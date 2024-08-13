package io.github.guegse.foreachstream.plugin;

import com.sun.source.tree.*;
import com.sun.tools.javac.code.Symbol;
import com.sun.tools.javac.code.Type;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.JCTree.*;

public class ASTHelpers {
    public static Symbol getDeclaredSymbol(Tree tree) {
        if (tree instanceof PackageTree) {
            return getSymbol((PackageTree) tree);
        }
        if (tree instanceof TypeParameterTree) {
            Type type = ((JCTree.JCTypeParameter) tree).type;
            return type == null ? null : type.tsym;
        }
        if (tree instanceof ClassTree) {
            return getSymbol((ClassTree) tree);
        }
        if (tree instanceof MethodTree) {
            return getSymbol((MethodTree) tree);
        }
        if (tree instanceof VariableTree) {
            return getSymbol((VariableTree) tree);
        }
        return null;
    }

    public static Type getReturnType(ExpressionTree expressionTree) {
        if (expressionTree instanceof JCFieldAccess methodCall) {
            if(methodCall.type == null) return null;
            return methodCall.type.getReturnType();
        } else if (expressionTree instanceof JCIdent methodCall) {
            if(methodCall.type == null) return null;
            return methodCall.type.getReturnType();
        } else if (expressionTree instanceof JCMethodInvocation) {
            return getReturnType(((JCMethodInvocation) expressionTree).getMethodSelect());
        } else if (expressionTree instanceof JCMemberReference) {
            return ((JCMemberReference) expressionTree).sym.type.getReturnType();
        }
        throw new IllegalArgumentException("Expected a JCFieldAccess or JCIdent");
    }

    public static Symbol getSymbol(Tree tree) {
        if (tree instanceof AnnotationTree) {
            return getSymbol(((AnnotationTree) tree).getAnnotationType());
        }
        if (tree instanceof JCTree.JCFieldAccess) {
            return ((JCTree.JCFieldAccess) tree).sym;
        }
        if (tree instanceof JCTree.JCIdent) {
            return ((JCTree.JCIdent) tree).sym;
        }
        if (tree instanceof JCTree.JCMethodInvocation) {
            return getSymbol((MethodInvocationTree) tree);
        }
        if (tree instanceof JCTree.JCNewClass) {
            return getSymbol((NewClassTree) tree);
        }
        if (tree instanceof MemberReferenceTree) {
            return getSymbol((MemberReferenceTree) tree);
        }
        if (tree instanceof JCTree.JCAnnotatedType) {
            return getSymbol(((JCTree.JCAnnotatedType) tree).underlyingType);
        }
        if (tree instanceof ParameterizedTypeTree) {
            return getSymbol(((ParameterizedTypeTree) tree).getType());
        }
        if (tree instanceof ClassTree) {
            return getSymbol((ClassTree) tree);
        }

        return getDeclaredSymbol(tree);
    }

    public static Symbol.ClassSymbol getSymbol(ClassTree tree) {
        return ((JCTree.JCClassDecl) tree).sym;
    }

    public static Symbol.PackageSymbol getSymbol(PackageTree tree) {
        return ((JCTree.JCPackageDecl) tree).packge;
    }

    public static Symbol.MethodSymbol getSymbol(MethodTree tree) {
        return ((JCMethodDecl) tree).sym;
    }

    public static Symbol.MethodSymbol getSymbol(NewClassTree tree) {
        Symbol sym = ((JCTree.JCNewClass) tree).constructor;
        if (!(sym instanceof Symbol.MethodSymbol)) {
            // Defensive. Would only occur if there are errors in the AST.
            throw new IllegalArgumentException(tree.toString());
        }
        return (Symbol.MethodSymbol) sym;
    }

    public static Symbol.VarSymbol getSymbol(VariableTree tree) {
        return ((JCTree.JCVariableDecl) tree).sym;
    }

    public static Symbol.MethodSymbol getSymbol(MethodInvocationTree tree) {
        Symbol sym = ASTHelpers.getSymbol(tree.getMethodSelect());
        if (!(sym instanceof Symbol.MethodSymbol)) {
            System.out.println("Method invocation symbol is not a method symbol:");
            // Defensive. Would only occur if there are errors in the AST.
            //throw new IllegalArgumentException(tree.toString());
            return null;
        }
        return (Symbol.MethodSymbol) sym.baseSymbol();
    }

    public static Symbol.MethodSymbol getSymbol(MemberReferenceTree tree) {
        Symbol sym = ((JCTree.JCMemberReference) tree).sym;
        if (!(sym instanceof Symbol.MethodSymbol)) {
            // Defensive. Would only occur if there are errors in the AST.
            throw new IllegalArgumentException(tree.toString());
        }
        return (Symbol.MethodSymbol) sym.baseSymbol();
    }

}
