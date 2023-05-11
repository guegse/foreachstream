package io.github.guegse.foreachstream.generator;

class CollectToList extends TerminalOperation {

    @Override
    String getName() {
        return "collect_toList";
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


    void emitPreamble(Emitter out, String inputType, String estimatedSize) {
        out.printIndentation();
        out.println("ArrayList<" + inputType + "> result = new ArrayList<>(" + estimatedSize + ");");
    }

    @Override
    void emitOperation(Emitter out, String inputType, String argument, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        out.printIndentation();
        out.print("result.add(");
        out.print(currentStreamElement);
        out.println(");");
    }

    @Override
    void emitPostamble(Emitter out, String inputType) {
        out.printIndentation();
        out.println("return result;");
    }
}
