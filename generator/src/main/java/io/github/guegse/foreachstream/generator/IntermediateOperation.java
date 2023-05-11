package io.github.guegse.foreachstream.generator;

abstract class IntermediateOperation extends Operation {

    @Override
    void emitPreamble(Emitter out, String inputType, String estimatedSize) {
    }

    @Override
    void emitPostamble(Emitter out, String inputType) {
    }

    boolean isFilter() {
        return false;
    }
}
