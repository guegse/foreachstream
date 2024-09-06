package io.github.guegse.foreachstream.generator;

import java.util.List;

abstract class IntermediateOperation extends Operation {

    @Override
    void emitPreamble(Emitter out, String inputType, List<String> arguments, String estimatedSize) {
    }

    @Override
    void emitPostamble(Emitter out, String inputType, List<String> arguments) {
    }

    @Override
    void emitShortCircuit(Emitter out, String inputType, List<String> arguments) {

    }

    boolean isFilter() {
        return false;
    }

    @Override
    boolean addTargetTypeToTypeParameterList() {
        return true;
    }
}
