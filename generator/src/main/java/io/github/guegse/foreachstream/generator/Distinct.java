package io.github.guegse.foreachstream.generator;

import java.util.List;

public class Distinct extends StatefulIntermediateOperation{
    @Override
    String getName() {
        return "distinct";
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
        out.println("Set<" + referenceType(inputType) + "> " + addVariable() + " = new HashSet<>(" + estimatedSize + ");");
    }

    @Override
    void emitOperation(Emitter out, String inputType, List<String> arguments, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        String collection = getVariable();
        out.printIndentation();
        out.println("if(!" + collection + ".add(" + currentStreamElement + ")) {");
        out.increaseIndentation();
        out.printIndentation();
        out.println("continue;");
        out.decreaseIndentation();
        out.printIndentation();
        out.println("}");
    }
}
