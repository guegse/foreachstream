package io.github.guegse.foreachstream.generator;

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
    String getArgumentType(String inputType, String nextOutputType) {
        return null;
    }

    @Override
    boolean hasArgument() {
        return false;
    }

    @Override
    void emitPreamble(Emitter out, String inputType, String argument, String estimatedSize) {
        out.printIndentation();
        out.println("List<" + inputType + "> result = new ArrayList<>(" + estimatedSize + ");");
    }

    @Override
    void emitOperation(Emitter out, String inputType, String argument, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        out.printIndentation();
        out.print("result.add(");
        out.print(currentStreamElement);
        out.println(");");
    }

    @Override
    void emitPostamble(Emitter out, String inputType, String argument) {
        out.printIndentation();
        out.println("return Collections.unmodifiableList(result);");
    }
}
