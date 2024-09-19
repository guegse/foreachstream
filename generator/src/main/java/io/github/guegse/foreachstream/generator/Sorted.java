package io.github.guegse.foreachstream.generator;

import java.util.List;

public class Sorted extends StatefulIntermediateOperation{
    @Override
    String getName() {
        return "sorted";
    }

    @Override
    String getTargetType(String inputType, String nextTargetType) {
        return inputType;
    }

    @Override
    List<String> getArgumentTypes(String inputType, String nextOutputType) {
        return null;
    }

    @Override
    void emitPreamble(Emitter out, String inputType, List<String> arguments, String estimatedSize) {
        out.printIndentation();
        out.println("List<" + referenceType(inputType) + "> " + addVariable() + " = new ArrayList<>(" + estimatedSize + ");");
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
        out.println(collection + ".sort(null);");
        out.printIndentation();
        out.println("for ("+ inputType + " " + nextTargetElement + ": " + collection + ") {");
        out.increaseIndentation();
        depth++;
    }
}
