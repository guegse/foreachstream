package io.github.guegse.sample;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static io.github.guegse.sample.ForeachStream.*;

public class Sample {
    private static final int WIDTH = 15;
    private static final int REPETITIONS = 20;
    private static final int LIST_SIZE = 10_000_000;
    private static final int LIST_SIZE_ROOT = (int) Math.ceil(Math.sqrt(LIST_SIZE));

    /* ====================================== Map-Filter-CollectToList ====================================== */

    private static List<Integer> test_stream_map_filter_collect_toList(List<String> input) {
        return input.stream().map(Integer::valueOf).filter(i -> i > 6).collect(Collectors.toList());
    }

    private static List<Integer> test_stream_map_filter_collect_toList_foreachstream(List<String> input) {
        return stream_map_filter_collectCollector(input, Integer::valueOf, i -> i > 6, Collectors.toList());
    }

    private static List<Integer> test_stream_map_filter_collect_toList_foreach(List<String> input) {
        List<Integer> result = new ArrayList<>();
        for (String s : input) {
            Integer i = Integer.valueOf(s);
            if (i > 6) {
                result.add(i);
            }
        }
        return result;
    }

    /* ====================================== Filter-CollectToList ====================================== */

    private static List<String> test_stream_filter_collect_toList(List<String> input) {
        return input.stream().filter(s -> s.charAt(0) <= '6').collect(Collectors.toList());
    }

    private static List<String> test_stream_filter_collect_toList_foreachstream(List<String> input) {
        return stream_filter_collectCollector(input, s -> s.charAt(0) <= '6', Collectors.toList());
    }

    private static List<String> test_stream_filter_collect_toList_foreach(List<String> input) {
        List<String> result = new ArrayList<>();
        for (String s : input) {
            if (s.charAt(0) <= '6') {
                result.add(s);
            }
        }
        return result;
    }

    /* ====================================== Filter-ToList ====================================== */

    private static List<String> test_stream_filter_toList(List<String> input) {
        return input.stream().filter(s -> s.charAt(0) <= '6').toList();
    }

    private static List<String> test_stream_filter_toList_foreachstream(List<String> input) {
        return stream_filter_toList(input, s -> s.charAt(0) <= '6');
    }

    private static List<String> test_stream_filter_toList_foreach(List<String> input) {
        List<String> result = new ArrayList<>();
        for (String s : input) {
            if (s.charAt(0) <= '6') {
                result.add(s);
            }
        }
        return Collections.unmodifiableList(result);
    }

    /* ====================================== Filter-CollectToSet ====================================== */

    private static Set<String> test_stream_filter_collect_toSet(List<String> input) {
        return input.stream().filter(s -> s.charAt(0) <= '6').collect(Collectors.toSet());
    }

    private static Set<String> test_stream_filter_collect_toSet_foreachstream(List<String> input) {
        return stream_filter_collectCollector(input, s -> s.charAt(0) <= '6', Collectors.toSet());
    }

    private static Set<String> test_stream_filter_collect_toSet_foreach(List<String> input) {
        Set<String> result = new HashSet<>();
        for (String s : input) {
            if (s.charAt(0) <= '6') {
                result.add(s);
            }
        }
        return result;
    }

    /* ====================================== FlatMap-Map-CollectToSet ====================================== */

    private static Set<Integer> test_stream_flatMap_map_collect_toSet(List<List<String>> input) {
        return input.stream().flatMap(list -> list.stream()).map(Integer::valueOf).collect(Collectors.toSet());
    }

    private static Set<Integer> test_stream_flatMap_map_collect_toSet_foreachstream(List<List<String>> input) {
        return stream_flatMapLambda_map_collectCollector(input, list -> list, Integer::valueOf, Collectors.toSet());
    }

    private static Set<Integer> test_stream_flatMap_map_collect_toSet_foreach(List<List<String>> input) {
        Set<Integer> result = new HashSet<>();
        for (List<String> l : input) {
            for (String s : l) {
                result.add(Integer.valueOf(s));
            }
        }
        return result;
    }

    /* ====================================== Map-ForEach ====================================== */

    private static List<Integer> test_stream_map_forEach(List<String> input) {
        ArrayList<Integer> list = new ArrayList<>(input.size());
        input.stream().map(Integer::valueOf).forEach(list::add);
        return list;
    }

