package io.github.guegse.sample;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    private static class StreamTest {
        public StreamTest stream() {
            return this;
        }
        public StreamTest filter(Predicate<String> predicate) {
            return this;
        }
        public StreamTest count() {
            return this;
        }
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("a", "d", "f");
        input.stream().filter(s -> s.charAt(0) <= '6').collect(Collectors.toSet());
        StreamTest streamTest = new StreamTest();
        streamTest.stream().filter(s -> s.charAt(0) <= '6').count();

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = list.stream().filter(i -> i % 2 == 0).mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        List<String> list2 = Arrays.asList("asdf", "sdfgh", "ksfg", "gfg");
        list2.stream()
                .flatMap(str -> Stream.of(str.charAt(2)))
                .filter(i -> i % 2 == 0)
                .filter(i -> i % 2 == 0)
                .forEach(System.out::println);
        list2.stream().collect(Collectors.joining(",", "{", "}"));
        sum = list.stream().filter(i -> i % 2 == 0).filter(i -> i % 2 == 0).filter(i -> i % 2 == 0).mapToInt(Integer::intValue).sum();
    }
}
