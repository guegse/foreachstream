package io.github.guegse.foreachstream.generator;

import java.util.List;

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
    List<String> getArgumentTypes(String inputType, String nextOutputType) {
        return null;
    }

    @Override
    String getName() {
        return "flatMapMemberReference";
    }

    @Override
    void emitOperation(Emitter out, String inputType, List<String> arguments, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        out.printIndentation();
        out.println("for (" + nextTargetType + " " + nextTargetElement + " : " + currentStreamElement + ") {");
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
