package io.github.guegse.foreachstream.generator;

import java.util.List;

class MapOp extends IntermediateOperation {

    @Override
    String getName() {
        return "map";
    }

    @Override
    String getTargetType(String inputType, String nextTargetType) {
        return switch (inputType) {
            case "int" -> "int";
            case "long" -> "long";
            case "double" -> "double";
            default -> nextTargetType;
        };
    }

    @Override
    List<String> getArgumentTypes(String inputType, String nextOutputType) {
        return List.of(switch (inputType) {
            case "int" -> "IntUnaryOperator";
            case "long" -> "LongUnaryOperator";
            case "double" -> "DoubleUnaryOperator";
            default -> "Function<" + inputType + ", " + nextOutputType + ">";
        });
    }

    @Override
    void emitOperation(Emitter out, String inputType, List<String> arguments, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        out.printIndentation();
        if (!inputType.equals(nextTargetType)) {
            out.print(nextTargetType + " ");
        }
        out.print(nextTargetElement + " = " + arguments.get(0));
        String applyFn = switch (inputType) {
            case "int" -> "applyAsInt";
            case "long" -> "applyAsLong";
            case "double" -> "applyAsDouble";
            default -> "apply";
        };
        out.print("." + applyFn);
        out.println("(" + currentStreamElement + ");");
    }

}
