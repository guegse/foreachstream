package io.github.guegse.foreachstream.generator;

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
    String getArgumentType(String inputType, String nextOutputType) {
        return predicateType(inputType);
    }

    @Override
    boolean hasArgument() {
        return true;
    }

    @Override
    void emitOperation(Emitter out, String inputType, String argument, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        out.printIndentation();
        out.println("if(!" + argument + ".test(" + currentStreamElement + ")) {");
        out.increaseIndentation();
        out.printIndentation();
        out.println("break;");
        out.decreaseIndentation();
        out.printIndentation();
        out.println("}");
    }
}
