package io.github.guegse.foreachstream.generator;

import java.util.List;

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
    List<String> getArgumentTypes(String inputType, String nextOutputType) {
        return List.of("Collector<? super " + inputType + ", A, R>");
    }

    void emitPreamble(Emitter out, String inputType, List<String> arguments, String estimatedSize) {
        out.printIndentation();
        out.println("A result = " + arguments.get(0) + ".supplier().get();");
    }

    @Override
    void emitOperation(Emitter out, String inputType, List<String> arguments, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        out.printIndentation();
        out.print(arguments.get(0));
        out.print(".accumulator().accept(result, ");
        out.print(currentStreamElement);
        out.println(");");
    }

    @Override
    void emitPostamble(Emitter out, String inputType, List<String> arguments) {
        out.printIndentation();
        out.println("return " + arguments.get(0) + ".finisher().apply(result);");
    }
}
