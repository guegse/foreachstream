package io.github.guegse.foreachstream.generator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Generator {

    private static final int MAX_DEPTH = 4;

    private static final Operation stream = new io.github.guegse.foreachstream.generator.Stream();

    private static final IntermediateOperation[] INTERMEDIATE_OPS = {
            new MapOp(),
            new Filter(),
            new MapToIntOp(),
            new MapToLongOp(),
            new MapToDoubleOp(),
            new MapToObjOp(),
            new Boxed(),
            new Sorted(),
            new SortedComparator(),
            new Limit(),
            new Skip(),
            new Distinct(),
            new DropWhile(),
            new TakeWhile(),
            new FlatMapOpLambda(),
            new FlatMapOpMemberReference(),
    };

    private static final TerminalOperation[] TERMINAL_OPS = {
            new Foreach(),
            new Count(),
            new AnyMatch(),
            new AllMatch(),
            new NoneMatch(),
            new FindFirst(),
            new FindAny(),
            new Min(),
            new Max(),
            new Sum(),
            new CollectCollector(),
            new ToList()
    };

    public static void main(String[] args) throws FileNotFoundException {
        String dir = "plugin/src/main/java/io/github/guegse/foreachstream/";
        new File(dir).mkdirs();

        for (TerminalOperation terminalOp : TERMINAL_OPS) {
            String className = "ForeachStream" + terminalOp.getClass().getSimpleName();
            File file = Path.of(dir, className + ".java").toFile();
            Emitter out = new EmitterImpl(new FileOutputStream(file));
            out.println("package io.github.guegse.foreachstream;");
            out.println("");
            out.println("import java.util.*;");
            out.println("import java.util.function.*;");
            out.println("import java.util.stream.*;");
            out.println();
            out.println("public class " + className + " {");
            out.println("");

            for (int i = 0; i < MAX_DEPTH; i++) {
                emitMethods(out, List.of(), terminalOp, 0, i);
            }

            out.println("");
            out.println("}");
            out.close();
        }

        dir = dir + "plugin";
        new File(dir).mkdirs();

        File file = Path.of(dir, "ForeachStreamClasses.java").toFile();
        Emitter out = new EmitterImpl(new FileOutputStream(file));
        out.println("package io.github.guegse.foreachstream.plugin;");
        out.println("");
        out.println("import io.github.guegse.foreachstream.*;");
        out.println();
        out.println("public class ForeachStreamClasses {");
        out.increaseIndentation();
        out.printIndentation();
        out.println("public static final Class<?>[] CLASSES = new Class<?>[] {");
        out.increaseIndentation();
        for (TerminalOperation terminalOperation : TERMINAL_OPS) {
            out.printIndentation();
            out.println("ForeachStream" + terminalOperation.getClass().getSimpleName() + ".class,");
        }
        out.decreaseIndentation();
        out.printIndentation();
        out.println("};");
        out.decreaseIndentation();
        out.println("}");
        out.close();
    }

    private static void emitMethods(Emitter out, List<IntermediateOperation> previousIntermediateOps, TerminalOperation terminalOperation, int depth, int targetDepth) {
        if (depth == targetDepth) {
            try {
                Emitter sub = out.subEmitter();
                emitMethod(sub, terminalOperation, previousIntermediateOps);
                sub.close();
            } catch (UnsupportedOperationException e) {
                System.out.println("Unsupported for " + previousIntermediateOps + "/" + terminalOperation + ": " + e.getMessage());
            }
            return;
        }

        for (IntermediateOperation op : INTERMEDIATE_OPS) {
            emitMethods(out, Stream.concat(previousIntermediateOps.stream(), Stream.of(op)).collect(Collectors.toList()), terminalOperation, depth + 1, targetDepth);
        }
    }

    private record OperationInstance(Operation operation, String sourceType, String targetType, List<String> argumentNames,
                                     String streamElement) {
    }

    private static void emitMethod(Emitter out, TerminalOperation terminalOperation, List<IntermediateOperation> intermediateOperations) {
        out.printIndentation();
        out.print("public static ");
        List<OperationInstance> operationInstances = getOperationInstances(intermediateOperations, terminalOperation);
        String returnType = operationInstances.get(operationInstances.size() - 1).targetType;
        emitTypeParameterList(out, operationInstances);
        out.print(" ");
        out.print(returnType);
        out.print(" ");
        emitMethodName(out, operationInstances);
        out.print("(");
        emitArgumentDeclarations(out, operationInstances);
        out.print(") ");
        out.println("{");
        out.increaseIndentation();

        String sizeEstimate = "input.size()";
        if (intermediateOperations.stream().anyMatch(IntermediateOperation::isFilter)) {
            sizeEstimate = "";
        }

        for (OperationInstance operationInstance : operationInstances) {
            Operation operation = operationInstance.operation;
            operation.emitPreamble(out, operationInstance.sourceType, operationInstance.argumentNames, sizeEstimate);
        }

        for (int i = 0; i < operationInstances.size(); i++) {
            OperationInstance operationInstance = operationInstances.get(i);
            String targetElement = i + 1 < operationInstances.size()
                    ? operationInstances.get(i + 1).streamElement
                    : null;
            Operation operation = operationInstance.operation;
            operation.emitOperation(out, operationInstance.sourceType, operationInstance.argumentNames, operationInstance.streamElement, operationInstance.targetType, targetElement);
        }

        for (OperationInstance operationInstance : operationInstances) {
            Operation operation = operationInstance.operation;
            operation.emitPostamble(out, operationInstance.sourceType, operationInstance.argumentNames);
        }

        out.decreaseIndentation();
        out.printIndentation();
        out.println("}");
        out.println();
    }

    private static void emitTypeParameterList(Emitter out, List<OperationInstance> operationInstances) {
        List<OperationInstance> uniqueInstances = new ArrayList<>();
        uniqueInstances.add(operationInstances.get(0));
        for(int i = 1; i < operationInstances.size() - 1; i++) {
            if(!operationInstances.get(i).targetType.equals(operationInstances.get(i - 1).targetType)) {
                uniqueInstances.add(operationInstances.get(i));
            }
        }

        List<String> types = new ArrayList<>();

        OperationInstance terminalInstance = operationInstances.get(operationInstances.size() - 1);
        if(terminalInstance.operation instanceof CollectCollector collector) {
            String[] argumentTypes = collector.getArgumentTypes(terminalInstance.sourceType, terminalInstance.targetType).get(0).split("[,<>]");
            types.add(argumentTypes[argumentTypes.length - 2].trim()); // add type of accumulator
            types.add(argumentTypes[argumentTypes.length - 1].trim()); // add type of combiner
        }

        OperationInstance prev = null;
        for(int i = uniqueInstances.size() - 1; i >= 0; i--) {
            OperationInstance op = uniqueInstances.get(i);
            if (!"int".equals(op.targetType)
                    && !"long".equals(op.targetType)
                    && !"double".equals(op.targetType)
                    && !"Integer".equals(op.targetType)
                    && !"Long".equals(op.targetType)
                    && !"Double".equals(op.targetType)) {
                String targetType = op.targetType;
                if(prev != null && prev.operation.appendPreviousTargetType(prev.targetType) != null) {
                    targetType = targetType + " " + prev.operation.appendPreviousTargetType(prev.targetType);
                }
                types.add(targetType);
                prev = op;
            }
        }
        Collections.reverse(types);

        out.print(types.stream().collect(Collectors.joining(", ", "<", ">")));
    }

    private static void emitMethodName(Emitter out, List<OperationInstance> operationInstances) {
        out.print(operationInstances.stream().map(instance -> instance.operation.getName()).collect(Collectors.joining("_")));
    }

    private static List<String> createArgumentNames(int numberOfArguments, int index) {
        if(numberOfArguments <= 0) return null;
        List<String> argumentNames = new ArrayList<>();
        for(int i = 0; i < numberOfArguments; i++) {
            argumentNames.add("arg" + index++);
        }
        return argumentNames;
    }

    private static List<OperationInstance> getOperationInstances(List<IntermediateOperation> intermediateOperations, TerminalOperation terminalOperation) {
        List<OperationInstance> operationInstances = new ArrayList<>();
        String currentType = "T0";
        int typeCount = 0;
        int argumentIndex = 0;
        String currentStreamElement = "t0";
        List<String> argumentTypes;
        String targetType;
        operationInstances.add(new OperationInstance(stream, currentType, stream.getTargetType(currentType, "T" + typeCount), List.of("input"), currentStreamElement));
        typeCount++;
        for (IntermediateOperation operation : intermediateOperations) {
            targetType = operation.getTargetType(currentType, "T" + typeCount);
            argumentTypes = operation.getArgumentTypes(currentType, targetType);
            operationInstances.add(new OperationInstance(operation, currentType, targetType, createArgumentNames(argumentTypes == null ? 0 : argumentTypes.size(), argumentIndex), currentStreamElement));
            argumentIndex += argumentTypes == null ? 0 : argumentTypes.size();
            if (!targetType.equals(currentType)) {
                currentStreamElement = "t" + typeCount;
                typeCount++;
                currentType = targetType;
            }
        }
        targetType = terminalOperation.getTargetType(currentType, null);
        argumentTypes = terminalOperation.getArgumentTypes(currentType, targetType);
        operationInstances.add(new OperationInstance(terminalOperation, currentType, targetType, createArgumentNames(argumentTypes == null ? 0 : argumentTypes.size(), argumentIndex), currentStreamElement));
        return operationInstances;
    }

    private static void emitArgumentDeclarations(Emitter out, List<OperationInstance> operationInstances) {
        String argumentDeclarations = operationInstances.stream()
                .filter(op -> op.operation.getArgumentTypes(op.sourceType, op.targetType) != null)
                .map(Generator::getArgumentDeclaration)
                .collect(Collectors.joining(", "));
        out.print(argumentDeclarations);
    }

    private static String getArgumentDeclaration(OperationInstance operationInstance) {
        if(operationInstance.argumentNames == null) return null;
        StringBuilder argumentDecl = new StringBuilder();
        List<String> types = operationInstance.operation.getArgumentTypes(operationInstance.sourceType, operationInstance.targetType);
        for(int i = 0; i < operationInstance.argumentNames.size(); i++) {
            argumentDecl.append(types.get(i)).append(" ").append(operationInstance.argumentNames.get(i));
        }
        return argumentDecl.toString();
    }

}

