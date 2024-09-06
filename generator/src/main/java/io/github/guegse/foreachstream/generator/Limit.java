package io.github.guegse.foreachstream.generator;

import java.util.List;

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
    List<String> getArgumentTypes(String inputType, String nextOutputType) {
        return List.of("long");
    }

    @Override
    void emitPreamble(Emitter out, String inputType, List<String> arguments, String estimatedSize) {
        out.printIndentation();
        out.println("if(" + arguments.get(0) + " < 0) {");
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
    void emitShortCircuit(Emitter out, String inputType, List<String> arguments) {
        String variable = getVariable();
        out.printIndentation();
        out.println("if(" + variable + " >= " + arguments.get(0) + ") {");
        out.increaseIndentation();
        out.printIndentation();
        out.println("break;");
        out.decreaseIndentation();
        out.printIndentation();
        out.println("}");
        addVariable(variable);
    }

    @Override
    void emitOperation(Emitter out, String inputType, List<String> arguments, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        String variable = getVariable();
        out.printIndentation();
        out.println(variable + "++;");
    }
}
