package io.github.guegse.foreachstream.generator;

import java.util.List;

abstract class TerminalOperation extends Operation {
    @Override
    boolean addTargetTypeToTypeParameterList() {
        return false;
    }

    @Override
    void emitShortCircuit(Emitter out, String inputType, List<String> arguments) {

    }
}
