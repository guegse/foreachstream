package io.github.guegse.foreachstream.generator;

public class CollectCollector extends TerminalOperation{
    @Override
    String getName() {
        return "collectCollector";
    }

    @Override
    String getTargetType(String inputType, String nextOutputType) {
        assertNonPrimitiveStream(inputType);
        return "R";
    }

    @Override
    String getArgumentType(String inputType, String nextOutputType) {
        return "Collector<? super " + inputType + ", A, R>";
    }

    @Override
    boolean hasArgument() {
        return true;
    }

    void emitPreamble(Emitter out, String inputType, String argument, String estimatedSize) {
        out.printIndentation();
        out.println("A result = " + argument + ".supplier().get();");
    }

    @Override
    void emitOperation(Emitter out, String inputType, String argument, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        out.printIndentation();
        out.print(argument);
        out.print(".accumulator().accept(result, ");
        out.print(currentStreamElement);
        out.println(");");
    }

    @Override
    void emitPostamble(Emitter out, String inputType, String argument) {
        out.printIndentation();
        out.println("return " + argument + ".finisher().apply(result);");
    }
}
