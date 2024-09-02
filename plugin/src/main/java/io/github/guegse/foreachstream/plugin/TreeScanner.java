package io.github.guegse.foreachstream.plugin;

import com.sun.source.tree.*;
import com.sun.tools.javac.code.Flags;
import com.sun.tools.javac.code.TypeTag;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeMaker;
import com.sun.tools.javac.util.Names;
import com.sun.tools.javac.util.Pair;

import javax.lang.model.element.Name;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class TreeScanner extends com.sun.source.util.TreeScanner<Void, Void> {
    private static final String[] TERMINAL_OPERATIONS = new String[] {
            "toSet",
            "toList",
            "collect",
            "forEach",
            "forEachOrdered",
            "toArray",
            "reduce",
            "anyMatch",
            "allMatch",
            "noneMatch",
            "findFirst",
            "findAny",
            "min",
            "max",
            "average",
            "sum",
            "summaryStatistics",
            "count",
    };

    private static final String[] INTERMEDIATE_OPERATIONS = new String[] {
            "filter",
            "map",
            "mapToInt",
            "mapToLong",
            "mapToDouble",
            "mapToObj",
            "boxed",
            "flatMap",
            "flatMapToInt",
            "flatMapToLong",
            "flatMapToDouble",
            "mapMulti",
            "mapMultiToInt",
            "mapMultiToLong",
            "mapMultiToDouble",
            "distinct",
            "sorted",
            "peek",
            "limit",
            "skip",
            "takeWhile",
            "dropWhile",
    };

    private final TreeMaker treeMaker;
    private final Names names;
    private final Map<String, Pair<String, Class<?>[]>>  availableMethodsToTheirClasses;
    private final Substitution subs;
    private final DebugOutput debugOutput;
    private final Statistics statistics;

    public TreeScanner(TreeMaker treeMaker, Names names, Map<String, Pair<String, Class<?>[]>>  availableMethodsToTheirClasses, Substitution subs, DebugOutput debugOutput, Statistics statistics) {
        this.treeMaker = treeMaker;
        this.names = names;
        this.availableMethodsToTheirClasses = availableMethodsToTheirClasses;
        this.subs = subs;
        this.debugOutput = debugOutput;
        this.statistics = statistics;
    }

    @Override
    public Void visitClass(ClassTree node, Void o) {
        // Add anonymous static block to class
        JCTree.JCClassDecl classDecl = (JCTree.JCClassDecl) node;
        classDecl.defs = classDecl.defs.prepend(subs.getStaticBlock());
        return super.visitClass(node, o);
    }

    @Override
    public Void visitMethodInvocation(MethodInvocationTree node, Void o) {
        if (node.getMethodSelect().getKind() == Tree.Kind.MEMBER_SELECT) {
            MemberSelectTree memberSelectTree = (MemberSelectTree) node.getMethodSelect();
            Name methodName = memberSelectTree.getIdentifier();
            if (isTerminalMethod(methodName)) {
                // Now take the expression of the MemberSelectTree and scan it until we find a stream() method invocation
                ExpressionTree expression = memberSelectTree.getExpression();
                boolean canReplace = true;
                java.util.List<MethodInvocationTree> invocations = new ArrayList<>(5);
                for (; ; ) {
                    if (expression.getKind() != Tree.Kind.METHOD_INVOCATION) {
                        canReplace = false;
                        break;
                    }
                    MethodInvocationTree methodInvocationTree = (MethodInvocationTree) expression;
                    if (methodInvocationTree.getMethodSelect().getKind() == Tree.Kind.MEMBER_SELECT) {
                        memberSelectTree = (MemberSelectTree) methodInvocationTree.getMethodSelect();
                        expression = memberSelectTree.getExpression();
                        Name name = memberSelectTree.getIdentifier();
                        if (isIntermediateMethod(name)) {
                            invocations.add(methodInvocationTree);
                        } else if (name.contentEquals("stream")) {
                            invocations.add(methodInvocationTree);
                            break;
                        } else {
                            canReplace = false;
                            break;
                        }
                    } else {
                        canReplace = false;
                        break;
                    }
                }

                if (canReplace) {
                    Collections.reverse(invocations);
                    String methodToCallWithoutTerminalOp = invocations.stream()
                            .map(invocation -> mapMethodName(((MemberSelectTree) invocation.getMethodSelect()).getIdentifier().toString(), invocation))
                            .collect(Collectors.joining("_"));

                    String terminalOperation = mapMethodName(methodName.toString(), node);
                    String methodToCall = methodToCallWithoutTerminalOp + "_" + terminalOperation;;
                    var containingClass = availableMethodsToTheirClasses.get(methodToCall);
                    if (containingClass == null || node.getArguments().size() > 1) {
                        debugOutput.printDebug(node, "method for this pattern not available: " + methodToCall);
                        if(statistics != null) {
                            statistics.substitutionFailed(methodToCall);
                        }
                        return super.visitMethodInvocation(node, o);
                    }

                    ExpressionTree terminalArgument = null;
                    if (!node.getArguments().isEmpty()) {
                        // There is an argument to the terminal method (e.g. a Consumer for forEach)
                        terminalArgument = node.getArguments().get(0);
                    }

                    // invocations[0] contains the stream() call
                    JCTree.JCMethodInvocation streamCall = (JCTree.JCMethodInvocation) invocations.get(0);
                    if (streamCall.getArguments().size() != 0
                            || !(memberSelectTree.getExpression() instanceof JCTree.JCExpression)) {
                        debugOutput.printDebug(node, "unexpected number of arguments to stream(): " + streamCall);
                        return super.visitMethodInvocation(node, o);
                    }

                    JCTree.JCFieldAccess methodMemberSelect = createForeachStreamFieldAccess(methodToCall, containingClass.fst);
                    methodMemberSelect.pos = streamCall.pos;

                    java.util.List<Pair<JCTree.JCExpression, String>> arguments = new ArrayList<>(invocations.size() + 1);
                    if (terminalArgument != null) {
                        arguments.add(new Pair<>((JCTree.JCExpression) terminalArgument, terminalOperation));
                    }
                    for (int i = invocations.size() - 1; i > 0; i--) {
                        MethodInvocationTree methodInvocationTree = invocations.get(i);
                        if (methodInvocationTree.getArguments().size() > 1){
                            debugOutput.printDebug(node, "unexpected number of arguments to intermediate method: "
                                    + methodInvocationTree);
                            return super.visitMethodInvocation(node, o);
                        } else if(methodInvocationTree.getArguments().size() == 1
                                && methodInvocationTree.getArguments().get(0) instanceof JCTree.JCExpression) {
                            ExpressionTree argument = methodInvocationTree.getArguments().get(0);
                            arguments.add(new Pair<>((JCTree.JCExpression) argument, ((MemberSelectTree) methodInvocationTree.getMethodSelect()).getIdentifier().toString()));
                        }
                    }
                    arguments.add(new Pair<>((JCTree.JCExpression) ((MemberSelectTree) streamCall.getMethodSelect()).getExpression(), "stream"));
                    Collections.reverse(arguments);

                    // create a list with empty arguments
                    com.sun.tools.javac.util.List<JCTree.JCExpression> args = com.sun.tools.javac.util.List.nil();
                    for(int i = 0; i < containingClass.snd.length; i++)  {
                        if(containingClass.snd[i].isPrimitive()) {
                            args = args.append(treeMaker.Literal(TypeTag.LONG, 0));
                        } else {
                            args = args.append(treeMaker.Literal(TypeTag.BOT, null));
                        }
                    }

                    JCTree.JCMethodInvocation original = (JCTree.JCMethodInvocation) node;
                    // create the new method invocation
                    JCTree.JCMethodInvocation sub = treeMaker.Apply(
                            com.sun.tools.javac.util.List.nil(),
                            methodMemberSelect,
                            args
                    );
                    subs.add(original, sub, streamCall, arguments);
                }
            }
        }
        return super.visitMethodInvocation(node, o);
    }

    private String mapMethodName(String method, MethodInvocationTree node) {
        if(method.equals("collect") && node.getArguments().size() == 1) {
            return "collectCollector";
        } else if(method.equals("sorted") && node.getArguments().size() == 1) {
            return "sortedComp";
        } else if(method.equals("flatMap") && node.getArguments().size() == 1 && node.getArguments().get(0) instanceof JCTree.JCLambda) {
            return "flatMapLambda";
        } else if(method.equals("flatMap") && node.getArguments().size() == 1 && node.getArguments().get(0) instanceof JCTree.JCMemberReference) {
            return "flatMapMemberReference";
        } else {
            return method;
        }
    }

    private boolean isIntermediateMethod(Name methodName) {
        for (String intermediateOperation : INTERMEDIATE_OPERATIONS) {
            if (methodName.contentEquals(intermediateOperation)) {
                return true;
            }
        }
        return false;
    }

    private boolean isTerminalMethod(Name methodName) {
        for (String terminalOperation : TERMINAL_OPERATIONS) {
            if (methodName.contentEquals(terminalOperation)) {
                return true;
            }
        }
        return false;
    }

    // Creates the MemberSelect to ForeachStream.<methodName>
    private JCTree.JCFieldAccess createForeachStreamFieldAccess(String methodName, String className) {
        String[] identifiers = className.split("\\.");
        JCTree.JCFieldAccess field = treeMaker.Select(
                treeMaker.Ident(names.fromString(identifiers[0])),
                names.fromString(identifiers[1]));

        for (int i = 2; i < identifiers.length; i++) {
            field = treeMaker.Select(field, names.fromString(identifiers[i]));
        }
        field = treeMaker.Select(field, names.fromString(methodName));
        return field;
    }
}