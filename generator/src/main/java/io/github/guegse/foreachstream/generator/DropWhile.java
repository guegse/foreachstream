package io.github.guegse.foreachstream.generator;

import java.util.List;

public class DropWhile extends StatefulIntermediateOperation{
    @Override
    String getName() {
        return "dropWhile";
    }

    @Override
    String getTargetType(String inputType, String nextTargetType) {
        return inputType;
    }

    @Override
    List<String> getArgumentTypes(String inputType, String nextOutputType) {
        return List.of(predicateType(inputType));
    }

    @Override
    void emitPreamble(Emitter out, String inputType, List<String> arguments, String estimatedSize) {
        out.printIndentation();
        out.println("boolean " + addVariable() + " = true;");
    }

    @Override
    void emitOperation(Emitter out, String inputType, List<String> arguments, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        String variable = getVariable();
        out.printIndentation();
        out.println("if(" + variable + " && " + arguments.get(0) + ".test(" + currentStreamElement + ")) {");
        out.increaseIndentation();
        out.printIndentation();
        out.println("continue;");
        out.decreaseIndentation();
        out.printIndentation();
        out.println("} else {");
        out.increaseIndentation();
        out.printIndentation();
        out.println(variable + " = false;");
        out.decreaseIndentation();
        out.printIndentation();
        out.println("}");
    }
}
