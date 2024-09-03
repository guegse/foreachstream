package io.github.guegse.foreachstream.generator;

import java.util.List;

public class Collect extends TerminalOperation{
    @Override
    String getName() {
        return "collect";
    }

    @Override
    String getTargetType(String inputType, String nextOutputType) {
        assertNonPrimitiveStream(inputType);
        return "R";
    }

    @Override
    List<String> getArgumentTypes(String inputType, String nextOutputType) {
        return List.of("Supplier<R>", "BiConsumer<R,? super " + inputType + ">", "BiConsumer<R,R>");
    }

    void emitPreamble(Emitter out, String inputType, List<String> arguments, String estimatedSize) {
        out.printIndentation();
        out.println("R result = " + arguments.get(0) + ".get();");
    }

    @Override
    void emitOperation(Emitter out, String inputType, List<String> arguments, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        out.printIndentation();
        out.print(arguments.get(1));
        out.print(".accept(result, ");
        out.print(currentStreamElement);
        out.println(");");
    }

    @Override
    void emitPostamble(Emitter out, String inputType, List<String> arguments) {
        out.printIndentation();
        out.println("return result;");
    }

    @Override
    boolean addTargetTypeToTypeParameterList() {
        return true;
    }
}
