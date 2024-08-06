package io.github.guegse.foreachstream.plugin;

import com.google.auto.service.AutoService;
import com.sun.source.tree.CompilationUnitTree;
import com.sun.source.util.*;
import com.sun.tools.javac.api.BasicJavacTask;
import com.sun.tools.javac.tree.TreeMaker;
import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.Names;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

@AutoService(Plugin.class)
public class ForeachStreamPlugin implements Plugin, TaskListener {

    private TreeMaker treeMaker;
    private Names names;
    private Trees trees;
    private Context javacContext;
    private Map<String, String> availableMethodsToTheirClasses;
    private Map<CompilationUnitTree, Substitution> subs;

    @Override
    public String getName() {
        return "ForeachStream";
    }

    @Override
    public boolean autoStart() {
        return true;
    }

    @Override
    public void init(JavacTask task, String... args) {
        javacContext = ((BasicJavacTask) task).getContext();
        treeMaker = TreeMaker.instance(javacContext);
        names = Names.instance(javacContext);
        trees = Trees.instance(task);
        task.addTaskListener(this);
        subs = new HashMap<>();
        availableMethodsToTheirClasses = new HashMap<>();
        for (Class<?> clazz : ForeachStreamClasses.CLASSES) {
            for (Method method : clazz.getMethods()) {
                if (Modifier.isPublic(method.getModifiers()) && Modifier.isStatic(method.getModifiers())) {
                    availableMethodsToTheirClasses.put(method.getName(), clazz.getName());
                }
            }
        }
    }

    @Override
    public void finished(TaskEvent e) {
        if (e.getKind() == TaskEvent.Kind.PARSE) {
            CompilationUnitTree compilationUnit = e.getCompilationUnit();
            Substitution sub = new Substitution(treeMaker, trees, compilationUnit);
            subs.put(compilationUnit, sub);
            e.getCompilationUnit().accept(
                    new TreeScanner(treeMaker, names, trees, availableMethodsToTheirClasses, compilationUnit, sub), null);
        } else if(e.getKind() == TaskEvent.Kind.ANALYZE) {
            Substitution sub = subs.get(e.getCompilationUnit());
            if(sub != null) {
                sub.substitute();
            }
        }
    }

}