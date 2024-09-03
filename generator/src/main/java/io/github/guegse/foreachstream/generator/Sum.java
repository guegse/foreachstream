package io.github.guegse.foreachstream.generator;

import java.util.List;

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
    List<String> getArgumentTypes(String inputType, String nextOutputType) {
        return null;
    }

    @Override
    String getName() {
        return "sum";
    }

    @Override
    void emitPreamble(Emitter out, String inputType, List<String> arguments, String estimatedSize) {
        out.printIndentation();
        switch (inputType) {
            case "int" -> out.println("int sum = 0;");
            case "long" -> out.println("long sum = 0;");
            case "double" -> out.println("double sum = 0;");
            default -> throw new UnsupportedOperationException();
        }
    }

    @Override
    void emitOperation(Emitter out, String inputType, List<String> arguments, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        out.printIndentation();
        out.println("sum += " + currentStreamElement + ";");
    }

    @Override
    void emitPostamble(Emitter out, String inputType, List<String> arguments) {
        out.printIndentation();
        out.println("return sum;");
    }
}
