package io.github.guegse.foreachstream;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class ForeachStreamSum {

	public static <T0> int stream_mapToInt_sum(Collection<T0> input, ToIntFunction<T0> arg0) {
		int sum = 0;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_sum(Collection<T0> input, ToLongFunction<T0> arg0) {
		long sum = 0;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_sum(Collection<T0> input, ToDoubleFunction<T0> arg0) {
		double sum = 0;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0, T1> int stream_map_mapToInt_sum(Collection<T0> input, Function<T0, T1> arg0, ToIntFunction<T1> arg1) {
		int sum = 0;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			int t2 = arg1.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> long stream_map_mapToLong_sum(Collection<T0> input, Function<T0, T1> arg0, ToLongFunction<T1> arg1) {
		long sum = 0;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			long t2 = arg1.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> double stream_map_mapToDouble_sum(Collection<T0> input, Function<T0, T1> arg0, ToDoubleFunction<T1> arg1) {
		double sum = 0;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			double t2 = arg1.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_filter_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1) {
		int sum = 0;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_filter_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1) {
		long sum = 0;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_filter_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1) {
		double sum = 0;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_map_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntUnaryOperator arg1) {
		int sum = 0;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			t1 = arg1.applyAsInt(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_filter_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1) {
		int sum = 0;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToInt_mapToLong_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntToLongFunction arg1) {
		long sum = 0;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			long t2 = arg1.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToInt_mapToDouble_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntToDoubleFunction arg1) {
		double sum = 0;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			double t2 = arg1.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_map_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongUnaryOperator arg1) {
		long sum = 0;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			t1 = arg1.applyAsLong(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_filter_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1) {
		long sum = 0;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToLong_mapToInt_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongToIntFunction arg1) {
		int sum = 0;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			int t2 = arg1.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToLong_mapToDouble_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongToDoubleFunction arg1) {
		double sum = 0;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			double t2 = arg1.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_map_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleUnaryOperator arg1) {
		double sum = 0;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			t1 = arg1.applyAsDouble(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_filter_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1) {
		double sum = 0;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToDouble_mapToInt_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToIntFunction arg1) {
		int sum = 0;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			int t2 = arg1.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_mapToDouble_mapToLong_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToLongFunction arg1) {
		long sum = 0;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			long t2 = arg1.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_sorted_mapToInt_sum(Collection<T0> input, ToIntFunction<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			int t1 = arg1.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_sorted_mapToLong_sum(Collection<T0> input, ToLongFunction<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			long t1 = arg1.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_sorted_mapToDouble_sum(Collection<T0> input, ToDoubleFunction<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			double t1 = arg1.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_sortedComp_mapToInt_sum(Collection<T0> input, Comparator<? super T0> arg0, ToIntFunction<T0> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			int t1 = arg1.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_sortedComp_mapToLong_sum(Collection<T0> input, Comparator<? super T0> arg0, ToLongFunction<T0> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			long t1 = arg1.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_sortedComp_mapToDouble_sum(Collection<T0> input, Comparator<? super T0> arg0, ToDoubleFunction<T0> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			double t1 = arg1.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0, T1, T2> int stream_map_map_mapToInt_sum(Collection<T0> input, Function<T0, T1> arg0, Function<T1, T2> arg1, ToIntFunction<T2> arg2) {
		int sum = 0;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			T2 t2 = arg1.apply(t1);
			int t3 = arg2.applyAsInt(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0, T1, T2> long stream_map_map_mapToLong_sum(Collection<T0> input, Function<T0, T1> arg0, Function<T1, T2> arg1, ToLongFunction<T2> arg2) {
		long sum = 0;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			T2 t2 = arg1.apply(t1);
			long t3 = arg2.applyAsLong(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0, T1, T2> double stream_map_map_mapToDouble_sum(Collection<T0> input, Function<T0, T1> arg0, Function<T1, T2> arg1, ToDoubleFunction<T2> arg2) {
		double sum = 0;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			T2 t2 = arg1.apply(t1);
			double t3 = arg2.applyAsDouble(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0, T1> int stream_map_filter_mapToInt_sum(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, ToIntFunction<T1> arg2) {
		int sum = 0;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			int t2 = arg2.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> long stream_map_filter_mapToLong_sum(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, ToLongFunction<T1> arg2) {
		long sum = 0;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			long t2 = arg2.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> double stream_map_filter_mapToDouble_sum(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, ToDoubleFunction<T1> arg2) {
		double sum = 0;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> int stream_map_mapToInt_map_sum(Collection<T0> input, Function<T0, T1> arg0, ToIntFunction<T1> arg1, IntUnaryOperator arg2) {
		int sum = 0;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			int t2 = arg1.applyAsInt(t1);
			t2 = arg2.applyAsInt(t2);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> int stream_map_mapToInt_filter_sum(Collection<T0> input, Function<T0, T1> arg0, ToIntFunction<T1> arg1, IntPredicate arg2) {
		int sum = 0;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			int t2 = arg1.applyAsInt(t1);
			if (!arg2.test(t2)) {
				continue;
			}
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> long stream_map_mapToInt_mapToLong_sum(Collection<T0> input, Function<T0, T1> arg0, ToIntFunction<T1> arg1, IntToLongFunction arg2) {
		long sum = 0;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			int t2 = arg1.applyAsInt(t1);
			long t3 = arg2.applyAsLong(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0, T1> double stream_map_mapToInt_mapToDouble_sum(Collection<T0> input, Function<T0, T1> arg0, ToIntFunction<T1> arg1, IntToDoubleFunction arg2) {
		double sum = 0;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			int t2 = arg1.applyAsInt(t1);
			double t3 = arg2.applyAsDouble(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0, T1> long stream_map_mapToLong_map_sum(Collection<T0> input, Function<T0, T1> arg0, ToLongFunction<T1> arg1, LongUnaryOperator arg2) {
		long sum = 0;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			long t2 = arg1.applyAsLong(t1);
			t2 = arg2.applyAsLong(t2);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> long stream_map_mapToLong_filter_sum(Collection<T0> input, Function<T0, T1> arg0, ToLongFunction<T1> arg1, LongPredicate arg2) {
		long sum = 0;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			long t2 = arg1.applyAsLong(t1);
			if (!arg2.test(t2)) {
				continue;
			}
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> int stream_map_mapToLong_mapToInt_sum(Collection<T0> input, Function<T0, T1> arg0, ToLongFunction<T1> arg1, LongToIntFunction arg2) {
		int sum = 0;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			long t2 = arg1.applyAsLong(t1);
			int t3 = arg2.applyAsInt(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0, T1> double stream_map_mapToLong_mapToDouble_sum(Collection<T0> input, Function<T0, T1> arg0, ToLongFunction<T1> arg1, LongToDoubleFunction arg2) {
		double sum = 0;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			long t2 = arg1.applyAsLong(t1);
			double t3 = arg2.applyAsDouble(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0, T1> double stream_map_mapToDouble_map_sum(Collection<T0> input, Function<T0, T1> arg0, ToDoubleFunction<T1> arg1, DoubleUnaryOperator arg2) {
		double sum = 0;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			double t2 = arg1.applyAsDouble(t1);
			t2 = arg2.applyAsDouble(t2);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> double stream_map_mapToDouble_filter_sum(Collection<T0> input, Function<T0, T1> arg0, ToDoubleFunction<T1> arg1, DoublePredicate arg2) {
		double sum = 0;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			double t2 = arg1.applyAsDouble(t1);
			if (!arg2.test(t2)) {
				continue;
			}
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> int stream_map_mapToDouble_mapToInt_sum(Collection<T0> input, Function<T0, T1> arg0, ToDoubleFunction<T1> arg1, DoubleToIntFunction arg2) {
		int sum = 0;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			double t2 = arg1.applyAsDouble(t1);
			int t3 = arg2.applyAsInt(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0, T1> long stream_map_mapToDouble_mapToLong_sum(Collection<T0> input, Function<T0, T1> arg0, ToDoubleFunction<T1> arg1, DoubleToLongFunction arg2) {
		long sum = 0;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			double t2 = arg1.applyAsDouble(t1);
			long t3 = arg2.applyAsLong(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0, T1> int stream_map_sorted_mapToInt_sum(Collection<T0> input, Function<T0, T1> arg0, ToIntFunction<T1> arg2) {
		List<T1> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			int t2 = arg2.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> long stream_map_sorted_mapToLong_sum(Collection<T0> input, Function<T0, T1> arg0, ToLongFunction<T1> arg2) {
		List<T1> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			long t2 = arg2.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> double stream_map_sorted_mapToDouble_sum(Collection<T0> input, Function<T0, T1> arg0, ToDoubleFunction<T1> arg2) {
		List<T1> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> int stream_map_sortedComp_mapToInt_sum(Collection<T0> input, Function<T0, T1> arg0, Comparator<? super T1> arg1, ToIntFunction<T1> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			int t2 = arg2.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> long stream_map_sortedComp_mapToLong_sum(Collection<T0> input, Function<T0, T1> arg0, Comparator<? super T1> arg1, ToLongFunction<T1> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			long t2 = arg2.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> double stream_map_sortedComp_mapToDouble_sum(Collection<T0> input, Function<T0, T1> arg0, Comparator<? super T1> arg1, ToDoubleFunction<T1> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> int stream_filter_map_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, ToIntFunction<T1> arg2) {
		int sum = 0;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			int t2 = arg2.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> long stream_filter_map_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, ToLongFunction<T1> arg2) {
		long sum = 0;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			long t2 = arg2.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> double stream_filter_map_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, ToDoubleFunction<T1> arg2) {
		double sum = 0;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_filter_filter_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, ToIntFunction<T0> arg2) {
		int sum = 0;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			int t1 = arg2.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_filter_filter_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, ToLongFunction<T0> arg2) {
		long sum = 0;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			long t1 = arg2.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_filter_filter_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, ToDoubleFunction<T0> arg2) {
		double sum = 0;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			double t1 = arg2.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_filter_mapToInt_map_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1, IntUnaryOperator arg2) {
		int sum = 0;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			t1 = arg2.applyAsInt(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_filter_mapToInt_filter_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1, IntPredicate arg2) {
		int sum = 0;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_filter_mapToInt_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1, IntToLongFunction arg2) {
		long sum = 0;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			long t2 = arg2.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_filter_mapToInt_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1, IntToDoubleFunction arg2) {
		double sum = 0;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_filter_mapToLong_map_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1, LongUnaryOperator arg2) {
		long sum = 0;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			t1 = arg2.applyAsLong(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_filter_mapToLong_filter_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1, LongPredicate arg2) {
		long sum = 0;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_filter_mapToLong_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1, LongToIntFunction arg2) {
		int sum = 0;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			int t2 = arg2.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_filter_mapToLong_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1, LongToDoubleFunction arg2) {
		double sum = 0;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_filter_mapToDouble_map_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1, DoubleUnaryOperator arg2) {
		double sum = 0;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			t1 = arg2.applyAsDouble(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_filter_mapToDouble_filter_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1, DoublePredicate arg2) {
		double sum = 0;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_filter_mapToDouble_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1, DoubleToIntFunction arg2) {
		int sum = 0;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			int t2 = arg2.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_filter_mapToDouble_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1, DoubleToLongFunction arg2) {
		long sum = 0;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			long t2 = arg2.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_filter_sorted_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			int t1 = arg2.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_filter_sorted_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			long t1 = arg2.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_filter_sorted_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			double t1 = arg2.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_filter_sortedComp_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, ToIntFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			int t1 = arg2.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_filter_sortedComp_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, ToLongFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			long t1 = arg2.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_filter_sortedComp_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, ToDoubleFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			double t1 = arg2.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_map_map_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntUnaryOperator arg1, IntUnaryOperator arg2) {
		int sum = 0;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			t1 = arg1.applyAsInt(t1);
			t1 = arg2.applyAsInt(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_map_filter_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntUnaryOperator arg1, IntPredicate arg2) {
		int sum = 0;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			t1 = arg1.applyAsInt(t1);
			if (!arg2.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToInt_map_mapToLong_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntUnaryOperator arg1, IntToLongFunction arg2) {
		long sum = 0;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			t1 = arg1.applyAsInt(t1);
			long t2 = arg2.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToInt_map_mapToDouble_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntUnaryOperator arg1, IntToDoubleFunction arg2) {
		double sum = 0;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			t1 = arg1.applyAsInt(t1);
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_filter_map_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1, IntUnaryOperator arg2) {
		int sum = 0;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			t1 = arg2.applyAsInt(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_filter_filter_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1, IntPredicate arg2) {
		int sum = 0;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			if (!arg2.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToInt_filter_mapToLong_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1, IntToLongFunction arg2) {
		long sum = 0;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			long t2 = arg2.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToInt_filter_mapToDouble_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1, IntToDoubleFunction arg2) {
		double sum = 0;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_mapToInt_mapToLong_map_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntToLongFunction arg1, LongUnaryOperator arg2) {
		long sum = 0;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			long t2 = arg1.applyAsLong(t1);
			t2 = arg2.applyAsLong(t2);
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_mapToInt_mapToLong_filter_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntToLongFunction arg1, LongPredicate arg2) {
		long sum = 0;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			long t2 = arg1.applyAsLong(t1);
			if (!arg2.test(t2)) {
				continue;
			}
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_mapToLong_mapToInt_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntToLongFunction arg1, LongToIntFunction arg2) {
		int sum = 0;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			long t2 = arg1.applyAsLong(t1);
			int t3 = arg2.applyAsInt(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0> double stream_mapToInt_mapToLong_mapToDouble_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntToLongFunction arg1, LongToDoubleFunction arg2) {
		double sum = 0;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			long t2 = arg1.applyAsLong(t1);
			double t3 = arg2.applyAsDouble(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0> double stream_mapToInt_mapToDouble_map_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntToDoubleFunction arg1, DoubleUnaryOperator arg2) {
		double sum = 0;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			double t2 = arg1.applyAsDouble(t1);
			t2 = arg2.applyAsDouble(t2);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToInt_mapToDouble_filter_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntToDoubleFunction arg1, DoublePredicate arg2) {
		double sum = 0;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			double t2 = arg1.applyAsDouble(t1);
			if (!arg2.test(t2)) {
				continue;
			}
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_mapToDouble_mapToInt_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntToDoubleFunction arg1, DoubleToIntFunction arg2) {
		int sum = 0;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			double t2 = arg1.applyAsDouble(t1);
			int t3 = arg2.applyAsInt(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0> long stream_mapToInt_mapToDouble_mapToLong_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntToDoubleFunction arg1, DoubleToLongFunction arg2) {
		long sum = 0;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			double t2 = arg1.applyAsDouble(t1);
			long t3 = arg2.applyAsLong(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0, T2> int stream_mapToInt_mapToObj_mapToInt_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntFunction<T2> arg1, ToIntFunction<T2> arg2) {
		int sum = 0;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			T2 t2 = arg1.apply(t1);
			int t3 = arg2.applyAsInt(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0, T2> long stream_mapToInt_mapToObj_mapToLong_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntFunction<T2> arg1, ToLongFunction<T2> arg2) {
		long sum = 0;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			T2 t2 = arg1.apply(t1);
			long t3 = arg2.applyAsLong(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0, T2> double stream_mapToInt_mapToObj_mapToDouble_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntFunction<T2> arg1, ToDoubleFunction<T2> arg2) {
		double sum = 0;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			T2 t2 = arg1.apply(t1);
			double t3 = arg2.applyAsDouble(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_boxed_mapToInt_sum(Collection<T0> input, ToIntFunction<T0> arg0, ToIntFunction<Integer> arg2) {
		int sum = 0;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			Integer t2 = t1;
			int t3 = arg2.applyAsInt(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0> long stream_mapToInt_boxed_mapToLong_sum(Collection<T0> input, ToIntFunction<T0> arg0, ToLongFunction<Integer> arg2) {
		long sum = 0;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			Integer t2 = t1;
			long t3 = arg2.applyAsLong(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0> double stream_mapToInt_boxed_mapToDouble_sum(Collection<T0> input, ToIntFunction<T0> arg0, ToDoubleFunction<Integer> arg2) {
		double sum = 0;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			Integer t2 = t1;
			double t3 = arg2.applyAsDouble(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_map_map_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongUnaryOperator arg1, LongUnaryOperator arg2) {
		long sum = 0;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			t1 = arg1.applyAsLong(t1);
			t1 = arg2.applyAsLong(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_map_filter_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongUnaryOperator arg1, LongPredicate arg2) {
		long sum = 0;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			t1 = arg1.applyAsLong(t1);
			if (!arg2.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToLong_map_mapToInt_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongUnaryOperator arg1, LongToIntFunction arg2) {
		int sum = 0;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			t1 = arg1.applyAsLong(t1);
			int t2 = arg2.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToLong_map_mapToDouble_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongUnaryOperator arg1, LongToDoubleFunction arg2) {
		double sum = 0;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			t1 = arg1.applyAsLong(t1);
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_filter_map_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1, LongUnaryOperator arg2) {
		long sum = 0;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			t1 = arg2.applyAsLong(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_filter_filter_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1, LongPredicate arg2) {
		long sum = 0;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			if (!arg2.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToLong_filter_mapToInt_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1, LongToIntFunction arg2) {
		int sum = 0;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			int t2 = arg2.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToLong_filter_mapToDouble_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1, LongToDoubleFunction arg2) {
		double sum = 0;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_mapToLong_mapToInt_map_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongToIntFunction arg1, IntUnaryOperator arg2) {
		int sum = 0;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			int t2 = arg1.applyAsInt(t1);
			t2 = arg2.applyAsInt(t2);
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_mapToLong_mapToInt_filter_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongToIntFunction arg1, IntPredicate arg2) {
		int sum = 0;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			int t2 = arg1.applyAsInt(t1);
			if (!arg2.test(t2)) {
				continue;
			}
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_mapToInt_mapToLong_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongToIntFunction arg1, IntToLongFunction arg2) {
		long sum = 0;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			int t2 = arg1.applyAsInt(t1);
			long t3 = arg2.applyAsLong(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0> double stream_mapToLong_mapToInt_mapToDouble_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongToIntFunction arg1, IntToDoubleFunction arg2) {
		double sum = 0;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			int t2 = arg1.applyAsInt(t1);
			double t3 = arg2.applyAsDouble(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0> double stream_mapToLong_mapToDouble_map_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongToDoubleFunction arg1, DoubleUnaryOperator arg2) {
		double sum = 0;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			double t2 = arg1.applyAsDouble(t1);
			t2 = arg2.applyAsDouble(t2);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToLong_mapToDouble_filter_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongToDoubleFunction arg1, DoublePredicate arg2) {
		double sum = 0;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			double t2 = arg1.applyAsDouble(t1);
			if (!arg2.test(t2)) {
				continue;
			}
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_mapToLong_mapToDouble_mapToInt_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongToDoubleFunction arg1, DoubleToIntFunction arg2) {
		int sum = 0;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			double t2 = arg1.applyAsDouble(t1);
			int t3 = arg2.applyAsInt(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_mapToDouble_mapToLong_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongToDoubleFunction arg1, DoubleToLongFunction arg2) {
		long sum = 0;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			double t2 = arg1.applyAsDouble(t1);
			long t3 = arg2.applyAsLong(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0, T2> int stream_mapToLong_mapToObj_mapToInt_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongFunction<T2> arg1, ToIntFunction<T2> arg2) {
		int sum = 0;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			T2 t2 = arg1.apply(t1);
			int t3 = arg2.applyAsInt(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0, T2> long stream_mapToLong_mapToObj_mapToLong_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongFunction<T2> arg1, ToLongFunction<T2> arg2) {
		long sum = 0;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			T2 t2 = arg1.apply(t1);
			long t3 = arg2.applyAsLong(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0, T2> double stream_mapToLong_mapToObj_mapToDouble_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongFunction<T2> arg1, ToDoubleFunction<T2> arg2) {
		double sum = 0;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			T2 t2 = arg1.apply(t1);
			double t3 = arg2.applyAsDouble(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0> int stream_mapToLong_boxed_mapToInt_sum(Collection<T0> input, ToLongFunction<T0> arg0, ToIntFunction<Long> arg2) {
		int sum = 0;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			Long t2 = t1;
			int t3 = arg2.applyAsInt(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_boxed_mapToLong_sum(Collection<T0> input, ToLongFunction<T0> arg0, ToLongFunction<Long> arg2) {
		long sum = 0;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			Long t2 = t1;
			long t3 = arg2.applyAsLong(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0> double stream_mapToLong_boxed_mapToDouble_sum(Collection<T0> input, ToLongFunction<T0> arg0, ToDoubleFunction<Long> arg2) {
		double sum = 0;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			Long t2 = t1;
			double t3 = arg2.applyAsDouble(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_map_map_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleUnaryOperator arg1, DoubleUnaryOperator arg2) {
		double sum = 0;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			t1 = arg1.applyAsDouble(t1);
			t1 = arg2.applyAsDouble(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_map_filter_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleUnaryOperator arg1, DoublePredicate arg2) {
		double sum = 0;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			t1 = arg1.applyAsDouble(t1);
			if (!arg2.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToDouble_map_mapToInt_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleUnaryOperator arg1, DoubleToIntFunction arg2) {
		int sum = 0;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			t1 = arg1.applyAsDouble(t1);
			int t2 = arg2.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_mapToDouble_map_mapToLong_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleUnaryOperator arg1, DoubleToLongFunction arg2) {
		long sum = 0;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			t1 = arg1.applyAsDouble(t1);
			long t2 = arg2.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_filter_map_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1, DoubleUnaryOperator arg2) {
		double sum = 0;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			t1 = arg2.applyAsDouble(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_filter_filter_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1, DoublePredicate arg2) {
		double sum = 0;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			if (!arg2.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToDouble_filter_mapToInt_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1, DoubleToIntFunction arg2) {
		int sum = 0;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			int t2 = arg2.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_mapToDouble_filter_mapToLong_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1, DoubleToLongFunction arg2) {
		long sum = 0;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			long t2 = arg2.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_mapToDouble_mapToInt_map_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToIntFunction arg1, IntUnaryOperator arg2) {
		int sum = 0;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			int t2 = arg1.applyAsInt(t1);
			t2 = arg2.applyAsInt(t2);
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_mapToDouble_mapToInt_filter_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToIntFunction arg1, IntPredicate arg2) {
		int sum = 0;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			int t2 = arg1.applyAsInt(t1);
			if (!arg2.test(t2)) {
				continue;
			}
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_mapToDouble_mapToInt_mapToLong_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToIntFunction arg1, IntToLongFunction arg2) {
		long sum = 0;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			int t2 = arg1.applyAsInt(t1);
			long t3 = arg2.applyAsLong(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_mapToInt_mapToDouble_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToIntFunction arg1, IntToDoubleFunction arg2) {
		double sum = 0;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			int t2 = arg1.applyAsInt(t1);
			double t3 = arg2.applyAsDouble(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0> long stream_mapToDouble_mapToLong_map_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToLongFunction arg1, LongUnaryOperator arg2) {
		long sum = 0;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			long t2 = arg1.applyAsLong(t1);
			t2 = arg2.applyAsLong(t2);
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_mapToDouble_mapToLong_filter_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToLongFunction arg1, LongPredicate arg2) {
		long sum = 0;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			long t2 = arg1.applyAsLong(t1);
			if (!arg2.test(t2)) {
				continue;
			}
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_mapToDouble_mapToLong_mapToInt_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToLongFunction arg1, LongToIntFunction arg2) {
		int sum = 0;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			long t2 = arg1.applyAsLong(t1);
			int t3 = arg2.applyAsInt(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_mapToLong_mapToDouble_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToLongFunction arg1, LongToDoubleFunction arg2) {
		double sum = 0;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			long t2 = arg1.applyAsLong(t1);
			double t3 = arg2.applyAsDouble(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0, T2> int stream_mapToDouble_mapToObj_mapToInt_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleFunction<T2> arg1, ToIntFunction<T2> arg2) {
		int sum = 0;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			T2 t2 = arg1.apply(t1);
			int t3 = arg2.applyAsInt(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0, T2> long stream_mapToDouble_mapToObj_mapToLong_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleFunction<T2> arg1, ToLongFunction<T2> arg2) {
		long sum = 0;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			T2 t2 = arg1.apply(t1);
			long t3 = arg2.applyAsLong(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0, T2> double stream_mapToDouble_mapToObj_mapToDouble_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleFunction<T2> arg1, ToDoubleFunction<T2> arg2) {
		double sum = 0;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			T2 t2 = arg1.apply(t1);
			double t3 = arg2.applyAsDouble(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0> int stream_mapToDouble_boxed_mapToInt_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, ToIntFunction<Double> arg2) {
		int sum = 0;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			Double t2 = t1;
			int t3 = arg2.applyAsInt(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0> long stream_mapToDouble_boxed_mapToLong_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, ToLongFunction<Double> arg2) {
		long sum = 0;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			Double t2 = t1;
			long t3 = arg2.applyAsLong(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_boxed_mapToDouble_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, ToDoubleFunction<Double> arg2) {
		double sum = 0;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			Double t2 = t1;
			double t3 = arg2.applyAsDouble(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0, T1> int stream_sorted_map_mapToInt_sum(Collection<T0> input, Function<T0, T1> arg1, ToIntFunction<T1> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			T1 t1 = arg1.apply(t0);
			int t2 = arg2.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> long stream_sorted_map_mapToLong_sum(Collection<T0> input, Function<T0, T1> arg1, ToLongFunction<T1> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			T1 t1 = arg1.apply(t0);
			long t2 = arg2.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> double stream_sorted_map_mapToDouble_sum(Collection<T0> input, Function<T0, T1> arg1, ToDoubleFunction<T1> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			T1 t1 = arg1.apply(t0);
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_sorted_filter_mapToInt_sum(Collection<T0> input, Predicate<T0> arg1, ToIntFunction<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if (!arg1.test(t0)) {
				continue;
			}
			int t1 = arg2.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_sorted_filter_mapToLong_sum(Collection<T0> input, Predicate<T0> arg1, ToLongFunction<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if (!arg1.test(t0)) {
				continue;
			}
			long t1 = arg2.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_sorted_filter_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg1, ToDoubleFunction<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if (!arg1.test(t0)) {
				continue;
			}
			double t1 = arg2.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_sorted_mapToInt_map_sum(Collection<T0> input, ToIntFunction<T0> arg1, IntUnaryOperator arg2) {
		List<T0> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			int t1 = arg1.applyAsInt(t0);
			t1 = arg2.applyAsInt(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_sorted_mapToInt_filter_sum(Collection<T0> input, ToIntFunction<T0> arg1, IntPredicate arg2) {
		List<T0> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			int t1 = arg1.applyAsInt(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_sorted_mapToInt_mapToLong_sum(Collection<T0> input, ToIntFunction<T0> arg1, IntToLongFunction arg2) {
		List<T0> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			int t1 = arg1.applyAsInt(t0);
			long t2 = arg2.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_sorted_mapToInt_mapToDouble_sum(Collection<T0> input, ToIntFunction<T0> arg1, IntToDoubleFunction arg2) {
		List<T0> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			int t1 = arg1.applyAsInt(t0);
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_sorted_mapToLong_map_sum(Collection<T0> input, ToLongFunction<T0> arg1, LongUnaryOperator arg2) {
		List<T0> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			long t1 = arg1.applyAsLong(t0);
			t1 = arg2.applyAsLong(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_sorted_mapToLong_filter_sum(Collection<T0> input, ToLongFunction<T0> arg1, LongPredicate arg2) {
		List<T0> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			long t1 = arg1.applyAsLong(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_sorted_mapToLong_mapToInt_sum(Collection<T0> input, ToLongFunction<T0> arg1, LongToIntFunction arg2) {
		List<T0> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			long t1 = arg1.applyAsLong(t0);
			int t2 = arg2.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_sorted_mapToLong_mapToDouble_sum(Collection<T0> input, ToLongFunction<T0> arg1, LongToDoubleFunction arg2) {
		List<T0> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			long t1 = arg1.applyAsLong(t0);
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_sorted_mapToDouble_map_sum(Collection<T0> input, ToDoubleFunction<T0> arg1, DoubleUnaryOperator arg2) {
		List<T0> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			double t1 = arg1.applyAsDouble(t0);
			t1 = arg2.applyAsDouble(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_sorted_mapToDouble_filter_sum(Collection<T0> input, ToDoubleFunction<T0> arg1, DoublePredicate arg2) {
		List<T0> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			double t1 = arg1.applyAsDouble(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_sorted_mapToDouble_mapToInt_sum(Collection<T0> input, ToDoubleFunction<T0> arg1, DoubleToIntFunction arg2) {
		List<T0> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			double t1 = arg1.applyAsDouble(t0);
			int t2 = arg2.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_sorted_mapToDouble_mapToLong_sum(Collection<T0> input, ToDoubleFunction<T0> arg1, DoubleToLongFunction arg2) {
		List<T0> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			double t1 = arg1.applyAsDouble(t0);
			long t2 = arg2.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_sorted_sorted_mapToInt_sum(Collection<T0> input, ToIntFunction<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		int sum = 0;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			sorted1.add(t0);
		}
		Collections.sort((List) sorted1);
		for (T0 t0: sorted1) {
			int t1 = arg2.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_sorted_sorted_mapToLong_sum(Collection<T0> input, ToLongFunction<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		long sum = 0;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			sorted1.add(t0);
		}
		Collections.sort((List) sorted1);
		for (T0 t0: sorted1) {
			long t1 = arg2.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_sorted_sorted_mapToDouble_sum(Collection<T0> input, ToDoubleFunction<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		double sum = 0;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			sorted1.add(t0);
		}
		Collections.sort((List) sorted1);
		for (T0 t0: sorted1) {
			double t1 = arg2.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_sorted_sortedComp_mapToInt_sum(Collection<T0> input, Comparator<? super T0> arg1, ToIntFunction<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			int t1 = arg2.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_sorted_sortedComp_mapToLong_sum(Collection<T0> input, Comparator<? super T0> arg1, ToLongFunction<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			long t1 = arg2.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_sorted_sortedComp_mapToDouble_sum(Collection<T0> input, Comparator<? super T0> arg1, ToDoubleFunction<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			double t1 = arg2.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0, T1> int stream_sortedComp_map_mapToInt_sum(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, T1> arg1, ToIntFunction<T1> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			T1 t1 = arg1.apply(t0);
			int t2 = arg2.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> long stream_sortedComp_map_mapToLong_sum(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, T1> arg1, ToLongFunction<T1> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			T1 t1 = arg1.apply(t0);
			long t2 = arg2.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> double stream_sortedComp_map_mapToDouble_sum(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, T1> arg1, ToDoubleFunction<T1> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			T1 t1 = arg1.apply(t0);
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_sortedComp_filter_mapToInt_sum(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, ToIntFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if (!arg1.test(t0)) {
				continue;
			}
			int t1 = arg2.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_sortedComp_filter_mapToLong_sum(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, ToLongFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if (!arg1.test(t0)) {
				continue;
			}
			long t1 = arg2.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_sortedComp_filter_mapToDouble_sum(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, ToDoubleFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if (!arg1.test(t0)) {
				continue;
			}
			double t1 = arg2.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_sortedComp_mapToInt_map_sum(Collection<T0> input, Comparator<? super T0> arg0, ToIntFunction<T0> arg1, IntUnaryOperator arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			int t1 = arg1.applyAsInt(t0);
			t1 = arg2.applyAsInt(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_sortedComp_mapToInt_filter_sum(Collection<T0> input, Comparator<? super T0> arg0, ToIntFunction<T0> arg1, IntPredicate arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			int t1 = arg1.applyAsInt(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_sortedComp_mapToInt_mapToLong_sum(Collection<T0> input, Comparator<? super T0> arg0, ToIntFunction<T0> arg1, IntToLongFunction arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			int t1 = arg1.applyAsInt(t0);
			long t2 = arg2.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_sortedComp_mapToInt_mapToDouble_sum(Collection<T0> input, Comparator<? super T0> arg0, ToIntFunction<T0> arg1, IntToDoubleFunction arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			int t1 = arg1.applyAsInt(t0);
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_sortedComp_mapToLong_map_sum(Collection<T0> input, Comparator<? super T0> arg0, ToLongFunction<T0> arg1, LongUnaryOperator arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			long t1 = arg1.applyAsLong(t0);
			t1 = arg2.applyAsLong(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_sortedComp_mapToLong_filter_sum(Collection<T0> input, Comparator<? super T0> arg0, ToLongFunction<T0> arg1, LongPredicate arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			long t1 = arg1.applyAsLong(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_sortedComp_mapToLong_mapToInt_sum(Collection<T0> input, Comparator<? super T0> arg0, ToLongFunction<T0> arg1, LongToIntFunction arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			long t1 = arg1.applyAsLong(t0);
			int t2 = arg2.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_sortedComp_mapToLong_mapToDouble_sum(Collection<T0> input, Comparator<? super T0> arg0, ToLongFunction<T0> arg1, LongToDoubleFunction arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			long t1 = arg1.applyAsLong(t0);
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_sortedComp_mapToDouble_map_sum(Collection<T0> input, Comparator<? super T0> arg0, ToDoubleFunction<T0> arg1, DoubleUnaryOperator arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			double t1 = arg1.applyAsDouble(t0);
			t1 = arg2.applyAsDouble(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_sortedComp_mapToDouble_filter_sum(Collection<T0> input, Comparator<? super T0> arg0, ToDoubleFunction<T0> arg1, DoublePredicate arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			double t1 = arg1.applyAsDouble(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_sortedComp_mapToDouble_mapToInt_sum(Collection<T0> input, Comparator<? super T0> arg0, ToDoubleFunction<T0> arg1, DoubleToIntFunction arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			double t1 = arg1.applyAsDouble(t0);
			int t2 = arg2.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_sortedComp_mapToDouble_mapToLong_sum(Collection<T0> input, Comparator<? super T0> arg0, ToDoubleFunction<T0> arg1, DoubleToLongFunction arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			double t1 = arg1.applyAsDouble(t0);
			long t2 = arg2.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_sortedComp_sorted_mapToInt_sum(Collection<T0> input, Comparator<? super T0> arg0, ToIntFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			int t1 = arg2.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_sortedComp_sorted_mapToLong_sum(Collection<T0> input, Comparator<? super T0> arg0, ToLongFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			long t1 = arg2.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_sortedComp_sorted_mapToDouble_sum(Collection<T0> input, Comparator<? super T0> arg0, ToDoubleFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			double t1 = arg2.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_sortedComp_sortedComp_mapToInt_sum(Collection<T0> input, Comparator<? super T0> arg0, Comparator<? super T0> arg1, ToIntFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		int sum = 0;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sortedComp1.add(t0);
		}
		sortedComp1.sort(arg1);
		for (T0 t0: sortedComp1) {
			int t1 = arg2.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_sortedComp_sortedComp_mapToLong_sum(Collection<T0> input, Comparator<? super T0> arg0, Comparator<? super T0> arg1, ToLongFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		long sum = 0;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sortedComp1.add(t0);
		}
		sortedComp1.sort(arg1);
		for (T0 t0: sortedComp1) {
			long t1 = arg2.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_sortedComp_sortedComp_mapToDouble_sum(Collection<T0> input, Comparator<? super T0> arg0, Comparator<? super T0> arg1, ToDoubleFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		double sum = 0;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sortedComp1.add(t0);
		}
		sortedComp1.sort(arg1);
		for (T0 t0: sortedComp1) {
			double t1 = arg2.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}


}
