package io.github.guegse.sample;

import java.lang.management.ManagementFactory;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static io.github.guegse.sample.ForeachStream.*;

public class Sample {
    private static final int WIDTH = 15;
    private static final int TOTAL_WIDTH = WIDTH * 4 + 5;
    private static final List<Integer> LIST_SIZES = Arrays.asList(10, 100, 1000, 10_000, 100_000, 1_000_000, 2_000_000);
    private static final List<Integer> LIST_SIZES_ROOT = LIST_SIZES.stream().map(size -> (int) Math.ceil(Math.sqrt(size))).toList();
    private static final List<Integer> REPETITIONS =  Arrays.asList(2_000_000, 1_000_000, 100_000, 10_000, 1_000, 300, 200).stream().map(size -> size / 10 ).toList();
    private static final List<Integer> FLATMAP_REPETITIONS = REPETITIONS.stream().map(size -> size / 10).toList();

    /* ====================================== Map-Filter-CollectToList ====================================== */

    public static List<Integer> test_stream_map_filter_collect_toList(List<String> input) {
        return input.stream().map(Integer::valueOf).filter(i -> i > 6).collect(Collectors.toList());
    }

    public static List<Integer> test_stream_map_filter_collect_toList_foreachstream(List<String> input) {
        return stream_map_filter_collectCollector(input, Integer::valueOf, i -> i > 6, Collectors.toList());
    }

    public static List<Integer> test_stream_map_filter_collect_toList_foreach(List<String> input) {
        List<Integer> result = new ArrayList<>(input.size());
        for (String s : input) {
            int i = Integer.parseInt(s);
            if (i > 6) {
                result.add(i);
            }
        }
        return result;
    }

    /* ====================================== Filter-CollectToList ====================================== */

    public static List<String> test_stream_filter_collect_toList(List<String> input) {
        return input.stream().filter(s -> s.charAt(0) <= '6').collect(Collectors.toList());
    }

    public static List<String> test_stream_filter_collect_toList_foreachstream(List<String> input) {
        return stream_filter_collectCollector(input, s -> s.charAt(0) <= '6', Collectors.toList());
    }

    public static List<String> test_stream_filter_collect_toList_foreach(List<String> input) {
        List<String> result = new ArrayList<>(input.size());
        for (String s : input) {
            if (s.charAt(0) <= '6') {
                result.add(s);
            }
        }
        return result;
    }

    /* ====================================== Filter-ToList ====================================== */

    public static List<Integer> test_stream_map_toList(List<String> input) {
        return input.stream().map(s -> s.charAt(0) - '0').toList();
    }

    public static List<Integer> test_stream_map_toList_foreachstream(List<String> input) {
        return stream_map_toList(input, s -> s.charAt(0) - '0');
    }

    public static List<Integer> test_stream_map_toList_foreach(List<String> input) {
        List<Integer> result = new ArrayList<>(input.size());
        for (String s : input) {
            result.add(s.charAt(0) - '0');
        }
        return Collections.unmodifiableList(result);
    }

    /* ====================================== FlatMap-Map-Filter-FindFirst ====================================== */

    public static Optional<Integer> test_stream_flatMap_map_filter_findFirst(List<List<String>> input) {
        return input.stream().flatMap(list -> list.stream()).map(Integer::valueOf).filter(i -> i > 10).findFirst();
    }

    public static Optional<Integer> test_stream_flatMap_map_filter_findFirst_foreachstream(List<List<String>> input) {
        return stream_flatMapLambda_map_filter_findFirst(input, list -> list, Integer::valueOf, i -> i > 10);
    }

