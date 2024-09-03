package io.github.guegse.foreachstream.generator;

import java.util.List;

public class Max extends TerminalOperation {
    @Override
    String getTargetType(String inputType, String nextOutputType) {
        return switch (inputType) {
            case "int" -> "OptionalInt";
            case "long" -> "OptionalLong";
            case "double" -> "OptionalDouble";
            default -> throw new UnsupportedOperationException(inputType);
        };
    }

    @Override
    List<String> getArgumentTypes(String inputType, String nextOutputType) {
        return null;
    }

    @Override
    String getName() {
        return "max";
    }

    @Override
    void emitPreamble(Emitter out, String inputType, List<String> arguments, String estimatedSize) {
        out.printIndentation();
        switch (inputType) {
            case "int" -> out.println("int max = 0;");
            case "long" -> out.println("long max = 0;");
            case "double" -> out.println("double max = 0;");
            default -> throw new UnsupportedOperationException();
        }
        out.printIndentation();
        out.println("boolean hasMax = false;");
    }

    @Override
    void emitOperation(Emitter out, String inputType, List<String> arguments, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        out.printIndentation();
        out.println("if (hasMax) {");
        out.increaseIndentation();
        out.printIndentation();
        out.println("max = Math.max(max, " + currentStreamElement + ");");
        out.decreaseIndentation();
        out.printIndentation();
        out.println("} else {");
        out.increaseIndentation();
        out.printIndentation();
        out.println("hasMax = true;");
        out.printIndentation();
        out.println("max = " + currentStreamElement + ";");
        out.decreaseIndentation();
        out.printIndentation();
        out.println("}");
    }

    @Override
    void emitPostamble(Emitter out, String inputType, List<String> arguments) {
        out.printIndentation();
        out.println("if (hasMax) {");
        out.increaseIndentation();
        out.printIndentation();
        out.println("return " + optionalTypeUnqualified(inputType) + ".of(max);");
        out.decreaseIndentation();
        out.printIndentation();
        out.println("}");
        out.printIndentation();
        out.println("return " + optionalTypeUnqualified(inputType) + ".empty();");
    }
}
