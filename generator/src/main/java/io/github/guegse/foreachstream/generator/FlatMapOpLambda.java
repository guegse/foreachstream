package io.github.guegse.foreachstream.generator;

public class FlatMapOpLambda extends IntermediateOperation {
    @Override
    String getTargetType(String inputType, String nextOutputType) {
        return nextOutputType;
    }

    @Override
    String getArgumentType(String inputType, String nextOutputType) {
        return switch (inputType) {
            case "int", "long", "double" -> throw new UnsupportedOperationException();
            default -> "Function<" + inputType + ", Collection<" + nextOutputType + ">>";
        };
    }

    @Override
    String getName() {
        return "flatMapLambda";
    }

    @Override
    boolean hasArgument() {
        return true;
    }

    @Override
    void emitOperation(Emitter out, String inputType, String argument, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        out.printIndentation();
        out.println("for (" + nextTargetType + " " + nextTargetElement + " : " + argument + ".apply(" + currentStreamElement + ")) {");
        out.increaseIndentation();
        depth++;
    }

    @Override
    void emitPostamble(Emitter out, String inputType, String argument) {
        if(depth > 1) {
            decreaseDepth(out);
        }
    }
}