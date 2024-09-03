package io.github.guegse.foreachstream.generator;

import java.util.List;

public class FindAny extends TerminalOperation {
    @Override
    String getTargetType(String inputType, String nextOutputType) {
        return optionalType(inputType);
    }

    @Override
    List<String> getArgumentTypes(String inputType, String nextOutputType) {
        return null;
    }

    @Override
    String getName() {
        return "findAny";
    }

    @Override
    void emitPreamble(Emitter out, String inputType, List<String> arguments, String estimatedSize) {

    }

    @Override
    void emitOperation(Emitter out, String inputType, List<String> arguments, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        out.printIndentation();
        out.println("return " + optionalTypeUnqualified(inputType) + ".of(" + currentStreamElement + ");");
    }

    @Override
    void emitPostamble(Emitter out, String inputType, List<String> arguments) {
        out.printIndentation();
        out.println("return " + optionalTypeUnqualified(inputType) + ".empty();");
    }

}
