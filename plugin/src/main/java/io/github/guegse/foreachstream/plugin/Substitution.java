package io.github.guegse.foreachstream.plugin;

import com.sun.tools.javac.code.Type;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeMaker;

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
        public List<JCTree.JCExpression> arguments;

        public Entry(JCTree.JCMethodInvocation original, JCTree.JCMethodInvocation sub, JCTree.JCMethodInvocation streamCall, List<JCTree.JCExpression> arguments) {
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

    public void add(JCTree.JCMethodInvocation original, JCTree.JCMethodInvocation sub, JCTree.JCMethodInvocation streamCall, List<JCTree.JCExpression> arguments) {
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

    public void substitute() {
        for(var entry : entries) {
            Type streamType = getReturnType(entry.streamCall);
            Type callerType = getReturnType(entry.arguments.get(0));
            if(streamType == null || !streamType.toString().startsWith("java.util.stream.Stream") || !isCollection(callerType)) {
                if(statistics != null) {
                    statistics.typeMismatch();
                }
                continue;
            }
            debugOutput.printDebug(entry.original, "replacing with: " + entry.sub.getMethodSelect());
            entry.original.args = com.sun.tools.javac.util.List.from(entry.arguments);
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