    public static Optional<Integer> test_stream_flatMap_map_filter_findFirst_foreach(List<List<String>> input) {
        for (List<String> list : input) {
            for (String s : list) {
                int i = Integer.parseInt(s);
                if (!(i > 10)) {
                    continue;
                }
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }

    /* ====================================== Map-ForEach ====================================== */

    public static List<Integer> test_stream_map_forEach(List<String> input) {
        ArrayList<Integer> list = new ArrayList<>(input.size());
        input.stream().map(Integer::valueOf).forEach(list::add);
        return list;
    }

    public static List<Integer> test_stream_map_forEach_foreachstream(List<String> input) {
        ArrayList<Integer> list = new ArrayList<>(input.size());
        stream_map_forEach(input, Integer::valueOf, list::add);
        return list;
    }

    public static List<Integer> test_stream_map_forEach_foreach(List<String> input) {
        ArrayList<Integer> list = new ArrayList<>(input.size());
        for (String s : input) {
            list.add(Integer.valueOf(s));
        }
        return list;
    }

    /* ====================================== FlatMap-MapToLong-Sum ====================================== */

    public static Long test_stream_flatMap_mapToLong_sum(List<List<String>> input) {
        return input.stream().flatMap(List::stream).mapToLong(Long::parseLong).sum();
    }

    public static Long test_stream_flatMap_mapToLong_sum_foreachstream(List<List<String>> input) {
        return stream_flatMapMemberReference_mapToLong_sum(input, Long::parseLong);
    }

    public static Long test_stream_flatMap_mapToLong_sum_foreach(List<List<String>> input) {
        long sum = 0;
        for (List<String> sublist : input) {
            for (String string : sublist) {
                sum += Long.parseLong(string);
            }
        }
        return sum;
    }

    /* ================================== Map-Sorted-Limit-AllMatch ================================= */

    public static boolean test_stream_map_sorted_limit_allMatch(List<String> input) {
        return input.stream().map(s -> s.length() > 1 ? s.substring(0, s.length() - 1) : s).sorted().limit(15).allMatch(s -> s.charAt(0) < '5');
    }

    public static boolean test_stream_map_sorted_limit_allMatch_foreachstream(List<String> input) {
        return stream_map_sorted_limit_allMatch(input, s -> s.length() > 1 ? s.substring(0, s.length() - 1) : s, 15, s -> s.charAt(0) < '5');
    }

    public static boolean test_stream_map_sorted_limit_allMatch_foreach(List<String> input) {
        List<String> sorted = new ArrayList<>(input.size());
        for(String s : input) {
            sorted.add(s.length() > 1 ? s.substring(0, s.length() - 1) : s);
        }
        sorted.sort(null);
        long limit = 0;
        for (String s : sorted) {
            if(limit >= 15) {
                break;
            }
            limit++;
            if (!(s.charAt(0) < '5')) {
                return false;
            }
        }
        return true;
    }

    /* ====================================== DropWhile-Skip-Map-Reduce ===================================== */

    public static int test_stream_takeWhile_skip_mapToInt_reduce(List<String> input) {
        return input.stream().takeWhile(s -> s.length() < 7).skip(10).mapToInt(Integer::parseInt).reduce(0, Integer::sum);
    }

    public static int test_stream_takeWhile_skip_mapToInt_reduce_foreachstream(List<String> input) {
        return stream_takeWhile_skip_mapToInt_reduce(input, s -> s.length() < 7, 10, Integer::parseInt, 0, Integer::sum);
    }

    public static int test_stream_takeWhile_skip_mapToInt_reduce_foreach(List<String> input) {
        long skip = 0;
        int result = 0;
        for (String s : input) {
            if(!(s.length() < 7)) {
                break;
            }
            skip++;
            if(skip <= 10) {
                continue;
            }
            result += Integer.parseInt(s);
        }
        return result;
    }

    /* ====================================== Skip-SortedComp-Limit-ReduceCombiner ===================================== */

    public static int test_stream_skip_sortedComp_limit_reduceCombiner(List<String> input) {
        return input.stream().skip(15).sorted(Collections.reverseOrder()).limit(8).reduce(0, (partialSum, element) -> partialSum + Integer.parseInt(element), Integer::sum);
    }

    public static int test_stream_skip_sortedComp_limit_reduceCombiner_foreachstream(List<String> input) {
        return stream_skip_sortedComp_limit_reduceCombiner(input, 15, Collections.reverseOrder(), 8, 0, (partialSum, element) -> partialSum + Integer.parseInt(element), Integer::sum);
    }

    public static int test_stream_skip_sortedComp_limit_reduceCombiner_foreach(List<String> input) {
        List<String> sortedComp = new ArrayList<>(input.size());
        for(int i = 15; i < input.size(); i++) {
            sortedComp.add(input.get(i));
        }
        sortedComp.sort(Collections.reverseOrder());
        int result = 0;
        for(int i = 0; i < sortedComp.size() && i < 8; i++) {
            result += Integer.parseInt(sortedComp.get(i));
        }
        return result;
    }

    /* ====================================== Distinct-MapToDouble-Max ===================================== */

    public static OptionalDouble test_stream_distinct_mapToDouble_max(List<String> input) {
        return input.stream().distinct().mapToDouble(Double::parseDouble).max();
    }

    public static OptionalDouble test_stream_distinct_mapToDouble_max_foreachstream(List<String> input) {
        return stream_distinct_mapToDouble_max(input, Double::parseDouble);
    }

    public static OptionalDouble test_stream_distinct_mapToDouble_max_foreach(List<String> input) {
        Set<String> distinct0 = new HashSet<>(input.size());
        double max = 0;
        boolean hasMax = false;
        for (String s : input) {
            if(!distinct0.add(s)) {
                continue;
            }
            double t1 = Double.parseDouble(s);
            if (hasMax) {
                max = Math.max(max, t1);
            } else {
                hasMax = true;
                max = t1;
            }
        }
        if (hasMax) {
            return OptionalDouble.of(max);
        }
        return OptionalDouble.empty();
    }

    /* ================================================================================================== */

    private record TestTuple<T>(String name, Function<T, Object> stream, Function<T, Object> foreachstream,
                                Function<T, Object> foreach, InputType<T> inputType) {}

    private record TestResult(long runtime, long allocatedBytes) {}

    private interface InputType<T> {}

    private static class Plain implements InputType<List<String>> {}
    private static class FlatMap implements InputType<List<List<String>>> {}

    private static final TestTuple[] TESTS = new TestTuple[] {
            new TestTuple<>("stream_map_filter_collectToList", Sample::test_stream_map_filter_collect_toList, Sample::test_stream_map_filter_collect_toList_foreachstream, Sample::test_stream_map_filter_collect_toList_foreach, new Plain()),
            new TestTuple<>("stream_filter_collectToList", Sample::test_stream_filter_collect_toList, Sample::test_stream_filter_collect_toList_foreachstream, Sample::test_stream_filter_collect_toList_foreach, new Plain()),
            new TestTuple<>("stream_map_toList", Sample::test_stream_map_toList, Sample::test_stream_map_toList_foreachstream, Sample::test_stream_map_toList_foreach, new Plain()),
            new TestTuple<>("stream_flatMap_map_filter_findFirst", Sample::test_stream_flatMap_map_filter_findFirst, Sample::test_stream_flatMap_map_filter_findFirst_foreachstream, Sample::test_stream_flatMap_map_filter_findFirst_foreach, new FlatMap()),
            new TestTuple<>("stream_map_forEach", Sample::test_stream_map_forEach, Sample::test_stream_map_forEach_foreachstream, Sample::test_stream_map_forEach_foreach, new Plain()),
            new TestTuple<>("stream_flatMap_mapToLong_sum", Sample::test_stream_flatMap_mapToLong_sum, Sample::test_stream_flatMap_mapToLong_sum_foreachstream, Sample::test_stream_flatMap_mapToLong_sum_foreach, new FlatMap()),
            new TestTuple<>("stream_map_sorted_limit_allMatch", Sample::test_stream_map_sorted_limit_allMatch, Sample::test_stream_map_sorted_limit_allMatch_foreachstream, Sample::test_stream_map_sorted_limit_allMatch_foreach, new Plain()),
            new TestTuple<>("stream_takeWhile_skip_map_reduce", Sample::test_stream_takeWhile_skip_mapToInt_reduce, Sample::test_stream_takeWhile_skip_mapToInt_reduce_foreachstream, Sample::test_stream_takeWhile_skip_mapToInt_reduce_foreach, new Plain()),
            new TestTuple<>("stream_skip_sortedComp_limit_reduceCombiner", Sample::test_stream_skip_sortedComp_limit_reduceCombiner, Sample::test_stream_skip_sortedComp_limit_reduceCombiner_foreachstream, Sample::test_stream_skip_sortedComp_limit_reduceCombiner_foreach, new Plain()),
            new TestTuple<>("stream_distinct_mapToDouble_max", Sample::test_stream_distinct_mapToDouble_max, Sample::test_stream_distinct_mapToDouble_max_foreachstream, Sample::test_stream_distinct_mapToDouble_max_foreach, new Plain())
    };

    private static int getMaxSize(List<Integer> sizes) {
        return sizes.stream().mapToInt(Integer::intValue).max().getAsInt();
    }

    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        for (int i = 0; i < getMaxSize(LIST_SIZES); i++) {
            input.add(String.valueOf(i));
        }
        List<List<String>> flatMapInput = new ArrayList<>();
        for (int i = 0; i < getMaxSize(LIST_SIZES_ROOT); i++) {
            List<String> inner = new ArrayList<>();
            for (int j = 0; j < getMaxSize(LIST_SIZES_ROOT); j++) {
                inner.add(String.valueOf(i + j));
            }
            flatMapInput.add(inner);
        }

        for (TestTuple testTuple : TESTS) {
            boolean testsPassed = true;
            System.out.println("Running test " + testTuple.name);
            System.out.printf("%-" + TOTAL_WIDTH + "s", "Runtime in Nano Seconds");
            printGap();
            System.out.printf("%-" + TOTAL_WIDTH + "s", "Allocated Bytes");
            System.out.println();
            printBorder();
            printGap();
            printBorder();
            System.out.println();
            printHeader(List.of("Elements", "Streams", "ForeachStream", "Foreach"));
            printGap();
            printHeader(List.of("Elements", "Streams", "ForeachStream", "Foreach"));
            System.out.println();
            for (int i = 0; i < LIST_SIZES.size(); i++) {
                List collection = null;
                int repetitions = 0;
                if(testTuple.inputType instanceof Plain) {
                    collection = input.subList(0, LIST_SIZES.get(i));
                    repetitions = REPETITIONS.get(i);
                } else if(testTuple.inputType instanceof FlatMap) {
                    collection = flatMapInput.subList(0, LIST_SIZES_ROOT.get(i));
                    repetitions = FLATMAP_REPETITIONS.get(i);
                }
                if(testsPassed && !checkResults(testTuple, collection)) {
                    testsPassed = false;
                }
                List<TestResult> testResults = List.of(
                        runTest(testTuple.stream, collection, repetitions),
                        runTest(testTuple.foreachstream, collection, repetitions),
                        runTest(testTuple.foreach, collection, repetitions)
                );
                printRow(collection.size(), testResults.stream().map(result -> result.runtime).toList());
                printGap();
                printRow(collection.size(), testResults.stream().map(result -> result.allocatedBytes).toList());
                System.out.println();
            }
            printBorder();
            printGap();
            printBorder();
            System.out.println();
            if(testsPassed) {
                System.out.println("Test passed!");
            } else {
                System.out.println("Test failed!");
            }
            System.out.println();
        }
    }

    private static void printColumn(String stringFormat) {
        System.out.print("|" + stringFormat);
    }

    private static void printHeader(List<String> header) {
        for(var h : header) {
            printColumn(String.format("%" + WIDTH + "s", h));
        }
        System.out.print("|");
    }

    private static void printRow(int elements, List<Long> values) {
        printColumn(String.format("%," + WIDTH + "d", elements));
        for(var value : values) {
            printColumn(String.format("%," + WIDTH + "d", value));
        }
        System.out.print("|");
    }

    private static void printBorder() {
        System.out.print("=".repeat(TOTAL_WIDTH));
    }

    private static void printGap() {
        System.out.print(" ".repeat(4));
    }

    private static <T> boolean checkResults(TestTuple testTuple, T input) {
        var foreachResult = testTuple.foreach.apply(input);
        var foreachStreamResult = testTuple.foreachstream.apply(input);
        var streamResult = testTuple.stream.apply(input);
        return foreachResult.equals(foreachStreamResult) && foreachStreamResult.equals(streamResult);
    }

    private static <T> TestResult runTest(Function<T, Object> meth, T input, int repetitions) {
        com.sun.management.ThreadMXBean mxBean = (com.sun.management.ThreadMXBean) ManagementFactory.getThreadMXBean();
        long runtime = 0;
        long allocatedBytes = 0;
        for(int i = 0; i < repetitions; i++) {
            long startBytes = mxBean.getCurrentThreadAllocatedBytes();
            long startTime = System.nanoTime();
            meth.apply(input);
            long endTime = System.nanoTime();
            long endBytes = mxBean.getCurrentThreadAllocatedBytes();
            runtime += endTime - startTime;
            allocatedBytes += endBytes - startBytes;
        }
        return new TestResult(runtime / repetitions, allocatedBytes / repetitions);
    }
}
