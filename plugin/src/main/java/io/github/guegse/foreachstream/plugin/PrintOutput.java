package io.github.guegse.foreachstream.plugin;

import com.sun.source.tree.CompilationUnitTree;
import com.sun.source.tree.Tree;
import com.sun.source.util.Trees;

import javax.tools.Diagnostic;

public class PrintOutput {
    private final CompilationUnitTree compilationUnit;
    private final Trees trees;
    private final boolean printDebug;
    private final boolean printStatistics;

    public PrintOutput(CompilationUnitTree compilationUnit, Trees trees, boolean printDebug, boolean printStatistics) {
        this.compilationUnit = compilationUnit;
        this.trees = trees;
        this.printDebug = printDebug;
        this.printStatistics = printStatistics;
    }

    public void debugPrint(Tree tree, String messagePrefix) {
        if(!printDebug) return;
        trees.printMessage(Diagnostic.Kind.NOTE, messagePrefix + "  " + tree.getKind() + " " + tree, tree, compilationUnit);
    }

    public void debugPrintWithTree(Tree tree, String messagePrefix) {
        if(!printDebug) return;
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
