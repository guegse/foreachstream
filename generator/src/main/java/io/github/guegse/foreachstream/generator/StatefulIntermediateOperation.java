package io.github.guegse.foreachstream.generator;

import java.util.ArrayDeque;
import java.util.Deque;

public abstract class StatefulIntermediateOperation extends IntermediateOperation{
    private Deque<String> deque = new ArrayDeque<>();

    public String addVariable() {
        String ident = getName() + deque.size();
        deque.addLast(ident);
        return ident;
    }

    public String getVariable() {
        return deque.removeFirst();
    }
}
