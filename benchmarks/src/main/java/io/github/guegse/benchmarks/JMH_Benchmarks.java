package io.github.guegse.benchmarks;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.profile.GCProfiler;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static io.github.guegse.benchmarks.ForeachStream.*;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 2, time = 10, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 4, time = 15, timeUnit = TimeUnit.SECONDS)
@Fork(2)
public class JMH_Benchmarks {

    /* ====================================== Input Initialization ====================================== */

    @Param({"1", "10", "100", "1000", "10000", "100000" , "1000000"})
    private int size;

    private List<String> input;
    private List<List<String>> flatMapInput;

    @Setup
    public void setUpInput() {
        input = java.util.stream.IntStream.range(0, size)
                .mapToObj(Integer::toString)
                .collect(Collectors.toList());
    }

    @Setup
    public void setUpFlatMapInput() {
        int rootSize = (int) Math.ceil(Math.sqrt(size));
        flatMapInput = new ArrayList<>(rootSize);

        for (int i = 0; i < rootSize; i++) {
            List<String> innerList = new ArrayList<>();
            for (int j = 0; j < rootSize; j++) {
                innerList.add(i + j + "");
            }
            flatMapInput.add(innerList);
        }
    }

    /* ====================================== Map-Filter-CollectToList ====================================== */

    @Benchmark
    public void test_stream_map_filter_collect_toList(Blackhole bh) {
        bh.consume(input.stream().map(Integer::valueOf).filter(i -> i > 6).collect(Collectors.toList()));
    }

    @Benchmark
    public void test_stream_map_filter_collect_toList_foreachstream(Blackhole bh) {
        bh.consume(stream_map_filter_collectCollector(input, Integer::valueOf, i -> i > 6, Collectors.toList()));
    }

    @Benchmark
    public void test_stream_map_filter_collect_toList_foreach(Blackhole bh) {
        List<Integer> result = new ArrayList<>(input.size());
        for (String s : input) {
            int i = Integer.parseInt(s);
            if (i > 6) {
                result.add(i);
            }
        }
        bh.consume(result);
    }

    /* ====================================== Filter-CollectToList ====================================== */
    @Benchmark
    public void test_stream_filter_collect_toList(Blackhole bh) {
        bh.consume(input.stream().filter(s -> s.charAt(0) <= '6').collect(Collectors.toList()));
    }
    
    @Benchmark
    public void test_stream_filter_collect_toList_foreachstream(Blackhole bh) {
        bh.consume(stream_filter_collectCollector(input, s -> s.charAt(0) <= '6', Collectors.toList()));
    }

    @Benchmark
    public void test_stream_filter_collect_toList_foreach(Blackhole bh) {
        List<String> result = new ArrayList<>(input.size());
        for (String s : input) {
            if (s.charAt(0) <= '6') {
                result.add(s);
            }
        }
        bh.consume(result);
    }

    /* ====================================== Map-ToList ====================================== */

    @Benchmark
    public void test_stream_map_toList(Blackhole bh) {
        bh.consume(input.stream().map(s -> s.charAt(0) - '0').toList());
    }

    @Benchmark
    public void test_stream_map_toList_foreachstream(Blackhole bh) {
        bh.consume(stream_map_toList(input, s -> s.charAt(0) - '0'));
    }

    @Benchmark
    public void test_stream_map_toList_foreach(Blackhole bh) {
        List<Integer> result = new ArrayList<>(input.size());
        for (String s : input) {
            result.add(s.charAt(0) - '0');
        }
        bh.consume(Collections.unmodifiableList(result));
    }

    /* ====================================== FlatMap-Map-Filter-FindFirst ====================================== */

    @Benchmark
    public void test_stream_flatMap_map_filter_findFirst(Blackhole bh) {
        bh.consume(flatMapInput.stream().flatMap(list -> list.stream()).map(Integer::valueOf).filter( i -> i > flatMapInput.size() + flatMapInput.size() / 2).findFirst());
    }

    @Benchmark
    public void test_stream_flatMap_map_filter_findFirst_foreachstream(Blackhole bh) {
        bh.consume(stream_flatMapLambda_map_filter_findFirst(flatMapInput, list -> list, Integer::valueOf, i -> i > flatMapInput.size() + flatMapInput.size() / 2));
    }

    @Benchmark
    public void test_stream_flatMap_map_filter_findFirst_foreach(Blackhole bh) {
        for (List<String> list : flatMapInput) {
            for (String s : list) {
                int i = Integer.parseInt(s);
                if (!(i > flatMapInput.size() + flatMapInput.size() / 2)) {
                    continue;
                }
                bh.consume(Optional.of(i));
                return;
            }
        }
        bh.consume(Optional.empty());
    }

    /* ====================================== Map-ForEach ====================================== */

    @Benchmark
    public void test_stream_map_forEach(Blackhole bh) {
        ArrayList<Integer> list = new ArrayList<>(input.size());
        input.stream().map(Integer::valueOf).forEach(list::add);
        bh.consume(list);
    }

    @Benchmark
    public void test_stream_map_forEach_foreachstream(Blackhole bh) {
        ArrayList<Integer> list = new ArrayList<>(input.size());
        stream_map_forEach(input, Integer::valueOf, list::add);
        bh.consume(list);
    }

