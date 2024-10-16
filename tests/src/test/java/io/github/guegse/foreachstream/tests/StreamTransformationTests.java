package io.github.guegse.foreachstream.tests;

import io.github.guegse.foreachstream.ForeachStreamCount;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentCaptor;
import org.mockito.MockedStatic;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class StreamTransformationTests {

    @FunctionalInterface
    interface StreamReplacement{
        long streamFilterCount(Integer[] numbers, Predicate<Integer> predicate);
    }

    private record SpliteratorToStream(Integer[] numbers) {
        public Stream<Integer> stream() {
            Spliterator<Integer> spliterator = Spliterators.spliterator(numbers, Spliterator.NONNULL);
            return StreamSupport.stream(spliterator, false);
        }
    }

    private static class SelfmadeStream<T> {
        private List<Integer> list;

        public SelfmadeStream(Integer[] numbers) {
            this.list = List.of(numbers);
        }

        public SelfmadeStream<T> filter(Predicate<? super T> predicate) {
            List<Integer> filtered = new ArrayList<>();
            for(int i : list) {
                filtered.add(i);
            }
            list = filtered;
            return this;
        }

        public long count() {
            return list.size();
        }

        public SelfmadeStream<T> stream() {
            return this;
        }
    }


    @ParameterizedTest(name = "{0}")
    @MethodSource("streamProvider")
    void testTypeSafetyOfStreamTransformation(String name, StreamReplacement replacement, boolean expected) {
        Integer[] numbers = {1, 2, 3, 4, 5};
        Predicate<Integer> predicate = x -> x % 2 == 0;

        try (MockedStatic<ForeachStreamCount> mockedStatic = mockStatic(ForeachStreamCount.class)) {
            replacement.streamFilterCount(numbers, predicate);

            if(expected){
                ArgumentCaptor<Collection<Integer>> collectionCaptor = ArgumentCaptor.forClass(Collection.class);
                ArgumentCaptor<Predicate<Integer>> predicateCaptor = ArgumentCaptor.forClass(Predicate.class);

                mockedStatic.verify(() -> ForeachStreamCount.stream_filter_count(collectionCaptor.capture(), predicateCaptor.capture()));
                assertEquals(Arrays.asList(numbers), collectionCaptor.getValue());
                assertEquals(predicate, predicateCaptor.getValue());
            } else {
                mockedStatic.verify(() -> ForeachStreamCount.stream_filter_count(anyCollection(), eq(predicate)), never());
            }
        }
    }

    static Stream<Arguments> streamProvider() {
        return Stream.of(
                Arguments.of("testSuccessfulTransformationWhenUsingStreams", (StreamReplacement) (numbers, predicate) -> {
                    List<Integer> list = Arrays.asList(numbers);
                    return list.stream().filter(predicate).count();
                }, true),
                Arguments.of("testFailedTransformationWhenUsingSpliteratorsAsStreams", (StreamReplacement) (numbers, predicate) -> {
                    SpliteratorToStream spliterator = new SpliteratorToStream(numbers);
                    return spliterator.stream().filter(predicate).count();
                }, false),
                Arguments.of("testFailedTransformationWhenUsingSelfmadeStreams", (StreamReplacement) (numbers, predicate) -> {
                    SelfmadeStream<Integer> selfmadeStream = new SelfmadeStream<>(numbers);
                    return selfmadeStream.stream().filter(predicate).count();
                }, false)
        );
    }
}
