package io.github.guegse.foreachstream.generator;

import java.util.List;

public class Reduce extends TerminalOperation {
    @Override
    String getName() {
        return "reduce";
    }

    @Override
    String getTargetType(String inputType, String nextOutputType) {
        return inputType;
    }

    @Override
    List<String> getArgumentTypes(String inputType, String nextOutputType) {
        return List.of(inputType, binaryOperatorType(inputType));
    }

    @Override
    void emitPreamble(Emitter out, String inputType, List<String> arguments, String estimatedSize) {
        out.printIndentation();
        out.println(inputType + " result = " + arguments.get(0) + ";");
    }

    @Override
    void emitOperation(Emitter out, String inputType, List<String> arguments, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        out.printIndentation();
        out.println("result = " + arguments.get(1) + "." + applyType(inputType) + "(result, " + currentStreamElement + ");");
    }

    @Override
    void emitPostamble(Emitter out, String inputType, List<String> arguments) {
        out.printIndentation();
        out.println("return result;");
    }
}
