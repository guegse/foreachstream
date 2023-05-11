package io.github.guegse.sample;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Sample {

    private static final int LIST_SIZE = 10;
    private static final int LIST_SIZE_ROOT = (int) Math.ceil(Math.sqrt(LIST_SIZE));

    public static void debug() {

    }

    private static List<Integer> test_stream_map_filter_collect_toList(List<String> input) {
        return input.stream().map(Integer::valueOf).filter(i -> i > 6).collect(Collectors.toList());
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

    private static List<String> test_stream_filter_collect_toList(List<String> input) {
        return input.stream().filter(s -> s.charAt(0) <= '6').collect(Collectors.toList());
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

    private static Set<String> test_stream_filter_collect_toSet(List<String> input) {
        return input.stream().filter(s -> s.charAt(0) <= '6').collect(Collectors.toSet());
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

    private static Set<Integer> test_stream_flatMap_map_collect_toSet(List<List<String>> input) {
        return input.stream().flatMap(List::stream).map(Integer::valueOf).collect(Collectors.toSet());
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

    private static List<Integer> test_stream_map_forEach(List<String> input) {
        ArrayList<Integer> list = new ArrayList<>(input.size());
        input.stream().map(Integer::valueOf).forEach(list::add);
        return list;
    }

    private static List<Integer> test_stream_map_forEach_foreach(List<String> input) {
        ArrayList<Integer> list = new ArrayList<>(input.size());
        for (String s : input) {
            list.add(Integer.valueOf(s));
        }
        return list;
    }

    private static Integer test_stream_flatMap_mapToInt_sum(List<List<String>> input) {
        return input.stream().flatMap(List::stream).mapToInt(Integer::parseInt).sum();
    }

    private static Integer test_stream_flatMap_mapToInt_sum_forEach(List<List<String>> input) {
        int sum = 0;
        for (List<String> sublist : input) {
            for (String string : sublist) {
                sum += Integer.parseInt(string);
            }
        }
        return sum;
    }

    private static class TestPair<T> {
        private final String name;
        private final Function<T, Object> stream;
        private final Function<T, Object> foreach;
        private final InputType<T> inputType;

        private TestPair(String name, Function<T, Object> stream, Function<T, Object> foreach, InputType<T> inputType) {
            this.name = name;
            this.stream = stream;
            this.foreach = foreach;
            this.inputType = inputType;
        }
    }

    private interface InputType<T> {
    }

    private static class Plain implements InputType<List<String>> {}
    private static class FlatMap implements InputType<List<List<String>>> {}

    private static final TestPair[] TESTS = new TestPair[] {
            new TestPair<>("test_stream_filter_toList", Sample::test_stream_filter_collect_toList, Sample::test_stream_filter_collect_toList_foreach, new Plain()),
            new TestPair<>("test_stream_map_filter_toList", Sample::test_stream_map_filter_collect_toList, Sample::test_stream_map_filter_collect_toList_foreach, new Plain()),
            new TestPair<>("test_stream_filter_toSet", Sample::test_stream_filter_collect_toSet, Sample::test_stream_filter_collect_toSet_foreach, new Plain()),
            new TestPair<>("test_stream_map_forEach", Sample::test_stream_map_forEach, Sample::test_stream_map_forEach_foreach, new Plain()),
            new TestPair<>("test_stream_flatMap_map_collect_toSet", Sample::test_stream_flatMap_map_collect_toSet, Sample::test_stream_flatMap_map_collect_toSet_foreach, new FlatMap()),
            new TestPair<>("test_stream_flatMap_mapToInt_sum", Sample::test_stream_flatMap_mapToInt_sum, Sample::test_stream_flatMap_mapToInt_sum_forEach, new FlatMap()),
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

        int count = 0;
        for (int i = 0; i < 10_000_000; i++) {
            for (TestPair testPair : TESTS) {
                if (testPair.inputType instanceof Plain) {
                    count += getCount(testPair.foreach.apply(input));
                    count += getCount(testPair.stream.apply(input));
                } else {
                    count += getCount(testPair.foreach.apply(flatMapInput));
                    count += getCount(testPair.stream.apply(flatMapInput));
                }
            }
        }
        System.out.println("Checksum: " + count);

        int numRuns = 60_000_000;

        for (TestPair testPair : TESTS) {
            System.out.println("Running test " + testPair.name);

            long start = System.currentTimeMillis();
            long countForeach = 0;
            for (int i = 0; i < numRuns; i++) {
                if (testPair.inputType instanceof Plain) {
                    countForeach += getCount(testPair.foreach.apply(input));
                } else {
                    countForeach += getCount(testPair.foreach.apply(flatMapInput));
                }
            }
            long end = System.currentTimeMillis();
            System.out.println("foreach: " + (end - start) + "ms      " + countForeach);

            start = System.currentTimeMillis();
            long countStream = 0;
            for (int i = 0; i < numRuns; i++) {
                if (testPair.inputType instanceof Plain) {
                    countStream += getCount(testPair.stream.apply(input));
                } else {
                    countStream += getCount(testPair.stream.apply(flatMapInput));
                }
            }
            end = System.currentTimeMillis();
            System.out.println("streams: " + (end - start) + "ms       " + countStream);
        }

    }

    private static int getCount(Object result) {
        if (result instanceof Collection collection) {
            return collection.size();
        } else if (result instanceof Integer integer) {
            return integer;
        }
        throw new UnsupportedOperationException(result.getClass().getName());
    }
}
