package io.github.guegse.foreachstream.generator;

public class Sum extends TerminalOperation {
    @Override
    String getTargetType(String inputType, String nextOutputType) {
        return switch (inputType) {
            case "int" -> "int";
            case "long" -> "long";
            case "double" -> "double";
            default -> throw new UnsupportedOperationException(inputType);
        };
    }

    @Override
    String getArgumentType(String inputType, String nextOutputType) {
        return null;
    }

    @Override
    String getName() {
        return "sum";
    }

    @Override
    boolean hasArgument() {
        return false;
    }

    @Override
    void emitPreamble(Emitter out, String inputType, String argument, String estimatedSize) {
        out.printIndentation();
        switch (inputType) {
            case "int" -> out.println("int sum = 0;");
            case "long" -> out.println("long sum = 0;");
            case "double" -> out.println("double sum = 0;");
            default -> throw new UnsupportedOperationException();
        }
    }

    @Override
    void emitOperation(Emitter out, String inputType, String argument, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        out.printIndentation();
        out.println("sum += " + currentStreamElement + ";");
    }

    @Override
    void emitPostamble(Emitter out, String inputType, String argument) {
        out.printIndentation();
        out.println("return sum;");
    }
}
