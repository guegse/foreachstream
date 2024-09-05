package io.github.guegse.sample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collector;

public class ForeachStream {

    /* ======================== Implementations adopted from the Foreachstream Plugin ========================= */

    public static <T0, T1, R, A> R stream_map_filter_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
        A result = arg2.supplier().get();
        for (T0 t0: input) {
            T1 t1 = arg0.apply(t0);
            if (!arg1.test(t1)) {
                continue;
            }
            arg2.accumulator().accept(result, t1);
        }
        return arg2.finisher().apply(result);
    }

    public static <T0, R, A> R stream_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
        A result = arg1.supplier().get();
        for (T0 t0: input) {
            if (!arg0.test(t0)) {
                continue;
            }
            arg1.accumulator().accept(result, t0);
        }
        return arg1.finisher().apply(result);
    }

    public static <T0, T1, T2, R, A> R stream_flatMapLambda_map_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, T2> arg1, Collector<? super T2, A, R> arg2) {
        A result = arg2.supplier().get();
        for (T0 t0: input) {
            for (T1 t1 : arg0.apply(t0)) {
                T2 t2 = arg1.apply(t1);
                arg2.accumulator().accept(result, t2);
            }
        }
        return arg2.finisher().apply(result);
    }

    public static <T0, T1> void stream_map_forEach(Collection<T0> input, Function<T0, T1> arg0, Consumer<T1> arg1) {
        for (T0 t0: input) {
            T1 t1 = arg0.apply(t0);
            arg1.accept(t1);
        }
    }

    public static <T0 extends Collection<T1>, T1> int stream_flatMapMemberReference_mapToInt_sum(Collection<T0> input, ToIntFunction<T1> arg0) {
        int sum = 0;
        for (T0 t0: input) {
            for (T1 t1 : t0) {
                int t2 = arg0.applyAsInt(t1);
                sum += t2;
            }
        }
        return sum;
    }

    public static <T0> List<T0> stream_filter_toList(Collection<T0> input, Predicate<T0> arg0) {
        List<T0> result = new ArrayList<>();
        for (T0 t0: input) {
            if (!arg0.test(t0)) {
                continue;
            }
            result.add(t0);
        }
        return Collections.unmodifiableList(result);
    }

    public static <T0> boolean stream_sorted_limit_allMatch(Collection<T0> input, long arg0, Predicate<T0> arg1) {
        List<T0> sorted0 = new ArrayList<>();
        if(arg0 < 0) {
            throw new IllegalArgumentException();
        }
        long limit0 = 0;
        for (T0 t0: input) {
            sorted0.add(t0);
        }
        Collections.sort((List) sorted0);
        for (T0 t0: sorted0) {
            limit0++;
            if(limit0 > arg0) {
                break;
            }
            if (!arg1.test(t0)) {
                return false;
            }
        }
        return true;
    }

    public static <T0, T1> T1 stream_takeWhile_skip_map_reduce(Collection<T0> input, Predicate<T0> arg0, long arg1, Function<T0, T1> arg2, T1 arg3,  BinaryOperator<T1> arg4) {
        if(arg1 < 0) {
            throw new IllegalArgumentException();
        }
        long skip0 = 0;
        T1 result = arg3;
        for (T0 t0: input) {
            if(!arg0.test(t0)) {
                break;
            }
            skip0++;
            if(skip0 <= arg1) {
                continue;
            }
            T1 t1 = arg2.apply(t0);
            result = arg4.apply(result, t1);
        }
        return result;
    }
}
