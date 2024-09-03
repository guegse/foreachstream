package io.github.guegse.foreachstream.generator;

import java.util.List;

public class MapToObjOp extends IntermediateOperation {
    @Override
    String getTargetType(String inputType, String nextOutputType) {
        return nextOutputType;
    }

    @Override
    List<String> getArgumentTypes(String inputType, String nextOutputType) {
        return List.of(switch (inputType) {
            case "int" -> "IntFunction<" + nextOutputType + ">";
            case "long" -> "LongFunction<" + nextOutputType + ">";
            case "double" -> "DoubleFunction<" + nextOutputType + ">";
            default -> throw new UnsupportedOperationException(inputType);
        });
    }

    @Override
    String getName() {
        return "mapToObj";
    }

    @Override
    void emitOperation(Emitter out, String inputType, List<String> arguments, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        out.printIndentation();
        out.println(nextTargetType + " " + nextTargetElement + " = " + arguments.get(0) + ".apply(" + currentStreamElement + ");");
    }
}
