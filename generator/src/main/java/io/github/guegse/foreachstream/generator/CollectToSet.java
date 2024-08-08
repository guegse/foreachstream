package io.github.guegse.foreachstream.generator;

class CollectToSet extends TerminalOperation {

    @Override
    String getName() {
        return "collectToSet";
    }

    @Override
    String getTargetType(String inputType, String nextOutputType) {
        assertNonPrimitiveStream(inputType);
        return "Set<" + inputType + ">";
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
    void emitPreamble(Emitter out, String inputType, String estimatedSize) {
        out.printIndentation();
        out.println("HashSet<" + inputType + "> result = new HashSet<>(" + estimatedSize + ");");
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
