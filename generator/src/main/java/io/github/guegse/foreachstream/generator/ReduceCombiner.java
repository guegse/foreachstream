package io.github.guegse.foreachstream.generator;

import java.util.List;

public class ReduceCombiner extends TerminalOperation {
    @Override
    String getName() {
        return "reduceCombiner";
    }

    @Override
    String getTargetType(String inputType, String nextOutputType) {
        assertNonPrimitiveStream(inputType);
        return "U";
    }

    @Override
    List<String> getArgumentTypes(String inputType, String nextOutputType) {
        return List.of("U", "BiFunction<U,? super " + inputType + ", U>", "BinaryOperator<U>");
    }

    @Override
    void emitPreamble(Emitter out, String inputType, List<String> arguments, String estimatedSize) {
        out.printIndentation();
        out.println("U result = " + arguments.get(0) + ";");
    }

    @Override
    void emitOperation(Emitter out, String inputType, List<String> arguments, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        out.printIndentation();
        out.println("result = " + arguments.get(1) + ".apply(result, " + currentStreamElement + ");");
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
