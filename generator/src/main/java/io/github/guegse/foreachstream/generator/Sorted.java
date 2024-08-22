package io.github.guegse.foreachstream.generator;

public class Sorted extends StatefulIntermediateOperation{
    @Override
    String getName() {
        return "sorted";
    }

    @Override
    String getTargetType(String inputType, String nextTargetType) {
        assertNonPrimitiveStream(inputType);
        return inputType;
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
        out.println("List<" + inputType + "> " + addCollection() + " = new ArrayList<>();");
    }

    @Override
    void emitOperation(Emitter out, String inputType, String argument, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        String collection = getCollection();
        out.printIndentation();
        out.println(collection + ".add(" + currentStreamElement + ");");
        out.decreaseIndentation();
        out.printIndentation();
        out.println("}");
        out.printIndentation();
        out.println("Collections.sort((List) " + collection + ");");
        out.printIndentation();
        out.println("for ("+ inputType + " " + nextTargetElement + ": " + collection + ") {");
        out.increaseIndentation();
    }
}
