package io.github.guegse.foreachstream.plugin;

import com.sun.source.tree.*;
import com.sun.source.util.Trees;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeMaker;

import javax.tools.Diagnostic;
import java.util.ArrayList;
import java.util.List;

public class Substitution {
    private final JCTree.JCBlock staticBlock;
    private final List<Entry> entries;
    private final TreeMaker treeMaker;
    private final Trees trees;
    private final CompilationUnitTree compilationUnit;

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

    public Substitution(TreeMaker treeMaker, Trees trees, CompilationUnitTree compilationUnit) {
        entries = new ArrayList<>();
        this.treeMaker = treeMaker;
        staticBlock = treeMaker.Block(0, com.sun.tools.javac.util.List.nil());
        this.trees = trees;
        this.compilationUnit = compilationUnit;
    }

    public JCTree.JCBlock getStaticBlock() {
        return staticBlock;
    }

    public void add(JCTree.JCMethodInvocation original, JCTree.JCMethodInvocation sub, JCTree.JCMethodInvocation streamCall, List<JCTree.JCExpression> arguments) {
        entries.add(new Entry(original, sub, streamCall, arguments));
        staticBlock.stats = staticBlock.stats.append(treeMaker.Exec(sub));
    }

    public void substitute() {
        for(var entry : entries) {
            trees.printMessage(Diagnostic.Kind.NOTE, entry.streamCall.type.toString(), compilationUnit, compilationUnit);
            if(!entry.streamCall.type.toString().startsWith("java.util.stream.Stream"))
                continue;
            entry.original.args = com.sun.tools.javac.util.List.from(entry.arguments);
            entry.original.meth = entry.sub.meth;
            trees.printMessage(Diagnostic.Kind.NOTE, entry.original.toString(), compilationUnit, compilationUnit);
        }
        staticBlock.stats = com.sun.tools.javac.util.List.nil();
    }
}