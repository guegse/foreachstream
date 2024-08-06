package io.github.guegse.sample;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
    }
}