    @Benchmark
    public void test_stream_map_forEach_foreach(Blackhole bh) {
        ArrayList<Integer> list = new ArrayList<>(input.size());
        for (String s : input) {
            list.add(Integer.valueOf(s));
        }
        bh.consume(list);
    }

    /* ====================================== FlatMap-MapToLong-Sum ====================================== */

    @Benchmark
    public void test_stream_flatMap_mapToLong_sum(Blackhole bh) {
        bh.consume(flatMapInput.stream().flatMap(List::stream).mapToLong(Long::parseLong).sum());
    }

    @Benchmark
    public void test_stream_flatMap_mapToLong_sum_foreachstream(Blackhole bh) {
        bh.consume(stream_flatMapMemberReference_mapToLong_sum(flatMapInput, Long::parseLong));
    }

    @Benchmark
    public void test_stream_flatMap_mapToLong_sum_foreach(Blackhole bh) {
        long sum = 0;
        for (List<String> sublist : flatMapInput) {
            for (String string : sublist) {
                sum += Long.parseLong(string);
            }
        }
        bh.consume(sum);
    }

    /* ================================== Map-Sorted-Limit-AllMatch ================================= */

    @Benchmark
    public void test_stream_map_sorted_limit_allMatch(Blackhole bh) {
        bh.consume(input.stream().map(s -> s.length() > 1 ? s.substring(0, s.length() - 1) : s).sorted().limit(15).allMatch(s -> s.charAt(0) < '5'));
    }

    @Benchmark
    public void test_stream_map_sorted_limit_allMatch_foreachstream(Blackhole bh) {
        bh.consume(stream_map_sorted_limit_allMatch(input, s -> s.length() > 1 ? s.substring(0, s.length() - 1) : s, 15, s -> s.charAt(0) < '5'));
    }

    @Benchmark
    public void test_stream_map_sorted_limit_allMatch_foreach(Blackhole bh) {
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
                return;
            }
        }
    }

    /* ====================================== DropWhile-Skip-Map-Reduce ===================================== */

    @Benchmark
    public void test_stream_takeWhile_skip_mapToInt_reduce(Blackhole bh) {
        bh.consume(input.stream().takeWhile(s -> s.length() < 7).skip(10).mapToInt(Integer::parseInt).reduce(0, Integer::sum));
    }

    @Benchmark
    public void test_stream_takeWhile_skip_mapToInt_reduce_foreachstream(Blackhole bh) {
        bh.consume(stream_takeWhile_skip_mapToInt_reduce(input, s -> s.length() < 7, 10, Integer::parseInt, 0, Integer::sum));
    }

    @Benchmark
    public void test_stream_takeWhile_skip_mapToInt_reduce_foreach(Blackhole bh) {
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
        bh.consume(result);
    }

    /* ====================================== Skip-SortedComp-Limit-ReduceCombiner ===================================== */

    @Benchmark
    public void test_stream_skip_sortedComp_limit_reduceCombiner(Blackhole bh) {
        bh.consume(input.stream().skip(15).sorted(Collections.reverseOrder()).limit(8).reduce(0, (partialSum, element) -> partialSum + Integer.parseInt(element), Integer::sum));
    }

    @Benchmark
    public void test_stream_skip_sortedComp_limit_reduceCombiner_foreachstream(Blackhole bh) {
        bh.consume(stream_skip_sortedComp_limit_reduceCombiner(input, 15, Collections.reverseOrder(), 8, 0, (partialSum, element) -> partialSum + Integer.parseInt(element), Integer::sum));
    }

    @Benchmark
    public void test_stream_skip_sortedComp_limit_reduceCombiner_foreach(Blackhole bh) {
        List<String> sortedComp = new ArrayList<>(input.size());
        for(int i = 15; i < input.size(); i++) {
            sortedComp.add(input.get(i));
        }
        sortedComp.sort(Collections.reverseOrder());
        int result = 0;
        for(int i = 0; i < sortedComp.size() && i < 8; i++) {
            result += Integer.parseInt(sortedComp.get(i));
        }
        bh.consume(result);
    }

    /* ====================================== Distinct-MapToDouble-Max ===================================== */

    @Benchmark
    public void test_stream_distinct_mapToDouble_max(Blackhole bh) {
        bh.consume(input.stream().distinct().mapToDouble(Double::parseDouble).max());
    }

    @Benchmark
    public void test_stream_distinct_mapToDouble_max_foreachstream(Blackhole bh) {
        bh.consume(stream_distinct_mapToDouble_max(input, Double::parseDouble));
    }

    @Benchmark
    public void test_stream_distinct_mapToDouble_max_foreach(Blackhole bh) {
        Set<String> distinct0 = new HashSet<>(input.size());
        double max = 0;
        boolean hasMax = false;
        OptionalDouble result;
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
            result = OptionalDouble.of(max);
        } else {
            result = OptionalDouble.empty();
        }
        bh.consume(result);
    }

        public static void main(String[] args) throws RunnerException {
            Options opt = new OptionsBuilder()
                    .include(JMH_Benchmarks.class.getSimpleName())
                    .addProfiler(GCProfiler.class)
                    .build();

            new Runner(opt).run();
        }
}
