package io.github.guegse.foreachstream.generator;

public class FindFirst extends TerminalOperation {
    @Override
    String getTargetType(String inputType, String nextOutputType) {
        return optionalType(inputType);
    }

    @Override
    String getArgumentType(String inputType, String nextOutputType) {
        return predicateType(inputType);
    }

    @Override
    String getName() {
        return "findFirst";
    }

    @Override
    boolean hasArgument() {
        return true;
    }

    @Override
    void emitPreamble(Emitter out, String inputType, String estimatedSize) {

    }

    @Override
    void emitOperation(Emitter out, String inputType, String argument, String currentStreamElement, String nextTargetType, String nextTargetElement) {
        out.printIndentation();
        out.println("if (" + argument + ".test(" + currentStreamElement + ")) {");
        out.increaseIndentation();
        out.printIndentation();
        out.println("// This might throw a NullPointerException if the current element is null.");
        out.printIndentation();
        out.println("// This behavior is consistent with the OpenJDK streams implementation.");
        out.printIndentation();
        out.println("return " + optionalTypeUnqualified(inputType) + ".of(" + currentStreamElement + ");");
        out.decreaseIndentation();
        out.printIndentation();
        out.println("}");
    }

    @Override
    void emitPostamble(Emitter out, String inputType) {
        out.printIndentation();
        out.println("return " + optionalTypeUnqualified(inputType) + ".empty();");
    }

}
