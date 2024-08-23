package io.github.guegse.foreachstream.generator;

public class Limit extends StatefulIntermediateOperation{
    @Override
    String getName() {
        return "limit";
    }

    @Override
    String getTargetType(String inputType, String nextTargetType) {
        return inputType;
    }

    @Override
    String getArgumentType(String inputType, String nextOutputType) {
        return "long";
    }

    @Override
    boolean hasArgument() {
        return true;
    }

    @Override
    void emitPreamble(Emitter out, String inputType, String argument, String estimatedSize) {
        out.printIndentation();
        out.println("if(" + argument + " < 0) {");
        out.increaseIndentation();
        out.printIndentation();
        out.println("throw new IllegalArgumentException();"); // consistent with the  streams implementation
        out.decreaseIndentation();
        out.printIndentation();
        out.println("}");
        out.printIndentation();
        out.println("long " + addVariable() + " = 0;");
    }

    @Override
    void emitOperation(Emitter out, String inputType, String argument, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        String variable = getVariable();
        out.printIndentation();
        out.println(variable + "++;");
        out.printIndentation();
        out.println("if(" + variable + " > " + argument + ") {");
        out.increaseIndentation();
        out.printIndentation();
        out.println("break;");
        out.decreaseIndentation();
        out.printIndentation();
        out.println("}");
    }
}
