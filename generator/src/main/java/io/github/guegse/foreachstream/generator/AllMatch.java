package io.github.guegse.foreachstream.generator;

import java.util.List;

public class AllMatch extends TerminalOperation {
    @Override
    String getTargetType(String inputType, String nextOutputType) {
        return "boolean";
    }

    @Override
    List<String> getArgumentTypes(String inputType, String nextOutputType) {
        return List.of(predicateType(inputType));
    }

    @Override
    String getName() {
        return "allMatch";
    }

    @Override
    void emitPreamble(Emitter out, String inputType, List<String> arguments, String estimatedSize) {
    }

    @Override
    void emitOperation(Emitter out, String inputType, List<String> arguments, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        out.printIndentation();
        out.println("if (!" + arguments.get(0) + ".test(" + currentStreamElement + ")) {");
        out.increaseIndentation();
        out.printIndentation();
        out.println("return false;");
        out.decreaseIndentation();
        out.printIndentation();
        out.println("}");
    }

    @Override
    void emitPostamble(Emitter out, String inputType, List<String> arguments) {
        out.printIndentation();
        out.println("return true;");
    }
}
