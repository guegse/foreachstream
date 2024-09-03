package io.github.guegse.foreachstream.generator;

abstract class TerminalOperation extends Operation {
    @Override
    boolean addTargetTypeToTypeParameterList() {
        return false;
    }
}