    private static List<Integer> test_stream_map_forEach_foreachstream(List<String> input) {
        ArrayList<Integer> list = new ArrayList<>(input.size());
        stream_map_forEach(input, Integer::valueOf, list::add);
        return list;
    }

    private static List<Integer> test_stream_map_forEach_foreach(List<String> input) {
        ArrayList<Integer> list = new ArrayList<>(input.size());
        for (String s : input) {
            list.add(Integer.valueOf(s));
        }
        return list;
    }

    /* ====================================== FlatMap-MapToInt-Sum ====================================== */

    private static Integer test_stream_flatMap_mapToInt_sum(List<List<String>> input) {
        return input.stream().flatMap(List::stream).mapToInt(Integer::parseInt).sum();
    }

    private static Integer test_stream_flatMap_mapToInt_sum_foreachstream(List<List<String>> input) {
        return stream_flatMapMemberReference_mapToInt_sum(input, Integer::parseInt);
    }

    private static Integer test_stream_flatMap_mapToInt_sum_foreach(List<List<String>> input) {
        int sum = 0;
        for (List<String> sublist : input) {
            for (String string : sublist) {
                sum += Integer.parseInt(string);
            }
        }
        return sum;
    }

    /* ================================== Sorted-Limit-AllMatch ================================= */

    private static boolean test_stream_sorted_limit_allMatch(List<String> input) {
        return input.stream().sorted().limit(15).allMatch(s -> s.charAt(0) < '5');
    }

    private static boolean test_stream_sorted_limit_allMatch_foreachstream(List<String> input) {
        return stream_sorted_limit_allMatch(input, 15, s -> s.charAt(0) < '5');
    }

    private static boolean test_stream_sorted_limit_allMatch_foreach(List<String> input) {
        List<String> sorted = new ArrayList<>(input);
        Collections.sort(sorted);
        long limit = 0;
        for (String s : sorted) {
            limit++;
            if(limit > 15) {
                break;
            }
            if (!(s.charAt(0) < '5')) {
                return false;
            }
        }
        return true;
    }

    /* ====================================== DropWhile-Skip-Map-Reduce ===================================== */

    private static int test_stream_takeWhile_skip_map_reduce(List<String> input) {
        return input.stream().takeWhile(s -> s.length() < 7).skip(10).map(Integer::parseInt).reduce(0, Integer::sum);
    }

    private static int test_stream_takeWhile_skip_map_reduce_foreachstream(List<String> input) {
        return stream_takeWhile_skip_map_reduce(input, s -> s.length() < 7, 10, Integer::parseInt, 0, Integer::sum);
    }

