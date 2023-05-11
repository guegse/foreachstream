package io.github.guegse.foreachstream.generator;

interface Emitter {

    Emitter subEmitter();

    void println();
    void println(String s);

    void print(String s);
    void printIndentation();

    void close();

    void increaseIndentation();

    void decreaseIndentation();

    String indentation();
}
