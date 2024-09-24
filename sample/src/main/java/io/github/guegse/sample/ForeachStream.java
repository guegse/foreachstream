package io.github.guegse.sample;

import java.util.*;
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

    public static <T0, T1, T2> Optional<T2> stream_flatMapLambda_map_filter_findFirst(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, T2> arg1, Predicate<T2> arg2) {
        for (T0 t0: input) {
            for (T1 t1 : arg0.apply(t0)) {
                T2 t2 = arg1.apply(t1);
                if (!arg2.test(t2)) {
                    continue;
                }
                return Optional.of(t2);
            }
        }
        return Optional.empty();
    }

    public static <T0, T1> void stream_map_forEach(Collection<T0> input, Function<T0, T1> arg0, Consumer<T1> arg1) {
        for (T0 t0: input) {
            T1 t1 = arg0.apply(t0);
            arg1.accept(t1);
        }
    }

    public static <T0 extends Collection<T1>, T1> long stream_flatMapMemberReference_mapToLong_sum(Collection<T0> input, ToLongFunction<T1> arg0) {
        long sum = 0;
        for (T0 t0: input) {
            for (T1 t1 : t0) {
                long t2 = arg0.applyAsLong(t1);
                sum += t2;
            }
        }
        return sum;
    }

    public static <T0, T1> List<T1> stream_map_toList(Collection<T0> input, Function<T0, T1> arg0) {
        List<T1> result = new ArrayList<>(input.size());
        for (T0 t0: input) {
            T1 t1 = arg0.apply(t0);
            result.add(t1);
        }
        return Collections.unmodifiableList(result);
    }

    public static <T0, T1> boolean stream_map_sorted_limit_allMatch(Collection<T0> input, Function<T0, T1> arg0, long arg1, Predicate<T1> arg2) {
        List<T1> sorted0 = new ArrayList<>(input.size());
        if(arg1 < 0) {
            throw new IllegalArgumentException();
        }
        long limit0 = 0;
        for (T0 t0: input) {
            T1 t1 = arg0.apply(t0);
            sorted0.add(t1);
        }
        sorted0.sort(null);
        for (T1 t1: sorted0) {
            if(limit0 >= arg1) {
                break;
            }
            limit0++;
            if (!arg2.test(t1)) {
                return false;
            }
        }
        return true;
    }

    public static <T0> int stream_takeWhile_skip_mapToInt_reduce(Collection<T0> input, Predicate<T0> arg0, long arg1, ToIntFunction<T0> arg2, int arg3, IntBinaryOperator arg4) {
        if(arg1 < 0) {
            throw new IllegalArgumentException();
        }
        long skip0 = 0;
        int result = arg3;
        for (T0 t0: input) {
            if(!arg0.test(t0)) {
                break;
            }
            skip0++;
            if(skip0 <= arg1) {
                continue;
            }
            int t1 = arg2.applyAsInt(t0);
            result = arg4.applyAsInt(result, t1);
        }
        return result;
    }

    public static <T0> OptionalDouble stream_distinct_mapToDouble_max(Collection<T0> input, ToDoubleFunction<T0> arg0) {
        Set<T0> distinct0 = new HashSet<>(input.size());
        double max = 0;
        boolean hasMax = false;
        for (T0 t0: input) {
            if(!distinct0.add(t0)) {
                continue;
            }
            double t1 = arg0.applyAsDouble(t0);
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

    public static <T0, U> U stream_skip_sortedComp_limit_reduceCombiner(Collection<T0> input, long arg0, Comparator<? super T0> arg1, long arg2, U arg3, BiFunction<U,? super T0, U> arg4, BinaryOperator<U> arg5) {
        if(arg0 < 0) {
            throw new IllegalArgumentException();
        }
        long skip0 = 0;
        List<T0> sortedComp0 = new ArrayList<>(input.size());
        if(arg2 < 0) {
            throw new IllegalArgumentException();
        }
        long limit0 = 0;
        U result = arg3;
        for (T0 t0: input) {
            skip0++;
            if(skip0 <= arg0) {
                continue;
            }
            sortedComp0.add(t0);
        }
        sortedComp0.sort(arg1);
        for (T0 t0: sortedComp0) {
            if(limit0 >= arg2) {
                break;
            }
            limit0++;
            result = arg4.apply(result, t0);
        }
        return result;
    }
}
