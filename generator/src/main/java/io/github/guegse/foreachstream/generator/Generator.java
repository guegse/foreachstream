package io.github.guegse.foreachstream.generator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Generator {

    private static final int MAX_DEPTH = 4;


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
            new DropWhile()
            //new FlatMapOp(),
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
            new CollectCollector()
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

    private record OperationInstance(Operation operation, String sourceType, String targetType, String argumentName,
                                     String streamElement) {
    }

    private static void emitMethod(Emitter out, TerminalOperation terminalOperation, List<IntermediateOperation> intermediateOperations) {
        out.printIndentation();
        out.print("public static ");
        List<OperationInstance> operationInstances = getOperationInstances(intermediateOperations, terminalOperation);
        String returnType = operationInstances.get(operationInstances.size() - 1).targetType;
        OperationInstance terminalInstance = operationInstances.get(operationInstances.size() - 1);
        emitTypeParameterList(out, operationInstances);
        out.print(" ");
        out.print(returnType);
        emitMethodName(out, terminalOperation, intermediateOperations);
        out.print("(");
        out.print("Collection<T0> input");
        if (intermediateOperations.stream().anyMatch(Operation::hasArgument) || terminalOperation.hasArgument()) {
            out.print(", ");
        }
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
            operation.emitPreamble(out, operationInstance.sourceType, operationInstance.argumentName, sizeEstimate);
        }

        //terminalOperation.emitPreamble(out, terminalInstance.sourceType, terminalInstance.argumentName, sizeEstimate);

        out.printIndentation();
        out.println("for (T0 t0 : input) {");
        out.increaseIndentation();

        for (int i = 0; i < operationInstances.size(); i++) {
            OperationInstance operationInstance = operationInstances.get(i);
            String targetElement = i + 1 < operationInstances.size()
                    ? operationInstances.get(i + 1).streamElement
                    : null;
            Operation operation = operationInstance.operation;
            operation.emitOperation(out, operationInstance.sourceType, operationInstance.argumentName, operationInstance.streamElement, operationInstance.targetType, targetElement);
        }
        out.decreaseIndentation();
        out.printIndentation();
        out.println("}");
        for (OperationInstance operationInstance : operationInstances) {
            Operation operation = operationInstance.operation;
            if (operation != terminalOperation) {
                operation.emitPostamble(out, operationInstance.sourceType, operationInstance.argumentName);
            }
        }
        terminalOperation.emitPostamble(out, terminalInstance.sourceType, terminalInstance.argumentName);

        out.decreaseIndentation();
        out.printIndentation();
        out.println("}");
        out.println();
    }

    private static void emitTypeParameterList(Emitter out, List<OperationInstance> operationInstances) {
        List<String> types = Stream.concat(
                Stream.of("T0"),
                operationInstances
                        .stream()
                        .filter(op -> op.operation instanceof IntermediateOperation)
                        .map(OperationInstance::targetType))
                .filter(s -> !"int".equals(s) && !"long".equals(s) && !"double".equals(s) && !"Integer".equals(s) && !"Long".equals(s) && !"Double".equals(s))
                .distinct()
                .collect(Collectors.toList());

        OperationInstance terminalInstance = operationInstances.get(operationInstances.size() - 1);
        if(terminalInstance.operation instanceof CollectCollector collector) {
            String[] argumentTypes = collector.getArgumentType(terminalInstance.sourceType, terminalInstance.targetType).split("[,<>]");
            types.add(argumentTypes[argumentTypes.length - 2].trim()); // add type of accumulator
            types.add(argumentTypes[argumentTypes.length - 1].trim()); // add type of combiner
        }

        out.print(types.stream().collect(Collectors.joining(", ", "<", ">")));
    }

    private static void emitMethodName(Emitter out, TerminalOperation terminalOperation, List<IntermediateOperation> intermediateOperationList) {
        out.print(" stream_");
        out.print(intermediateOperationList.stream().map(IntermediateOperation::getName).collect(Collectors.joining("_")));
        if (!intermediateOperationList.isEmpty()) {
            out.print("_");
        }
        out.print(terminalOperation.getName());
    }

    private static List<OperationInstance> getOperationInstances(List<IntermediateOperation> intermediateOperations, TerminalOperation terminalOperation) {
        String currentType = "T0";
        int typeCount = 1;
        List<OperationInstance> operationInstances = new ArrayList<>();
        int argumentIndex = 0;
        int currentElement = 0;
        String currentStreamElement = "t0";
        for (IntermediateOperation operation : intermediateOperations) {
            String targetType = operation.getTargetType(currentType, "T" + typeCount);
            assert operation.hasArgument();
            operationInstances.add(new OperationInstance(operation, currentType, targetType, "arg" + argumentIndex++, currentStreamElement));
            if (!targetType.equals(currentType)) {
                currentStreamElement = "t" + typeCount;
                typeCount++;
                currentType = targetType;
            }
        }
        operationInstances.add(new OperationInstance(terminalOperation, currentType, terminalOperation.getTargetType(currentType, null), "arg" + argumentIndex, currentStreamElement));
        return operationInstances;
    }

    private static void emitArgumentDeclarations(Emitter out, List<OperationInstance> operationInstances) {
        String argumentDeclarations = operationInstances.stream()
                .filter(op -> op.operation.hasArgument())
                .map(Generator::getArgumentDeclaration)
                .collect(Collectors.joining(", "));
        out.print(argumentDeclarations);
    }

    private static String getArgumentDeclaration(OperationInstance operationInstance) {
        return operationInstance.operation.getArgumentType(operationInstance.sourceType, operationInstance.targetType)
                + " "
                + operationInstance.argumentName;
    }

}

