package io.github.guegse.foreachstream.generator;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class EmitterImpl implements Emitter {
    private final PrintWriter out;
    private int indentation = 1;

    public EmitterImpl(OutputStream outputStream) {
        this.out = new PrintWriter(outputStream);
    }

    @Override
    public Emitter subEmitter() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintWriter outerWriter = out;
        EmitterImpl sub = new EmitterImpl(os) {
            @Override
            public void close() {
                super.close();
                outerWriter.print(os.toString(StandardCharsets.UTF_8));
            }
        };
        sub.indentation = indentation;
        return sub;
    }

    @Override
    public void println() {
        out.println();
    }

    @Override
    public void println(String s) {
        out.println(s);
    }

    @Override
    public void print(String s) {
        out.print(s);
    }

    @Override
    public void printIndentation() {
        out.print(indentation());
    }

    @Override
    public void close() {
        out.flush();
        out.close();
    }

    @Override
    public void increaseIndentation() {
        indentation++;
    }

    @Override
    public void decreaseIndentation() {
        indentation--;
    }

    @Override
    public String indentation() {
        return "\t".repeat(indentation);
    }
}
