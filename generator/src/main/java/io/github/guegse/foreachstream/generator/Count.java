package io.github.guegse.foreachstream.generator;

public class Count extends TerminalOperation {
    @Override
    String getTargetType(String inputType, String nextOutputType) {
        return "long";
    }

    @Override
    String getArgumentType(String inputType, String nextOutputType) {
        return null;
    }

    @Override
    String getName() {
        return "count";
    }

    @Override
    boolean hasArgument() {
        return false;
    }

    @Override
    void emitPreamble(Emitter out, String inputType, String argument, String estimatedSize) {
        out.printIndentation();
        out.println("long count = 0;");
    }

    @Override
    void emitOperation(Emitter out, String inputType, String argument, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        out.printIndentation();
        out.println("count++;");
    }

    @Override
    void emitPostamble(Emitter out, String inputType, String argument) {
        out.printIndentation();
        out.println("return count;");
    }
}
