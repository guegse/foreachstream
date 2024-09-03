package io.github.guegse.foreachstream.generator;

import java.util.List;

public class MapToDoubleOp extends IntermediateOperation {
    @Override
    String getTargetType(String inputType, String nextOutputType) {
        return "double";
    }

    @Override
    List<String> getArgumentTypes(String inputType, String nextOutputType) {
        return List.of( switch (inputType) {
            case "int" -> "IntToDoubleFunction";
            case "long" -> "LongToDoubleFunction";
            case "double" -> throw new UnsupportedOperationException("cannot map double to double");
            default -> "ToDoubleFunction<" + inputType + ">";
        });
    }

    @Override
    String getName() {
        return "mapToDouble";
    }

    @Override
    void emitOperation(Emitter out, String inputType, List<String> arguments, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        out.printIndentation();
        out.println("double " + nextTargetElement + " = " + arguments.get(0) + ".applyAsDouble(" + currentStreamElement + ");");
    }
}
