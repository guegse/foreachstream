package io.github.guegse.foreachstream.generator;

import java.util.List;

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
    List<String> getArgumentTypes(String inputType, String nextOutputType) {
        return List.of(consumerType(inputType));
    }

    @Override
    void emitPreamble(Emitter out, String inputType, List<String> arguments, String estimatedSize) {

    }

    @Override
    void emitOperation(Emitter out, String inputType, List<String> arguments, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        out.printIndentation();
        out.print(arguments.get(0));
        out.print(".accept(");
        out.print(currentStreamElement);
        out.println(");");
    }

    @Override
    void emitPostamble(Emitter out, String inputType, List<String> arguments) {

    }
}
