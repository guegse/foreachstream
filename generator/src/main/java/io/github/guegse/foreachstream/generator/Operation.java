package io.github.guegse.foreachstream.generator;

import java.util.List;

public abstract class Operation {
    protected static int depth = 1;

    protected void decreaseDepth(Emitter out) {
        out.decreaseIndentation();
        out.printIndentation();
        out.println("}");
        depth--;
    }

    protected boolean isPrimitiveType(String inputType) {
        return inputType.equals("int") || inputType.equals("long") || inputType.equals("double");
    }

    protected void assertNonPrimitiveStream(String inputType) {
        if (isPrimitiveType(inputType)) {
            throw new UnsupportedOperationException();
        }
    }

    protected void assertCollectionStream(String inputType) {
        if (isPrimitiveType(inputType) || inputType.equals("Integer") || inputType.equals("Long") || inputType.equals("Double")) {
            throw new UnsupportedOperationException();
        }
    }

    protected String referenceType(String inputType) {
        return switch (inputType) {
            case "int" -> "Integer";
            case "long" -> "Long";
            case "double" -> "Double";
            default -> inputType;
        };
    }

    protected String predicateType(String inputType) {
        return switch (inputType) {
            case "int" -> "IntPredicate";
            case "long" -> "LongPredicate";
            case "double" -> "DoublePredicate";
            default -> "Predicate<" + inputType + ">";
        };
    }

    protected String consumerType(String inputType) {
        return switch (inputType) {
            case "int" -> "IntConsumer";
            case "long" -> "LongConsumer";
            case "double" -> "DoubleConsumer";
            default -> "Consumer<" + inputType + ">";
        };
    }

    protected String optionalType(String inputType) {
        return switch (inputType) {
            case "int" -> "OptionalInt";
            case "long" -> "OptionalLong";
            case "double" -> "OptionalDouble";
            default -> "Optional<" + inputType + ">";
        };
    }

    protected String optionalTypeUnqualified(String inputType) {
        return switch (inputType) {
            case "int" -> "OptionalInt";
            case "long" -> "OptionalLong";
            case "double" -> "OptionalDouble";
            default -> "Optional";
        };
    }

    protected String binaryOperatorType(String inputType) {
        return switch (inputType) {
            case "int" -> "IntBinaryOperator";
            case "long" -> "LongBinaryOperator";
            case "double" -> "DoubleBinaryOperator";
            default -> " BinaryOperator<" + inputType + ">";
        };
    }

    protected String applyType(String inputType) {
        return switch (inputType) {
            case "int" -> "applyAsInt";
            case "long" -> "applyAsLong";
            case "double" -> "applyAsDouble";
            default -> "apply";
        };
    }

    abstract boolean addTargetTypeToTypeParameterList();

    abstract String getTargetType(String inputType, String nextOutputType);

    String appendPreviousTargetType(String currentType) {
        return null;
    }

    abstract List<String> getArgumentTypes(String inputType, String nextOutputType);

    abstract String getName();

    abstract void emitPreamble(Emitter out, String inputType, List<String> arguments, String estimatedSize);

    abstract void emitShortCircuit(Emitter out, String inputType, List<String> arguments);

    abstract void emitOperation(Emitter out, String inputType, List<String> arguments, String currentStreamElement, String nextTargetType, String nextTargetElement);

    abstract void emitPostamble(Emitter out, String inputType, List<String> arguments);
}
