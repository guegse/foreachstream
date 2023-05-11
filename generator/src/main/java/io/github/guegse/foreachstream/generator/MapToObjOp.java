package io.github.guegse.foreachstream.generator;

public class MapToObjOp extends IntermediateOperation {
    @Override
    String getTargetType(String inputType, String nextOutputType) {
        return nextOutputType;
    }

    @Override
    String getArgumentType(String inputType, String nextOutputType) {
        return switch (inputType) {
            case "int" -> "IntFunction<" + nextOutputType + ">";
            case "long" -> "LongFunction<" + nextOutputType + ">";
            case "double" -> "DoubleFunction<" + nextOutputType + ">";
            default -> throw new UnsupportedOperationException(inputType);
        };
    }

    @Override
    String getName() {
        return "mapToObj";
    }

    @Override
    boolean hasArgument() {
        return true;
    }

    @Override
    void emitOperation(Emitter out, String inputType, String argument, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        out.printIndentation();
        out.println(nextTargetType + " " + nextTargetElement + " = " + argument + ".apply(" + currentStreamElement + ");");
    }
}
