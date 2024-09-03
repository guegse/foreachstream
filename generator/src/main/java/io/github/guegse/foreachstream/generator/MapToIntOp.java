package io.github.guegse.foreachstream.generator;

import java.util.List;

public class MapToIntOp extends IntermediateOperation {
    @Override
    String getTargetType(String inputType, String nextOutputType) {
        return "int";
    }

    @Override
    List<String> getArgumentTypes(String inputType, String nextOutputType) {
        return List.of( switch (inputType) {
            case "int" -> throw new UnsupportedOperationException("cannot map int to int");
            case "long" -> "LongToIntFunction";
            case "double" -> "DoubleToIntFunction";
            default -> "ToIntFunction<" + inputType + ">";
        });
    }

    @Override
    String getName() {
        return "mapToInt";
    }

    @Override
    void emitOperation(Emitter out, String inputType, List<String> arguments, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        out.printIndentation();
        out.println("int " + nextTargetElement + " = " + arguments.get(0) + ".applyAsInt(" + currentStreamElement + ");");
    }
}
