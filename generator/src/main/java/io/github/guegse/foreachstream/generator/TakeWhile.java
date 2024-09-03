package io.github.guegse.foreachstream.generator;

import java.util.List;

public class TakeWhile extends StatefulIntermediateOperation{
    @Override
    String getName() {
        return "takeWhile";
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
        out.println("if(!" + arguments.get(0) + ".test(" + currentStreamElement + ")) {");
        out.increaseIndentation();
        out.printIndentation();
        out.println("break;");
        out.decreaseIndentation();
        out.printIndentation();
        out.println("}");
    }
}
