package io.github.guegse.foreachstream.generator;

public class MapToLongOp extends IntermediateOperation {
    @Override
    String getTargetType(String inputType, String nextOutputType) {
        return "long";
    }

    @Override
    String getArgumentType(String inputType, String nextOutputType) {
        return switch (inputType) {
            case "int" -> "IntToLongFunction";
            case "long" -> throw new UnsupportedOperationException("cannot map long to long");
            case "double" -> "DoubleToLongFunction";
            default -> "ToLongFunction<" + inputType + ">";
        };
    }

    @Override
    String getName() {
        return "mapToLong";
    }

    @Override
    boolean hasArgument() {
        return true;
    }

    @Override
    void emitOperation(Emitter out, String inputType, String argument, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        out.printIndentation();
        out.println("long " + nextTargetElement + " = " + argument + ".applyAsLong(" + currentStreamElement + ");");
    }
}
