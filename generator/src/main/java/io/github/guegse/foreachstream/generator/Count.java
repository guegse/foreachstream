package io.github.guegse.foreachstream.generator;

import java.util.List;

public class Count extends TerminalOperation {
    @Override
    String getTargetType(String inputType, String nextOutputType) {
        return "long";
    }

    @Override
    List<String> getArgumentTypes(String inputType, String nextOutputType) {
        return null;
    }

    @Override
    String getName() {
        return "count";
    }

    @Override
    void emitPreamble(Emitter out, String inputType, List<String> arguments, String estimatedSize) {
        out.printIndentation();
        out.println("long count = 0;");
    }

    @Override
    void emitOperation(Emitter out, String inputType, List<String> arguments, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        out.printIndentation();
        out.println("count++;");
    }

    @Override
    void emitPostamble(Emitter out, String inputType, List<String> arguments) {
        out.printIndentation();
        out.println("return count;");
    }
}
