package io.github.guegse.foreachstream.generator;

public class DropWhile extends StatefulIntermediateOperation{
    @Override
    String getName() {
        return "dropWhile";
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
    void emitPreamble(Emitter out, String inputType, String argument, String estimatedSize) {
        out.printIndentation();
        out.println("boolean " + addVariable() + " = true;");
    }

    @Override
    void emitOperation(Emitter out, String inputType, String argument, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        String variable = getVariable();
        out.printIndentation();
        out.println("if(" + variable + " && " + argument + ".test(" + currentStreamElement + ")) {");
        out.increaseIndentation();
        out.printIndentation();
        out.println("continue;");
        out.decreaseIndentation();
        out.printIndentation();
        out.println("} else {");
        out.increaseIndentation();
        out.printIndentation();
        out.println(variable + " = false;");
        out.decreaseIndentation();
        out.printIndentation();
        out.println("}");
    }
}
