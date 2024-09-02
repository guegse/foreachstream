package io.github.guegse.foreachstream.generator;

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
    String getArgumentType(String inputType, String nextOutputType) {
        return "Collection<" + inputType + ">";
    }

    @Override
    boolean hasArgument() {
        return true;
    }

    @Override
    void emitPreamble(Emitter out, String inputType, String argument, String estimatedSize) {

    }

    @Override
    void emitOperation(Emitter out, String inputType, String argument, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        out.printIndentation();
        out.println("for ("+ inputType + " " + nextTargetElement + ": " + argument + ") {");
        out.increaseIndentation();
    }

    @Override
    void emitPostamble(Emitter out, String inputType, String argument) {
        out.decreaseIndentation();
        out.printIndentation();
        out.println("}");
    }
}
