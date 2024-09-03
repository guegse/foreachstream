package io.github.guegse.foreachstream.generator;

import java.util.List;

public class Stream extends Operation{
    @Override
    String getName() {
        return "stream";
    }

    @Override
    String getTargetType(String inputType, String nextTargetType) {
        assertNonPrimitiveStream(inputType);
        return inputType;
    }

    @Override
    List<String> getArgumentTypes(String inputType, String nextOutputType) {
        return List.of("Collection<" + inputType + ">");
    }

    @Override
    void emitPreamble(Emitter out, String inputType, List<String> arguments, String estimatedSize) {

    }

    @Override
    void emitOperation(Emitter out, String inputType, List<String> arguments, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        out.printIndentation();
        out.println("for ("+ inputType + " " + nextTargetElement + ": " + arguments.get(0) + ") {");
        out.increaseIndentation();
    }

    @Override
    void emitPostamble(Emitter out, String inputType, List<String> arguments) {
        out.decreaseIndentation();
        out.printIndentation();
        out.println("}");
    }
}
