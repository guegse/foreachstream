package io.github.guegse.foreachstream.generator;

import java.util.List;

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
    List<String> getArgumentTypes(String inputType, String nextOutputType) {
        return List.of("Comparator<? super " + inputType + ">");
    }

    @Override
    void emitPreamble(Emitter out, String inputType, List<String> arguments, String estimatedSize) {
        out.printIndentation();
        out.println("List<" + inputType + "> " + addVariable() + " = new ArrayList<>();");
    }

    @Override
    void emitOperation(Emitter out, String inputType, List<String> arguments, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        String collection = getVariable();
        out.printIndentation();
        out.println(collection + ".add(" + currentStreamElement + ");");
        while(depth >= 1) {
            decreaseDepth(out);
        }
        out.printIndentation();
        out.println(collection + ".sort(" + arguments.get(0) + ");");
        out.printIndentation();
        out.println("for ("+ inputType + " " + nextTargetElement + ": " + collection + ") {");
        out.increaseIndentation();
        depth++;
    }
}
