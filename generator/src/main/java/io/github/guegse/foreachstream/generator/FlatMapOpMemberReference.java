package io.github.guegse.foreachstream.generator;

public class FlatMapOpMemberReference extends IntermediateOperation {
    @Override
    String getTargetType(String inputType, String nextOutputType) {
        assertCollectionStream(inputType);
        return nextOutputType;
    }

    @Override
    String appendPreviousTargetType(String currentType) {
        return "extends Collection<" + currentType + ">";
    }

    @Override
    String getArgumentType(String inputType, String nextOutputType) {
        return null;
    }

    @Override
    String getName() {
        return "flatMapMemberReference";
    }

    @Override
    boolean hasArgument() {
        return false;
    }

    @Override
    void emitOperation(Emitter out, String inputType, String argument, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        out.printIndentation();
        out.println("for (" + nextTargetType + " " + nextTargetElement + " : " + currentStreamElement + ") {");
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
