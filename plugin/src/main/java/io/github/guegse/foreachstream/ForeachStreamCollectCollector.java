package io.github.guegse.foreachstream;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class ForeachStreamCollectCollector {

	public static <T0, A, R> R stream_collectCollector(Collection<T0> input, Collector<? super T0, A, R> arg0) {
		A result = arg0.supplier().get();
		for (T0 t0 : input) {
			arg0.accumulator().accept(result, t0);
		}
		return arg0.finisher().apply(result);
	}

	public static <T0, T1, A, R> R stream_map_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Collector<? super T1, A, R> arg1) {
		A result = arg1.supplier().get();
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			arg1.accumulator().accept(result, t1);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, A, R> R stream_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Collector<? super T0, A, R> arg1) {
		A result = arg1.supplier().get();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			arg1.accumulator().accept(result, t0);
		}
		return arg1.finisher().apply(result);
	}

	public static <T0, T1, T2, A, R> R stream_map_map_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Function<T1, T2> arg1, Collector<? super T2, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			T2 t2 = arg1.apply(t1);
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, A, R> R stream_map_filter_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Collector<? super T1, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, A, R> R stream_filter_map_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Collector<? super T1, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			arg2.accumulator().accept(result, t1);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, A, R> R stream_filter_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Collector<? super T0, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0 : input) {
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

	public static <T0, T2, A, R> R stream_mapToInt_mapToObj_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, IntFunction<T2> arg1, Collector<? super T2, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			T2 t2 = arg1.apply(t1);
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, A, R> R stream_mapToInt_boxed_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, Collector<? super Integer, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			Integer t2 = t1;
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T2, A, R> R stream_mapToLong_mapToObj_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, LongFunction<T2> arg1, Collector<? super T2, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			T2 t2 = arg1.apply(t1);
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, A, R> R stream_mapToLong_boxed_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, Collector<? super Long, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			Long t2 = t1;
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T2, A, R> R stream_mapToDouble_mapToObj_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleFunction<T2> arg1, Collector<? super T2, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			T2 t2 = arg1.apply(t1);
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, A, R> R stream_mapToDouble_boxed_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, Collector<? super Double, A, R> arg2) {
		A result = arg2.supplier().get();
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			Double t2 = t1;
			arg2.accumulator().accept(result, t2);
		}
		return arg2.finisher().apply(result);
	}

	public static <T0, T1, T2, T3, A, R> R stream_map_map_map_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Function<T1, T2> arg1, Function<T2, T3> arg2, Collector<? super T3, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			T2 t2 = arg1.apply(t1);
			T3 t3 = arg2.apply(t2);
			arg3.accumulator().accept(result, t3);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, A, R> R stream_map_map_filter_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Function<T1, T2> arg1, Predicate<T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			T2 t2 = arg1.apply(t1);
			if (!arg2.test(t2)) {
				continue;
			}
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, A, R> R stream_map_filter_map_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Function<T1, T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, A, R> R stream_map_filter_filter_collectCollector(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
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

	public static <T0, T1, T3, A, R> R stream_map_mapToInt_mapToObj_collectCollector(Collection<T0> input, Function<T0, T1> arg0, ToIntFunction<T1> arg1, IntFunction<T3> arg2, Collector<? super T3, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			int t2 = arg1.applyAsInt(t1);
			T3 t3 = arg2.apply(t2);
			arg3.accumulator().accept(result, t3);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, A, R> R stream_map_mapToInt_boxed_collectCollector(Collection<T0> input, Function<T0, T1> arg0, ToIntFunction<T1> arg1, Collector<? super Integer, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			int t2 = arg1.applyAsInt(t1);
			Integer t3 = t2;
			arg3.accumulator().accept(result, t3);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T3, A, R> R stream_map_mapToLong_mapToObj_collectCollector(Collection<T0> input, Function<T0, T1> arg0, ToLongFunction<T1> arg1, LongFunction<T3> arg2, Collector<? super T3, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			long t2 = arg1.applyAsLong(t1);
			T3 t3 = arg2.apply(t2);
			arg3.accumulator().accept(result, t3);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, A, R> R stream_map_mapToLong_boxed_collectCollector(Collection<T0> input, Function<T0, T1> arg0, ToLongFunction<T1> arg1, Collector<? super Long, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			long t2 = arg1.applyAsLong(t1);
			Long t3 = t2;
			arg3.accumulator().accept(result, t3);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T3, A, R> R stream_map_mapToDouble_mapToObj_collectCollector(Collection<T0> input, Function<T0, T1> arg0, ToDoubleFunction<T1> arg1, DoubleFunction<T3> arg2, Collector<? super T3, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			double t2 = arg1.applyAsDouble(t1);
			T3 t3 = arg2.apply(t2);
			arg3.accumulator().accept(result, t3);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, A, R> R stream_map_mapToDouble_boxed_collectCollector(Collection<T0> input, Function<T0, T1> arg0, ToDoubleFunction<T1> arg1, Collector<? super Double, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			double t2 = arg1.applyAsDouble(t1);
			Double t3 = t2;
			arg3.accumulator().accept(result, t3);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, T2, A, R> R stream_filter_map_map_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Function<T1, T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T1, A, R> R stream_filter_map_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Predicate<T1> arg2, Collector<? super T1, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
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

	public static <T0, T1, A, R> R stream_filter_filter_map_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Function<T0, T1> arg2, Collector<? super T1, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
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

	public static <T0, A, R> R stream_filter_filter_filter_collectCollector(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2, Collector<? super T0, A, R> arg3) {
		A result = arg3.supplier().get();
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
			arg3.accumulator().accept(result, t0);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T2, A, R> R stream_filter_mapToInt_mapToObj_collectCollector(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1, IntFunction<T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, A, R> R stream_filter_mapToInt_boxed_collectCollector(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1, Collector<? super Integer, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			Integer t2 = t1;
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T2, A, R> R stream_filter_mapToLong_mapToObj_collectCollector(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1, LongFunction<T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, A, R> R stream_filter_mapToLong_boxed_collectCollector(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1, Collector<? super Long, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			Long t2 = t1;
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T2, A, R> R stream_filter_mapToDouble_mapToObj_collectCollector(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1, DoubleFunction<T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, A, R> R stream_filter_mapToDouble_boxed_collectCollector(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1, Collector<? super Double, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			Double t2 = t1;
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T2, A, R> R stream_mapToInt_map_mapToObj_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, IntUnaryOperator arg1, IntFunction<T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			t1 = arg1.applyAsInt(t1);
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, A, R> R stream_mapToInt_map_boxed_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, IntUnaryOperator arg1, Collector<? super Integer, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			t1 = arg1.applyAsInt(t1);
			Integer t2 = t1;
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T2, A, R> R stream_mapToInt_filter_mapToObj_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1, IntFunction<T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, A, R> R stream_mapToInt_filter_boxed_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1, Collector<? super Integer, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			Integer t2 = t1;
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T3, A, R> R stream_mapToInt_mapToLong_mapToObj_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, IntToLongFunction arg1, LongFunction<T3> arg2, Collector<? super T3, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			long t2 = arg1.applyAsLong(t1);
			T3 t3 = arg2.apply(t2);
			arg3.accumulator().accept(result, t3);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, A, R> R stream_mapToInt_mapToLong_boxed_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, IntToLongFunction arg1, Collector<? super Long, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			long t2 = arg1.applyAsLong(t1);
			Long t3 = t2;
			arg3.accumulator().accept(result, t3);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T3, A, R> R stream_mapToInt_mapToDouble_mapToObj_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, IntToDoubleFunction arg1, DoubleFunction<T3> arg2, Collector<? super T3, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			double t2 = arg1.applyAsDouble(t1);
			T3 t3 = arg2.apply(t2);
			arg3.accumulator().accept(result, t3);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, A, R> R stream_mapToInt_mapToDouble_boxed_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, IntToDoubleFunction arg1, Collector<? super Double, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			double t2 = arg1.applyAsDouble(t1);
			Double t3 = t2;
			arg3.accumulator().accept(result, t3);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T2, T3, A, R> R stream_mapToInt_mapToObj_map_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, IntFunction<T2> arg1, Function<T2, T3> arg2, Collector<? super T3, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			T2 t2 = arg1.apply(t1);
			T3 t3 = arg2.apply(t2);
			arg3.accumulator().accept(result, t3);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T2, A, R> R stream_mapToInt_mapToObj_filter_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, IntFunction<T2> arg1, Predicate<T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			T2 t2 = arg1.apply(t1);
			if (!arg2.test(t2)) {
				continue;
			}
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T3, A, R> R stream_mapToInt_boxed_map_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, Function<Integer, T3> arg2, Collector<? super T3, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			Integer t2 = t1;
			T3 t3 = arg2.apply(t2);
			arg3.accumulator().accept(result, t3);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, A, R> R stream_mapToInt_boxed_filter_collectCollector(Collection<T0> input, ToIntFunction<T0> arg0, Predicate<Integer> arg2, Collector<? super Integer, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			Integer t2 = t1;
			if (!arg2.test(t2)) {
				continue;
			}
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T2, A, R> R stream_mapToLong_map_mapToObj_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, LongUnaryOperator arg1, LongFunction<T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			t1 = arg1.applyAsLong(t1);
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, A, R> R stream_mapToLong_map_boxed_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, LongUnaryOperator arg1, Collector<? super Long, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			t1 = arg1.applyAsLong(t1);
			Long t2 = t1;
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T2, A, R> R stream_mapToLong_filter_mapToObj_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1, LongFunction<T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, A, R> R stream_mapToLong_filter_boxed_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1, Collector<? super Long, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			Long t2 = t1;
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T3, A, R> R stream_mapToLong_mapToInt_mapToObj_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, LongToIntFunction arg1, IntFunction<T3> arg2, Collector<? super T3, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			int t2 = arg1.applyAsInt(t1);
			T3 t3 = arg2.apply(t2);
			arg3.accumulator().accept(result, t3);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, A, R> R stream_mapToLong_mapToInt_boxed_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, LongToIntFunction arg1, Collector<? super Integer, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			int t2 = arg1.applyAsInt(t1);
			Integer t3 = t2;
			arg3.accumulator().accept(result, t3);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T3, A, R> R stream_mapToLong_mapToDouble_mapToObj_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, LongToDoubleFunction arg1, DoubleFunction<T3> arg2, Collector<? super T3, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			double t2 = arg1.applyAsDouble(t1);
			T3 t3 = arg2.apply(t2);
			arg3.accumulator().accept(result, t3);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, A, R> R stream_mapToLong_mapToDouble_boxed_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, LongToDoubleFunction arg1, Collector<? super Double, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			double t2 = arg1.applyAsDouble(t1);
			Double t3 = t2;
			arg3.accumulator().accept(result, t3);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T2, T3, A, R> R stream_mapToLong_mapToObj_map_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, LongFunction<T2> arg1, Function<T2, T3> arg2, Collector<? super T3, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			T2 t2 = arg1.apply(t1);
			T3 t3 = arg2.apply(t2);
			arg3.accumulator().accept(result, t3);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T2, A, R> R stream_mapToLong_mapToObj_filter_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, LongFunction<T2> arg1, Predicate<T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			T2 t2 = arg1.apply(t1);
			if (!arg2.test(t2)) {
				continue;
			}
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T3, A, R> R stream_mapToLong_boxed_map_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, Function<Long, T3> arg2, Collector<? super T3, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			Long t2 = t1;
			T3 t3 = arg2.apply(t2);
			arg3.accumulator().accept(result, t3);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, A, R> R stream_mapToLong_boxed_filter_collectCollector(Collection<T0> input, ToLongFunction<T0> arg0, Predicate<Long> arg2, Collector<? super Long, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			Long t2 = t1;
			if (!arg2.test(t2)) {
				continue;
			}
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T2, A, R> R stream_mapToDouble_map_mapToObj_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleUnaryOperator arg1, DoubleFunction<T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			t1 = arg1.applyAsDouble(t1);
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, A, R> R stream_mapToDouble_map_boxed_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleUnaryOperator arg1, Collector<? super Double, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			t1 = arg1.applyAsDouble(t1);
			Double t2 = t1;
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T2, A, R> R stream_mapToDouble_filter_mapToObj_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1, DoubleFunction<T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			T2 t2 = arg2.apply(t1);
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, A, R> R stream_mapToDouble_filter_boxed_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1, Collector<? super Double, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			Double t2 = t1;
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T3, A, R> R stream_mapToDouble_mapToInt_mapToObj_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToIntFunction arg1, IntFunction<T3> arg2, Collector<? super T3, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			int t2 = arg1.applyAsInt(t1);
			T3 t3 = arg2.apply(t2);
			arg3.accumulator().accept(result, t3);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, A, R> R stream_mapToDouble_mapToInt_boxed_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToIntFunction arg1, Collector<? super Integer, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			int t2 = arg1.applyAsInt(t1);
			Integer t3 = t2;
			arg3.accumulator().accept(result, t3);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T3, A, R> R stream_mapToDouble_mapToLong_mapToObj_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToLongFunction arg1, LongFunction<T3> arg2, Collector<? super T3, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			long t2 = arg1.applyAsLong(t1);
			T3 t3 = arg2.apply(t2);
			arg3.accumulator().accept(result, t3);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, A, R> R stream_mapToDouble_mapToLong_boxed_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToLongFunction arg1, Collector<? super Long, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			long t2 = arg1.applyAsLong(t1);
			Long t3 = t2;
			arg3.accumulator().accept(result, t3);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T2, T3, A, R> R stream_mapToDouble_mapToObj_map_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleFunction<T2> arg1, Function<T2, T3> arg2, Collector<? super T3, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			T2 t2 = arg1.apply(t1);
			T3 t3 = arg2.apply(t2);
			arg3.accumulator().accept(result, t3);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T2, A, R> R stream_mapToDouble_mapToObj_filter_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleFunction<T2> arg1, Predicate<T2> arg2, Collector<? super T2, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			T2 t2 = arg1.apply(t1);
			if (!arg2.test(t2)) {
				continue;
			}
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, T3, A, R> R stream_mapToDouble_boxed_map_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, Function<Double, T3> arg2, Collector<? super T3, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			Double t2 = t1;
			T3 t3 = arg2.apply(t2);
			arg3.accumulator().accept(result, t3);
		}
		return arg3.finisher().apply(result);
	}

	public static <T0, A, R> R stream_mapToDouble_boxed_filter_collectCollector(Collection<T0> input, ToDoubleFunction<T0> arg0, Predicate<Double> arg2, Collector<? super Double, A, R> arg3) {
		A result = arg3.supplier().get();
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			Double t2 = t1;
			if (!arg2.test(t2)) {
				continue;
			}
			arg3.accumulator().accept(result, t2);
		}
		return arg3.finisher().apply(result);
	}


}
