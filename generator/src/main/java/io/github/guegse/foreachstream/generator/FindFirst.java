package io.github.guegse.foreachstream.generator;

public class FindFirst extends TerminalOperation {
    @Override
    String getTargetType(String inputType, String nextOutputType) {
        return optionalType(inputType);
    }

    @Override
    String getArgumentType(String inputType, String nextOutputType) {
        return null;
    }

    @Override
    String getName() {
        return "findFirst";
    }

    @Override
    boolean hasArgument() {
        return false;
    }

    @Override
    void emitPreamble(Emitter out, String inputType, String estimatedSize) {

    }

    @Override
    void emitOperation(Emitter out, String inputType, String argument, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        out.printIndentation();
        out.println("return " + optionalTypeUnqualified(inputType) + ".of(" + currentStreamElement + ");");
    }

    @Override
    void emitPostamble(Emitter out, String inputType) {
        out.printIndentation();
        out.println("return " + optionalTypeUnqualified(inputType) + ".empty();");
    }

}
