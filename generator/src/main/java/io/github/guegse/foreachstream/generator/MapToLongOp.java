package io.github.guegse.foreachstream.generator;

import java.util.List;

public class MapToLongOp extends IntermediateOperation {
    @Override
    String getTargetType(String inputType, String nextOutputType) {
        return "long";
    }

    @Override
    List<String> getArgumentTypes(String inputType, String nextOutputType) {
        return List.of( switch (inputType) {
            case "int" -> "IntToLongFunction";
            case "long" -> throw new UnsupportedOperationException("cannot map long to long");
            case "double" -> "DoubleToLongFunction";
            default -> "ToLongFunction<" + inputType + ">";
        });
    }

    @Override
    String getName() {
        return "mapToLong";
    }

    @Override
    void emitOperation(Emitter out, String inputType, List<String> arguments, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        out.printIndentation();
        out.println("long " + nextTargetElement + " = " + arguments.get(0) + ".applyAsLong(" + currentStreamElement + ");");
    }
}
