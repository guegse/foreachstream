package io.github.guegse.foreachstream.generator;

public class Min extends TerminalOperation {
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
    String getArgumentType(String inputType, String nextOutputType) {
        return null;
    }

    @Override
    String getName() {
        return "min";
    }

    @Override
    boolean hasArgument() {
        return false;
    }

    @Override
    void emitPreamble(Emitter out, String inputType, String argument, String estimatedSize) {
        out.printIndentation();
        switch (inputType) {
            case "int" -> out.println("int min = Integer.MAX_VALUE;");
            case "long" -> out.println("long min = Long.MAX_VALUE;");
            case "double" -> out.println("double min = Double.MAX_VALUE;");
            default -> throw new UnsupportedOperationException();
        }
        out.printIndentation();
        out.println("boolean hasMin = false;");
    }

    @Override
    void emitOperation(Emitter out, String inputType, String argument, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        out.printIndentation();
        out.println("if (hasMin) {");
        out.increaseIndentation();
        out.printIndentation();
        out.println("min = Math.min(min, " + currentStreamElement + ");");
        out.decreaseIndentation();
        out.printIndentation();
        out.println("} else {");
        out.increaseIndentation();
        out.printIndentation();
        out.println("hasMin = true;");
        out.printIndentation();
        out.println("min = " + currentStreamElement + ";");
        out.decreaseIndentation();
        out.printIndentation();
        out.println("}");
    }

    @Override
    void emitPostamble(Emitter out, String inputType, String argument) {
        out.printIndentation();
        out.println("if (hasMin) {");
        out.increaseIndentation();
        out.printIndentation();
        out.println("return " + optionalTypeUnqualified(inputType) + ".of(min);");
        out.decreaseIndentation();
        out.printIndentation();
        out.println("}");
        out.printIndentation();
        out.println("return " + optionalTypeUnqualified(inputType) + ".empty();");
    }
}
