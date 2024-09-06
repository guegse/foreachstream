package io.github.guegse.foreachstream;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class ForeachStreamSum {

	public static <T0> int stream_mapToInt_sum(Collection<T0> input, ToIntFunction<T0> arg0) {
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_sum(Collection<T0> input, ToLongFunction<T0> arg0) {
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_sum(Collection<T0> input, ToDoubleFunction<T0> arg0) {
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0, T1> int stream_map_mapToInt_sum(Collection<T0> input, Function<T0, T1> arg0, ToIntFunction<T1> arg1) {
		int sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			int t2 = arg1.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> long stream_map_mapToLong_sum(Collection<T0> input, Function<T0, T1> arg0, ToLongFunction<T1> arg1) {
		long sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			long t2 = arg1.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> double stream_map_mapToDouble_sum(Collection<T0> input, Function<T0, T1> arg0, ToDoubleFunction<T1> arg1) {
		double sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			double t2 = arg1.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_filter_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1) {
		int sum = 0;
		for (T0 t0: input) {
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
		for (T0 t0: input) {
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
		for (T0 t0: input) {
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
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			t1 = arg1.applyAsInt(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_filter_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1) {
		int sum = 0;
		for (T0 t0: input) {
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
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			long t2 = arg1.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToInt_mapToDouble_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntToDoubleFunction arg1) {
		double sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			double t2 = arg1.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_sorted_sum(Collection<T0> input, ToIntFunction<T0> arg0) {
		List<Integer> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (int t1: sorted0) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_limit_sum(Collection<T0> input, ToIntFunction<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			int t1 = arg0.applyAsInt(t0);
			limit0++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_skip_sum(Collection<T0> input, ToIntFunction<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_distinct_sum(Collection<T0> input, ToIntFunction<T0> arg0) {
		Set<Integer> distinct0 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_dropWhile_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1) {
		boolean dropWhile0 = true;
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_takeWhile_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1) {
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			if(!arg1.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_map_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongUnaryOperator arg1) {
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			t1 = arg1.applyAsLong(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_filter_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1) {
		long sum = 0;
		for (T0 t0: input) {
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
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			int t2 = arg1.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToLong_mapToDouble_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongToDoubleFunction arg1) {
		double sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			double t2 = arg1.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_sorted_sum(Collection<T0> input, ToLongFunction<T0> arg0) {
		List<Long> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (long t1: sorted0) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_limit_sum(Collection<T0> input, ToLongFunction<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			long t1 = arg0.applyAsLong(t0);
			limit0++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_skip_sum(Collection<T0> input, ToLongFunction<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_distinct_sum(Collection<T0> input, ToLongFunction<T0> arg0) {
		Set<Long> distinct0 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_dropWhile_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1) {
		boolean dropWhile0 = true;
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_takeWhile_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1) {
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			if(!arg1.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_map_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleUnaryOperator arg1) {
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			t1 = arg1.applyAsDouble(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_filter_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1) {
		double sum = 0;
		for (T0 t0: input) {
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
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			int t2 = arg1.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_mapToDouble_mapToLong_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToLongFunction arg1) {
		long sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			long t2 = arg1.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_sorted_sum(Collection<T0> input, ToDoubleFunction<T0> arg0) {
		List<Double> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (double t1: sorted0) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_limit_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			double t1 = arg0.applyAsDouble(t0);
			limit0++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_skip_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_distinct_sum(Collection<T0> input, ToDoubleFunction<T0> arg0) {
		Set<Double> distinct0 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_dropWhile_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1) {
		boolean dropWhile0 = true;
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_takeWhile_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1) {
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			if(!arg1.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_sorted_mapToInt_sum(Collection<T0> input, ToIntFunction<T0> arg0) {
		List<T0> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			int t1 = arg0.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_sorted_mapToLong_sum(Collection<T0> input, ToLongFunction<T0> arg0) {
		List<T0> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			long t1 = arg0.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_sorted_mapToDouble_sum(Collection<T0> input, ToDoubleFunction<T0> arg0) {
		List<T0> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			double t1 = arg0.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_sortedComp_mapToInt_sum(Collection<T0> input, Comparator<? super T0> arg0, ToIntFunction<T0> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
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
		for (T0 t0: input) {
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
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			double t1 = arg1.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_limit_mapToInt_sum(Collection<T0> input, long arg0, ToIntFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			int t1 = arg1.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_limit_mapToLong_sum(Collection<T0> input, long arg0, ToLongFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			long t1 = arg1.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_limit_mapToDouble_sum(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			double t1 = arg1.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_skip_mapToInt_sum(Collection<T0> input, long arg0, ToIntFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_skip_mapToLong_sum(Collection<T0> input, long arg0, ToLongFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_skip_mapToDouble_sum(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_distinct_mapToInt_sum(Collection<T0> input, ToIntFunction<T0> arg0) {
		Set<T0> distinct0 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			int t1 = arg0.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_distinct_mapToLong_sum(Collection<T0> input, ToLongFunction<T0> arg0) {
		Set<T0> distinct0 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			long t1 = arg0.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_distinct_mapToDouble_sum(Collection<T0> input, ToDoubleFunction<T0> arg0) {
		Set<T0> distinct0 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			double t1 = arg0.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_dropWhile_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1) {
		boolean dropWhile0 = true;
		int sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			int t1 = arg1.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_dropWhile_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1) {
		boolean dropWhile0 = true;
		long sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			long t1 = arg1.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_dropWhile_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1) {
		boolean dropWhile0 = true;
		double sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			double t1 = arg1.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_takeWhile_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1) {
		int sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			int t1 = arg1.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_takeWhile_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1) {
		long sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			long t1 = arg1.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_takeWhile_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1) {
		double sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			double t1 = arg1.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0, T1> int stream_flatMapLambda_mapToInt_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToIntFunction<T1> arg1) {
		int sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				int t2 = arg1.applyAsInt(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> long stream_flatMapLambda_mapToLong_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToLongFunction<T1> arg1) {
		long sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				long t2 = arg1.applyAsLong(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> double stream_flatMapLambda_mapToDouble_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToDoubleFunction<T1> arg1) {
		double sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				double t2 = arg1.applyAsDouble(t1);
				sum += t2;
			}
		}
		return sum;
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

	public static <T0 extends Collection<T1>, T1> double stream_flatMapMemberReference_mapToDouble_sum(Collection<T0> input, ToDoubleFunction<T1> arg0) {
		double sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				double t2 = arg0.applyAsDouble(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1, T2> int stream_map_map_mapToInt_sum(Collection<T0> input, Function<T0, T1> arg0, Function<T1, T2> arg1, ToIntFunction<T2> arg2) {
		int sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			T2 t2 = arg1.apply(t1);
			int t3 = arg2.applyAsInt(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0, T1, T2> long stream_map_map_mapToLong_sum(Collection<T0> input, Function<T0, T1> arg0, Function<T1, T2> arg1, ToLongFunction<T2> arg2) {
		long sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			T2 t2 = arg1.apply(t1);
			long t3 = arg2.applyAsLong(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0, T1, T2> double stream_map_map_mapToDouble_sum(Collection<T0> input, Function<T0, T1> arg0, Function<T1, T2> arg1, ToDoubleFunction<T2> arg2) {
		double sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			T2 t2 = arg1.apply(t1);
			double t3 = arg2.applyAsDouble(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0, T1> int stream_map_filter_mapToInt_sum(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, ToIntFunction<T1> arg2) {
		int sum = 0;
		for (T0 t0: input) {
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
		for (T0 t0: input) {
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
		for (T0 t0: input) {
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
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			int t2 = arg1.applyAsInt(t1);
			t2 = arg2.applyAsInt(t2);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> int stream_map_mapToInt_filter_sum(Collection<T0> input, Function<T0, T1> arg0, ToIntFunction<T1> arg1, IntPredicate arg2) {
		int sum = 0;
		for (T0 t0: input) {
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
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			int t2 = arg1.applyAsInt(t1);
			long t3 = arg2.applyAsLong(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0, T1> double stream_map_mapToInt_mapToDouble_sum(Collection<T0> input, Function<T0, T1> arg0, ToIntFunction<T1> arg1, IntToDoubleFunction arg2) {
		double sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			int t2 = arg1.applyAsInt(t1);
			double t3 = arg2.applyAsDouble(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0, T1> int stream_map_mapToInt_sorted_sum(Collection<T0> input, Function<T0, T1> arg0, ToIntFunction<T1> arg1) {
		List<Integer> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			int t2 = arg1.applyAsInt(t1);
			sorted0.add(t2);
		}
		sorted0.sort(null);
		for (int t2: sorted0) {
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> int stream_map_mapToInt_limit_sum(Collection<T0> input, Function<T0, T1> arg0, ToIntFunction<T1> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			T1 t1 = arg0.apply(t0);
			int t2 = arg1.applyAsInt(t1);
			limit0++;
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> int stream_map_mapToInt_skip_sum(Collection<T0> input, Function<T0, T1> arg0, ToIntFunction<T1> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			int t2 = arg1.applyAsInt(t1);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> int stream_map_mapToInt_distinct_sum(Collection<T0> input, Function<T0, T1> arg0, ToIntFunction<T1> arg1) {
		Set<Integer> distinct0 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			int t2 = arg1.applyAsInt(t1);
			if(!distinct0.add(t2)) {
				continue;
			}
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> int stream_map_mapToInt_dropWhile_sum(Collection<T0> input, Function<T0, T1> arg0, ToIntFunction<T1> arg1, IntPredicate arg2) {
		boolean dropWhile0 = true;
		int sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			int t2 = arg1.applyAsInt(t1);
			if(dropWhile0 && arg2.test(t2)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> int stream_map_mapToInt_takeWhile_sum(Collection<T0> input, Function<T0, T1> arg0, ToIntFunction<T1> arg1, IntPredicate arg2) {
		int sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			int t2 = arg1.applyAsInt(t1);
			if(!arg2.test(t2)) {
				break;
			}
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> long stream_map_mapToLong_map_sum(Collection<T0> input, Function<T0, T1> arg0, ToLongFunction<T1> arg1, LongUnaryOperator arg2) {
		long sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			long t2 = arg1.applyAsLong(t1);
			t2 = arg2.applyAsLong(t2);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> long stream_map_mapToLong_filter_sum(Collection<T0> input, Function<T0, T1> arg0, ToLongFunction<T1> arg1, LongPredicate arg2) {
		long sum = 0;
		for (T0 t0: input) {
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
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			long t2 = arg1.applyAsLong(t1);
			int t3 = arg2.applyAsInt(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0, T1> double stream_map_mapToLong_mapToDouble_sum(Collection<T0> input, Function<T0, T1> arg0, ToLongFunction<T1> arg1, LongToDoubleFunction arg2) {
		double sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			long t2 = arg1.applyAsLong(t1);
			double t3 = arg2.applyAsDouble(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0, T1> long stream_map_mapToLong_sorted_sum(Collection<T0> input, Function<T0, T1> arg0, ToLongFunction<T1> arg1) {
		List<Long> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			long t2 = arg1.applyAsLong(t1);
			sorted0.add(t2);
		}
		sorted0.sort(null);
		for (long t2: sorted0) {
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> long stream_map_mapToLong_limit_sum(Collection<T0> input, Function<T0, T1> arg0, ToLongFunction<T1> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			T1 t1 = arg0.apply(t0);
			long t2 = arg1.applyAsLong(t1);
			limit0++;
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> long stream_map_mapToLong_skip_sum(Collection<T0> input, Function<T0, T1> arg0, ToLongFunction<T1> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			long t2 = arg1.applyAsLong(t1);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> long stream_map_mapToLong_distinct_sum(Collection<T0> input, Function<T0, T1> arg0, ToLongFunction<T1> arg1) {
		Set<Long> distinct0 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			long t2 = arg1.applyAsLong(t1);
			if(!distinct0.add(t2)) {
				continue;
			}
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> long stream_map_mapToLong_dropWhile_sum(Collection<T0> input, Function<T0, T1> arg0, ToLongFunction<T1> arg1, LongPredicate arg2) {
		boolean dropWhile0 = true;
		long sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			long t2 = arg1.applyAsLong(t1);
			if(dropWhile0 && arg2.test(t2)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> long stream_map_mapToLong_takeWhile_sum(Collection<T0> input, Function<T0, T1> arg0, ToLongFunction<T1> arg1, LongPredicate arg2) {
		long sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			long t2 = arg1.applyAsLong(t1);
			if(!arg2.test(t2)) {
				break;
			}
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> double stream_map_mapToDouble_map_sum(Collection<T0> input, Function<T0, T1> arg0, ToDoubleFunction<T1> arg1, DoubleUnaryOperator arg2) {
		double sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			double t2 = arg1.applyAsDouble(t1);
			t2 = arg2.applyAsDouble(t2);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> double stream_map_mapToDouble_filter_sum(Collection<T0> input, Function<T0, T1> arg0, ToDoubleFunction<T1> arg1, DoublePredicate arg2) {
		double sum = 0;
		for (T0 t0: input) {
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
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			double t2 = arg1.applyAsDouble(t1);
			int t3 = arg2.applyAsInt(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0, T1> long stream_map_mapToDouble_mapToLong_sum(Collection<T0> input, Function<T0, T1> arg0, ToDoubleFunction<T1> arg1, DoubleToLongFunction arg2) {
		long sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			double t2 = arg1.applyAsDouble(t1);
			long t3 = arg2.applyAsLong(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0, T1> double stream_map_mapToDouble_sorted_sum(Collection<T0> input, Function<T0, T1> arg0, ToDoubleFunction<T1> arg1) {
		List<Double> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			double t2 = arg1.applyAsDouble(t1);
			sorted0.add(t2);
		}
		sorted0.sort(null);
		for (double t2: sorted0) {
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> double stream_map_mapToDouble_limit_sum(Collection<T0> input, Function<T0, T1> arg0, ToDoubleFunction<T1> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			T1 t1 = arg0.apply(t0);
			double t2 = arg1.applyAsDouble(t1);
			limit0++;
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> double stream_map_mapToDouble_skip_sum(Collection<T0> input, Function<T0, T1> arg0, ToDoubleFunction<T1> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			double t2 = arg1.applyAsDouble(t1);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> double stream_map_mapToDouble_distinct_sum(Collection<T0> input, Function<T0, T1> arg0, ToDoubleFunction<T1> arg1) {
		Set<Double> distinct0 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			double t2 = arg1.applyAsDouble(t1);
			if(!distinct0.add(t2)) {
				continue;
			}
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> double stream_map_mapToDouble_dropWhile_sum(Collection<T0> input, Function<T0, T1> arg0, ToDoubleFunction<T1> arg1, DoublePredicate arg2) {
		boolean dropWhile0 = true;
		double sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			double t2 = arg1.applyAsDouble(t1);
			if(dropWhile0 && arg2.test(t2)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> double stream_map_mapToDouble_takeWhile_sum(Collection<T0> input, Function<T0, T1> arg0, ToDoubleFunction<T1> arg1, DoublePredicate arg2) {
		double sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			double t2 = arg1.applyAsDouble(t1);
			if(!arg2.test(t2)) {
				break;
			}
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> int stream_map_sorted_mapToInt_sum(Collection<T0> input, Function<T0, T1> arg0, ToIntFunction<T1> arg1) {
		List<T1> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			int t2 = arg1.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> long stream_map_sorted_mapToLong_sum(Collection<T0> input, Function<T0, T1> arg0, ToLongFunction<T1> arg1) {
		List<T1> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			long t2 = arg1.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> double stream_map_sorted_mapToDouble_sum(Collection<T0> input, Function<T0, T1> arg0, ToDoubleFunction<T1> arg1) {
		List<T1> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			double t2 = arg1.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> int stream_map_sortedComp_mapToInt_sum(Collection<T0> input, Function<T0, T1> arg0, Comparator<? super T1> arg1, ToIntFunction<T1> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
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
		for (T0 t0: input) {
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
		for (T0 t0: input) {
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

	public static <T0, T1> int stream_map_limit_mapToInt_sum(Collection<T0> input, Function<T0, T1> arg0, long arg1, ToIntFunction<T1> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			T1 t1 = arg0.apply(t0);
			limit0++;
			int t2 = arg2.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> long stream_map_limit_mapToLong_sum(Collection<T0> input, Function<T0, T1> arg0, long arg1, ToLongFunction<T1> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			T1 t1 = arg0.apply(t0);
			limit0++;
			long t2 = arg2.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> double stream_map_limit_mapToDouble_sum(Collection<T0> input, Function<T0, T1> arg0, long arg1, ToDoubleFunction<T1> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			T1 t1 = arg0.apply(t0);
			limit0++;
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> int stream_map_skip_mapToInt_sum(Collection<T0> input, Function<T0, T1> arg0, long arg1, ToIntFunction<T1> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			int t2 = arg2.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> long stream_map_skip_mapToLong_sum(Collection<T0> input, Function<T0, T1> arg0, long arg1, ToLongFunction<T1> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			long t2 = arg2.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> double stream_map_skip_mapToDouble_sum(Collection<T0> input, Function<T0, T1> arg0, long arg1, ToDoubleFunction<T1> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> int stream_map_distinct_mapToInt_sum(Collection<T0> input, Function<T0, T1> arg0, ToIntFunction<T1> arg1) {
		Set<T1> distinct0 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			int t2 = arg1.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> long stream_map_distinct_mapToLong_sum(Collection<T0> input, Function<T0, T1> arg0, ToLongFunction<T1> arg1) {
		Set<T1> distinct0 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			long t2 = arg1.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> double stream_map_distinct_mapToDouble_sum(Collection<T0> input, Function<T0, T1> arg0, ToDoubleFunction<T1> arg1) {
		Set<T1> distinct0 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			double t2 = arg1.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> int stream_map_dropWhile_mapToInt_sum(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, ToIntFunction<T1> arg2) {
		boolean dropWhile0 = true;
		int sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			int t2 = arg2.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> long stream_map_dropWhile_mapToLong_sum(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, ToLongFunction<T1> arg2) {
		boolean dropWhile0 = true;
		long sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			long t2 = arg2.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> double stream_map_dropWhile_mapToDouble_sum(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, ToDoubleFunction<T1> arg2) {
		boolean dropWhile0 = true;
		double sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> int stream_map_takeWhile_mapToInt_sum(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, ToIntFunction<T1> arg2) {
		int sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if(!arg1.test(t1)) {
				break;
			}
			int t2 = arg2.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> long stream_map_takeWhile_mapToLong_sum(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, ToLongFunction<T1> arg2) {
		long sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if(!arg1.test(t1)) {
				break;
			}
			long t2 = arg2.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> double stream_map_takeWhile_mapToDouble_sum(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, ToDoubleFunction<T1> arg2) {
		double sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			if(!arg1.test(t1)) {
				break;
			}
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1, T2> int stream_map_flatMapLambda_mapToInt_sum(Collection<T0> input, Function<T0, T1> arg0, Function<T1, Collection<T2>> arg1, ToIntFunction<T2> arg2) {
		int sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			for (T2 t2 : arg1.apply(t1)) {
				int t3 = arg2.applyAsInt(t2);
				sum += t3;
			}
		}
		return sum;
	}

	public static <T0, T1, T2> long stream_map_flatMapLambda_mapToLong_sum(Collection<T0> input, Function<T0, T1> arg0, Function<T1, Collection<T2>> arg1, ToLongFunction<T2> arg2) {
		long sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			for (T2 t2 : arg1.apply(t1)) {
				long t3 = arg2.applyAsLong(t2);
				sum += t3;
			}
		}
		return sum;
	}

	public static <T0, T1, T2> double stream_map_flatMapLambda_mapToDouble_sum(Collection<T0> input, Function<T0, T1> arg0, Function<T1, Collection<T2>> arg1, ToDoubleFunction<T2> arg2) {
		double sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			for (T2 t2 : arg1.apply(t1)) {
				double t3 = arg2.applyAsDouble(t2);
				sum += t3;
			}
		}
		return sum;
	}

	public static <T0, T1 extends Collection<T2>, T2> int stream_map_flatMapMemberReference_mapToInt_sum(Collection<T0> input, Function<T0, T1> arg0, ToIntFunction<T2> arg1) {
		int sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			for (T2 t2 : t1) {
				int t3 = arg1.applyAsInt(t2);
				sum += t3;
			}
		}
		return sum;
	}

	public static <T0, T1 extends Collection<T2>, T2> long stream_map_flatMapMemberReference_mapToLong_sum(Collection<T0> input, Function<T0, T1> arg0, ToLongFunction<T2> arg1) {
		long sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			for (T2 t2 : t1) {
				long t3 = arg1.applyAsLong(t2);
				sum += t3;
			}
		}
		return sum;
	}

	public static <T0, T1 extends Collection<T2>, T2> double stream_map_flatMapMemberReference_mapToDouble_sum(Collection<T0> input, Function<T0, T1> arg0, ToDoubleFunction<T2> arg1) {
		double sum = 0;
		for (T0 t0: input) {
			T1 t1 = arg0.apply(t0);
			for (T2 t2 : t1) {
				double t3 = arg1.applyAsDouble(t2);
				sum += t3;
			}
		}
		return sum;
	}

	public static <T0, T1> int stream_filter_map_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, ToIntFunction<T1> arg2) {
		int sum = 0;
		for (T0 t0: input) {
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
		for (T0 t0: input) {
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
		for (T0 t0: input) {
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
		for (T0 t0: input) {
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
		for (T0 t0: input) {
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
		for (T0 t0: input) {
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
		for (T0 t0: input) {
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
		for (T0 t0: input) {
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
		for (T0 t0: input) {
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
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_filter_mapToInt_sorted_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1) {
		List<Integer> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (int t1: sorted0) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_filter_mapToInt_limit_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			if (!arg0.test(t0)) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			limit0++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_filter_mapToInt_skip_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_filter_mapToInt_distinct_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1) {
		Set<Integer> distinct0 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_filter_mapToInt_dropWhile_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1, IntPredicate arg2) {
		boolean dropWhile0 = true;
		int sum = 0;
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_filter_mapToInt_takeWhile_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1, IntPredicate arg2) {
		int sum = 0;
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			if(!arg2.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_filter_mapToLong_map_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1, LongUnaryOperator arg2) {
		long sum = 0;
		for (T0 t0: input) {
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
		for (T0 t0: input) {
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
		for (T0 t0: input) {
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
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_filter_mapToLong_sorted_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1) {
		List<Long> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (long t1: sorted0) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_filter_mapToLong_limit_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			if (!arg0.test(t0)) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			limit0++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_filter_mapToLong_skip_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_filter_mapToLong_distinct_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1) {
		Set<Long> distinct0 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_filter_mapToLong_dropWhile_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1, LongPredicate arg2) {
		boolean dropWhile0 = true;
		long sum = 0;
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_filter_mapToLong_takeWhile_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1, LongPredicate arg2) {
		long sum = 0;
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			if(!arg2.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_filter_mapToDouble_map_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1, DoubleUnaryOperator arg2) {
		double sum = 0;
		for (T0 t0: input) {
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
		for (T0 t0: input) {
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
		for (T0 t0: input) {
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
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			long t2 = arg2.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_filter_mapToDouble_sorted_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1) {
		List<Double> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (double t1: sorted0) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_filter_mapToDouble_limit_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			if (!arg0.test(t0)) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			limit0++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_filter_mapToDouble_skip_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_filter_mapToDouble_distinct_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1) {
		Set<Double> distinct0 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_filter_mapToDouble_dropWhile_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1, DoublePredicate arg2) {
		boolean dropWhile0 = true;
		double sum = 0;
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_filter_mapToDouble_takeWhile_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1, DoublePredicate arg2) {
		double sum = 0;
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			if(!arg2.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_filter_sorted_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			int t1 = arg1.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_filter_sorted_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			long t1 = arg1.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_filter_sorted_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			double t1 = arg1.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_filter_sortedComp_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, ToIntFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
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
		for (T0 t0: input) {
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
		for (T0 t0: input) {
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

	public static <T0> int stream_filter_limit_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, long arg1, ToIntFunction<T0> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if (!arg0.test(t0)) {
				continue;
			}
			limit0++;
			int t1 = arg2.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_filter_limit_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, long arg1, ToLongFunction<T0> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if (!arg0.test(t0)) {
				continue;
			}
			limit0++;
			long t1 = arg2.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_filter_limit_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, long arg1, ToDoubleFunction<T0> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if (!arg0.test(t0)) {
				continue;
			}
			limit0++;
			double t1 = arg2.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_filter_skip_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, long arg1, ToIntFunction<T0> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			int t1 = arg2.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_filter_skip_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, long arg1, ToLongFunction<T0> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			long t1 = arg2.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_filter_skip_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, long arg1, ToDoubleFunction<T0> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			double t1 = arg2.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_filter_distinct_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_filter_distinct_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_filter_distinct_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_filter_dropWhile_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, ToIntFunction<T0> arg2) {
		boolean dropWhile0 = true;
		int sum = 0;
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			int t1 = arg2.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_filter_dropWhile_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, ToLongFunction<T0> arg2) {
		boolean dropWhile0 = true;
		long sum = 0;
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			long t1 = arg2.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_filter_dropWhile_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, ToDoubleFunction<T0> arg2) {
		boolean dropWhile0 = true;
		double sum = 0;
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			double t1 = arg2.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_filter_takeWhile_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, ToIntFunction<T0> arg2) {
		int sum = 0;
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			int t1 = arg2.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_filter_takeWhile_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, ToLongFunction<T0> arg2) {
		long sum = 0;
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			long t1 = arg2.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_filter_takeWhile_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, ToDoubleFunction<T0> arg2) {
		double sum = 0;
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			double t1 = arg2.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0, T1> int stream_filter_flatMapLambda_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, ToIntFunction<T1> arg2) {
		int sum = 0;
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				int t2 = arg2.applyAsInt(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> long stream_filter_flatMapLambda_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, ToLongFunction<T1> arg2) {
		long sum = 0;
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				long t2 = arg2.applyAsLong(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> double stream_filter_flatMapLambda_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, ToDoubleFunction<T1> arg2) {
		double sum = 0;
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				double t2 = arg2.applyAsDouble(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> int stream_filter_flatMapMemberReference_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T1> arg1) {
		int sum = 0;
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			for (T1 t1 : t0) {
				int t2 = arg1.applyAsInt(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> long stream_filter_flatMapMemberReference_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T1> arg1) {
		long sum = 0;
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			for (T1 t1 : t0) {
				long t2 = arg1.applyAsLong(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> double stream_filter_flatMapMemberReference_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T1> arg1) {
		double sum = 0;
		for (T0 t0: input) {
			if (!arg0.test(t0)) {
				continue;
			}
			for (T1 t1 : t0) {
				double t2 = arg1.applyAsDouble(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_map_map_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntUnaryOperator arg1, IntUnaryOperator arg2) {
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			t1 = arg1.applyAsInt(t1);
			t1 = arg2.applyAsInt(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_map_filter_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntUnaryOperator arg1, IntPredicate arg2) {
		int sum = 0;
		for (T0 t0: input) {
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
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			t1 = arg1.applyAsInt(t1);
			long t2 = arg2.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToInt_map_mapToDouble_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntUnaryOperator arg1, IntToDoubleFunction arg2) {
		double sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			t1 = arg1.applyAsInt(t1);
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_map_sorted_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntUnaryOperator arg1) {
		List<Integer> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			t1 = arg1.applyAsInt(t1);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (int t1: sorted0) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_map_limit_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntUnaryOperator arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			int t1 = arg0.applyAsInt(t0);
			t1 = arg1.applyAsInt(t1);
			limit0++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_map_skip_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntUnaryOperator arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			t1 = arg1.applyAsInt(t1);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_map_distinct_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntUnaryOperator arg1) {
		Set<Integer> distinct0 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			t1 = arg1.applyAsInt(t1);
			if(!distinct0.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_map_dropWhile_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntUnaryOperator arg1, IntPredicate arg2) {
		boolean dropWhile0 = true;
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			t1 = arg1.applyAsInt(t1);
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_map_takeWhile_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntUnaryOperator arg1, IntPredicate arg2) {
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			t1 = arg1.applyAsInt(t1);
			if(!arg2.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_filter_map_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1, IntUnaryOperator arg2) {
		int sum = 0;
		for (T0 t0: input) {
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
		for (T0 t0: input) {
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
		for (T0 t0: input) {
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
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_filter_sorted_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1) {
		List<Integer> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (int t1: sorted0) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_filter_limit_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			int t1 = arg0.applyAsInt(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			limit0++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_filter_skip_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_filter_distinct_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1) {
		Set<Integer> distinct0 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			if(!distinct0.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_filter_dropWhile_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1, IntPredicate arg2) {
		boolean dropWhile0 = true;
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_filter_takeWhile_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1, IntPredicate arg2) {
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			if(!arg2.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToInt_mapToLong_map_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntToLongFunction arg1, LongUnaryOperator arg2) {
		long sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			long t2 = arg1.applyAsLong(t1);
			t2 = arg2.applyAsLong(t2);
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_mapToInt_mapToLong_filter_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntToLongFunction arg1, LongPredicate arg2) {
		long sum = 0;
		for (T0 t0: input) {
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
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			long t2 = arg1.applyAsLong(t1);
			int t3 = arg2.applyAsInt(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0> double stream_mapToInt_mapToLong_mapToDouble_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntToLongFunction arg1, LongToDoubleFunction arg2) {
		double sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			long t2 = arg1.applyAsLong(t1);
			double t3 = arg2.applyAsDouble(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0> long stream_mapToInt_mapToLong_sorted_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntToLongFunction arg1) {
		List<Long> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			long t2 = arg1.applyAsLong(t1);
			sorted0.add(t2);
		}
		sorted0.sort(null);
		for (long t2: sorted0) {
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_mapToInt_mapToLong_limit_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntToLongFunction arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			int t1 = arg0.applyAsInt(t0);
			long t2 = arg1.applyAsLong(t1);
			limit0++;
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_mapToInt_mapToLong_skip_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntToLongFunction arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			long t2 = arg1.applyAsLong(t1);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_mapToInt_mapToLong_distinct_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntToLongFunction arg1) {
		Set<Long> distinct0 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			long t2 = arg1.applyAsLong(t1);
			if(!distinct0.add(t2)) {
				continue;
			}
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_mapToInt_mapToLong_dropWhile_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntToLongFunction arg1, LongPredicate arg2) {
		boolean dropWhile0 = true;
		long sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			long t2 = arg1.applyAsLong(t1);
			if(dropWhile0 && arg2.test(t2)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_mapToInt_mapToLong_takeWhile_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntToLongFunction arg1, LongPredicate arg2) {
		long sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			long t2 = arg1.applyAsLong(t1);
			if(!arg2.test(t2)) {
				break;
			}
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToInt_mapToDouble_map_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntToDoubleFunction arg1, DoubleUnaryOperator arg2) {
		double sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			double t2 = arg1.applyAsDouble(t1);
			t2 = arg2.applyAsDouble(t2);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToInt_mapToDouble_filter_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntToDoubleFunction arg1, DoublePredicate arg2) {
		double sum = 0;
		for (T0 t0: input) {
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
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			double t2 = arg1.applyAsDouble(t1);
			int t3 = arg2.applyAsInt(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0> long stream_mapToInt_mapToDouble_mapToLong_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntToDoubleFunction arg1, DoubleToLongFunction arg2) {
		long sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			double t2 = arg1.applyAsDouble(t1);
			long t3 = arg2.applyAsLong(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0> double stream_mapToInt_mapToDouble_sorted_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntToDoubleFunction arg1) {
		List<Double> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			double t2 = arg1.applyAsDouble(t1);
			sorted0.add(t2);
		}
		sorted0.sort(null);
		for (double t2: sorted0) {
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToInt_mapToDouble_limit_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntToDoubleFunction arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			int t1 = arg0.applyAsInt(t0);
			double t2 = arg1.applyAsDouble(t1);
			limit0++;
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToInt_mapToDouble_skip_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntToDoubleFunction arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			double t2 = arg1.applyAsDouble(t1);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToInt_mapToDouble_distinct_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntToDoubleFunction arg1) {
		Set<Double> distinct0 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			double t2 = arg1.applyAsDouble(t1);
			if(!distinct0.add(t2)) {
				continue;
			}
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToInt_mapToDouble_dropWhile_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntToDoubleFunction arg1, DoublePredicate arg2) {
		boolean dropWhile0 = true;
		double sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			double t2 = arg1.applyAsDouble(t1);
			if(dropWhile0 && arg2.test(t2)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToInt_mapToDouble_takeWhile_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntToDoubleFunction arg1, DoublePredicate arg2) {
		double sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			double t2 = arg1.applyAsDouble(t1);
			if(!arg2.test(t2)) {
				break;
			}
			sum += t2;
		}
		return sum;
	}

	public static <T0, T2> int stream_mapToInt_mapToObj_mapToInt_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntFunction<T2> arg1, ToIntFunction<T2> arg2) {
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			T2 t2 = arg1.apply(t1);
			int t3 = arg2.applyAsInt(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0, T2> long stream_mapToInt_mapToObj_mapToLong_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntFunction<T2> arg1, ToLongFunction<T2> arg2) {
		long sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			T2 t2 = arg1.apply(t1);
			long t3 = arg2.applyAsLong(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0, T2> double stream_mapToInt_mapToObj_mapToDouble_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntFunction<T2> arg1, ToDoubleFunction<T2> arg2) {
		double sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			T2 t2 = arg1.apply(t1);
			double t3 = arg2.applyAsDouble(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_boxed_mapToInt_sum(Collection<T0> input, ToIntFunction<T0> arg0, ToIntFunction<Integer> arg1) {
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			Integer t2 = t1;
			int t3 = arg1.applyAsInt(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0> long stream_mapToInt_boxed_mapToLong_sum(Collection<T0> input, ToIntFunction<T0> arg0, ToLongFunction<Integer> arg1) {
		long sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			Integer t2 = t1;
			long t3 = arg1.applyAsLong(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0> double stream_mapToInt_boxed_mapToDouble_sum(Collection<T0> input, ToIntFunction<T0> arg0, ToDoubleFunction<Integer> arg1) {
		double sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			Integer t2 = t1;
			double t3 = arg1.applyAsDouble(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_sorted_map_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntUnaryOperator arg1) {
		List<Integer> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (int t1: sorted0) {
			t1 = arg1.applyAsInt(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_sorted_filter_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1) {
		List<Integer> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (int t1: sorted0) {
			if (!arg1.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToInt_sorted_mapToLong_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntToLongFunction arg1) {
		List<Integer> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (int t1: sorted0) {
			long t2 = arg1.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToInt_sorted_mapToDouble_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntToDoubleFunction arg1) {
		List<Integer> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (int t1: sorted0) {
			double t2 = arg1.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_sorted_sorted_sum(Collection<T0> input, ToIntFunction<T0> arg0) {
		List<Integer> sorted0 = new ArrayList<>();
		List<Integer> sorted1 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (int t1: sorted0) {
			sorted1.add(t1);
		}
		sorted1.sort(null);
		for (int t1: sorted1) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_sorted_limit_sum(Collection<T0> input, ToIntFunction<T0> arg0, long arg1) {
		List<Integer> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			int t1 = arg0.applyAsInt(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (int t1: sorted0) {
			limit0++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_sorted_skip_sum(Collection<T0> input, ToIntFunction<T0> arg0, long arg1) {
		List<Integer> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (int t1: sorted0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_sorted_distinct_sum(Collection<T0> input, ToIntFunction<T0> arg0) {
		List<Integer> sorted0 = new ArrayList<>();
		Set<Integer> distinct0 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (int t1: sorted0) {
			if(!distinct0.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_sorted_dropWhile_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1) {
		List<Integer> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (int t1: sorted0) {
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_sorted_takeWhile_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1) {
		List<Integer> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (int t1: sorted0) {
			if(!arg1.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_limit_map_sum(Collection<T0> input, ToIntFunction<T0> arg0, long arg1, IntUnaryOperator arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			int t1 = arg0.applyAsInt(t0);
			limit0++;
			t1 = arg2.applyAsInt(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_limit_filter_sum(Collection<T0> input, ToIntFunction<T0> arg0, long arg1, IntPredicate arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			int t1 = arg0.applyAsInt(t0);
			limit0++;
			if (!arg2.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToInt_limit_mapToLong_sum(Collection<T0> input, ToIntFunction<T0> arg0, long arg1, IntToLongFunction arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			int t1 = arg0.applyAsInt(t0);
			limit0++;
			long t2 = arg2.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToInt_limit_mapToDouble_sum(Collection<T0> input, ToIntFunction<T0> arg0, long arg1, IntToDoubleFunction arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			int t1 = arg0.applyAsInt(t0);
			limit0++;
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_limit_sorted_sum(Collection<T0> input, ToIntFunction<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<Integer> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			int t1 = arg0.applyAsInt(t0);
			limit0++;
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (int t1: sorted0) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_limit_limit_sum(Collection<T0> input, ToIntFunction<T0> arg0, long arg1, long arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(limit1 >= arg2) {
				break;
			}
			int t1 = arg0.applyAsInt(t0);
			limit0++;
			limit1++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_limit_skip_sum(Collection<T0> input, ToIntFunction<T0> arg0, long arg1, long arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			int t1 = arg0.applyAsInt(t0);
			limit0++;
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_limit_distinct_sum(Collection<T0> input, ToIntFunction<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<Integer> distinct0 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			int t1 = arg0.applyAsInt(t0);
			limit0++;
			if(!distinct0.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_limit_dropWhile_sum(Collection<T0> input, ToIntFunction<T0> arg0, long arg1, IntPredicate arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			int t1 = arg0.applyAsInt(t0);
			limit0++;
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_limit_takeWhile_sum(Collection<T0> input, ToIntFunction<T0> arg0, long arg1, IntPredicate arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			int t1 = arg0.applyAsInt(t0);
			limit0++;
			if(!arg2.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_skip_map_sum(Collection<T0> input, ToIntFunction<T0> arg0, long arg1, IntUnaryOperator arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			t1 = arg2.applyAsInt(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_skip_filter_sum(Collection<T0> input, ToIntFunction<T0> arg0, long arg1, IntPredicate arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if (!arg2.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToInt_skip_mapToLong_sum(Collection<T0> input, ToIntFunction<T0> arg0, long arg1, IntToLongFunction arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			long t2 = arg2.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToInt_skip_mapToDouble_sum(Collection<T0> input, ToIntFunction<T0> arg0, long arg1, IntToDoubleFunction arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_skip_sorted_sum(Collection<T0> input, ToIntFunction<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<Integer> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (int t1: sorted0) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_skip_limit_sum(Collection<T0> input, ToIntFunction<T0> arg0, long arg1, long arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			int t1 = arg0.applyAsInt(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			limit0++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_skip_skip_sum(Collection<T0> input, ToIntFunction<T0> arg0, long arg1, long arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			skip1++;
			if(skip1 <= arg2) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_skip_distinct_sum(Collection<T0> input, ToIntFunction<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<Integer> distinct0 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if(!distinct0.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_skip_dropWhile_sum(Collection<T0> input, ToIntFunction<T0> arg0, long arg1, IntPredicate arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_skip_takeWhile_sum(Collection<T0> input, ToIntFunction<T0> arg0, long arg1, IntPredicate arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if(!arg2.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_distinct_map_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntUnaryOperator arg1) {
		Set<Integer> distinct0 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			t1 = arg1.applyAsInt(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_distinct_filter_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1) {
		Set<Integer> distinct0 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			if (!arg1.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToInt_distinct_mapToLong_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntToLongFunction arg1) {
		Set<Integer> distinct0 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			long t2 = arg1.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToInt_distinct_mapToDouble_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntToDoubleFunction arg1) {
		Set<Integer> distinct0 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			double t2 = arg1.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_distinct_sorted_sum(Collection<T0> input, ToIntFunction<T0> arg0) {
		Set<Integer> distinct0 = new HashSet<>();
		List<Integer> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (int t1: sorted0) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_distinct_limit_sum(Collection<T0> input, ToIntFunction<T0> arg0, long arg1) {
		Set<Integer> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			int t1 = arg0.applyAsInt(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			limit0++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_distinct_skip_sum(Collection<T0> input, ToIntFunction<T0> arg0, long arg1) {
		Set<Integer> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_distinct_distinct_sum(Collection<T0> input, ToIntFunction<T0> arg0) {
		Set<Integer> distinct0 = new HashSet<>();
		Set<Integer> distinct1 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			if(!distinct1.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_distinct_dropWhile_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1) {
		Set<Integer> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_distinct_takeWhile_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1) {
		Set<Integer> distinct0 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			if(!arg1.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_dropWhile_map_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1, IntUnaryOperator arg2) {
		boolean dropWhile0 = true;
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			t1 = arg2.applyAsInt(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_dropWhile_filter_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1, IntPredicate arg2) {
		boolean dropWhile0 = true;
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if (!arg2.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToInt_dropWhile_mapToLong_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1, IntToLongFunction arg2) {
		boolean dropWhile0 = true;
		long sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			long t2 = arg2.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToInt_dropWhile_mapToDouble_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1, IntToDoubleFunction arg2) {
		boolean dropWhile0 = true;
		double sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_dropWhile_sorted_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1) {
		boolean dropWhile0 = true;
		List<Integer> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (int t1: sorted0) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_dropWhile_limit_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1, long arg2) {
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			int t1 = arg0.applyAsInt(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			limit0++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_dropWhile_skip_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1, long arg2) {
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_dropWhile_distinct_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1) {
		boolean dropWhile0 = true;
		Set<Integer> distinct0 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!distinct0.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_dropWhile_dropWhile_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1, IntPredicate arg2) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
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
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_dropWhile_takeWhile_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1, IntPredicate arg2) {
		boolean dropWhile0 = true;
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!arg2.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_takeWhile_map_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1, IntUnaryOperator arg2) {
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			if(!arg1.test(t1)) {
				break;
			}
			t1 = arg2.applyAsInt(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_takeWhile_filter_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1, IntPredicate arg2) {
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			if(!arg1.test(t1)) {
				break;
			}
			if (!arg2.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToInt_takeWhile_mapToLong_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1, IntToLongFunction arg2) {
		long sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			if(!arg1.test(t1)) {
				break;
			}
			long t2 = arg2.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToInt_takeWhile_mapToDouble_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1, IntToDoubleFunction arg2) {
		double sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			if(!arg1.test(t1)) {
				break;
			}
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_takeWhile_sorted_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1) {
		List<Integer> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			if(!arg1.test(t1)) {
				break;
			}
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (int t1: sorted0) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_takeWhile_limit_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			int t1 = arg0.applyAsInt(t0);
			if(!arg1.test(t1)) {
				break;
			}
			limit0++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_takeWhile_skip_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			if(!arg1.test(t1)) {
				break;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_takeWhile_distinct_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1) {
		Set<Integer> distinct0 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			if(!arg1.test(t1)) {
				break;
			}
			if(!distinct0.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_takeWhile_dropWhile_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1, IntPredicate arg2) {
		boolean dropWhile0 = true;
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			if(!arg1.test(t1)) {
				break;
			}
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToInt_takeWhile_takeWhile_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1, IntPredicate arg2) {
		int sum = 0;
		for (T0 t0: input) {
			int t1 = arg0.applyAsInt(t0);
			if(!arg1.test(t1)) {
				break;
			}
			if(!arg2.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_map_map_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongUnaryOperator arg1, LongUnaryOperator arg2) {
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			t1 = arg1.applyAsLong(t1);
			t1 = arg2.applyAsLong(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_map_filter_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongUnaryOperator arg1, LongPredicate arg2) {
		long sum = 0;
		for (T0 t0: input) {
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
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			t1 = arg1.applyAsLong(t1);
			int t2 = arg2.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToLong_map_mapToDouble_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongUnaryOperator arg1, LongToDoubleFunction arg2) {
		double sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			t1 = arg1.applyAsLong(t1);
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_map_sorted_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongUnaryOperator arg1) {
		List<Long> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			t1 = arg1.applyAsLong(t1);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (long t1: sorted0) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_map_limit_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongUnaryOperator arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			long t1 = arg0.applyAsLong(t0);
			t1 = arg1.applyAsLong(t1);
			limit0++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_map_skip_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongUnaryOperator arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			t1 = arg1.applyAsLong(t1);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_map_distinct_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongUnaryOperator arg1) {
		Set<Long> distinct0 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			t1 = arg1.applyAsLong(t1);
			if(!distinct0.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_map_dropWhile_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongUnaryOperator arg1, LongPredicate arg2) {
		boolean dropWhile0 = true;
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			t1 = arg1.applyAsLong(t1);
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_map_takeWhile_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongUnaryOperator arg1, LongPredicate arg2) {
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			t1 = arg1.applyAsLong(t1);
			if(!arg2.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_filter_map_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1, LongUnaryOperator arg2) {
		long sum = 0;
		for (T0 t0: input) {
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
		for (T0 t0: input) {
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
		for (T0 t0: input) {
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
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_filter_sorted_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1) {
		List<Long> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (long t1: sorted0) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_filter_limit_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			long t1 = arg0.applyAsLong(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			limit0++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_filter_skip_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_filter_distinct_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1) {
		Set<Long> distinct0 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			if(!distinct0.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_filter_dropWhile_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1, LongPredicate arg2) {
		boolean dropWhile0 = true;
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_filter_takeWhile_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1, LongPredicate arg2) {
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			if(!arg2.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToLong_mapToInt_map_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongToIntFunction arg1, IntUnaryOperator arg2) {
		int sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			int t2 = arg1.applyAsInt(t1);
			t2 = arg2.applyAsInt(t2);
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_mapToLong_mapToInt_filter_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongToIntFunction arg1, IntPredicate arg2) {
		int sum = 0;
		for (T0 t0: input) {
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
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			int t2 = arg1.applyAsInt(t1);
			long t3 = arg2.applyAsLong(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0> double stream_mapToLong_mapToInt_mapToDouble_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongToIntFunction arg1, IntToDoubleFunction arg2) {
		double sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			int t2 = arg1.applyAsInt(t1);
			double t3 = arg2.applyAsDouble(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0> int stream_mapToLong_mapToInt_sorted_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongToIntFunction arg1) {
		List<Integer> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			int t2 = arg1.applyAsInt(t1);
			sorted0.add(t2);
		}
		sorted0.sort(null);
		for (int t2: sorted0) {
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_mapToLong_mapToInt_limit_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongToIntFunction arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			long t1 = arg0.applyAsLong(t0);
			int t2 = arg1.applyAsInt(t1);
			limit0++;
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_mapToLong_mapToInt_skip_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongToIntFunction arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			int t2 = arg1.applyAsInt(t1);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_mapToLong_mapToInt_distinct_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongToIntFunction arg1) {
		Set<Integer> distinct0 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			int t2 = arg1.applyAsInt(t1);
			if(!distinct0.add(t2)) {
				continue;
			}
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_mapToLong_mapToInt_dropWhile_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongToIntFunction arg1, IntPredicate arg2) {
		boolean dropWhile0 = true;
		int sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			int t2 = arg1.applyAsInt(t1);
			if(dropWhile0 && arg2.test(t2)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_mapToLong_mapToInt_takeWhile_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongToIntFunction arg1, IntPredicate arg2) {
		int sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			int t2 = arg1.applyAsInt(t1);
			if(!arg2.test(t2)) {
				break;
			}
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToLong_mapToDouble_map_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongToDoubleFunction arg1, DoubleUnaryOperator arg2) {
		double sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			double t2 = arg1.applyAsDouble(t1);
			t2 = arg2.applyAsDouble(t2);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToLong_mapToDouble_filter_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongToDoubleFunction arg1, DoublePredicate arg2) {
		double sum = 0;
		for (T0 t0: input) {
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
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			double t2 = arg1.applyAsDouble(t1);
			int t3 = arg2.applyAsInt(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_mapToDouble_mapToLong_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongToDoubleFunction arg1, DoubleToLongFunction arg2) {
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			double t2 = arg1.applyAsDouble(t1);
			long t3 = arg2.applyAsLong(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0> double stream_mapToLong_mapToDouble_sorted_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongToDoubleFunction arg1) {
		List<Double> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			double t2 = arg1.applyAsDouble(t1);
			sorted0.add(t2);
		}
		sorted0.sort(null);
		for (double t2: sorted0) {
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToLong_mapToDouble_limit_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongToDoubleFunction arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			long t1 = arg0.applyAsLong(t0);
			double t2 = arg1.applyAsDouble(t1);
			limit0++;
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToLong_mapToDouble_skip_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongToDoubleFunction arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			double t2 = arg1.applyAsDouble(t1);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToLong_mapToDouble_distinct_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongToDoubleFunction arg1) {
		Set<Double> distinct0 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			double t2 = arg1.applyAsDouble(t1);
			if(!distinct0.add(t2)) {
				continue;
			}
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToLong_mapToDouble_dropWhile_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongToDoubleFunction arg1, DoublePredicate arg2) {
		boolean dropWhile0 = true;
		double sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			double t2 = arg1.applyAsDouble(t1);
			if(dropWhile0 && arg2.test(t2)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToLong_mapToDouble_takeWhile_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongToDoubleFunction arg1, DoublePredicate arg2) {
		double sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			double t2 = arg1.applyAsDouble(t1);
			if(!arg2.test(t2)) {
				break;
			}
			sum += t2;
		}
		return sum;
	}

	public static <T0, T2> int stream_mapToLong_mapToObj_mapToInt_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongFunction<T2> arg1, ToIntFunction<T2> arg2) {
		int sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			T2 t2 = arg1.apply(t1);
			int t3 = arg2.applyAsInt(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0, T2> long stream_mapToLong_mapToObj_mapToLong_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongFunction<T2> arg1, ToLongFunction<T2> arg2) {
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			T2 t2 = arg1.apply(t1);
			long t3 = arg2.applyAsLong(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0, T2> double stream_mapToLong_mapToObj_mapToDouble_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongFunction<T2> arg1, ToDoubleFunction<T2> arg2) {
		double sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			T2 t2 = arg1.apply(t1);
			double t3 = arg2.applyAsDouble(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0> int stream_mapToLong_boxed_mapToInt_sum(Collection<T0> input, ToLongFunction<T0> arg0, ToIntFunction<Long> arg1) {
		int sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			Long t2 = t1;
			int t3 = arg1.applyAsInt(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_boxed_mapToLong_sum(Collection<T0> input, ToLongFunction<T0> arg0, ToLongFunction<Long> arg1) {
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			Long t2 = t1;
			long t3 = arg1.applyAsLong(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0> double stream_mapToLong_boxed_mapToDouble_sum(Collection<T0> input, ToLongFunction<T0> arg0, ToDoubleFunction<Long> arg1) {
		double sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			Long t2 = t1;
			double t3 = arg1.applyAsDouble(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_sorted_map_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongUnaryOperator arg1) {
		List<Long> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (long t1: sorted0) {
			t1 = arg1.applyAsLong(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_sorted_filter_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1) {
		List<Long> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (long t1: sorted0) {
			if (!arg1.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToLong_sorted_mapToInt_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongToIntFunction arg1) {
		List<Long> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (long t1: sorted0) {
			int t2 = arg1.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToLong_sorted_mapToDouble_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongToDoubleFunction arg1) {
		List<Long> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (long t1: sorted0) {
			double t2 = arg1.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_sorted_sorted_sum(Collection<T0> input, ToLongFunction<T0> arg0) {
		List<Long> sorted0 = new ArrayList<>();
		List<Long> sorted1 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (long t1: sorted0) {
			sorted1.add(t1);
		}
		sorted1.sort(null);
		for (long t1: sorted1) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_sorted_limit_sum(Collection<T0> input, ToLongFunction<T0> arg0, long arg1) {
		List<Long> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			long t1 = arg0.applyAsLong(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (long t1: sorted0) {
			limit0++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_sorted_skip_sum(Collection<T0> input, ToLongFunction<T0> arg0, long arg1) {
		List<Long> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (long t1: sorted0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_sorted_distinct_sum(Collection<T0> input, ToLongFunction<T0> arg0) {
		List<Long> sorted0 = new ArrayList<>();
		Set<Long> distinct0 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (long t1: sorted0) {
			if(!distinct0.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_sorted_dropWhile_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1) {
		List<Long> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (long t1: sorted0) {
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_sorted_takeWhile_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1) {
		List<Long> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (long t1: sorted0) {
			if(!arg1.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_limit_map_sum(Collection<T0> input, ToLongFunction<T0> arg0, long arg1, LongUnaryOperator arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			long t1 = arg0.applyAsLong(t0);
			limit0++;
			t1 = arg2.applyAsLong(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_limit_filter_sum(Collection<T0> input, ToLongFunction<T0> arg0, long arg1, LongPredicate arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			long t1 = arg0.applyAsLong(t0);
			limit0++;
			if (!arg2.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToLong_limit_mapToInt_sum(Collection<T0> input, ToLongFunction<T0> arg0, long arg1, LongToIntFunction arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			long t1 = arg0.applyAsLong(t0);
			limit0++;
			int t2 = arg2.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToLong_limit_mapToDouble_sum(Collection<T0> input, ToLongFunction<T0> arg0, long arg1, LongToDoubleFunction arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			long t1 = arg0.applyAsLong(t0);
			limit0++;
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_limit_sorted_sum(Collection<T0> input, ToLongFunction<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<Long> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			long t1 = arg0.applyAsLong(t0);
			limit0++;
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (long t1: sorted0) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_limit_limit_sum(Collection<T0> input, ToLongFunction<T0> arg0, long arg1, long arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(limit1 >= arg2) {
				break;
			}
			long t1 = arg0.applyAsLong(t0);
			limit0++;
			limit1++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_limit_skip_sum(Collection<T0> input, ToLongFunction<T0> arg0, long arg1, long arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			long t1 = arg0.applyAsLong(t0);
			limit0++;
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_limit_distinct_sum(Collection<T0> input, ToLongFunction<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<Long> distinct0 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			long t1 = arg0.applyAsLong(t0);
			limit0++;
			if(!distinct0.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_limit_dropWhile_sum(Collection<T0> input, ToLongFunction<T0> arg0, long arg1, LongPredicate arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			long t1 = arg0.applyAsLong(t0);
			limit0++;
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_limit_takeWhile_sum(Collection<T0> input, ToLongFunction<T0> arg0, long arg1, LongPredicate arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			long t1 = arg0.applyAsLong(t0);
			limit0++;
			if(!arg2.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_skip_map_sum(Collection<T0> input, ToLongFunction<T0> arg0, long arg1, LongUnaryOperator arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			t1 = arg2.applyAsLong(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_skip_filter_sum(Collection<T0> input, ToLongFunction<T0> arg0, long arg1, LongPredicate arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if (!arg2.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToLong_skip_mapToInt_sum(Collection<T0> input, ToLongFunction<T0> arg0, long arg1, LongToIntFunction arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			int t2 = arg2.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToLong_skip_mapToDouble_sum(Collection<T0> input, ToLongFunction<T0> arg0, long arg1, LongToDoubleFunction arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_skip_sorted_sum(Collection<T0> input, ToLongFunction<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<Long> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (long t1: sorted0) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_skip_limit_sum(Collection<T0> input, ToLongFunction<T0> arg0, long arg1, long arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			long t1 = arg0.applyAsLong(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			limit0++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_skip_skip_sum(Collection<T0> input, ToLongFunction<T0> arg0, long arg1, long arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			skip1++;
			if(skip1 <= arg2) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_skip_distinct_sum(Collection<T0> input, ToLongFunction<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<Long> distinct0 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if(!distinct0.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_skip_dropWhile_sum(Collection<T0> input, ToLongFunction<T0> arg0, long arg1, LongPredicate arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_skip_takeWhile_sum(Collection<T0> input, ToLongFunction<T0> arg0, long arg1, LongPredicate arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if(!arg2.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_distinct_map_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongUnaryOperator arg1) {
		Set<Long> distinct0 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			t1 = arg1.applyAsLong(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_distinct_filter_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1) {
		Set<Long> distinct0 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			if (!arg1.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToLong_distinct_mapToInt_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongToIntFunction arg1) {
		Set<Long> distinct0 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			int t2 = arg1.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToLong_distinct_mapToDouble_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongToDoubleFunction arg1) {
		Set<Long> distinct0 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			double t2 = arg1.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_distinct_sorted_sum(Collection<T0> input, ToLongFunction<T0> arg0) {
		Set<Long> distinct0 = new HashSet<>();
		List<Long> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (long t1: sorted0) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_distinct_limit_sum(Collection<T0> input, ToLongFunction<T0> arg0, long arg1) {
		Set<Long> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			long t1 = arg0.applyAsLong(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			limit0++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_distinct_skip_sum(Collection<T0> input, ToLongFunction<T0> arg0, long arg1) {
		Set<Long> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_distinct_distinct_sum(Collection<T0> input, ToLongFunction<T0> arg0) {
		Set<Long> distinct0 = new HashSet<>();
		Set<Long> distinct1 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			if(!distinct1.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_distinct_dropWhile_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1) {
		Set<Long> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_distinct_takeWhile_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1) {
		Set<Long> distinct0 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			if(!arg1.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_dropWhile_map_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1, LongUnaryOperator arg2) {
		boolean dropWhile0 = true;
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			t1 = arg2.applyAsLong(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_dropWhile_filter_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1, LongPredicate arg2) {
		boolean dropWhile0 = true;
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if (!arg2.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToLong_dropWhile_mapToInt_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1, LongToIntFunction arg2) {
		boolean dropWhile0 = true;
		int sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			int t2 = arg2.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToLong_dropWhile_mapToDouble_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1, LongToDoubleFunction arg2) {
		boolean dropWhile0 = true;
		double sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_dropWhile_sorted_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1) {
		boolean dropWhile0 = true;
		List<Long> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (long t1: sorted0) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_dropWhile_limit_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1, long arg2) {
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			long t1 = arg0.applyAsLong(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			limit0++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_dropWhile_skip_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1, long arg2) {
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_dropWhile_distinct_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1) {
		boolean dropWhile0 = true;
		Set<Long> distinct0 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!distinct0.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_dropWhile_dropWhile_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1, LongPredicate arg2) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
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
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_dropWhile_takeWhile_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1, LongPredicate arg2) {
		boolean dropWhile0 = true;
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!arg2.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_takeWhile_map_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1, LongUnaryOperator arg2) {
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			if(!arg1.test(t1)) {
				break;
			}
			t1 = arg2.applyAsLong(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_takeWhile_filter_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1, LongPredicate arg2) {
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			if(!arg1.test(t1)) {
				break;
			}
			if (!arg2.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToLong_takeWhile_mapToInt_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1, LongToIntFunction arg2) {
		int sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			if(!arg1.test(t1)) {
				break;
			}
			int t2 = arg2.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToLong_takeWhile_mapToDouble_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1, LongToDoubleFunction arg2) {
		double sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			if(!arg1.test(t1)) {
				break;
			}
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_takeWhile_sorted_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1) {
		List<Long> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			if(!arg1.test(t1)) {
				break;
			}
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (long t1: sorted0) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_takeWhile_limit_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			long t1 = arg0.applyAsLong(t0);
			if(!arg1.test(t1)) {
				break;
			}
			limit0++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_takeWhile_skip_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			if(!arg1.test(t1)) {
				break;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_takeWhile_distinct_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1) {
		Set<Long> distinct0 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			if(!arg1.test(t1)) {
				break;
			}
			if(!distinct0.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_takeWhile_dropWhile_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1, LongPredicate arg2) {
		boolean dropWhile0 = true;
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			if(!arg1.test(t1)) {
				break;
			}
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_mapToLong_takeWhile_takeWhile_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1, LongPredicate arg2) {
		long sum = 0;
		for (T0 t0: input) {
			long t1 = arg0.applyAsLong(t0);
			if(!arg1.test(t1)) {
				break;
			}
			if(!arg2.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_map_map_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleUnaryOperator arg1, DoubleUnaryOperator arg2) {
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			t1 = arg1.applyAsDouble(t1);
			t1 = arg2.applyAsDouble(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_map_filter_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleUnaryOperator arg1, DoublePredicate arg2) {
		double sum = 0;
		for (T0 t0: input) {
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
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			t1 = arg1.applyAsDouble(t1);
			int t2 = arg2.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_mapToDouble_map_mapToLong_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleUnaryOperator arg1, DoubleToLongFunction arg2) {
		long sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			t1 = arg1.applyAsDouble(t1);
			long t2 = arg2.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_map_sorted_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleUnaryOperator arg1) {
		List<Double> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			t1 = arg1.applyAsDouble(t1);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (double t1: sorted0) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_map_limit_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleUnaryOperator arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			double t1 = arg0.applyAsDouble(t0);
			t1 = arg1.applyAsDouble(t1);
			limit0++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_map_skip_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleUnaryOperator arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			t1 = arg1.applyAsDouble(t1);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_map_distinct_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleUnaryOperator arg1) {
		Set<Double> distinct0 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			t1 = arg1.applyAsDouble(t1);
			if(!distinct0.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_map_dropWhile_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleUnaryOperator arg1, DoublePredicate arg2) {
		boolean dropWhile0 = true;
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			t1 = arg1.applyAsDouble(t1);
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_map_takeWhile_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleUnaryOperator arg1, DoublePredicate arg2) {
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			t1 = arg1.applyAsDouble(t1);
			if(!arg2.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_filter_map_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1, DoubleUnaryOperator arg2) {
		double sum = 0;
		for (T0 t0: input) {
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
		for (T0 t0: input) {
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
		for (T0 t0: input) {
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
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			long t2 = arg2.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_filter_sorted_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1) {
		List<Double> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (double t1: sorted0) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_filter_limit_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			double t1 = arg0.applyAsDouble(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			limit0++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_filter_skip_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_filter_distinct_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1) {
		Set<Double> distinct0 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			if(!distinct0.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_filter_dropWhile_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1, DoublePredicate arg2) {
		boolean dropWhile0 = true;
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_filter_takeWhile_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1, DoublePredicate arg2) {
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			if(!arg2.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToDouble_mapToInt_map_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToIntFunction arg1, IntUnaryOperator arg2) {
		int sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			int t2 = arg1.applyAsInt(t1);
			t2 = arg2.applyAsInt(t2);
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_mapToDouble_mapToInt_filter_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToIntFunction arg1, IntPredicate arg2) {
		int sum = 0;
		for (T0 t0: input) {
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
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			int t2 = arg1.applyAsInt(t1);
			long t3 = arg2.applyAsLong(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_mapToInt_mapToDouble_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToIntFunction arg1, IntToDoubleFunction arg2) {
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			int t2 = arg1.applyAsInt(t1);
			double t3 = arg2.applyAsDouble(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0> int stream_mapToDouble_mapToInt_sorted_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToIntFunction arg1) {
		List<Integer> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			int t2 = arg1.applyAsInt(t1);
			sorted0.add(t2);
		}
		sorted0.sort(null);
		for (int t2: sorted0) {
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_mapToDouble_mapToInt_limit_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToIntFunction arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			double t1 = arg0.applyAsDouble(t0);
			int t2 = arg1.applyAsInt(t1);
			limit0++;
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_mapToDouble_mapToInt_skip_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToIntFunction arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			int t2 = arg1.applyAsInt(t1);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_mapToDouble_mapToInt_distinct_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToIntFunction arg1) {
		Set<Integer> distinct0 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			int t2 = arg1.applyAsInt(t1);
			if(!distinct0.add(t2)) {
				continue;
			}
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_mapToDouble_mapToInt_dropWhile_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToIntFunction arg1, IntPredicate arg2) {
		boolean dropWhile0 = true;
		int sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			int t2 = arg1.applyAsInt(t1);
			if(dropWhile0 && arg2.test(t2)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_mapToDouble_mapToInt_takeWhile_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToIntFunction arg1, IntPredicate arg2) {
		int sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			int t2 = arg1.applyAsInt(t1);
			if(!arg2.test(t2)) {
				break;
			}
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_mapToDouble_mapToLong_map_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToLongFunction arg1, LongUnaryOperator arg2) {
		long sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			long t2 = arg1.applyAsLong(t1);
			t2 = arg2.applyAsLong(t2);
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_mapToDouble_mapToLong_filter_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToLongFunction arg1, LongPredicate arg2) {
		long sum = 0;
		for (T0 t0: input) {
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
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			long t2 = arg1.applyAsLong(t1);
			int t3 = arg2.applyAsInt(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_mapToLong_mapToDouble_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToLongFunction arg1, LongToDoubleFunction arg2) {
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			long t2 = arg1.applyAsLong(t1);
			double t3 = arg2.applyAsDouble(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0> long stream_mapToDouble_mapToLong_sorted_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToLongFunction arg1) {
		List<Long> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			long t2 = arg1.applyAsLong(t1);
			sorted0.add(t2);
		}
		sorted0.sort(null);
		for (long t2: sorted0) {
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_mapToDouble_mapToLong_limit_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToLongFunction arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			double t1 = arg0.applyAsDouble(t0);
			long t2 = arg1.applyAsLong(t1);
			limit0++;
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_mapToDouble_mapToLong_skip_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToLongFunction arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			long t2 = arg1.applyAsLong(t1);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_mapToDouble_mapToLong_distinct_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToLongFunction arg1) {
		Set<Long> distinct0 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			long t2 = arg1.applyAsLong(t1);
			if(!distinct0.add(t2)) {
				continue;
			}
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_mapToDouble_mapToLong_dropWhile_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToLongFunction arg1, LongPredicate arg2) {
		boolean dropWhile0 = true;
		long sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			long t2 = arg1.applyAsLong(t1);
			if(dropWhile0 && arg2.test(t2)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_mapToDouble_mapToLong_takeWhile_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToLongFunction arg1, LongPredicate arg2) {
		long sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			long t2 = arg1.applyAsLong(t1);
			if(!arg2.test(t2)) {
				break;
			}
			sum += t2;
		}
		return sum;
	}

	public static <T0, T2> int stream_mapToDouble_mapToObj_mapToInt_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleFunction<T2> arg1, ToIntFunction<T2> arg2) {
		int sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			T2 t2 = arg1.apply(t1);
			int t3 = arg2.applyAsInt(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0, T2> long stream_mapToDouble_mapToObj_mapToLong_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleFunction<T2> arg1, ToLongFunction<T2> arg2) {
		long sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			T2 t2 = arg1.apply(t1);
			long t3 = arg2.applyAsLong(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0, T2> double stream_mapToDouble_mapToObj_mapToDouble_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleFunction<T2> arg1, ToDoubleFunction<T2> arg2) {
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			T2 t2 = arg1.apply(t1);
			double t3 = arg2.applyAsDouble(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0> int stream_mapToDouble_boxed_mapToInt_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, ToIntFunction<Double> arg1) {
		int sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			Double t2 = t1;
			int t3 = arg1.applyAsInt(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0> long stream_mapToDouble_boxed_mapToLong_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, ToLongFunction<Double> arg1) {
		long sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			Double t2 = t1;
			long t3 = arg1.applyAsLong(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_boxed_mapToDouble_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, ToDoubleFunction<Double> arg1) {
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			Double t2 = t1;
			double t3 = arg1.applyAsDouble(t2);
			sum += t3;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_sorted_map_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleUnaryOperator arg1) {
		List<Double> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (double t1: sorted0) {
			t1 = arg1.applyAsDouble(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_sorted_filter_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1) {
		List<Double> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (double t1: sorted0) {
			if (!arg1.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToDouble_sorted_mapToInt_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToIntFunction arg1) {
		List<Double> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (double t1: sorted0) {
			int t2 = arg1.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_mapToDouble_sorted_mapToLong_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToLongFunction arg1) {
		List<Double> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (double t1: sorted0) {
			long t2 = arg1.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_sorted_sorted_sum(Collection<T0> input, ToDoubleFunction<T0> arg0) {
		List<Double> sorted0 = new ArrayList<>();
		List<Double> sorted1 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (double t1: sorted0) {
			sorted1.add(t1);
		}
		sorted1.sort(null);
		for (double t1: sorted1) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_sorted_limit_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1) {
		List<Double> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			double t1 = arg0.applyAsDouble(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (double t1: sorted0) {
			limit0++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_sorted_skip_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1) {
		List<Double> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (double t1: sorted0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_sorted_distinct_sum(Collection<T0> input, ToDoubleFunction<T0> arg0) {
		List<Double> sorted0 = new ArrayList<>();
		Set<Double> distinct0 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (double t1: sorted0) {
			if(!distinct0.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_sorted_dropWhile_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1) {
		List<Double> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (double t1: sorted0) {
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_sorted_takeWhile_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1) {
		List<Double> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (double t1: sorted0) {
			if(!arg1.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_limit_map_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1, DoubleUnaryOperator arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			double t1 = arg0.applyAsDouble(t0);
			limit0++;
			t1 = arg2.applyAsDouble(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_limit_filter_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1, DoublePredicate arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			double t1 = arg0.applyAsDouble(t0);
			limit0++;
			if (!arg2.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToDouble_limit_mapToInt_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1, DoubleToIntFunction arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			double t1 = arg0.applyAsDouble(t0);
			limit0++;
			int t2 = arg2.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_mapToDouble_limit_mapToLong_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1, DoubleToLongFunction arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			double t1 = arg0.applyAsDouble(t0);
			limit0++;
			long t2 = arg2.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_limit_sorted_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<Double> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			double t1 = arg0.applyAsDouble(t0);
			limit0++;
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (double t1: sorted0) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_limit_limit_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1, long arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(limit1 >= arg2) {
				break;
			}
			double t1 = arg0.applyAsDouble(t0);
			limit0++;
			limit1++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_limit_skip_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1, long arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			double t1 = arg0.applyAsDouble(t0);
			limit0++;
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_limit_distinct_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<Double> distinct0 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			double t1 = arg0.applyAsDouble(t0);
			limit0++;
			if(!distinct0.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_limit_dropWhile_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1, DoublePredicate arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			double t1 = arg0.applyAsDouble(t0);
			limit0++;
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_limit_takeWhile_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1, DoublePredicate arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			double t1 = arg0.applyAsDouble(t0);
			limit0++;
			if(!arg2.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_skip_map_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1, DoubleUnaryOperator arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			t1 = arg2.applyAsDouble(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_skip_filter_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1, DoublePredicate arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if (!arg2.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToDouble_skip_mapToInt_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1, DoubleToIntFunction arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			int t2 = arg2.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_mapToDouble_skip_mapToLong_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1, DoubleToLongFunction arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			long t2 = arg2.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_skip_sorted_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<Double> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (double t1: sorted0) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_skip_limit_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1, long arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			double t1 = arg0.applyAsDouble(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			limit0++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_skip_skip_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1, long arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			skip1++;
			if(skip1 <= arg2) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_skip_distinct_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<Double> distinct0 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if(!distinct0.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_skip_dropWhile_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1, DoublePredicate arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_skip_takeWhile_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1, DoublePredicate arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if(!arg2.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_distinct_map_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleUnaryOperator arg1) {
		Set<Double> distinct0 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			t1 = arg1.applyAsDouble(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_distinct_filter_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1) {
		Set<Double> distinct0 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			if (!arg1.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToDouble_distinct_mapToInt_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToIntFunction arg1) {
		Set<Double> distinct0 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			int t2 = arg1.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_mapToDouble_distinct_mapToLong_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToLongFunction arg1) {
		Set<Double> distinct0 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			long t2 = arg1.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_distinct_sorted_sum(Collection<T0> input, ToDoubleFunction<T0> arg0) {
		Set<Double> distinct0 = new HashSet<>();
		List<Double> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (double t1: sorted0) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_distinct_limit_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1) {
		Set<Double> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			double t1 = arg0.applyAsDouble(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			limit0++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_distinct_skip_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1) {
		Set<Double> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_distinct_distinct_sum(Collection<T0> input, ToDoubleFunction<T0> arg0) {
		Set<Double> distinct0 = new HashSet<>();
		Set<Double> distinct1 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			if(!distinct1.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_distinct_dropWhile_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1) {
		Set<Double> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_distinct_takeWhile_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1) {
		Set<Double> distinct0 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			if(!arg1.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_dropWhile_map_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1, DoubleUnaryOperator arg2) {
		boolean dropWhile0 = true;
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			t1 = arg2.applyAsDouble(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_dropWhile_filter_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1, DoublePredicate arg2) {
		boolean dropWhile0 = true;
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if (!arg2.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToDouble_dropWhile_mapToInt_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1, DoubleToIntFunction arg2) {
		boolean dropWhile0 = true;
		int sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			int t2 = arg2.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_mapToDouble_dropWhile_mapToLong_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1, DoubleToLongFunction arg2) {
		boolean dropWhile0 = true;
		long sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			long t2 = arg2.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_dropWhile_sorted_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1) {
		boolean dropWhile0 = true;
		List<Double> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (double t1: sorted0) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_dropWhile_limit_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1, long arg2) {
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			double t1 = arg0.applyAsDouble(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			limit0++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_dropWhile_skip_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1, long arg2) {
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_dropWhile_distinct_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1) {
		boolean dropWhile0 = true;
		Set<Double> distinct0 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!distinct0.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_dropWhile_dropWhile_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1, DoublePredicate arg2) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
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
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_dropWhile_takeWhile_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1, DoublePredicate arg2) {
		boolean dropWhile0 = true;
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!arg2.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_takeWhile_map_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1, DoubleUnaryOperator arg2) {
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			if(!arg1.test(t1)) {
				break;
			}
			t1 = arg2.applyAsDouble(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_takeWhile_filter_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1, DoublePredicate arg2) {
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			if(!arg1.test(t1)) {
				break;
			}
			if (!arg2.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_mapToDouble_takeWhile_mapToInt_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1, DoubleToIntFunction arg2) {
		int sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			if(!arg1.test(t1)) {
				break;
			}
			int t2 = arg2.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_mapToDouble_takeWhile_mapToLong_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1, DoubleToLongFunction arg2) {
		long sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			if(!arg1.test(t1)) {
				break;
			}
			long t2 = arg2.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_takeWhile_sorted_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1) {
		List<Double> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			if(!arg1.test(t1)) {
				break;
			}
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (double t1: sorted0) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_takeWhile_limit_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			double t1 = arg0.applyAsDouble(t0);
			if(!arg1.test(t1)) {
				break;
			}
			limit0++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_takeWhile_skip_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			if(!arg1.test(t1)) {
				break;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_takeWhile_distinct_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1) {
		Set<Double> distinct0 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			if(!arg1.test(t1)) {
				break;
			}
			if(!distinct0.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_takeWhile_dropWhile_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1, DoublePredicate arg2) {
		boolean dropWhile0 = true;
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			if(!arg1.test(t1)) {
				break;
			}
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_mapToDouble_takeWhile_takeWhile_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1, DoublePredicate arg2) {
		double sum = 0;
		for (T0 t0: input) {
			double t1 = arg0.applyAsDouble(t0);
			if(!arg1.test(t1)) {
				break;
			}
			if(!arg2.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0, T1> int stream_sorted_map_mapToInt_sum(Collection<T0> input, Function<T0, T1> arg0, ToIntFunction<T1> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			T1 t1 = arg0.apply(t0);
			int t2 = arg1.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> long stream_sorted_map_mapToLong_sum(Collection<T0> input, Function<T0, T1> arg0, ToLongFunction<T1> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			T1 t1 = arg0.apply(t0);
			long t2 = arg1.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> double stream_sorted_map_mapToDouble_sum(Collection<T0> input, Function<T0, T1> arg0, ToDoubleFunction<T1> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			T1 t1 = arg0.apply(t0);
			double t2 = arg1.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_sorted_filter_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if (!arg0.test(t0)) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_sorted_filter_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if (!arg0.test(t0)) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_sorted_filter_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if (!arg0.test(t0)) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_sorted_mapToInt_map_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntUnaryOperator arg1) {
		List<T0> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			int t1 = arg0.applyAsInt(t0);
			t1 = arg1.applyAsInt(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_sorted_mapToInt_filter_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1) {
		List<T0> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			int t1 = arg0.applyAsInt(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_sorted_mapToInt_mapToLong_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntToLongFunction arg1) {
		List<T0> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			int t1 = arg0.applyAsInt(t0);
			long t2 = arg1.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_sorted_mapToInt_mapToDouble_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntToDoubleFunction arg1) {
		List<T0> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			int t1 = arg0.applyAsInt(t0);
			double t2 = arg1.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_sorted_mapToInt_sorted_sum(Collection<T0> input, ToIntFunction<T0> arg0) {
		List<T0> sorted0 = new ArrayList<>();
		List<Integer> sorted1 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			int t1 = arg0.applyAsInt(t0);
			sorted1.add(t1);
		}
		sorted1.sort(null);
		for (int t1: sorted1) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_sorted_mapToInt_limit_sum(Collection<T0> input, ToIntFunction<T0> arg0, long arg1) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			int t1 = arg0.applyAsInt(t0);
			limit0++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_sorted_mapToInt_skip_sum(Collection<T0> input, ToIntFunction<T0> arg0, long arg1) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			int t1 = arg0.applyAsInt(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_sorted_mapToInt_distinct_sum(Collection<T0> input, ToIntFunction<T0> arg0) {
		List<T0> sorted0 = new ArrayList<>();
		Set<Integer> distinct0 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			int t1 = arg0.applyAsInt(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_sorted_mapToInt_dropWhile_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1) {
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		int sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			int t1 = arg0.applyAsInt(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_sorted_mapToInt_takeWhile_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1) {
		List<T0> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			int t1 = arg0.applyAsInt(t0);
			if(!arg1.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_sorted_mapToLong_map_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongUnaryOperator arg1) {
		List<T0> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			long t1 = arg0.applyAsLong(t0);
			t1 = arg1.applyAsLong(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_sorted_mapToLong_filter_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1) {
		List<T0> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			long t1 = arg0.applyAsLong(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_sorted_mapToLong_mapToInt_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongToIntFunction arg1) {
		List<T0> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			long t1 = arg0.applyAsLong(t0);
			int t2 = arg1.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_sorted_mapToLong_mapToDouble_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongToDoubleFunction arg1) {
		List<T0> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			long t1 = arg0.applyAsLong(t0);
			double t2 = arg1.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_sorted_mapToLong_sorted_sum(Collection<T0> input, ToLongFunction<T0> arg0) {
		List<T0> sorted0 = new ArrayList<>();
		List<Long> sorted1 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			long t1 = arg0.applyAsLong(t0);
			sorted1.add(t1);
		}
		sorted1.sort(null);
		for (long t1: sorted1) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_sorted_mapToLong_limit_sum(Collection<T0> input, ToLongFunction<T0> arg0, long arg1) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			long t1 = arg0.applyAsLong(t0);
			limit0++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_sorted_mapToLong_skip_sum(Collection<T0> input, ToLongFunction<T0> arg0, long arg1) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			long t1 = arg0.applyAsLong(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_sorted_mapToLong_distinct_sum(Collection<T0> input, ToLongFunction<T0> arg0) {
		List<T0> sorted0 = new ArrayList<>();
		Set<Long> distinct0 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			long t1 = arg0.applyAsLong(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_sorted_mapToLong_dropWhile_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1) {
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		long sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			long t1 = arg0.applyAsLong(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_sorted_mapToLong_takeWhile_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1) {
		List<T0> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			long t1 = arg0.applyAsLong(t0);
			if(!arg1.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_sorted_mapToDouble_map_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleUnaryOperator arg1) {
		List<T0> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			double t1 = arg0.applyAsDouble(t0);
			t1 = arg1.applyAsDouble(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_sorted_mapToDouble_filter_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1) {
		List<T0> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			double t1 = arg0.applyAsDouble(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_sorted_mapToDouble_mapToInt_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToIntFunction arg1) {
		List<T0> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			double t1 = arg0.applyAsDouble(t0);
			int t2 = arg1.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_sorted_mapToDouble_mapToLong_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToLongFunction arg1) {
		List<T0> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			double t1 = arg0.applyAsDouble(t0);
			long t2 = arg1.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_sorted_mapToDouble_sorted_sum(Collection<T0> input, ToDoubleFunction<T0> arg0) {
		List<T0> sorted0 = new ArrayList<>();
		List<Double> sorted1 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			double t1 = arg0.applyAsDouble(t0);
			sorted1.add(t1);
		}
		sorted1.sort(null);
		for (double t1: sorted1) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_sorted_mapToDouble_limit_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			double t1 = arg0.applyAsDouble(t0);
			limit0++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_sorted_mapToDouble_skip_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			double t1 = arg0.applyAsDouble(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_sorted_mapToDouble_distinct_sum(Collection<T0> input, ToDoubleFunction<T0> arg0) {
		List<T0> sorted0 = new ArrayList<>();
		Set<Double> distinct0 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			double t1 = arg0.applyAsDouble(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_sorted_mapToDouble_dropWhile_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1) {
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		double sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			double t1 = arg0.applyAsDouble(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_sorted_mapToDouble_takeWhile_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1) {
		List<T0> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			double t1 = arg0.applyAsDouble(t0);
			if(!arg1.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_sorted_sorted_mapToInt_sum(Collection<T0> input, ToIntFunction<T0> arg0) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			sorted1.add(t0);
		}
		sorted1.sort(null);
		for (T0 t0: sorted1) {
			int t1 = arg0.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_sorted_sorted_mapToLong_sum(Collection<T0> input, ToLongFunction<T0> arg0) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			sorted1.add(t0);
		}
		sorted1.sort(null);
		for (T0 t0: sorted1) {
			long t1 = arg0.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_sorted_sorted_mapToDouble_sum(Collection<T0> input, ToDoubleFunction<T0> arg0) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			sorted1.add(t0);
		}
		sorted1.sort(null);
		for (T0 t0: sorted1) {
			double t1 = arg0.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_sorted_sortedComp_mapToInt_sum(Collection<T0> input, Comparator<? super T0> arg0, ToIntFunction<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			int t1 = arg1.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_sorted_sortedComp_mapToLong_sum(Collection<T0> input, Comparator<? super T0> arg0, ToLongFunction<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			long t1 = arg1.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_sorted_sortedComp_mapToDouble_sum(Collection<T0> input, Comparator<? super T0> arg0, ToDoubleFunction<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			double t1 = arg1.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_sorted_limit_mapToInt_sum(Collection<T0> input, long arg0, ToIntFunction<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			limit0++;
			int t1 = arg1.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_sorted_limit_mapToLong_sum(Collection<T0> input, long arg0, ToLongFunction<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			limit0++;
			long t1 = arg1.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_sorted_limit_mapToDouble_sum(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			limit0++;
			double t1 = arg1.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_sorted_skip_mapToInt_sum(Collection<T0> input, long arg0, ToIntFunction<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_sorted_skip_mapToLong_sum(Collection<T0> input, long arg0, ToLongFunction<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_sorted_skip_mapToDouble_sum(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_sorted_distinct_mapToInt_sum(Collection<T0> input, ToIntFunction<T0> arg0) {
		List<T0> sorted0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			int t1 = arg0.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_sorted_distinct_mapToLong_sum(Collection<T0> input, ToLongFunction<T0> arg0) {
		List<T0> sorted0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			long t1 = arg0.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_sorted_distinct_mapToDouble_sum(Collection<T0> input, ToDoubleFunction<T0> arg0) {
		List<T0> sorted0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			double t1 = arg0.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_sorted_dropWhile_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		int sum = 0;
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
			int t1 = arg1.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_sorted_dropWhile_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		long sum = 0;
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
			long t1 = arg1.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_sorted_dropWhile_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		double sum = 0;
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
			double t1 = arg1.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_sorted_takeWhile_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(!arg0.test(t0)) {
				break;
			}
			int t1 = arg1.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_sorted_takeWhile_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(!arg0.test(t0)) {
				break;
			}
			long t1 = arg1.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_sorted_takeWhile_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			if(!arg0.test(t0)) {
				break;
			}
			double t1 = arg1.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0, T1> int stream_sorted_flatMapLambda_mapToInt_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToIntFunction<T1> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			for (T1 t1 : arg0.apply(t0)) {
				int t2 = arg1.applyAsInt(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> long stream_sorted_flatMapLambda_mapToLong_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToLongFunction<T1> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			for (T1 t1 : arg0.apply(t0)) {
				long t2 = arg1.applyAsLong(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> double stream_sorted_flatMapLambda_mapToDouble_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToDoubleFunction<T1> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			for (T1 t1 : arg0.apply(t0)) {
				double t2 = arg1.applyAsDouble(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> int stream_sorted_flatMapMemberReference_mapToInt_sum(Collection<T0> input, ToIntFunction<T1> arg0) {
		List<T0> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			for (T1 t1 : t0) {
				int t2 = arg0.applyAsInt(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> long stream_sorted_flatMapMemberReference_mapToLong_sum(Collection<T0> input, ToLongFunction<T1> arg0) {
		List<T0> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			for (T1 t1 : t0) {
				long t2 = arg0.applyAsLong(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> double stream_sorted_flatMapMemberReference_mapToDouble_sum(Collection<T0> input, ToDoubleFunction<T1> arg0) {
		List<T0> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			for (T1 t1 : t0) {
				double t2 = arg0.applyAsDouble(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> int stream_sortedComp_map_mapToInt_sum(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, T1> arg1, ToIntFunction<T1> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
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
		for (T0 t0: input) {
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
		for (T0 t0: input) {
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
		for (T0 t0: input) {
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
		for (T0 t0: input) {
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
		for (T0 t0: input) {
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
		for (T0 t0: input) {
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
		for (T0 t0: input) {
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
		for (T0 t0: input) {
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
		for (T0 t0: input) {
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

	public static <T0> int stream_sortedComp_mapToInt_sorted_sum(Collection<T0> input, Comparator<? super T0> arg0, ToIntFunction<T0> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<Integer> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			int t1 = arg1.applyAsInt(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (int t1: sorted0) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_sortedComp_mapToInt_limit_sum(Collection<T0> input, Comparator<? super T0> arg0, ToIntFunction<T0> arg1, long arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			int t1 = arg1.applyAsInt(t0);
			limit0++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_sortedComp_mapToInt_skip_sum(Collection<T0> input, Comparator<? super T0> arg0, ToIntFunction<T0> arg1, long arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			int t1 = arg1.applyAsInt(t0);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_sortedComp_mapToInt_distinct_sum(Collection<T0> input, Comparator<? super T0> arg0, ToIntFunction<T0> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		Set<Integer> distinct0 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			int t1 = arg1.applyAsInt(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_sortedComp_mapToInt_dropWhile_sum(Collection<T0> input, Comparator<? super T0> arg0, ToIntFunction<T0> arg1, IntPredicate arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		int sum = 0;
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			int t1 = arg1.applyAsInt(t0);
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_sortedComp_mapToInt_takeWhile_sum(Collection<T0> input, Comparator<? super T0> arg0, ToIntFunction<T0> arg1, IntPredicate arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			int t1 = arg1.applyAsInt(t0);
			if(!arg2.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_sortedComp_mapToLong_map_sum(Collection<T0> input, Comparator<? super T0> arg0, ToLongFunction<T0> arg1, LongUnaryOperator arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
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
		for (T0 t0: input) {
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
		for (T0 t0: input) {
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
		for (T0 t0: input) {
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

	public static <T0> long stream_sortedComp_mapToLong_sorted_sum(Collection<T0> input, Comparator<? super T0> arg0, ToLongFunction<T0> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<Long> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			long t1 = arg1.applyAsLong(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (long t1: sorted0) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_sortedComp_mapToLong_limit_sum(Collection<T0> input, Comparator<? super T0> arg0, ToLongFunction<T0> arg1, long arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			long t1 = arg1.applyAsLong(t0);
			limit0++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_sortedComp_mapToLong_skip_sum(Collection<T0> input, Comparator<? super T0> arg0, ToLongFunction<T0> arg1, long arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			long t1 = arg1.applyAsLong(t0);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_sortedComp_mapToLong_distinct_sum(Collection<T0> input, Comparator<? super T0> arg0, ToLongFunction<T0> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		Set<Long> distinct0 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			long t1 = arg1.applyAsLong(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_sortedComp_mapToLong_dropWhile_sum(Collection<T0> input, Comparator<? super T0> arg0, ToLongFunction<T0> arg1, LongPredicate arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		long sum = 0;
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			long t1 = arg1.applyAsLong(t0);
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_sortedComp_mapToLong_takeWhile_sum(Collection<T0> input, Comparator<? super T0> arg0, ToLongFunction<T0> arg1, LongPredicate arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			long t1 = arg1.applyAsLong(t0);
			if(!arg2.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_sortedComp_mapToDouble_map_sum(Collection<T0> input, Comparator<? super T0> arg0, ToDoubleFunction<T0> arg1, DoubleUnaryOperator arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
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
		for (T0 t0: input) {
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
		for (T0 t0: input) {
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
		for (T0 t0: input) {
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

	public static <T0> double stream_sortedComp_mapToDouble_sorted_sum(Collection<T0> input, Comparator<? super T0> arg0, ToDoubleFunction<T0> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<Double> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			double t1 = arg1.applyAsDouble(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (double t1: sorted0) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_sortedComp_mapToDouble_limit_sum(Collection<T0> input, Comparator<? super T0> arg0, ToDoubleFunction<T0> arg1, long arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			double t1 = arg1.applyAsDouble(t0);
			limit0++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_sortedComp_mapToDouble_skip_sum(Collection<T0> input, Comparator<? super T0> arg0, ToDoubleFunction<T0> arg1, long arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			double t1 = arg1.applyAsDouble(t0);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_sortedComp_mapToDouble_distinct_sum(Collection<T0> input, Comparator<? super T0> arg0, ToDoubleFunction<T0> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		Set<Double> distinct0 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			double t1 = arg1.applyAsDouble(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_sortedComp_mapToDouble_dropWhile_sum(Collection<T0> input, Comparator<? super T0> arg0, ToDoubleFunction<T0> arg1, DoublePredicate arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		double sum = 0;
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			double t1 = arg1.applyAsDouble(t0);
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_sortedComp_mapToDouble_takeWhile_sum(Collection<T0> input, Comparator<? super T0> arg0, ToDoubleFunction<T0> arg1, DoublePredicate arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			double t1 = arg1.applyAsDouble(t0);
			if(!arg2.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_sortedComp_sorted_mapToInt_sum(Collection<T0> input, Comparator<? super T0> arg0, ToIntFunction<T0> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			int t1 = arg1.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_sortedComp_sorted_mapToLong_sum(Collection<T0> input, Comparator<? super T0> arg0, ToLongFunction<T0> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			long t1 = arg1.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_sortedComp_sorted_mapToDouble_sum(Collection<T0> input, Comparator<? super T0> arg0, ToDoubleFunction<T0> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			double t1 = arg1.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_sortedComp_sortedComp_mapToInt_sum(Collection<T0> input, Comparator<? super T0> arg0, Comparator<? super T0> arg1, ToIntFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
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
		for (T0 t0: input) {
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
		for (T0 t0: input) {
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

	public static <T0> int stream_sortedComp_limit_mapToInt_sum(Collection<T0> input, Comparator<? super T0> arg0, long arg1, ToIntFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			limit0++;
			int t1 = arg2.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_sortedComp_limit_mapToLong_sum(Collection<T0> input, Comparator<? super T0> arg0, long arg1, ToLongFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			limit0++;
			long t1 = arg2.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_sortedComp_limit_mapToDouble_sum(Collection<T0> input, Comparator<? super T0> arg0, long arg1, ToDoubleFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			limit0++;
			double t1 = arg2.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_sortedComp_skip_mapToInt_sum(Collection<T0> input, Comparator<? super T0> arg0, long arg1, ToIntFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			int t1 = arg2.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_sortedComp_skip_mapToLong_sum(Collection<T0> input, Comparator<? super T0> arg0, long arg1, ToLongFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			long t1 = arg2.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_sortedComp_skip_mapToDouble_sum(Collection<T0> input, Comparator<? super T0> arg0, long arg1, ToDoubleFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			double t1 = arg2.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_sortedComp_distinct_mapToInt_sum(Collection<T0> input, Comparator<? super T0> arg0, ToIntFunction<T0> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_sortedComp_distinct_mapToLong_sum(Collection<T0> input, Comparator<? super T0> arg0, ToLongFunction<T0> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_sortedComp_distinct_mapToDouble_sum(Collection<T0> input, Comparator<? super T0> arg0, ToDoubleFunction<T0> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_sortedComp_dropWhile_mapToInt_sum(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, ToIntFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		int sum = 0;
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
			int t1 = arg2.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_sortedComp_dropWhile_mapToLong_sum(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, ToLongFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		long sum = 0;
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
			long t1 = arg2.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_sortedComp_dropWhile_mapToDouble_sum(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, ToDoubleFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		double sum = 0;
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
			double t1 = arg2.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_sortedComp_takeWhile_mapToInt_sum(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, ToIntFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!arg1.test(t0)) {
				break;
			}
			int t1 = arg2.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_sortedComp_takeWhile_mapToLong_sum(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, ToLongFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!arg1.test(t0)) {
				break;
			}
			long t1 = arg2.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_sortedComp_takeWhile_mapToDouble_sum(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, ToDoubleFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!arg1.test(t0)) {
				break;
			}
			double t1 = arg2.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0, T1> int stream_sortedComp_flatMapLambda_mapToInt_sum(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, Collection<T1>> arg1, ToIntFunction<T1> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : arg1.apply(t0)) {
				int t2 = arg2.applyAsInt(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> long stream_sortedComp_flatMapLambda_mapToLong_sum(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, Collection<T1>> arg1, ToLongFunction<T1> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : arg1.apply(t0)) {
				long t2 = arg2.applyAsLong(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> double stream_sortedComp_flatMapLambda_mapToDouble_sum(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, Collection<T1>> arg1, ToDoubleFunction<T1> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : arg1.apply(t0)) {
				double t2 = arg2.applyAsDouble(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> int stream_sortedComp_flatMapMemberReference_mapToInt_sum(Collection<T0> input, Comparator<? super T0> arg0, ToIntFunction<T1> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : t0) {
				int t2 = arg1.applyAsInt(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> long stream_sortedComp_flatMapMemberReference_mapToLong_sum(Collection<T0> input, Comparator<? super T0> arg0, ToLongFunction<T1> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : t0) {
				long t2 = arg1.applyAsLong(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> double stream_sortedComp_flatMapMemberReference_mapToDouble_sum(Collection<T0> input, Comparator<? super T0> arg0, ToDoubleFunction<T1> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : t0) {
				double t2 = arg1.applyAsDouble(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> int stream_limit_map_mapToInt_sum(Collection<T0> input, long arg0, Function<T0, T1> arg1, ToIntFunction<T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			T1 t1 = arg1.apply(t0);
			int t2 = arg2.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> long stream_limit_map_mapToLong_sum(Collection<T0> input, long arg0, Function<T0, T1> arg1, ToLongFunction<T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			T1 t1 = arg1.apply(t0);
			long t2 = arg2.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> double stream_limit_map_mapToDouble_sum(Collection<T0> input, long arg0, Function<T0, T1> arg1, ToDoubleFunction<T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			T1 t1 = arg1.apply(t0);
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_limit_filter_mapToInt_sum(Collection<T0> input, long arg0, Predicate<T0> arg1, ToIntFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if (!arg1.test(t0)) {
				continue;
			}
			int t1 = arg2.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_limit_filter_mapToLong_sum(Collection<T0> input, long arg0, Predicate<T0> arg1, ToLongFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if (!arg1.test(t0)) {
				continue;
			}
			long t1 = arg2.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_limit_filter_mapToDouble_sum(Collection<T0> input, long arg0, Predicate<T0> arg1, ToDoubleFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if (!arg1.test(t0)) {
				continue;
			}
			double t1 = arg2.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_limit_mapToInt_map_sum(Collection<T0> input, long arg0, ToIntFunction<T0> arg1, IntUnaryOperator arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			int t1 = arg1.applyAsInt(t0);
			t1 = arg2.applyAsInt(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_limit_mapToInt_filter_sum(Collection<T0> input, long arg0, ToIntFunction<T0> arg1, IntPredicate arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			int t1 = arg1.applyAsInt(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_limit_mapToInt_mapToLong_sum(Collection<T0> input, long arg0, ToIntFunction<T0> arg1, IntToLongFunction arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			int t1 = arg1.applyAsInt(t0);
			long t2 = arg2.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_limit_mapToInt_mapToDouble_sum(Collection<T0> input, long arg0, ToIntFunction<T0> arg1, IntToDoubleFunction arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			int t1 = arg1.applyAsInt(t0);
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_limit_mapToInt_sorted_sum(Collection<T0> input, long arg0, ToIntFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<Integer> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			int t1 = arg1.applyAsInt(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (int t1: sorted0) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_limit_mapToInt_limit_sum(Collection<T0> input, long arg0, ToIntFunction<T0> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(limit1 >= arg2) {
				break;
			}
			limit0++;
			int t1 = arg1.applyAsInt(t0);
			limit1++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_limit_mapToInt_skip_sum(Collection<T0> input, long arg0, ToIntFunction<T0> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			int t1 = arg1.applyAsInt(t0);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_limit_mapToInt_distinct_sum(Collection<T0> input, long arg0, ToIntFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<Integer> distinct0 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			int t1 = arg1.applyAsInt(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_limit_mapToInt_dropWhile_sum(Collection<T0> input, long arg0, ToIntFunction<T0> arg1, IntPredicate arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			int t1 = arg1.applyAsInt(t0);
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_limit_mapToInt_takeWhile_sum(Collection<T0> input, long arg0, ToIntFunction<T0> arg1, IntPredicate arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			int t1 = arg1.applyAsInt(t0);
			if(!arg2.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_limit_mapToLong_map_sum(Collection<T0> input, long arg0, ToLongFunction<T0> arg1, LongUnaryOperator arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			long t1 = arg1.applyAsLong(t0);
			t1 = arg2.applyAsLong(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_limit_mapToLong_filter_sum(Collection<T0> input, long arg0, ToLongFunction<T0> arg1, LongPredicate arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			long t1 = arg1.applyAsLong(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_limit_mapToLong_mapToInt_sum(Collection<T0> input, long arg0, ToLongFunction<T0> arg1, LongToIntFunction arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			long t1 = arg1.applyAsLong(t0);
			int t2 = arg2.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_limit_mapToLong_mapToDouble_sum(Collection<T0> input, long arg0, ToLongFunction<T0> arg1, LongToDoubleFunction arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			long t1 = arg1.applyAsLong(t0);
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_limit_mapToLong_sorted_sum(Collection<T0> input, long arg0, ToLongFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<Long> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			long t1 = arg1.applyAsLong(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (long t1: sorted0) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_limit_mapToLong_limit_sum(Collection<T0> input, long arg0, ToLongFunction<T0> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(limit1 >= arg2) {
				break;
			}
			limit0++;
			long t1 = arg1.applyAsLong(t0);
			limit1++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_limit_mapToLong_skip_sum(Collection<T0> input, long arg0, ToLongFunction<T0> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			long t1 = arg1.applyAsLong(t0);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_limit_mapToLong_distinct_sum(Collection<T0> input, long arg0, ToLongFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<Long> distinct0 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			long t1 = arg1.applyAsLong(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_limit_mapToLong_dropWhile_sum(Collection<T0> input, long arg0, ToLongFunction<T0> arg1, LongPredicate arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			long t1 = arg1.applyAsLong(t0);
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_limit_mapToLong_takeWhile_sum(Collection<T0> input, long arg0, ToLongFunction<T0> arg1, LongPredicate arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			long t1 = arg1.applyAsLong(t0);
			if(!arg2.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_limit_mapToDouble_map_sum(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1, DoubleUnaryOperator arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			double t1 = arg1.applyAsDouble(t0);
			t1 = arg2.applyAsDouble(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_limit_mapToDouble_filter_sum(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1, DoublePredicate arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			double t1 = arg1.applyAsDouble(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_limit_mapToDouble_mapToInt_sum(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1, DoubleToIntFunction arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			double t1 = arg1.applyAsDouble(t0);
			int t2 = arg2.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_limit_mapToDouble_mapToLong_sum(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1, DoubleToLongFunction arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			double t1 = arg1.applyAsDouble(t0);
			long t2 = arg2.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_limit_mapToDouble_sorted_sum(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<Double> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			double t1 = arg1.applyAsDouble(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (double t1: sorted0) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_limit_mapToDouble_limit_sum(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(limit1 >= arg2) {
				break;
			}
			limit0++;
			double t1 = arg1.applyAsDouble(t0);
			limit1++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_limit_mapToDouble_skip_sum(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			double t1 = arg1.applyAsDouble(t0);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_limit_mapToDouble_distinct_sum(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<Double> distinct0 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			double t1 = arg1.applyAsDouble(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_limit_mapToDouble_dropWhile_sum(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1, DoublePredicate arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			double t1 = arg1.applyAsDouble(t0);
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_limit_mapToDouble_takeWhile_sum(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1, DoublePredicate arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			double t1 = arg1.applyAsDouble(t0);
			if(!arg2.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_limit_sorted_mapToInt_sum(Collection<T0> input, long arg0, ToIntFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			int t1 = arg1.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_limit_sorted_mapToLong_sum(Collection<T0> input, long arg0, ToLongFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			long t1 = arg1.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_limit_sorted_mapToDouble_sum(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			double t1 = arg1.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_limit_sortedComp_mapToInt_sum(Collection<T0> input, long arg0, Comparator<? super T0> arg1, ToIntFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			int t1 = arg2.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_limit_sortedComp_mapToLong_sum(Collection<T0> input, long arg0, Comparator<? super T0> arg1, ToLongFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			long t1 = arg2.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_limit_sortedComp_mapToDouble_sum(Collection<T0> input, long arg0, Comparator<? super T0> arg1, ToDoubleFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			double t1 = arg2.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_limit_limit_mapToInt_sum(Collection<T0> input, long arg0, long arg1, ToIntFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(limit1 >= arg1) {
				break;
			}
			limit0++;
			limit1++;
			int t1 = arg2.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_limit_limit_mapToLong_sum(Collection<T0> input, long arg0, long arg1, ToLongFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(limit1 >= arg1) {
				break;
			}
			limit0++;
			limit1++;
			long t1 = arg2.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_limit_limit_mapToDouble_sum(Collection<T0> input, long arg0, long arg1, ToDoubleFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(limit1 >= arg1) {
				break;
			}
			limit0++;
			limit1++;
			double t1 = arg2.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_limit_skip_mapToInt_sum(Collection<T0> input, long arg0, long arg1, ToIntFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			int t1 = arg2.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_limit_skip_mapToLong_sum(Collection<T0> input, long arg0, long arg1, ToLongFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			long t1 = arg2.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_limit_skip_mapToDouble_sum(Collection<T0> input, long arg0, long arg1, ToDoubleFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			double t1 = arg2.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_limit_distinct_mapToInt_sum(Collection<T0> input, long arg0, ToIntFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if(!distinct0.add(t0)) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_limit_distinct_mapToLong_sum(Collection<T0> input, long arg0, ToLongFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if(!distinct0.add(t0)) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_limit_distinct_mapToDouble_sum(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if(!distinct0.add(t0)) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_limit_dropWhile_mapToInt_sum(Collection<T0> input, long arg0, Predicate<T0> arg1, ToIntFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		int sum = 0;
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
			int t1 = arg2.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_limit_dropWhile_mapToLong_sum(Collection<T0> input, long arg0, Predicate<T0> arg1, ToLongFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		long sum = 0;
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
			long t1 = arg2.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_limit_dropWhile_mapToDouble_sum(Collection<T0> input, long arg0, Predicate<T0> arg1, ToDoubleFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		double sum = 0;
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
			double t1 = arg2.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_limit_takeWhile_mapToInt_sum(Collection<T0> input, long arg0, Predicate<T0> arg1, ToIntFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if(!arg1.test(t0)) {
				break;
			}
			int t1 = arg2.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_limit_takeWhile_mapToLong_sum(Collection<T0> input, long arg0, Predicate<T0> arg1, ToLongFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if(!arg1.test(t0)) {
				break;
			}
			long t1 = arg2.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_limit_takeWhile_mapToDouble_sum(Collection<T0> input, long arg0, Predicate<T0> arg1, ToDoubleFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			if(!arg1.test(t0)) {
				break;
			}
			double t1 = arg2.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0, T1> int stream_limit_flatMapLambda_mapToInt_sum(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, ToIntFunction<T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			for (T1 t1 : arg1.apply(t0)) {
				int t2 = arg2.applyAsInt(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> long stream_limit_flatMapLambda_mapToLong_sum(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, ToLongFunction<T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			for (T1 t1 : arg1.apply(t0)) {
				long t2 = arg2.applyAsLong(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> double stream_limit_flatMapLambda_mapToDouble_sum(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, ToDoubleFunction<T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			for (T1 t1 : arg1.apply(t0)) {
				double t2 = arg2.applyAsDouble(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> int stream_limit_flatMapMemberReference_mapToInt_sum(Collection<T0> input, long arg0, ToIntFunction<T1> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			for (T1 t1 : t0) {
				int t2 = arg1.applyAsInt(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> long stream_limit_flatMapMemberReference_mapToLong_sum(Collection<T0> input, long arg0, ToLongFunction<T1> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			for (T1 t1 : t0) {
				long t2 = arg1.applyAsLong(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> double stream_limit_flatMapMemberReference_mapToDouble_sum(Collection<T0> input, long arg0, ToDoubleFunction<T1> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			limit0++;
			for (T1 t1 : t0) {
				double t2 = arg1.applyAsDouble(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> int stream_skip_map_mapToInt_sum(Collection<T0> input, long arg0, Function<T0, T1> arg1, ToIntFunction<T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			int t2 = arg2.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> long stream_skip_map_mapToLong_sum(Collection<T0> input, long arg0, Function<T0, T1> arg1, ToLongFunction<T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			long t2 = arg2.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> double stream_skip_map_mapToDouble_sum(Collection<T0> input, long arg0, Function<T0, T1> arg1, ToDoubleFunction<T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_skip_filter_mapToInt_sum(Collection<T0> input, long arg0, Predicate<T0> arg1, ToIntFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
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

	public static <T0> long stream_skip_filter_mapToLong_sum(Collection<T0> input, long arg0, Predicate<T0> arg1, ToLongFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
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

	public static <T0> double stream_skip_filter_mapToDouble_sum(Collection<T0> input, long arg0, Predicate<T0> arg1, ToDoubleFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
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

	public static <T0> int stream_skip_mapToInt_map_sum(Collection<T0> input, long arg0, ToIntFunction<T0> arg1, IntUnaryOperator arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			t1 = arg2.applyAsInt(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_skip_mapToInt_filter_sum(Collection<T0> input, long arg0, ToIntFunction<T0> arg1, IntPredicate arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
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

	public static <T0> long stream_skip_mapToInt_mapToLong_sum(Collection<T0> input, long arg0, ToIntFunction<T0> arg1, IntToLongFunction arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			long t2 = arg2.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_skip_mapToInt_mapToDouble_sum(Collection<T0> input, long arg0, ToIntFunction<T0> arg1, IntToDoubleFunction arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_skip_mapToInt_sorted_sum(Collection<T0> input, long arg0, ToIntFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<Integer> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (int t1: sorted0) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_skip_mapToInt_limit_sum(Collection<T0> input, long arg0, ToIntFunction<T0> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			limit0++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_skip_mapToInt_skip_sum(Collection<T0> input, long arg0, ToIntFunction<T0> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		int sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			skip1++;
			if(skip1 <= arg2) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_skip_mapToInt_distinct_sum(Collection<T0> input, long arg0, ToIntFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<Integer> distinct0 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_skip_mapToInt_dropWhile_sum(Collection<T0> input, long arg0, ToIntFunction<T0> arg1, IntPredicate arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		int sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_skip_mapToInt_takeWhile_sum(Collection<T0> input, long arg0, ToIntFunction<T0> arg1, IntPredicate arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			if(!arg2.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_skip_mapToLong_map_sum(Collection<T0> input, long arg0, ToLongFunction<T0> arg1, LongUnaryOperator arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			t1 = arg2.applyAsLong(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_skip_mapToLong_filter_sum(Collection<T0> input, long arg0, ToLongFunction<T0> arg1, LongPredicate arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
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

	public static <T0> int stream_skip_mapToLong_mapToInt_sum(Collection<T0> input, long arg0, ToLongFunction<T0> arg1, LongToIntFunction arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			int t2 = arg2.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_skip_mapToLong_mapToDouble_sum(Collection<T0> input, long arg0, ToLongFunction<T0> arg1, LongToDoubleFunction arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_skip_mapToLong_sorted_sum(Collection<T0> input, long arg0, ToLongFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<Long> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (long t1: sorted0) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_skip_mapToLong_limit_sum(Collection<T0> input, long arg0, ToLongFunction<T0> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			limit0++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_skip_mapToLong_skip_sum(Collection<T0> input, long arg0, ToLongFunction<T0> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		long sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			skip1++;
			if(skip1 <= arg2) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_skip_mapToLong_distinct_sum(Collection<T0> input, long arg0, ToLongFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<Long> distinct0 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_skip_mapToLong_dropWhile_sum(Collection<T0> input, long arg0, ToLongFunction<T0> arg1, LongPredicate arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		long sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_skip_mapToLong_takeWhile_sum(Collection<T0> input, long arg0, ToLongFunction<T0> arg1, LongPredicate arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			if(!arg2.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_skip_mapToDouble_map_sum(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1, DoubleUnaryOperator arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			t1 = arg2.applyAsDouble(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_skip_mapToDouble_filter_sum(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1, DoublePredicate arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
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

	public static <T0> int stream_skip_mapToDouble_mapToInt_sum(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1, DoubleToIntFunction arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			int t2 = arg2.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_skip_mapToDouble_mapToLong_sum(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1, DoubleToLongFunction arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			long t2 = arg2.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_skip_mapToDouble_sorted_sum(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<Double> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (double t1: sorted0) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_skip_mapToDouble_limit_sum(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			limit0++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_skip_mapToDouble_skip_sum(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		double sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			skip1++;
			if(skip1 <= arg2) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_skip_mapToDouble_distinct_sum(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<Double> distinct0 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_skip_mapToDouble_dropWhile_sum(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1, DoublePredicate arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		double sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_skip_mapToDouble_takeWhile_sum(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1, DoublePredicate arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			if(!arg2.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_skip_sorted_mapToInt_sum(Collection<T0> input, long arg0, ToIntFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			int t1 = arg1.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_skip_sorted_mapToLong_sum(Collection<T0> input, long arg0, ToLongFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			long t1 = arg1.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_skip_sorted_mapToDouble_sum(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			double t1 = arg1.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_skip_sortedComp_mapToInt_sum(Collection<T0> input, long arg0, Comparator<? super T0> arg1, ToIntFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
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

	public static <T0> long stream_skip_sortedComp_mapToLong_sum(Collection<T0> input, long arg0, Comparator<? super T0> arg1, ToLongFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
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

	public static <T0> double stream_skip_sortedComp_mapToDouble_sum(Collection<T0> input, long arg0, Comparator<? super T0> arg1, ToDoubleFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
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

	public static <T0> int stream_skip_limit_mapToInt_sum(Collection<T0> input, long arg0, long arg1, ToIntFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			limit0++;
			int t1 = arg2.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_skip_limit_mapToLong_sum(Collection<T0> input, long arg0, long arg1, ToLongFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			limit0++;
			long t1 = arg2.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_skip_limit_mapToDouble_sum(Collection<T0> input, long arg0, long arg1, ToDoubleFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			limit0++;
			double t1 = arg2.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_skip_skip_mapToInt_sum(Collection<T0> input, long arg0, long arg1, ToIntFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		int sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			skip1++;
			if(skip1 <= arg1) {
				continue;
			}
			int t1 = arg2.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_skip_skip_mapToLong_sum(Collection<T0> input, long arg0, long arg1, ToLongFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		long sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			skip1++;
			if(skip1 <= arg1) {
				continue;
			}
			long t1 = arg2.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_skip_skip_mapToDouble_sum(Collection<T0> input, long arg0, long arg1, ToDoubleFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		double sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			skip1++;
			if(skip1 <= arg1) {
				continue;
			}
			double t1 = arg2.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_skip_distinct_mapToInt_sum(Collection<T0> input, long arg0, ToIntFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_skip_distinct_mapToLong_sum(Collection<T0> input, long arg0, ToLongFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_skip_distinct_mapToDouble_sum(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_skip_dropWhile_mapToInt_sum(Collection<T0> input, long arg0, Predicate<T0> arg1, ToIntFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		int sum = 0;
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
			int t1 = arg2.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_skip_dropWhile_mapToLong_sum(Collection<T0> input, long arg0, Predicate<T0> arg1, ToLongFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		long sum = 0;
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
			long t1 = arg2.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_skip_dropWhile_mapToDouble_sum(Collection<T0> input, long arg0, Predicate<T0> arg1, ToDoubleFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		double sum = 0;
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
			double t1 = arg2.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_skip_takeWhile_mapToInt_sum(Collection<T0> input, long arg0, Predicate<T0> arg1, ToIntFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			int t1 = arg2.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_skip_takeWhile_mapToLong_sum(Collection<T0> input, long arg0, Predicate<T0> arg1, ToLongFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			long t1 = arg2.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_skip_takeWhile_mapToDouble_sum(Collection<T0> input, long arg0, Predicate<T0> arg1, ToDoubleFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			double t1 = arg2.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0, T1> int stream_skip_flatMapLambda_mapToInt_sum(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, ToIntFunction<T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				int t2 = arg2.applyAsInt(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> long stream_skip_flatMapLambda_mapToLong_sum(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, ToLongFunction<T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				long t2 = arg2.applyAsLong(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> double stream_skip_flatMapLambda_mapToDouble_sum(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, ToDoubleFunction<T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				double t2 = arg2.applyAsDouble(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> int stream_skip_flatMapMemberReference_mapToInt_sum(Collection<T0> input, long arg0, ToIntFunction<T1> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			for (T1 t1 : t0) {
				int t2 = arg1.applyAsInt(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> long stream_skip_flatMapMemberReference_mapToLong_sum(Collection<T0> input, long arg0, ToLongFunction<T1> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			for (T1 t1 : t0) {
				long t2 = arg1.applyAsLong(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> double stream_skip_flatMapMemberReference_mapToDouble_sum(Collection<T0> input, long arg0, ToDoubleFunction<T1> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			for (T1 t1 : t0) {
				double t2 = arg1.applyAsDouble(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> int stream_distinct_map_mapToInt_sum(Collection<T0> input, Function<T0, T1> arg0, ToIntFunction<T1> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			T1 t1 = arg0.apply(t0);
			int t2 = arg1.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> long stream_distinct_map_mapToLong_sum(Collection<T0> input, Function<T0, T1> arg0, ToLongFunction<T1> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			T1 t1 = arg0.apply(t0);
			long t2 = arg1.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> double stream_distinct_map_mapToDouble_sum(Collection<T0> input, Function<T0, T1> arg0, ToDoubleFunction<T1> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			T1 t1 = arg0.apply(t0);
			double t2 = arg1.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_distinct_filter_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if (!arg0.test(t0)) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_distinct_filter_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if (!arg0.test(t0)) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_distinct_filter_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if (!arg0.test(t0)) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_distinct_mapToInt_map_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntUnaryOperator arg1) {
		Set<T0> distinct0 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			int t1 = arg0.applyAsInt(t0);
			t1 = arg1.applyAsInt(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_distinct_mapToInt_filter_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1) {
		Set<T0> distinct0 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			int t1 = arg0.applyAsInt(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_distinct_mapToInt_mapToLong_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntToLongFunction arg1) {
		Set<T0> distinct0 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			int t1 = arg0.applyAsInt(t0);
			long t2 = arg1.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_distinct_mapToInt_mapToDouble_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntToDoubleFunction arg1) {
		Set<T0> distinct0 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			int t1 = arg0.applyAsInt(t0);
			double t2 = arg1.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_distinct_mapToInt_sorted_sum(Collection<T0> input, ToIntFunction<T0> arg0) {
		Set<T0> distinct0 = new HashSet<>();
		List<Integer> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			int t1 = arg0.applyAsInt(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (int t1: sorted0) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_distinct_mapToInt_limit_sum(Collection<T0> input, ToIntFunction<T0> arg0, long arg1) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			int t1 = arg0.applyAsInt(t0);
			limit0++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_distinct_mapToInt_skip_sum(Collection<T0> input, ToIntFunction<T0> arg0, long arg1) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			int t1 = arg0.applyAsInt(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_distinct_mapToInt_distinct_sum(Collection<T0> input, ToIntFunction<T0> arg0) {
		Set<T0> distinct0 = new HashSet<>();
		Set<Integer> distinct1 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			int t1 = arg0.applyAsInt(t0);
			if(!distinct1.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_distinct_mapToInt_dropWhile_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1) {
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		int sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			int t1 = arg0.applyAsInt(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_distinct_mapToInt_takeWhile_sum(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1) {
		Set<T0> distinct0 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			int t1 = arg0.applyAsInt(t0);
			if(!arg1.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_distinct_mapToLong_map_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongUnaryOperator arg1) {
		Set<T0> distinct0 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			long t1 = arg0.applyAsLong(t0);
			t1 = arg1.applyAsLong(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_distinct_mapToLong_filter_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1) {
		Set<T0> distinct0 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			long t1 = arg0.applyAsLong(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_distinct_mapToLong_mapToInt_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongToIntFunction arg1) {
		Set<T0> distinct0 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			long t1 = arg0.applyAsLong(t0);
			int t2 = arg1.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_distinct_mapToLong_mapToDouble_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongToDoubleFunction arg1) {
		Set<T0> distinct0 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			long t1 = arg0.applyAsLong(t0);
			double t2 = arg1.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_distinct_mapToLong_sorted_sum(Collection<T0> input, ToLongFunction<T0> arg0) {
		Set<T0> distinct0 = new HashSet<>();
		List<Long> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			long t1 = arg0.applyAsLong(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (long t1: sorted0) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_distinct_mapToLong_limit_sum(Collection<T0> input, ToLongFunction<T0> arg0, long arg1) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			long t1 = arg0.applyAsLong(t0);
			limit0++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_distinct_mapToLong_skip_sum(Collection<T0> input, ToLongFunction<T0> arg0, long arg1) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			long t1 = arg0.applyAsLong(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_distinct_mapToLong_distinct_sum(Collection<T0> input, ToLongFunction<T0> arg0) {
		Set<T0> distinct0 = new HashSet<>();
		Set<Long> distinct1 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			long t1 = arg0.applyAsLong(t0);
			if(!distinct1.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_distinct_mapToLong_dropWhile_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1) {
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		long sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			long t1 = arg0.applyAsLong(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_distinct_mapToLong_takeWhile_sum(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1) {
		Set<T0> distinct0 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			long t1 = arg0.applyAsLong(t0);
			if(!arg1.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_distinct_mapToDouble_map_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleUnaryOperator arg1) {
		Set<T0> distinct0 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			double t1 = arg0.applyAsDouble(t0);
			t1 = arg1.applyAsDouble(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_distinct_mapToDouble_filter_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1) {
		Set<T0> distinct0 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			double t1 = arg0.applyAsDouble(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_distinct_mapToDouble_mapToInt_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToIntFunction arg1) {
		Set<T0> distinct0 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			double t1 = arg0.applyAsDouble(t0);
			int t2 = arg1.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_distinct_mapToDouble_mapToLong_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToLongFunction arg1) {
		Set<T0> distinct0 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			double t1 = arg0.applyAsDouble(t0);
			long t2 = arg1.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_distinct_mapToDouble_sorted_sum(Collection<T0> input, ToDoubleFunction<T0> arg0) {
		Set<T0> distinct0 = new HashSet<>();
		List<Double> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			double t1 = arg0.applyAsDouble(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (double t1: sorted0) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_distinct_mapToDouble_limit_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			double t1 = arg0.applyAsDouble(t0);
			limit0++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_distinct_mapToDouble_skip_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			double t1 = arg0.applyAsDouble(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_distinct_mapToDouble_distinct_sum(Collection<T0> input, ToDoubleFunction<T0> arg0) {
		Set<T0> distinct0 = new HashSet<>();
		Set<Double> distinct1 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			double t1 = arg0.applyAsDouble(t0);
			if(!distinct1.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_distinct_mapToDouble_dropWhile_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1) {
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		double sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			double t1 = arg0.applyAsDouble(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_distinct_mapToDouble_takeWhile_sum(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1) {
		Set<T0> distinct0 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			double t1 = arg0.applyAsDouble(t0);
			if(!arg1.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_distinct_sorted_mapToInt_sum(Collection<T0> input, ToIntFunction<T0> arg0) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			int t1 = arg0.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_distinct_sorted_mapToLong_sum(Collection<T0> input, ToLongFunction<T0> arg0) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			long t1 = arg0.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_distinct_sorted_mapToDouble_sum(Collection<T0> input, ToDoubleFunction<T0> arg0) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			double t1 = arg0.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_distinct_sortedComp_mapToInt_sum(Collection<T0> input, Comparator<? super T0> arg0, ToIntFunction<T0> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sortedComp0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			int t1 = arg1.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_distinct_sortedComp_mapToLong_sum(Collection<T0> input, Comparator<? super T0> arg0, ToLongFunction<T0> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sortedComp0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			long t1 = arg1.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_distinct_sortedComp_mapToDouble_sum(Collection<T0> input, Comparator<? super T0> arg0, ToDoubleFunction<T0> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sortedComp0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			double t1 = arg1.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_distinct_limit_mapToInt_sum(Collection<T0> input, long arg0, ToIntFunction<T0> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			limit0++;
			int t1 = arg1.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_distinct_limit_mapToLong_sum(Collection<T0> input, long arg0, ToLongFunction<T0> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			limit0++;
			long t1 = arg1.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_distinct_limit_mapToDouble_sum(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			limit0++;
			double t1 = arg1.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_distinct_skip_mapToInt_sum(Collection<T0> input, long arg0, ToIntFunction<T0> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_distinct_skip_mapToLong_sum(Collection<T0> input, long arg0, ToLongFunction<T0> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_distinct_skip_mapToDouble_sum(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_distinct_distinct_mapToInt_sum(Collection<T0> input, ToIntFunction<T0> arg0) {
		Set<T0> distinct0 = new HashSet<>();
		Set<T0> distinct1 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!distinct1.add(t0)) {
				continue;
			}
			int t1 = arg0.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_distinct_distinct_mapToLong_sum(Collection<T0> input, ToLongFunction<T0> arg0) {
		Set<T0> distinct0 = new HashSet<>();
		Set<T0> distinct1 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!distinct1.add(t0)) {
				continue;
			}
			long t1 = arg0.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_distinct_distinct_mapToDouble_sum(Collection<T0> input, ToDoubleFunction<T0> arg0) {
		Set<T0> distinct0 = new HashSet<>();
		Set<T0> distinct1 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!distinct1.add(t0)) {
				continue;
			}
			double t1 = arg0.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_distinct_dropWhile_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		int sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			int t1 = arg1.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_distinct_dropWhile_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		long sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			long t1 = arg1.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_distinct_dropWhile_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		double sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			double t1 = arg1.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_distinct_takeWhile_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!arg0.test(t0)) {
				break;
			}
			int t1 = arg1.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_distinct_takeWhile_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!arg0.test(t0)) {
				break;
			}
			long t1 = arg1.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_distinct_takeWhile_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!arg0.test(t0)) {
				break;
			}
			double t1 = arg1.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0, T1> int stream_distinct_flatMapLambda_mapToInt_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToIntFunction<T1> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : arg0.apply(t0)) {
				int t2 = arg1.applyAsInt(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> long stream_distinct_flatMapLambda_mapToLong_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToLongFunction<T1> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : arg0.apply(t0)) {
				long t2 = arg1.applyAsLong(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> double stream_distinct_flatMapLambda_mapToDouble_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToDoubleFunction<T1> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : arg0.apply(t0)) {
				double t2 = arg1.applyAsDouble(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> int stream_distinct_flatMapMemberReference_mapToInt_sum(Collection<T0> input, ToIntFunction<T1> arg0) {
		Set<T0> distinct0 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : t0) {
				int t2 = arg0.applyAsInt(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> long stream_distinct_flatMapMemberReference_mapToLong_sum(Collection<T0> input, ToLongFunction<T1> arg0) {
		Set<T0> distinct0 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : t0) {
				long t2 = arg0.applyAsLong(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> double stream_distinct_flatMapMemberReference_mapToDouble_sum(Collection<T0> input, ToDoubleFunction<T1> arg0) {
		Set<T0> distinct0 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : t0) {
				double t2 = arg0.applyAsDouble(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> int stream_dropWhile_map_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, ToIntFunction<T1> arg2) {
		boolean dropWhile0 = true;
		int sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			T1 t1 = arg1.apply(t0);
			int t2 = arg2.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> long stream_dropWhile_map_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, ToLongFunction<T1> arg2) {
		boolean dropWhile0 = true;
		long sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			T1 t1 = arg1.apply(t0);
			long t2 = arg2.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> double stream_dropWhile_map_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, ToDoubleFunction<T1> arg2) {
		boolean dropWhile0 = true;
		double sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			T1 t1 = arg1.apply(t0);
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_dropWhile_filter_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, ToIntFunction<T0> arg2) {
		boolean dropWhile0 = true;
		int sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			int t1 = arg2.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_dropWhile_filter_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, ToLongFunction<T0> arg2) {
		boolean dropWhile0 = true;
		long sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			long t1 = arg2.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_dropWhile_filter_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, ToDoubleFunction<T0> arg2) {
		boolean dropWhile0 = true;
		double sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			double t1 = arg2.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_dropWhile_mapToInt_map_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1, IntUnaryOperator arg2) {
		boolean dropWhile0 = true;
		int sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			int t1 = arg1.applyAsInt(t0);
			t1 = arg2.applyAsInt(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_dropWhile_mapToInt_filter_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1, IntPredicate arg2) {
		boolean dropWhile0 = true;
		int sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			int t1 = arg1.applyAsInt(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_dropWhile_mapToInt_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1, IntToLongFunction arg2) {
		boolean dropWhile0 = true;
		long sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			int t1 = arg1.applyAsInt(t0);
			long t2 = arg2.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_dropWhile_mapToInt_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1, IntToDoubleFunction arg2) {
		boolean dropWhile0 = true;
		double sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			int t1 = arg1.applyAsInt(t0);
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_dropWhile_mapToInt_sorted_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1) {
		boolean dropWhile0 = true;
		List<Integer> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			int t1 = arg1.applyAsInt(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (int t1: sorted0) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_dropWhile_mapToInt_limit_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1, long arg2) {
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			int t1 = arg1.applyAsInt(t0);
			limit0++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_dropWhile_mapToInt_skip_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1, long arg2) {
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			int t1 = arg1.applyAsInt(t0);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_dropWhile_mapToInt_distinct_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1) {
		boolean dropWhile0 = true;
		Set<Integer> distinct0 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			int t1 = arg1.applyAsInt(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_dropWhile_mapToInt_dropWhile_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1, IntPredicate arg2) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		int sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			int t1 = arg1.applyAsInt(t0);
			if(dropWhile1 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile1 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_dropWhile_mapToInt_takeWhile_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1, IntPredicate arg2) {
		boolean dropWhile0 = true;
		int sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			int t1 = arg1.applyAsInt(t0);
			if(!arg2.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_dropWhile_mapToLong_map_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1, LongUnaryOperator arg2) {
		boolean dropWhile0 = true;
		long sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			long t1 = arg1.applyAsLong(t0);
			t1 = arg2.applyAsLong(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_dropWhile_mapToLong_filter_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1, LongPredicate arg2) {
		boolean dropWhile0 = true;
		long sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			long t1 = arg1.applyAsLong(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_dropWhile_mapToLong_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1, LongToIntFunction arg2) {
		boolean dropWhile0 = true;
		int sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			long t1 = arg1.applyAsLong(t0);
			int t2 = arg2.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_dropWhile_mapToLong_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1, LongToDoubleFunction arg2) {
		boolean dropWhile0 = true;
		double sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			long t1 = arg1.applyAsLong(t0);
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_dropWhile_mapToLong_sorted_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1) {
		boolean dropWhile0 = true;
		List<Long> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			long t1 = arg1.applyAsLong(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (long t1: sorted0) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_dropWhile_mapToLong_limit_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1, long arg2) {
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			long t1 = arg1.applyAsLong(t0);
			limit0++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_dropWhile_mapToLong_skip_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1, long arg2) {
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			long t1 = arg1.applyAsLong(t0);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_dropWhile_mapToLong_distinct_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1) {
		boolean dropWhile0 = true;
		Set<Long> distinct0 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			long t1 = arg1.applyAsLong(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_dropWhile_mapToLong_dropWhile_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1, LongPredicate arg2) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		long sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			long t1 = arg1.applyAsLong(t0);
			if(dropWhile1 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile1 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_dropWhile_mapToLong_takeWhile_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1, LongPredicate arg2) {
		boolean dropWhile0 = true;
		long sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			long t1 = arg1.applyAsLong(t0);
			if(!arg2.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_dropWhile_mapToDouble_map_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1, DoubleUnaryOperator arg2) {
		boolean dropWhile0 = true;
		double sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			double t1 = arg1.applyAsDouble(t0);
			t1 = arg2.applyAsDouble(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_dropWhile_mapToDouble_filter_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1, DoublePredicate arg2) {
		boolean dropWhile0 = true;
		double sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			double t1 = arg1.applyAsDouble(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_dropWhile_mapToDouble_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1, DoubleToIntFunction arg2) {
		boolean dropWhile0 = true;
		int sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			double t1 = arg1.applyAsDouble(t0);
			int t2 = arg2.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_dropWhile_mapToDouble_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1, DoubleToLongFunction arg2) {
		boolean dropWhile0 = true;
		long sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			double t1 = arg1.applyAsDouble(t0);
			long t2 = arg2.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_dropWhile_mapToDouble_sorted_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1) {
		boolean dropWhile0 = true;
		List<Double> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			double t1 = arg1.applyAsDouble(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (double t1: sorted0) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_dropWhile_mapToDouble_limit_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1, long arg2) {
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			double t1 = arg1.applyAsDouble(t0);
			limit0++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_dropWhile_mapToDouble_skip_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1, long arg2) {
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			double t1 = arg1.applyAsDouble(t0);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_dropWhile_mapToDouble_distinct_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1) {
		boolean dropWhile0 = true;
		Set<Double> distinct0 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			double t1 = arg1.applyAsDouble(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_dropWhile_mapToDouble_dropWhile_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1, DoublePredicate arg2) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		double sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			double t1 = arg1.applyAsDouble(t0);
			if(dropWhile1 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile1 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_dropWhile_mapToDouble_takeWhile_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1, DoublePredicate arg2) {
		boolean dropWhile0 = true;
		double sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			double t1 = arg1.applyAsDouble(t0);
			if(!arg2.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_dropWhile_sorted_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1) {
		boolean dropWhile0 = true;
		List<T0> sorted0 = new ArrayList<>();
		int sum = 0;
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
			int t1 = arg1.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_dropWhile_sorted_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1) {
		boolean dropWhile0 = true;
		List<T0> sorted0 = new ArrayList<>();
		long sum = 0;
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
			long t1 = arg1.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_dropWhile_sorted_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1) {
		boolean dropWhile0 = true;
		List<T0> sorted0 = new ArrayList<>();
		double sum = 0;
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
			double t1 = arg1.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_dropWhile_sortedComp_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, ToIntFunction<T0> arg2) {
		boolean dropWhile0 = true;
		List<T0> sortedComp0 = new ArrayList<>();
		int sum = 0;
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
			int t1 = arg2.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_dropWhile_sortedComp_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, ToLongFunction<T0> arg2) {
		boolean dropWhile0 = true;
		List<T0> sortedComp0 = new ArrayList<>();
		long sum = 0;
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
			long t1 = arg2.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_dropWhile_sortedComp_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, ToDoubleFunction<T0> arg2) {
		boolean dropWhile0 = true;
		List<T0> sortedComp0 = new ArrayList<>();
		double sum = 0;
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
			double t1 = arg2.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_dropWhile_limit_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, long arg1, ToIntFunction<T0> arg2) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int sum = 0;
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
			int t1 = arg2.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_dropWhile_limit_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, long arg1, ToLongFunction<T0> arg2) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long sum = 0;
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
			long t1 = arg2.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_dropWhile_limit_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, long arg1, ToDoubleFunction<T0> arg2) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double sum = 0;
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
			double t1 = arg2.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_dropWhile_skip_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, long arg1, ToIntFunction<T0> arg2) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int sum = 0;
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
			int t1 = arg2.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_dropWhile_skip_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, long arg1, ToLongFunction<T0> arg2) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long sum = 0;
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
			long t1 = arg2.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_dropWhile_skip_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, long arg1, ToDoubleFunction<T0> arg2) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double sum = 0;
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
			double t1 = arg2.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_dropWhile_distinct_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1) {
		boolean dropWhile0 = true;
		Set<T0> distinct0 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_dropWhile_distinct_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1) {
		boolean dropWhile0 = true;
		Set<T0> distinct0 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_dropWhile_distinct_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1) {
		boolean dropWhile0 = true;
		Set<T0> distinct0 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_dropWhile_dropWhile_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, ToIntFunction<T0> arg2) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		int sum = 0;
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
			int t1 = arg2.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_dropWhile_dropWhile_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, ToLongFunction<T0> arg2) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		long sum = 0;
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
			long t1 = arg2.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_dropWhile_dropWhile_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, ToDoubleFunction<T0> arg2) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		double sum = 0;
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
			double t1 = arg2.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_dropWhile_takeWhile_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, ToIntFunction<T0> arg2) {
		boolean dropWhile0 = true;
		int sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!arg1.test(t0)) {
				break;
			}
			int t1 = arg2.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_dropWhile_takeWhile_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, ToLongFunction<T0> arg2) {
		boolean dropWhile0 = true;
		long sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!arg1.test(t0)) {
				break;
			}
			long t1 = arg2.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_dropWhile_takeWhile_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, ToDoubleFunction<T0> arg2) {
		boolean dropWhile0 = true;
		double sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!arg1.test(t0)) {
				break;
			}
			double t1 = arg2.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0, T1> int stream_dropWhile_flatMapLambda_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, ToIntFunction<T1> arg2) {
		boolean dropWhile0 = true;
		int sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : arg1.apply(t0)) {
				int t2 = arg2.applyAsInt(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> long stream_dropWhile_flatMapLambda_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, ToLongFunction<T1> arg2) {
		boolean dropWhile0 = true;
		long sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : arg1.apply(t0)) {
				long t2 = arg2.applyAsLong(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> double stream_dropWhile_flatMapLambda_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, ToDoubleFunction<T1> arg2) {
		boolean dropWhile0 = true;
		double sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : arg1.apply(t0)) {
				double t2 = arg2.applyAsDouble(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> int stream_dropWhile_flatMapMemberReference_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T1> arg1) {
		boolean dropWhile0 = true;
		int sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : t0) {
				int t2 = arg1.applyAsInt(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> long stream_dropWhile_flatMapMemberReference_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T1> arg1) {
		boolean dropWhile0 = true;
		long sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : t0) {
				long t2 = arg1.applyAsLong(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> double stream_dropWhile_flatMapMemberReference_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T1> arg1) {
		boolean dropWhile0 = true;
		double sum = 0;
		for (T0 t0: input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : t0) {
				double t2 = arg1.applyAsDouble(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> int stream_takeWhile_map_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, ToIntFunction<T1> arg2) {
		int sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			T1 t1 = arg1.apply(t0);
			int t2 = arg2.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> long stream_takeWhile_map_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, ToLongFunction<T1> arg2) {
		long sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			T1 t1 = arg1.apply(t0);
			long t2 = arg2.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> double stream_takeWhile_map_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, ToDoubleFunction<T1> arg2) {
		double sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			T1 t1 = arg1.apply(t0);
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_takeWhile_filter_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, ToIntFunction<T0> arg2) {
		int sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			int t1 = arg2.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_takeWhile_filter_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, ToLongFunction<T0> arg2) {
		long sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			long t1 = arg2.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_takeWhile_filter_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, ToDoubleFunction<T0> arg2) {
		double sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			double t1 = arg2.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_takeWhile_mapToInt_map_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1, IntUnaryOperator arg2) {
		int sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			int t1 = arg1.applyAsInt(t0);
			t1 = arg2.applyAsInt(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_takeWhile_mapToInt_filter_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1, IntPredicate arg2) {
		int sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			int t1 = arg1.applyAsInt(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_takeWhile_mapToInt_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1, IntToLongFunction arg2) {
		long sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			int t1 = arg1.applyAsInt(t0);
			long t2 = arg2.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_takeWhile_mapToInt_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1, IntToDoubleFunction arg2) {
		double sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			int t1 = arg1.applyAsInt(t0);
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> int stream_takeWhile_mapToInt_sorted_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1) {
		List<Integer> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			int t1 = arg1.applyAsInt(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (int t1: sorted0) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_takeWhile_mapToInt_limit_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			if(!arg0.test(t0)) {
				break;
			}
			int t1 = arg1.applyAsInt(t0);
			limit0++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_takeWhile_mapToInt_skip_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			int t1 = arg1.applyAsInt(t0);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_takeWhile_mapToInt_distinct_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1) {
		Set<Integer> distinct0 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			int t1 = arg1.applyAsInt(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_takeWhile_mapToInt_dropWhile_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1, IntPredicate arg2) {
		boolean dropWhile0 = true;
		int sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			int t1 = arg1.applyAsInt(t0);
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_takeWhile_mapToInt_takeWhile_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1, IntPredicate arg2) {
		int sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			int t1 = arg1.applyAsInt(t0);
			if(!arg2.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_takeWhile_mapToLong_map_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1, LongUnaryOperator arg2) {
		long sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			long t1 = arg1.applyAsLong(t0);
			t1 = arg2.applyAsLong(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_takeWhile_mapToLong_filter_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1, LongPredicate arg2) {
		long sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			long t1 = arg1.applyAsLong(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_takeWhile_mapToLong_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1, LongToIntFunction arg2) {
		int sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			long t1 = arg1.applyAsLong(t0);
			int t2 = arg2.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_takeWhile_mapToLong_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1, LongToDoubleFunction arg2) {
		double sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			long t1 = arg1.applyAsLong(t0);
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_takeWhile_mapToLong_sorted_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1) {
		List<Long> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			long t1 = arg1.applyAsLong(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (long t1: sorted0) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_takeWhile_mapToLong_limit_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			if(!arg0.test(t0)) {
				break;
			}
			long t1 = arg1.applyAsLong(t0);
			limit0++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_takeWhile_mapToLong_skip_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			long t1 = arg1.applyAsLong(t0);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_takeWhile_mapToLong_distinct_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1) {
		Set<Long> distinct0 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			long t1 = arg1.applyAsLong(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_takeWhile_mapToLong_dropWhile_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1, LongPredicate arg2) {
		boolean dropWhile0 = true;
		long sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			long t1 = arg1.applyAsLong(t0);
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_takeWhile_mapToLong_takeWhile_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1, LongPredicate arg2) {
		long sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			long t1 = arg1.applyAsLong(t0);
			if(!arg2.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_takeWhile_mapToDouble_map_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1, DoubleUnaryOperator arg2) {
		double sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			double t1 = arg1.applyAsDouble(t0);
			t1 = arg2.applyAsDouble(t1);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_takeWhile_mapToDouble_filter_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1, DoublePredicate arg2) {
		double sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			double t1 = arg1.applyAsDouble(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_takeWhile_mapToDouble_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1, DoubleToIntFunction arg2) {
		int sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			double t1 = arg1.applyAsDouble(t0);
			int t2 = arg2.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> long stream_takeWhile_mapToDouble_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1, DoubleToLongFunction arg2) {
		long sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			double t1 = arg1.applyAsDouble(t0);
			long t2 = arg2.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0> double stream_takeWhile_mapToDouble_sorted_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1) {
		List<Double> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			double t1 = arg1.applyAsDouble(t0);
			sorted0.add(t1);
		}
		sorted0.sort(null);
		for (double t1: sorted0) {
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_takeWhile_mapToDouble_limit_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			if(!arg0.test(t0)) {
				break;
			}
			double t1 = arg1.applyAsDouble(t0);
			limit0++;
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_takeWhile_mapToDouble_skip_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			double t1 = arg1.applyAsDouble(t0);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_takeWhile_mapToDouble_distinct_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1) {
		Set<Double> distinct0 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			double t1 = arg1.applyAsDouble(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_takeWhile_mapToDouble_dropWhile_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1, DoublePredicate arg2) {
		boolean dropWhile0 = true;
		double sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			double t1 = arg1.applyAsDouble(t0);
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_takeWhile_mapToDouble_takeWhile_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1, DoublePredicate arg2) {
		double sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			double t1 = arg1.applyAsDouble(t0);
			if(!arg2.test(t1)) {
				break;
			}
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_takeWhile_sorted_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			int t1 = arg1.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_takeWhile_sorted_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			long t1 = arg1.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_takeWhile_sorted_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			sorted0.add(t0);
		}
		sorted0.sort(null);
		for (T0 t0: sorted0) {
			double t1 = arg1.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_takeWhile_sortedComp_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, ToIntFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
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

	public static <T0> long stream_takeWhile_sortedComp_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, ToLongFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
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

	public static <T0> double stream_takeWhile_sortedComp_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, ToDoubleFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
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

	public static <T0> int stream_takeWhile_limit_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, long arg1, ToIntFunction<T0> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(!arg0.test(t0)) {
				break;
			}
			limit0++;
			int t1 = arg2.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_takeWhile_limit_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, long arg1, ToLongFunction<T0> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(!arg0.test(t0)) {
				break;
			}
			limit0++;
			long t1 = arg2.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_takeWhile_limit_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, long arg1, ToDoubleFunction<T0> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			if(!arg0.test(t0)) {
				break;
			}
			limit0++;
			double t1 = arg2.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_takeWhile_skip_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, long arg1, ToIntFunction<T0> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			int t1 = arg2.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_takeWhile_skip_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, long arg1, ToLongFunction<T0> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			long t1 = arg2.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_takeWhile_skip_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, long arg1, ToDoubleFunction<T0> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			double t1 = arg2.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_takeWhile_distinct_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_takeWhile_distinct_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_takeWhile_distinct_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_takeWhile_dropWhile_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, ToIntFunction<T0> arg2) {
		boolean dropWhile0 = true;
		int sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			int t1 = arg2.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_takeWhile_dropWhile_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, ToLongFunction<T0> arg2) {
		boolean dropWhile0 = true;
		long sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			long t1 = arg2.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_takeWhile_dropWhile_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, ToDoubleFunction<T0> arg2) {
		boolean dropWhile0 = true;
		double sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			double t1 = arg2.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> int stream_takeWhile_takeWhile_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, ToIntFunction<T0> arg2) {
		int sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!arg1.test(t0)) {
				break;
			}
			int t1 = arg2.applyAsInt(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> long stream_takeWhile_takeWhile_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, ToLongFunction<T0> arg2) {
		long sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!arg1.test(t0)) {
				break;
			}
			long t1 = arg2.applyAsLong(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0> double stream_takeWhile_takeWhile_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, ToDoubleFunction<T0> arg2) {
		double sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!arg1.test(t0)) {
				break;
			}
			double t1 = arg2.applyAsDouble(t0);
			sum += t1;
		}
		return sum;
	}

	public static <T0, T1> int stream_takeWhile_flatMapLambda_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, ToIntFunction<T1> arg2) {
		int sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			for (T1 t1 : arg1.apply(t0)) {
				int t2 = arg2.applyAsInt(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> long stream_takeWhile_flatMapLambda_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, ToLongFunction<T1> arg2) {
		long sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			for (T1 t1 : arg1.apply(t0)) {
				long t2 = arg2.applyAsLong(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> double stream_takeWhile_flatMapLambda_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, ToDoubleFunction<T1> arg2) {
		double sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			for (T1 t1 : arg1.apply(t0)) {
				double t2 = arg2.applyAsDouble(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> int stream_takeWhile_flatMapMemberReference_mapToInt_sum(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T1> arg1) {
		int sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			for (T1 t1 : t0) {
				int t2 = arg1.applyAsInt(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> long stream_takeWhile_flatMapMemberReference_mapToLong_sum(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T1> arg1) {
		long sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			for (T1 t1 : t0) {
				long t2 = arg1.applyAsLong(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> double stream_takeWhile_flatMapMemberReference_mapToDouble_sum(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T1> arg1) {
		double sum = 0;
		for (T0 t0: input) {
			if(!arg0.test(t0)) {
				break;
			}
			for (T1 t1 : t0) {
				double t2 = arg1.applyAsDouble(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1, T2> int stream_flatMapLambda_map_mapToInt_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, T2> arg1, ToIntFunction<T2> arg2) {
		int sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				T2 t2 = arg1.apply(t1);
				int t3 = arg2.applyAsInt(t2);
				sum += t3;
			}
		}
		return sum;
	}

	public static <T0, T1, T2> long stream_flatMapLambda_map_mapToLong_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, T2> arg1, ToLongFunction<T2> arg2) {
		long sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				T2 t2 = arg1.apply(t1);
				long t3 = arg2.applyAsLong(t2);
				sum += t3;
			}
		}
		return sum;
	}

	public static <T0, T1, T2> double stream_flatMapLambda_map_mapToDouble_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, T2> arg1, ToDoubleFunction<T2> arg2) {
		double sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				T2 t2 = arg1.apply(t1);
				double t3 = arg2.applyAsDouble(t2);
				sum += t3;
			}
		}
		return sum;
	}

	public static <T0, T1> int stream_flatMapLambda_filter_mapToInt_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, ToIntFunction<T1> arg2) {
		int sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if (!arg1.test(t1)) {
					continue;
				}
				int t2 = arg2.applyAsInt(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> long stream_flatMapLambda_filter_mapToLong_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, ToLongFunction<T1> arg2) {
		long sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if (!arg1.test(t1)) {
					continue;
				}
				long t2 = arg2.applyAsLong(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> double stream_flatMapLambda_filter_mapToDouble_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, ToDoubleFunction<T1> arg2) {
		double sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if (!arg1.test(t1)) {
					continue;
				}
				double t2 = arg2.applyAsDouble(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> int stream_flatMapLambda_mapToInt_map_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToIntFunction<T1> arg1, IntUnaryOperator arg2) {
		int sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				int t2 = arg1.applyAsInt(t1);
				t2 = arg2.applyAsInt(t2);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> int stream_flatMapLambda_mapToInt_filter_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToIntFunction<T1> arg1, IntPredicate arg2) {
		int sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				int t2 = arg1.applyAsInt(t1);
				if (!arg2.test(t2)) {
					continue;
				}
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> long stream_flatMapLambda_mapToInt_mapToLong_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToIntFunction<T1> arg1, IntToLongFunction arg2) {
		long sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				int t2 = arg1.applyAsInt(t1);
				long t3 = arg2.applyAsLong(t2);
				sum += t3;
			}
		}
		return sum;
	}

	public static <T0, T1> double stream_flatMapLambda_mapToInt_mapToDouble_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToIntFunction<T1> arg1, IntToDoubleFunction arg2) {
		double sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				int t2 = arg1.applyAsInt(t1);
				double t3 = arg2.applyAsDouble(t2);
				sum += t3;
			}
		}
		return sum;
	}

	public static <T0, T1> int stream_flatMapLambda_mapToInt_sorted_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToIntFunction<T1> arg1) {
		List<Integer> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				int t2 = arg1.applyAsInt(t1);
				sorted0.add(t2);
			}
		}
		sorted0.sort(null);
		for (int t2: sorted0) {
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> int stream_flatMapLambda_mapToInt_limit_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToIntFunction<T1> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			for (T1 t1 : arg0.apply(t0)) {
				int t2 = arg1.applyAsInt(t1);
				limit0++;
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> int stream_flatMapLambda_mapToInt_skip_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToIntFunction<T1> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				int t2 = arg1.applyAsInt(t1);
				skip0++;
				if(skip0 <= arg2) {
					continue;
				}
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> int stream_flatMapLambda_mapToInt_distinct_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToIntFunction<T1> arg1) {
		Set<Integer> distinct0 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				int t2 = arg1.applyAsInt(t1);
				if(!distinct0.add(t2)) {
					continue;
				}
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> int stream_flatMapLambda_mapToInt_dropWhile_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToIntFunction<T1> arg1, IntPredicate arg2) {
		boolean dropWhile0 = true;
		int sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				int t2 = arg1.applyAsInt(t1);
				if(dropWhile0 && arg2.test(t2)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> int stream_flatMapLambda_mapToInt_takeWhile_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToIntFunction<T1> arg1, IntPredicate arg2) {
		int sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				int t2 = arg1.applyAsInt(t1);
				if(!arg2.test(t2)) {
					break;
				}
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> long stream_flatMapLambda_mapToLong_map_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToLongFunction<T1> arg1, LongUnaryOperator arg2) {
		long sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				long t2 = arg1.applyAsLong(t1);
				t2 = arg2.applyAsLong(t2);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> long stream_flatMapLambda_mapToLong_filter_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToLongFunction<T1> arg1, LongPredicate arg2) {
		long sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				long t2 = arg1.applyAsLong(t1);
				if (!arg2.test(t2)) {
					continue;
				}
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> int stream_flatMapLambda_mapToLong_mapToInt_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToLongFunction<T1> arg1, LongToIntFunction arg2) {
		int sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				long t2 = arg1.applyAsLong(t1);
				int t3 = arg2.applyAsInt(t2);
				sum += t3;
			}
		}
		return sum;
	}

	public static <T0, T1> double stream_flatMapLambda_mapToLong_mapToDouble_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToLongFunction<T1> arg1, LongToDoubleFunction arg2) {
		double sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				long t2 = arg1.applyAsLong(t1);
				double t3 = arg2.applyAsDouble(t2);
				sum += t3;
			}
		}
		return sum;
	}

	public static <T0, T1> long stream_flatMapLambda_mapToLong_sorted_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToLongFunction<T1> arg1) {
		List<Long> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				long t2 = arg1.applyAsLong(t1);
				sorted0.add(t2);
			}
		}
		sorted0.sort(null);
		for (long t2: sorted0) {
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> long stream_flatMapLambda_mapToLong_limit_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToLongFunction<T1> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			for (T1 t1 : arg0.apply(t0)) {
				long t2 = arg1.applyAsLong(t1);
				limit0++;
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> long stream_flatMapLambda_mapToLong_skip_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToLongFunction<T1> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				long t2 = arg1.applyAsLong(t1);
				skip0++;
				if(skip0 <= arg2) {
					continue;
				}
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> long stream_flatMapLambda_mapToLong_distinct_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToLongFunction<T1> arg1) {
		Set<Long> distinct0 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				long t2 = arg1.applyAsLong(t1);
				if(!distinct0.add(t2)) {
					continue;
				}
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> long stream_flatMapLambda_mapToLong_dropWhile_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToLongFunction<T1> arg1, LongPredicate arg2) {
		boolean dropWhile0 = true;
		long sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				long t2 = arg1.applyAsLong(t1);
				if(dropWhile0 && arg2.test(t2)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> long stream_flatMapLambda_mapToLong_takeWhile_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToLongFunction<T1> arg1, LongPredicate arg2) {
		long sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				long t2 = arg1.applyAsLong(t1);
				if(!arg2.test(t2)) {
					break;
				}
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> double stream_flatMapLambda_mapToDouble_map_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToDoubleFunction<T1> arg1, DoubleUnaryOperator arg2) {
		double sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				double t2 = arg1.applyAsDouble(t1);
				t2 = arg2.applyAsDouble(t2);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> double stream_flatMapLambda_mapToDouble_filter_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToDoubleFunction<T1> arg1, DoublePredicate arg2) {
		double sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				double t2 = arg1.applyAsDouble(t1);
				if (!arg2.test(t2)) {
					continue;
				}
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> int stream_flatMapLambda_mapToDouble_mapToInt_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToDoubleFunction<T1> arg1, DoubleToIntFunction arg2) {
		int sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				double t2 = arg1.applyAsDouble(t1);
				int t3 = arg2.applyAsInt(t2);
				sum += t3;
			}
		}
		return sum;
	}

	public static <T0, T1> long stream_flatMapLambda_mapToDouble_mapToLong_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToDoubleFunction<T1> arg1, DoubleToLongFunction arg2) {
		long sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				double t2 = arg1.applyAsDouble(t1);
				long t3 = arg2.applyAsLong(t2);
				sum += t3;
			}
		}
		return sum;
	}

	public static <T0, T1> double stream_flatMapLambda_mapToDouble_sorted_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToDoubleFunction<T1> arg1) {
		List<Double> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				double t2 = arg1.applyAsDouble(t1);
				sorted0.add(t2);
			}
		}
		sorted0.sort(null);
		for (double t2: sorted0) {
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> double stream_flatMapLambda_mapToDouble_limit_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToDoubleFunction<T1> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg2) {
				break;
			}
			for (T1 t1 : arg0.apply(t0)) {
				double t2 = arg1.applyAsDouble(t1);
				limit0++;
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> double stream_flatMapLambda_mapToDouble_skip_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToDoubleFunction<T1> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				double t2 = arg1.applyAsDouble(t1);
				skip0++;
				if(skip0 <= arg2) {
					continue;
				}
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> double stream_flatMapLambda_mapToDouble_distinct_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToDoubleFunction<T1> arg1) {
		Set<Double> distinct0 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				double t2 = arg1.applyAsDouble(t1);
				if(!distinct0.add(t2)) {
					continue;
				}
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> double stream_flatMapLambda_mapToDouble_dropWhile_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToDoubleFunction<T1> arg1, DoublePredicate arg2) {
		boolean dropWhile0 = true;
		double sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				double t2 = arg1.applyAsDouble(t1);
				if(dropWhile0 && arg2.test(t2)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> double stream_flatMapLambda_mapToDouble_takeWhile_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToDoubleFunction<T1> arg1, DoublePredicate arg2) {
		double sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				double t2 = arg1.applyAsDouble(t1);
				if(!arg2.test(t2)) {
					break;
				}
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> int stream_flatMapLambda_sorted_mapToInt_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToIntFunction<T1> arg1) {
		List<T1> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			int t2 = arg1.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> long stream_flatMapLambda_sorted_mapToLong_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToLongFunction<T1> arg1) {
		List<T1> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			long t2 = arg1.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> double stream_flatMapLambda_sorted_mapToDouble_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToDoubleFunction<T1> arg1) {
		List<T1> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			double t2 = arg1.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> int stream_flatMapLambda_sortedComp_mapToInt_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, Comparator<? super T1> arg1, ToIntFunction<T1> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			int t2 = arg2.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> long stream_flatMapLambda_sortedComp_mapToLong_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, Comparator<? super T1> arg1, ToLongFunction<T1> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			long t2 = arg2.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> double stream_flatMapLambda_sortedComp_mapToDouble_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, Comparator<? super T1> arg1, ToDoubleFunction<T1> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			double t2 = arg2.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0, T1> int stream_flatMapLambda_limit_mapToInt_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, ToIntFunction<T1> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			for (T1 t1 : arg0.apply(t0)) {
				limit0++;
				int t2 = arg2.applyAsInt(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> long stream_flatMapLambda_limit_mapToLong_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, ToLongFunction<T1> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			for (T1 t1 : arg0.apply(t0)) {
				limit0++;
				long t2 = arg2.applyAsLong(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> double stream_flatMapLambda_limit_mapToDouble_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, ToDoubleFunction<T1> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			for (T1 t1 : arg0.apply(t0)) {
				limit0++;
				double t2 = arg2.applyAsDouble(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> int stream_flatMapLambda_skip_mapToInt_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, ToIntFunction<T1> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				skip0++;
				if(skip0 <= arg1) {
					continue;
				}
				int t2 = arg2.applyAsInt(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> long stream_flatMapLambda_skip_mapToLong_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, ToLongFunction<T1> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				skip0++;
				if(skip0 <= arg1) {
					continue;
				}
				long t2 = arg2.applyAsLong(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> double stream_flatMapLambda_skip_mapToDouble_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, ToDoubleFunction<T1> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				skip0++;
				if(skip0 <= arg1) {
					continue;
				}
				double t2 = arg2.applyAsDouble(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> int stream_flatMapLambda_distinct_mapToInt_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToIntFunction<T1> arg1) {
		Set<T1> distinct0 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!distinct0.add(t1)) {
					continue;
				}
				int t2 = arg1.applyAsInt(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> long stream_flatMapLambda_distinct_mapToLong_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToLongFunction<T1> arg1) {
		Set<T1> distinct0 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!distinct0.add(t1)) {
					continue;
				}
				long t2 = arg1.applyAsLong(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> double stream_flatMapLambda_distinct_mapToDouble_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToDoubleFunction<T1> arg1) {
		Set<T1> distinct0 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!distinct0.add(t1)) {
					continue;
				}
				double t2 = arg1.applyAsDouble(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> int stream_flatMapLambda_dropWhile_mapToInt_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, ToIntFunction<T1> arg2) {
		boolean dropWhile0 = true;
		int sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(dropWhile0 && arg1.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				int t2 = arg2.applyAsInt(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> long stream_flatMapLambda_dropWhile_mapToLong_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, ToLongFunction<T1> arg2) {
		boolean dropWhile0 = true;
		long sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(dropWhile0 && arg1.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				long t2 = arg2.applyAsLong(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> double stream_flatMapLambda_dropWhile_mapToDouble_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, ToDoubleFunction<T1> arg2) {
		boolean dropWhile0 = true;
		double sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(dropWhile0 && arg1.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				double t2 = arg2.applyAsDouble(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> int stream_flatMapLambda_takeWhile_mapToInt_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, ToIntFunction<T1> arg2) {
		int sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!arg1.test(t1)) {
					break;
				}
				int t2 = arg2.applyAsInt(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> long stream_flatMapLambda_takeWhile_mapToLong_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, ToLongFunction<T1> arg2) {
		long sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!arg1.test(t1)) {
					break;
				}
				long t2 = arg2.applyAsLong(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1> double stream_flatMapLambda_takeWhile_mapToDouble_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, ToDoubleFunction<T1> arg2) {
		double sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!arg1.test(t1)) {
					break;
				}
				double t2 = arg2.applyAsDouble(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0, T1, T2> int stream_flatMapLambda_flatMapLambda_mapToInt_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, Collection<T2>> arg1, ToIntFunction<T2> arg2) {
		int sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				for (T2 t2 : arg1.apply(t1)) {
					int t3 = arg2.applyAsInt(t2);
					sum += t3;
				}
			}
		}
		return sum;
	}

	public static <T0, T1, T2> long stream_flatMapLambda_flatMapLambda_mapToLong_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, Collection<T2>> arg1, ToLongFunction<T2> arg2) {
		long sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				for (T2 t2 : arg1.apply(t1)) {
					long t3 = arg2.applyAsLong(t2);
					sum += t3;
				}
			}
		}
		return sum;
	}

	public static <T0, T1, T2> double stream_flatMapLambda_flatMapLambda_mapToDouble_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, Collection<T2>> arg1, ToDoubleFunction<T2> arg2) {
		double sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				for (T2 t2 : arg1.apply(t1)) {
					double t3 = arg2.applyAsDouble(t2);
					sum += t3;
				}
			}
		}
		return sum;
	}

	public static <T0, T1 extends Collection<T2>, T2> int stream_flatMapLambda_flatMapMemberReference_mapToInt_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToIntFunction<T2> arg1) {
		int sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				for (T2 t2 : t1) {
					int t3 = arg1.applyAsInt(t2);
					sum += t3;
				}
			}
		}
		return sum;
	}

	public static <T0, T1 extends Collection<T2>, T2> long stream_flatMapLambda_flatMapMemberReference_mapToLong_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToLongFunction<T2> arg1) {
		long sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				for (T2 t2 : t1) {
					long t3 = arg1.applyAsLong(t2);
					sum += t3;
				}
			}
		}
		return sum;
	}

	public static <T0, T1 extends Collection<T2>, T2> double stream_flatMapLambda_flatMapMemberReference_mapToDouble_sum(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToDoubleFunction<T2> arg1) {
		double sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : arg0.apply(t0)) {
				for (T2 t2 : t1) {
					double t3 = arg1.applyAsDouble(t2);
					sum += t3;
				}
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1, T2> int stream_flatMapMemberReference_map_mapToInt_sum(Collection<T0> input, Function<T1, T2> arg0, ToIntFunction<T2> arg1) {
		int sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				T2 t2 = arg0.apply(t1);
				int t3 = arg1.applyAsInt(t2);
				sum += t3;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1, T2> long stream_flatMapMemberReference_map_mapToLong_sum(Collection<T0> input, Function<T1, T2> arg0, ToLongFunction<T2> arg1) {
		long sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				T2 t2 = arg0.apply(t1);
				long t3 = arg1.applyAsLong(t2);
				sum += t3;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1, T2> double stream_flatMapMemberReference_map_mapToDouble_sum(Collection<T0> input, Function<T1, T2> arg0, ToDoubleFunction<T2> arg1) {
		double sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				T2 t2 = arg0.apply(t1);
				double t3 = arg1.applyAsDouble(t2);
				sum += t3;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> int stream_flatMapMemberReference_filter_mapToInt_sum(Collection<T0> input, Predicate<T1> arg0, ToIntFunction<T1> arg1) {
		int sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if (!arg0.test(t1)) {
					continue;
				}
				int t2 = arg1.applyAsInt(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> long stream_flatMapMemberReference_filter_mapToLong_sum(Collection<T0> input, Predicate<T1> arg0, ToLongFunction<T1> arg1) {
		long sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if (!arg0.test(t1)) {
					continue;
				}
				long t2 = arg1.applyAsLong(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> double stream_flatMapMemberReference_filter_mapToDouble_sum(Collection<T0> input, Predicate<T1> arg0, ToDoubleFunction<T1> arg1) {
		double sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if (!arg0.test(t1)) {
					continue;
				}
				double t2 = arg1.applyAsDouble(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> int stream_flatMapMemberReference_mapToInt_map_sum(Collection<T0> input, ToIntFunction<T1> arg0, IntUnaryOperator arg1) {
		int sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				int t2 = arg0.applyAsInt(t1);
				t2 = arg1.applyAsInt(t2);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> int stream_flatMapMemberReference_mapToInt_filter_sum(Collection<T0> input, ToIntFunction<T1> arg0, IntPredicate arg1) {
		int sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				int t2 = arg0.applyAsInt(t1);
				if (!arg1.test(t2)) {
					continue;
				}
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> long stream_flatMapMemberReference_mapToInt_mapToLong_sum(Collection<T0> input, ToIntFunction<T1> arg0, IntToLongFunction arg1) {
		long sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				int t2 = arg0.applyAsInt(t1);
				long t3 = arg1.applyAsLong(t2);
				sum += t3;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> double stream_flatMapMemberReference_mapToInt_mapToDouble_sum(Collection<T0> input, ToIntFunction<T1> arg0, IntToDoubleFunction arg1) {
		double sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				int t2 = arg0.applyAsInt(t1);
				double t3 = arg1.applyAsDouble(t2);
				sum += t3;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> int stream_flatMapMemberReference_mapToInt_sorted_sum(Collection<T0> input, ToIntFunction<T1> arg0) {
		List<Integer> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				int t2 = arg0.applyAsInt(t1);
				sorted0.add(t2);
			}
		}
		sorted0.sort(null);
		for (int t2: sorted0) {
			sum += t2;
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> int stream_flatMapMemberReference_mapToInt_limit_sum(Collection<T0> input, ToIntFunction<T1> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			for (T1 t1 : t0) {
				int t2 = arg0.applyAsInt(t1);
				limit0++;
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> int stream_flatMapMemberReference_mapToInt_skip_sum(Collection<T0> input, ToIntFunction<T1> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				int t2 = arg0.applyAsInt(t1);
				skip0++;
				if(skip0 <= arg1) {
					continue;
				}
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> int stream_flatMapMemberReference_mapToInt_distinct_sum(Collection<T0> input, ToIntFunction<T1> arg0) {
		Set<Integer> distinct0 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				int t2 = arg0.applyAsInt(t1);
				if(!distinct0.add(t2)) {
					continue;
				}
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> int stream_flatMapMemberReference_mapToInt_dropWhile_sum(Collection<T0> input, ToIntFunction<T1> arg0, IntPredicate arg1) {
		boolean dropWhile0 = true;
		int sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				int t2 = arg0.applyAsInt(t1);
				if(dropWhile0 && arg1.test(t2)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> int stream_flatMapMemberReference_mapToInt_takeWhile_sum(Collection<T0> input, ToIntFunction<T1> arg0, IntPredicate arg1) {
		int sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				int t2 = arg0.applyAsInt(t1);
				if(!arg1.test(t2)) {
					break;
				}
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> long stream_flatMapMemberReference_mapToLong_map_sum(Collection<T0> input, ToLongFunction<T1> arg0, LongUnaryOperator arg1) {
		long sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				long t2 = arg0.applyAsLong(t1);
				t2 = arg1.applyAsLong(t2);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> long stream_flatMapMemberReference_mapToLong_filter_sum(Collection<T0> input, ToLongFunction<T1> arg0, LongPredicate arg1) {
		long sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				long t2 = arg0.applyAsLong(t1);
				if (!arg1.test(t2)) {
					continue;
				}
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> int stream_flatMapMemberReference_mapToLong_mapToInt_sum(Collection<T0> input, ToLongFunction<T1> arg0, LongToIntFunction arg1) {
		int sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				long t2 = arg0.applyAsLong(t1);
				int t3 = arg1.applyAsInt(t2);
				sum += t3;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> double stream_flatMapMemberReference_mapToLong_mapToDouble_sum(Collection<T0> input, ToLongFunction<T1> arg0, LongToDoubleFunction arg1) {
		double sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				long t2 = arg0.applyAsLong(t1);
				double t3 = arg1.applyAsDouble(t2);
				sum += t3;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> long stream_flatMapMemberReference_mapToLong_sorted_sum(Collection<T0> input, ToLongFunction<T1> arg0) {
		List<Long> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				long t2 = arg0.applyAsLong(t1);
				sorted0.add(t2);
			}
		}
		sorted0.sort(null);
		for (long t2: sorted0) {
			sum += t2;
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> long stream_flatMapMemberReference_mapToLong_limit_sum(Collection<T0> input, ToLongFunction<T1> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			for (T1 t1 : t0) {
				long t2 = arg0.applyAsLong(t1);
				limit0++;
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> long stream_flatMapMemberReference_mapToLong_skip_sum(Collection<T0> input, ToLongFunction<T1> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				long t2 = arg0.applyAsLong(t1);
				skip0++;
				if(skip0 <= arg1) {
					continue;
				}
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> long stream_flatMapMemberReference_mapToLong_distinct_sum(Collection<T0> input, ToLongFunction<T1> arg0) {
		Set<Long> distinct0 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				long t2 = arg0.applyAsLong(t1);
				if(!distinct0.add(t2)) {
					continue;
				}
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> long stream_flatMapMemberReference_mapToLong_dropWhile_sum(Collection<T0> input, ToLongFunction<T1> arg0, LongPredicate arg1) {
		boolean dropWhile0 = true;
		long sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				long t2 = arg0.applyAsLong(t1);
				if(dropWhile0 && arg1.test(t2)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> long stream_flatMapMemberReference_mapToLong_takeWhile_sum(Collection<T0> input, ToLongFunction<T1> arg0, LongPredicate arg1) {
		long sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				long t2 = arg0.applyAsLong(t1);
				if(!arg1.test(t2)) {
					break;
				}
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> double stream_flatMapMemberReference_mapToDouble_map_sum(Collection<T0> input, ToDoubleFunction<T1> arg0, DoubleUnaryOperator arg1) {
		double sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				double t2 = arg0.applyAsDouble(t1);
				t2 = arg1.applyAsDouble(t2);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> double stream_flatMapMemberReference_mapToDouble_filter_sum(Collection<T0> input, ToDoubleFunction<T1> arg0, DoublePredicate arg1) {
		double sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				double t2 = arg0.applyAsDouble(t1);
				if (!arg1.test(t2)) {
					continue;
				}
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> int stream_flatMapMemberReference_mapToDouble_mapToInt_sum(Collection<T0> input, ToDoubleFunction<T1> arg0, DoubleToIntFunction arg1) {
		int sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				double t2 = arg0.applyAsDouble(t1);
				int t3 = arg1.applyAsInt(t2);
				sum += t3;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> long stream_flatMapMemberReference_mapToDouble_mapToLong_sum(Collection<T0> input, ToDoubleFunction<T1> arg0, DoubleToLongFunction arg1) {
		long sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				double t2 = arg0.applyAsDouble(t1);
				long t3 = arg1.applyAsLong(t2);
				sum += t3;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> double stream_flatMapMemberReference_mapToDouble_sorted_sum(Collection<T0> input, ToDoubleFunction<T1> arg0) {
		List<Double> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				double t2 = arg0.applyAsDouble(t1);
				sorted0.add(t2);
			}
		}
		sorted0.sort(null);
		for (double t2: sorted0) {
			sum += t2;
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> double stream_flatMapMemberReference_mapToDouble_limit_sum(Collection<T0> input, ToDoubleFunction<T1> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg1) {
				break;
			}
			for (T1 t1 : t0) {
				double t2 = arg0.applyAsDouble(t1);
				limit0++;
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> double stream_flatMapMemberReference_mapToDouble_skip_sum(Collection<T0> input, ToDoubleFunction<T1> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				double t2 = arg0.applyAsDouble(t1);
				skip0++;
				if(skip0 <= arg1) {
					continue;
				}
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> double stream_flatMapMemberReference_mapToDouble_distinct_sum(Collection<T0> input, ToDoubleFunction<T1> arg0) {
		Set<Double> distinct0 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				double t2 = arg0.applyAsDouble(t1);
				if(!distinct0.add(t2)) {
					continue;
				}
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> double stream_flatMapMemberReference_mapToDouble_dropWhile_sum(Collection<T0> input, ToDoubleFunction<T1> arg0, DoublePredicate arg1) {
		boolean dropWhile0 = true;
		double sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				double t2 = arg0.applyAsDouble(t1);
				if(dropWhile0 && arg1.test(t2)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> double stream_flatMapMemberReference_mapToDouble_takeWhile_sum(Collection<T0> input, ToDoubleFunction<T1> arg0, DoublePredicate arg1) {
		double sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				double t2 = arg0.applyAsDouble(t1);
				if(!arg1.test(t2)) {
					break;
				}
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> int stream_flatMapMemberReference_sorted_mapToInt_sum(Collection<T0> input, ToIntFunction<T1> arg0) {
		List<T1> sorted0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			int t2 = arg0.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> long stream_flatMapMemberReference_sorted_mapToLong_sum(Collection<T0> input, ToLongFunction<T1> arg0) {
		List<T1> sorted0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			long t2 = arg0.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> double stream_flatMapMemberReference_sorted_mapToDouble_sum(Collection<T0> input, ToDoubleFunction<T1> arg0) {
		List<T1> sorted0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				sorted0.add(t1);
			}
		}
		sorted0.sort(null);
		for (T1 t1: sorted0) {
			double t2 = arg0.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> int stream_flatMapMemberReference_sortedComp_mapToInt_sum(Collection<T0> input, Comparator<? super T1> arg0, ToIntFunction<T1> arg1) {
		List<T1> sortedComp0 = new ArrayList<>();
		int sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg0);
		for (T1 t1: sortedComp0) {
			int t2 = arg1.applyAsInt(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> long stream_flatMapMemberReference_sortedComp_mapToLong_sum(Collection<T0> input, Comparator<? super T1> arg0, ToLongFunction<T1> arg1) {
		List<T1> sortedComp0 = new ArrayList<>();
		long sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg0);
		for (T1 t1: sortedComp0) {
			long t2 = arg1.applyAsLong(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> double stream_flatMapMemberReference_sortedComp_mapToDouble_sum(Collection<T0> input, Comparator<? super T1> arg0, ToDoubleFunction<T1> arg1) {
		List<T1> sortedComp0 = new ArrayList<>();
		double sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg0);
		for (T1 t1: sortedComp0) {
			double t2 = arg1.applyAsDouble(t1);
			sum += t2;
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> int stream_flatMapMemberReference_limit_mapToInt_sum(Collection<T0> input, long arg0, ToIntFunction<T1> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			for (T1 t1 : t0) {
				limit0++;
				int t2 = arg1.applyAsInt(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> long stream_flatMapMemberReference_limit_mapToLong_sum(Collection<T0> input, long arg0, ToLongFunction<T1> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			for (T1 t1 : t0) {
				limit0++;
				long t2 = arg1.applyAsLong(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> double stream_flatMapMemberReference_limit_mapToDouble_sum(Collection<T0> input, long arg0, ToDoubleFunction<T1> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			if(limit0 >= arg0) {
				break;
			}
			for (T1 t1 : t0) {
				limit0++;
				double t2 = arg1.applyAsDouble(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> int stream_flatMapMemberReference_skip_mapToInt_sum(Collection<T0> input, long arg0, ToIntFunction<T1> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				skip0++;
				if(skip0 <= arg0) {
					continue;
				}
				int t2 = arg1.applyAsInt(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> long stream_flatMapMemberReference_skip_mapToLong_sum(Collection<T0> input, long arg0, ToLongFunction<T1> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				skip0++;
				if(skip0 <= arg0) {
					continue;
				}
				long t2 = arg1.applyAsLong(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> double stream_flatMapMemberReference_skip_mapToDouble_sum(Collection<T0> input, long arg0, ToDoubleFunction<T1> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				skip0++;
				if(skip0 <= arg0) {
					continue;
				}
				double t2 = arg1.applyAsDouble(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> int stream_flatMapMemberReference_distinct_mapToInt_sum(Collection<T0> input, ToIntFunction<T1> arg0) {
		Set<T1> distinct0 = new HashSet<>();
		int sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if(!distinct0.add(t1)) {
					continue;
				}
				int t2 = arg0.applyAsInt(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> long stream_flatMapMemberReference_distinct_mapToLong_sum(Collection<T0> input, ToLongFunction<T1> arg0) {
		Set<T1> distinct0 = new HashSet<>();
		long sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if(!distinct0.add(t1)) {
					continue;
				}
				long t2 = arg0.applyAsLong(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> double stream_flatMapMemberReference_distinct_mapToDouble_sum(Collection<T0> input, ToDoubleFunction<T1> arg0) {
		Set<T1> distinct0 = new HashSet<>();
		double sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if(!distinct0.add(t1)) {
					continue;
				}
				double t2 = arg0.applyAsDouble(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> int stream_flatMapMemberReference_dropWhile_mapToInt_sum(Collection<T0> input, Predicate<T1> arg0, ToIntFunction<T1> arg1) {
		boolean dropWhile0 = true;
		int sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if(dropWhile0 && arg0.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				int t2 = arg1.applyAsInt(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> long stream_flatMapMemberReference_dropWhile_mapToLong_sum(Collection<T0> input, Predicate<T1> arg0, ToLongFunction<T1> arg1) {
		boolean dropWhile0 = true;
		long sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if(dropWhile0 && arg0.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				long t2 = arg1.applyAsLong(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> double stream_flatMapMemberReference_dropWhile_mapToDouble_sum(Collection<T0> input, Predicate<T1> arg0, ToDoubleFunction<T1> arg1) {
		boolean dropWhile0 = true;
		double sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if(dropWhile0 && arg0.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				double t2 = arg1.applyAsDouble(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> int stream_flatMapMemberReference_takeWhile_mapToInt_sum(Collection<T0> input, Predicate<T1> arg0, ToIntFunction<T1> arg1) {
		int sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if(!arg0.test(t1)) {
					break;
				}
				int t2 = arg1.applyAsInt(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> long stream_flatMapMemberReference_takeWhile_mapToLong_sum(Collection<T0> input, Predicate<T1> arg0, ToLongFunction<T1> arg1) {
		long sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if(!arg0.test(t1)) {
					break;
				}
				long t2 = arg1.applyAsLong(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1> double stream_flatMapMemberReference_takeWhile_mapToDouble_sum(Collection<T0> input, Predicate<T1> arg0, ToDoubleFunction<T1> arg1) {
		double sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				if(!arg0.test(t1)) {
					break;
				}
				double t2 = arg1.applyAsDouble(t1);
				sum += t2;
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1, T2> int stream_flatMapMemberReference_flatMapLambda_mapToInt_sum(Collection<T0> input, Function<T1, Collection<T2>> arg0, ToIntFunction<T2> arg1) {
		int sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				for (T2 t2 : arg0.apply(t1)) {
					int t3 = arg1.applyAsInt(t2);
					sum += t3;
				}
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1, T2> long stream_flatMapMemberReference_flatMapLambda_mapToLong_sum(Collection<T0> input, Function<T1, Collection<T2>> arg0, ToLongFunction<T2> arg1) {
		long sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				for (T2 t2 : arg0.apply(t1)) {
					long t3 = arg1.applyAsLong(t2);
					sum += t3;
				}
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1, T2> double stream_flatMapMemberReference_flatMapLambda_mapToDouble_sum(Collection<T0> input, Function<T1, Collection<T2>> arg0, ToDoubleFunction<T2> arg1) {
		double sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				for (T2 t2 : arg0.apply(t1)) {
					double t3 = arg1.applyAsDouble(t2);
					sum += t3;
				}
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1 extends Collection<T2>, T2> int stream_flatMapMemberReference_flatMapMemberReference_mapToInt_sum(Collection<T0> input, ToIntFunction<T2> arg0) {
		int sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				for (T2 t2 : t1) {
					int t3 = arg0.applyAsInt(t2);
					sum += t3;
				}
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1 extends Collection<T2>, T2> long stream_flatMapMemberReference_flatMapMemberReference_mapToLong_sum(Collection<T0> input, ToLongFunction<T2> arg0) {
		long sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				for (T2 t2 : t1) {
					long t3 = arg0.applyAsLong(t2);
					sum += t3;
				}
			}
		}
		return sum;
	}

	public static <T0 extends Collection<T1>, T1 extends Collection<T2>, T2> double stream_flatMapMemberReference_flatMapMemberReference_mapToDouble_sum(Collection<T0> input, ToDoubleFunction<T2> arg0) {
		double sum = 0;
		for (T0 t0: input) {
			for (T1 t1 : t0) {
				for (T2 t2 : t1) {
					double t3 = arg0.applyAsDouble(t2);
					sum += t3;
				}
			}
		}
		return sum;
	}


}
