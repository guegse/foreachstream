package io.github.guegse.foreachstream.generator;

abstract class Operation {
    protected void assertNonPrimitiveStream(String inputType) {
        if (inputType.equals("int") || inputType.equals("long") || inputType.equals("double")) {
            throw new UnsupportedOperationException();
        }
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

    abstract String getTargetType(String inputType, String nextOutputType);

    abstract String getArgumentType(String inputType, String nextOutputType);

    abstract String getName();

    abstract boolean hasArgument();

    abstract void emitPreamble(Emitter out, String inputType, String estimatedSize);

    abstract void emitOperation(Emitter out, String inputType, String argument, String currentStreamElement, String nextTargetType, String nextTargetElement);

    abstract void emitPostamble(Emitter out, String inputType);
}
