package io.github.guegse.foreachstream.plugin;

import com.sun.source.tree.*;
import com.sun.source.util.Trees;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeMaker;
import com.sun.tools.javac.util.Names;

import javax.lang.model.element.Name;
import javax.tools.Diagnostic;
import java.util.*;
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
            "min",
            "max",
            "count",
            "average",
            "sum",
            "summaryStatistics",
            "anyMatch",
            "allMatch",
            "noneMatch",
            "findFirst",
            "findAny",
    };

    private static final String[] INTERMEDIATE_OPERATIONS = new String[] {
            "filter",
            "map",
            "mapToInt",
            "mapToLong",
            "mapToDouble",
            "mapToObj",
            "boxed",
            //"flatMap",
            //"flatMapToInt",
            //"flatMapToLong",
            //"flatMapToDouble",
            //"mapMulti",
            //"mapMultiToInt",
            //"mapMultiToLong",
            //"mapMultiToDouble",
            //"distinct",
            //"sorted",
            "peek",
            "limit",
            "skip",
            "takeWhile",
            "dropWhile",
    };
    private final TreeMaker treeMaker;
    private final Names names;
    private final Trees trees;
    private final Map<String, String> availableMethodsToTheirClasses;

    private final CompilationUnitTree compilationUnit;

    public TreeScanner(TreeMaker treeMaker, Names names, Trees trees, Map<String, String> availableMethodsToTheirClasses, CompilationUnitTree compilationUnit) {
        this.treeMaker = treeMaker;
        this.names = names;
        this.trees = trees;
        this.availableMethodsToTheirClasses = availableMethodsToTheirClasses;
        this.compilationUnit = compilationUnit;
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
                List<MethodInvocationTree> invocations = new ArrayList<>(5);
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
                        } else if (name.contentEquals("stream")) { // TODO: Detect other stream sources
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
                            .map(invocation -> ((MemberSelectTree) invocation.getMethodSelect()).getIdentifier().toString())
                            .collect(Collectors.joining("_"));
                    String methodToCall;
                    Name collectorMethodName = getCollectorMethod(methodName, node);
                    ExpressionTree terminalArgument = null;
                    if (collectorMethodName != null) {
                        methodToCall = methodToCallWithoutTerminalOp + "_collect_" + collectorMethodName;
                    } else {
                        methodToCall = methodToCallWithoutTerminalOp + "_" + methodName;
                        if (node.getArguments().size() == 1) {
                            // There is an argument to the terminal method (e.g. a Consumer for forEach)
                            terminalArgument = node.getArguments().get(0);
                        }
                    }

                    String containingClassName = availableMethodsToTheirClasses.get(methodToCall);
                    if (containingClassName == null) {
                        debugPrint(node, "method for this pattern not available: " + methodToCall);
                        return super.visitMethodInvocation(node, o);
                    }

                    // invocations[0] contains the stream() call
                    JCTree.JCMethodInvocation streamCall = (JCTree.JCMethodInvocation) invocations.get(0);
                    if (streamCall.getArguments().size() != 0
                            || !(memberSelectTree.getExpression() instanceof JCTree.JCExpression)) {
                        debugPrint(node, "unexpected number of arguments to stream(): " + streamCall);
                        return super.visitMethodInvocation(node, o);
                    }

                    JCTree.JCFieldAccess methodMemberSelect = createForeachStreamFieldAccess(methodToCall, containingClassName);
                    methodMemberSelect.pos = streamCall.pos;
                    List<JCTree.JCExpression> arguments = new ArrayList<>(invocations.size() + 1);
                    if (terminalArgument != null) {
                        arguments.add((JCTree.JCExpression) terminalArgument);
                    }
                    for (int i = invocations.size() - 1; i > 0; i--) {
                        MethodInvocationTree methodInvocationTree = invocations.get(i);
                        if (methodInvocationTree.getArguments().size() != 1
                                || !(methodInvocationTree.getArguments().get(0) instanceof JCTree.JCExpression)) {
                            debugPrint(node, "unexpected number of arguments to intermediate method: "
                                    + methodInvocationTree);
                            return super.visitMethodInvocation(node, o);
                        }
                        ExpressionTree argument = methodInvocationTree.getArguments().get(0);
                        arguments.add((JCTree.JCExpression) argument);
                    }
                    arguments.add((JCTree.JCExpression) ((MemberSelectTree) streamCall.getMethodSelect()).getExpression());
                    Collections.reverse(arguments);
                    com.sun.tools.javac.util.List<JCTree.JCExpression> args = com.sun.tools.javac.util.List.from(arguments);
                    JCTree.JCMethodInvocation original = (JCTree.JCMethodInvocation) node;
                    debugPrint(original, "replacing with a call to: " + methodToCall);
                    original.args = args;
                    original.meth = methodMemberSelect;
                }
            }
        }
        return super.visitMethodInvocation(node, o);
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

    private Name getCollectorMethod(Name methodName, MethodInvocationTree node) {
        if (!methodName.contentEquals("collect")) {
            return null;
        }

        if (node.getArguments().size() != 1) {
            return null;
        }

        ExpressionTree argument = node.getArguments().get(0);
        if (argument.getKind() == Tree.Kind.METHOD_INVOCATION) {
            MethodInvocationTree argumentMethodInvocation = (MethodInvocationTree) argument;
            if (argumentMethodInvocation.getMethodSelect().getKind() == Tree.Kind.MEMBER_SELECT) {
                MemberSelectTree memberSelectTree = (MemberSelectTree) argumentMethodInvocation.getMethodSelect();
                if (!memberSelectTree.getIdentifier().contentEquals("toList") &&
                        !memberSelectTree.getIdentifier().contentEquals("toSet")) {
                    return null;
                }
                if (memberSelectTree.getExpression().getKind() == Tree.Kind.IDENTIFIER) {
                    IdentifierTree identifierTree = (IdentifierTree) memberSelectTree.getExpression();
                    if (!identifierTree.getName().contentEquals("Collectors") &&
                            !identifierTree.getName().contentEquals("java.util.stream.Collectors")) {
                        return null;
                    }
                }
                return memberSelectTree.getIdentifier();
            } else if (argumentMethodInvocation.getMethodSelect().getKind() == Tree.Kind.IDENTIFIER) {
                // Maybe a static import of toList/toSet()? TODO: Check when scanning imports
                Name selectedMethodName = ((IdentifierTree) argumentMethodInvocation.getMethodSelect()).getName();
                if (!selectedMethodName.contentEquals("toList") && !selectedMethodName.contentEquals("toSet")) {
                    return null;
                }
                return selectedMethodName;
            }
        }

        return null;
    }

    private void debugPrint(Tree tree, String messagePrefix) {
        trees.printMessage(Diagnostic.Kind.NOTE, messagePrefix + "  " + tree.getKind() + " " + tree, tree, compilationUnit);
    }

    private void debugPrintWithTree(Tree tree, String messagePrefix) {
        debugPrint(tree, messagePrefix);
        tree.accept(new com.sun.source.util.TreeScanner<>() {
            private int depth = 2;

            @Override
            public Object scan(Tree tree, Object o) {
                if (tree == null) {
                    // Get here when scanning a variable declaration with missing type in a lambda
                    return null;
                }
                trees.printMessage(Diagnostic.Kind.NOTE,
                        messagePrefix + "  ".repeat(depth) + tree.getKind() + " " + tree, tree, compilationUnit);
                depth++;
                super.scan(tree, o);
                depth--;
                return null;
            }
        }, null);
    }
}
