package io.github.guegse.foreachstream.generator;

abstract class Operation {
    protected static int depth = 1;

    protected void decreaseDepth(Emitter out) {
        out.decreaseIndentation();
        out.printIndentation();
        out.println("}");
        depth--;
    }

    protected void assertNonPrimitiveStream(String inputType) {
        if (inputType.equals("int") || inputType.equals("long") || inputType.equals("double")) {
            throw new UnsupportedOperationException();
        }
    }

    protected void assertCollectionStream(String inputType) {
        if (inputType.equals("int") || inputType.equals("long") || inputType.equals("double")
                || inputType.equals("Integer") || inputType.equals("Long") || inputType.equals("Double")) {
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

    abstract String getTargetType(String inputType, String nextOutputType);

    String appendPreviousTargetType(String currentType) {
        return null;
    }

    abstract String getArgumentType(String inputType, String nextOutputType);

    abstract String getName();

    abstract boolean hasArgument();

    abstract void emitPreamble(Emitter out, String inputType, String argument, String estimatedSize);

    abstract void emitOperation(Emitter out, String inputType, String argument, String currentStreamElement, String nextTargetType, String nextTargetElement);

    abstract void emitPostamble(Emitter out, String inputType, String argument);
}
