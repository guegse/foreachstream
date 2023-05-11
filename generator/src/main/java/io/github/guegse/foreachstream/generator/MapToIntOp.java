package io.github.guegse.foreachstream.generator;

public class MapToIntOp extends IntermediateOperation {
    @Override
    String getTargetType(String inputType, String nextOutputType) {
        return "int";
    }

    @Override
    String getArgumentType(String inputType, String nextOutputType) {
        return switch (inputType) {
            case "int" -> throw new UnsupportedOperationException("cannot map int to int");
            case "long" -> "LongToIntFunction";
            case "double" -> "DoubleToIntFunction";
            default -> "ToIntFunction<" + inputType + ">";
        };
    }

    @Override
    String getName() {
        return "mapToInt";
    }

    @Override
    boolean hasArgument() {
        return true;
    }

    @Override
    void emitOperation(Emitter out, String inputType, String argument, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        out.printIndentation();
        out.println("int " + nextTargetElement + " = " + argument + ".applyAsInt(" + currentStreamElement + ");");
    }
}