    private static int test_stream_takeWhile_skip_map_reduce_foreach(List<String> input) {
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

    /* ================================================================================================== */

    private record TestTuple<T>(String name, Function<T, Object> stream, Function<T, Object> foreachstream,
                                Function<T, Object> foreach, InputType<T> inputType) {}

    private interface InputType<T> {}

    private static class Plain implements InputType<List<String>> {}
    private static class FlatMap implements InputType<List<List<String>>> {}

    private static final TestTuple[] TESTS = new TestTuple[] {
            new TestTuple<>("stream_filter_collectToList", Sample::test_stream_filter_collect_toList, Sample::test_stream_filter_collect_toList_foreachstream, Sample::test_stream_filter_collect_toList_foreach, new Plain()),
            new TestTuple<>("stream_filter_toList", Sample::test_stream_filter_toList, Sample::test_stream_filter_toList_foreachstream, Sample::test_stream_filter_toList_foreach, new Plain()),
            new TestTuple<>("stream_filter_collectToSet", Sample::test_stream_filter_collect_toSet, Sample::test_stream_filter_collect_toSet_foreachstream, Sample::test_stream_filter_collect_toSet_foreach, new Plain()),
            new TestTuple<>("stream_map_filter_collectToList", Sample::test_stream_map_filter_collect_toList, Sample::test_stream_map_filter_collect_toList_foreachstream, Sample::test_stream_map_filter_collect_toList_foreach, new Plain()),
            new TestTuple<>("stream_map_forEach", Sample::test_stream_map_forEach, Sample::test_stream_map_forEach_foreachstream, Sample::test_stream_map_forEach_foreach, new Plain()),
            new TestTuple<>("stream_flatMap_map_collectToSet", Sample::test_stream_flatMap_map_collect_toSet, Sample::test_stream_flatMap_map_collect_toSet_foreachstream, Sample::test_stream_flatMap_map_collect_toSet_foreach, new FlatMap()),
            new TestTuple<>("stream_flatMap_mapToInt_sum", Sample::test_stream_flatMap_mapToInt_sum, Sample::test_stream_flatMap_mapToInt_sum_foreachstream, Sample::test_stream_flatMap_mapToInt_sum_foreach, new FlatMap()),
            new TestTuple<>("stream_sorted_limit_allMatch", Sample::test_stream_sorted_limit_allMatch, Sample::test_stream_sorted_limit_allMatch_foreachstream, Sample::test_stream_sorted_limit_allMatch_foreach, new Plain()),
            new TestTuple<>("stream_takeWhile_skip_map_reduce", Sample::test_stream_takeWhile_skip_map_reduce, Sample::test_stream_takeWhile_skip_map_reduce_foreachstream, Sample::test_stream_takeWhile_skip_map_reduce_foreach, new Plain()),
    };

    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        for (int i = 0; i < LIST_SIZE; i++) {
            input.add(String.valueOf(i));
        }
        List<List<String>> flatMapInput = new ArrayList<>();
        for (int i = 0; i < LIST_SIZE_ROOT; i++) {
            List<String> inner = new ArrayList<>();
            for (int j = 0; j < LIST_SIZE_ROOT; j++) {
                inner.add(String.valueOf(j));
            }
            flatMapInput.add(inner);
        }

        List<Integer> listSizes = Arrays.asList(2_000_000, 1_000_000, 100_000, 10_000, 1000, 100, 10);
        List<Integer> rootListSizes = new ArrayList<>();
        for(int size : listSizes) {
            rootListSizes.add((int) Math.ceil(Math.sqrt(size)));
        }

        for (TestTuple testTuple : TESTS) {
            boolean testsPassed = true;
            System.out.println("Running test " + testTuple.name);
            printBorder();
            printRow(List.of("Elements", "Streams", "ForeachStream", "Foreach"));
            for (int i = 0; i < listSizes.size(); i++) {
                if(testsPassed && !checkResults(testTuple, input.subList(0, listSizes.get(i)), flatMapInput.subList(0, rootListSizes.get(i)))) {
                    testsPassed = false;
                }
                printRow(List.of(
                    listSizes.get(i),
                    runTest(testTuple.stream, testTuple.inputType, input.subList(0, listSizes.get(i)), flatMapInput.subList(0, rootListSizes.get(i))),
                    runTest(testTuple.foreachstream, testTuple.inputType, input.subList(0, listSizes.get(i)), flatMapInput.subList(0, rootListSizes.get(i))),
                    runTest(testTuple.foreach, testTuple.inputType, input.subList(0, listSizes.get(i)), flatMapInput.subList(0, rootListSizes.get(i)))
                ));
            }
            printBorder();
            if(!testsPassed) {
                System.out.println("Test failed!");
            }
            System.out.println();
        }
    }

    private static <T> void printRow(List<T> columns) {
        for(var col : columns) {
            String stringFormat;
            if(col instanceof Number number) {
                stringFormat = String.format("%," + WIDTH + "d", number.longValue());
            } else {
                stringFormat = String.format("%" + WIDTH + "s", col);
            }
            System.out.print("|" + stringFormat);
        }
        System.out.println("|");
    }

    private static void printBorder() {
        System.out.println("=".repeat(WIDTH * 4 + 5));
    }

    private static <T> boolean checkResults(TestTuple testTuple, T input, T flatMapInput) {
        T collection;
        if (testTuple.inputType instanceof Plain) {
            collection = input;
        } else {
            collection = flatMapInput;
        }
        var foreachResult = testTuple.foreach.apply(collection);
        var foreachStreamResult = testTuple.foreachstream.apply(collection);
        var streamResult = testTuple.stream.apply(collection);
        return foreachResult.equals(foreachStreamResult) && foreachStreamResult.equals(streamResult);
    }

    private static <T> long runTest(Function<T, Object> meth, InputType<T> inputType, T input, T flatMapInput) {
        long sum = 0;
        for(int i = 0; i < REPETITIONS; i++) {
            long start = System.nanoTime();
            if (inputType instanceof Plain) {
                meth.apply(input);
            } else {
                meth.apply(flatMapInput);
            }
            long end = System.nanoTime();
            sum += end - start;
        }
        return sum / REPETITIONS;
    }
}
