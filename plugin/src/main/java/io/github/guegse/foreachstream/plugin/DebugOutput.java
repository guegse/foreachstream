package io.github.guegse.foreachstream.plugin;

import com.sun.source.tree.CompilationUnitTree;
import com.sun.source.tree.Tree;
import com.sun.source.util.Trees;

import javax.tools.Diagnostic;

public class DebugOutput {
    private final CompilationUnitTree compilationUnit;
    private final Trees trees;
    private final boolean printDebug;

    public DebugOutput(CompilationUnitTree compilationUnit, Trees trees, boolean printDebug) {
        this.compilationUnit = compilationUnit;
        this.trees = trees;
        this.printDebug = printDebug;
    }

    public void printDebug(Tree tree, String messagePrefix) {
        if(!printDebug) return;
        trees.printMessage(Diagnostic.Kind.NOTE, messagePrefix + "  " + tree.getKind() + " " + tree, tree, compilationUnit);
    }

    public void printDebugWithTree(Tree tree, String messagePrefix) {
        if(!printDebug) return;
        printDebug(tree, messagePrefix);
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
