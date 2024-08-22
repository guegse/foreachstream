package io.github.guegse.foreachstream.generator;

import java.util.ArrayDeque;
import java.util.Deque;

public abstract class StatefulIntermediateOperation extends IntermediateOperation{
    private Deque<String> deque = new ArrayDeque<>();

    public String addCollection() {
        String ident = getName() + deque.size();
        deque.addLast(ident);
        return ident;
    }

    public String getCollection() {
        return deque.removeFirst();
    }
}
