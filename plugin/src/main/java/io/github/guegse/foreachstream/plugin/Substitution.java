package io.github.guegse.foreachstream.plugin;

import com.sun.tools.javac.code.Type;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeMaker;
import com.sun.tools.javac.util.Pair;

import java.util.ArrayList;
import java.util.List;

import static io.github.guegse.foreachstream.plugin.ASTHelpers.getReturnType;

public class Substitution {
    private final JCTree.JCBlock staticBlock;
    private final List<Entry> entries;
    private final TreeMaker treeMaker;
    private final DebugOutput debugOutput;
    private final Statistics statistics;

    private static class Entry {
        public JCTree.JCMethodInvocation original;
        public JCTree.JCMethodInvocation sub;
        public JCTree.JCMethodInvocation streamCall;
        public List<Pair<JCTree.JCExpression, String>> arguments;

        public Entry(JCTree.JCMethodInvocation original, JCTree.JCMethodInvocation sub, JCTree.JCMethodInvocation streamCall, List<Pair<JCTree.JCExpression, String>> arguments) {
            this.original = original;
            this.sub = sub;
            this.arguments = arguments;
            this.streamCall = streamCall;
        }
    }

    public Substitution(TreeMaker treeMaker, DebugOutput debugOutput, Statistics statistics) {
        entries = new ArrayList<>();
        this.treeMaker = treeMaker;
        staticBlock = treeMaker.Block(0, com.sun.tools.javac.util.List.nil());
        this.debugOutput = debugOutput;
        this.statistics = statistics;
    }

    public JCTree.JCBlock getStaticBlock() {
        return staticBlock;
    }

    public void add(JCTree.JCMethodInvocation original, JCTree.JCMethodInvocation sub, JCTree.JCMethodInvocation streamCall, List<Pair<JCTree.JCExpression, String>> arguments) {
        entries.add(new Entry(original, sub, streamCall, arguments));
        staticBlock.stats = staticBlock.stats.append(treeMaker.Exec(sub));
    }

    private boolean isCollection(Type type) {
        if(type instanceof Type.ClassType classType) {
            if(classType.tsym.getQualifiedName().toString().equals("java.util.Collection")) {
                return true;
            }
            if(classType.interfaces_field != null) {
                for(Type iface : classType.interfaces_field) {
                    if(isCollection(iface))
                        return true;
                }
            }
            return isCollection(classType.supertype_field);
        }
        return false;
    }

    private boolean isStream(Type type) {
        return type.tsym.getQualifiedName().toString().equals("java.util.stream.Stream");
    }

    private boolean transformFlatMapArgument(JCTree.JCExpression arg) {
        if(arg instanceof JCTree.JCLambda lambda
                && lambda.body instanceof JCTree.JCMethodInvocation invocation
                && invocation.meth instanceof JCTree.JCFieldAccess fieldAccess
                && fieldAccess.sym.toString().equals("stream()")
                && isStream(lambda.body.type)
                && isCollection(fieldAccess.selected.type)) {
            lambda.body = fieldAccess.selected;
            Type.ClassType classType = (Type.ClassType) lambda.type;
            com.sun.tools.javac.util.List<Type> newTypeParams = com.sun.tools.javac.util.List.from(classType.getTypeArguments().subList(0, 1));
            newTypeParams = newTypeParams.append(fieldAccess.selected.type);
            var newclassType =  new Type.ClassType(classType.getEnclosingType(), newTypeParams, classType.tsym);
            lambda.setType(newclassType);
            lambda.target = newclassType;
            return true;
        }
        return false;
    }

    public void substitute() {
        for(var entry : entries) {
            Type streamType = getReturnType(entry.streamCall);
            Type callerType = getReturnType(entry.arguments.get(0).fst);
            if(streamType == null
                    || !isStream(streamType)
                    || !isCollection(callerType)
                    || !entry.arguments.stream()
                                    .filter(operation -> operation.snd.equals("flatMap"))
                                    .allMatch(operation -> transformFlatMapArgument(operation.fst))) {
                if(statistics != null) {
                    statistics.typeMismatch();
                }
                continue;
            }
            debugOutput.printDebug(entry.original, "replacing with: " + entry.sub.getMethodSelect());
            entry.original.args = com.sun.tools.javac.util.List.from(entry.arguments.stream().map(arg -> arg.fst).toList());
            entry.original.meth = entry.sub.meth;

            if(statistics != null) {
                String subMethod = entry.original.getMethodSelect().toString();
                int streamIndex = subMethod.indexOf("stream_");
                statistics.substituted(subMethod.substring(streamIndex));
            }
        }
        staticBlock.stats = com.sun.tools.javac.util.List.nil();
    }
}
