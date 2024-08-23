package io.github.guegse.foreachstream.generator;

public class MapToDoubleOp extends IntermediateOperation {
    @Override
    String getTargetType(String inputType, String nextOutputType) {
        return "double";
    }

    @Override
    String getArgumentType(String inputType, String nextOutputType) {
        return switch (inputType) {
            case "int" -> "IntToDoubleFunction";
            case "long" -> "LongToDoubleFunction";
            case "double" -> throw new UnsupportedOperationException("cannot map double to double");
            default -> "ToDoubleFunction<" + inputType + ">";
        };
    }

    @Override
    String getName() {
        return "mapToDouble";
    }

    @Override
    boolean hasArgument() {
        return true;
    }

    @Override
    void emitOperation(Emitter out, String inputType, String argument, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        out.printIndentation();
        out.println("double " + nextTargetElement + " = " + argument + ".applyAsDouble(" + currentStreamElement + ");");
    }
}
