package io.github.guegse.foreachstream.plugin;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Statistics implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String[] INTERMEDIATE_OPERATIONS_IMPLEMENTED = new String[] {
            "filter",
            "map",
            "mapToInt",
            "mapToLong",
            "mapToDouble",
            "mapToObj",
            "boxed",
            "sorted",
            "sortedComp",
            "distinct",
            "skip",
            "limit",
            "flatMapLambda",
            "flatMapMemberReference"
    };
    private static final String[] TERMINAL_OPERATIONS_IMPLEMENTED = new String[] {
            "collectCollector",
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
            "toList"
    };
    private int subCounter;
    private int subFailedCounter;
    private int typeCounter;
    private Map<Integer, Integer> depthMap = new HashMap<>();
    private Map<String, Integer> terminalMissMap = new HashMap<>();
    private Map<String, Integer> intermediateMissMap = new HashMap<>();
    private Map<String, Integer> terminalSubMap = new HashMap<>();
    private Map<String, Integer> intermediateSubMap = new HashMap<>();
    private Map<String, Integer> methodSubMap = new HashMap<>();
    private Map<String, Integer> methodMissMap = new HashMap<>();

    private static final String appDataPath = Paths.get(System.getenv("LOCALAPPDATA"), "ForeachStream").toString();

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
                    terminalOperationMissing(operation);
                }
            } else {
                if(!containsOperation(INTERMEDIATE_OPERATIONS_IMPLEMENTED, operation)) {
                    intermediateOperationMissing(operation);
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

    public static <K> Map<K, Integer> mergeMaps(Map<K, Integer> map1, Map<K, Integer> map2) {
        Map<K, Integer> combinedMap = new HashMap<>(map1);
        map2.forEach((key, value) -> combinedMap.merge(key, value, Integer::sum));
        return combinedMap;
    }

    private void add(Statistics statistics) {
        if(statistics == null) return;
        this.subCounter += statistics.subCounter;
        this.subFailedCounter += statistics.subFailedCounter;
        this.typeCounter += statistics.typeCounter;

        depthMap = mergeMaps(depthMap, statistics.depthMap);
        terminalMissMap = mergeMaps(terminalMissMap, statistics.terminalMissMap);
        intermediateMissMap = mergeMaps(intermediateMissMap, statistics.intermediateMissMap);
        terminalSubMap = mergeMaps(terminalSubMap, statistics.terminalSubMap);
        intermediateSubMap = mergeMaps(intermediateSubMap, statistics.intermediateSubMap);
        methodSubMap = mergeMaps(methodSubMap, statistics.methodSubMap);
        methodMissMap = mergeMaps(methodMissMap, statistics.methodMissMap);
    }

    public static String evaluateStatistics(String rootProjectPath) {
        String folderPath = Paths.get(appDataPath, rootProjectPath.hashCode()+"").toString();
        File folder = new File(folderPath);
        if(!folder.isDirectory() || folder.listFiles() == null) return null;
        Statistics result = new Statistics();
        for (File file : folder.listFiles()) {
            if (file.isFile()) {
                try (FileInputStream fis = new FileInputStream(file);
                     ObjectInputStream ois = new ObjectInputStream(fis)) {
                    result.add((Statistics) ois.readObject());
                } catch (IOException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        return result.printStatistics();
    }

    public void writeToFile(String rootProjectPath, String projectPath, String taskName) {
        String folderHash = rootProjectPath.hashCode() + "";
        String fileHash = (projectPath + taskName).hashCode() + "";
        String folderPath = Paths.get(appDataPath, folderHash).toString();

        File folder = new File(folderPath);
        folder.mkdirs();

        File file = new File(folder, fileHash);
        try (FileOutputStream fileOut = new FileOutputStream(file);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(this);
            out.flush();
        } catch (IOException i) {
            i.printStackTrace();
        }
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
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(20)
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
        sb.append("Stream Calls not substituted: ").append(subFailedCounter).append("\n");
        addOperationsToStringBuilder(sb, methodMissMap);
        sb.append("Depth insufficient: ").append(sumMapValues(depthMap)).append("\n");
        addDepthsToStringBuilder(sb, depthMap);
        sb.append("Type mismatches: ").append(typeCounter).append("\n");
        sb.append("Intermediate Operations missing: ").append(sumMapValues(intermediateMissMap)).append("\n");
        addOperationsToStringBuilder(sb, intermediateMissMap);
        sb.append("Terminal Operations missing: ").append(sumMapValues(terminalMissMap)).append("\n");
        addOperationsToStringBuilder(sb, terminalMissMap);
        sb.append("=============================================\n");
        return sb.toString();
    }
}
