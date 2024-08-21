package io.github.guegse.foreachstream.generator;

class Foreach extends TerminalOperation {

    @Override
    String getName() {
        return "forEach";
    }

    @Override
    String getTargetType(String inputType, String nextOutputType) {
        return "void";
    }

    @Override
    String getArgumentType(String inputType, String nextOutputType) {
        return consumerType(inputType);
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
        out.print(argument);
        out.print(".accept(");
        out.print(currentStreamElement);
        out.println(");");
    }

    @Override
    void emitPostamble(Emitter out, String inputType, String argument) {

    }
}
