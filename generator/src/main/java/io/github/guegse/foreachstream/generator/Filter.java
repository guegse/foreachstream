package io.github.guegse.foreachstream.generator;

import java.util.List;

class Filter extends IntermediateOperation {

    @Override
    String getName() {
        return "filter";
    }

    @Override
    String getTargetType(String inputType, String nextTargetType) {
        return inputType;
    }

    @Override
    List<String> getArgumentTypes(String inputType, String nextOutputType) {
        return List.of(predicateType(inputType));
    }

    @Override
    void emitOperation(Emitter out, String inputType, List<String> arguments, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        out.printIndentation();
        out.println("if (!" + arguments.get(0) + ".test(" + currentStreamElement + ")) {");
        out.increaseIndentation();
        out.printIndentation();
        out.println("continue;");
        out.decreaseIndentation();
        out.printIndentation();
        out.println("}");
    }

    @Override
    boolean isFilter() {
        return true;
    }
}
