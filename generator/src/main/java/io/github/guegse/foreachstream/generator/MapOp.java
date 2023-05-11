package io.github.guegse.foreachstream.generator;

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
    String getArgumentType(String inputType, String nextOutputType) {
        return switch (inputType) {
            case "int" -> "IntUnaryOperator";
            case "long" -> "LongUnaryOperator";
            case "double" -> "DoubleUnaryOperator";
            default -> "Function<" + inputType + ", " + nextOutputType + ">";
        };
    }

    @Override
    boolean hasArgument() {
        return true;
    }

    @Override
    void emitOperation(Emitter out, String inputType, String argument, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        out.printIndentation();
        if (!inputType.equals(nextTargetType)) {
            out.print(nextTargetType + " ");
        }
        out.print(nextTargetElement + " = " + argument);
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
