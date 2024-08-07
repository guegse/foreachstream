package io.github.guegse.foreachstream;

import java.util.*;
import java.util.function.*;

public class ForeachStreamCollectToSet {

	public static <T0> Set<T0> stream_collect_toSet(Collection<T0> input) {
		HashSet<T0> result = new HashSet<>(input.size());
		for (T0 t0 : input) {
			result.add(t0);
		}
		return result;
	}

	public static <T0, T1> Set<T1> stream_map_collect_toSet(Collection<T0> input, Function<T0, T1> arg0) {
		HashSet<T1> result = new HashSet<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			result.add(t1);
		}
		return result;
	}

	public static <T0> Set<T0> stream_filter_collect_toSet(Collection<T0> input, Predicate<T0> arg0) {
		HashSet<T0> result = new HashSet<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return result;
	}

	public static <T0, T1, T2> Set<T2> stream_map_map_collect_toSet(Collection<T0> input, Function<T0, T1> arg0, Function<T1, T2> arg1) {
		HashSet<T2> result = new HashSet<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			T2 t2 = arg1.apply(t1);
			result.add(t2);
		}
		return result;
	}

	public static <T0, T1> Set<T1> stream_map_filter_collect_toSet(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1) {
		HashSet<T1> result = new HashSet<>();
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			result.add(t1);
		}
		return result;
	}

	public static <T0, T1> Set<T1> stream_filter_map_collect_toSet(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1) {
		HashSet<T1> result = new HashSet<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			result.add(t1);
		}
		return result;
	}

	public static <T0> Set<T0> stream_filter_filter_collect_toSet(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1) {
		HashSet<T0> result = new HashSet<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return result;
	}

	public static <T0, T2> Set<T2> stream_mapToInt_mapToObj_collect_toSet(Collection<T0> input, ToIntFunction<T0> arg0, IntFunction<T2> arg1) {
		HashSet<T2> result = new HashSet<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			T2 t2 = arg1.apply(t1);
			result.add(t2);
		}
		return result;
	}

	public static <T0> Set<Integer> stream_mapToInt_boxed_collect_toSet(Collection<T0> input, ToIntFunction<T0> arg0) {
		HashSet<Integer> result = new HashSet<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			Integer t2 = t1;
			result.add(t2);
		}
		return result;
	}

	public static <T0, T2> Set<T2> stream_mapToLong_mapToObj_collect_toSet(Collection<T0> input, ToLongFunction<T0> arg0, LongFunction<T2> arg1) {
		HashSet<T2> result = new HashSet<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			T2 t2 = arg1.apply(t1);
			result.add(t2);
		}
		return result;
	}

	public static <T0> Set<Long> stream_mapToLong_boxed_collect_toSet(Collection<T0> input, ToLongFunction<T0> arg0) {
		HashSet<Long> result = new HashSet<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			Long t2 = t1;
			result.add(t2);
		}
		return result;
	}

	public static <T0, T2> Set<T2> stream_mapToDouble_mapToObj_collect_toSet(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleFunction<T2> arg1) {
		HashSet<T2> result = new HashSet<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			T2 t2 = arg1.apply(t1);
			result.add(t2);
		}
		return result;
	}

	public static <T0> Set<Double> stream_mapToDouble_boxed_collect_toSet(Collection<T0> input, ToDoubleFunction<T0> arg0) {
		HashSet<Double> result = new HashSet<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			Double t2 = t1;
			result.add(t2);
		}
		return result;
	}

	public static <T0, T1, T2, T3> Set<T3> stream_map_map_map_collect_toSet(Collection<T0> input, Function<T0, T1> arg0, Function<T1, T2> arg1, Function<T2, T3> arg2) {
		HashSet<T3> result = new HashSet<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			T2 t2 = arg1.apply(t1);
			T3 t3 = arg2.apply(t2);
			result.add(t3);
		}
		return result;
	}

	public static <T0, T1, T2> Set<T2> stream_map_map_filter_collect_toSet(Collection<T0> input, Function<T0, T1> arg0, Function<T1, T2> arg1, Predicate<T2> arg2) {
		HashSet<T2> result = new HashSet<>();
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			T2 t2 = arg1.apply(t1);
			if (!arg2.test(t2)) {
				continue;
			}
			result.add(t2);
		}
		return result;
	}

	public static <T0, T1, T2> Set<T2> stream_map_filter_map_collect_toSet(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Function<T1, T2> arg2) {
		HashSet<T2> result = new HashSet<>();
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return result;
	}

	public static <T0, T1> Set<T1> stream_map_filter_filter_collect_toSet(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Predicate<T1> arg2) {
		HashSet<T1> result = new HashSet<>();
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			if (!arg2.test(t1)) {
				continue;
			}
			result.add(t1);
		}
		return result;
	}

	public static <T0, T1, T3> Set<T3> stream_map_mapToInt_mapToObj_collect_toSet(Collection<T0> input, Function<T0, T1> arg0, ToIntFunction<T1> arg1, IntFunction<T3> arg2) {
		HashSet<T3> result = new HashSet<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			int t2 = arg1.applyAsInt(t1);
			T3 t3 = arg2.apply(t2);
			result.add(t3);
		}
		return result;
	}

	public static <T0, T1> Set<Integer> stream_map_mapToInt_boxed_collect_toSet(Collection<T0> input, Function<T0, T1> arg0, ToIntFunction<T1> arg1) {
		HashSet<Integer> result = new HashSet<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			int t2 = arg1.applyAsInt(t1);
			Integer t3 = t2;
			result.add(t3);
		}
		return result;
	}

	public static <T0, T1, T3> Set<T3> stream_map_mapToLong_mapToObj_collect_toSet(Collection<T0> input, Function<T0, T1> arg0, ToLongFunction<T1> arg1, LongFunction<T3> arg2) {
		HashSet<T3> result = new HashSet<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			long t2 = arg1.applyAsLong(t1);
			T3 t3 = arg2.apply(t2);
			result.add(t3);
		}
		return result;
	}

	public static <T0, T1> Set<Long> stream_map_mapToLong_boxed_collect_toSet(Collection<T0> input, Function<T0, T1> arg0, ToLongFunction<T1> arg1) {
		HashSet<Long> result = new HashSet<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			long t2 = arg1.applyAsLong(t1);
			Long t3 = t2;
			result.add(t3);
		}
		return result;
	}

	public static <T0, T1, T3> Set<T3> stream_map_mapToDouble_mapToObj_collect_toSet(Collection<T0> input, Function<T0, T1> arg0, ToDoubleFunction<T1> arg1, DoubleFunction<T3> arg2) {
		HashSet<T3> result = new HashSet<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			double t2 = arg1.applyAsDouble(t1);
			T3 t3 = arg2.apply(t2);
			result.add(t3);
		}
		return result;
	}

	public static <T0, T1> Set<Double> stream_map_mapToDouble_boxed_collect_toSet(Collection<T0> input, Function<T0, T1> arg0, ToDoubleFunction<T1> arg1) {
		HashSet<Double> result = new HashSet<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			double t2 = arg1.applyAsDouble(t1);
			Double t3 = t2;
			result.add(t3);
		}
		return result;
	}

	public static <T0, T1, T2> Set<T2> stream_filter_map_map_collect_toSet(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Function<T1, T2> arg2) {
		HashSet<T2> result = new HashSet<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return result;
	}

	public static <T0, T1> Set<T1> stream_filter_map_filter_collect_toSet(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Predicate<T1> arg2) {
		HashSet<T1> result = new HashSet<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			result.add(t1);
		}
		return result;
	}

	public static <T0, T1> Set<T1> stream_filter_filter_map_collect_toSet(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Function<T0, T1> arg2) {
		HashSet<T1> result = new HashSet<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return result;
	}

	public static <T0> Set<T0> stream_filter_filter_filter_collect_toSet(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		HashSet<T0> result = new HashSet<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return result;
	}

	public static <T0, T2> Set<T2> stream_filter_mapToInt_mapToObj_collect_toSet(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1, IntFunction<T2> arg2) {
		HashSet<T2> result = new HashSet<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return result;
	}

	public static <T0> Set<Integer> stream_filter_mapToInt_boxed_collect_toSet(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1) {
		HashSet<Integer> result = new HashSet<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			Integer t2 = t1;
			result.add(t2);
		}
		return result;
	}

	public static <T0, T2> Set<T2> stream_filter_mapToLong_mapToObj_collect_toSet(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1, LongFunction<T2> arg2) {
		HashSet<T2> result = new HashSet<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return result;
	}

	public static <T0> Set<Long> stream_filter_mapToLong_boxed_collect_toSet(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1) {
		HashSet<Long> result = new HashSet<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			Long t2 = t1;
			result.add(t2);
		}
		return result;
	}

	public static <T0, T2> Set<T2> stream_filter_mapToDouble_mapToObj_collect_toSet(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1, DoubleFunction<T2> arg2) {
		HashSet<T2> result = new HashSet<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return result;
	}

	public static <T0> Set<Double> stream_filter_mapToDouble_boxed_collect_toSet(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1) {
		HashSet<Double> result = new HashSet<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			Double t2 = t1;
			result.add(t2);
		}
		return result;
	}

	public static <T0, T2> Set<T2> stream_mapToInt_map_mapToObj_collect_toSet(Collection<T0> input, ToIntFunction<T0> arg0, IntUnaryOperator arg1, IntFunction<T2> arg2) {
		HashSet<T2> result = new HashSet<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			t1 = arg1.applyAsInt(t1);
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return result;
	}

	public static <T0> Set<Integer> stream_mapToInt_map_boxed_collect_toSet(Collection<T0> input, ToIntFunction<T0> arg0, IntUnaryOperator arg1) {
		HashSet<Integer> result = new HashSet<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			t1 = arg1.applyAsInt(t1);
			Integer t2 = t1;
			result.add(t2);
		}
		return result;
	}

	public static <T0, T2> Set<T2> stream_mapToInt_filter_mapToObj_collect_toSet(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1, IntFunction<T2> arg2) {
		HashSet<T2> result = new HashSet<>();
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return result;
	}

	public static <T0> Set<Integer> stream_mapToInt_filter_boxed_collect_toSet(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1) {
		HashSet<Integer> result = new HashSet<>();
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			Integer t2 = t1;
			result.add(t2);
		}
		return result;
	}

	public static <T0, T3> Set<T3> stream_mapToInt_mapToLong_mapToObj_collect_toSet(Collection<T0> input, ToIntFunction<T0> arg0, IntToLongFunction arg1, LongFunction<T3> arg2) {
		HashSet<T3> result = new HashSet<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			long t2 = arg1.applyAsLong(t1);
			T3 t3 = arg2.apply(t2);
			result.add(t3);
		}
		return result;
	}

	public static <T0> Set<Long> stream_mapToInt_mapToLong_boxed_collect_toSet(Collection<T0> input, ToIntFunction<T0> arg0, IntToLongFunction arg1) {
		HashSet<Long> result = new HashSet<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			long t2 = arg1.applyAsLong(t1);
			Long t3 = t2;
			result.add(t3);
		}
		return result;
	}

	public static <T0, T3> Set<T3> stream_mapToInt_mapToDouble_mapToObj_collect_toSet(Collection<T0> input, ToIntFunction<T0> arg0, IntToDoubleFunction arg1, DoubleFunction<T3> arg2) {
		HashSet<T3> result = new HashSet<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			double t2 = arg1.applyAsDouble(t1);
			T3 t3 = arg2.apply(t2);
			result.add(t3);
		}
		return result;
	}

	public static <T0> Set<Double> stream_mapToInt_mapToDouble_boxed_collect_toSet(Collection<T0> input, ToIntFunction<T0> arg0, IntToDoubleFunction arg1) {
		HashSet<Double> result = new HashSet<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			double t2 = arg1.applyAsDouble(t1);
			Double t3 = t2;
			result.add(t3);
		}
		return result;
	}

	public static <T0, T2, T3> Set<T3> stream_mapToInt_mapToObj_map_collect_toSet(Collection<T0> input, ToIntFunction<T0> arg0, IntFunction<T2> arg1, Function<T2, T3> arg2) {
		HashSet<T3> result = new HashSet<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			T2 t2 = arg1.apply(t1);
			T3 t3 = arg2.apply(t2);
			result.add(t3);
		}
		return result;
	}

	public static <T0, T2> Set<T2> stream_mapToInt_mapToObj_filter_collect_toSet(Collection<T0> input, ToIntFunction<T0> arg0, IntFunction<T2> arg1, Predicate<T2> arg2) {
		HashSet<T2> result = new HashSet<>();
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			T2 t2 = arg1.apply(t1);
			if (!arg2.test(t2)) {
				continue;
			}
			result.add(t2);
		}
		return result;
	}

	public static <T0, T3> Set<T3> stream_mapToInt_boxed_map_collect_toSet(Collection<T0> input, ToIntFunction<T0> arg0, Function<Integer, T3> arg2) {
		HashSet<T3> result = new HashSet<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			Integer t2 = t1;
			T3 t3 = arg2.apply(t2);
			result.add(t3);
		}
		return result;
	}

	public static <T0> Set<Integer> stream_mapToInt_boxed_filter_collect_toSet(Collection<T0> input, ToIntFunction<T0> arg0, Predicate<Integer> arg2) {
		HashSet<Integer> result = new HashSet<>();
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			Integer t2 = t1;
			if (!arg2.test(t2)) {
				continue;
			}
			result.add(t2);
		}
		return result;
	}

	public static <T0, T2> Set<T2> stream_mapToLong_map_mapToObj_collect_toSet(Collection<T0> input, ToLongFunction<T0> arg0, LongUnaryOperator arg1, LongFunction<T2> arg2) {
		HashSet<T2> result = new HashSet<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			t1 = arg1.applyAsLong(t1);
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return result;
	}

	public static <T0> Set<Long> stream_mapToLong_map_boxed_collect_toSet(Collection<T0> input, ToLongFunction<T0> arg0, LongUnaryOperator arg1) {
		HashSet<Long> result = new HashSet<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			t1 = arg1.applyAsLong(t1);
			Long t2 = t1;
			result.add(t2);
		}
		return result;
	}

	public static <T0, T2> Set<T2> stream_mapToLong_filter_mapToObj_collect_toSet(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1, LongFunction<T2> arg2) {
		HashSet<T2> result = new HashSet<>();
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return result;
	}

	public static <T0> Set<Long> stream_mapToLong_filter_boxed_collect_toSet(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1) {
		HashSet<Long> result = new HashSet<>();
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			Long t2 = t1;
			result.add(t2);
		}
		return result;
	}

	public static <T0, T3> Set<T3> stream_mapToLong_mapToInt_mapToObj_collect_toSet(Collection<T0> input, ToLongFunction<T0> arg0, LongToIntFunction arg1, IntFunction<T3> arg2) {
		HashSet<T3> result = new HashSet<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			int t2 = arg1.applyAsInt(t1);
			T3 t3 = arg2.apply(t2);
			result.add(t3);
		}
		return result;
	}

	public static <T0> Set<Integer> stream_mapToLong_mapToInt_boxed_collect_toSet(Collection<T0> input, ToLongFunction<T0> arg0, LongToIntFunction arg1) {
		HashSet<Integer> result = new HashSet<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			int t2 = arg1.applyAsInt(t1);
			Integer t3 = t2;
			result.add(t3);
		}
		return result;
	}

	public static <T0, T3> Set<T3> stream_mapToLong_mapToDouble_mapToObj_collect_toSet(Collection<T0> input, ToLongFunction<T0> arg0, LongToDoubleFunction arg1, DoubleFunction<T3> arg2) {
		HashSet<T3> result = new HashSet<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			double t2 = arg1.applyAsDouble(t1);
			T3 t3 = arg2.apply(t2);
			result.add(t3);
		}
		return result;
	}

	public static <T0> Set<Double> stream_mapToLong_mapToDouble_boxed_collect_toSet(Collection<T0> input, ToLongFunction<T0> arg0, LongToDoubleFunction arg1) {
		HashSet<Double> result = new HashSet<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			double t2 = arg1.applyAsDouble(t1);
			Double t3 = t2;
			result.add(t3);
		}
		return result;
	}

	public static <T0, T2, T3> Set<T3> stream_mapToLong_mapToObj_map_collect_toSet(Collection<T0> input, ToLongFunction<T0> arg0, LongFunction<T2> arg1, Function<T2, T3> arg2) {
		HashSet<T3> result = new HashSet<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			T2 t2 = arg1.apply(t1);
			T3 t3 = arg2.apply(t2);
			result.add(t3);
		}
		return result;
	}

	public static <T0, T2> Set<T2> stream_mapToLong_mapToObj_filter_collect_toSet(Collection<T0> input, ToLongFunction<T0> arg0, LongFunction<T2> arg1, Predicate<T2> arg2) {
		HashSet<T2> result = new HashSet<>();
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			T2 t2 = arg1.apply(t1);
			if (!arg2.test(t2)) {
				continue;
			}
			result.add(t2);
		}
		return result;
	}

	public static <T0, T3> Set<T3> stream_mapToLong_boxed_map_collect_toSet(Collection<T0> input, ToLongFunction<T0> arg0, Function<Long, T3> arg2) {
		HashSet<T3> result = new HashSet<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			Long t2 = t1;
			T3 t3 = arg2.apply(t2);
			result.add(t3);
		}
		return result;
	}

	public static <T0> Set<Long> stream_mapToLong_boxed_filter_collect_toSet(Collection<T0> input, ToLongFunction<T0> arg0, Predicate<Long> arg2) {
		HashSet<Long> result = new HashSet<>();
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			Long t2 = t1;
			if (!arg2.test(t2)) {
				continue;
			}
			result.add(t2);
		}
		return result;
	}

	public static <T0, T2> Set<T2> stream_mapToDouble_map_mapToObj_collect_toSet(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleUnaryOperator arg1, DoubleFunction<T2> arg2) {
		HashSet<T2> result = new HashSet<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			t1 = arg1.applyAsDouble(t1);
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return result;
	}

	public static <T0> Set<Double> stream_mapToDouble_map_boxed_collect_toSet(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleUnaryOperator arg1) {
		HashSet<Double> result = new HashSet<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			t1 = arg1.applyAsDouble(t1);
			Double t2 = t1;
			result.add(t2);
		}
		return result;
	}

	public static <T0, T2> Set<T2> stream_mapToDouble_filter_mapToObj_collect_toSet(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1, DoubleFunction<T2> arg2) {
		HashSet<T2> result = new HashSet<>();
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return result;
	}

	public static <T0> Set<Double> stream_mapToDouble_filter_boxed_collect_toSet(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1) {
		HashSet<Double> result = new HashSet<>();
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			Double t2 = t1;
			result.add(t2);
		}
		return result;
	}

	public static <T0, T3> Set<T3> stream_mapToDouble_mapToInt_mapToObj_collect_toSet(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToIntFunction arg1, IntFunction<T3> arg2) {
		HashSet<T3> result = new HashSet<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			int t2 = arg1.applyAsInt(t1);
			T3 t3 = arg2.apply(t2);
			result.add(t3);
		}
		return result;
	}

	public static <T0> Set<Integer> stream_mapToDouble_mapToInt_boxed_collect_toSet(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToIntFunction arg1) {
		HashSet<Integer> result = new HashSet<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			int t2 = arg1.applyAsInt(t1);
			Integer t3 = t2;
			result.add(t3);
		}
		return result;
	}

	public static <T0, T3> Set<T3> stream_mapToDouble_mapToLong_mapToObj_collect_toSet(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToLongFunction arg1, LongFunction<T3> arg2) {
		HashSet<T3> result = new HashSet<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			long t2 = arg1.applyAsLong(t1);
			T3 t3 = arg2.apply(t2);
			result.add(t3);
		}
		return result;
	}

	public static <T0> Set<Long> stream_mapToDouble_mapToLong_boxed_collect_toSet(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToLongFunction arg1) {
		HashSet<Long> result = new HashSet<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			long t2 = arg1.applyAsLong(t1);
			Long t3 = t2;
			result.add(t3);
		}
		return result;
	}

	public static <T0, T2, T3> Set<T3> stream_mapToDouble_mapToObj_map_collect_toSet(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleFunction<T2> arg1, Function<T2, T3> arg2) {
		HashSet<T3> result = new HashSet<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			T2 t2 = arg1.apply(t1);
			T3 t3 = arg2.apply(t2);
			result.add(t3);
		}
		return result;
	}

	public static <T0, T2> Set<T2> stream_mapToDouble_mapToObj_filter_collect_toSet(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleFunction<T2> arg1, Predicate<T2> arg2) {
		HashSet<T2> result = new HashSet<>();
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			T2 t2 = arg1.apply(t1);
			if (!arg2.test(t2)) {
				continue;
			}
			result.add(t2);
		}
		return result;
	}

	public static <T0, T3> Set<T3> stream_mapToDouble_boxed_map_collect_toSet(Collection<T0> input, ToDoubleFunction<T0> arg0, Function<Double, T3> arg2) {
		HashSet<T3> result = new HashSet<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			Double t2 = t1;
			T3 t3 = arg2.apply(t2);
			result.add(t3);
		}
		return result;
	}

	public static <T0> Set<Double> stream_mapToDouble_boxed_filter_collect_toSet(Collection<T0> input, ToDoubleFunction<T0> arg0, Predicate<Double> arg2) {
		HashSet<Double> result = new HashSet<>();
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			Double t2 = t1;
			if (!arg2.test(t2)) {
				continue;
			}
			result.add(t2);
		}
		return result;
	}


}
