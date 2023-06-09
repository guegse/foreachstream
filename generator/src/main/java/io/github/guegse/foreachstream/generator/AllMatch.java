package io.github.guegse.foreachstream.generator;

public class AllMatch extends TerminalOperation {
    @Override
    String getTargetType(String inputType, String nextOutputType) {
        return "boolean";
    }

    @Override
    String getArgumentType(String inputType, String nextOutputType) {
        return predicateType(inputType);
    }

    @Override
    String getName() {
        return "allMatch";
    }

    @Override
    boolean hasArgument() {
        return true;
    }

    @Override
    void emitPreamble(Emitter out, String inputType, String estimatedSize) {
    }

    @Override
    void emitOperation(Emitter out, String inputType, String argument, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        out.printIndentation();
        out.println("if (!" + argument + ".test(" + currentStreamElement + ")) {");
        out.increaseIndentation();
        out.printIndentation();
        out.println("return false;");
        out.decreaseIndentation();
        out.printIndentation();
        out.println("}");
    }

    @Override
    void emitPostamble(Emitter out, String inputType) {
        out.printIndentation();
        out.println("return true;");
    }
}
