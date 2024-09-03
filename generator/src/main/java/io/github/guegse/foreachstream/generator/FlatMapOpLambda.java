package io.github.guegse.foreachstream.generator;

import java.util.List;

public class FlatMapOpLambda extends IntermediateOperation {
    @Override
    String getTargetType(String inputType, String nextOutputType) {
        return nextOutputType;
    }

    @Override
    List<String> getArgumentTypes(String inputType, String nextOutputType) {
        return switch (inputType) {
            case "int", "long", "double" -> throw new UnsupportedOperationException();
            default -> List.of("Function<" + inputType + ", Collection<" + nextOutputType + ">>");
        };
    }

    @Override
    String getName() {
        return "flatMapLambda";
    }

    @Override
    void emitOperation(Emitter out, String inputType, List<String> arguments, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        out.printIndentation();
        out.println("for (" + nextTargetType + " " + nextTargetElement + " : " + arguments.get(0) + ".apply(" + currentStreamElement + ")) {");
        out.increaseIndentation();
        depth++;
    }

    @Override
    void emitPostamble(Emitter out, String inputType, List<String> arguments) {
        if(depth > 1) {
            decreaseDepth(out);
        }
    }
}
