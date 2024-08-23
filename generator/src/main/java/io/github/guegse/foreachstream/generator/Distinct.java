package io.github.guegse.foreachstream.generator;

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
        out.println("Set<" + referenceType(inputType) + "> " + addVariable() + " = new HashSet<>();");
    }

    @Override
    void emitOperation(Emitter out, String inputType, String argument, String currentStreamElement, String nextTargetType, String nextTargetElement) {
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
