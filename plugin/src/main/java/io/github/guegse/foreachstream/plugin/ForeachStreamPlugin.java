package io.github.guegse.foreachstream.plugin;

import com.google.auto.service.AutoService;
import com.sun.source.tree.CompilationUnitTree;
import com.sun.source.util.*;
import com.sun.tools.javac.api.BasicJavacTask;
import com.sun.tools.javac.tree.TreeMaker;
import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.Log;
import com.sun.tools.javac.util.Names;
import com.sun.tools.javac.util.Options;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

@AutoService(Plugin.class)
public class ForeachStreamPlugin implements Plugin, TaskListener {

    private Log log;
    private TreeMaker treeMaker;
    private Names names;
    private Trees trees;
    private Map<String, String> availableMethodsToTheirClasses;
    private Map<CompilationUnitTree, Substitution> subs;
    private Statistics statistics;
    private Options options;
    private String rootProjectPath;
    private String projectPath;
    private String taskName;

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
        Context javacContext = ((BasicJavacTask) task).getContext();
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
        this.log = Log.instance(javacContext);
        options = Options.instance(javacContext);
        this.statistics = new Statistics();
        for(var option : options.keySet()) {
            if(option.startsWith("-ArootProjectPath=")) {
                this.rootProjectPath = option.substring(option.indexOf("=") + 1);
            } else if(option.startsWith("-AprojectPath")) {
                this.projectPath = option.substring(option.indexOf("=") + 1);
            } else if(option.startsWith("-AtaskName")) {
                this.taskName = option.substring(option.indexOf("=") + 1);
            }
        }
    }

    @Override
    public void finished(TaskEvent e) {
        DebugOutput debugOutput = new DebugOutput(e.getCompilationUnit(), trees, true);
        if (e.getKind() == TaskEvent.Kind.PARSE) {
            CompilationUnitTree compilationUnit = e.getCompilationUnit();
            Substitution sub = new Substitution(treeMaker, debugOutput, statistics);
            subs.put(compilationUnit, sub);
            e.getCompilationUnit().accept(
                    new TreeScanner(treeMaker, names, availableMethodsToTheirClasses, sub, debugOutput, statistics), null);
        } else if(e.getKind() == TaskEvent.Kind.ANALYZE) {
            Substitution sub = subs.get(e.getCompilationUnit());
            if(sub != null) {
                sub.substitute();
            }
        } else if(e.getKind() == TaskEvent.Kind.COMPILATION) {
            if(statistics != null) {
                log.printRawLines(Log.WriterKind.NOTICE, statistics.printStatistics());
            }
            if(rootProjectPath != null && projectPath != null && taskName != null) {
                statistics.writeToFile(rootProjectPath, projectPath, taskName);
            }
        }
    }

}