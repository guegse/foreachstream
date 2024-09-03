package io.github.guegse.foreachstream.generator;

import java.util.List;

public class ToList extends TerminalOperation {
    @Override
    String getName() {
        return "toList";
    }

    @Override
    String getTargetType(String inputType, String nextOutputType) {
        assertNonPrimitiveStream(inputType);
        return "List<" + inputType + ">";
    }

    @Override
    List<String> getArgumentTypes(String inputType, String nextOutputType) {
        return null;
    }

    @Override
    void emitPreamble(Emitter out, String inputType, List<String> arguments, String estimatedSize) {
        out.printIndentation();
        out.println("List<" + inputType + "> result = new ArrayList<>(" + estimatedSize + ");");
    }

    @Override
    void emitOperation(Emitter out, String inputType, List<String> arguments, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        out.printIndentation();
        out.print("result.add(");
        out.print(currentStreamElement);
        out.println(");");
    }

    @Override
    void emitPostamble(Emitter out, String inputType, List<String> arguments) {
        out.printIndentation();
        out.println("return Collections.unmodifiableList(result);");
    }
}
