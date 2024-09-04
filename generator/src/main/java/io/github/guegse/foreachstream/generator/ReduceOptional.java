package io.github.guegse.foreachstream.generator;

import java.util.List;

public class ReduceOptional extends TerminalOperation {
    @Override
    String getName() {
        return "reduceOptional";
    }

    @Override
    String getTargetType(String inputType, String nextOutputType) {
        return optionalType(inputType);
    }

    @Override
    List<String> getArgumentTypes(String inputType, String nextOutputType) {
        return List.of(binaryOperatorType(inputType));
    }

    @Override
    void emitPreamble(Emitter out, String inputType, List<String> arguments, String estimatedSize) {
        out.printIndentation();
        out.println("boolean foundAny = false;");
        out.printIndentation();
        out.println(inputType + " result = " + (isPrimitiveType(inputType) ? "0" : "null") + ";");
    }

    @Override
    void emitOperation(Emitter out, String inputType, List<String> arguments, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        out.printIndentation();
        out.println("if (!foundAny) {");
        out.increaseIndentation();
        out.printIndentation();
        out.println("foundAny = true;");
        out.printIndentation();
        out.println("result = " + currentStreamElement + ";");
        out.decreaseIndentation();
        out.printIndentation();
        out.println("} else {");
        out.increaseIndentation();
        out.printIndentation();
        out.println("result = " + arguments.get(0) + "." + applyType(inputType) + "(result, " + currentStreamElement + ");");
        out.decreaseIndentation();
        out.printIndentation();
        out.println("}");
    }

    @Override
    void emitPostamble(Emitter out, String inputType, List<String> arguments) {
        out.printIndentation();
        out.println("return foundAny ? " + optionalTypeUnqualified(inputType) + ".of(result) : " + optionalTypeUnqualified(inputType) + ".empty();");
    }
}
