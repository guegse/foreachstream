package io.github.guegse.foreachstream;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class ForeachStreamCollectCollector {

	public static <T0, R, A> R stream_collectCollector(Collection<T0> input, Collector<? super T0, A, R> arg0) {
		A result = arg0.supplier().get();
		for (T0 t0: input) {
			arg0.accumulator().accept(result, t0);
		}
		return arg0.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Collector<? super T1, A, R> arg1) {
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
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

	public static <T0, R, A> R stream_sorted_collectCollector(Collection<T0> input, Collector<? super T0, A, R> arg0) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg0.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg0.accumulator().accept(result, t0);
		}
		return arg0.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Collector<? super T0, A, R> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_collectCollector(Collection<T0> input, long arg0, Collector<? super T0, A, R> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_collectCollector(Collection<T0> input, long arg0, Collector<? super T0, A, R> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_collectCollector(Collection<T0> input, Collector<? super T0, A, R> arg0) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg0.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			arg0.accumulator().accept(result, t0);
		}
		return arg0.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		boolean dropWhile0 = true;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Collector<? super T1, A, R> arg1) {
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_collectCollector(Collection<T0> input, Collector<? super T1, A, R> arg0) {
		A result = arg0.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				arg0.accumulator().accept(result, t1);
			}
		}
		return arg0.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_map_map_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Function<T1, T2> arg1, Collector<? super T2, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			T2 t2 = arg1.apply(t1);
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

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

	public static <T0, T1, R, A> R stream_map_sorted_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Collector<? super T1, A, R> arg1) {
		List<T1> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_sortedComp_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Comparator<? super T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_limit_collectCollector(Collection<T0> input, Function<T0, T1> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			T1 t1 = arg0.apply(t0);
			limit0++;
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_skip_collectCollector(Collection<T0> input, Function<T0, T1> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_distinct_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Collector<? super T1, A, R> arg1) {
		Set<T1> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_dropWhile_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_takeWhile_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if(!arg1.test(t1)) {
				break;
			}
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_map_flatMapLambda_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Function<T1, Collection<T2>> arg1, Collector<? super T2, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			for (T2 t2 : arg1.apply(t1)) {
				arg2.accumulator().accept(result, t2);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_map_flatMapMemberReference_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Collector<? super T2, A, R> arg1) {
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			for (T2 t2 : t1) {
				arg1.accumulator().accept(result, t2);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_filter_map_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Collector<? super T1, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_sorted_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_sortedComp_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_limit_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if (!arg0.test(t0)) {
				continue;
			}
			limit0++;
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_skip_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_distinct_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_filter_flatMapLambda_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Collector<? super T1, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_filter_flatMapMemberReference_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T1, A, R> arg1) {
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			for (T1 t1 : t0) {
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToInt_mapToObj_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, IntFunction<T2> arg1, Collector<? super T2, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			T2 t2 = arg1.apply(t1);
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToInt_boxed_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, Collector<? super Integer, A, R> arg1) {
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			Integer t2 = t1;
			arg1.accumulator().accept(result, t2);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToLong_mapToObj_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, LongFunction<T2> arg1, Collector<? super T2, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			T2 t2 = arg1.apply(t1);
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToLong_boxed_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, Collector<? super Long, A, R> arg1) {
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			Long t2 = t1;
			arg1.accumulator().accept(result, t2);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToDouble_mapToObj_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleFunction<T2> arg1, Collector<? super T2, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			T2 t2 = arg1.apply(t1);
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToDouble_boxed_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, Collector<? super Double, A, R> arg1) {
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			Double t2 = t1;
			arg1.accumulator().accept(result, t2);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sorted_map_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Collector<? super T1, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			T1 t1 = arg0.apply(t0);
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if (!arg0.test(t0)) {
				continue;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_sorted_collectCollector(Collection<T0> input, Collector<? super T0, A, R> arg0) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		A result = arg0.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			sorted1.add(t0);
		}
		sorted1.sort(null);
		for (T0 t0: sorted1) {
			arg0.accumulator().accept(result, t0);
		}
		return arg0.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_sortedComp_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Collector<? super T0, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_limit_collectCollector(Collection<T0> input, long arg0, Collector<? super T0, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			limit0++;
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_skip_collectCollector(Collection<T0> input, long arg0, Collector<? super T0, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_distinct_collectCollector(Collection<T0> input, Collector<? super T0, A, R> arg0) {
		List<T0> sorted0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		A result = arg0.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			arg0.accumulator().accept(result, t0);
		}
		return arg0.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(!arg0.test(t0)) {
				break;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sorted_flatMapLambda_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Collector<? super T1, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			for (T1 t1 : arg0.apply(t0)) {
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_sorted_flatMapMemberReference_collectCollector(Collection<T0> input, Collector<? super T1, A, R> arg0) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg0.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			for (T1 t1 : t0) {
				arg0.accumulator().accept(result, t1);
			}
		}
		return arg0.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sortedComp_map_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			T1 t1 = arg1.apply(t0);
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_filter_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if (!arg1.test(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_sorted_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Collector<? super T0, A, R> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_sortedComp_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Comparator<? super T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sortedComp1.add(t0);
		}
		sortedComp1.sort(arg1);
		for (T0 t0: sortedComp1) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_limit_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			limit0++;
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_skip_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_distinct_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Collector<? super T0, A, R> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_dropWhile_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_takeWhile_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!arg1.test(t0)) {
				break;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sortedComp_flatMapLambda_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, Collection<T1>> arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : arg1.apply(t0)) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_sortedComp_flatMapMemberReference_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Collector<? super T1, A, R> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : t0) {
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_limit_map_collectCollector(Collection<T0> input, long arg0, Function<T0, T1> arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			T1 t1 = arg1.apply(t0);
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_filter_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if (!arg1.test(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_sorted_collectCollector(Collection<T0> input, long arg0, Collector<? super T0, A, R> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_sortedComp_collectCollector(Collection<T0> input, long arg0, Comparator<? super T0> arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_limit_collectCollector(Collection<T0> input, long arg0, long arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(limit1 >= arg1) {
				break;
			}
			limit0++;
			limit1++;
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_skip_collectCollector(Collection<T0> input, long arg0, long arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_distinct_collectCollector(Collection<T0> input, long arg0, Collector<? super T0, A, R> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if(!distinct0.add(t0)) {
				continue;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_dropWhile_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_takeWhile_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if(!arg1.test(t0)) {
				break;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_limit_flatMapLambda_collectCollector(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			for (T1 t1 : arg1.apply(t0)) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_limit_flatMapMemberReference_collectCollector(Collection<T0> input, long arg0, Collector<? super T1, A, R> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			for (T1 t1 : t0) {
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_skip_map_collectCollector(Collection<T0> input, long arg0, Function<T0, T1> arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_filter_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_sorted_collectCollector(Collection<T0> input, long arg0, Collector<? super T0, A, R> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_sortedComp_collectCollector(Collection<T0> input, long arg0, Comparator<? super T0> arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_limit_collectCollector(Collection<T0> input, long arg0, long arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			limit0++;
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_skip_collectCollector(Collection<T0> input, long arg0, long arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			skip1++;
			if(skip1 <= arg1) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_distinct_collectCollector(Collection<T0> input, long arg0, Collector<? super T0, A, R> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_dropWhile_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_takeWhile_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_skip_flatMapLambda_collectCollector(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_skip_flatMapMemberReference_collectCollector(Collection<T0> input, long arg0, Collector<? super T1, A, R> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			for (T1 t1 : t0) {
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_distinct_map_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Collector<? super T1, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			T1 t1 = arg0.apply(t0);
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if (!arg0.test(t0)) {
				continue;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_sorted_collectCollector(Collection<T0> input, Collector<? super T0, A, R> arg0) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sorted0 = new ArrayList<>();
		A result = arg0.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg0.accumulator().accept(result, t0);
		}
		return arg0.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_sortedComp_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Collector<? super T0, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_limit_collectCollector(Collection<T0> input, long arg0, Collector<? super T0, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			limit0++;
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_skip_collectCollector(Collection<T0> input, long arg0, Collector<? super T0, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_distinct_collectCollector(Collection<T0> input, Collector<? super T0, A, R> arg0) {
		Set<T0> distinct0 = new HashSet<>();
		Set<T0> distinct1 = new HashSet<>();
		A result = arg0.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!distinct1.add(t0)) {
				continue;
			}
			arg0.accumulator().accept(result, t0);
		}
		return arg0.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!arg0.test(t0)) {
				break;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_distinct_flatMapLambda_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Collector<? super T1, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : arg0.apply(t0)) {
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_distinct_flatMapMemberReference_collectCollector(Collection<T0> input, Collector<? super T1, A, R> arg0) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg0.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : t0) {
				arg0.accumulator().accept(result, t1);
			}
		}
		return arg0.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_dropWhile_map_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Collector<? super T1, A, R> arg2) {
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			T1 t1 = arg1.apply(t0);
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_sorted_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		boolean dropWhile0 = true;
		List<T0> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_sortedComp_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Collector<? super T0, A, R> arg2) {
		boolean dropWhile0 = true;
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_limit_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			limit0++;
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_skip_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_distinct_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		boolean dropWhile0 = true;
		Set<T0> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(dropWhile1 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile1 = false;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!arg1.test(t0)) {
				break;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_dropWhile_flatMapLambda_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Collector<? super T1, A, R> arg2) {
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : arg1.apply(t0)) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_dropWhile_flatMapMemberReference_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T1, A, R> arg1) {
		boolean dropWhile0 = true;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : t0) {
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_takeWhile_map_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Collector<? super T1, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			T1 t1 = arg1.apply(t0);
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_sorted_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_sortedComp_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_limit_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(!arg0.test(t0)) {
				break;
			}
			limit0++;
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_skip_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_distinct_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!arg1.test(t0)) {
				break;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_takeWhile_flatMapLambda_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Collector<? super T1, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			for (T1 t1 : arg1.apply(t0)) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_takeWhile_flatMapMemberReference_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T1, A, R> arg1) {
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			for (T1 t1 : t0) {
				arg1.accumulator().accept(result, t1);
			}
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

	public static <T0, T1, R, A> R stream_flatMapLambda_filter_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if (!arg1.test(t1)) {
					continue;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_sorted_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Collector<? super T1, A, R> arg1) {
		List<T1> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_sortedComp_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Comparator<? super T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_limit_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			for (T1 t1 : arg0.apply(t0)) {
				limit0++;
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_skip_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				skip0++;
				if(skip0 <= arg1) {
					continue;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_distinct_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Collector<? super T1, A, R> arg1) {
		Set<T1> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!distinct0.add(t1)) {
					continue;
				}
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_dropWhile_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(dropWhile0 && arg1.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_takeWhile_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!arg1.test(t1)) {
					break;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_flatMapLambda_flatMapLambda_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, Collection<T2>> arg1, Collector<? super T2, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				for (T2 t2 : arg1.apply(t1)) {
					arg2.accumulator().accept(result, t2);
				}
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_flatMapLambda_flatMapMemberReference_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Collector<? super T2, A, R> arg1) {
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				for (T2 t2 : t1) {
					arg1.accumulator().accept(result, t2);
				}
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_flatMapMemberReference_map_collectCollector(Collection<T0> input, Function<T1, T2> arg0, Collector<? super T2, A, R> arg1) {
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				T2 t2 = arg0.apply(t1);
				arg1.accumulator().accept(result, t2);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_filter_collectCollector(Collection<T0> input, Predicate<T1> arg0, Collector<? super T1, A, R> arg1) {
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if (!arg0.test(t1)) {
					continue;
				}
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_sorted_collectCollector(Collection<T0> input, Collector<? super T1, A, R> arg0) {
		List<T1> sorted0 = new ArrayList<>();
		A result = arg0.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			arg0.accumulator().accept(result, t1);
		}
		return arg0.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_sortedComp_collectCollector(Collection<T0> input, Comparator<? super T1> arg0, Collector<? super T1, A, R> arg1) {
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg0);
		for (T1 t1: sortedComp0) {
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_limit_collectCollector(Collection<T0> input, long arg0, Collector<? super T1, A, R> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			for (T1 t1 : t0) {
				limit0++;
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_skip_collectCollector(Collection<T0> input, long arg0, Collector<? super T1, A, R> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				skip0++;
				if(skip0 <= arg0) {
					continue;
				}
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_distinct_collectCollector(Collection<T0> input, Collector<? super T1, A, R> arg0) {
		Set<T1> distinct0 = new HashSet<>();
		A result = arg0.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if(!distinct0.add(t1)) {
					continue;
				}
				arg0.accumulator().accept(result, t1);
			}
		}
		return arg0.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_dropWhile_collectCollector(Collection<T0> input, Predicate<T1> arg0, Collector<? super T1, A, R> arg1) {
		boolean dropWhile0 = true;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if(dropWhile0 && arg0.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_takeWhile_collectCollector(Collection<T0> input, Predicate<T1> arg0, Collector<? super T1, A, R> arg1) {
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if(!arg0.test(t1)) {
					break;
				}
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_flatMapMemberReference_flatMapLambda_collectCollector(Collection<T0> input, Function<T1, Collection<T2>> arg0, Collector<? super T2, A, R> arg1) {
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				for (T2 t2 : arg0.apply(t1)) {
					arg1.accumulator().accept(result, t2);
				}
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1 extends Collection<T2>, T2, R, A> R stream_flatMapMemberReference_flatMapMemberReference_collectCollector(Collection<T0> input, Collector<? super T2, A, R> arg0) {
		A result = arg0.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				for (T2 t2 : t1) {
					arg0.accumulator().accept(result, t2);
				}
			}
		}
		return arg0.finisher().apply(result);
	}

	public static <T0, T1, T2, T3, R, A> R stream_map_map_map_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Function<T1, T2> arg1, Function<T2, T3> arg2, Collector<? super T3, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			T2 t2 = arg1.apply(t1);
			T3 t3 = arg2.apply(t2);
			arg3.accumulator().accept(result, t3);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_map_map_filter_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Function<T1, T2> arg1, Predicate<T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			T2 t2 = arg1.apply(t1);
			if (!arg2.test(t2)) {
				continue;
			}
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_map_map_sorted_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Function<T1, T2> arg1, Collector<? super T2, A, R> arg2) {
		List<T2> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			T2 t2 = arg1.apply(t1);
			sorted0.add(t2);
		}
		sorted0.sort(null);
		for (T2 t2: sorted0) {
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_map_map_sortedComp_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Function<T1, T2> arg1, Comparator<? super T2> arg2, Collector<? super T2, A, R> arg3) {
		List<T2> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			T2 t2 = arg1.apply(t1);
			sortedComp0.add(t2);
		}
		sortedComp0.sort(arg2);
		for (T2 t2: sortedComp0) {
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_map_map_limit_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Function<T1, T2> arg1, long arg2, Collector<? super T2, A, R> arg3) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			T1 t1 = arg0.apply(t0);
			T2 t2 = arg1.apply(t1);
			limit0++;
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_map_map_skip_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Function<T1, T2> arg1, long arg2, Collector<? super T2, A, R> arg3) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			T2 t2 = arg1.apply(t1);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_map_map_distinct_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Function<T1, T2> arg1, Collector<? super T2, A, R> arg2) {
		Set<T2> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			T2 t2 = arg1.apply(t1);
			if(!distinct0.add(t2)) {
				continue;
			}
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_map_map_dropWhile_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Function<T1, T2> arg1, Predicate<T2> arg2, Collector<? super T2, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			T2 t2 = arg1.apply(t1);
			if(dropWhile0 && arg2.test(t2)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_map_map_takeWhile_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Function<T1, T2> arg1, Predicate<T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			T2 t2 = arg1.apply(t1);
			if(!arg2.test(t2)) {
				break;
			}
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, T3, R, A> R stream_map_map_flatMapLambda_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Function<T1, T2> arg1, Function<T2, Collection<T3>> arg2, Collector<? super T3, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			T2 t2 = arg1.apply(t1);
			for (T3 t3 : arg2.apply(t2)) {
				arg3.accumulator().accept(result, t3);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2 extends Collection<T3>, T3, R, A> R stream_map_map_flatMapMemberReference_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Function<T1, T2> arg1, Collector<? super T3, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			T2 t2 = arg1.apply(t1);
			for (T3 t3 : t2) {
				arg2.accumulator().accept(result, t3);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_map_filter_map_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Function<T1, T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_filter_filter_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			if (!arg2.test(t1)) {
				continue;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_filter_sorted_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T1> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_filter_sortedComp_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Comparator<? super T1> arg2, Collector<? super T1, A, R> arg3) {
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg2);
		for (T1 t1: sortedComp0) {
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_filter_limit_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, long arg2, Collector<? super T1, A, R> arg3) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			T1 t1 = arg0.apply(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			limit0++;
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_filter_skip_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, long arg2, Collector<? super T1, A, R> arg3) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_filter_distinct_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		Set<T1> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			if(!distinct0.add(t1)) {
				continue;
			}
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_filter_dropWhile_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_filter_takeWhile_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			if(!arg2.test(t1)) {
				break;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_map_filter_flatMapLambda_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Function<T1, Collection<T2>> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			for (T2 t2 : arg2.apply(t1)) {
				arg3.accumulator().accept(result, t2);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_map_filter_flatMapMemberReference_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Collector<? super T2, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			for (T2 t2 : t1) {
				arg2.accumulator().accept(result, t2);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, T3, R, A> R stream_map_mapToInt_mapToObj_collectCollector(Collection<T0> input, Function<T0, T1> arg0, ToIntFunction<T1> arg1, IntFunction<T3> arg2, Collector<? super T3, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			int t2 = arg1.applyAsInt(t1);
			T3 t3 = arg2.apply(t2);
			arg3.accumulator().accept(result, t3);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_mapToInt_boxed_collectCollector(Collection<T0> input, Function<T0, T1> arg0, ToIntFunction<T1> arg1, Collector<? super Integer, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			int t2 = arg1.applyAsInt(t1);
			Integer t3 = t2;
			arg2.accumulator().accept(result, t3);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, T3, R, A> R stream_map_mapToLong_mapToObj_collectCollector(Collection<T0> input, Function<T0, T1> arg0, ToLongFunction<T1> arg1, LongFunction<T3> arg2, Collector<? super T3, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			long t2 = arg1.applyAsLong(t1);
			T3 t3 = arg2.apply(t2);
			arg3.accumulator().accept(result, t3);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_mapToLong_boxed_collectCollector(Collection<T0> input, Function<T0, T1> arg0, ToLongFunction<T1> arg1, Collector<? super Long, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			long t2 = arg1.applyAsLong(t1);
			Long t3 = t2;
			arg2.accumulator().accept(result, t3);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, T3, R, A> R stream_map_mapToDouble_mapToObj_collectCollector(Collection<T0> input, Function<T0, T1> arg0, ToDoubleFunction<T1> arg1, DoubleFunction<T3> arg2, Collector<? super T3, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			double t2 = arg1.applyAsDouble(t1);
			T3 t3 = arg2.apply(t2);
			arg3.accumulator().accept(result, t3);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_mapToDouble_boxed_collectCollector(Collection<T0> input, Function<T0, T1> arg0, ToDoubleFunction<T1> arg1, Collector<? super Double, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			double t2 = arg1.applyAsDouble(t1);
			Double t3 = t2;
			arg2.accumulator().accept(result, t3);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_map_sorted_map_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Function<T1, T2> arg1, Collector<? super T2, A, R> arg2) {
		List<T1> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			T2 t2 = arg1.apply(t1);
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_sorted_filter_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T1> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			if (!arg1.test(t1)) {
				continue;
			}
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_sorted_sorted_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Collector<? super T1, A, R> arg1) {
		List<T1> sorted0 = new ArrayList<>();
		List<T1> sorted1 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			sorted1.add(t1);
		}
		sorted1.sort(null);
		for (T1 t1: sorted1) {
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_sorted_sortedComp_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Comparator<? super T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T1> sorted0 = new ArrayList<>();
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_sorted_limit_collectCollector(Collection<T0> input, Function<T0, T1> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		List<T1> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			T1 t1 = arg0.apply(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			limit0++;
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_sorted_skip_collectCollector(Collection<T0> input, Function<T0, T1> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		List<T1> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_sorted_distinct_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Collector<? super T1, A, R> arg1) {
		List<T1> sorted0 = new ArrayList<>();
		Set<T1> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			if(!distinct0.add(t1)) {
				continue;
			}
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_sorted_dropWhile_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T1> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_sorted_takeWhile_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T1> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			if(!arg1.test(t1)) {
				break;
			}
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_map_sorted_flatMapLambda_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Function<T1, Collection<T2>> arg1, Collector<? super T2, A, R> arg2) {
		List<T1> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			for (T2 t2 : arg1.apply(t1)) {
				arg2.accumulator().accept(result, t2);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_map_sorted_flatMapMemberReference_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Collector<? super T2, A, R> arg1) {
		List<T1> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			for (T2 t2 : t1) {
				arg1.accumulator().accept(result, t2);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_map_sortedComp_map_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Comparator<? super T1> arg1, Function<T1, T2> arg2, Collector<? super T2, A, R> arg3) {
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_sortedComp_filter_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Comparator<? super T1> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			if (!arg2.test(t1)) {
				continue;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_sortedComp_sorted_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Comparator<? super T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		List<T1> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_sortedComp_sortedComp_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Comparator<? super T1> arg1, Comparator<? super T1> arg2, Collector<? super T1, A, R> arg3) {
		List<T1> sortedComp0 = new ArrayList<>();
		List<T1> sortedComp1 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			sortedComp1.add(t1);
		}
		sortedComp1.sort(arg2);
		for (T1 t1: sortedComp1) {
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_sortedComp_limit_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Comparator<? super T1> arg1, long arg2, Collector<? super T1, A, R> arg3) {
		List<T1> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			T1 t1 = arg0.apply(t0);
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			limit0++;
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_sortedComp_skip_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Comparator<? super T1> arg1, long arg2, Collector<? super T1, A, R> arg3) {
		List<T1> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_sortedComp_distinct_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Comparator<? super T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		Set<T1> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			if(!distinct0.add(t1)) {
				continue;
			}
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_sortedComp_dropWhile_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Comparator<? super T1> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		List<T1> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_sortedComp_takeWhile_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Comparator<? super T1> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			if(!arg2.test(t1)) {
				break;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_map_sortedComp_flatMapLambda_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Comparator<? super T1> arg1, Function<T1, Collection<T2>> arg2, Collector<? super T2, A, R> arg3) {
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			for (T2 t2 : arg2.apply(t1)) {
				arg3.accumulator().accept(result, t2);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_map_sortedComp_flatMapMemberReference_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Comparator<? super T1> arg1, Collector<? super T2, A, R> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			for (T2 t2 : t1) {
				arg2.accumulator().accept(result, t2);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_map_limit_map_collectCollector(Collection<T0> input, Function<T0, T1> arg0, long arg1, Function<T1, T2> arg2, Collector<? super T2, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			T1 t1 = arg0.apply(t0);
			limit0++;
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_limit_filter_collectCollector(Collection<T0> input, Function<T0, T1> arg0, long arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			T1 t1 = arg0.apply(t0);
			limit0++;
			if (!arg2.test(t1)) {
				continue;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_limit_sorted_collectCollector(Collection<T0> input, Function<T0, T1> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			T1 t1 = arg0.apply(t0);
			limit0++;
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_limit_sortedComp_collectCollector(Collection<T0> input, Function<T0, T1> arg0, long arg1, Comparator<? super T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			T1 t1 = arg0.apply(t0);
			limit0++;
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg2);
		for (T1 t1: sortedComp0) {
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_limit_limit_collectCollector(Collection<T0> input, Function<T0, T1> arg0, long arg1, long arg2, Collector<? super T1, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(limit1 >= arg2) {
				break;
			}
			T1 t1 = arg0.apply(t0);
			limit0++;
			limit1++;
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_limit_skip_collectCollector(Collection<T0> input, Function<T0, T1> arg0, long arg1, long arg2, Collector<? super T1, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			T1 t1 = arg0.apply(t0);
			limit0++;
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_limit_distinct_collectCollector(Collection<T0> input, Function<T0, T1> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T1> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			T1 t1 = arg0.apply(t0);
			limit0++;
			if(!distinct0.add(t1)) {
				continue;
			}
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_limit_dropWhile_collectCollector(Collection<T0> input, Function<T0, T1> arg0, long arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			T1 t1 = arg0.apply(t0);
			limit0++;
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_limit_takeWhile_collectCollector(Collection<T0> input, Function<T0, T1> arg0, long arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			T1 t1 = arg0.apply(t0);
			limit0++;
			if(!arg2.test(t1)) {
				break;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_map_limit_flatMapLambda_collectCollector(Collection<T0> input, Function<T0, T1> arg0, long arg1, Function<T1, Collection<T2>> arg2, Collector<? super T2, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			T1 t1 = arg0.apply(t0);
			limit0++;
			for (T2 t2 : arg2.apply(t1)) {
				arg3.accumulator().accept(result, t2);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_map_limit_flatMapMemberReference_collectCollector(Collection<T0> input, Function<T0, T1> arg0, long arg1, Collector<? super T2, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			T1 t1 = arg0.apply(t0);
			limit0++;
			for (T2 t2 : t1) {
				arg2.accumulator().accept(result, t2);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_map_skip_map_collectCollector(Collection<T0> input, Function<T0, T1> arg0, long arg1, Function<T1, T2> arg2, Collector<? super T2, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_skip_filter_collectCollector(Collection<T0> input, Function<T0, T1> arg0, long arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if (!arg2.test(t1)) {
				continue;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_skip_sorted_collectCollector(Collection<T0> input, Function<T0, T1> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_skip_sortedComp_collectCollector(Collection<T0> input, Function<T0, T1> arg0, long arg1, Comparator<? super T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg2);
		for (T1 t1: sortedComp0) {
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_skip_limit_collectCollector(Collection<T0> input, Function<T0, T1> arg0, long arg1, long arg2, Collector<? super T1, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			T1 t1 = arg0.apply(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			limit0++;
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_skip_skip_collectCollector(Collection<T0> input, Function<T0, T1> arg0, long arg1, long arg2, Collector<? super T1, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			skip1++;
			if(skip1 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_skip_distinct_collectCollector(Collection<T0> input, Function<T0, T1> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T1> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if(!distinct0.add(t1)) {
				continue;
			}
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_skip_dropWhile_collectCollector(Collection<T0> input, Function<T0, T1> arg0, long arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_skip_takeWhile_collectCollector(Collection<T0> input, Function<T0, T1> arg0, long arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if(!arg2.test(t1)) {
				break;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_map_skip_flatMapLambda_collectCollector(Collection<T0> input, Function<T0, T1> arg0, long arg1, Function<T1, Collection<T2>> arg2, Collector<? super T2, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			for (T2 t2 : arg2.apply(t1)) {
				arg3.accumulator().accept(result, t2);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_map_skip_flatMapMemberReference_collectCollector(Collection<T0> input, Function<T0, T1> arg0, long arg1, Collector<? super T2, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			for (T2 t2 : t1) {
				arg2.accumulator().accept(result, t2);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_map_distinct_map_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Function<T1, T2> arg1, Collector<? super T2, A, R> arg2) {
		Set<T1> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			T2 t2 = arg1.apply(t1);
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_distinct_filter_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		Set<T1> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			if (!arg1.test(t1)) {
				continue;
			}
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_distinct_sorted_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Collector<? super T1, A, R> arg1) {
		Set<T1> distinct0 = new HashSet<>();
		List<T1> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_distinct_sortedComp_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Comparator<? super T1> arg1, Collector<? super T1, A, R> arg2) {
		Set<T1> distinct0 = new HashSet<>();
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_distinct_limit_collectCollector(Collection<T0> input, Function<T0, T1> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		Set<T1> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			T1 t1 = arg0.apply(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			limit0++;
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_distinct_skip_collectCollector(Collection<T0> input, Function<T0, T1> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		Set<T1> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_distinct_distinct_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Collector<? super T1, A, R> arg1) {
		Set<T1> distinct0 = new HashSet<>();
		Set<T1> distinct1 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			if(!distinct1.add(t1)) {
				continue;
			}
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_distinct_dropWhile_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		Set<T1> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_distinct_takeWhile_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		Set<T1> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			if(!arg1.test(t1)) {
				break;
			}
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_map_distinct_flatMapLambda_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Function<T1, Collection<T2>> arg1, Collector<? super T2, A, R> arg2) {
		Set<T1> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			for (T2 t2 : arg1.apply(t1)) {
				arg2.accumulator().accept(result, t2);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_map_distinct_flatMapMemberReference_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Collector<? super T2, A, R> arg1) {
		Set<T1> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			for (T2 t2 : t1) {
				arg1.accumulator().accept(result, t2);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_map_dropWhile_map_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Function<T1, T2> arg2, Collector<? super T2, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_dropWhile_filter_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if (!arg2.test(t1)) {
				continue;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_dropWhile_sorted_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		boolean dropWhile0 = true;
		List<T1> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_dropWhile_sortedComp_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Comparator<? super T1> arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg2);
		for (T1 t1: sortedComp0) {
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_dropWhile_limit_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, long arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			T1 t1 = arg0.apply(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			limit0++;
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_dropWhile_skip_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, long arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_dropWhile_distinct_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		boolean dropWhile0 = true;
		Set<T1> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!distinct0.add(t1)) {
				continue;
			}
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_dropWhile_dropWhile_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(dropWhile1 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile1 = false;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_dropWhile_takeWhile_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!arg2.test(t1)) {
				break;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_map_dropWhile_flatMapLambda_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Function<T1, Collection<T2>> arg2, Collector<? super T2, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T2 t2 : arg2.apply(t1)) {
				arg3.accumulator().accept(result, t2);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_map_dropWhile_flatMapMemberReference_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Collector<? super T2, A, R> arg2) {
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T2 t2 : t1) {
				arg2.accumulator().accept(result, t2);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_map_takeWhile_map_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Function<T1, T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if(!arg1.test(t1)) {
				break;
			}
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_takeWhile_filter_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if(!arg1.test(t1)) {
				break;
			}
			if (!arg2.test(t1)) {
				continue;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_takeWhile_sorted_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T1> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if(!arg1.test(t1)) {
				break;
			}
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_takeWhile_sortedComp_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Comparator<? super T1> arg2, Collector<? super T1, A, R> arg3) {
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if(!arg1.test(t1)) {
				break;
			}
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg2);
		for (T1 t1: sortedComp0) {
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_takeWhile_limit_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, long arg2, Collector<? super T1, A, R> arg3) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			T1 t1 = arg0.apply(t0);
			if(!arg1.test(t1)) {
				break;
			}
			limit0++;
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_takeWhile_skip_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, long arg2, Collector<? super T1, A, R> arg3) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if(!arg1.test(t1)) {
				break;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_takeWhile_distinct_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		Set<T1> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if(!arg1.test(t1)) {
				break;
			}
			if(!distinct0.add(t1)) {
				continue;
			}
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_takeWhile_dropWhile_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if(!arg1.test(t1)) {
				break;
			}
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_map_takeWhile_takeWhile_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if(!arg1.test(t1)) {
				break;
			}
			if(!arg2.test(t1)) {
				break;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_map_takeWhile_flatMapLambda_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Function<T1, Collection<T2>> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if(!arg1.test(t1)) {
				break;
			}
			for (T2 t2 : arg2.apply(t1)) {
				arg3.accumulator().accept(result, t2);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_map_takeWhile_flatMapMemberReference_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Collector<? super T2, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if(!arg1.test(t1)) {
				break;
			}
			for (T2 t2 : t1) {
				arg2.accumulator().accept(result, t2);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, T2, T3, R, A> R stream_map_flatMapLambda_map_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Function<T1, Collection<T2>> arg1, Function<T2, T3> arg2, Collector<? super T3, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			for (T2 t2 : arg1.apply(t1)) {
				T3 t3 = arg2.apply(t2);
				arg3.accumulator().accept(result, t3);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_map_flatMapLambda_filter_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Function<T1, Collection<T2>> arg1, Predicate<T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			for (T2 t2 : arg1.apply(t1)) {
				if (!arg2.test(t2)) {
					continue;
				}
				arg3.accumulator().accept(result, t2);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_map_flatMapLambda_sorted_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Function<T1, Collection<T2>> arg1, Collector<? super T2, A, R> arg2) {
		List<T2> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			for (T2 t2 : arg1.apply(t1)) {
				sorted0.add(t2);
			}
		}
		sorted0.sort(null);
		for (T2 t2: sorted0) {
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_map_flatMapLambda_sortedComp_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Function<T1, Collection<T2>> arg1, Comparator<? super T2> arg2, Collector<? super T2, A, R> arg3) {
		List<T2> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			for (T2 t2 : arg1.apply(t1)) {
				sortedComp0.add(t2);
			}
		}
		sortedComp0.sort(arg2);
		for (T2 t2: sortedComp0) {
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_map_flatMapLambda_limit_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Function<T1, Collection<T2>> arg1, long arg2, Collector<? super T2, A, R> arg3) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			T1 t1 = arg0.apply(t0);
			for (T2 t2 : arg1.apply(t1)) {
				limit0++;
				arg3.accumulator().accept(result, t2);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_map_flatMapLambda_skip_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Function<T1, Collection<T2>> arg1, long arg2, Collector<? super T2, A, R> arg3) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			for (T2 t2 : arg1.apply(t1)) {
				skip0++;
				if(skip0 <= arg2) {
					continue;
				}
				arg3.accumulator().accept(result, t2);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_map_flatMapLambda_distinct_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Function<T1, Collection<T2>> arg1, Collector<? super T2, A, R> arg2) {
		Set<T2> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			for (T2 t2 : arg1.apply(t1)) {
				if(!distinct0.add(t2)) {
					continue;
				}
				arg2.accumulator().accept(result, t2);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_map_flatMapLambda_dropWhile_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Function<T1, Collection<T2>> arg1, Predicate<T2> arg2, Collector<? super T2, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			for (T2 t2 : arg1.apply(t1)) {
				if(dropWhile0 && arg2.test(t2)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				arg3.accumulator().accept(result, t2);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_map_flatMapLambda_takeWhile_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Function<T1, Collection<T2>> arg1, Predicate<T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			for (T2 t2 : arg1.apply(t1)) {
				if(!arg2.test(t2)) {
					break;
				}
				arg3.accumulator().accept(result, t2);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, T3, R, A> R stream_map_flatMapLambda_flatMapLambda_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Function<T1, Collection<T2>> arg1, Function<T2, Collection<T3>> arg2, Collector<? super T3, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			for (T2 t2 : arg1.apply(t1)) {
				for (T3 t3 : arg2.apply(t2)) {
					arg3.accumulator().accept(result, t3);
				}
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2 extends Collection<T3>, T3, R, A> R stream_map_flatMapLambda_flatMapMemberReference_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Function<T1, Collection<T2>> arg1, Collector<? super T3, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			for (T2 t2 : arg1.apply(t1)) {
				for (T3 t3 : t2) {
					arg2.accumulator().accept(result, t3);
				}
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, T3, R, A> R stream_map_flatMapMemberReference_map_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Function<T2, T3> arg1, Collector<? super T3, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			for (T2 t2 : t1) {
				T3 t3 = arg1.apply(t2);
				arg2.accumulator().accept(result, t3);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_map_flatMapMemberReference_filter_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T2> arg1, Collector<? super T2, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			for (T2 t2 : t1) {
				if (!arg1.test(t2)) {
					continue;
				}
				arg2.accumulator().accept(result, t2);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_map_flatMapMemberReference_sorted_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Collector<? super T2, A, R> arg1) {
		List<T2> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			for (T2 t2 : t1) {
				sorted0.add(t2);
			}
		}
		sorted0.sort(null);
		for (T2 t2: sorted0) {
			arg1.accumulator().accept(result, t2);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_map_flatMapMemberReference_sortedComp_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Comparator<? super T2> arg1, Collector<? super T2, A, R> arg2) {
		List<T2> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			for (T2 t2 : t1) {
				sortedComp0.add(t2);
			}
		}
		sortedComp0.sort(arg1);
		for (T2 t2: sortedComp0) {
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_map_flatMapMemberReference_limit_collectCollector(Collection<T0> input, Function<T0, T1> arg0, long arg1, Collector<? super T2, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			T1 t1 = arg0.apply(t0);
			for (T2 t2 : t1) {
				limit0++;
				arg2.accumulator().accept(result, t2);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_map_flatMapMemberReference_skip_collectCollector(Collection<T0> input, Function<T0, T1> arg0, long arg1, Collector<? super T2, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			for (T2 t2 : t1) {
				skip0++;
				if(skip0 <= arg1) {
					continue;
				}
				arg2.accumulator().accept(result, t2);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_map_flatMapMemberReference_distinct_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Collector<? super T2, A, R> arg1) {
		Set<T2> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			for (T2 t2 : t1) {
				if(!distinct0.add(t2)) {
					continue;
				}
				arg1.accumulator().accept(result, t2);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_map_flatMapMemberReference_dropWhile_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T2> arg1, Collector<? super T2, A, R> arg2) {
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			for (T2 t2 : t1) {
				if(dropWhile0 && arg1.test(t2)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				arg2.accumulator().accept(result, t2);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_map_flatMapMemberReference_takeWhile_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T2> arg1, Collector<? super T2, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			for (T2 t2 : t1) {
				if(!arg1.test(t2)) {
					break;
				}
				arg2.accumulator().accept(result, t2);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, T3, R, A> R stream_map_flatMapMemberReference_flatMapLambda_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Function<T2, Collection<T3>> arg1, Collector<? super T3, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			for (T2 t2 : t1) {
				for (T3 t3 : arg1.apply(t2)) {
					arg2.accumulator().accept(result, t3);
				}
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2 extends Collection<T3>, T3, R, A> R stream_map_flatMapMemberReference_flatMapMemberReference_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Collector<? super T3, A, R> arg1) {
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			for (T2 t2 : t1) {
				for (T3 t3 : t2) {
					arg1.accumulator().accept(result, t3);
				}
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_filter_map_map_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Function<T1, T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_filter_map_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_filter_map_sorted_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T1> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_filter_map_sortedComp_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Comparator<? super T1> arg2, Collector<? super T1, A, R> arg3) {
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg2);
		for (T1 t1: sortedComp0) {
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_filter_map_limit_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, long arg2, Collector<? super T1, A, R> arg3) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			if (!arg0.test(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			limit0++;
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_filter_map_skip_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, long arg2, Collector<? super T1, A, R> arg3) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_filter_map_distinct_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Collector<? super T1, A, R> arg2) {
		Set<T1> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_filter_map_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_filter_map_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			if(!arg2.test(t1)) {
				break;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_filter_map_flatMapLambda_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Function<T1, Collection<T2>> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			for (T2 t2 : arg2.apply(t1)) {
				arg3.accumulator().accept(result, t2);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_filter_map_flatMapMemberReference_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Collector<? super T2, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			for (T2 t2 : t1) {
				arg2.accumulator().accept(result, t2);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_filter_filter_map_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Function<T0, T1> arg2, Collector<? super T1, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			T1 t1 = arg2.apply(t0);
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_filter_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_filter_sorted_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_filter_sortedComp_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Comparator<? super T0> arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_filter_limit_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			if (!arg0.test(t0)) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			limit0++;
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_filter_skip_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_filter_distinct_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_filter_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_filter_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			if(!arg2.test(t0)) {
				break;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_filter_filter_flatMapLambda_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Function<T0, Collection<T1>> arg2, Collector<? super T1, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			for (T1 t1 : arg2.apply(t0)) {
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_filter_filter_flatMapMemberReference_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T1, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			for (T1 t1 : t0) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_filter_mapToInt_mapToObj_collectCollector(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1, IntFunction<T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_mapToInt_boxed_collectCollector(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1, Collector<? super Integer, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			Integer t2 = t1;
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_filter_mapToLong_mapToObj_collectCollector(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1, LongFunction<T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_mapToLong_boxed_collectCollector(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1, Collector<? super Long, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			Long t2 = t1;
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_filter_mapToDouble_mapToObj_collectCollector(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1, DoubleFunction<T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_mapToDouble_boxed_collectCollector(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1, Collector<? super Double, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			Double t2 = t1;
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_filter_sorted_map_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			T1 t1 = arg1.apply(t0);
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_sorted_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if (!arg1.test(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_sorted_sorted_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			sorted1.add(t0);
		}
		sorted1.sort(null);
		for (T0 t0: sorted1) {
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_sorted_sortedComp_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_sorted_limit_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if (!arg0.test(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			limit0++;
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_sorted_skip_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_sorted_distinct_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_sorted_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_sorted_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(!arg1.test(t0)) {
				break;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_filter_sorted_flatMapLambda_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			for (T1 t1 : arg1.apply(t0)) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_filter_sorted_flatMapMemberReference_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T1, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			for (T1 t1 : t0) {
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_filter_sortedComp_map_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Function<T0, T1> arg2, Collector<? super T1, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			T1 t1 = arg2.apply(t0);
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_sortedComp_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			if (!arg2.test(t0)) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_sortedComp_sorted_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_sortedComp_sortedComp_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Comparator<? super T0> arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			sortedComp1.add(t0);
		}
		sortedComp1.sort(arg2);
		for (T0 t0: sortedComp1) {
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_sortedComp_limit_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			if (!arg0.test(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			limit0++;
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_sortedComp_skip_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_sortedComp_distinct_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_sortedComp_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_sortedComp_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			if(!arg2.test(t0)) {
				break;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_filter_sortedComp_flatMapLambda_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Function<T0, Collection<T1>> arg2, Collector<? super T1, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : arg2.apply(t0)) {
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_filter_sortedComp_flatMapMemberReference_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : t0) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_filter_limit_map_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Function<T0, T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if (!arg0.test(t0)) {
				continue;
			}
			limit0++;
			T1 t1 = arg2.apply(t0);
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_limit_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if (!arg0.test(t0)) {
				continue;
			}
			limit0++;
			if (!arg2.test(t0)) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_limit_sorted_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if (!arg0.test(t0)) {
				continue;
			}
			limit0++;
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_limit_sortedComp_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Comparator<? super T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if (!arg0.test(t0)) {
				continue;
			}
			limit0++;
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_limit_limit_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, long arg2, Collector<? super T0, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(limit1 >= arg2) {
				break;
			}
			if (!arg0.test(t0)) {
				continue;
			}
			limit0++;
			limit1++;
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_limit_skip_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, long arg2, Collector<? super T0, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if (!arg0.test(t0)) {
				continue;
			}
			limit0++;
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_limit_distinct_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if (!arg0.test(t0)) {
				continue;
			}
			limit0++;
			if(!distinct0.add(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_limit_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if (!arg0.test(t0)) {
				continue;
			}
			limit0++;
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_limit_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if (!arg0.test(t0)) {
				continue;
			}
			limit0++;
			if(!arg2.test(t0)) {
				break;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_filter_limit_flatMapLambda_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Function<T0, Collection<T1>> arg2, Collector<? super T1, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if (!arg0.test(t0)) {
				continue;
			}
			limit0++;
			for (T1 t1 : arg2.apply(t0)) {
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_filter_limit_flatMapMemberReference_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if (!arg0.test(t0)) {
				continue;
			}
			limit0++;
			for (T1 t1 : t0) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_filter_skip_map_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Function<T0, T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			T1 t1 = arg2.apply(t0);
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_skip_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_skip_sorted_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_skip_sortedComp_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Comparator<? super T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_skip_limit_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, long arg2, Collector<? super T0, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			if (!arg0.test(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			limit0++;
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_skip_skip_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, long arg2, Collector<? super T0, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			skip1++;
			if(skip1 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_skip_distinct_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_skip_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_skip_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if(!arg2.test(t0)) {
				break;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_filter_skip_flatMapLambda_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Function<T0, Collection<T1>> arg2, Collector<? super T1, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			for (T1 t1 : arg2.apply(t0)) {
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_filter_skip_flatMapMemberReference_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			for (T1 t1 : t0) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_filter_distinct_map_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Collector<? super T1, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_distinct_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_distinct_sorted_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_distinct_sortedComp_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_distinct_limit_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if (!arg0.test(t0)) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			limit0++;
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_distinct_skip_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_distinct_distinct_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		Set<T0> distinct1 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!distinct1.add(t0)) {
				continue;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_distinct_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_distinct_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_filter_distinct_flatMapLambda_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Collector<? super T1, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_filter_distinct_flatMapMemberReference_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T1, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : t0) {
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_filter_dropWhile_map_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Function<T0, T1> arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			T1 t1 = arg2.apply(t0);
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_dropWhile_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_dropWhile_sorted_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		boolean dropWhile0 = true;
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_dropWhile_sortedComp_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Comparator<? super T0> arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_dropWhile_limit_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			if (!arg0.test(t0)) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			limit0++;
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_dropWhile_skip_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_dropWhile_distinct_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		boolean dropWhile0 = true;
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_dropWhile_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(dropWhile1 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile1 = false;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_dropWhile_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!arg2.test(t0)) {
				break;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_filter_dropWhile_flatMapLambda_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Function<T0, Collection<T1>> arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : arg2.apply(t0)) {
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_filter_dropWhile_flatMapMemberReference_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T1, A, R> arg2) {
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : t0) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_filter_takeWhile_map_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Function<T0, T1> arg2, Collector<? super T1, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			T1 t1 = arg2.apply(t0);
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_takeWhile_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_takeWhile_sorted_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_takeWhile_sortedComp_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Comparator<? super T0> arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_takeWhile_limit_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			if (!arg0.test(t0)) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			limit0++;
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_takeWhile_skip_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_takeWhile_distinct_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_takeWhile_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_filter_takeWhile_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			if(!arg2.test(t0)) {
				break;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_filter_takeWhile_flatMapLambda_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Function<T0, Collection<T1>> arg2, Collector<? super T1, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			for (T1 t1 : arg2.apply(t0)) {
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_filter_takeWhile_flatMapMemberReference_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T1, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			for (T1 t1 : t0) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_filter_flatMapLambda_map_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Function<T1, T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				T2 t2 = arg2.apply(t1);
				arg3.accumulator().accept(result, t2);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_filter_flatMapLambda_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				if (!arg2.test(t1)) {
					continue;
				}
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_filter_flatMapLambda_sorted_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Collector<? super T1, A, R> arg2) {
		List<T1> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_filter_flatMapLambda_sortedComp_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Comparator<? super T1> arg2, Collector<? super T1, A, R> arg3) {
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg2);
		for (T1 t1: sortedComp0) {
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_filter_flatMapLambda_limit_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, long arg2, Collector<? super T1, A, R> arg3) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			if (!arg0.test(t0)) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				limit0++;
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_filter_flatMapLambda_skip_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, long arg2, Collector<? super T1, A, R> arg3) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				skip0++;
				if(skip0 <= arg2) {
					continue;
				}
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_filter_flatMapLambda_distinct_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Collector<? super T1, A, R> arg2) {
		Set<T1> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				if(!distinct0.add(t1)) {
					continue;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_filter_flatMapLambda_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				if(dropWhile0 && arg2.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_filter_flatMapLambda_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				if(!arg2.test(t1)) {
					break;
				}
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_filter_flatMapLambda_flatMapLambda_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Function<T1, Collection<T2>> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				for (T2 t2 : arg2.apply(t1)) {
					arg3.accumulator().accept(result, t2);
				}
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_filter_flatMapLambda_flatMapMemberReference_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Collector<? super T2, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				for (T2 t2 : t1) {
					arg2.accumulator().accept(result, t2);
				}
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_filter_flatMapMemberReference_map_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T1, T2> arg1, Collector<? super T2, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			for (T1 t1 : t0) {
				T2 t2 = arg1.apply(t1);
				arg2.accumulator().accept(result, t2);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_filter_flatMapMemberReference_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			for (T1 t1 : t0) {
				if (!arg1.test(t1)) {
					continue;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_filter_flatMapMemberReference_sorted_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T1, A, R> arg1) {
		List<T1> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			for (T1 t1 : t0) {
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_filter_flatMapMemberReference_sortedComp_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			for (T1 t1 : t0) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_filter_flatMapMemberReference_limit_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if (!arg0.test(t0)) {
				continue;
			}
			for (T1 t1 : t0) {
				limit0++;
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_filter_flatMapMemberReference_skip_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			for (T1 t1 : t0) {
				skip0++;
				if(skip0 <= arg1) {
					continue;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_filter_flatMapMemberReference_distinct_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T1, A, R> arg1) {
		Set<T1> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			for (T1 t1 : t0) {
				if(!distinct0.add(t1)) {
					continue;
				}
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_filter_flatMapMemberReference_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			for (T1 t1 : t0) {
				if(dropWhile0 && arg1.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_filter_flatMapMemberReference_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			for (T1 t1 : t0) {
				if(!arg1.test(t1)) {
					break;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_filter_flatMapMemberReference_flatMapLambda_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T1, Collection<T2>> arg1, Collector<? super T2, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			for (T1 t1 : t0) {
				for (T2 t2 : arg1.apply(t1)) {
					arg2.accumulator().accept(result, t2);
				}
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1 extends Collection<T2>, T2, R, A> R stream_filter_flatMapMemberReference_flatMapMemberReference_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T2, A, R> arg1) {
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			for (T1 t1 : t0) {
				for (T2 t2 : t1) {
					arg1.accumulator().accept(result, t2);
				}
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToInt_map_mapToObj_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, IntUnaryOperator arg1, IntFunction<T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			t1 = arg1.applyAsInt(t1);
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToInt_map_boxed_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, IntUnaryOperator arg1, Collector<? super Integer, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			t1 = arg1.applyAsInt(t1);
			Integer t2 = t1;
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToInt_filter_mapToObj_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1, IntFunction<T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToInt_filter_boxed_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1, Collector<? super Integer, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			Integer t2 = t1;
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T3, R, A> R stream_mapToInt_mapToLong_mapToObj_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, IntToLongFunction arg1, LongFunction<T3> arg2, Collector<? super T3, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			long t2 = arg1.applyAsLong(t1);
			T3 t3 = arg2.apply(t2);
			arg3.accumulator().accept(result, t3);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToInt_mapToLong_boxed_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, IntToLongFunction arg1, Collector<? super Long, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			long t2 = arg1.applyAsLong(t1);
			Long t3 = t2;
			arg2.accumulator().accept(result, t3);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T3, R, A> R stream_mapToInt_mapToDouble_mapToObj_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, IntToDoubleFunction arg1, DoubleFunction<T3> arg2, Collector<? super T3, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			double t2 = arg1.applyAsDouble(t1);
			T3 t3 = arg2.apply(t2);
			arg3.accumulator().accept(result, t3);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToInt_mapToDouble_boxed_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, IntToDoubleFunction arg1, Collector<? super Double, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			double t2 = arg1.applyAsDouble(t1);
			Double t3 = t2;
			arg2.accumulator().accept(result, t3);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T2, T3, R, A> R stream_mapToInt_mapToObj_map_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, IntFunction<T2> arg1, Function<T2, T3> arg2, Collector<? super T3, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			T2 t2 = arg1.apply(t1);
			T3 t3 = arg2.apply(t2);
			arg3.accumulator().accept(result, t3);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToInt_mapToObj_filter_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, IntFunction<T2> arg1, Predicate<T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			T2 t2 = arg1.apply(t1);
			if (!arg2.test(t2)) {
				continue;
			}
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToInt_mapToObj_sorted_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, IntFunction<T2> arg1, Collector<? super T2, A, R> arg2) {
		List<T2> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			T2 t2 = arg1.apply(t1);
			sorted0.add(t2);
		}
		sorted0.sort(null);
		for (T2 t2: sorted0) {
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToInt_mapToObj_sortedComp_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, IntFunction<T2> arg1, Comparator<? super T2> arg2, Collector<? super T2, A, R> arg3) {
		List<T2> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			T2 t2 = arg1.apply(t1);
			sortedComp0.add(t2);
		}
		sortedComp0.sort(arg2);
		for (T2 t2: sortedComp0) {
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToInt_mapToObj_limit_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, IntFunction<T2> arg1, long arg2, Collector<? super T2, A, R> arg3) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			int t1 = arg0.applyAsInt(t0);
			T2 t2 = arg1.apply(t1);
			limit0++;
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToInt_mapToObj_skip_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, IntFunction<T2> arg1, long arg2, Collector<? super T2, A, R> arg3) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			T2 t2 = arg1.apply(t1);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToInt_mapToObj_distinct_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, IntFunction<T2> arg1, Collector<? super T2, A, R> arg2) {
		Set<T2> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			T2 t2 = arg1.apply(t1);
			if(!distinct0.add(t2)) {
				continue;
			}
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToInt_mapToObj_dropWhile_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, IntFunction<T2> arg1, Predicate<T2> arg2, Collector<? super T2, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			T2 t2 = arg1.apply(t1);
			if(dropWhile0 && arg2.test(t2)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToInt_mapToObj_takeWhile_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, IntFunction<T2> arg1, Predicate<T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			T2 t2 = arg1.apply(t1);
			if(!arg2.test(t2)) {
				break;
			}
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T2, T3, R, A> R stream_mapToInt_mapToObj_flatMapLambda_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, IntFunction<T2> arg1, Function<T2, Collection<T3>> arg2, Collector<? super T3, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			T2 t2 = arg1.apply(t1);
			for (T3 t3 : arg2.apply(t2)) {
				arg3.accumulator().accept(result, t3);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T2 extends Collection<T3>, T3, R, A> R stream_mapToInt_mapToObj_flatMapMemberReference_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, IntFunction<T2> arg1, Collector<? super T3, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			T2 t2 = arg1.apply(t1);
			for (T3 t3 : t2) {
				arg2.accumulator().accept(result, t3);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T3, R, A> R stream_mapToInt_boxed_map_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, Function<Integer, T3> arg1, Collector<? super T3, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			Integer t2 = t1;
			T3 t3 = arg1.apply(t2);
			arg2.accumulator().accept(result, t3);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToInt_boxed_filter_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, Predicate<Integer> arg1, Collector<? super Integer, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			Integer t2 = t1;
			if (!arg1.test(t2)) {
				continue;
			}
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToInt_boxed_sorted_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, Collector<? super Integer, A, R> arg1) {
		List<Integer> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			Integer t2 = t1;
			sorted0.add(t2);
		}
		sorted0.sort(null);
		for (Integer t2: sorted0) {
			arg1.accumulator().accept(result, t2);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToInt_boxed_sortedComp_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, Comparator<? super Integer> arg1, Collector<? super Integer, A, R> arg2) {
		List<Integer> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			Integer t2 = t1;
			sortedComp0.add(t2);
		}
		sortedComp0.sort(arg1);
		for (Integer t2: sortedComp0) {
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToInt_boxed_limit_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, long arg1, Collector<? super Integer, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			int t1 = arg0.applyAsInt(t0);
			Integer t2 = t1;
			limit0++;
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToInt_boxed_skip_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, long arg1, Collector<? super Integer, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			Integer t2 = t1;
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToInt_boxed_distinct_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, Collector<? super Integer, A, R> arg1) {
		Set<Integer> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			Integer t2 = t1;
			if(!distinct0.add(t2)) {
				continue;
			}
			arg1.accumulator().accept(result, t2);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToInt_boxed_dropWhile_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, Predicate<Integer> arg1, Collector<? super Integer, A, R> arg2) {
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			Integer t2 = t1;
			if(dropWhile0 && arg1.test(t2)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToInt_boxed_takeWhile_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, Predicate<Integer> arg1, Collector<? super Integer, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			Integer t2 = t1;
			if(!arg1.test(t2)) {
				break;
			}
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T3, R, A> R stream_mapToInt_boxed_flatMapLambda_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, Function<Integer, Collection<T3>> arg1, Collector<? super T3, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			Integer t2 = t1;
			for (T3 t3 : arg1.apply(t2)) {
				arg2.accumulator().accept(result, t3);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToInt_sorted_mapToObj_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, IntFunction<T2> arg1, Collector<? super T2, A, R> arg2) {
		List<Integer> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (int t1: sorted0) {
			T2 t2 = arg1.apply(t1);
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToInt_sorted_boxed_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, Collector<? super Integer, A, R> arg1) {
		List<Integer> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (int t1: sorted0) {
			Integer t2 = t1;
			arg1.accumulator().accept(result, t2);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToInt_limit_mapToObj_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, long arg1, IntFunction<T2> arg2, Collector<? super T2, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			int t1 = arg0.applyAsInt(t0);
			limit0++;
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToInt_limit_boxed_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, long arg1, Collector<? super Integer, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			int t1 = arg0.applyAsInt(t0);
			limit0++;
			Integer t2 = t1;
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToInt_skip_mapToObj_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, long arg1, IntFunction<T2> arg2, Collector<? super T2, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToInt_skip_boxed_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, long arg1, Collector<? super Integer, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			Integer t2 = t1;
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToInt_distinct_mapToObj_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, IntFunction<T2> arg1, Collector<? super T2, A, R> arg2) {
		Set<Integer> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			T2 t2 = arg1.apply(t1);
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToInt_distinct_boxed_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, Collector<? super Integer, A, R> arg1) {
		Set<Integer> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			Integer t2 = t1;
			arg1.accumulator().accept(result, t2);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToInt_dropWhile_mapToObj_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1, IntFunction<T2> arg2, Collector<? super T2, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToInt_dropWhile_boxed_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1, Collector<? super Integer, A, R> arg2) {
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			Integer t2 = t1;
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToInt_takeWhile_mapToObj_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1, IntFunction<T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			if(!arg1.test(t1)) {
				break;
			}
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToInt_takeWhile_boxed_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1, Collector<? super Integer, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			if(!arg1.test(t1)) {
				break;
			}
			Integer t2 = t1;
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToLong_map_mapToObj_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, LongUnaryOperator arg1, LongFunction<T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			t1 = arg1.applyAsLong(t1);
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToLong_map_boxed_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, LongUnaryOperator arg1, Collector<? super Long, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			t1 = arg1.applyAsLong(t1);
			Long t2 = t1;
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToLong_filter_mapToObj_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1, LongFunction<T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToLong_filter_boxed_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1, Collector<? super Long, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			Long t2 = t1;
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T3, R, A> R stream_mapToLong_mapToInt_mapToObj_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, LongToIntFunction arg1, IntFunction<T3> arg2, Collector<? super T3, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			int t2 = arg1.applyAsInt(t1);
			T3 t3 = arg2.apply(t2);
			arg3.accumulator().accept(result, t3);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToLong_mapToInt_boxed_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, LongToIntFunction arg1, Collector<? super Integer, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			int t2 = arg1.applyAsInt(t1);
			Integer t3 = t2;
			arg2.accumulator().accept(result, t3);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T3, R, A> R stream_mapToLong_mapToDouble_mapToObj_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, LongToDoubleFunction arg1, DoubleFunction<T3> arg2, Collector<? super T3, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			double t2 = arg1.applyAsDouble(t1);
			T3 t3 = arg2.apply(t2);
			arg3.accumulator().accept(result, t3);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToLong_mapToDouble_boxed_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, LongToDoubleFunction arg1, Collector<? super Double, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			double t2 = arg1.applyAsDouble(t1);
			Double t3 = t2;
			arg2.accumulator().accept(result, t3);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T2, T3, R, A> R stream_mapToLong_mapToObj_map_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, LongFunction<T2> arg1, Function<T2, T3> arg2, Collector<? super T3, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			T2 t2 = arg1.apply(t1);
			T3 t3 = arg2.apply(t2);
			arg3.accumulator().accept(result, t3);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToLong_mapToObj_filter_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, LongFunction<T2> arg1, Predicate<T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			T2 t2 = arg1.apply(t1);
			if (!arg2.test(t2)) {
				continue;
			}
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToLong_mapToObj_sorted_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, LongFunction<T2> arg1, Collector<? super T2, A, R> arg2) {
		List<T2> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			T2 t2 = arg1.apply(t1);
			sorted0.add(t2);
		}
		sorted0.sort(null);
		for (T2 t2: sorted0) {
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToLong_mapToObj_sortedComp_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, LongFunction<T2> arg1, Comparator<? super T2> arg2, Collector<? super T2, A, R> arg3) {
		List<T2> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			T2 t2 = arg1.apply(t1);
			sortedComp0.add(t2);
		}
		sortedComp0.sort(arg2);
		for (T2 t2: sortedComp0) {
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToLong_mapToObj_limit_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, LongFunction<T2> arg1, long arg2, Collector<? super T2, A, R> arg3) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			long t1 = arg0.applyAsLong(t0);
			T2 t2 = arg1.apply(t1);
			limit0++;
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToLong_mapToObj_skip_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, LongFunction<T2> arg1, long arg2, Collector<? super T2, A, R> arg3) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			T2 t2 = arg1.apply(t1);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToLong_mapToObj_distinct_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, LongFunction<T2> arg1, Collector<? super T2, A, R> arg2) {
		Set<T2> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			T2 t2 = arg1.apply(t1);
			if(!distinct0.add(t2)) {
				continue;
			}
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToLong_mapToObj_dropWhile_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, LongFunction<T2> arg1, Predicate<T2> arg2, Collector<? super T2, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			T2 t2 = arg1.apply(t1);
			if(dropWhile0 && arg2.test(t2)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToLong_mapToObj_takeWhile_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, LongFunction<T2> arg1, Predicate<T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			T2 t2 = arg1.apply(t1);
			if(!arg2.test(t2)) {
				break;
			}
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T2, T3, R, A> R stream_mapToLong_mapToObj_flatMapLambda_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, LongFunction<T2> arg1, Function<T2, Collection<T3>> arg2, Collector<? super T3, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			T2 t2 = arg1.apply(t1);
			for (T3 t3 : arg2.apply(t2)) {
				arg3.accumulator().accept(result, t3);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T2 extends Collection<T3>, T3, R, A> R stream_mapToLong_mapToObj_flatMapMemberReference_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, LongFunction<T2> arg1, Collector<? super T3, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			T2 t2 = arg1.apply(t1);
			for (T3 t3 : t2) {
				arg2.accumulator().accept(result, t3);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T3, R, A> R stream_mapToLong_boxed_map_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, Function<Long, T3> arg1, Collector<? super T3, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			Long t2 = t1;
			T3 t3 = arg1.apply(t2);
			arg2.accumulator().accept(result, t3);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToLong_boxed_filter_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, Predicate<Long> arg1, Collector<? super Long, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			Long t2 = t1;
			if (!arg1.test(t2)) {
				continue;
			}
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToLong_boxed_sorted_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, Collector<? super Long, A, R> arg1) {
		List<Long> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			Long t2 = t1;
			sorted0.add(t2);
		}
		sorted0.sort(null);
		for (Long t2: sorted0) {
			arg1.accumulator().accept(result, t2);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToLong_boxed_sortedComp_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, Comparator<? super Long> arg1, Collector<? super Long, A, R> arg2) {
		List<Long> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			Long t2 = t1;
			sortedComp0.add(t2);
		}
		sortedComp0.sort(arg1);
		for (Long t2: sortedComp0) {
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToLong_boxed_limit_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, long arg1, Collector<? super Long, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			long t1 = arg0.applyAsLong(t0);
			Long t2 = t1;
			limit0++;
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToLong_boxed_skip_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, long arg1, Collector<? super Long, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			Long t2 = t1;
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToLong_boxed_distinct_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, Collector<? super Long, A, R> arg1) {
		Set<Long> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			Long t2 = t1;
			if(!distinct0.add(t2)) {
				continue;
			}
			arg1.accumulator().accept(result, t2);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToLong_boxed_dropWhile_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, Predicate<Long> arg1, Collector<? super Long, A, R> arg2) {
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			Long t2 = t1;
			if(dropWhile0 && arg1.test(t2)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToLong_boxed_takeWhile_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, Predicate<Long> arg1, Collector<? super Long, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			Long t2 = t1;
			if(!arg1.test(t2)) {
				break;
			}
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T3, R, A> R stream_mapToLong_boxed_flatMapLambda_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, Function<Long, Collection<T3>> arg1, Collector<? super T3, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			Long t2 = t1;
			for (T3 t3 : arg1.apply(t2)) {
				arg2.accumulator().accept(result, t3);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToLong_sorted_mapToObj_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, LongFunction<T2> arg1, Collector<? super T2, A, R> arg2) {
		List<Long> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (long t1: sorted0) {
			T2 t2 = arg1.apply(t1);
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToLong_sorted_boxed_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, Collector<? super Long, A, R> arg1) {
		List<Long> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (long t1: sorted0) {
			Long t2 = t1;
			arg1.accumulator().accept(result, t2);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToLong_limit_mapToObj_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, long arg1, LongFunction<T2> arg2, Collector<? super T2, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			long t1 = arg0.applyAsLong(t0);
			limit0++;
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToLong_limit_boxed_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, long arg1, Collector<? super Long, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			long t1 = arg0.applyAsLong(t0);
			limit0++;
			Long t2 = t1;
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToLong_skip_mapToObj_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, long arg1, LongFunction<T2> arg2, Collector<? super T2, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToLong_skip_boxed_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, long arg1, Collector<? super Long, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			Long t2 = t1;
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToLong_distinct_mapToObj_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, LongFunction<T2> arg1, Collector<? super T2, A, R> arg2) {
		Set<Long> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			T2 t2 = arg1.apply(t1);
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToLong_distinct_boxed_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, Collector<? super Long, A, R> arg1) {
		Set<Long> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			Long t2 = t1;
			arg1.accumulator().accept(result, t2);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToLong_dropWhile_mapToObj_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1, LongFunction<T2> arg2, Collector<? super T2, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToLong_dropWhile_boxed_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1, Collector<? super Long, A, R> arg2) {
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			Long t2 = t1;
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToLong_takeWhile_mapToObj_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1, LongFunction<T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			if(!arg1.test(t1)) {
				break;
			}
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToLong_takeWhile_boxed_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1, Collector<? super Long, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			if(!arg1.test(t1)) {
				break;
			}
			Long t2 = t1;
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToDouble_map_mapToObj_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleUnaryOperator arg1, DoubleFunction<T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			t1 = arg1.applyAsDouble(t1);
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToDouble_map_boxed_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleUnaryOperator arg1, Collector<? super Double, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			t1 = arg1.applyAsDouble(t1);
			Double t2 = t1;
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToDouble_filter_mapToObj_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1, DoubleFunction<T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToDouble_filter_boxed_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1, Collector<? super Double, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			Double t2 = t1;
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T3, R, A> R stream_mapToDouble_mapToInt_mapToObj_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToIntFunction arg1, IntFunction<T3> arg2, Collector<? super T3, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			int t2 = arg1.applyAsInt(t1);
			T3 t3 = arg2.apply(t2);
			arg3.accumulator().accept(result, t3);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToDouble_mapToInt_boxed_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToIntFunction arg1, Collector<? super Integer, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			int t2 = arg1.applyAsInt(t1);
			Integer t3 = t2;
			arg2.accumulator().accept(result, t3);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T3, R, A> R stream_mapToDouble_mapToLong_mapToObj_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToLongFunction arg1, LongFunction<T3> arg2, Collector<? super T3, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			long t2 = arg1.applyAsLong(t1);
			T3 t3 = arg2.apply(t2);
			arg3.accumulator().accept(result, t3);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToDouble_mapToLong_boxed_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToLongFunction arg1, Collector<? super Long, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			long t2 = arg1.applyAsLong(t1);
			Long t3 = t2;
			arg2.accumulator().accept(result, t3);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T2, T3, R, A> R stream_mapToDouble_mapToObj_map_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleFunction<T2> arg1, Function<T2, T3> arg2, Collector<? super T3, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			T2 t2 = arg1.apply(t1);
			T3 t3 = arg2.apply(t2);
			arg3.accumulator().accept(result, t3);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToDouble_mapToObj_filter_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleFunction<T2> arg1, Predicate<T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			T2 t2 = arg1.apply(t1);
			if (!arg2.test(t2)) {
				continue;
			}
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToDouble_mapToObj_sorted_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleFunction<T2> arg1, Collector<? super T2, A, R> arg2) {
		List<T2> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			T2 t2 = arg1.apply(t1);
			sorted0.add(t2);
		}
		sorted0.sort(null);
		for (T2 t2: sorted0) {
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToDouble_mapToObj_sortedComp_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleFunction<T2> arg1, Comparator<? super T2> arg2, Collector<? super T2, A, R> arg3) {
		List<T2> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			T2 t2 = arg1.apply(t1);
			sortedComp0.add(t2);
		}
		sortedComp0.sort(arg2);
		for (T2 t2: sortedComp0) {
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToDouble_mapToObj_limit_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleFunction<T2> arg1, long arg2, Collector<? super T2, A, R> arg3) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			double t1 = arg0.applyAsDouble(t0);
			T2 t2 = arg1.apply(t1);
			limit0++;
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToDouble_mapToObj_skip_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleFunction<T2> arg1, long arg2, Collector<? super T2, A, R> arg3) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			T2 t2 = arg1.apply(t1);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToDouble_mapToObj_distinct_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleFunction<T2> arg1, Collector<? super T2, A, R> arg2) {
		Set<T2> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			T2 t2 = arg1.apply(t1);
			if(!distinct0.add(t2)) {
				continue;
			}
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToDouble_mapToObj_dropWhile_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleFunction<T2> arg1, Predicate<T2> arg2, Collector<? super T2, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			T2 t2 = arg1.apply(t1);
			if(dropWhile0 && arg2.test(t2)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToDouble_mapToObj_takeWhile_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleFunction<T2> arg1, Predicate<T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			T2 t2 = arg1.apply(t1);
			if(!arg2.test(t2)) {
				break;
			}
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T2, T3, R, A> R stream_mapToDouble_mapToObj_flatMapLambda_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleFunction<T2> arg1, Function<T2, Collection<T3>> arg2, Collector<? super T3, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			T2 t2 = arg1.apply(t1);
			for (T3 t3 : arg2.apply(t2)) {
				arg3.accumulator().accept(result, t3);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T2 extends Collection<T3>, T3, R, A> R stream_mapToDouble_mapToObj_flatMapMemberReference_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleFunction<T2> arg1, Collector<? super T3, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			T2 t2 = arg1.apply(t1);
			for (T3 t3 : t2) {
				arg2.accumulator().accept(result, t3);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T3, R, A> R stream_mapToDouble_boxed_map_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, Function<Double, T3> arg1, Collector<? super T3, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			Double t2 = t1;
			T3 t3 = arg1.apply(t2);
			arg2.accumulator().accept(result, t3);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToDouble_boxed_filter_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, Predicate<Double> arg1, Collector<? super Double, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			Double t2 = t1;
			if (!arg1.test(t2)) {
				continue;
			}
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToDouble_boxed_sorted_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, Collector<? super Double, A, R> arg1) {
		List<Double> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			Double t2 = t1;
			sorted0.add(t2);
		}
		sorted0.sort(null);
		for (Double t2: sorted0) {
			arg1.accumulator().accept(result, t2);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToDouble_boxed_sortedComp_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, Comparator<? super Double> arg1, Collector<? super Double, A, R> arg2) {
		List<Double> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			Double t2 = t1;
			sortedComp0.add(t2);
		}
		sortedComp0.sort(arg1);
		for (Double t2: sortedComp0) {
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToDouble_boxed_limit_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1, Collector<? super Double, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			double t1 = arg0.applyAsDouble(t0);
			Double t2 = t1;
			limit0++;
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToDouble_boxed_skip_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1, Collector<? super Double, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			Double t2 = t1;
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToDouble_boxed_distinct_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, Collector<? super Double, A, R> arg1) {
		Set<Double> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			Double t2 = t1;
			if(!distinct0.add(t2)) {
				continue;
			}
			arg1.accumulator().accept(result, t2);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToDouble_boxed_dropWhile_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, Predicate<Double> arg1, Collector<? super Double, A, R> arg2) {
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			Double t2 = t1;
			if(dropWhile0 && arg1.test(t2)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToDouble_boxed_takeWhile_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, Predicate<Double> arg1, Collector<? super Double, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			Double t2 = t1;
			if(!arg1.test(t2)) {
				break;
			}
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T3, R, A> R stream_mapToDouble_boxed_flatMapLambda_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, Function<Double, Collection<T3>> arg1, Collector<? super T3, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			Double t2 = t1;
			for (T3 t3 : arg1.apply(t2)) {
				arg2.accumulator().accept(result, t3);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToDouble_sorted_mapToObj_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleFunction<T2> arg1, Collector<? super T2, A, R> arg2) {
		List<Double> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (double t1: sorted0) {
			T2 t2 = arg1.apply(t1);
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToDouble_sorted_boxed_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, Collector<? super Double, A, R> arg1) {
		List<Double> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (double t1: sorted0) {
			Double t2 = t1;
			arg1.accumulator().accept(result, t2);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToDouble_limit_mapToObj_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1, DoubleFunction<T2> arg2, Collector<? super T2, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			double t1 = arg0.applyAsDouble(t0);
			limit0++;
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToDouble_limit_boxed_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1, Collector<? super Double, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			double t1 = arg0.applyAsDouble(t0);
			limit0++;
			Double t2 = t1;
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToDouble_skip_mapToObj_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1, DoubleFunction<T2> arg2, Collector<? super T2, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToDouble_skip_boxed_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1, Collector<? super Double, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			Double t2 = t1;
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToDouble_distinct_mapToObj_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleFunction<T2> arg1, Collector<? super T2, A, R> arg2) {
		Set<Double> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			T2 t2 = arg1.apply(t1);
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToDouble_distinct_boxed_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, Collector<? super Double, A, R> arg1) {
		Set<Double> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			Double t2 = t1;
			arg1.accumulator().accept(result, t2);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToDouble_dropWhile_mapToObj_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1, DoubleFunction<T2> arg2, Collector<? super T2, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToDouble_dropWhile_boxed_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1, Collector<? super Double, A, R> arg2) {
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			Double t2 = t1;
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_mapToDouble_takeWhile_mapToObj_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1, DoubleFunction<T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			if(!arg1.test(t1)) {
				break;
			}
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_mapToDouble_takeWhile_boxed_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1, Collector<? super Double, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			if(!arg1.test(t1)) {
				break;
			}
			Double t2 = t1;
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_sorted_map_map_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Function<T1, T2> arg1, Collector<? super T2, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			T1 t1 = arg0.apply(t0);
			T2 t2 = arg1.apply(t1);
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sorted_map_filter_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			T1 t1 = arg0.apply(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sorted_map_sorted_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Collector<? super T1, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		List<T1> sorted1 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			T1 t1 = arg0.apply(t0);
			sorted1.add(t1);
		}
		sorted1.sort(null);
		for (T1 t1: sorted1) {
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sorted_map_sortedComp_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Comparator<? super T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			T1 t1 = arg0.apply(t0);
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sorted_map_limit_collectCollector(Collection<T0> input, Function<T0, T1> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			T1 t1 = arg0.apply(t0);
			limit0++;
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sorted_map_skip_collectCollector(Collection<T0> input, Function<T0, T1> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			T1 t1 = arg0.apply(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sorted_map_distinct_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Collector<? super T1, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		Set<T1> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			T1 t1 = arg0.apply(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sorted_map_dropWhile_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			T1 t1 = arg0.apply(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sorted_map_takeWhile_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			T1 t1 = arg0.apply(t0);
			if(!arg1.test(t1)) {
				break;
			}
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_sorted_map_flatMapLambda_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Function<T1, Collection<T2>> arg1, Collector<? super T2, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			T1 t1 = arg0.apply(t0);
			for (T2 t2 : arg1.apply(t1)) {
				arg2.accumulator().accept(result, t2);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_sorted_map_flatMapMemberReference_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Collector<? super T2, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			T1 t1 = arg0.apply(t0);
			for (T2 t2 : t1) {
				arg1.accumulator().accept(result, t2);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sorted_filter_map_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if (!arg0.test(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_filter_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if (!arg0.test(t0)) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_filter_sorted_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if (!arg0.test(t0)) {
				continue;
			}
			sorted1.add(t0);
		}
		sorted1.sort(null);
		for (T0 t0: sorted1) {
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_filter_sortedComp_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if (!arg0.test(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_filter_limit_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if (!arg0.test(t0)) {
				continue;
			}
			limit0++;
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_filter_skip_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if (!arg0.test(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_filter_distinct_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_filter_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_filter_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sorted_filter_flatMapLambda_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if (!arg0.test(t0)) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_sorted_filter_flatMapMemberReference_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T1, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if (!arg0.test(t0)) {
				continue;
			}
			for (T1 t1 : t0) {
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_sorted_mapToInt_mapToObj_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, IntFunction<T2> arg1, Collector<? super T2, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			int t1 = arg0.applyAsInt(t0);
			T2 t2 = arg1.apply(t1);
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_mapToInt_boxed_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, Collector<? super Integer, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			int t1 = arg0.applyAsInt(t0);
			Integer t2 = t1;
			arg1.accumulator().accept(result, t2);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_sorted_mapToLong_mapToObj_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, LongFunction<T2> arg1, Collector<? super T2, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			long t1 = arg0.applyAsLong(t0);
			T2 t2 = arg1.apply(t1);
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_mapToLong_boxed_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, Collector<? super Long, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			long t1 = arg0.applyAsLong(t0);
			Long t2 = t1;
			arg1.accumulator().accept(result, t2);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_sorted_mapToDouble_mapToObj_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleFunction<T2> arg1, Collector<? super T2, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			double t1 = arg0.applyAsDouble(t0);
			T2 t2 = arg1.apply(t1);
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_mapToDouble_boxed_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, Collector<? super Double, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			double t1 = arg0.applyAsDouble(t0);
			Double t2 = t1;
			arg1.accumulator().accept(result, t2);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sorted_sorted_map_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Collector<? super T1, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			sorted1.add(t0);
		}
		sorted1.sort(null);
		for (T0 t0: sorted1) {
			T1 t1 = arg0.apply(t0);
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_sorted_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			sorted1.add(t0);
		}
		sorted1.sort(null);
		for (T0 t0: sorted1) {
			if (!arg0.test(t0)) {
				continue;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_sorted_sorted_collectCollector(Collection<T0> input, Collector<? super T0, A, R> arg0) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		List<T0> sorted2 = new ArrayList<>();
		A result = arg0.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			sorted1.add(t0);
		}
		sorted1.sort(null);
		for (T0 t0: sorted1) {
			sorted2.add(t0);
		}
		sorted2.sort(null);
		for (T0 t0: sorted2) {
			arg0.accumulator().accept(result, t0);
		}
		return arg0.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_sorted_sortedComp_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Collector<? super T0, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			sorted1.add(t0);
		}
		sorted1.sort(null);
		for (T0 t0: sorted1) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_sorted_limit_collectCollector(Collection<T0> input, long arg0, Collector<? super T0, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			sorted1.add(t0);
		}
		sorted1.sort(null);
		for (T0 t0: sorted1) {
			limit0++;
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_sorted_skip_collectCollector(Collection<T0> input, long arg0, Collector<? super T0, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			sorted1.add(t0);
		}
		sorted1.sort(null);
		for (T0 t0: sorted1) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_sorted_distinct_collectCollector(Collection<T0> input, Collector<? super T0, A, R> arg0) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		A result = arg0.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			sorted1.add(t0);
		}
		sorted1.sort(null);
		for (T0 t0: sorted1) {
			if(!distinct0.add(t0)) {
				continue;
			}
			arg0.accumulator().accept(result, t0);
		}
		return arg0.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_sorted_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		boolean dropWhile0 = true;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			sorted1.add(t0);
		}
		sorted1.sort(null);
		for (T0 t0: sorted1) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_sorted_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			sorted1.add(t0);
		}
		sorted1.sort(null);
		for (T0 t0: sorted1) {
			if(!arg0.test(t0)) {
				break;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sorted_sorted_flatMapLambda_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Collector<? super T1, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			sorted1.add(t0);
		}
		sorted1.sort(null);
		for (T0 t0: sorted1) {
			for (T1 t1 : arg0.apply(t0)) {
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_sorted_sorted_flatMapMemberReference_collectCollector(Collection<T0> input, Collector<? super T1, A, R> arg0) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		A result = arg0.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			sorted1.add(t0);
		}
		sorted1.sort(null);
		for (T0 t0: sorted1) {
			for (T1 t1 : t0) {
				arg0.accumulator().accept(result, t1);
			}
		}
		return arg0.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sorted_sortedComp_map_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			T1 t1 = arg1.apply(t0);
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_sortedComp_filter_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if (!arg1.test(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_sortedComp_sorted_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Collector<? super T0, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sorted1.add(t0);
		}
		sorted1.sort(null);
		for (T0 t0: sorted1) {
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_sortedComp_sortedComp_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Comparator<? super T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sortedComp1.add(t0);
		}
		sortedComp1.sort(arg1);
		for (T0 t0: sortedComp1) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_sortedComp_limit_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			limit0++;
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_sortedComp_skip_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_sortedComp_distinct_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Collector<? super T0, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_sortedComp_dropWhile_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_sortedComp_takeWhile_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!arg1.test(t0)) {
				break;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sorted_sortedComp_flatMapLambda_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, Collection<T1>> arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : arg1.apply(t0)) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_sorted_sortedComp_flatMapMemberReference_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Collector<? super T1, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : t0) {
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sorted_limit_map_collectCollector(Collection<T0> input, long arg0, Function<T0, T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			limit0++;
			T1 t1 = arg1.apply(t0);
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_limit_filter_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			limit0++;
			if (!arg1.test(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_limit_sorted_collectCollector(Collection<T0> input, long arg0, Collector<? super T0, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted1 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			limit0++;
			sorted1.add(t0);
		}
		sorted1.sort(null);
		for (T0 t0: sorted1) {
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_limit_sortedComp_collectCollector(Collection<T0> input, long arg0, Comparator<? super T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			limit0++;
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_limit_limit_collectCollector(Collection<T0> input, long arg0, long arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(limit1 >= arg1) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			limit0++;
			limit1++;
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_limit_skip_collectCollector(Collection<T0> input, long arg0, long arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			limit0++;
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_limit_distinct_collectCollector(Collection<T0> input, long arg0, Collector<? super T0, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			limit0++;
			if(!distinct0.add(t0)) {
				continue;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_limit_dropWhile_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			limit0++;
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_limit_takeWhile_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			limit0++;
			if(!arg1.test(t0)) {
				break;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sorted_limit_flatMapLambda_collectCollector(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			limit0++;
			for (T1 t1 : arg1.apply(t0)) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_sorted_limit_flatMapMemberReference_collectCollector(Collection<T0> input, long arg0, Collector<? super T1, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			limit0++;
			for (T1 t1 : t0) {
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sorted_skip_map_collectCollector(Collection<T0> input, long arg0, Function<T0, T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_skip_filter_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_skip_sorted_collectCollector(Collection<T0> input, long arg0, Collector<? super T0, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted1 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sorted1.add(t0);
		}
		sorted1.sort(null);
		for (T0 t0: sorted1) {
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_skip_sortedComp_collectCollector(Collection<T0> input, long arg0, Comparator<? super T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_skip_limit_collectCollector(Collection<T0> input, long arg0, long arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			limit0++;
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_skip_skip_collectCollector(Collection<T0> input, long arg0, long arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			skip1++;
			if(skip1 <= arg1) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_skip_distinct_collectCollector(Collection<T0> input, long arg0, Collector<? super T0, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_skip_dropWhile_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_skip_takeWhile_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sorted_skip_flatMapLambda_collectCollector(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_sorted_skip_flatMapMemberReference_collectCollector(Collection<T0> input, long arg0, Collector<? super T1, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			for (T1 t1 : t0) {
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sorted_distinct_map_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Collector<? super T1, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			T1 t1 = arg0.apply(t0);
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_distinct_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if (!arg0.test(t0)) {
				continue;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_distinct_sorted_collectCollector(Collection<T0> input, Collector<? super T0, A, R> arg0) {
		List<T0> sorted0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sorted1 = new ArrayList<>();
		A result = arg0.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sorted1.add(t0);
		}
		sorted1.sort(null);
		for (T0 t0: sorted1) {
			arg0.accumulator().accept(result, t0);
		}
		return arg0.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_distinct_sortedComp_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Collector<? super T0, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_distinct_limit_collectCollector(Collection<T0> input, long arg0, Collector<? super T0, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			limit0++;
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_distinct_skip_collectCollector(Collection<T0> input, long arg0, Collector<? super T0, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_distinct_distinct_collectCollector(Collection<T0> input, Collector<? super T0, A, R> arg0) {
		List<T0> sorted0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		Set<T0> distinct1 = new HashSet<>();
		A result = arg0.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!distinct1.add(t0)) {
				continue;
			}
			arg0.accumulator().accept(result, t0);
		}
		return arg0.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_distinct_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_distinct_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!arg0.test(t0)) {
				break;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sorted_distinct_flatMapLambda_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Collector<? super T1, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : arg0.apply(t0)) {
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_sorted_distinct_flatMapMemberReference_collectCollector(Collection<T0> input, Collector<? super T1, A, R> arg0) {
		List<T0> sorted0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		A result = arg0.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : t0) {
				arg0.accumulator().accept(result, t1);
			}
		}
		return arg0.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sorted_dropWhile_map_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			T1 t1 = arg1.apply(t0);
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_dropWhile_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_dropWhile_sorted_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		List<T0> sorted1 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sorted1.add(t0);
		}
		sorted1.sort(null);
		for (T0 t0: sorted1) {
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_dropWhile_sortedComp_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_dropWhile_limit_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			limit0++;
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_dropWhile_skip_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_dropWhile_distinct_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		Set<T0> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_dropWhile_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(dropWhile1 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile1 = false;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_dropWhile_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!arg1.test(t0)) {
				break;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sorted_dropWhile_flatMapLambda_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : arg1.apply(t0)) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_sorted_dropWhile_flatMapMemberReference_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T1, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : t0) {
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sorted_takeWhile_map_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(!arg0.test(t0)) {
				break;
			}
			T1 t1 = arg1.apply(t0);
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_takeWhile_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(!arg0.test(t0)) {
				break;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_takeWhile_sorted_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(!arg0.test(t0)) {
				break;
			}
			sorted1.add(t0);
		}
		sorted1.sort(null);
		for (T0 t0: sorted1) {
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_takeWhile_sortedComp_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(!arg0.test(t0)) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_takeWhile_limit_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(!arg0.test(t0)) {
				break;
			}
			limit0++;
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_takeWhile_skip_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(!arg0.test(t0)) {
				break;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_takeWhile_distinct_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_takeWhile_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(!arg0.test(t0)) {
				break;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sorted_takeWhile_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!arg1.test(t0)) {
				break;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sorted_takeWhile_flatMapLambda_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(!arg0.test(t0)) {
				break;
			}
			for (T1 t1 : arg1.apply(t0)) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_sorted_takeWhile_flatMapMemberReference_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T1, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(!arg0.test(t0)) {
				break;
			}
			for (T1 t1 : t0) {
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_sorted_flatMapLambda_map_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, T2> arg1, Collector<? super T2, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			for (T1 t1 : arg0.apply(t0)) {
				T2 t2 = arg1.apply(t1);
				arg2.accumulator().accept(result, t2);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sorted_flatMapLambda_filter_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			for (T1 t1 : arg0.apply(t0)) {
				if (!arg1.test(t1)) {
					continue;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sorted_flatMapLambda_sorted_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Collector<? super T1, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		List<T1> sorted1 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			for (T1 t1 : arg0.apply(t0)) {
				sorted1.add(t1);
			}
		}
		sorted1.sort(null);
		for (T1 t1: sorted1) {
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sorted_flatMapLambda_sortedComp_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Comparator<? super T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			for (T1 t1 : arg0.apply(t0)) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sorted_flatMapLambda_limit_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			for (T1 t1 : arg0.apply(t0)) {
				limit0++;
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sorted_flatMapLambda_skip_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			for (T1 t1 : arg0.apply(t0)) {
				skip0++;
				if(skip0 <= arg1) {
					continue;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sorted_flatMapLambda_distinct_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Collector<? super T1, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		Set<T1> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!distinct0.add(t1)) {
					continue;
				}
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sorted_flatMapLambda_dropWhile_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			for (T1 t1 : arg0.apply(t0)) {
				if(dropWhile0 && arg1.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sorted_flatMapLambda_takeWhile_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!arg1.test(t1)) {
					break;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_sorted_flatMapLambda_flatMapLambda_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, Collection<T2>> arg1, Collector<? super T2, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			for (T1 t1 : arg0.apply(t0)) {
				for (T2 t2 : arg1.apply(t1)) {
					arg2.accumulator().accept(result, t2);
				}
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_sorted_flatMapLambda_flatMapMemberReference_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Collector<? super T2, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			for (T1 t1 : arg0.apply(t0)) {
				for (T2 t2 : t1) {
					arg1.accumulator().accept(result, t2);
				}
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_sorted_flatMapMemberReference_map_collectCollector(Collection<T0> input, Function<T1, T2> arg0, Collector<? super T2, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			for (T1 t1 : t0) {
				T2 t2 = arg0.apply(t1);
				arg1.accumulator().accept(result, t2);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_sorted_flatMapMemberReference_filter_collectCollector(Collection<T0> input, Predicate<T1> arg0, Collector<? super T1, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			for (T1 t1 : t0) {
				if (!arg0.test(t1)) {
					continue;
				}
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_sorted_flatMapMemberReference_sorted_collectCollector(Collection<T0> input, Collector<? super T1, A, R> arg0) {
		List<T0> sorted0 = new ArrayList<>();
		List<T1> sorted1 = new ArrayList<>();
		A result = arg0.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			for (T1 t1 : t0) {
				sorted1.add(t1);
			}
		}
		sorted1.sort(null);
		for (T1 t1: sorted1) {
			arg0.accumulator().accept(result, t1);
		}
		return arg0.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_sorted_flatMapMemberReference_sortedComp_collectCollector(Collection<T0> input, Comparator<? super T1> arg0, Collector<? super T1, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			for (T1 t1 : t0) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg0);
		for (T1 t1: sortedComp0) {
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_sorted_flatMapMemberReference_limit_collectCollector(Collection<T0> input, long arg0, Collector<? super T1, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			for (T1 t1 : t0) {
				limit0++;
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_sorted_flatMapMemberReference_skip_collectCollector(Collection<T0> input, long arg0, Collector<? super T1, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			for (T1 t1 : t0) {
				skip0++;
				if(skip0 <= arg0) {
					continue;
				}
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_sorted_flatMapMemberReference_distinct_collectCollector(Collection<T0> input, Collector<? super T1, A, R> arg0) {
		List<T0> sorted0 = new ArrayList<>();
		Set<T1> distinct0 = new HashSet<>();
		A result = arg0.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			for (T1 t1 : t0) {
				if(!distinct0.add(t1)) {
					continue;
				}
				arg0.accumulator().accept(result, t1);
			}
		}
		return arg0.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_sorted_flatMapMemberReference_dropWhile_collectCollector(Collection<T0> input, Predicate<T1> arg0, Collector<? super T1, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			for (T1 t1 : t0) {
				if(dropWhile0 && arg0.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_sorted_flatMapMemberReference_takeWhile_collectCollector(Collection<T0> input, Predicate<T1> arg0, Collector<? super T1, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			for (T1 t1 : t0) {
				if(!arg0.test(t1)) {
					break;
				}
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_sorted_flatMapMemberReference_flatMapLambda_collectCollector(Collection<T0> input, Function<T1, Collection<T2>> arg0, Collector<? super T2, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			for (T1 t1 : t0) {
				for (T2 t2 : arg0.apply(t1)) {
					arg1.accumulator().accept(result, t2);
				}
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1 extends Collection<T2>, T2, R, A> R stream_sorted_flatMapMemberReference_flatMapMemberReference_collectCollector(Collection<T0> input, Collector<? super T2, A, R> arg0) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg0.supplier().get();
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			for (T1 t1 : t0) {
				for (T2 t2 : t1) {
					arg0.accumulator().accept(result, t2);
				}
			}
		}
		return arg0.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_sortedComp_map_map_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, T1> arg1, Function<T1, T2> arg2, Collector<? super T2, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			T1 t1 = arg1.apply(t0);
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sortedComp_map_filter_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, T1> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			T1 t1 = arg1.apply(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sortedComp_map_sorted_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T1> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			T1 t1 = arg1.apply(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sortedComp_map_sortedComp_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, T1> arg1, Comparator<? super T1> arg2, Collector<? super T1, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T1> sortedComp1 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			T1 t1 = arg1.apply(t0);
			sortedComp1.add(t1);
		}
		sortedComp1.sort(arg2);
		for (T1 t1: sortedComp1) {
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sortedComp_map_limit_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, T1> arg1, long arg2, Collector<? super T1, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			T1 t1 = arg1.apply(t0);
			limit0++;
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sortedComp_map_skip_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, T1> arg1, long arg2, Collector<? super T1, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			T1 t1 = arg1.apply(t0);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sortedComp_map_distinct_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T1> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			T1 t1 = arg1.apply(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sortedComp_map_dropWhile_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, T1> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			T1 t1 = arg1.apply(t0);
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sortedComp_map_takeWhile_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, T1> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			T1 t1 = arg1.apply(t0);
			if(!arg2.test(t1)) {
				break;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_sortedComp_map_flatMapLambda_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, T1> arg1, Function<T1, Collection<T2>> arg2, Collector<? super T2, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			T1 t1 = arg1.apply(t0);
			for (T2 t2 : arg2.apply(t1)) {
				arg3.accumulator().accept(result, t2);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_sortedComp_map_flatMapMemberReference_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, T1> arg1, Collector<? super T2, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			T1 t1 = arg1.apply(t0);
			for (T2 t2 : t1) {
				arg2.accumulator().accept(result, t2);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sortedComp_filter_map_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Function<T0, T1> arg2, Collector<? super T1, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if (!arg1.test(t0)) {
				continue;
			}
			T1 t1 = arg2.apply(t0);
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_filter_filter_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if (!arg1.test(t0)) {
				continue;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_filter_sorted_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if (!arg1.test(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_filter_sortedComp_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Comparator<? super T0> arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if (!arg1.test(t0)) {
				continue;
			}
			sortedComp1.add(t0);
		}
		sortedComp1.sort(arg2);
		for (T0 t0: sortedComp1) {
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_filter_limit_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if (!arg1.test(t0)) {
				continue;
			}
			limit0++;
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_filter_skip_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if (!arg1.test(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_filter_distinct_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if (!arg1.test(t0)) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_filter_dropWhile_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if (!arg1.test(t0)) {
				continue;
			}
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_filter_takeWhile_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if (!arg1.test(t0)) {
				continue;
			}
			if(!arg2.test(t0)) {
				break;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sortedComp_filter_flatMapLambda_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Function<T0, Collection<T1>> arg2, Collector<? super T1, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if (!arg1.test(t0)) {
				continue;
			}
			for (T1 t1 : arg2.apply(t0)) {
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_sortedComp_filter_flatMapMemberReference_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if (!arg1.test(t0)) {
				continue;
			}
			for (T1 t1 : t0) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_sortedComp_mapToInt_mapToObj_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, ToIntFunction<T0> arg1, IntFunction<T2> arg2, Collector<? super T2, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			int t1 = arg1.applyAsInt(t0);
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_mapToInt_boxed_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, ToIntFunction<T0> arg1, Collector<? super Integer, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			int t1 = arg1.applyAsInt(t0);
			Integer t2 = t1;
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_sortedComp_mapToLong_mapToObj_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, ToLongFunction<T0> arg1, LongFunction<T2> arg2, Collector<? super T2, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			long t1 = arg1.applyAsLong(t0);
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_mapToLong_boxed_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, ToLongFunction<T0> arg1, Collector<? super Long, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			long t1 = arg1.applyAsLong(t0);
			Long t2 = t1;
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_sortedComp_mapToDouble_mapToObj_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, ToDoubleFunction<T0> arg1, DoubleFunction<T2> arg2, Collector<? super T2, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			double t1 = arg1.applyAsDouble(t0);
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_mapToDouble_boxed_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, ToDoubleFunction<T0> arg1, Collector<? super Double, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			double t1 = arg1.applyAsDouble(t0);
			Double t2 = t1;
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sortedComp_sorted_map_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			T1 t1 = arg1.apply(t0);
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_sorted_filter_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if (!arg1.test(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_sorted_sorted_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Collector<? super T0, A, R> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			sorted1.add(t0);
		}
		sorted1.sort(null);
		for (T0 t0: sorted1) {
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_sorted_sortedComp_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Comparator<? super T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			sortedComp1.add(t0);
		}
		sortedComp1.sort(arg1);
		for (T0 t0: sortedComp1) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_sorted_limit_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			limit0++;
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_sorted_skip_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_sorted_distinct_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Collector<? super T0, A, R> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_sorted_dropWhile_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_sorted_takeWhile_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(!arg1.test(t0)) {
				break;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sortedComp_sorted_flatMapLambda_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, Collection<T1>> arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			for (T1 t1 : arg1.apply(t0)) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_sortedComp_sorted_flatMapMemberReference_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Collector<? super T1, A, R> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			for (T1 t1 : t0) {
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sortedComp_sortedComp_map_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Comparator<? super T0> arg1, Function<T0, T1> arg2, Collector<? super T1, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sortedComp1.add(t0);
		}
		sortedComp1.sort(arg1);
		for (T0 t0: sortedComp1) {
			T1 t1 = arg2.apply(t0);
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_sortedComp_filter_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Comparator<? super T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sortedComp1.add(t0);
		}
		sortedComp1.sort(arg1);
		for (T0 t0: sortedComp1) {
			if (!arg2.test(t0)) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_sortedComp_sorted_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Comparator<? super T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sortedComp1.add(t0);
		}
		sortedComp1.sort(arg1);
		for (T0 t0: sortedComp1) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_sortedComp_sortedComp_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Comparator<? super T0> arg1, Comparator<? super T0> arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		List<T0> sortedComp2 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sortedComp1.add(t0);
		}
		sortedComp1.sort(arg1);
		for (T0 t0: sortedComp1) {
			sortedComp2.add(t0);
		}
		sortedComp2.sort(arg2);
		for (T0 t0: sortedComp2) {
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_sortedComp_limit_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Comparator<? super T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sortedComp1.add(t0);
		}
		sortedComp1.sort(arg1);
		for (T0 t0: sortedComp1) {
			limit0++;
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_sortedComp_skip_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Comparator<? super T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sortedComp1.add(t0);
		}
		sortedComp1.sort(arg1);
		for (T0 t0: sortedComp1) {
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_sortedComp_distinct_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Comparator<? super T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sortedComp1.add(t0);
		}
		sortedComp1.sort(arg1);
		for (T0 t0: sortedComp1) {
			if(!distinct0.add(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_sortedComp_dropWhile_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Comparator<? super T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sortedComp1.add(t0);
		}
		sortedComp1.sort(arg1);
		for (T0 t0: sortedComp1) {
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_sortedComp_takeWhile_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Comparator<? super T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sortedComp1.add(t0);
		}
		sortedComp1.sort(arg1);
		for (T0 t0: sortedComp1) {
			if(!arg2.test(t0)) {
				break;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sortedComp_sortedComp_flatMapLambda_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Comparator<? super T0> arg1, Function<T0, Collection<T1>> arg2, Collector<? super T1, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sortedComp1.add(t0);
		}
		sortedComp1.sort(arg1);
		for (T0 t0: sortedComp1) {
			for (T1 t1 : arg2.apply(t0)) {
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_sortedComp_sortedComp_flatMapMemberReference_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Comparator<? super T0> arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sortedComp1.add(t0);
		}
		sortedComp1.sort(arg1);
		for (T0 t0: sortedComp1) {
			for (T1 t1 : t0) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sortedComp_limit_map_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, long arg1, Function<T0, T1> arg2, Collector<? super T1, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			limit0++;
			T1 t1 = arg2.apply(t0);
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_limit_filter_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, long arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			limit0++;
			if (!arg2.test(t0)) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_limit_sorted_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			limit0++;
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_limit_sortedComp_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, long arg1, Comparator<? super T0> arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp1 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			limit0++;
			sortedComp1.add(t0);
		}
		sortedComp1.sort(arg2);
		for (T0 t0: sortedComp1) {
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_limit_limit_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, long arg1, long arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(limit1 >= arg2) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			limit0++;
			limit1++;
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_limit_skip_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, long arg1, long arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			limit0++;
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_limit_distinct_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			limit0++;
			if(!distinct0.add(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_limit_dropWhile_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, long arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			limit0++;
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_limit_takeWhile_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, long arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			limit0++;
			if(!arg2.test(t0)) {
				break;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sortedComp_limit_flatMapLambda_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, long arg1, Function<T0, Collection<T1>> arg2, Collector<? super T1, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			limit0++;
			for (T1 t1 : arg2.apply(t0)) {
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_sortedComp_limit_flatMapMemberReference_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			limit0++;
			for (T1 t1 : t0) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sortedComp_skip_map_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, long arg1, Function<T0, T1> arg2, Collector<? super T1, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			T1 t1 = arg2.apply(t0);
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_skip_filter_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, long arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_skip_sorted_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_skip_sortedComp_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, long arg1, Comparator<? super T0> arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp1 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			sortedComp1.add(t0);
		}
		sortedComp1.sort(arg2);
		for (T0 t0: sortedComp1) {
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_skip_limit_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, long arg1, long arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			limit0++;
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_skip_skip_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, long arg1, long arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			skip1++;
			if(skip1 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_skip_distinct_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_skip_dropWhile_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, long arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_skip_takeWhile_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, long arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if(!arg2.test(t0)) {
				break;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sortedComp_skip_flatMapLambda_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, long arg1, Function<T0, Collection<T1>> arg2, Collector<? super T1, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			for (T1 t1 : arg2.apply(t0)) {
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_sortedComp_skip_flatMapMemberReference_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			for (T1 t1 : t0) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sortedComp_distinct_map_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_distinct_filter_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_distinct_sorted_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Collector<? super T0, A, R> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_distinct_sortedComp_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Comparator<? super T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sortedComp1 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sortedComp1.add(t0);
		}
		sortedComp1.sort(arg1);
		for (T0 t0: sortedComp1) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_distinct_limit_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			limit0++;
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_distinct_skip_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_distinct_distinct_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Collector<? super T0, A, R> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		Set<T0> distinct1 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!distinct1.add(t0)) {
				continue;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_distinct_dropWhile_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_distinct_takeWhile_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sortedComp_distinct_flatMapLambda_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, Collection<T1>> arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_sortedComp_distinct_flatMapMemberReference_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Collector<? super T1, A, R> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : t0) {
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sortedComp_dropWhile_map_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Function<T0, T1> arg2, Collector<? super T1, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			T1 t1 = arg2.apply(t0);
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_dropWhile_filter_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_dropWhile_sorted_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_dropWhile_sortedComp_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Comparator<? super T0> arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		List<T0> sortedComp1 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sortedComp1.add(t0);
		}
		sortedComp1.sort(arg2);
		for (T0 t0: sortedComp1) {
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_dropWhile_limit_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			limit0++;
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_dropWhile_skip_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_dropWhile_distinct_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_dropWhile_dropWhile_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(dropWhile1 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile1 = false;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_dropWhile_takeWhile_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!arg2.test(t0)) {
				break;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sortedComp_dropWhile_flatMapLambda_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Function<T0, Collection<T1>> arg2, Collector<? super T1, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : arg2.apply(t0)) {
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_sortedComp_dropWhile_flatMapMemberReference_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : t0) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sortedComp_takeWhile_map_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Function<T0, T1> arg2, Collector<? super T1, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!arg1.test(t0)) {
				break;
			}
			T1 t1 = arg2.apply(t0);
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_takeWhile_filter_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!arg1.test(t0)) {
				break;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_takeWhile_sorted_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!arg1.test(t0)) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_takeWhile_sortedComp_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Comparator<? super T0> arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!arg1.test(t0)) {
				break;
			}
			sortedComp1.add(t0);
		}
		sortedComp1.sort(arg2);
		for (T0 t0: sortedComp1) {
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_takeWhile_limit_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!arg1.test(t0)) {
				break;
			}
			limit0++;
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_takeWhile_skip_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!arg1.test(t0)) {
				break;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_takeWhile_distinct_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!arg1.test(t0)) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_takeWhile_dropWhile_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!arg1.test(t0)) {
				break;
			}
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_sortedComp_takeWhile_takeWhile_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!arg1.test(t0)) {
				break;
			}
			if(!arg2.test(t0)) {
				break;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sortedComp_takeWhile_flatMapLambda_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Function<T0, Collection<T1>> arg2, Collector<? super T1, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!arg1.test(t0)) {
				break;
			}
			for (T1 t1 : arg2.apply(t0)) {
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_sortedComp_takeWhile_flatMapMemberReference_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!arg1.test(t0)) {
				break;
			}
			for (T1 t1 : t0) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_sortedComp_flatMapLambda_map_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, Collection<T1>> arg1, Function<T1, T2> arg2, Collector<? super T2, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : arg1.apply(t0)) {
				T2 t2 = arg2.apply(t1);
				arg3.accumulator().accept(result, t2);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sortedComp_flatMapLambda_filter_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, Collection<T1>> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : arg1.apply(t0)) {
				if (!arg2.test(t1)) {
					continue;
				}
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sortedComp_flatMapLambda_sorted_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, Collection<T1>> arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T1> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : arg1.apply(t0)) {
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sortedComp_flatMapLambda_sortedComp_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, Collection<T1>> arg1, Comparator<? super T1> arg2, Collector<? super T1, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T1> sortedComp1 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : arg1.apply(t0)) {
				sortedComp1.add(t1);
			}
		}
		sortedComp1.sort(arg2);
		for (T1 t1: sortedComp1) {
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sortedComp_flatMapLambda_limit_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, Collection<T1>> arg1, long arg2, Collector<? super T1, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : arg1.apply(t0)) {
				limit0++;
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sortedComp_flatMapLambda_skip_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, Collection<T1>> arg1, long arg2, Collector<? super T1, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : arg1.apply(t0)) {
				skip0++;
				if(skip0 <= arg2) {
					continue;
				}
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sortedComp_flatMapLambda_distinct_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, Collection<T1>> arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T1> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : arg1.apply(t0)) {
				if(!distinct0.add(t1)) {
					continue;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sortedComp_flatMapLambda_dropWhile_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, Collection<T1>> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : arg1.apply(t0)) {
				if(dropWhile0 && arg2.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_sortedComp_flatMapLambda_takeWhile_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, Collection<T1>> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : arg1.apply(t0)) {
				if(!arg2.test(t1)) {
					break;
				}
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_sortedComp_flatMapLambda_flatMapLambda_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, Collection<T1>> arg1, Function<T1, Collection<T2>> arg2, Collector<? super T2, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : arg1.apply(t0)) {
				for (T2 t2 : arg2.apply(t1)) {
					arg3.accumulator().accept(result, t2);
				}
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_sortedComp_flatMapLambda_flatMapMemberReference_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, Collection<T1>> arg1, Collector<? super T2, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : arg1.apply(t0)) {
				for (T2 t2 : t1) {
					arg2.accumulator().accept(result, t2);
				}
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_sortedComp_flatMapMemberReference_map_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Function<T1, T2> arg1, Collector<? super T2, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : t0) {
				T2 t2 = arg1.apply(t1);
				arg2.accumulator().accept(result, t2);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_sortedComp_flatMapMemberReference_filter_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : t0) {
				if (!arg1.test(t1)) {
					continue;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_sortedComp_flatMapMemberReference_sorted_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Collector<? super T1, A, R> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T1> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : t0) {
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_sortedComp_flatMapMemberReference_sortedComp_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Comparator<? super T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T1> sortedComp1 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : t0) {
				sortedComp1.add(t1);
			}
		}
		sortedComp1.sort(arg1);
		for (T1 t1: sortedComp1) {
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_sortedComp_flatMapMemberReference_limit_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : t0) {
				limit0++;
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_sortedComp_flatMapMemberReference_skip_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : t0) {
				skip0++;
				if(skip0 <= arg1) {
					continue;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_sortedComp_flatMapMemberReference_distinct_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Collector<? super T1, A, R> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T1> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : t0) {
				if(!distinct0.add(t1)) {
					continue;
				}
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_sortedComp_flatMapMemberReference_dropWhile_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : t0) {
				if(dropWhile0 && arg1.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_sortedComp_flatMapMemberReference_takeWhile_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : t0) {
				if(!arg1.test(t1)) {
					break;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_sortedComp_flatMapMemberReference_flatMapLambda_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Function<T1, Collection<T2>> arg1, Collector<? super T2, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : t0) {
				for (T2 t2 : arg1.apply(t1)) {
					arg2.accumulator().accept(result, t2);
				}
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1 extends Collection<T2>, T2, R, A> R stream_sortedComp_flatMapMemberReference_flatMapMemberReference_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Collector<? super T2, A, R> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : t0) {
				for (T2 t2 : t1) {
					arg1.accumulator().accept(result, t2);
				}
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_limit_map_map_collectCollector(Collection<T0> input, long arg0, Function<T0, T1> arg1, Function<T1, T2> arg2, Collector<? super T2, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			T1 t1 = arg1.apply(t0);
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_limit_map_filter_collectCollector(Collection<T0> input, long arg0, Function<T0, T1> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			T1 t1 = arg1.apply(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_limit_map_sorted_collectCollector(Collection<T0> input, long arg0, Function<T0, T1> arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			T1 t1 = arg1.apply(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_limit_map_sortedComp_collectCollector(Collection<T0> input, long arg0, Function<T0, T1> arg1, Comparator<? super T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			T1 t1 = arg1.apply(t0);
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg2);
		for (T1 t1: sortedComp0) {
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_limit_map_limit_collectCollector(Collection<T0> input, long arg0, Function<T0, T1> arg1, long arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(limit1 >= arg2) {
				break;
			}
			limit0++;
			T1 t1 = arg1.apply(t0);
			limit1++;
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_limit_map_skip_collectCollector(Collection<T0> input, long arg0, Function<T0, T1> arg1, long arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			T1 t1 = arg1.apply(t0);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_limit_map_distinct_collectCollector(Collection<T0> input, long arg0, Function<T0, T1> arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T1> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			T1 t1 = arg1.apply(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_limit_map_dropWhile_collectCollector(Collection<T0> input, long arg0, Function<T0, T1> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			T1 t1 = arg1.apply(t0);
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_limit_map_takeWhile_collectCollector(Collection<T0> input, long arg0, Function<T0, T1> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			T1 t1 = arg1.apply(t0);
			if(!arg2.test(t1)) {
				break;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_limit_map_flatMapLambda_collectCollector(Collection<T0> input, long arg0, Function<T0, T1> arg1, Function<T1, Collection<T2>> arg2, Collector<? super T2, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			T1 t1 = arg1.apply(t0);
			for (T2 t2 : arg2.apply(t1)) {
				arg3.accumulator().accept(result, t2);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_limit_map_flatMapMemberReference_collectCollector(Collection<T0> input, long arg0, Function<T0, T1> arg1, Collector<? super T2, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			T1 t1 = arg1.apply(t0);
			for (T2 t2 : t1) {
				arg2.accumulator().accept(result, t2);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_limit_filter_map_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Function<T0, T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if (!arg1.test(t0)) {
				continue;
			}
			T1 t1 = arg2.apply(t0);
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_filter_filter_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if (!arg1.test(t0)) {
				continue;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_filter_sorted_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if (!arg1.test(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_filter_sortedComp_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Comparator<? super T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if (!arg1.test(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_filter_limit_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(limit1 >= arg2) {
				break;
			}
			limit0++;
			if (!arg1.test(t0)) {
				continue;
			}
			limit1++;
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_filter_skip_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if (!arg1.test(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_filter_distinct_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if (!arg1.test(t0)) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_filter_dropWhile_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if (!arg1.test(t0)) {
				continue;
			}
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_filter_takeWhile_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if (!arg1.test(t0)) {
				continue;
			}
			if(!arg2.test(t0)) {
				break;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_limit_filter_flatMapLambda_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Function<T0, Collection<T1>> arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if (!arg1.test(t0)) {
				continue;
			}
			for (T1 t1 : arg2.apply(t0)) {
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_limit_filter_flatMapMemberReference_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if (!arg1.test(t0)) {
				continue;
			}
			for (T1 t1 : t0) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_limit_mapToInt_mapToObj_collectCollector(Collection<T0> input, long arg0, ToIntFunction<T0> arg1, IntFunction<T2> arg2, Collector<? super T2, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			int t1 = arg1.applyAsInt(t0);
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_mapToInt_boxed_collectCollector(Collection<T0> input, long arg0, ToIntFunction<T0> arg1, Collector<? super Integer, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			int t1 = arg1.applyAsInt(t0);
			Integer t2 = t1;
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_limit_mapToLong_mapToObj_collectCollector(Collection<T0> input, long arg0, ToLongFunction<T0> arg1, LongFunction<T2> arg2, Collector<? super T2, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			long t1 = arg1.applyAsLong(t0);
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_mapToLong_boxed_collectCollector(Collection<T0> input, long arg0, ToLongFunction<T0> arg1, Collector<? super Long, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			long t1 = arg1.applyAsLong(t0);
			Long t2 = t1;
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_limit_mapToDouble_mapToObj_collectCollector(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1, DoubleFunction<T2> arg2, Collector<? super T2, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			double t1 = arg1.applyAsDouble(t0);
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_mapToDouble_boxed_collectCollector(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1, Collector<? super Double, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			double t1 = arg1.applyAsDouble(t0);
			Double t2 = t1;
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_limit_sorted_map_collectCollector(Collection<T0> input, long arg0, Function<T0, T1> arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			T1 t1 = arg1.apply(t0);
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_sorted_filter_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if (!arg1.test(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_sorted_sorted_collectCollector(Collection<T0> input, long arg0, Collector<? super T0, A, R> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			sorted1.add(t0);
		}
		sorted1.sort(null);
		for (T0 t0: sorted1) {
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_sorted_sortedComp_collectCollector(Collection<T0> input, long arg0, Comparator<? super T0> arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_sorted_limit_collectCollector(Collection<T0> input, long arg0, long arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(limit1 >= arg1) {
				break;
			}
			limit0++;
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			limit1++;
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_sorted_skip_collectCollector(Collection<T0> input, long arg0, long arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_sorted_distinct_collectCollector(Collection<T0> input, long arg0, Collector<? super T0, A, R> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_sorted_dropWhile_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_sorted_takeWhile_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(!arg1.test(t0)) {
				break;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_limit_sorted_flatMapLambda_collectCollector(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			for (T1 t1 : arg1.apply(t0)) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_limit_sorted_flatMapMemberReference_collectCollector(Collection<T0> input, long arg0, Collector<? super T1, A, R> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			for (T1 t1 : t0) {
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_limit_sortedComp_map_collectCollector(Collection<T0> input, long arg0, Comparator<? super T0> arg1, Function<T0, T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			T1 t1 = arg2.apply(t0);
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_sortedComp_filter_collectCollector(Collection<T0> input, long arg0, Comparator<? super T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			if (!arg2.test(t0)) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_sortedComp_sorted_collectCollector(Collection<T0> input, long arg0, Comparator<? super T0> arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_sortedComp_sortedComp_collectCollector(Collection<T0> input, long arg0, Comparator<? super T0> arg1, Comparator<? super T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			sortedComp1.add(t0);
		}
		sortedComp1.sort(arg2);
		for (T0 t0: sortedComp1) {
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_sortedComp_limit_collectCollector(Collection<T0> input, long arg0, Comparator<? super T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(limit1 >= arg2) {
				break;
			}
			limit0++;
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			limit1++;
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_sortedComp_skip_collectCollector(Collection<T0> input, long arg0, Comparator<? super T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_sortedComp_distinct_collectCollector(Collection<T0> input, long arg0, Comparator<? super T0> arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_sortedComp_dropWhile_collectCollector(Collection<T0> input, long arg0, Comparator<? super T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_sortedComp_takeWhile_collectCollector(Collection<T0> input, long arg0, Comparator<? super T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			if(!arg2.test(t0)) {
				break;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_limit_sortedComp_flatMapLambda_collectCollector(Collection<T0> input, long arg0, Comparator<? super T0> arg1, Function<T0, Collection<T1>> arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : arg2.apply(t0)) {
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_limit_sortedComp_flatMapMemberReference_collectCollector(Collection<T0> input, long arg0, Comparator<? super T0> arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : t0) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_limit_limit_map_collectCollector(Collection<T0> input, long arg0, long arg1, Function<T0, T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(limit1 >= arg1) {
				break;
			}
			limit0++;
			limit1++;
			T1 t1 = arg2.apply(t0);
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_limit_filter_collectCollector(Collection<T0> input, long arg0, long arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(limit1 >= arg1) {
				break;
			}
			limit0++;
			limit1++;
			if (!arg2.test(t0)) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_limit_sorted_collectCollector(Collection<T0> input, long arg0, long arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(limit1 >= arg1) {
				break;
			}
			limit0++;
			limit1++;
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_limit_sortedComp_collectCollector(Collection<T0> input, long arg0, long arg1, Comparator<? super T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(limit1 >= arg1) {
				break;
			}
			limit0++;
			limit1++;
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_limit_limit_collectCollector(Collection<T0> input, long arg0, long arg1, long arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit2 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(limit1 >= arg1) {
				break;
			}
			if(limit2 >= arg2) {
				break;
			}
			limit0++;
			limit1++;
			limit2++;
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_limit_skip_collectCollector(Collection<T0> input, long arg0, long arg1, long arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(limit1 >= arg1) {
				break;
			}
			limit0++;
			limit1++;
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_limit_distinct_collectCollector(Collection<T0> input, long arg0, long arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(limit1 >= arg1) {
				break;
			}
			limit0++;
			limit1++;
			if(!distinct0.add(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_limit_dropWhile_collectCollector(Collection<T0> input, long arg0, long arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(limit1 >= arg1) {
				break;
			}
			limit0++;
			limit1++;
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_limit_takeWhile_collectCollector(Collection<T0> input, long arg0, long arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(limit1 >= arg1) {
				break;
			}
			limit0++;
			limit1++;
			if(!arg2.test(t0)) {
				break;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_limit_limit_flatMapLambda_collectCollector(Collection<T0> input, long arg0, long arg1, Function<T0, Collection<T1>> arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(limit1 >= arg1) {
				break;
			}
			limit0++;
			limit1++;
			for (T1 t1 : arg2.apply(t0)) {
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_limit_limit_flatMapMemberReference_collectCollector(Collection<T0> input, long arg0, long arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(limit1 >= arg1) {
				break;
			}
			limit0++;
			limit1++;
			for (T1 t1 : t0) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_limit_skip_map_collectCollector(Collection<T0> input, long arg0, long arg1, Function<T0, T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			T1 t1 = arg2.apply(t0);
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_skip_filter_collectCollector(Collection<T0> input, long arg0, long arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_skip_sorted_collectCollector(Collection<T0> input, long arg0, long arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_skip_sortedComp_collectCollector(Collection<T0> input, long arg0, long arg1, Comparator<? super T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_skip_limit_collectCollector(Collection<T0> input, long arg0, long arg1, long arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(limit1 >= arg2) {
				break;
			}
			limit0++;
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			limit1++;
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_skip_skip_collectCollector(Collection<T0> input, long arg0, long arg1, long arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			skip1++;
			if(skip1 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_skip_distinct_collectCollector(Collection<T0> input, long arg0, long arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_skip_dropWhile_collectCollector(Collection<T0> input, long arg0, long arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_skip_takeWhile_collectCollector(Collection<T0> input, long arg0, long arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if(!arg2.test(t0)) {
				break;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_limit_skip_flatMapLambda_collectCollector(Collection<T0> input, long arg0, long arg1, Function<T0, Collection<T1>> arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			for (T1 t1 : arg2.apply(t0)) {
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_limit_skip_flatMapMemberReference_collectCollector(Collection<T0> input, long arg0, long arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			for (T1 t1 : t0) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_limit_distinct_map_collectCollector(Collection<T0> input, long arg0, Function<T0, T1> arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if(!distinct0.add(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_distinct_filter_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if(!distinct0.add(t0)) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_distinct_sorted_collectCollector(Collection<T0> input, long arg0, Collector<? super T0, A, R> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if(!distinct0.add(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_distinct_sortedComp_collectCollector(Collection<T0> input, long arg0, Comparator<? super T0> arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if(!distinct0.add(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_distinct_limit_collectCollector(Collection<T0> input, long arg0, long arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(limit1 >= arg1) {
				break;
			}
			limit0++;
			if(!distinct0.add(t0)) {
				continue;
			}
			limit1++;
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_distinct_skip_collectCollector(Collection<T0> input, long arg0, long arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if(!distinct0.add(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_distinct_distinct_collectCollector(Collection<T0> input, long arg0, Collector<? super T0, A, R> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		Set<T0> distinct1 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!distinct1.add(t0)) {
				continue;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_distinct_dropWhile_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if(!distinct0.add(t0)) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_distinct_takeWhile_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_limit_distinct_flatMapLambda_collectCollector(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_limit_distinct_flatMapMemberReference_collectCollector(Collection<T0> input, long arg0, Collector<? super T1, A, R> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : t0) {
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_limit_dropWhile_map_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Function<T0, T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			T1 t1 = arg2.apply(t0);
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_dropWhile_filter_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_dropWhile_sorted_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_dropWhile_sortedComp_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Comparator<? super T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_dropWhile_limit_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(limit1 >= arg2) {
				break;
			}
			limit0++;
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			limit1++;
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_dropWhile_skip_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_dropWhile_distinct_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_dropWhile_dropWhile_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(dropWhile1 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile1 = false;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_dropWhile_takeWhile_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!arg2.test(t0)) {
				break;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_limit_dropWhile_flatMapLambda_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Function<T0, Collection<T1>> arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : arg2.apply(t0)) {
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_limit_dropWhile_flatMapMemberReference_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : t0) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_limit_takeWhile_map_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Function<T0, T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if(!arg1.test(t0)) {
				break;
			}
			T1 t1 = arg2.apply(t0);
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_takeWhile_filter_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if(!arg1.test(t0)) {
				break;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_takeWhile_sorted_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if(!arg1.test(t0)) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_takeWhile_sortedComp_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Comparator<? super T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if(!arg1.test(t0)) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_takeWhile_limit_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(limit1 >= arg2) {
				break;
			}
			limit0++;
			if(!arg1.test(t0)) {
				break;
			}
			limit1++;
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_takeWhile_skip_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if(!arg1.test(t0)) {
				break;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_takeWhile_distinct_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if(!arg1.test(t0)) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_takeWhile_dropWhile_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if(!arg1.test(t0)) {
				break;
			}
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_limit_takeWhile_takeWhile_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if(!arg1.test(t0)) {
				break;
			}
			if(!arg2.test(t0)) {
				break;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_limit_takeWhile_flatMapLambda_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Function<T0, Collection<T1>> arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if(!arg1.test(t0)) {
				break;
			}
			for (T1 t1 : arg2.apply(t0)) {
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_limit_takeWhile_flatMapMemberReference_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if(!arg1.test(t0)) {
				break;
			}
			for (T1 t1 : t0) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_limit_flatMapLambda_map_collectCollector(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, Function<T1, T2> arg2, Collector<? super T2, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			for (T1 t1 : arg1.apply(t0)) {
				T2 t2 = arg2.apply(t1);
				arg3.accumulator().accept(result, t2);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_limit_flatMapLambda_filter_collectCollector(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			for (T1 t1 : arg1.apply(t0)) {
				if (!arg2.test(t1)) {
					continue;
				}
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_limit_flatMapLambda_sorted_collectCollector(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			for (T1 t1 : arg1.apply(t0)) {
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_limit_flatMapLambda_sortedComp_collectCollector(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, Comparator<? super T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			for (T1 t1 : arg1.apply(t0)) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg2);
		for (T1 t1: sortedComp0) {
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_limit_flatMapLambda_limit_collectCollector(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, long arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(limit1 >= arg2) {
				break;
			}
			limit0++;
			for (T1 t1 : arg1.apply(t0)) {
				limit1++;
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_limit_flatMapLambda_skip_collectCollector(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, long arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			for (T1 t1 : arg1.apply(t0)) {
				skip0++;
				if(skip0 <= arg2) {
					continue;
				}
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_limit_flatMapLambda_distinct_collectCollector(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T1> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			for (T1 t1 : arg1.apply(t0)) {
				if(!distinct0.add(t1)) {
					continue;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_limit_flatMapLambda_dropWhile_collectCollector(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			for (T1 t1 : arg1.apply(t0)) {
				if(dropWhile0 && arg2.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_limit_flatMapLambda_takeWhile_collectCollector(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			for (T1 t1 : arg1.apply(t0)) {
				if(!arg2.test(t1)) {
					break;
				}
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_limit_flatMapLambda_flatMapLambda_collectCollector(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, Function<T1, Collection<T2>> arg2, Collector<? super T2, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			for (T1 t1 : arg1.apply(t0)) {
				for (T2 t2 : arg2.apply(t1)) {
					arg3.accumulator().accept(result, t2);
				}
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_limit_flatMapLambda_flatMapMemberReference_collectCollector(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, Collector<? super T2, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			for (T1 t1 : arg1.apply(t0)) {
				for (T2 t2 : t1) {
					arg2.accumulator().accept(result, t2);
				}
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_limit_flatMapMemberReference_map_collectCollector(Collection<T0> input, long arg0, Function<T1, T2> arg1, Collector<? super T2, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			for (T1 t1 : t0) {
				T2 t2 = arg1.apply(t1);
				arg2.accumulator().accept(result, t2);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_limit_flatMapMemberReference_filter_collectCollector(Collection<T0> input, long arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			for (T1 t1 : t0) {
				if (!arg1.test(t1)) {
					continue;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_limit_flatMapMemberReference_sorted_collectCollector(Collection<T0> input, long arg0, Collector<? super T1, A, R> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			for (T1 t1 : t0) {
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_limit_flatMapMemberReference_sortedComp_collectCollector(Collection<T0> input, long arg0, Comparator<? super T1> arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			for (T1 t1 : t0) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_limit_flatMapMemberReference_limit_collectCollector(Collection<T0> input, long arg0, long arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(limit1 >= arg1) {
				break;
			}
			limit0++;
			for (T1 t1 : t0) {
				limit1++;
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_limit_flatMapMemberReference_skip_collectCollector(Collection<T0> input, long arg0, long arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			for (T1 t1 : t0) {
				skip0++;
				if(skip0 <= arg1) {
					continue;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_limit_flatMapMemberReference_distinct_collectCollector(Collection<T0> input, long arg0, Collector<? super T1, A, R> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T1> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			for (T1 t1 : t0) {
				if(!distinct0.add(t1)) {
					continue;
				}
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_limit_flatMapMemberReference_dropWhile_collectCollector(Collection<T0> input, long arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			for (T1 t1 : t0) {
				if(dropWhile0 && arg1.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_limit_flatMapMemberReference_takeWhile_collectCollector(Collection<T0> input, long arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			for (T1 t1 : t0) {
				if(!arg1.test(t1)) {
					break;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_limit_flatMapMemberReference_flatMapLambda_collectCollector(Collection<T0> input, long arg0, Function<T1, Collection<T2>> arg1, Collector<? super T2, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			for (T1 t1 : t0) {
				for (T2 t2 : arg1.apply(t1)) {
					arg2.accumulator().accept(result, t2);
				}
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1 extends Collection<T2>, T2, R, A> R stream_limit_flatMapMemberReference_flatMapMemberReference_collectCollector(Collection<T0> input, long arg0, Collector<? super T2, A, R> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			for (T1 t1 : t0) {
				for (T2 t2 : t1) {
					arg1.accumulator().accept(result, t2);
				}
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_skip_map_map_collectCollector(Collection<T0> input, long arg0, Function<T0, T1> arg1, Function<T1, T2> arg2, Collector<? super T2, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_skip_map_filter_collectCollector(Collection<T0> input, long arg0, Function<T0, T1> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_skip_map_sorted_collectCollector(Collection<T0> input, long arg0, Function<T0, T1> arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_skip_map_sortedComp_collectCollector(Collection<T0> input, long arg0, Function<T0, T1> arg1, Comparator<? super T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg2);
		for (T1 t1: sortedComp0) {
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_skip_map_limit_collectCollector(Collection<T0> input, long arg0, Function<T0, T1> arg1, long arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			limit0++;
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_skip_map_skip_collectCollector(Collection<T0> input, long arg0, Function<T0, T1> arg1, long arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			skip1++;
			if(skip1 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_skip_map_distinct_collectCollector(Collection<T0> input, long arg0, Function<T0, T1> arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T1> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_skip_map_dropWhile_collectCollector(Collection<T0> input, long arg0, Function<T0, T1> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_skip_map_takeWhile_collectCollector(Collection<T0> input, long arg0, Function<T0, T1> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			if(!arg2.test(t1)) {
				break;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_skip_map_flatMapLambda_collectCollector(Collection<T0> input, long arg0, Function<T0, T1> arg1, Function<T1, Collection<T2>> arg2, Collector<? super T2, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			for (T2 t2 : arg2.apply(t1)) {
				arg3.accumulator().accept(result, t2);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_skip_map_flatMapMemberReference_collectCollector(Collection<T0> input, long arg0, Function<T0, T1> arg1, Collector<? super T2, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			for (T2 t2 : t1) {
				arg2.accumulator().accept(result, t2);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_skip_filter_map_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Function<T0, T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			T1 t1 = arg2.apply(t0);
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_filter_filter_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_filter_sorted_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_filter_sortedComp_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Comparator<? super T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_filter_limit_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			limit0++;
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_filter_skip_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			skip1++;
			if(skip1 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_filter_distinct_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_filter_dropWhile_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_filter_takeWhile_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			if(!arg2.test(t0)) {
				break;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_skip_filter_flatMapLambda_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Function<T0, Collection<T1>> arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			for (T1 t1 : arg2.apply(t0)) {
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_skip_filter_flatMapMemberReference_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			for (T1 t1 : t0) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_skip_mapToInt_mapToObj_collectCollector(Collection<T0> input, long arg0, ToIntFunction<T0> arg1, IntFunction<T2> arg2, Collector<? super T2, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_mapToInt_boxed_collectCollector(Collection<T0> input, long arg0, ToIntFunction<T0> arg1, Collector<? super Integer, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			Integer t2 = t1;
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_skip_mapToLong_mapToObj_collectCollector(Collection<T0> input, long arg0, ToLongFunction<T0> arg1, LongFunction<T2> arg2, Collector<? super T2, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_mapToLong_boxed_collectCollector(Collection<T0> input, long arg0, ToLongFunction<T0> arg1, Collector<? super Long, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			Long t2 = t1;
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_skip_mapToDouble_mapToObj_collectCollector(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1, DoubleFunction<T2> arg2, Collector<? super T2, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_mapToDouble_boxed_collectCollector(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1, Collector<? super Double, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			Double t2 = t1;
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_skip_sorted_map_collectCollector(Collection<T0> input, long arg0, Function<T0, T1> arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			T1 t1 = arg1.apply(t0);
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_sorted_filter_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if (!arg1.test(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_sorted_sorted_collectCollector(Collection<T0> input, long arg0, Collector<? super T0, A, R> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			sorted1.add(t0);
		}
		sorted1.sort(null);
		for (T0 t0: sorted1) {
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_sorted_sortedComp_collectCollector(Collection<T0> input, long arg0, Comparator<? super T0> arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_sorted_limit_collectCollector(Collection<T0> input, long arg0, long arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			limit0++;
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_sorted_skip_collectCollector(Collection<T0> input, long arg0, long arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			skip1++;
			if(skip1 <= arg1) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_sorted_distinct_collectCollector(Collection<T0> input, long arg0, Collector<? super T0, A, R> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_sorted_dropWhile_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_sorted_takeWhile_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(!arg1.test(t0)) {
				break;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_skip_sorted_flatMapLambda_collectCollector(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			for (T1 t1 : arg1.apply(t0)) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_skip_sorted_flatMapMemberReference_collectCollector(Collection<T0> input, long arg0, Collector<? super T1, A, R> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			for (T1 t1 : t0) {
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_skip_sortedComp_map_collectCollector(Collection<T0> input, long arg0, Comparator<? super T0> arg1, Function<T0, T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			T1 t1 = arg2.apply(t0);
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_sortedComp_filter_collectCollector(Collection<T0> input, long arg0, Comparator<? super T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			if (!arg2.test(t0)) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_sortedComp_sorted_collectCollector(Collection<T0> input, long arg0, Comparator<? super T0> arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_sortedComp_sortedComp_collectCollector(Collection<T0> input, long arg0, Comparator<? super T0> arg1, Comparator<? super T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			sortedComp1.add(t0);
		}
		sortedComp1.sort(arg2);
		for (T0 t0: sortedComp1) {
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_sortedComp_limit_collectCollector(Collection<T0> input, long arg0, Comparator<? super T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			limit0++;
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_sortedComp_skip_collectCollector(Collection<T0> input, long arg0, Comparator<? super T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			skip1++;
			if(skip1 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_sortedComp_distinct_collectCollector(Collection<T0> input, long arg0, Comparator<? super T0> arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_sortedComp_dropWhile_collectCollector(Collection<T0> input, long arg0, Comparator<? super T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_sortedComp_takeWhile_collectCollector(Collection<T0> input, long arg0, Comparator<? super T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			if(!arg2.test(t0)) {
				break;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_skip_sortedComp_flatMapLambda_collectCollector(Collection<T0> input, long arg0, Comparator<? super T0> arg1, Function<T0, Collection<T1>> arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : arg2.apply(t0)) {
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_skip_sortedComp_flatMapMemberReference_collectCollector(Collection<T0> input, long arg0, Comparator<? super T0> arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : t0) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_skip_limit_map_collectCollector(Collection<T0> input, long arg0, long arg1, Function<T0, T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			limit0++;
			T1 t1 = arg2.apply(t0);
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_limit_filter_collectCollector(Collection<T0> input, long arg0, long arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			limit0++;
			if (!arg2.test(t0)) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_limit_sorted_collectCollector(Collection<T0> input, long arg0, long arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			limit0++;
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_limit_sortedComp_collectCollector(Collection<T0> input, long arg0, long arg1, Comparator<? super T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			limit0++;
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_limit_limit_collectCollector(Collection<T0> input, long arg0, long arg1, long arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(limit1 >= arg2) {
				break;
			}
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			limit0++;
			limit1++;
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_limit_skip_collectCollector(Collection<T0> input, long arg0, long arg1, long arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			limit0++;
			skip1++;
			if(skip1 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_limit_distinct_collectCollector(Collection<T0> input, long arg0, long arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			limit0++;
			if(!distinct0.add(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_limit_dropWhile_collectCollector(Collection<T0> input, long arg0, long arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			limit0++;
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_limit_takeWhile_collectCollector(Collection<T0> input, long arg0, long arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			limit0++;
			if(!arg2.test(t0)) {
				break;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_skip_limit_flatMapLambda_collectCollector(Collection<T0> input, long arg0, long arg1, Function<T0, Collection<T1>> arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			limit0++;
			for (T1 t1 : arg2.apply(t0)) {
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_skip_limit_flatMapMemberReference_collectCollector(Collection<T0> input, long arg0, long arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			limit0++;
			for (T1 t1 : t0) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_skip_skip_map_collectCollector(Collection<T0> input, long arg0, long arg1, Function<T0, T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			skip1++;
			if(skip1 <= arg1) {
				continue;
			}
			T1 t1 = arg2.apply(t0);
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_skip_filter_collectCollector(Collection<T0> input, long arg0, long arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			skip1++;
			if(skip1 <= arg1) {
				continue;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_skip_sorted_collectCollector(Collection<T0> input, long arg0, long arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			skip1++;
			if(skip1 <= arg1) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_skip_sortedComp_collectCollector(Collection<T0> input, long arg0, long arg1, Comparator<? super T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			skip1++;
			if(skip1 <= arg1) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_skip_limit_collectCollector(Collection<T0> input, long arg0, long arg1, long arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			skip1++;
			if(skip1 <= arg1) {
				continue;
			}
			limit0++;
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_skip_skip_collectCollector(Collection<T0> input, long arg0, long arg1, long arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip2 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			skip1++;
			if(skip1 <= arg1) {
				continue;
			}
			skip2++;
			if(skip2 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_skip_distinct_collectCollector(Collection<T0> input, long arg0, long arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			skip1++;
			if(skip1 <= arg1) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_skip_dropWhile_collectCollector(Collection<T0> input, long arg0, long arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			skip1++;
			if(skip1 <= arg1) {
				continue;
			}
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_skip_takeWhile_collectCollector(Collection<T0> input, long arg0, long arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			skip1++;
			if(skip1 <= arg1) {
				continue;
			}
			if(!arg2.test(t0)) {
				break;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_skip_skip_flatMapLambda_collectCollector(Collection<T0> input, long arg0, long arg1, Function<T0, Collection<T1>> arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			skip1++;
			if(skip1 <= arg1) {
				continue;
			}
			for (T1 t1 : arg2.apply(t0)) {
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_skip_skip_flatMapMemberReference_collectCollector(Collection<T0> input, long arg0, long arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			skip1++;
			if(skip1 <= arg1) {
				continue;
			}
			for (T1 t1 : t0) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_skip_distinct_map_collectCollector(Collection<T0> input, long arg0, Function<T0, T1> arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_distinct_filter_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_distinct_sorted_collectCollector(Collection<T0> input, long arg0, Collector<? super T0, A, R> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_distinct_sortedComp_collectCollector(Collection<T0> input, long arg0, Comparator<? super T0> arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_distinct_limit_collectCollector(Collection<T0> input, long arg0, long arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			limit0++;
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_distinct_skip_collectCollector(Collection<T0> input, long arg0, long arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			skip1++;
			if(skip1 <= arg1) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_distinct_distinct_collectCollector(Collection<T0> input, long arg0, Collector<? super T0, A, R> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		Set<T0> distinct1 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!distinct1.add(t0)) {
				continue;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_distinct_dropWhile_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_distinct_takeWhile_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_skip_distinct_flatMapLambda_collectCollector(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_skip_distinct_flatMapMemberReference_collectCollector(Collection<T0> input, long arg0, Collector<? super T1, A, R> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : t0) {
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_skip_dropWhile_map_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Function<T0, T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			T1 t1 = arg2.apply(t0);
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_dropWhile_filter_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_dropWhile_sorted_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_dropWhile_sortedComp_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Comparator<? super T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_dropWhile_limit_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			limit0++;
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_dropWhile_skip_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			skip1++;
			if(skip1 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_dropWhile_distinct_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_dropWhile_dropWhile_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(dropWhile1 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile1 = false;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_dropWhile_takeWhile_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!arg2.test(t0)) {
				break;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_skip_dropWhile_flatMapLambda_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Function<T0, Collection<T1>> arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : arg2.apply(t0)) {
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_skip_dropWhile_flatMapMemberReference_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : t0) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_skip_takeWhile_map_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Function<T0, T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			T1 t1 = arg2.apply(t0);
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_takeWhile_filter_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_takeWhile_sorted_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_takeWhile_sortedComp_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Comparator<? super T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_takeWhile_limit_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			limit0++;
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_takeWhile_skip_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			skip1++;
			if(skip1 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_takeWhile_distinct_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_takeWhile_dropWhile_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_skip_takeWhile_takeWhile_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			if(!arg2.test(t0)) {
				break;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_skip_takeWhile_flatMapLambda_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Function<T0, Collection<T1>> arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			for (T1 t1 : arg2.apply(t0)) {
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_skip_takeWhile_flatMapMemberReference_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			for (T1 t1 : t0) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_skip_flatMapLambda_map_collectCollector(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, Function<T1, T2> arg2, Collector<? super T2, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				T2 t2 = arg2.apply(t1);
				arg3.accumulator().accept(result, t2);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_skip_flatMapLambda_filter_collectCollector(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				if (!arg2.test(t1)) {
					continue;
				}
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_skip_flatMapLambda_sorted_collectCollector(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_skip_flatMapLambda_sortedComp_collectCollector(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, Comparator<? super T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg2);
		for (T1 t1: sortedComp0) {
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_skip_flatMapLambda_limit_collectCollector(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, long arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				limit0++;
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_skip_flatMapLambda_skip_collectCollector(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, long arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				skip1++;
				if(skip1 <= arg2) {
					continue;
				}
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_skip_flatMapLambda_distinct_collectCollector(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T1> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				if(!distinct0.add(t1)) {
					continue;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_skip_flatMapLambda_dropWhile_collectCollector(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				if(dropWhile0 && arg2.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_skip_flatMapLambda_takeWhile_collectCollector(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				if(!arg2.test(t1)) {
					break;
				}
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_skip_flatMapLambda_flatMapLambda_collectCollector(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, Function<T1, Collection<T2>> arg2, Collector<? super T2, A, R> arg3) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				for (T2 t2 : arg2.apply(t1)) {
					arg3.accumulator().accept(result, t2);
				}
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_skip_flatMapLambda_flatMapMemberReference_collectCollector(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, Collector<? super T2, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				for (T2 t2 : t1) {
					arg2.accumulator().accept(result, t2);
				}
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_skip_flatMapMemberReference_map_collectCollector(Collection<T0> input, long arg0, Function<T1, T2> arg1, Collector<? super T2, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			for (T1 t1 : t0) {
				T2 t2 = arg1.apply(t1);
				arg2.accumulator().accept(result, t2);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_skip_flatMapMemberReference_filter_collectCollector(Collection<T0> input, long arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			for (T1 t1 : t0) {
				if (!arg1.test(t1)) {
					continue;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_skip_flatMapMemberReference_sorted_collectCollector(Collection<T0> input, long arg0, Collector<? super T1, A, R> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			for (T1 t1 : t0) {
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_skip_flatMapMemberReference_sortedComp_collectCollector(Collection<T0> input, long arg0, Comparator<? super T1> arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			for (T1 t1 : t0) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_skip_flatMapMemberReference_limit_collectCollector(Collection<T0> input, long arg0, long arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			for (T1 t1 : t0) {
				limit0++;
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_skip_flatMapMemberReference_skip_collectCollector(Collection<T0> input, long arg0, long arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			for (T1 t1 : t0) {
				skip1++;
				if(skip1 <= arg1) {
					continue;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_skip_flatMapMemberReference_distinct_collectCollector(Collection<T0> input, long arg0, Collector<? super T1, A, R> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T1> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			for (T1 t1 : t0) {
				if(!distinct0.add(t1)) {
					continue;
				}
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_skip_flatMapMemberReference_dropWhile_collectCollector(Collection<T0> input, long arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			for (T1 t1 : t0) {
				if(dropWhile0 && arg1.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_skip_flatMapMemberReference_takeWhile_collectCollector(Collection<T0> input, long arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			for (T1 t1 : t0) {
				if(!arg1.test(t1)) {
					break;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_skip_flatMapMemberReference_flatMapLambda_collectCollector(Collection<T0> input, long arg0, Function<T1, Collection<T2>> arg1, Collector<? super T2, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			for (T1 t1 : t0) {
				for (T2 t2 : arg1.apply(t1)) {
					arg2.accumulator().accept(result, t2);
				}
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1 extends Collection<T2>, T2, R, A> R stream_skip_flatMapMemberReference_flatMapMemberReference_collectCollector(Collection<T0> input, long arg0, Collector<? super T2, A, R> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			for (T1 t1 : t0) {
				for (T2 t2 : t1) {
					arg1.accumulator().accept(result, t2);
				}
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_distinct_map_map_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Function<T1, T2> arg1, Collector<? super T2, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			T1 t1 = arg0.apply(t0);
			T2 t2 = arg1.apply(t1);
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_distinct_map_filter_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			T1 t1 = arg0.apply(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_distinct_map_sorted_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Collector<? super T1, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		List<T1> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			T1 t1 = arg0.apply(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_distinct_map_sortedComp_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Comparator<? super T1> arg1, Collector<? super T1, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			T1 t1 = arg0.apply(t0);
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_distinct_map_limit_collectCollector(Collection<T0> input, Function<T0, T1> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			T1 t1 = arg0.apply(t0);
			limit0++;
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_distinct_map_skip_collectCollector(Collection<T0> input, Function<T0, T1> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			T1 t1 = arg0.apply(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_distinct_map_distinct_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Collector<? super T1, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		Set<T1> distinct1 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			T1 t1 = arg0.apply(t0);
			if(!distinct1.add(t1)) {
				continue;
			}
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_distinct_map_dropWhile_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			T1 t1 = arg0.apply(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_distinct_map_takeWhile_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			T1 t1 = arg0.apply(t0);
			if(!arg1.test(t1)) {
				break;
			}
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_distinct_map_flatMapLambda_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Function<T1, Collection<T2>> arg1, Collector<? super T2, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			T1 t1 = arg0.apply(t0);
			for (T2 t2 : arg1.apply(t1)) {
				arg2.accumulator().accept(result, t2);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_distinct_map_flatMapMemberReference_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Collector<? super T2, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			T1 t1 = arg0.apply(t0);
			for (T2 t2 : t1) {
				arg1.accumulator().accept(result, t2);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_distinct_filter_map_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Collector<? super T1, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if (!arg0.test(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_filter_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if (!arg0.test(t0)) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_filter_sorted_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if (!arg0.test(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_filter_sortedComp_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if (!arg0.test(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_filter_limit_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			if (!arg0.test(t0)) {
				continue;
			}
			limit0++;
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_filter_skip_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if (!arg0.test(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_filter_distinct_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		Set<T0> distinct1 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if (!arg0.test(t0)) {
				continue;
			}
			if(!distinct1.add(t0)) {
				continue;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_filter_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if (!arg0.test(t0)) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_filter_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if (!arg0.test(t0)) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_distinct_filter_flatMapLambda_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Collector<? super T1, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if (!arg0.test(t0)) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_distinct_filter_flatMapMemberReference_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T1, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if (!arg0.test(t0)) {
				continue;
			}
			for (T1 t1 : t0) {
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_distinct_mapToInt_mapToObj_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, IntFunction<T2> arg1, Collector<? super T2, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			int t1 = arg0.applyAsInt(t0);
			T2 t2 = arg1.apply(t1);
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_mapToInt_boxed_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, Collector<? super Integer, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			int t1 = arg0.applyAsInt(t0);
			Integer t2 = t1;
			arg1.accumulator().accept(result, t2);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_distinct_mapToLong_mapToObj_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, LongFunction<T2> arg1, Collector<? super T2, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			long t1 = arg0.applyAsLong(t0);
			T2 t2 = arg1.apply(t1);
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_mapToLong_boxed_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, Collector<? super Long, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			long t1 = arg0.applyAsLong(t0);
			Long t2 = t1;
			arg1.accumulator().accept(result, t2);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_distinct_mapToDouble_mapToObj_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleFunction<T2> arg1, Collector<? super T2, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			double t1 = arg0.applyAsDouble(t0);
			T2 t2 = arg1.apply(t1);
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_mapToDouble_boxed_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, Collector<? super Double, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			double t1 = arg0.applyAsDouble(t0);
			Double t2 = t1;
			arg1.accumulator().accept(result, t2);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_distinct_sorted_map_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Collector<? super T1, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			T1 t1 = arg0.apply(t0);
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_sorted_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if (!arg0.test(t0)) {
				continue;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_sorted_sorted_collectCollector(Collection<T0> input, Collector<? super T0, A, R> arg0) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		A result = arg0.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			sorted1.add(t0);
		}
		sorted1.sort(null);
		for (T0 t0: sorted1) {
			arg0.accumulator().accept(result, t0);
		}
		return arg0.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_sorted_sortedComp_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Collector<? super T0, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_sorted_limit_collectCollector(Collection<T0> input, long arg0, Collector<? super T0, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sorted0 = new ArrayList<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			limit0++;
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_sorted_skip_collectCollector(Collection<T0> input, long arg0, Collector<? super T0, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sorted0 = new ArrayList<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_sorted_distinct_collectCollector(Collection<T0> input, Collector<? super T0, A, R> arg0) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sorted0 = new ArrayList<>();
		Set<T0> distinct1 = new HashSet<>();
		A result = arg0.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(!distinct1.add(t0)) {
				continue;
			}
			arg0.accumulator().accept(result, t0);
		}
		return arg0.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_sorted_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_sorted_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(!arg0.test(t0)) {
				break;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_distinct_sorted_flatMapLambda_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Collector<? super T1, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			for (T1 t1 : arg0.apply(t0)) {
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_distinct_sorted_flatMapMemberReference_collectCollector(Collection<T0> input, Collector<? super T1, A, R> arg0) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sorted0 = new ArrayList<>();
		A result = arg0.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			for (T1 t1 : t0) {
				arg0.accumulator().accept(result, t1);
			}
		}
		return arg0.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_distinct_sortedComp_map_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, T1> arg1, Collector<? super T1, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			T1 t1 = arg1.apply(t0);
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_sortedComp_filter_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if (!arg1.test(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_sortedComp_sorted_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Collector<? super T0, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_sortedComp_sortedComp_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Comparator<? super T0> arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sortedComp1.add(t0);
		}
		sortedComp1.sort(arg1);
		for (T0 t0: sortedComp1) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_sortedComp_limit_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			limit0++;
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_sortedComp_skip_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_sortedComp_distinct_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Collector<? super T0, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T0> distinct1 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!distinct1.add(t0)) {
				continue;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_sortedComp_dropWhile_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_sortedComp_takeWhile_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!arg1.test(t0)) {
				break;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_distinct_sortedComp_flatMapLambda_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, Collection<T1>> arg1, Collector<? super T1, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : arg1.apply(t0)) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_distinct_sortedComp_flatMapMemberReference_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Collector<? super T1, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : t0) {
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_distinct_limit_map_collectCollector(Collection<T0> input, long arg0, Function<T0, T1> arg1, Collector<? super T1, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			limit0++;
			T1 t1 = arg1.apply(t0);
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_limit_filter_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			limit0++;
			if (!arg1.test(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_limit_sorted_collectCollector(Collection<T0> input, long arg0, Collector<? super T0, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			limit0++;
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_limit_sortedComp_collectCollector(Collection<T0> input, long arg0, Comparator<? super T0> arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			limit0++;
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_limit_limit_collectCollector(Collection<T0> input, long arg0, long arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(limit1 >= arg1) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			limit0++;
			limit1++;
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_limit_skip_collectCollector(Collection<T0> input, long arg0, long arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			limit0++;
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_limit_distinct_collectCollector(Collection<T0> input, long arg0, Collector<? super T0, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T0> distinct1 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			limit0++;
			if(!distinct1.add(t0)) {
				continue;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_limit_dropWhile_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			limit0++;
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_limit_takeWhile_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			limit0++;
			if(!arg1.test(t0)) {
				break;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_distinct_limit_flatMapLambda_collectCollector(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, Collector<? super T1, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			limit0++;
			for (T1 t1 : arg1.apply(t0)) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_distinct_limit_flatMapMemberReference_collectCollector(Collection<T0> input, long arg0, Collector<? super T1, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			limit0++;
			for (T1 t1 : t0) {
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_distinct_skip_map_collectCollector(Collection<T0> input, long arg0, Function<T0, T1> arg1, Collector<? super T1, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_skip_filter_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_skip_sorted_collectCollector(Collection<T0> input, long arg0, Collector<? super T0, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_skip_sortedComp_collectCollector(Collection<T0> input, long arg0, Comparator<? super T0> arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_skip_limit_collectCollector(Collection<T0> input, long arg0, long arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			limit0++;
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_skip_skip_collectCollector(Collection<T0> input, long arg0, long arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			skip1++;
			if(skip1 <= arg1) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_skip_distinct_collectCollector(Collection<T0> input, long arg0, Collector<? super T0, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T0> distinct1 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!distinct1.add(t0)) {
				continue;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_skip_dropWhile_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_skip_takeWhile_collectCollector(Collection<T0> input, long arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_distinct_skip_flatMapLambda_collectCollector(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, Collector<? super T1, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_distinct_skip_flatMapMemberReference_collectCollector(Collection<T0> input, long arg0, Collector<? super T1, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			for (T1 t1 : t0) {
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_distinct_distinct_map_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Collector<? super T1, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		Set<T0> distinct1 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!distinct1.add(t0)) {
				continue;
			}
			T1 t1 = arg0.apply(t0);
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_distinct_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		Set<T0> distinct1 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!distinct1.add(t0)) {
				continue;
			}
			if (!arg0.test(t0)) {
				continue;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_distinct_sorted_collectCollector(Collection<T0> input, Collector<? super T0, A, R> arg0) {
		Set<T0> distinct0 = new HashSet<>();
		Set<T0> distinct1 = new HashSet<>();
		List<T0> sorted0 = new ArrayList<>();
		A result = arg0.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!distinct1.add(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg0.accumulator().accept(result, t0);
		}
		return arg0.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_distinct_sortedComp_collectCollector(Collection<T0> input, Comparator<? super T0> arg0, Collector<? super T0, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		Set<T0> distinct1 = new HashSet<>();
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!distinct1.add(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_distinct_limit_collectCollector(Collection<T0> input, long arg0, Collector<? super T0, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		Set<T0> distinct1 = new HashSet<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!distinct1.add(t0)) {
				continue;
			}
			limit0++;
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_distinct_skip_collectCollector(Collection<T0> input, long arg0, Collector<? super T0, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		Set<T0> distinct1 = new HashSet<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!distinct1.add(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_distinct_distinct_collectCollector(Collection<T0> input, Collector<? super T0, A, R> arg0) {
		Set<T0> distinct0 = new HashSet<>();
		Set<T0> distinct1 = new HashSet<>();
		Set<T0> distinct2 = new HashSet<>();
		A result = arg0.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!distinct1.add(t0)) {
				continue;
			}
			if(!distinct2.add(t0)) {
				continue;
			}
			arg0.accumulator().accept(result, t0);
		}
		return arg0.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_distinct_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		Set<T0> distinct1 = new HashSet<>();
		boolean dropWhile0 = true;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!distinct1.add(t0)) {
				continue;
			}
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_distinct_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		Set<T0> distinct1 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!distinct1.add(t0)) {
				continue;
			}
			if(!arg0.test(t0)) {
				break;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_distinct_distinct_flatMapLambda_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Collector<? super T1, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		Set<T0> distinct1 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!distinct1.add(t0)) {
				continue;
			}
			for (T1 t1 : arg0.apply(t0)) {
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_distinct_distinct_flatMapMemberReference_collectCollector(Collection<T0> input, Collector<? super T1, A, R> arg0) {
		Set<T0> distinct0 = new HashSet<>();
		Set<T0> distinct1 = new HashSet<>();
		A result = arg0.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!distinct1.add(t0)) {
				continue;
			}
			for (T1 t1 : t0) {
				arg0.accumulator().accept(result, t1);
			}
		}
		return arg0.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_distinct_dropWhile_map_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Collector<? super T1, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			T1 t1 = arg1.apply(t0);
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_dropWhile_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_dropWhile_sorted_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		List<T0> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_dropWhile_sortedComp_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_dropWhile_limit_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			limit0++;
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_dropWhile_skip_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_dropWhile_distinct_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		Set<T0> distinct1 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!distinct1.add(t0)) {
				continue;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_dropWhile_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(dropWhile1 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile1 = false;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_dropWhile_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!arg1.test(t0)) {
				break;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_distinct_dropWhile_flatMapLambda_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Collector<? super T1, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : arg1.apply(t0)) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_distinct_dropWhile_flatMapMemberReference_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T1, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : t0) {
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_distinct_takeWhile_map_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Collector<? super T1, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!arg0.test(t0)) {
				break;
			}
			T1 t1 = arg1.apply(t0);
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_takeWhile_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!arg0.test(t0)) {
				break;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_takeWhile_sorted_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!arg0.test(t0)) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_takeWhile_sortedComp_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!arg0.test(t0)) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_takeWhile_limit_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!arg0.test(t0)) {
				break;
			}
			limit0++;
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_takeWhile_skip_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!arg0.test(t0)) {
				break;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_takeWhile_distinct_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		Set<T0> distinct1 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!arg0.test(t0)) {
				break;
			}
			if(!distinct1.add(t0)) {
				continue;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_takeWhile_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!arg0.test(t0)) {
				break;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_distinct_takeWhile_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!arg0.test(t0)) {
				break;
			}
			if(!arg1.test(t0)) {
				break;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_distinct_takeWhile_flatMapLambda_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Collector<? super T1, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!arg0.test(t0)) {
				break;
			}
			for (T1 t1 : arg1.apply(t0)) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_distinct_takeWhile_flatMapMemberReference_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T1, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!arg0.test(t0)) {
				break;
			}
			for (T1 t1 : t0) {
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_distinct_flatMapLambda_map_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, T2> arg1, Collector<? super T2, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : arg0.apply(t0)) {
				T2 t2 = arg1.apply(t1);
				arg2.accumulator().accept(result, t2);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_distinct_flatMapLambda_filter_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : arg0.apply(t0)) {
				if (!arg1.test(t1)) {
					continue;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_distinct_flatMapLambda_sorted_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Collector<? super T1, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		List<T1> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : arg0.apply(t0)) {
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_distinct_flatMapLambda_sortedComp_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Comparator<? super T1> arg1, Collector<? super T1, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : arg0.apply(t0)) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_distinct_flatMapLambda_limit_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : arg0.apply(t0)) {
				limit0++;
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_distinct_flatMapLambda_skip_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : arg0.apply(t0)) {
				skip0++;
				if(skip0 <= arg1) {
					continue;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_distinct_flatMapLambda_distinct_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Collector<? super T1, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		Set<T1> distinct1 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : arg0.apply(t0)) {
				if(!distinct1.add(t1)) {
					continue;
				}
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_distinct_flatMapLambda_dropWhile_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : arg0.apply(t0)) {
				if(dropWhile0 && arg1.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_distinct_flatMapLambda_takeWhile_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : arg0.apply(t0)) {
				if(!arg1.test(t1)) {
					break;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_distinct_flatMapLambda_flatMapLambda_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, Collection<T2>> arg1, Collector<? super T2, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : arg0.apply(t0)) {
				for (T2 t2 : arg1.apply(t1)) {
					arg2.accumulator().accept(result, t2);
				}
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_distinct_flatMapLambda_flatMapMemberReference_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Collector<? super T2, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : arg0.apply(t0)) {
				for (T2 t2 : t1) {
					arg1.accumulator().accept(result, t2);
				}
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_distinct_flatMapMemberReference_map_collectCollector(Collection<T0> input, Function<T1, T2> arg0, Collector<? super T2, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : t0) {
				T2 t2 = arg0.apply(t1);
				arg1.accumulator().accept(result, t2);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_distinct_flatMapMemberReference_filter_collectCollector(Collection<T0> input, Predicate<T1> arg0, Collector<? super T1, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : t0) {
				if (!arg0.test(t1)) {
					continue;
				}
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_distinct_flatMapMemberReference_sorted_collectCollector(Collection<T0> input, Collector<? super T1, A, R> arg0) {
		Set<T0> distinct0 = new HashSet<>();
		List<T1> sorted0 = new ArrayList<>();
		A result = arg0.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : t0) {
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			arg0.accumulator().accept(result, t1);
		}
		return arg0.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_distinct_flatMapMemberReference_sortedComp_collectCollector(Collection<T0> input, Comparator<? super T1> arg0, Collector<? super T1, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : t0) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg0);
		for (T1 t1: sortedComp0) {
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_distinct_flatMapMemberReference_limit_collectCollector(Collection<T0> input, long arg0, Collector<? super T1, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : t0) {
				limit0++;
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_distinct_flatMapMemberReference_skip_collectCollector(Collection<T0> input, long arg0, Collector<? super T1, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : t0) {
				skip0++;
				if(skip0 <= arg0) {
					continue;
				}
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_distinct_flatMapMemberReference_distinct_collectCollector(Collection<T0> input, Collector<? super T1, A, R> arg0) {
		Set<T0> distinct0 = new HashSet<>();
		Set<T1> distinct1 = new HashSet<>();
		A result = arg0.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : t0) {
				if(!distinct1.add(t1)) {
					continue;
				}
				arg0.accumulator().accept(result, t1);
			}
		}
		return arg0.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_distinct_flatMapMemberReference_dropWhile_collectCollector(Collection<T0> input, Predicate<T1> arg0, Collector<? super T1, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : t0) {
				if(dropWhile0 && arg0.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_distinct_flatMapMemberReference_takeWhile_collectCollector(Collection<T0> input, Predicate<T1> arg0, Collector<? super T1, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : t0) {
				if(!arg0.test(t1)) {
					break;
				}
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_distinct_flatMapMemberReference_flatMapLambda_collectCollector(Collection<T0> input, Function<T1, Collection<T2>> arg0, Collector<? super T2, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : t0) {
				for (T2 t2 : arg0.apply(t1)) {
					arg1.accumulator().accept(result, t2);
				}
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1 extends Collection<T2>, T2, R, A> R stream_distinct_flatMapMemberReference_flatMapMemberReference_collectCollector(Collection<T0> input, Collector<? super T2, A, R> arg0) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg0.supplier().get();
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : t0) {
				for (T2 t2 : t1) {
					arg0.accumulator().accept(result, t2);
				}
			}
		}
		return arg0.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_dropWhile_map_map_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Function<T1, T2> arg2, Collector<? super T2, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			T1 t1 = arg1.apply(t0);
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_dropWhile_map_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			T1 t1 = arg1.apply(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_dropWhile_map_sorted_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Collector<? super T1, A, R> arg2) {
		boolean dropWhile0 = true;
		List<T1> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			T1 t1 = arg1.apply(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_dropWhile_map_sortedComp_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Comparator<? super T1> arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			T1 t1 = arg1.apply(t0);
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg2);
		for (T1 t1: sortedComp0) {
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_dropWhile_map_limit_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, long arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			T1 t1 = arg1.apply(t0);
			limit0++;
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_dropWhile_map_skip_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, long arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			T1 t1 = arg1.apply(t0);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_dropWhile_map_distinct_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Collector<? super T1, A, R> arg2) {
		boolean dropWhile0 = true;
		Set<T1> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			T1 t1 = arg1.apply(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_dropWhile_map_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			T1 t1 = arg1.apply(t0);
			if(dropWhile1 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile1 = false;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_dropWhile_map_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			T1 t1 = arg1.apply(t0);
			if(!arg2.test(t1)) {
				break;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_dropWhile_map_flatMapLambda_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Function<T1, Collection<T2>> arg2, Collector<? super T2, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			T1 t1 = arg1.apply(t0);
			for (T2 t2 : arg2.apply(t1)) {
				arg3.accumulator().accept(result, t2);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_dropWhile_map_flatMapMemberReference_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Collector<? super T2, A, R> arg2) {
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			T1 t1 = arg1.apply(t0);
			for (T2 t2 : t1) {
				arg2.accumulator().accept(result, t2);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_dropWhile_filter_map_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Function<T0, T1> arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			T1 t1 = arg2.apply(t0);
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_filter_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_filter_sorted_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		boolean dropWhile0 = true;
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_filter_sortedComp_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Comparator<? super T0> arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_filter_limit_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			limit0++;
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_filter_skip_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_filter_distinct_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		boolean dropWhile0 = true;
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_filter_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			if(dropWhile1 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile1 = false;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_filter_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			if(!arg2.test(t0)) {
				break;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_dropWhile_filter_flatMapLambda_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Function<T0, Collection<T1>> arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			for (T1 t1 : arg2.apply(t0)) {
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_dropWhile_filter_flatMapMemberReference_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T1, A, R> arg2) {
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			for (T1 t1 : t0) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_dropWhile_mapToInt_mapToObj_collectCollector(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1, IntFunction<T2> arg2, Collector<? super T2, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			int t1 = arg1.applyAsInt(t0);
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_mapToInt_boxed_collectCollector(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1, Collector<? super Integer, A, R> arg2) {
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			int t1 = arg1.applyAsInt(t0);
			Integer t2 = t1;
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_dropWhile_mapToLong_mapToObj_collectCollector(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1, LongFunction<T2> arg2, Collector<? super T2, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			long t1 = arg1.applyAsLong(t0);
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_mapToLong_boxed_collectCollector(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1, Collector<? super Long, A, R> arg2) {
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			long t1 = arg1.applyAsLong(t0);
			Long t2 = t1;
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_dropWhile_mapToDouble_mapToObj_collectCollector(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1, DoubleFunction<T2> arg2, Collector<? super T2, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			double t1 = arg1.applyAsDouble(t0);
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_mapToDouble_boxed_collectCollector(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1, Collector<? super Double, A, R> arg2) {
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			double t1 = arg1.applyAsDouble(t0);
			Double t2 = t1;
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_dropWhile_sorted_map_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Collector<? super T1, A, R> arg2) {
		boolean dropWhile0 = true;
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			T1 t1 = arg1.apply(t0);
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_sorted_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		boolean dropWhile0 = true;
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if (!arg1.test(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_sorted_sorted_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		boolean dropWhile0 = true;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			sorted1.add(t0);
		}
		sorted1.sort(null);
		for (T0 t0: sorted1) {
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_sorted_sortedComp_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Collector<? super T0, A, R> arg2) {
		boolean dropWhile0 = true;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_sorted_limit_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		boolean dropWhile0 = true;
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			limit0++;
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_sorted_skip_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		boolean dropWhile0 = true;
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_sorted_distinct_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		boolean dropWhile0 = true;
		List<T0> sorted0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_sorted_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		boolean dropWhile0 = true;
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile1 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(dropWhile1 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile1 = false;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_sorted_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		boolean dropWhile0 = true;
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(!arg1.test(t0)) {
				break;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_dropWhile_sorted_flatMapLambda_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Collector<? super T1, A, R> arg2) {
		boolean dropWhile0 = true;
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			for (T1 t1 : arg1.apply(t0)) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_dropWhile_sorted_flatMapMemberReference_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T1, A, R> arg1) {
		boolean dropWhile0 = true;
		List<T0> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			for (T1 t1 : t0) {
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_dropWhile_sortedComp_map_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Function<T0, T1> arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			T1 t1 = arg2.apply(t0);
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_sortedComp_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			if (!arg2.test(t0)) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_sortedComp_sorted_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Collector<? super T0, A, R> arg2) {
		boolean dropWhile0 = true;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_sortedComp_sortedComp_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Comparator<? super T0> arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			sortedComp1.add(t0);
		}
		sortedComp1.sort(arg2);
		for (T0 t0: sortedComp1) {
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_sortedComp_limit_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			limit0++;
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_sortedComp_skip_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_sortedComp_distinct_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Collector<? super T0, A, R> arg2) {
		boolean dropWhile0 = true;
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_sortedComp_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile1 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			if(dropWhile1 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile1 = false;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_sortedComp_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			if(!arg2.test(t0)) {
				break;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_dropWhile_sortedComp_flatMapLambda_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Function<T0, Collection<T1>> arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : arg2.apply(t0)) {
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_dropWhile_sortedComp_flatMapMemberReference_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Collector<? super T1, A, R> arg2) {
		boolean dropWhile0 = true;
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : t0) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_dropWhile_limit_map_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Function<T0, T1> arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			limit0++;
			T1 t1 = arg2.apply(t0);
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_limit_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			limit0++;
			if (!arg2.test(t0)) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_limit_sorted_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			limit0++;
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_limit_sortedComp_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Comparator<? super T0> arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			limit0++;
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_limit_limit_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, long arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(limit1 >= arg2) {
				break;
			}
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			limit0++;
			limit1++;
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_limit_skip_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, long arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			limit0++;
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_limit_distinct_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			limit0++;
			if(!distinct0.add(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_limit_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile1 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			limit0++;
			if(dropWhile1 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile1 = false;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_limit_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			limit0++;
			if(!arg2.test(t0)) {
				break;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_dropWhile_limit_flatMapLambda_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Function<T0, Collection<T1>> arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			limit0++;
			for (T1 t1 : arg2.apply(t0)) {
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_dropWhile_limit_flatMapMemberReference_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			limit0++;
			for (T1 t1 : t0) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_dropWhile_skip_map_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Function<T0, T1> arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			T1 t1 = arg2.apply(t0);
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_skip_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_skip_sorted_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_skip_sortedComp_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Comparator<? super T0> arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_skip_limit_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, long arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			limit0++;
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_skip_skip_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, long arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			skip1++;
			if(skip1 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_skip_distinct_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_skip_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile1 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if(dropWhile1 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile1 = false;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_skip_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if(!arg2.test(t0)) {
				break;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_dropWhile_skip_flatMapLambda_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Function<T0, Collection<T1>> arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			for (T1 t1 : arg2.apply(t0)) {
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_dropWhile_skip_flatMapMemberReference_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			for (T1 t1 : t0) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_dropWhile_distinct_map_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Collector<? super T1, A, R> arg2) {
		boolean dropWhile0 = true;
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_distinct_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		boolean dropWhile0 = true;
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_distinct_sorted_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		boolean dropWhile0 = true;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_distinct_sortedComp_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Collector<? super T0, A, R> arg2) {
		boolean dropWhile0 = true;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_distinct_limit_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		boolean dropWhile0 = true;
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			limit0++;
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_distinct_skip_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		boolean dropWhile0 = true;
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_distinct_distinct_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		boolean dropWhile0 = true;
		Set<T0> distinct0 = new HashSet<>();
		Set<T0> distinct1 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!distinct1.add(t0)) {
				continue;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_distinct_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		boolean dropWhile0 = true;
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile1 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			if(dropWhile1 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile1 = false;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_distinct_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		boolean dropWhile0 = true;
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_dropWhile_distinct_flatMapLambda_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Collector<? super T1, A, R> arg2) {
		boolean dropWhile0 = true;
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_dropWhile_distinct_flatMapMemberReference_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T1, A, R> arg1) {
		boolean dropWhile0 = true;
		Set<T0> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : t0) {
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_dropWhile_dropWhile_map_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Function<T0, T1> arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(dropWhile1 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile1 = false;
			}
			T1 t1 = arg2.apply(t0);
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_dropWhile_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(dropWhile1 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile1 = false;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_dropWhile_sorted_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(dropWhile1 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile1 = false;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_dropWhile_sortedComp_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Comparator<? super T0> arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(dropWhile1 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile1 = false;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_dropWhile_limit_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(dropWhile1 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile1 = false;
			}
			limit0++;
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_dropWhile_skip_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(dropWhile1 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile1 = false;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_dropWhile_distinct_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(dropWhile1 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile1 = false;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_dropWhile_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		boolean dropWhile2 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(dropWhile1 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile1 = false;
			}
			if(dropWhile2 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile2 = false;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_dropWhile_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(dropWhile1 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile1 = false;
			}
			if(!arg2.test(t0)) {
				break;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_dropWhile_dropWhile_flatMapLambda_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Function<T0, Collection<T1>> arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(dropWhile1 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile1 = false;
			}
			for (T1 t1 : arg2.apply(t0)) {
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_dropWhile_dropWhile_flatMapMemberReference_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T1, A, R> arg2) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(dropWhile1 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile1 = false;
			}
			for (T1 t1 : t0) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_dropWhile_takeWhile_map_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Function<T0, T1> arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!arg1.test(t0)) {
				break;
			}
			T1 t1 = arg2.apply(t0);
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_takeWhile_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!arg1.test(t0)) {
				break;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_takeWhile_sorted_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		boolean dropWhile0 = true;
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!arg1.test(t0)) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_takeWhile_sortedComp_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Comparator<? super T0> arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!arg1.test(t0)) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_takeWhile_limit_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!arg1.test(t0)) {
				break;
			}
			limit0++;
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_takeWhile_skip_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!arg1.test(t0)) {
				break;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_takeWhile_distinct_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		boolean dropWhile0 = true;
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!arg1.test(t0)) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_takeWhile_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!arg1.test(t0)) {
				break;
			}
			if(dropWhile1 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile1 = false;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_dropWhile_takeWhile_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!arg1.test(t0)) {
				break;
			}
			if(!arg2.test(t0)) {
				break;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_dropWhile_takeWhile_flatMapLambda_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Function<T0, Collection<T1>> arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!arg1.test(t0)) {
				break;
			}
			for (T1 t1 : arg2.apply(t0)) {
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_dropWhile_takeWhile_flatMapMemberReference_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T1, A, R> arg2) {
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!arg1.test(t0)) {
				break;
			}
			for (T1 t1 : t0) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_dropWhile_flatMapLambda_map_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Function<T1, T2> arg2, Collector<? super T2, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : arg1.apply(t0)) {
				T2 t2 = arg2.apply(t1);
				arg3.accumulator().accept(result, t2);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_dropWhile_flatMapLambda_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : arg1.apply(t0)) {
				if (!arg2.test(t1)) {
					continue;
				}
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_dropWhile_flatMapLambda_sorted_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Collector<? super T1, A, R> arg2) {
		boolean dropWhile0 = true;
		List<T1> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : arg1.apply(t0)) {
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_dropWhile_flatMapLambda_sortedComp_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Comparator<? super T1> arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : arg1.apply(t0)) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg2);
		for (T1 t1: sortedComp0) {
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_dropWhile_flatMapLambda_limit_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, long arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : arg1.apply(t0)) {
				limit0++;
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_dropWhile_flatMapLambda_skip_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, long arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : arg1.apply(t0)) {
				skip0++;
				if(skip0 <= arg2) {
					continue;
				}
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_dropWhile_flatMapLambda_distinct_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Collector<? super T1, A, R> arg2) {
		boolean dropWhile0 = true;
		Set<T1> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : arg1.apply(t0)) {
				if(!distinct0.add(t1)) {
					continue;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_dropWhile_flatMapLambda_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : arg1.apply(t0)) {
				if(dropWhile1 && arg2.test(t1)) {
					continue;
				} else {
					dropWhile1 = false;
				}
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_dropWhile_flatMapLambda_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : arg1.apply(t0)) {
				if(!arg2.test(t1)) {
					break;
				}
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_dropWhile_flatMapLambda_flatMapLambda_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Function<T1, Collection<T2>> arg2, Collector<? super T2, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : arg1.apply(t0)) {
				for (T2 t2 : arg2.apply(t1)) {
					arg3.accumulator().accept(result, t2);
				}
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_dropWhile_flatMapLambda_flatMapMemberReference_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Collector<? super T2, A, R> arg2) {
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : arg1.apply(t0)) {
				for (T2 t2 : t1) {
					arg2.accumulator().accept(result, t2);
				}
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_dropWhile_flatMapMemberReference_map_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T1, T2> arg1, Collector<? super T2, A, R> arg2) {
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : t0) {
				T2 t2 = arg1.apply(t1);
				arg2.accumulator().accept(result, t2);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_dropWhile_flatMapMemberReference_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : t0) {
				if (!arg1.test(t1)) {
					continue;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_dropWhile_flatMapMemberReference_sorted_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T1, A, R> arg1) {
		boolean dropWhile0 = true;
		List<T1> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : t0) {
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_dropWhile_flatMapMemberReference_sortedComp_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T1> arg1, Collector<? super T1, A, R> arg2) {
		boolean dropWhile0 = true;
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : t0) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_dropWhile_flatMapMemberReference_limit_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : t0) {
				limit0++;
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_dropWhile_flatMapMemberReference_skip_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : t0) {
				skip0++;
				if(skip0 <= arg1) {
					continue;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_dropWhile_flatMapMemberReference_distinct_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T1, A, R> arg1) {
		boolean dropWhile0 = true;
		Set<T1> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : t0) {
				if(!distinct0.add(t1)) {
					continue;
				}
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_dropWhile_flatMapMemberReference_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : t0) {
				if(dropWhile1 && arg1.test(t1)) {
					continue;
				} else {
					dropWhile1 = false;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_dropWhile_flatMapMemberReference_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : t0) {
				if(!arg1.test(t1)) {
					break;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_dropWhile_flatMapMemberReference_flatMapLambda_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T1, Collection<T2>> arg1, Collector<? super T2, A, R> arg2) {
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : t0) {
				for (T2 t2 : arg1.apply(t1)) {
					arg2.accumulator().accept(result, t2);
				}
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1 extends Collection<T2>, T2, R, A> R stream_dropWhile_flatMapMemberReference_flatMapMemberReference_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T2, A, R> arg1) {
		boolean dropWhile0 = true;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : t0) {
				for (T2 t2 : t1) {
					arg1.accumulator().accept(result, t2);
				}
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_takeWhile_map_map_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Function<T1, T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			T1 t1 = arg1.apply(t0);
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_takeWhile_map_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			T1 t1 = arg1.apply(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_takeWhile_map_sorted_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T1> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			T1 t1 = arg1.apply(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_takeWhile_map_sortedComp_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Comparator<? super T1> arg2, Collector<? super T1, A, R> arg3) {
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			T1 t1 = arg1.apply(t0);
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg2);
		for (T1 t1: sortedComp0) {
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_takeWhile_map_limit_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, long arg2, Collector<? super T1, A, R> arg3) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			if(!arg0.test(t0)) {
				break;
			}
			T1 t1 = arg1.apply(t0);
			limit0++;
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_takeWhile_map_skip_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, long arg2, Collector<? super T1, A, R> arg3) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			T1 t1 = arg1.apply(t0);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_takeWhile_map_distinct_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Collector<? super T1, A, R> arg2) {
		Set<T1> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			T1 t1 = arg1.apply(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_takeWhile_map_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			T1 t1 = arg1.apply(t0);
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_takeWhile_map_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			T1 t1 = arg1.apply(t0);
			if(!arg2.test(t1)) {
				break;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_takeWhile_map_flatMapLambda_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Function<T1, Collection<T2>> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			T1 t1 = arg1.apply(t0);
			for (T2 t2 : arg2.apply(t1)) {
				arg3.accumulator().accept(result, t2);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_takeWhile_map_flatMapMemberReference_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Collector<? super T2, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			T1 t1 = arg1.apply(t0);
			for (T2 t2 : t1) {
				arg2.accumulator().accept(result, t2);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_takeWhile_filter_map_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Function<T0, T1> arg2, Collector<? super T1, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			T1 t1 = arg2.apply(t0);
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_filter_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_filter_sorted_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_filter_sortedComp_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Comparator<? super T0> arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_filter_limit_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			if(!arg0.test(t0)) {
				break;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			limit0++;
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_filter_skip_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_filter_distinct_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_filter_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_filter_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			if(!arg2.test(t0)) {
				break;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_takeWhile_filter_flatMapLambda_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Function<T0, Collection<T1>> arg2, Collector<? super T1, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			for (T1 t1 : arg2.apply(t0)) {
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_takeWhile_filter_flatMapMemberReference_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T1, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			for (T1 t1 : t0) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_takeWhile_mapToInt_mapToObj_collectCollector(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1, IntFunction<T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			int t1 = arg1.applyAsInt(t0);
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_mapToInt_boxed_collectCollector(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1, Collector<? super Integer, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			int t1 = arg1.applyAsInt(t0);
			Integer t2 = t1;
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_takeWhile_mapToLong_mapToObj_collectCollector(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1, LongFunction<T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			long t1 = arg1.applyAsLong(t0);
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_mapToLong_boxed_collectCollector(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1, Collector<? super Long, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			long t1 = arg1.applyAsLong(t0);
			Long t2 = t1;
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T2, R, A> R stream_takeWhile_mapToDouble_mapToObj_collectCollector(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1, DoubleFunction<T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			double t1 = arg1.applyAsDouble(t0);
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_mapToDouble_boxed_collectCollector(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1, Collector<? super Double, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			double t1 = arg1.applyAsDouble(t0);
			Double t2 = t1;
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_takeWhile_sorted_map_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			T1 t1 = arg1.apply(t0);
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_sorted_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if (!arg1.test(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_sorted_sorted_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			sorted1.add(t0);
		}
		sorted1.sort(null);
		for (T0 t0: sorted1) {
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_sorted_sortedComp_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_sorted_limit_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(!arg0.test(t0)) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			limit0++;
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_sorted_skip_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_sorted_distinct_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_sorted_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_sorted_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(!arg1.test(t0)) {
				break;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_takeWhile_sorted_flatMapLambda_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			for (T1 t1 : arg1.apply(t0)) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_takeWhile_sorted_flatMapMemberReference_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T1, A, R> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			for (T1 t1 : t0) {
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_takeWhile_sortedComp_map_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Function<T0, T1> arg2, Collector<? super T1, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			T1 t1 = arg2.apply(t0);
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_sortedComp_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			if (!arg2.test(t0)) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_sortedComp_sorted_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_sortedComp_sortedComp_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Comparator<? super T0> arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			sortedComp1.add(t0);
		}
		sortedComp1.sort(arg2);
		for (T0 t0: sortedComp1) {
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_sortedComp_limit_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			if(!arg0.test(t0)) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			limit0++;
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_sortedComp_skip_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_sortedComp_distinct_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_sortedComp_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_sortedComp_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			if(!arg2.test(t0)) {
				break;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_takeWhile_sortedComp_flatMapLambda_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Function<T0, Collection<T1>> arg2, Collector<? super T1, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : arg2.apply(t0)) {
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_takeWhile_sortedComp_flatMapMemberReference_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Collector<? super T1, A, R> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : t0) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_takeWhile_limit_map_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Function<T0, T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(!arg0.test(t0)) {
				break;
			}
			limit0++;
			T1 t1 = arg2.apply(t0);
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_limit_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(!arg0.test(t0)) {
				break;
			}
			limit0++;
			if (!arg2.test(t0)) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_limit_sorted_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(!arg0.test(t0)) {
				break;
			}
			limit0++;
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_limit_sortedComp_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Comparator<? super T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(!arg0.test(t0)) {
				break;
			}
			limit0++;
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_limit_limit_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, long arg2, Collector<? super T0, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(limit1 >= arg2) {
				break;
			}
			if(!arg0.test(t0)) {
				break;
			}
			limit0++;
			limit1++;
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_limit_skip_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, long arg2, Collector<? super T0, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(!arg0.test(t0)) {
				break;
			}
			limit0++;
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_limit_distinct_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(!arg0.test(t0)) {
				break;
			}
			limit0++;
			if(!distinct0.add(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_limit_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(!arg0.test(t0)) {
				break;
			}
			limit0++;
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_limit_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(!arg0.test(t0)) {
				break;
			}
			limit0++;
			if(!arg2.test(t0)) {
				break;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_takeWhile_limit_flatMapLambda_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Function<T0, Collection<T1>> arg2, Collector<? super T1, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(!arg0.test(t0)) {
				break;
			}
			limit0++;
			for (T1 t1 : arg2.apply(t0)) {
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_takeWhile_limit_flatMapMemberReference_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(!arg0.test(t0)) {
				break;
			}
			limit0++;
			for (T1 t1 : t0) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_takeWhile_skip_map_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Function<T0, T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			T1 t1 = arg2.apply(t0);
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_skip_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_skip_sorted_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_skip_sortedComp_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Comparator<? super T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_skip_limit_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, long arg2, Collector<? super T0, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			if(!arg0.test(t0)) {
				break;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			limit0++;
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_skip_skip_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, long arg2, Collector<? super T0, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			skip1++;
			if(skip1 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_skip_distinct_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_skip_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_skip_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if(!arg2.test(t0)) {
				break;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_takeWhile_skip_flatMapLambda_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Function<T0, Collection<T1>> arg2, Collector<? super T1, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			for (T1 t1 : arg2.apply(t0)) {
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_takeWhile_skip_flatMapMemberReference_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			for (T1 t1 : t0) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_takeWhile_distinct_map_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Collector<? super T1, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_distinct_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_distinct_sorted_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_distinct_sortedComp_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_distinct_limit_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(!arg0.test(t0)) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			limit0++;
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_distinct_skip_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_distinct_distinct_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		Set<T0> distinct1 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!distinct1.add(t0)) {
				continue;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_distinct_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_distinct_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_takeWhile_distinct_flatMapLambda_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Collector<? super T1, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_takeWhile_distinct_flatMapMemberReference_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T1, A, R> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : t0) {
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_takeWhile_dropWhile_map_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Function<T0, T1> arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			T1 t1 = arg2.apply(t0);
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_dropWhile_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_dropWhile_sorted_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		boolean dropWhile0 = true;
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_dropWhile_sortedComp_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Comparator<? super T0> arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_dropWhile_limit_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			if(!arg0.test(t0)) {
				break;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			limit0++;
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_dropWhile_skip_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_dropWhile_distinct_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		boolean dropWhile0 = true;
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_dropWhile_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(dropWhile1 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile1 = false;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_dropWhile_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!arg2.test(t0)) {
				break;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_takeWhile_dropWhile_flatMapLambda_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Function<T0, Collection<T1>> arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : arg2.apply(t0)) {
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_takeWhile_dropWhile_flatMapMemberReference_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T1, A, R> arg2) {
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : t0) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_takeWhile_takeWhile_map_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Function<T0, T1> arg2, Collector<? super T1, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!arg1.test(t0)) {
				break;
			}
			T1 t1 = arg2.apply(t0);
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_takeWhile_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!arg1.test(t0)) {
				break;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_takeWhile_sorted_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!arg1.test(t0)) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_takeWhile_sortedComp_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Comparator<? super T0> arg2, Collector<? super T0, A, R> arg3) {
		List<T0> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!arg1.test(t0)) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_takeWhile_limit_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			if(!arg0.test(t0)) {
				break;
			}
			if(!arg1.test(t0)) {
				break;
			}
			limit0++;
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_takeWhile_skip_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, long arg2, Collector<? super T0, A, R> arg3) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!arg1.test(t0)) {
				break;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_takeWhile_distinct_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!arg1.test(t0)) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			arg2.accumulator().accept(result, t0);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_takeWhile_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!arg1.test(t0)) {
				break;
			}
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, R, A> R stream_takeWhile_takeWhile_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!arg1.test(t0)) {
				break;
			}
			if(!arg2.test(t0)) {
				break;
			}
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_takeWhile_takeWhile_flatMapLambda_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Function<T0, Collection<T1>> arg2, Collector<? super T1, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!arg1.test(t0)) {
				break;
			}
			for (T1 t1 : arg2.apply(t0)) {
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_takeWhile_takeWhile_flatMapMemberReference_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T1, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!arg1.test(t0)) {
				break;
			}
			for (T1 t1 : t0) {
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_takeWhile_flatMapLambda_map_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Function<T1, T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			for (T1 t1 : arg1.apply(t0)) {
				T2 t2 = arg2.apply(t1);
				arg3.accumulator().accept(result, t2);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_takeWhile_flatMapLambda_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			for (T1 t1 : arg1.apply(t0)) {
				if (!arg2.test(t1)) {
					continue;
				}
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_takeWhile_flatMapLambda_sorted_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Collector<? super T1, A, R> arg2) {
		List<T1> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			for (T1 t1 : arg1.apply(t0)) {
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_takeWhile_flatMapLambda_sortedComp_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Comparator<? super T1> arg2, Collector<? super T1, A, R> arg3) {
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			for (T1 t1 : arg1.apply(t0)) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg2);
		for (T1 t1: sortedComp0) {
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_takeWhile_flatMapLambda_limit_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, long arg2, Collector<? super T1, A, R> arg3) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			if(!arg0.test(t0)) {
				break;
			}
			for (T1 t1 : arg1.apply(t0)) {
				limit0++;
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_takeWhile_flatMapLambda_skip_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, long arg2, Collector<? super T1, A, R> arg3) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			for (T1 t1 : arg1.apply(t0)) {
				skip0++;
				if(skip0 <= arg2) {
					continue;
				}
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_takeWhile_flatMapLambda_distinct_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Collector<? super T1, A, R> arg2) {
		Set<T1> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			for (T1 t1 : arg1.apply(t0)) {
				if(!distinct0.add(t1)) {
					continue;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_takeWhile_flatMapLambda_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			for (T1 t1 : arg1.apply(t0)) {
				if(dropWhile0 && arg2.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_takeWhile_flatMapLambda_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			for (T1 t1 : arg1.apply(t0)) {
				if(!arg2.test(t1)) {
					break;
				}
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_takeWhile_flatMapLambda_flatMapLambda_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Function<T1, Collection<T2>> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			for (T1 t1 : arg1.apply(t0)) {
				for (T2 t2 : arg2.apply(t1)) {
					arg3.accumulator().accept(result, t2);
				}
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_takeWhile_flatMapLambda_flatMapMemberReference_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Collector<? super T2, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			for (T1 t1 : arg1.apply(t0)) {
				for (T2 t2 : t1) {
					arg2.accumulator().accept(result, t2);
				}
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_takeWhile_flatMapMemberReference_map_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T1, T2> arg1, Collector<? super T2, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			for (T1 t1 : t0) {
				T2 t2 = arg1.apply(t1);
				arg2.accumulator().accept(result, t2);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_takeWhile_flatMapMemberReference_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			for (T1 t1 : t0) {
				if (!arg1.test(t1)) {
					continue;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_takeWhile_flatMapMemberReference_sorted_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T1, A, R> arg1) {
		List<T1> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			for (T1 t1 : t0) {
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_takeWhile_flatMapMemberReference_sortedComp_collectCollector(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			for (T1 t1 : t0) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_takeWhile_flatMapMemberReference_limit_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(!arg0.test(t0)) {
				break;
			}
			for (T1 t1 : t0) {
				limit0++;
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_takeWhile_flatMapMemberReference_skip_collectCollector(Collection<T0> input, Predicate<T0> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			for (T1 t1 : t0) {
				skip0++;
				if(skip0 <= arg1) {
					continue;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_takeWhile_flatMapMemberReference_distinct_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T1, A, R> arg1) {
		Set<T1> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			for (T1 t1 : t0) {
				if(!distinct0.add(t1)) {
					continue;
				}
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_takeWhile_flatMapMemberReference_dropWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			for (T1 t1 : t0) {
				if(dropWhile0 && arg1.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_takeWhile_flatMapMemberReference_takeWhile_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			for (T1 t1 : t0) {
				if(!arg1.test(t1)) {
					break;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_takeWhile_flatMapMemberReference_flatMapLambda_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T1, Collection<T2>> arg1, Collector<? super T2, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			for (T1 t1 : t0) {
				for (T2 t2 : arg1.apply(t1)) {
					arg2.accumulator().accept(result, t2);
				}
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1 extends Collection<T2>, T2, R, A> R stream_takeWhile_flatMapMemberReference_flatMapMemberReference_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T2, A, R> arg1) {
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			for (T1 t1 : t0) {
				for (T2 t2 : t1) {
					arg1.accumulator().accept(result, t2);
				}
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, T2, T3, R, A> R stream_flatMapLambda_map_map_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, T2> arg1, Function<T2, T3> arg2, Collector<? super T3, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				T2 t2 = arg1.apply(t1);
				T3 t3 = arg2.apply(t2);
				arg3.accumulator().accept(result, t3);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_flatMapLambda_map_filter_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, T2> arg1, Predicate<T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				T2 t2 = arg1.apply(t1);
				if (!arg2.test(t2)) {
					continue;
				}
				arg3.accumulator().accept(result, t2);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_flatMapLambda_map_sorted_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, T2> arg1, Collector<? super T2, A, R> arg2) {
		List<T2> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				T2 t2 = arg1.apply(t1);
				sorted0.add(t2);
			}
		}
		sorted0.sort(null);
		for (T2 t2: sorted0) {
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_flatMapLambda_map_sortedComp_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, T2> arg1, Comparator<? super T2> arg2, Collector<? super T2, A, R> arg3) {
		List<T2> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				T2 t2 = arg1.apply(t1);
				sortedComp0.add(t2);
			}
		}
		sortedComp0.sort(arg2);
		for (T2 t2: sortedComp0) {
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_flatMapLambda_map_limit_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, T2> arg1, long arg2, Collector<? super T2, A, R> arg3) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			for (T1 t1 : arg0.apply(t0)) {
				T2 t2 = arg1.apply(t1);
				limit0++;
				arg3.accumulator().accept(result, t2);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_flatMapLambda_map_skip_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, T2> arg1, long arg2, Collector<? super T2, A, R> arg3) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				T2 t2 = arg1.apply(t1);
				skip0++;
				if(skip0 <= arg2) {
					continue;
				}
				arg3.accumulator().accept(result, t2);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_flatMapLambda_map_distinct_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, T2> arg1, Collector<? super T2, A, R> arg2) {
		Set<T2> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				T2 t2 = arg1.apply(t1);
				if(!distinct0.add(t2)) {
					continue;
				}
				arg2.accumulator().accept(result, t2);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_flatMapLambda_map_dropWhile_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, T2> arg1, Predicate<T2> arg2, Collector<? super T2, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				T2 t2 = arg1.apply(t1);
				if(dropWhile0 && arg2.test(t2)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				arg3.accumulator().accept(result, t2);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_flatMapLambda_map_takeWhile_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, T2> arg1, Predicate<T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				T2 t2 = arg1.apply(t1);
				if(!arg2.test(t2)) {
					break;
				}
				arg3.accumulator().accept(result, t2);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, T3, R, A> R stream_flatMapLambda_map_flatMapLambda_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, T2> arg1, Function<T2, Collection<T3>> arg2, Collector<? super T3, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				T2 t2 = arg1.apply(t1);
				for (T3 t3 : arg2.apply(t2)) {
					arg3.accumulator().accept(result, t3);
				}
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2 extends Collection<T3>, T3, R, A> R stream_flatMapLambda_map_flatMapMemberReference_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, T2> arg1, Collector<? super T3, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				T2 t2 = arg1.apply(t1);
				for (T3 t3 : t2) {
					arg2.accumulator().accept(result, t3);
				}
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_flatMapLambda_filter_map_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Function<T1, T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if (!arg1.test(t1)) {
					continue;
				}
				T2 t2 = arg2.apply(t1);
				arg3.accumulator().accept(result, t2);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_filter_filter_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if (!arg1.test(t1)) {
					continue;
				}
				if (!arg2.test(t1)) {
					continue;
				}
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_filter_sorted_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T1> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if (!arg1.test(t1)) {
					continue;
				}
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_filter_sortedComp_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Comparator<? super T1> arg2, Collector<? super T1, A, R> arg3) {
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if (!arg1.test(t1)) {
					continue;
				}
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg2);
		for (T1 t1: sortedComp0) {
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_filter_limit_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, long arg2, Collector<? super T1, A, R> arg3) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			for (T1 t1 : arg0.apply(t0)) {
				if (!arg1.test(t1)) {
					continue;
				}
				limit0++;
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_filter_skip_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, long arg2, Collector<? super T1, A, R> arg3) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if (!arg1.test(t1)) {
					continue;
				}
				skip0++;
				if(skip0 <= arg2) {
					continue;
				}
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_filter_distinct_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		Set<T1> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if (!arg1.test(t1)) {
					continue;
				}
				if(!distinct0.add(t1)) {
					continue;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_filter_dropWhile_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if (!arg1.test(t1)) {
					continue;
				}
				if(dropWhile0 && arg2.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_filter_takeWhile_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if (!arg1.test(t1)) {
					continue;
				}
				if(!arg2.test(t1)) {
					break;
				}
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_flatMapLambda_filter_flatMapLambda_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Function<T1, Collection<T2>> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if (!arg1.test(t1)) {
					continue;
				}
				for (T2 t2 : arg2.apply(t1)) {
					arg3.accumulator().accept(result, t2);
				}
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_flatMapLambda_filter_flatMapMemberReference_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Collector<? super T2, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if (!arg1.test(t1)) {
					continue;
				}
				for (T2 t2 : t1) {
					arg2.accumulator().accept(result, t2);
				}
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, T3, R, A> R stream_flatMapLambda_mapToInt_mapToObj_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToIntFunction<T1> arg1, IntFunction<T3> arg2, Collector<? super T3, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				int t2 = arg1.applyAsInt(t1);
				T3 t3 = arg2.apply(t2);
				arg3.accumulator().accept(result, t3);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_mapToInt_boxed_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToIntFunction<T1> arg1, Collector<? super Integer, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				int t2 = arg1.applyAsInt(t1);
				Integer t3 = t2;
				arg2.accumulator().accept(result, t3);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, T3, R, A> R stream_flatMapLambda_mapToLong_mapToObj_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToLongFunction<T1> arg1, LongFunction<T3> arg2, Collector<? super T3, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				long t2 = arg1.applyAsLong(t1);
				T3 t3 = arg2.apply(t2);
				arg3.accumulator().accept(result, t3);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_mapToLong_boxed_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToLongFunction<T1> arg1, Collector<? super Long, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				long t2 = arg1.applyAsLong(t1);
				Long t3 = t2;
				arg2.accumulator().accept(result, t3);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, T3, R, A> R stream_flatMapLambda_mapToDouble_mapToObj_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToDoubleFunction<T1> arg1, DoubleFunction<T3> arg2, Collector<? super T3, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				double t2 = arg1.applyAsDouble(t1);
				T3 t3 = arg2.apply(t2);
				arg3.accumulator().accept(result, t3);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_mapToDouble_boxed_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToDoubleFunction<T1> arg1, Collector<? super Double, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				double t2 = arg1.applyAsDouble(t1);
				Double t3 = t2;
				arg2.accumulator().accept(result, t3);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_flatMapLambda_sorted_map_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, T2> arg1, Collector<? super T2, A, R> arg2) {
		List<T1> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			T2 t2 = arg1.apply(t1);
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_sorted_filter_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T1> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			if (!arg1.test(t1)) {
				continue;
			}
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_sorted_sorted_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Collector<? super T1, A, R> arg1) {
		List<T1> sorted0 = new ArrayList<>();
		List<T1> sorted1 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			sorted1.add(t1);
		}
		sorted1.sort(null);
		for (T1 t1: sorted1) {
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_sorted_sortedComp_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Comparator<? super T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T1> sorted0 = new ArrayList<>();
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_sorted_limit_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		List<T1> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			for (T1 t1 : arg0.apply(t0)) {
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			limit0++;
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_sorted_skip_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		List<T1> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_sorted_distinct_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Collector<? super T1, A, R> arg1) {
		List<T1> sorted0 = new ArrayList<>();
		Set<T1> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			if(!distinct0.add(t1)) {
				continue;
			}
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_sorted_dropWhile_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T1> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_sorted_takeWhile_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T1> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			if(!arg1.test(t1)) {
				break;
			}
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_flatMapLambda_sorted_flatMapLambda_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, Collection<T2>> arg1, Collector<? super T2, A, R> arg2) {
		List<T1> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			for (T2 t2 : arg1.apply(t1)) {
				arg2.accumulator().accept(result, t2);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_flatMapLambda_sorted_flatMapMemberReference_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Collector<? super T2, A, R> arg1) {
		List<T1> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			for (T2 t2 : t1) {
				arg1.accumulator().accept(result, t2);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_flatMapLambda_sortedComp_map_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Comparator<? super T1> arg1, Function<T1, T2> arg2, Collector<? super T2, A, R> arg3) {
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_sortedComp_filter_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Comparator<? super T1> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			if (!arg2.test(t1)) {
				continue;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_sortedComp_sorted_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Comparator<? super T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		List<T1> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_sortedComp_sortedComp_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Comparator<? super T1> arg1, Comparator<? super T1> arg2, Collector<? super T1, A, R> arg3) {
		List<T1> sortedComp0 = new ArrayList<>();
		List<T1> sortedComp1 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			sortedComp1.add(t1);
		}
		sortedComp1.sort(arg2);
		for (T1 t1: sortedComp1) {
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_sortedComp_limit_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Comparator<? super T1> arg1, long arg2, Collector<? super T1, A, R> arg3) {
		List<T1> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			for (T1 t1 : arg0.apply(t0)) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			limit0++;
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_sortedComp_skip_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Comparator<? super T1> arg1, long arg2, Collector<? super T1, A, R> arg3) {
		List<T1> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_sortedComp_distinct_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Comparator<? super T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		Set<T1> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			if(!distinct0.add(t1)) {
				continue;
			}
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_sortedComp_dropWhile_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Comparator<? super T1> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		List<T1> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_sortedComp_takeWhile_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Comparator<? super T1> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			if(!arg2.test(t1)) {
				break;
			}
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_flatMapLambda_sortedComp_flatMapLambda_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Comparator<? super T1> arg1, Function<T1, Collection<T2>> arg2, Collector<? super T2, A, R> arg3) {
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			for (T2 t2 : arg2.apply(t1)) {
				arg3.accumulator().accept(result, t2);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_flatMapLambda_sortedComp_flatMapMemberReference_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Comparator<? super T1> arg1, Collector<? super T2, A, R> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			for (T2 t2 : t1) {
				arg2.accumulator().accept(result, t2);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_flatMapLambda_limit_map_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, Function<T1, T2> arg2, Collector<? super T2, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			for (T1 t1 : arg0.apply(t0)) {
				limit0++;
				T2 t2 = arg2.apply(t1);
				arg3.accumulator().accept(result, t2);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_limit_filter_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			for (T1 t1 : arg0.apply(t0)) {
				limit0++;
				if (!arg2.test(t1)) {
					continue;
				}
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_limit_sorted_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			for (T1 t1 : arg0.apply(t0)) {
				limit0++;
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_limit_sortedComp_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, Comparator<? super T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			for (T1 t1 : arg0.apply(t0)) {
				limit0++;
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg2);
		for (T1 t1: sortedComp0) {
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_limit_limit_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, long arg2, Collector<? super T1, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(limit1 >= arg2) {
				break;
			}
			for (T1 t1 : arg0.apply(t0)) {
				limit0++;
				limit1++;
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_limit_skip_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, long arg2, Collector<? super T1, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			for (T1 t1 : arg0.apply(t0)) {
				limit0++;
				skip0++;
				if(skip0 <= arg2) {
					continue;
				}
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_limit_distinct_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T1> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			for (T1 t1 : arg0.apply(t0)) {
				limit0++;
				if(!distinct0.add(t1)) {
					continue;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_limit_dropWhile_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			for (T1 t1 : arg0.apply(t0)) {
				limit0++;
				if(dropWhile0 && arg2.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_limit_takeWhile_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			for (T1 t1 : arg0.apply(t0)) {
				limit0++;
				if(!arg2.test(t1)) {
					break;
				}
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_flatMapLambda_limit_flatMapLambda_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, Function<T1, Collection<T2>> arg2, Collector<? super T2, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			for (T1 t1 : arg0.apply(t0)) {
				limit0++;
				for (T2 t2 : arg2.apply(t1)) {
					arg3.accumulator().accept(result, t2);
				}
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_flatMapLambda_limit_flatMapMemberReference_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, Collector<? super T2, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			for (T1 t1 : arg0.apply(t0)) {
				limit0++;
				for (T2 t2 : t1) {
					arg2.accumulator().accept(result, t2);
				}
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_flatMapLambda_skip_map_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, Function<T1, T2> arg2, Collector<? super T2, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				skip0++;
				if(skip0 <= arg1) {
					continue;
				}
				T2 t2 = arg2.apply(t1);
				arg3.accumulator().accept(result, t2);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_skip_filter_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				skip0++;
				if(skip0 <= arg1) {
					continue;
				}
				if (!arg2.test(t1)) {
					continue;
				}
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_skip_sorted_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				skip0++;
				if(skip0 <= arg1) {
					continue;
				}
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_skip_sortedComp_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, Comparator<? super T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				skip0++;
				if(skip0 <= arg1) {
					continue;
				}
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg2);
		for (T1 t1: sortedComp0) {
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_skip_limit_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, long arg2, Collector<? super T1, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			for (T1 t1 : arg0.apply(t0)) {
				skip0++;
				if(skip0 <= arg1) {
					continue;
				}
				limit0++;
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_skip_skip_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, long arg2, Collector<? super T1, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				skip0++;
				if(skip0 <= arg1) {
					continue;
				}
				skip1++;
				if(skip1 <= arg2) {
					continue;
				}
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_skip_distinct_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T1> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				skip0++;
				if(skip0 <= arg1) {
					continue;
				}
				if(!distinct0.add(t1)) {
					continue;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_skip_dropWhile_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				skip0++;
				if(skip0 <= arg1) {
					continue;
				}
				if(dropWhile0 && arg2.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_skip_takeWhile_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				skip0++;
				if(skip0 <= arg1) {
					continue;
				}
				if(!arg2.test(t1)) {
					break;
				}
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_flatMapLambda_skip_flatMapLambda_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, Function<T1, Collection<T2>> arg2, Collector<? super T2, A, R> arg3) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				skip0++;
				if(skip0 <= arg1) {
					continue;
				}
				for (T2 t2 : arg2.apply(t1)) {
					arg3.accumulator().accept(result, t2);
				}
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_flatMapLambda_skip_flatMapMemberReference_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, Collector<? super T2, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				skip0++;
				if(skip0 <= arg1) {
					continue;
				}
				for (T2 t2 : t1) {
					arg2.accumulator().accept(result, t2);
				}
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_flatMapLambda_distinct_map_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, T2> arg1, Collector<? super T2, A, R> arg2) {
		Set<T1> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!distinct0.add(t1)) {
					continue;
				}
				T2 t2 = arg1.apply(t1);
				arg2.accumulator().accept(result, t2);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_distinct_filter_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		Set<T1> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!distinct0.add(t1)) {
					continue;
				}
				if (!arg1.test(t1)) {
					continue;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_distinct_sorted_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Collector<? super T1, A, R> arg1) {
		Set<T1> distinct0 = new HashSet<>();
		List<T1> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!distinct0.add(t1)) {
					continue;
				}
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_distinct_sortedComp_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Comparator<? super T1> arg1, Collector<? super T1, A, R> arg2) {
		Set<T1> distinct0 = new HashSet<>();
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!distinct0.add(t1)) {
					continue;
				}
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_distinct_limit_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		Set<T1> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			for (T1 t1 : arg0.apply(t0)) {
				if(!distinct0.add(t1)) {
					continue;
				}
				limit0++;
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_distinct_skip_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		Set<T1> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!distinct0.add(t1)) {
					continue;
				}
				skip0++;
				if(skip0 <= arg1) {
					continue;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_distinct_distinct_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Collector<? super T1, A, R> arg1) {
		Set<T1> distinct0 = new HashSet<>();
		Set<T1> distinct1 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!distinct0.add(t1)) {
					continue;
				}
				if(!distinct1.add(t1)) {
					continue;
				}
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_distinct_dropWhile_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		Set<T1> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!distinct0.add(t1)) {
					continue;
				}
				if(dropWhile0 && arg1.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_distinct_takeWhile_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		Set<T1> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!distinct0.add(t1)) {
					continue;
				}
				if(!arg1.test(t1)) {
					break;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_flatMapLambda_distinct_flatMapLambda_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, Collection<T2>> arg1, Collector<? super T2, A, R> arg2) {
		Set<T1> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!distinct0.add(t1)) {
					continue;
				}
				for (T2 t2 : arg1.apply(t1)) {
					arg2.accumulator().accept(result, t2);
				}
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_flatMapLambda_distinct_flatMapMemberReference_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Collector<? super T2, A, R> arg1) {
		Set<T1> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!distinct0.add(t1)) {
					continue;
				}
				for (T2 t2 : t1) {
					arg1.accumulator().accept(result, t2);
				}
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_flatMapLambda_dropWhile_map_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Function<T1, T2> arg2, Collector<? super T2, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(dropWhile0 && arg1.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				T2 t2 = arg2.apply(t1);
				arg3.accumulator().accept(result, t2);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_dropWhile_filter_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(dropWhile0 && arg1.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				if (!arg2.test(t1)) {
					continue;
				}
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_dropWhile_sorted_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		boolean dropWhile0 = true;
		List<T1> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(dropWhile0 && arg1.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_dropWhile_sortedComp_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Comparator<? super T1> arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(dropWhile0 && arg1.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg2);
		for (T1 t1: sortedComp0) {
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_dropWhile_limit_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, long arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			for (T1 t1 : arg0.apply(t0)) {
				if(dropWhile0 && arg1.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				limit0++;
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_dropWhile_skip_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, long arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(dropWhile0 && arg1.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				skip0++;
				if(skip0 <= arg2) {
					continue;
				}
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_dropWhile_distinct_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		boolean dropWhile0 = true;
		Set<T1> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(dropWhile0 && arg1.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				if(!distinct0.add(t1)) {
					continue;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_dropWhile_dropWhile_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(dropWhile0 && arg1.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				if(dropWhile1 && arg2.test(t1)) {
					continue;
				} else {
					dropWhile1 = false;
				}
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_dropWhile_takeWhile_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(dropWhile0 && arg1.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				if(!arg2.test(t1)) {
					break;
				}
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_flatMapLambda_dropWhile_flatMapLambda_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Function<T1, Collection<T2>> arg2, Collector<? super T2, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(dropWhile0 && arg1.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				for (T2 t2 : arg2.apply(t1)) {
					arg3.accumulator().accept(result, t2);
				}
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_flatMapLambda_dropWhile_flatMapMemberReference_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Collector<? super T2, A, R> arg2) {
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(dropWhile0 && arg1.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				for (T2 t2 : t1) {
					arg2.accumulator().accept(result, t2);
				}
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_flatMapLambda_takeWhile_map_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Function<T1, T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!arg1.test(t1)) {
					break;
				}
				T2 t2 = arg2.apply(t1);
				arg3.accumulator().accept(result, t2);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_takeWhile_filter_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!arg1.test(t1)) {
					break;
				}
				if (!arg2.test(t1)) {
					continue;
				}
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_takeWhile_sorted_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T1> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!arg1.test(t1)) {
					break;
				}
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_takeWhile_sortedComp_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Comparator<? super T1> arg2, Collector<? super T1, A, R> arg3) {
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!arg1.test(t1)) {
					break;
				}
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg2);
		for (T1 t1: sortedComp0) {
			arg3.accumulator().accept(result, t1);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_takeWhile_limit_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, long arg2, Collector<? super T1, A, R> arg3) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			for (T1 t1 : arg0.apply(t0)) {
				if(!arg1.test(t1)) {
					break;
				}
				limit0++;
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_takeWhile_skip_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, long arg2, Collector<? super T1, A, R> arg3) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!arg1.test(t1)) {
					break;
				}
				skip0++;
				if(skip0 <= arg2) {
					continue;
				}
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_takeWhile_distinct_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		Set<T1> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!arg1.test(t1)) {
					break;
				}
				if(!distinct0.add(t1)) {
					continue;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_takeWhile_dropWhile_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!arg1.test(t1)) {
					break;
				}
				if(dropWhile0 && arg2.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, R, A> R stream_flatMapLambda_takeWhile_takeWhile_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!arg1.test(t1)) {
					break;
				}
				if(!arg2.test(t1)) {
					break;
				}
				arg3.accumulator().accept(result, t1);
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_flatMapLambda_takeWhile_flatMapLambda_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Function<T1, Collection<T2>> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!arg1.test(t1)) {
					break;
				}
				for (T2 t2 : arg2.apply(t1)) {
					arg3.accumulator().accept(result, t2);
				}
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_flatMapLambda_takeWhile_flatMapMemberReference_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Collector<? super T2, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!arg1.test(t1)) {
					break;
				}
				for (T2 t2 : t1) {
					arg2.accumulator().accept(result, t2);
				}
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, T2, T3, R, A> R stream_flatMapLambda_flatMapLambda_map_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, Collection<T2>> arg1, Function<T2, T3> arg2, Collector<? super T3, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				for (T2 t2 : arg1.apply(t1)) {
					T3 t3 = arg2.apply(t2);
					arg3.accumulator().accept(result, t3);
				}
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_flatMapLambda_flatMapLambda_filter_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, Collection<T2>> arg1, Predicate<T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				for (T2 t2 : arg1.apply(t1)) {
					if (!arg2.test(t2)) {
						continue;
					}
					arg3.accumulator().accept(result, t2);
				}
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_flatMapLambda_flatMapLambda_sorted_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, Collection<T2>> arg1, Collector<? super T2, A, R> arg2) {
		List<T2> sorted0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				for (T2 t2 : arg1.apply(t1)) {
					sorted0.add(t2);
				}
			}
		}
		sorted0.sort(null);
		for (T2 t2: sorted0) {
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_flatMapLambda_flatMapLambda_sortedComp_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, Collection<T2>> arg1, Comparator<? super T2> arg2, Collector<? super T2, A, R> arg3) {
		List<T2> sortedComp0 = new ArrayList<>();
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				for (T2 t2 : arg1.apply(t1)) {
					sortedComp0.add(t2);
				}
			}
		}
		sortedComp0.sort(arg2);
		for (T2 t2: sortedComp0) {
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_flatMapLambda_flatMapLambda_limit_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, Collection<T2>> arg1, long arg2, Collector<? super T2, A, R> arg3) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			for (T1 t1 : arg0.apply(t0)) {
				for (T2 t2 : arg1.apply(t1)) {
					limit0++;
					arg3.accumulator().accept(result, t2);
				}
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_flatMapLambda_flatMapLambda_skip_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, Collection<T2>> arg1, long arg2, Collector<? super T2, A, R> arg3) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				for (T2 t2 : arg1.apply(t1)) {
					skip0++;
					if(skip0 <= arg2) {
						continue;
					}
					arg3.accumulator().accept(result, t2);
				}
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_flatMapLambda_flatMapLambda_distinct_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, Collection<T2>> arg1, Collector<? super T2, A, R> arg2) {
		Set<T2> distinct0 = new HashSet<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				for (T2 t2 : arg1.apply(t1)) {
					if(!distinct0.add(t2)) {
						continue;
					}
					arg2.accumulator().accept(result, t2);
				}
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_flatMapLambda_flatMapLambda_dropWhile_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, Collection<T2>> arg1, Predicate<T2> arg2, Collector<? super T2, A, R> arg3) {
		boolean dropWhile0 = true;
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				for (T2 t2 : arg1.apply(t1)) {
					if(dropWhile0 && arg2.test(t2)) {
						continue;
					} else {
						dropWhile0 = false;
					}
					arg3.accumulator().accept(result, t2);
				}
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, R, A> R stream_flatMapLambda_flatMapLambda_takeWhile_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, Collection<T2>> arg1, Predicate<T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				for (T2 t2 : arg1.apply(t1)) {
					if(!arg2.test(t2)) {
						break;
					}
					arg3.accumulator().accept(result, t2);
				}
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, T3, R, A> R stream_flatMapLambda_flatMapLambda_flatMapLambda_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, Collection<T2>> arg1, Function<T2, Collection<T3>> arg2, Collector<? super T3, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				for (T2 t2 : arg1.apply(t1)) {
					for (T3 t3 : arg2.apply(t2)) {
						arg3.accumulator().accept(result, t3);
					}
				}
			}
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2 extends Collection<T3>, T3, R, A> R stream_flatMapLambda_flatMapLambda_flatMapMemberReference_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, Collection<T2>> arg1, Collector<? super T3, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				for (T2 t2 : arg1.apply(t1)) {
					for (T3 t3 : t2) {
						arg2.accumulator().accept(result, t3);
					}
				}
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, T3, R, A> R stream_flatMapLambda_flatMapMemberReference_map_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T2, T3> arg1, Collector<? super T3, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				for (T2 t2 : t1) {
					T3 t3 = arg1.apply(t2);
					arg2.accumulator().accept(result, t3);
				}
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_flatMapLambda_flatMapMemberReference_filter_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T2> arg1, Collector<? super T2, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				for (T2 t2 : t1) {
					if (!arg1.test(t2)) {
						continue;
					}
					arg2.accumulator().accept(result, t2);
				}
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_flatMapLambda_flatMapMemberReference_sorted_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Collector<? super T2, A, R> arg1) {
		List<T2> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				for (T2 t2 : t1) {
					sorted0.add(t2);
				}
			}
		}
		sorted0.sort(null);
		for (T2 t2: sorted0) {
			arg1.accumulator().accept(result, t2);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_flatMapLambda_flatMapMemberReference_sortedComp_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Comparator<? super T2> arg1, Collector<? super T2, A, R> arg2) {
		List<T2> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				for (T2 t2 : t1) {
					sortedComp0.add(t2);
				}
			}
		}
		sortedComp0.sort(arg1);
		for (T2 t2: sortedComp0) {
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_flatMapLambda_flatMapMemberReference_limit_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, Collector<? super T2, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			for (T1 t1 : arg0.apply(t0)) {
				for (T2 t2 : t1) {
					limit0++;
					arg2.accumulator().accept(result, t2);
				}
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_flatMapLambda_flatMapMemberReference_skip_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, Collector<? super T2, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				for (T2 t2 : t1) {
					skip0++;
					if(skip0 <= arg1) {
						continue;
					}
					arg2.accumulator().accept(result, t2);
				}
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_flatMapLambda_flatMapMemberReference_distinct_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Collector<? super T2, A, R> arg1) {
		Set<T2> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				for (T2 t2 : t1) {
					if(!distinct0.add(t2)) {
						continue;
					}
					arg1.accumulator().accept(result, t2);
				}
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_flatMapLambda_flatMapMemberReference_dropWhile_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T2> arg1, Collector<? super T2, A, R> arg2) {
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				for (T2 t2 : t1) {
					if(dropWhile0 && arg1.test(t2)) {
						continue;
					} else {
						dropWhile0 = false;
					}
					arg2.accumulator().accept(result, t2);
				}
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, R, A> R stream_flatMapLambda_flatMapMemberReference_takeWhile_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T2> arg1, Collector<? super T2, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				for (T2 t2 : t1) {
					if(!arg1.test(t2)) {
						break;
					}
					arg2.accumulator().accept(result, t2);
				}
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2, T3, R, A> R stream_flatMapLambda_flatMapMemberReference_flatMapLambda_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T2, Collection<T3>> arg1, Collector<? super T3, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				for (T2 t2 : t1) {
					for (T3 t3 : arg1.apply(t2)) {
						arg2.accumulator().accept(result, t3);
					}
				}
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1 extends Collection<T2>, T2 extends Collection<T3>, T3, R, A> R stream_flatMapLambda_flatMapMemberReference_flatMapMemberReference_collectCollector(Collection<T0> input, Function<T0, Collection<T1>> arg0, Collector<? super T3, A, R> arg1) {
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				for (T2 t2 : t1) {
					for (T3 t3 : t2) {
						arg1.accumulator().accept(result, t3);
					}
				}
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, T3, R, A> R stream_flatMapMemberReference_map_map_collectCollector(Collection<T0> input, Function<T1, T2> arg0, Function<T2, T3> arg1, Collector<? super T3, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				T2 t2 = arg0.apply(t1);
				T3 t3 = arg1.apply(t2);
				arg2.accumulator().accept(result, t3);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_flatMapMemberReference_map_filter_collectCollector(Collection<T0> input, Function<T1, T2> arg0, Predicate<T2> arg1, Collector<? super T2, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				T2 t2 = arg0.apply(t1);
				if (!arg1.test(t2)) {
					continue;
				}
				arg2.accumulator().accept(result, t2);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_flatMapMemberReference_map_sorted_collectCollector(Collection<T0> input, Function<T1, T2> arg0, Collector<? super T2, A, R> arg1) {
		List<T2> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				T2 t2 = arg0.apply(t1);
				sorted0.add(t2);
			}
		}
		sorted0.sort(null);
		for (T2 t2: sorted0) {
			arg1.accumulator().accept(result, t2);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_flatMapMemberReference_map_sortedComp_collectCollector(Collection<T0> input, Function<T1, T2> arg0, Comparator<? super T2> arg1, Collector<? super T2, A, R> arg2) {
		List<T2> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				T2 t2 = arg0.apply(t1);
				sortedComp0.add(t2);
			}
		}
		sortedComp0.sort(arg1);
		for (T2 t2: sortedComp0) {
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_flatMapMemberReference_map_limit_collectCollector(Collection<T0> input, Function<T1, T2> arg0, long arg1, Collector<? super T2, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			for (T1 t1 : t0) {
				T2 t2 = arg0.apply(t1);
				limit0++;
				arg2.accumulator().accept(result, t2);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_flatMapMemberReference_map_skip_collectCollector(Collection<T0> input, Function<T1, T2> arg0, long arg1, Collector<? super T2, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				T2 t2 = arg0.apply(t1);
				skip0++;
				if(skip0 <= arg1) {
					continue;
				}
				arg2.accumulator().accept(result, t2);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_flatMapMemberReference_map_distinct_collectCollector(Collection<T0> input, Function<T1, T2> arg0, Collector<? super T2, A, R> arg1) {
		Set<T2> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				T2 t2 = arg0.apply(t1);
				if(!distinct0.add(t2)) {
					continue;
				}
				arg1.accumulator().accept(result, t2);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_flatMapMemberReference_map_dropWhile_collectCollector(Collection<T0> input, Function<T1, T2> arg0, Predicate<T2> arg1, Collector<? super T2, A, R> arg2) {
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				T2 t2 = arg0.apply(t1);
				if(dropWhile0 && arg1.test(t2)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				arg2.accumulator().accept(result, t2);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_flatMapMemberReference_map_takeWhile_collectCollector(Collection<T0> input, Function<T1, T2> arg0, Predicate<T2> arg1, Collector<? super T2, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				T2 t2 = arg0.apply(t1);
				if(!arg1.test(t2)) {
					break;
				}
				arg2.accumulator().accept(result, t2);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, T3, R, A> R stream_flatMapMemberReference_map_flatMapLambda_collectCollector(Collection<T0> input, Function<T1, T2> arg0, Function<T2, Collection<T3>> arg1, Collector<? super T3, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				T2 t2 = arg0.apply(t1);
				for (T3 t3 : arg1.apply(t2)) {
					arg2.accumulator().accept(result, t3);
				}
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2 extends Collection<T3>, T3, R, A> R stream_flatMapMemberReference_map_flatMapMemberReference_collectCollector(Collection<T0> input, Function<T1, T2> arg0, Collector<? super T3, A, R> arg1) {
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				T2 t2 = arg0.apply(t1);
				for (T3 t3 : t2) {
					arg1.accumulator().accept(result, t3);
				}
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_flatMapMemberReference_filter_map_collectCollector(Collection<T0> input, Predicate<T1> arg0, Function<T1, T2> arg1, Collector<? super T2, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if (!arg0.test(t1)) {
					continue;
				}
				T2 t2 = arg1.apply(t1);
				arg2.accumulator().accept(result, t2);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_filter_filter_collectCollector(Collection<T0> input, Predicate<T1> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if (!arg0.test(t1)) {
					continue;
				}
				if (!arg1.test(t1)) {
					continue;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_filter_sorted_collectCollector(Collection<T0> input, Predicate<T1> arg0, Collector<? super T1, A, R> arg1) {
		List<T1> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if (!arg0.test(t1)) {
					continue;
				}
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_filter_sortedComp_collectCollector(Collection<T0> input, Predicate<T1> arg0, Comparator<? super T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if (!arg0.test(t1)) {
					continue;
				}
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_filter_limit_collectCollector(Collection<T0> input, Predicate<T1> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			for (T1 t1 : t0) {
				if (!arg0.test(t1)) {
					continue;
				}
				limit0++;
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_filter_skip_collectCollector(Collection<T0> input, Predicate<T1> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if (!arg0.test(t1)) {
					continue;
				}
				skip0++;
				if(skip0 <= arg1) {
					continue;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_filter_distinct_collectCollector(Collection<T0> input, Predicate<T1> arg0, Collector<? super T1, A, R> arg1) {
		Set<T1> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if (!arg0.test(t1)) {
					continue;
				}
				if(!distinct0.add(t1)) {
					continue;
				}
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_filter_dropWhile_collectCollector(Collection<T0> input, Predicate<T1> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if (!arg0.test(t1)) {
					continue;
				}
				if(dropWhile0 && arg1.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_filter_takeWhile_collectCollector(Collection<T0> input, Predicate<T1> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if (!arg0.test(t1)) {
					continue;
				}
				if(!arg1.test(t1)) {
					break;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_flatMapMemberReference_filter_flatMapLambda_collectCollector(Collection<T0> input, Predicate<T1> arg0, Function<T1, Collection<T2>> arg1, Collector<? super T2, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if (!arg0.test(t1)) {
					continue;
				}
				for (T2 t2 : arg1.apply(t1)) {
					arg2.accumulator().accept(result, t2);
				}
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1 extends Collection<T2>, T2, R, A> R stream_flatMapMemberReference_filter_flatMapMemberReference_collectCollector(Collection<T0> input, Predicate<T1> arg0, Collector<? super T2, A, R> arg1) {
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if (!arg0.test(t1)) {
					continue;
				}
				for (T2 t2 : t1) {
					arg1.accumulator().accept(result, t2);
				}
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T3, R, A> R stream_flatMapMemberReference_mapToInt_mapToObj_collectCollector(Collection<T0> input, ToIntFunction<T1> arg0, IntFunction<T3> arg1, Collector<? super T3, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				int t2 = arg0.applyAsInt(t1);
				T3 t3 = arg1.apply(t2);
				arg2.accumulator().accept(result, t3);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_mapToInt_boxed_collectCollector(Collection<T0> input, ToIntFunction<T1> arg0, Collector<? super Integer, A, R> arg1) {
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				int t2 = arg0.applyAsInt(t1);
				Integer t3 = t2;
				arg1.accumulator().accept(result, t3);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T3, R, A> R stream_flatMapMemberReference_mapToLong_mapToObj_collectCollector(Collection<T0> input, ToLongFunction<T1> arg0, LongFunction<T3> arg1, Collector<? super T3, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				long t2 = arg0.applyAsLong(t1);
				T3 t3 = arg1.apply(t2);
				arg2.accumulator().accept(result, t3);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_mapToLong_boxed_collectCollector(Collection<T0> input, ToLongFunction<T1> arg0, Collector<? super Long, A, R> arg1) {
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				long t2 = arg0.applyAsLong(t1);
				Long t3 = t2;
				arg1.accumulator().accept(result, t3);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T3, R, A> R stream_flatMapMemberReference_mapToDouble_mapToObj_collectCollector(Collection<T0> input, ToDoubleFunction<T1> arg0, DoubleFunction<T3> arg1, Collector<? super T3, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				double t2 = arg0.applyAsDouble(t1);
				T3 t3 = arg1.apply(t2);
				arg2.accumulator().accept(result, t3);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_mapToDouble_boxed_collectCollector(Collection<T0> input, ToDoubleFunction<T1> arg0, Collector<? super Double, A, R> arg1) {
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				double t2 = arg0.applyAsDouble(t1);
				Double t3 = t2;
				arg1.accumulator().accept(result, t3);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_flatMapMemberReference_sorted_map_collectCollector(Collection<T0> input, Function<T1, T2> arg0, Collector<? super T2, A, R> arg1) {
		List<T1> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			T2 t2 = arg0.apply(t1);
			arg1.accumulator().accept(result, t2);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_sorted_filter_collectCollector(Collection<T0> input, Predicate<T1> arg0, Collector<? super T1, A, R> arg1) {
		List<T1> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			if (!arg0.test(t1)) {
				continue;
			}
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_sorted_sorted_collectCollector(Collection<T0> input, Collector<? super T1, A, R> arg0) {
		List<T1> sorted0 = new ArrayList<>();
		List<T1> sorted1 = new ArrayList<>();
		A result = arg0.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			sorted1.add(t1);
		}
		sorted1.sort(null);
		for (T1 t1: sorted1) {
			arg0.accumulator().accept(result, t1);
		}
		return arg0.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_sorted_sortedComp_collectCollector(Collection<T0> input, Comparator<? super T1> arg0, Collector<? super T1, A, R> arg1) {
		List<T1> sorted0 = new ArrayList<>();
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg0);
		for (T1 t1: sortedComp0) {
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_sorted_limit_collectCollector(Collection<T0> input, long arg0, Collector<? super T1, A, R> arg1) {
		List<T1> sorted0 = new ArrayList<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			for (T1 t1 : t0) {
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			limit0++;
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_sorted_skip_collectCollector(Collection<T0> input, long arg0, Collector<? super T1, A, R> arg1) {
		List<T1> sorted0 = new ArrayList<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_sorted_distinct_collectCollector(Collection<T0> input, Collector<? super T1, A, R> arg0) {
		List<T1> sorted0 = new ArrayList<>();
		Set<T1> distinct0 = new HashSet<>();
		A result = arg0.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			if(!distinct0.add(t1)) {
				continue;
			}
			arg0.accumulator().accept(result, t1);
		}
		return arg0.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_sorted_dropWhile_collectCollector(Collection<T0> input, Predicate<T1> arg0, Collector<? super T1, A, R> arg1) {
		List<T1> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			if(dropWhile0 && arg0.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_sorted_takeWhile_collectCollector(Collection<T0> input, Predicate<T1> arg0, Collector<? super T1, A, R> arg1) {
		List<T1> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			if(!arg0.test(t1)) {
				break;
			}
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_flatMapMemberReference_sorted_flatMapLambda_collectCollector(Collection<T0> input, Function<T1, Collection<T2>> arg0, Collector<? super T2, A, R> arg1) {
		List<T1> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			for (T2 t2 : arg0.apply(t1)) {
				arg1.accumulator().accept(result, t2);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1 extends Collection<T2>, T2, R, A> R stream_flatMapMemberReference_sorted_flatMapMemberReference_collectCollector(Collection<T0> input, Collector<? super T2, A, R> arg0) {
		List<T1> sorted0 = new ArrayList<>();
		A result = arg0.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			for (T2 t2 : t1) {
				arg0.accumulator().accept(result, t2);
			}
		}
		return arg0.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_flatMapMemberReference_sortedComp_map_collectCollector(Collection<T0> input, Comparator<? super T1> arg0, Function<T1, T2> arg1, Collector<? super T2, A, R> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg0);
		for (T1 t1: sortedComp0) {
			T2 t2 = arg1.apply(t1);
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_sortedComp_filter_collectCollector(Collection<T0> input, Comparator<? super T1> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg0);
		for (T1 t1: sortedComp0) {
			if (!arg1.test(t1)) {
				continue;
			}
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_sortedComp_sorted_collectCollector(Collection<T0> input, Comparator<? super T1> arg0, Collector<? super T1, A, R> arg1) {
		List<T1> sortedComp0 = new ArrayList<>();
		List<T1> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg0);
		for (T1 t1: sortedComp0) {
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_sortedComp_sortedComp_collectCollector(Collection<T0> input, Comparator<? super T1> arg0, Comparator<? super T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		List<T1> sortedComp1 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg0);
		for (T1 t1: sortedComp0) {
			sortedComp1.add(t1);
		}
		sortedComp1.sort(arg1);
		for (T1 t1: sortedComp1) {
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_sortedComp_limit_collectCollector(Collection<T0> input, Comparator<? super T1> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			for (T1 t1 : t0) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg0);
		for (T1 t1: sortedComp0) {
			limit0++;
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_sortedComp_skip_collectCollector(Collection<T0> input, Comparator<? super T1> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg0);
		for (T1 t1: sortedComp0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_sortedComp_distinct_collectCollector(Collection<T0> input, Comparator<? super T1> arg0, Collector<? super T1, A, R> arg1) {
		List<T1> sortedComp0 = new ArrayList<>();
		Set<T1> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg0);
		for (T1 t1: sortedComp0) {
			if(!distinct0.add(t1)) {
				continue;
			}
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_sortedComp_dropWhile_collectCollector(Collection<T0> input, Comparator<? super T1> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg0);
		for (T1 t1: sortedComp0) {
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_sortedComp_takeWhile_collectCollector(Collection<T0> input, Comparator<? super T1> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg0);
		for (T1 t1: sortedComp0) {
			if(!arg1.test(t1)) {
				break;
			}
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_flatMapMemberReference_sortedComp_flatMapLambda_collectCollector(Collection<T0> input, Comparator<? super T1> arg0, Function<T1, Collection<T2>> arg1, Collector<? super T2, A, R> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg0);
		for (T1 t1: sortedComp0) {
			for (T2 t2 : arg1.apply(t1)) {
				arg2.accumulator().accept(result, t2);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1 extends Collection<T2>, T2, R, A> R stream_flatMapMemberReference_sortedComp_flatMapMemberReference_collectCollector(Collection<T0> input, Comparator<? super T1> arg0, Collector<? super T2, A, R> arg1) {
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg0);
		for (T1 t1: sortedComp0) {
			for (T2 t2 : t1) {
				arg1.accumulator().accept(result, t2);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_flatMapMemberReference_limit_map_collectCollector(Collection<T0> input, long arg0, Function<T1, T2> arg1, Collector<? super T2, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			for (T1 t1 : t0) {
				limit0++;
				T2 t2 = arg1.apply(t1);
				arg2.accumulator().accept(result, t2);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_limit_filter_collectCollector(Collection<T0> input, long arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			for (T1 t1 : t0) {
				limit0++;
				if (!arg1.test(t1)) {
					continue;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_limit_sorted_collectCollector(Collection<T0> input, long arg0, Collector<? super T1, A, R> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			for (T1 t1 : t0) {
				limit0++;
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_limit_sortedComp_collectCollector(Collection<T0> input, long arg0, Comparator<? super T1> arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			for (T1 t1 : t0) {
				limit0++;
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_limit_limit_collectCollector(Collection<T0> input, long arg0, long arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(limit1 >= arg1) {
				break;
			}
			for (T1 t1 : t0) {
				limit0++;
				limit1++;
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_limit_skip_collectCollector(Collection<T0> input, long arg0, long arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			for (T1 t1 : t0) {
				limit0++;
				skip0++;
				if(skip0 <= arg1) {
					continue;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_limit_distinct_collectCollector(Collection<T0> input, long arg0, Collector<? super T1, A, R> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T1> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			for (T1 t1 : t0) {
				limit0++;
				if(!distinct0.add(t1)) {
					continue;
				}
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_limit_dropWhile_collectCollector(Collection<T0> input, long arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			for (T1 t1 : t0) {
				limit0++;
				if(dropWhile0 && arg1.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_limit_takeWhile_collectCollector(Collection<T0> input, long arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			for (T1 t1 : t0) {
				limit0++;
				if(!arg1.test(t1)) {
					break;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_flatMapMemberReference_limit_flatMapLambda_collectCollector(Collection<T0> input, long arg0, Function<T1, Collection<T2>> arg1, Collector<? super T2, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			for (T1 t1 : t0) {
				limit0++;
				for (T2 t2 : arg1.apply(t1)) {
					arg2.accumulator().accept(result, t2);
				}
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1 extends Collection<T2>, T2, R, A> R stream_flatMapMemberReference_limit_flatMapMemberReference_collectCollector(Collection<T0> input, long arg0, Collector<? super T2, A, R> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			for (T1 t1 : t0) {
				limit0++;
				for (T2 t2 : t1) {
					arg1.accumulator().accept(result, t2);
				}
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_flatMapMemberReference_skip_map_collectCollector(Collection<T0> input, long arg0, Function<T1, T2> arg1, Collector<? super T2, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				skip0++;
				if(skip0 <= arg0) {
					continue;
				}
				T2 t2 = arg1.apply(t1);
				arg2.accumulator().accept(result, t2);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_skip_filter_collectCollector(Collection<T0> input, long arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				skip0++;
				if(skip0 <= arg0) {
					continue;
				}
				if (!arg1.test(t1)) {
					continue;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_skip_sorted_collectCollector(Collection<T0> input, long arg0, Collector<? super T1, A, R> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				skip0++;
				if(skip0 <= arg0) {
					continue;
				}
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_skip_sortedComp_collectCollector(Collection<T0> input, long arg0, Comparator<? super T1> arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				skip0++;
				if(skip0 <= arg0) {
					continue;
				}
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_skip_limit_collectCollector(Collection<T0> input, long arg0, long arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			for (T1 t1 : t0) {
				skip0++;
				if(skip0 <= arg0) {
					continue;
				}
				limit0++;
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_skip_skip_collectCollector(Collection<T0> input, long arg0, long arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				skip0++;
				if(skip0 <= arg0) {
					continue;
				}
				skip1++;
				if(skip1 <= arg1) {
					continue;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_skip_distinct_collectCollector(Collection<T0> input, long arg0, Collector<? super T1, A, R> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T1> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				skip0++;
				if(skip0 <= arg0) {
					continue;
				}
				if(!distinct0.add(t1)) {
					continue;
				}
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_skip_dropWhile_collectCollector(Collection<T0> input, long arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				skip0++;
				if(skip0 <= arg0) {
					continue;
				}
				if(dropWhile0 && arg1.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_skip_takeWhile_collectCollector(Collection<T0> input, long arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				skip0++;
				if(skip0 <= arg0) {
					continue;
				}
				if(!arg1.test(t1)) {
					break;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_flatMapMemberReference_skip_flatMapLambda_collectCollector(Collection<T0> input, long arg0, Function<T1, Collection<T2>> arg1, Collector<? super T2, A, R> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				skip0++;
				if(skip0 <= arg0) {
					continue;
				}
				for (T2 t2 : arg1.apply(t1)) {
					arg2.accumulator().accept(result, t2);
				}
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1 extends Collection<T2>, T2, R, A> R stream_flatMapMemberReference_skip_flatMapMemberReference_collectCollector(Collection<T0> input, long arg0, Collector<? super T2, A, R> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				skip0++;
				if(skip0 <= arg0) {
					continue;
				}
				for (T2 t2 : t1) {
					arg1.accumulator().accept(result, t2);
				}
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_flatMapMemberReference_distinct_map_collectCollector(Collection<T0> input, Function<T1, T2> arg0, Collector<? super T2, A, R> arg1) {
		Set<T1> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if(!distinct0.add(t1)) {
					continue;
				}
				T2 t2 = arg0.apply(t1);
				arg1.accumulator().accept(result, t2);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_distinct_filter_collectCollector(Collection<T0> input, Predicate<T1> arg0, Collector<? super T1, A, R> arg1) {
		Set<T1> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if(!distinct0.add(t1)) {
					continue;
				}
				if (!arg0.test(t1)) {
					continue;
				}
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_distinct_sorted_collectCollector(Collection<T0> input, Collector<? super T1, A, R> arg0) {
		Set<T1> distinct0 = new HashSet<>();
		List<T1> sorted0 = new ArrayList<>();
		A result = arg0.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if(!distinct0.add(t1)) {
					continue;
				}
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			arg0.accumulator().accept(result, t1);
		}
		return arg0.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_distinct_sortedComp_collectCollector(Collection<T0> input, Comparator<? super T1> arg0, Collector<? super T1, A, R> arg1) {
		Set<T1> distinct0 = new HashSet<>();
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if(!distinct0.add(t1)) {
					continue;
				}
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg0);
		for (T1 t1: sortedComp0) {
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_distinct_limit_collectCollector(Collection<T0> input, long arg0, Collector<? super T1, A, R> arg1) {
		Set<T1> distinct0 = new HashSet<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			for (T1 t1 : t0) {
				if(!distinct0.add(t1)) {
					continue;
				}
				limit0++;
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_distinct_skip_collectCollector(Collection<T0> input, long arg0, Collector<? super T1, A, R> arg1) {
		Set<T1> distinct0 = new HashSet<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if(!distinct0.add(t1)) {
					continue;
				}
				skip0++;
				if(skip0 <= arg0) {
					continue;
				}
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_distinct_distinct_collectCollector(Collection<T0> input, Collector<? super T1, A, R> arg0) {
		Set<T1> distinct0 = new HashSet<>();
		Set<T1> distinct1 = new HashSet<>();
		A result = arg0.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if(!distinct0.add(t1)) {
					continue;
				}
				if(!distinct1.add(t1)) {
					continue;
				}
				arg0.accumulator().accept(result, t1);
			}
		}
		return arg0.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_distinct_dropWhile_collectCollector(Collection<T0> input, Predicate<T1> arg0, Collector<? super T1, A, R> arg1) {
		Set<T1> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if(!distinct0.add(t1)) {
					continue;
				}
				if(dropWhile0 && arg0.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_distinct_takeWhile_collectCollector(Collection<T0> input, Predicate<T1> arg0, Collector<? super T1, A, R> arg1) {
		Set<T1> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if(!distinct0.add(t1)) {
					continue;
				}
				if(!arg0.test(t1)) {
					break;
				}
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_flatMapMemberReference_distinct_flatMapLambda_collectCollector(Collection<T0> input, Function<T1, Collection<T2>> arg0, Collector<? super T2, A, R> arg1) {
		Set<T1> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if(!distinct0.add(t1)) {
					continue;
				}
				for (T2 t2 : arg0.apply(t1)) {
					arg1.accumulator().accept(result, t2);
				}
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1 extends Collection<T2>, T2, R, A> R stream_flatMapMemberReference_distinct_flatMapMemberReference_collectCollector(Collection<T0> input, Collector<? super T2, A, R> arg0) {
		Set<T1> distinct0 = new HashSet<>();
		A result = arg0.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if(!distinct0.add(t1)) {
					continue;
				}
				for (T2 t2 : t1) {
					arg0.accumulator().accept(result, t2);
				}
			}
		}
		return arg0.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_flatMapMemberReference_dropWhile_map_collectCollector(Collection<T0> input, Predicate<T1> arg0, Function<T1, T2> arg1, Collector<? super T2, A, R> arg2) {
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if(dropWhile0 && arg0.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				T2 t2 = arg1.apply(t1);
				arg2.accumulator().accept(result, t2);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_dropWhile_filter_collectCollector(Collection<T0> input, Predicate<T1> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if(dropWhile0 && arg0.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				if (!arg1.test(t1)) {
					continue;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_dropWhile_sorted_collectCollector(Collection<T0> input, Predicate<T1> arg0, Collector<? super T1, A, R> arg1) {
		boolean dropWhile0 = true;
		List<T1> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if(dropWhile0 && arg0.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_dropWhile_sortedComp_collectCollector(Collection<T0> input, Predicate<T1> arg0, Comparator<? super T1> arg1, Collector<? super T1, A, R> arg2) {
		boolean dropWhile0 = true;
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if(dropWhile0 && arg0.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_dropWhile_limit_collectCollector(Collection<T0> input, Predicate<T1> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			for (T1 t1 : t0) {
				if(dropWhile0 && arg0.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				limit0++;
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_dropWhile_skip_collectCollector(Collection<T0> input, Predicate<T1> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if(dropWhile0 && arg0.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				skip0++;
				if(skip0 <= arg1) {
					continue;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_dropWhile_distinct_collectCollector(Collection<T0> input, Predicate<T1> arg0, Collector<? super T1, A, R> arg1) {
		boolean dropWhile0 = true;
		Set<T1> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if(dropWhile0 && arg0.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				if(!distinct0.add(t1)) {
					continue;
				}
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_dropWhile_dropWhile_collectCollector(Collection<T0> input, Predicate<T1> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if(dropWhile0 && arg0.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				if(dropWhile1 && arg1.test(t1)) {
					continue;
				} else {
					dropWhile1 = false;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_dropWhile_takeWhile_collectCollector(Collection<T0> input, Predicate<T1> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if(dropWhile0 && arg0.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				if(!arg1.test(t1)) {
					break;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_flatMapMemberReference_dropWhile_flatMapLambda_collectCollector(Collection<T0> input, Predicate<T1> arg0, Function<T1, Collection<T2>> arg1, Collector<? super T2, A, R> arg2) {
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if(dropWhile0 && arg0.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				for (T2 t2 : arg1.apply(t1)) {
					arg2.accumulator().accept(result, t2);
				}
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1 extends Collection<T2>, T2, R, A> R stream_flatMapMemberReference_dropWhile_flatMapMemberReference_collectCollector(Collection<T0> input, Predicate<T1> arg0, Collector<? super T2, A, R> arg1) {
		boolean dropWhile0 = true;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if(dropWhile0 && arg0.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				for (T2 t2 : t1) {
					arg1.accumulator().accept(result, t2);
				}
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_flatMapMemberReference_takeWhile_map_collectCollector(Collection<T0> input, Predicate<T1> arg0, Function<T1, T2> arg1, Collector<? super T2, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if(!arg0.test(t1)) {
					break;
				}
				T2 t2 = arg1.apply(t1);
				arg2.accumulator().accept(result, t2);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_takeWhile_filter_collectCollector(Collection<T0> input, Predicate<T1> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if(!arg0.test(t1)) {
					break;
				}
				if (!arg1.test(t1)) {
					continue;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_takeWhile_sorted_collectCollector(Collection<T0> input, Predicate<T1> arg0, Collector<? super T1, A, R> arg1) {
		List<T1> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if(!arg0.test(t1)) {
					break;
				}
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_takeWhile_sortedComp_collectCollector(Collection<T0> input, Predicate<T1> arg0, Comparator<? super T1> arg1, Collector<? super T1, A, R> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if(!arg0.test(t1)) {
					break;
				}
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_takeWhile_limit_collectCollector(Collection<T0> input, Predicate<T1> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			for (T1 t1 : t0) {
				if(!arg0.test(t1)) {
					break;
				}
				limit0++;
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_takeWhile_skip_collectCollector(Collection<T0> input, Predicate<T1> arg0, long arg1, Collector<? super T1, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if(!arg0.test(t1)) {
					break;
				}
				skip0++;
				if(skip0 <= arg1) {
					continue;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_takeWhile_distinct_collectCollector(Collection<T0> input, Predicate<T1> arg0, Collector<? super T1, A, R> arg1) {
		Set<T1> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if(!arg0.test(t1)) {
					break;
				}
				if(!distinct0.add(t1)) {
					continue;
				}
				arg1.accumulator().accept(result, t1);
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_takeWhile_dropWhile_collectCollector(Collection<T0> input, Predicate<T1> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if(!arg0.test(t1)) {
					break;
				}
				if(dropWhile0 && arg1.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, R, A> R stream_flatMapMemberReference_takeWhile_takeWhile_collectCollector(Collection<T0> input, Predicate<T1> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if(!arg0.test(t1)) {
					break;
				}
				if(!arg1.test(t1)) {
					break;
				}
				arg2.accumulator().accept(result, t1);
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_flatMapMemberReference_takeWhile_flatMapLambda_collectCollector(Collection<T0> input, Predicate<T1> arg0, Function<T1, Collection<T2>> arg1, Collector<? super T2, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if(!arg0.test(t1)) {
					break;
				}
				for (T2 t2 : arg1.apply(t1)) {
					arg2.accumulator().accept(result, t2);
				}
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1 extends Collection<T2>, T2, R, A> R stream_flatMapMemberReference_takeWhile_flatMapMemberReference_collectCollector(Collection<T0> input, Predicate<T1> arg0, Collector<? super T2, A, R> arg1) {
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if(!arg0.test(t1)) {
					break;
				}
				for (T2 t2 : t1) {
					arg1.accumulator().accept(result, t2);
				}
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, T3, R, A> R stream_flatMapMemberReference_flatMapLambda_map_collectCollector(Collection<T0> input, Function<T1, Collection<T2>> arg0, Function<T2, T3> arg1, Collector<? super T3, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				for (T2 t2 : arg0.apply(t1)) {
					T3 t3 = arg1.apply(t2);
					arg2.accumulator().accept(result, t3);
				}
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_flatMapMemberReference_flatMapLambda_filter_collectCollector(Collection<T0> input, Function<T1, Collection<T2>> arg0, Predicate<T2> arg1, Collector<? super T2, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				for (T2 t2 : arg0.apply(t1)) {
					if (!arg1.test(t2)) {
						continue;
					}
					arg2.accumulator().accept(result, t2);
				}
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_flatMapMemberReference_flatMapLambda_sorted_collectCollector(Collection<T0> input, Function<T1, Collection<T2>> arg0, Collector<? super T2, A, R> arg1) {
		List<T2> sorted0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				for (T2 t2 : arg0.apply(t1)) {
					sorted0.add(t2);
				}
			}
		}
		sorted0.sort(null);
		for (T2 t2: sorted0) {
			arg1.accumulator().accept(result, t2);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_flatMapMemberReference_flatMapLambda_sortedComp_collectCollector(Collection<T0> input, Function<T1, Collection<T2>> arg0, Comparator<? super T2> arg1, Collector<? super T2, A, R> arg2) {
		List<T2> sortedComp0 = new ArrayList<>();
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				for (T2 t2 : arg0.apply(t1)) {
					sortedComp0.add(t2);
				}
			}
		}
		sortedComp0.sort(arg1);
		for (T2 t2: sortedComp0) {
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_flatMapMemberReference_flatMapLambda_limit_collectCollector(Collection<T0> input, Function<T1, Collection<T2>> arg0, long arg1, Collector<? super T2, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			for (T1 t1 : t0) {
				for (T2 t2 : arg0.apply(t1)) {
					limit0++;
					arg2.accumulator().accept(result, t2);
				}
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_flatMapMemberReference_flatMapLambda_skip_collectCollector(Collection<T0> input, Function<T1, Collection<T2>> arg0, long arg1, Collector<? super T2, A, R> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				for (T2 t2 : arg0.apply(t1)) {
					skip0++;
					if(skip0 <= arg1) {
						continue;
					}
					arg2.accumulator().accept(result, t2);
				}
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_flatMapMemberReference_flatMapLambda_distinct_collectCollector(Collection<T0> input, Function<T1, Collection<T2>> arg0, Collector<? super T2, A, R> arg1) {
		Set<T2> distinct0 = new HashSet<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				for (T2 t2 : arg0.apply(t1)) {
					if(!distinct0.add(t2)) {
						continue;
					}
					arg1.accumulator().accept(result, t2);
				}
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_flatMapMemberReference_flatMapLambda_dropWhile_collectCollector(Collection<T0> input, Function<T1, Collection<T2>> arg0, Predicate<T2> arg1, Collector<? super T2, A, R> arg2) {
		boolean dropWhile0 = true;
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				for (T2 t2 : arg0.apply(t1)) {
					if(dropWhile0 && arg1.test(t2)) {
						continue;
					} else {
						dropWhile0 = false;
					}
					arg2.accumulator().accept(result, t2);
				}
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, R, A> R stream_flatMapMemberReference_flatMapLambda_takeWhile_collectCollector(Collection<T0> input, Function<T1, Collection<T2>> arg0, Predicate<T2> arg1, Collector<? super T2, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				for (T2 t2 : arg0.apply(t1)) {
					if(!arg1.test(t2)) {
						break;
					}
					arg2.accumulator().accept(result, t2);
				}
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2, T3, R, A> R stream_flatMapMemberReference_flatMapLambda_flatMapLambda_collectCollector(Collection<T0> input, Function<T1, Collection<T2>> arg0, Function<T2, Collection<T3>> arg1, Collector<? super T3, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				for (T2 t2 : arg0.apply(t1)) {
					for (T3 t3 : arg1.apply(t2)) {
						arg2.accumulator().accept(result, t3);
					}
				}
			}
		}
		return arg2.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1, T2 extends Collection<T3>, T3, R, A> R stream_flatMapMemberReference_flatMapLambda_flatMapMemberReference_collectCollector(Collection<T0> input, Function<T1, Collection<T2>> arg0, Collector<? super T3, A, R> arg1) {
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				for (T2 t2 : arg0.apply(t1)) {
					for (T3 t3 : t2) {
						arg1.accumulator().accept(result, t3);
					}
				}
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1 extends Collection<T2>, T2, T3, R, A> R stream_flatMapMemberReference_flatMapMemberReference_map_collectCollector(Collection<T0> input, Function<T2, T3> arg0, Collector<? super T3, A, R> arg1) {
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				for (T2 t2 : t1) {
					T3 t3 = arg0.apply(t2);
					arg1.accumulator().accept(result, t3);
				}
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1 extends Collection<T2>, T2, R, A> R stream_flatMapMemberReference_flatMapMemberReference_filter_collectCollector(Collection<T0> input, Predicate<T2> arg0, Collector<? super T2, A, R> arg1) {
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				for (T2 t2 : t1) {
					if (!arg0.test(t2)) {
						continue;
					}
					arg1.accumulator().accept(result, t2);
				}
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1 extends Collection<T2>, T2, R, A> R stream_flatMapMemberReference_flatMapMemberReference_sorted_collectCollector(Collection<T0> input, Collector<? super T2, A, R> arg0) {
		List<T2> sorted0 = new ArrayList<>();
		A result = arg0.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				for (T2 t2 : t1) {
					sorted0.add(t2);
				}
			}
		}
		sorted0.sort(null);
		for (T2 t2: sorted0) {
			arg0.accumulator().accept(result, t2);
		}
		return arg0.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1 extends Collection<T2>, T2, R, A> R stream_flatMapMemberReference_flatMapMemberReference_sortedComp_collectCollector(Collection<T0> input, Comparator<? super T2> arg0, Collector<? super T2, A, R> arg1) {
		List<T2> sortedComp0 = new ArrayList<>();
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				for (T2 t2 : t1) {
					sortedComp0.add(t2);
				}
			}
		}
		sortedComp0.sort(arg0);
		for (T2 t2: sortedComp0) {
			arg1.accumulator().accept(result, t2);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1 extends Collection<T2>, T2, R, A> R stream_flatMapMemberReference_flatMapMemberReference_limit_collectCollector(Collection<T0> input, long arg0, Collector<? super T2, A, R> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			for (T1 t1 : t0) {
				for (T2 t2 : t1) {
					limit0++;
					arg1.accumulator().accept(result, t2);
				}
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1 extends Collection<T2>, T2, R, A> R stream_flatMapMemberReference_flatMapMemberReference_skip_collectCollector(Collection<T0> input, long arg0, Collector<? super T2, A, R> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				for (T2 t2 : t1) {
					skip0++;
					if(skip0 <= arg0) {
						continue;
					}
					arg1.accumulator().accept(result, t2);
				}
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1 extends Collection<T2>, T2, R, A> R stream_flatMapMemberReference_flatMapMemberReference_distinct_collectCollector(Collection<T0> input, Collector<? super T2, A, R> arg0) {
		Set<T2> distinct0 = new HashSet<>();
		A result = arg0.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				for (T2 t2 : t1) {
					if(!distinct0.add(t2)) {
						continue;
					}
					arg0.accumulator().accept(result, t2);
				}
			}
		}
		return arg0.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1 extends Collection<T2>, T2, R, A> R stream_flatMapMemberReference_flatMapMemberReference_dropWhile_collectCollector(Collection<T0> input, Predicate<T2> arg0, Collector<? super T2, A, R> arg1) {
		boolean dropWhile0 = true;
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				for (T2 t2 : t1) {
					if(dropWhile0 && arg0.test(t2)) {
						continue;
					} else {
						dropWhile0 = false;
					}
					arg1.accumulator().accept(result, t2);
				}
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1 extends Collection<T2>, T2, R, A> R stream_flatMapMemberReference_flatMapMemberReference_takeWhile_collectCollector(Collection<T0> input, Predicate<T2> arg0, Collector<? super T2, A, R> arg1) {
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				for (T2 t2 : t1) {
					if(!arg0.test(t2)) {
						break;
					}
					arg1.accumulator().accept(result, t2);
				}
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1 extends Collection<T2>, T2, T3, R, A> R stream_flatMapMemberReference_flatMapMemberReference_flatMapLambda_collectCollector(Collection<T0> input, Function<T2, Collection<T3>> arg0, Collector<? super T3, A, R> arg1) {
		A result = arg1.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				for (T2 t2 : t1) {
					for (T3 t3 : arg0.apply(t2)) {
						arg1.accumulator().accept(result, t3);
					}
				}
			}
		}
		return arg1.finisher().apply(result);
	}

	public static <T0 extends Collection<T1>, T1 extends Collection<T2>, T2 extends Collection<T3>, T3, R, A> R stream_flatMapMemberReference_flatMapMemberReference_flatMapMemberReference_collectCollector(Collection<T0> input, Collector<? super T3, A, R> arg0) {
		A result = arg0.supplier().get();
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				for (T2 t2 : t1) {
					for (T3 t3 : t2) {
						arg0.accumulator().accept(result, t3);
					}
				}
			}
		}
		return arg0.finisher().apply(result);
	}


}
