package io.github.guegse.foreachstream.plugin;

import java.util.*;
import java.util.stream.Collectors;

public class Statistics {
    private static final String[] INTERMEDIATE_OPERATIONS_IMPLEMENTED = new String[] {
            "filter",
            "map",
            "mapToInt",
            "mapToLong",
            "mapToDouble",
            "mapToObj",
            "boxed",
    };
    private static final String[] TERMINAL_OPERATIONS_IMPLEMENTED = new String[] {
            "collectToList",
            "collectToSet",
            "forEach",
            "anyMatch",
            "allMatch",
            "noneMatch",
            "findFirst",
            "findAny",
            "min",
            "max",
            "sum",
            "count",
    };
    private int subCounter;
    private int subFailedCounter;
    private int typeCounter;
    private int arrayStreamCounter;
    private final Map<Integer, Integer> depthMap = new HashMap<>();
    private final Map<String, Integer> terminalMissMap = new HashMap<>();
    private final Map<String, Integer> intermediateMissMap = new HashMap<>();
    private final Map<String, Integer> terminalSubMap = new HashMap<>();
    private final Map<String, Integer> intermediateSubMap = new HashMap<>();
    private final Map<String, Integer> methodSubMap = new HashMap<>();
    private final Map<String, Integer> methodMissMap = new HashMap<>();

    private static final Statistics statistics = new Statistics();

    private Statistics() {

    }

    public static Statistics getInstance() {
        return statistics;
    }

    public void arrayStreamSource() {
        arrayStreamCounter++;
        subFailedCounter++;
    }

    public void substituted(String method) {
        subCounter++;
        incrementValue(methodSubMap, method);
        String[] operations = method.split("_");
        for(int i = 1; i < operations.length; i++) {
            String operation = operations[i];
            if(i == operations.length - 1) {
                incrementValue(terminalSubMap, operation);
            } else {
                incrementValue(intermediateSubMap, operation);
            }
        }
    }

    public void substitutionFailed(String method) {
        subFailedCounter++;
        incrementValue(methodMissMap, method);
        String[] operations = method.split("_");
        for(int i = 1; i < operations.length; i++) {
            String operation = operations[i];
            if(i == operations.length - 1) {
                if(!containsOperation(TERMINAL_OPERATIONS_IMPLEMENTED, operation)) {
                    statistics.terminalOperationMissing(operation);
                }
            } else {
                if(!containsOperation(INTERMEDIATE_OPERATIONS_IMPLEMENTED, operation)) {
                    statistics.intermediateOperationMissing(operation);
                }
            }
        }
        if(operations.length > 5) {
            incrementValue(depthMap, operations.length - 1);
        }
    }

    public void typeMismatch() {
        typeCounter++;
        subFailedCounter++;
    }

    private static <K> void incrementValue(Map<K, Integer> map, K key) {
        int count = map.getOrDefault(key, 0);
        map.put(key, count + 1);
    }

    public void terminalOperationMissing(String terminalOperation) {
        incrementValue(terminalMissMap, terminalOperation);
    }

    public void intermediateOperationMissing(String intermediateOperation) {
        incrementValue(intermediateMissMap, intermediateOperation);
    }

    private static <K, V extends Comparable<? super V>> Set<Map.Entry<K, V>> sortMapByValue(Map<K, V> map) {
        return map.entrySet().stream()
                .limit(20)
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    private static void addOperationsToStringBuilder(StringBuilder sb, Map<String, Integer> operations) {
        for(var entry : sortMapByValue(operations)) {
            sb.append("-> ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
    }

    private static void addDepthsToStringBuilder(StringBuilder sb, Map<Integer, Integer> operations) {
        for(var entry : sortMapByValue(operations)) {
            sb.append("-> ").append("Depth ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
    }

    private boolean containsOperation(String[] operations, String operation) {
        return Arrays.asList(operations).contains(operation);
    }

    private static <K> int sumMapValues(Map<K, Integer> map) {
        int sum = 0;
        for(int value : map.values()) {
            sum += value;
        }
        return sum;
    }

    public String printStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("========== FOREACHSTREAM STATISTICS =========\n");
        sb.append("Total Stream Calls found: ").append(subCounter + subFailedCounter).append("\n");
        sb.append("=============== SUBSTITUTIONS ===============\n");
        sb.append("Stream Calls substituted: ").append(subCounter).append("\n");
        addOperationsToStringBuilder(sb, methodSubMap);
        sb.append("Intermediate Operations substituted: ").append(sumMapValues(intermediateSubMap)).append("\n");
        addOperationsToStringBuilder(sb, intermediateSubMap);
        sb.append("Terminal Operations substituted: ").append(sumMapValues(terminalSubMap)).append("\n");
        addOperationsToStringBuilder(sb, terminalSubMap);
        sb.append("============ FAILED SUBSTITUTIONS ===========\n");
        sb.append("Stream Calls not substituted: ").append(subCounter).append("\n");
        addOperationsToStringBuilder(sb, methodMissMap);
        sb.append("Depth insufficient: ").append(sumMapValues(depthMap)).append("\n");
        addDepthsToStringBuilder(sb, depthMap);
        sb.append("Stream Type mismatches: ").append(typeCounter).append("\n");
        sb.append("Array Stream Sources: ").append(arrayStreamCounter).append("\n");
        sb.append("Intermediate Operations missing: ").append(sumMapValues(intermediateMissMap)).append("\n");
        addOperationsToStringBuilder(sb, intermediateMissMap);
        sb.append("Terminal Operations missing: ").append(sumMapValues(terminalMissMap)).append("\n");
        addOperationsToStringBuilder(sb, terminalMissMap);
        sb.append("=============================================\n");
        return sb.toString();
    }
}
