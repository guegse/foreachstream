package io.github.guegse.foreachstream.generator;

public class SortedComparator extends StatefulIntermediateOperation{
    @Override
    String getName() {
        return "sortedComp";
    }

    @Override
    String getTargetType(String inputType, String nextTargetType) {
        assertNonPrimitiveStream(inputType);
        return inputType;
    }

    @Override
    String getArgumentType(String inputType, String nextOutputType) {
        return "Comparator<? super " + inputType + ">";
    }

    @Override
    boolean hasArgument() {
        return true;
    }

    @Override
    void emitPreamble(Emitter out, String inputType, String argument, String estimatedSize) {
        out.printIndentation();
        out.println("List<" + inputType + "> " + addVariable() + " = new ArrayList<>();");
    }

    @Override
    void emitOperation(Emitter out, String inputType, String argument, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        String collection = getVariable();
        out.printIndentation();
        out.println(collection + ".add(" + currentStreamElement + ");");
        while(depth >= 1) {
            decreaseDepth(out);
        }
        out.printIndentation();
        out.println(collection + ".sort(" + argument + ");");
        out.printIndentation();
        out.println("for ("+ inputType + " " + nextTargetElement + ": " + collection + ") {");
        out.increaseIndentation();
        depth++;
    }
}
