package io.github.guegse.foreachstream.generator;

public class Boxed extends IntermediateOperation {
    @Override
    String getTargetType(String inputType, String nextOutputType) {
        return switch (inputType) {
            case "int" -> "Integer";
            case "long" -> "Long";
            case "double" -> "Double";
            default -> throw new UnsupportedOperationException(inputType);
        };
    }

    @Override
    String getArgumentType(String inputType, String nextOutputType) {
        return null;
    }

    @Override
    String getName() {
        return "boxed";
    }

    @Override
    boolean hasArgument() {
        return false;
    }

    @Override
    void emitOperation(Emitter out, String inputType, String argument, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        out.printIndentation();
        switch (inputType) {
            case "int" -> out.println("Integer " + nextTargetElement + " = " + currentStreamElement + ";");
            case "long" -> out.println("Long " + nextTargetElement + " = " + currentStreamElement + ";");
            case "double" -> out.println("Double " + nextTargetElement + " = " + currentStreamElement + ";");
            default -> throw new UnsupportedOperationException(inputType);
        }
    }
}
