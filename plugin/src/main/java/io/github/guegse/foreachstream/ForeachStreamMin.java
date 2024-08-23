package io.github.guegse.foreachstream;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class ForeachStreamMin {

	public static <T0> OptionalInt stream_mapToInt_min(Collection<T0> input, ToIntFunction<T0> arg0) {
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_mapToLong_min(Collection<T0> input, ToLongFunction<T0> arg0) {
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_mapToDouble_min(Collection<T0> input, ToDoubleFunction<T0> arg0) {
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0, T1> OptionalInt stream_map_mapToInt_min(Collection<T0> input, Function<T0, T1> arg0, ToIntFunction<T1> arg1) {
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			int t2 = arg1.applyAsInt(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0, T1> OptionalLong stream_map_mapToLong_min(Collection<T0> input, Function<T0, T1> arg0, ToLongFunction<T1> arg1) {
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			long t2 = arg1.applyAsLong(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0, T1> OptionalDouble stream_map_mapToDouble_min(Collection<T0> input, Function<T0, T1> arg0, ToDoubleFunction<T1> arg1) {
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			double t2 = arg1.applyAsDouble(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_filter_mapToInt_min(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1) {
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_filter_mapToLong_min(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1) {
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_filter_mapToDouble_min(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1) {
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_mapToInt_map_min(Collection<T0> input, ToIntFunction<T0> arg0, IntUnaryOperator arg1) {
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			t1 = arg1.applyAsInt(t1);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalInt stream_mapToInt_filter_min(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1) {
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_mapToInt_mapToLong_min(Collection<T0> input, ToIntFunction<T0> arg0, IntToLongFunction arg1) {
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			long t2 = arg1.applyAsLong(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_mapToInt_mapToDouble_min(Collection<T0> input, ToIntFunction<T0> arg0, IntToDoubleFunction arg1) {
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			double t2 = arg1.applyAsDouble(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_mapToInt_sorted_min(Collection<T0> input, ToIntFunction<T0> arg0) {
		List<Integer> sorted0 = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (int t1: sorted0) {
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalInt stream_mapToInt_limit_min(Collection<T0> input, ToIntFunction<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalInt stream_mapToInt_skip_min(Collection<T0> input, ToIntFunction<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_mapToLong_map_min(Collection<T0> input, ToLongFunction<T0> arg0, LongUnaryOperator arg1) {
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			t1 = arg1.applyAsLong(t1);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalLong stream_mapToLong_filter_min(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1) {
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalInt stream_mapToLong_mapToInt_min(Collection<T0> input, ToLongFunction<T0> arg0, LongToIntFunction arg1) {
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			int t2 = arg1.applyAsInt(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalDouble stream_mapToLong_mapToDouble_min(Collection<T0> input, ToLongFunction<T0> arg0, LongToDoubleFunction arg1) {
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			double t2 = arg1.applyAsDouble(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalLong stream_mapToLong_sorted_min(Collection<T0> input, ToLongFunction<T0> arg0) {
		List<Long> sorted0 = new ArrayList<>();
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (long t1: sorted0) {
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalLong stream_mapToLong_limit_min(Collection<T0> input, ToLongFunction<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalLong stream_mapToLong_skip_min(Collection<T0> input, ToLongFunction<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_mapToDouble_map_min(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleUnaryOperator arg1) {
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			t1 = arg1.applyAsDouble(t1);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalDouble stream_mapToDouble_filter_min(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1) {
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_mapToDouble_mapToInt_min(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToIntFunction arg1) {
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			int t2 = arg1.applyAsInt(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_mapToDouble_mapToLong_min(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToLongFunction arg1) {
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			long t2 = arg1.applyAsLong(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_mapToDouble_sorted_min(Collection<T0> input, ToDoubleFunction<T0> arg0) {
		List<Double> sorted0 = new ArrayList<>();
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (double t1: sorted0) {
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalDouble stream_mapToDouble_limit_min(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalDouble stream_mapToDouble_skip_min(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_sorted_mapToInt_min(Collection<T0> input, ToIntFunction<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			int t1 = arg1.applyAsInt(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_sorted_mapToLong_min(Collection<T0> input, ToLongFunction<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			long t1 = arg1.applyAsLong(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_sorted_mapToDouble_min(Collection<T0> input, ToDoubleFunction<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			double t1 = arg1.applyAsDouble(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_sortedComp_mapToInt_min(Collection<T0> input, Comparator<? super T0> arg0, ToIntFunction<T0> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			int t1 = arg1.applyAsInt(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_sortedComp_mapToLong_min(Collection<T0> input, Comparator<? super T0> arg0, ToLongFunction<T0> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			long t1 = arg1.applyAsLong(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_sortedComp_mapToDouble_min(Collection<T0> input, Comparator<? super T0> arg0, ToDoubleFunction<T0> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			double t1 = arg1.applyAsDouble(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_limit_mapToInt_min(Collection<T0> input, long arg0, ToIntFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			int t1 = arg1.applyAsInt(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_limit_mapToLong_min(Collection<T0> input, long arg0, ToLongFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			long t1 = arg1.applyAsLong(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_limit_mapToDouble_min(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			double t1 = arg1.applyAsDouble(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_skip_mapToInt_min(Collection<T0> input, long arg0, ToIntFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_skip_mapToLong_min(Collection<T0> input, long arg0, ToLongFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_skip_mapToDouble_min(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0, T1, T2> OptionalInt stream_map_map_mapToInt_min(Collection<T0> input, Function<T0, T1> arg0, Function<T1, T2> arg1, ToIntFunction<T2> arg2) {
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			T2 t2 = arg1.apply(t1);
			int t3 = arg2.applyAsInt(t2);
			if (hasMin) {
				min = Math.min(min, t3);
			} else {
				hasMin = true;
				min = t3;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0, T1, T2> OptionalLong stream_map_map_mapToLong_min(Collection<T0> input, Function<T0, T1> arg0, Function<T1, T2> arg1, ToLongFunction<T2> arg2) {
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			T2 t2 = arg1.apply(t1);
			long t3 = arg2.applyAsLong(t2);
			if (hasMin) {
				min = Math.min(min, t3);
			} else {
				hasMin = true;
				min = t3;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0, T1, T2> OptionalDouble stream_map_map_mapToDouble_min(Collection<T0> input, Function<T0, T1> arg0, Function<T1, T2> arg1, ToDoubleFunction<T2> arg2) {
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			T2 t2 = arg1.apply(t1);
			double t3 = arg2.applyAsDouble(t2);
			if (hasMin) {
				min = Math.min(min, t3);
			} else {
				hasMin = true;
				min = t3;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0, T1> OptionalInt stream_map_filter_mapToInt_min(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, ToIntFunction<T1> arg2) {
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			int t2 = arg2.applyAsInt(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0, T1> OptionalLong stream_map_filter_mapToLong_min(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, ToLongFunction<T1> arg2) {
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			long t2 = arg2.applyAsLong(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0, T1> OptionalDouble stream_map_filter_mapToDouble_min(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, ToDoubleFunction<T1> arg2) {
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			double t2 = arg2.applyAsDouble(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0, T1> OptionalInt stream_map_mapToInt_map_min(Collection<T0> input, Function<T0, T1> arg0, ToIntFunction<T1> arg1, IntUnaryOperator arg2) {
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			int t2 = arg1.applyAsInt(t1);
			t2 = arg2.applyAsInt(t2);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0, T1> OptionalInt stream_map_mapToInt_filter_min(Collection<T0> input, Function<T0, T1> arg0, ToIntFunction<T1> arg1, IntPredicate arg2) {
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			int t2 = arg1.applyAsInt(t1);
			if (!arg2.test(t2)) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0, T1> OptionalLong stream_map_mapToInt_mapToLong_min(Collection<T0> input, Function<T0, T1> arg0, ToIntFunction<T1> arg1, IntToLongFunction arg2) {
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			int t2 = arg1.applyAsInt(t1);
			long t3 = arg2.applyAsLong(t2);
			if (hasMin) {
				min = Math.min(min, t3);
			} else {
				hasMin = true;
				min = t3;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0, T1> OptionalDouble stream_map_mapToInt_mapToDouble_min(Collection<T0> input, Function<T0, T1> arg0, ToIntFunction<T1> arg1, IntToDoubleFunction arg2) {
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			int t2 = arg1.applyAsInt(t1);
			double t3 = arg2.applyAsDouble(t2);
			if (hasMin) {
				min = Math.min(min, t3);
			} else {
				hasMin = true;
				min = t3;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0, T1> OptionalInt stream_map_mapToInt_sorted_min(Collection<T0> input, Function<T0, T1> arg0, ToIntFunction<T1> arg1) {
		List<Integer> sorted0 = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			int t2 = arg1.applyAsInt(t1);
			sorted0.add(t2);
		}
		Collections.sort((List) sorted0);
		for (int t2: sorted0) {
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0, T1> OptionalInt stream_map_mapToInt_limit_min(Collection<T0> input, Function<T0, T1> arg0, ToIntFunction<T1> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			int t2 = arg1.applyAsInt(t1);
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0, T1> OptionalInt stream_map_mapToInt_skip_min(Collection<T0> input, Function<T0, T1> arg0, ToIntFunction<T1> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			int t2 = arg1.applyAsInt(t1);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0, T1> OptionalLong stream_map_mapToLong_map_min(Collection<T0> input, Function<T0, T1> arg0, ToLongFunction<T1> arg1, LongUnaryOperator arg2) {
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			long t2 = arg1.applyAsLong(t1);
			t2 = arg2.applyAsLong(t2);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0, T1> OptionalLong stream_map_mapToLong_filter_min(Collection<T0> input, Function<T0, T1> arg0, ToLongFunction<T1> arg1, LongPredicate arg2) {
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			long t2 = arg1.applyAsLong(t1);
			if (!arg2.test(t2)) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0, T1> OptionalInt stream_map_mapToLong_mapToInt_min(Collection<T0> input, Function<T0, T1> arg0, ToLongFunction<T1> arg1, LongToIntFunction arg2) {
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			long t2 = arg1.applyAsLong(t1);
			int t3 = arg2.applyAsInt(t2);
			if (hasMin) {
				min = Math.min(min, t3);
			} else {
				hasMin = true;
				min = t3;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0, T1> OptionalDouble stream_map_mapToLong_mapToDouble_min(Collection<T0> input, Function<T0, T1> arg0, ToLongFunction<T1> arg1, LongToDoubleFunction arg2) {
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			long t2 = arg1.applyAsLong(t1);
			double t3 = arg2.applyAsDouble(t2);
			if (hasMin) {
				min = Math.min(min, t3);
			} else {
				hasMin = true;
				min = t3;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0, T1> OptionalLong stream_map_mapToLong_sorted_min(Collection<T0> input, Function<T0, T1> arg0, ToLongFunction<T1> arg1) {
		List<Long> sorted0 = new ArrayList<>();
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			long t2 = arg1.applyAsLong(t1);
			sorted0.add(t2);
		}
		Collections.sort((List) sorted0);
		for (long t2: sorted0) {
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0, T1> OptionalLong stream_map_mapToLong_limit_min(Collection<T0> input, Function<T0, T1> arg0, ToLongFunction<T1> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			long t2 = arg1.applyAsLong(t1);
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0, T1> OptionalLong stream_map_mapToLong_skip_min(Collection<T0> input, Function<T0, T1> arg0, ToLongFunction<T1> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			long t2 = arg1.applyAsLong(t1);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0, T1> OptionalDouble stream_map_mapToDouble_map_min(Collection<T0> input, Function<T0, T1> arg0, ToDoubleFunction<T1> arg1, DoubleUnaryOperator arg2) {
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			double t2 = arg1.applyAsDouble(t1);
			t2 = arg2.applyAsDouble(t2);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0, T1> OptionalDouble stream_map_mapToDouble_filter_min(Collection<T0> input, Function<T0, T1> arg0, ToDoubleFunction<T1> arg1, DoublePredicate arg2) {
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			double t2 = arg1.applyAsDouble(t1);
			if (!arg2.test(t2)) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0, T1> OptionalInt stream_map_mapToDouble_mapToInt_min(Collection<T0> input, Function<T0, T1> arg0, ToDoubleFunction<T1> arg1, DoubleToIntFunction arg2) {
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			double t2 = arg1.applyAsDouble(t1);
			int t3 = arg2.applyAsInt(t2);
			if (hasMin) {
				min = Math.min(min, t3);
			} else {
				hasMin = true;
				min = t3;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0, T1> OptionalLong stream_map_mapToDouble_mapToLong_min(Collection<T0> input, Function<T0, T1> arg0, ToDoubleFunction<T1> arg1, DoubleToLongFunction arg2) {
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			double t2 = arg1.applyAsDouble(t1);
			long t3 = arg2.applyAsLong(t2);
			if (hasMin) {
				min = Math.min(min, t3);
			} else {
				hasMin = true;
				min = t3;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0, T1> OptionalDouble stream_map_mapToDouble_sorted_min(Collection<T0> input, Function<T0, T1> arg0, ToDoubleFunction<T1> arg1) {
		List<Double> sorted0 = new ArrayList<>();
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			double t2 = arg1.applyAsDouble(t1);
			sorted0.add(t2);
		}
		Collections.sort((List) sorted0);
		for (double t2: sorted0) {
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0, T1> OptionalDouble stream_map_mapToDouble_limit_min(Collection<T0> input, Function<T0, T1> arg0, ToDoubleFunction<T1> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			double t2 = arg1.applyAsDouble(t1);
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0, T1> OptionalDouble stream_map_mapToDouble_skip_min(Collection<T0> input, Function<T0, T1> arg0, ToDoubleFunction<T1> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			double t2 = arg1.applyAsDouble(t1);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0, T1> OptionalInt stream_map_sorted_mapToInt_min(Collection<T0> input, Function<T0, T1> arg0, ToIntFunction<T1> arg2) {
		List<T1> sorted0 = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			int t2 = arg2.applyAsInt(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0, T1> OptionalLong stream_map_sorted_mapToLong_min(Collection<T0> input, Function<T0, T1> arg0, ToLongFunction<T1> arg2) {
		List<T1> sorted0 = new ArrayList<>();
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			long t2 = arg2.applyAsLong(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0, T1> OptionalDouble stream_map_sorted_mapToDouble_min(Collection<T0> input, Function<T0, T1> arg0, ToDoubleFunction<T1> arg2) {
		List<T1> sorted0 = new ArrayList<>();
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			double t2 = arg2.applyAsDouble(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0, T1> OptionalInt stream_map_sortedComp_mapToInt_min(Collection<T0> input, Function<T0, T1> arg0, Comparator<? super T1> arg1, ToIntFunction<T1> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			int t2 = arg2.applyAsInt(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0, T1> OptionalLong stream_map_sortedComp_mapToLong_min(Collection<T0> input, Function<T0, T1> arg0, Comparator<? super T1> arg1, ToLongFunction<T1> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			long t2 = arg2.applyAsLong(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0, T1> OptionalDouble stream_map_sortedComp_mapToDouble_min(Collection<T0> input, Function<T0, T1> arg0, Comparator<? super T1> arg1, ToDoubleFunction<T1> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			double t2 = arg2.applyAsDouble(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0, T1> OptionalInt stream_map_limit_mapToInt_min(Collection<T0> input, Function<T0, T1> arg0, long arg1, ToIntFunction<T1> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			int t2 = arg2.applyAsInt(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0, T1> OptionalLong stream_map_limit_mapToLong_min(Collection<T0> input, Function<T0, T1> arg0, long arg1, ToLongFunction<T1> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			long t2 = arg2.applyAsLong(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0, T1> OptionalDouble stream_map_limit_mapToDouble_min(Collection<T0> input, Function<T0, T1> arg0, long arg1, ToDoubleFunction<T1> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			double t2 = arg2.applyAsDouble(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0, T1> OptionalInt stream_map_skip_mapToInt_min(Collection<T0> input, Function<T0, T1> arg0, long arg1, ToIntFunction<T1> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			int t2 = arg2.applyAsInt(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0, T1> OptionalLong stream_map_skip_mapToLong_min(Collection<T0> input, Function<T0, T1> arg0, long arg1, ToLongFunction<T1> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			long t2 = arg2.applyAsLong(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0, T1> OptionalDouble stream_map_skip_mapToDouble_min(Collection<T0> input, Function<T0, T1> arg0, long arg1, ToDoubleFunction<T1> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			double t2 = arg2.applyAsDouble(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0, T1> OptionalInt stream_filter_map_mapToInt_min(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, ToIntFunction<T1> arg2) {
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			int t2 = arg2.applyAsInt(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0, T1> OptionalLong stream_filter_map_mapToLong_min(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, ToLongFunction<T1> arg2) {
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			long t2 = arg2.applyAsLong(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0, T1> OptionalDouble stream_filter_map_mapToDouble_min(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, ToDoubleFunction<T1> arg2) {
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			double t2 = arg2.applyAsDouble(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_filter_filter_mapToInt_min(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, ToIntFunction<T0> arg2) {
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			int t1 = arg2.applyAsInt(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_filter_filter_mapToLong_min(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, ToLongFunction<T0> arg2) {
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			long t1 = arg2.applyAsLong(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_filter_filter_mapToDouble_min(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, ToDoubleFunction<T0> arg2) {
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			double t1 = arg2.applyAsDouble(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_filter_mapToInt_map_min(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1, IntUnaryOperator arg2) {
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			t1 = arg2.applyAsInt(t1);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalInt stream_filter_mapToInt_filter_min(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1, IntPredicate arg2) {
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_filter_mapToInt_mapToLong_min(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1, IntToLongFunction arg2) {
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			long t2 = arg2.applyAsLong(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_filter_mapToInt_mapToDouble_min(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1, IntToDoubleFunction arg2) {
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			double t2 = arg2.applyAsDouble(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_filter_mapToInt_sorted_min(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1) {
		List<Integer> sorted0 = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (int t1: sorted0) {
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalInt stream_filter_mapToInt_limit_min(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalInt stream_filter_mapToInt_skip_min(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_filter_mapToLong_map_min(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1, LongUnaryOperator arg2) {
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			t1 = arg2.applyAsLong(t1);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalLong stream_filter_mapToLong_filter_min(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1, LongPredicate arg2) {
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalInt stream_filter_mapToLong_mapToInt_min(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1, LongToIntFunction arg2) {
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			int t2 = arg2.applyAsInt(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalDouble stream_filter_mapToLong_mapToDouble_min(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1, LongToDoubleFunction arg2) {
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			double t2 = arg2.applyAsDouble(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalLong stream_filter_mapToLong_sorted_min(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1) {
		List<Long> sorted0 = new ArrayList<>();
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (long t1: sorted0) {
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalLong stream_filter_mapToLong_limit_min(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalLong stream_filter_mapToLong_skip_min(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_filter_mapToDouble_map_min(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1, DoubleUnaryOperator arg2) {
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			t1 = arg2.applyAsDouble(t1);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalDouble stream_filter_mapToDouble_filter_min(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1, DoublePredicate arg2) {
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_filter_mapToDouble_mapToInt_min(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1, DoubleToIntFunction arg2) {
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			int t2 = arg2.applyAsInt(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_filter_mapToDouble_mapToLong_min(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1, DoubleToLongFunction arg2) {
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			long t2 = arg2.applyAsLong(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_filter_mapToDouble_sorted_min(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1) {
		List<Double> sorted0 = new ArrayList<>();
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (double t1: sorted0) {
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalDouble stream_filter_mapToDouble_limit_min(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalDouble stream_filter_mapToDouble_skip_min(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_filter_sorted_mapToInt_min(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			int t1 = arg2.applyAsInt(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_filter_sorted_mapToLong_min(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			long t1 = arg2.applyAsLong(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_filter_sorted_mapToDouble_min(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			double t1 = arg2.applyAsDouble(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_filter_sortedComp_mapToInt_min(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, ToIntFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			int t1 = arg2.applyAsInt(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_filter_sortedComp_mapToLong_min(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, ToLongFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			long t1 = arg2.applyAsLong(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_filter_sortedComp_mapToDouble_min(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, ToDoubleFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			double t1 = arg2.applyAsDouble(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_filter_limit_mapToInt_min(Collection<T0> input, Predicate<T0> arg0, long arg1, ToIntFunction<T0> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			int t1 = arg2.applyAsInt(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_filter_limit_mapToLong_min(Collection<T0> input, Predicate<T0> arg0, long arg1, ToLongFunction<T0> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			long t1 = arg2.applyAsLong(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_filter_limit_mapToDouble_min(Collection<T0> input, Predicate<T0> arg0, long arg1, ToDoubleFunction<T0> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			double t1 = arg2.applyAsDouble(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_filter_skip_mapToInt_min(Collection<T0> input, Predicate<T0> arg0, long arg1, ToIntFunction<T0> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			int t1 = arg2.applyAsInt(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_filter_skip_mapToLong_min(Collection<T0> input, Predicate<T0> arg0, long arg1, ToLongFunction<T0> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			long t1 = arg2.applyAsLong(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_filter_skip_mapToDouble_min(Collection<T0> input, Predicate<T0> arg0, long arg1, ToDoubleFunction<T0> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			double t1 = arg2.applyAsDouble(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_mapToInt_map_map_min(Collection<T0> input, ToIntFunction<T0> arg0, IntUnaryOperator arg1, IntUnaryOperator arg2) {
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			t1 = arg1.applyAsInt(t1);
			t1 = arg2.applyAsInt(t1);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalInt stream_mapToInt_map_filter_min(Collection<T0> input, ToIntFunction<T0> arg0, IntUnaryOperator arg1, IntPredicate arg2) {
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			t1 = arg1.applyAsInt(t1);
			if (!arg2.test(t1)) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_mapToInt_map_mapToLong_min(Collection<T0> input, ToIntFunction<T0> arg0, IntUnaryOperator arg1, IntToLongFunction arg2) {
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			t1 = arg1.applyAsInt(t1);
			long t2 = arg2.applyAsLong(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_mapToInt_map_mapToDouble_min(Collection<T0> input, ToIntFunction<T0> arg0, IntUnaryOperator arg1, IntToDoubleFunction arg2) {
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			t1 = arg1.applyAsInt(t1);
			double t2 = arg2.applyAsDouble(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_mapToInt_map_sorted_min(Collection<T0> input, ToIntFunction<T0> arg0, IntUnaryOperator arg1) {
		List<Integer> sorted0 = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			t1 = arg1.applyAsInt(t1);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (int t1: sorted0) {
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalInt stream_mapToInt_map_limit_min(Collection<T0> input, ToIntFunction<T0> arg0, IntUnaryOperator arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			t1 = arg1.applyAsInt(t1);
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalInt stream_mapToInt_map_skip_min(Collection<T0> input, ToIntFunction<T0> arg0, IntUnaryOperator arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			t1 = arg1.applyAsInt(t1);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalInt stream_mapToInt_filter_map_min(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1, IntUnaryOperator arg2) {
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			t1 = arg2.applyAsInt(t1);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalInt stream_mapToInt_filter_filter_min(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1, IntPredicate arg2) {
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			if (!arg2.test(t1)) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_mapToInt_filter_mapToLong_min(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1, IntToLongFunction arg2) {
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			long t2 = arg2.applyAsLong(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_mapToInt_filter_mapToDouble_min(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1, IntToDoubleFunction arg2) {
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			double t2 = arg2.applyAsDouble(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_mapToInt_filter_sorted_min(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1) {
		List<Integer> sorted0 = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (int t1: sorted0) {
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalInt stream_mapToInt_filter_limit_min(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalInt stream_mapToInt_filter_skip_min(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_mapToInt_mapToLong_map_min(Collection<T0> input, ToIntFunction<T0> arg0, IntToLongFunction arg1, LongUnaryOperator arg2) {
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			long t2 = arg1.applyAsLong(t1);
			t2 = arg2.applyAsLong(t2);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalLong stream_mapToInt_mapToLong_filter_min(Collection<T0> input, ToIntFunction<T0> arg0, IntToLongFunction arg1, LongPredicate arg2) {
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			long t2 = arg1.applyAsLong(t1);
			if (!arg2.test(t2)) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalInt stream_mapToInt_mapToLong_mapToInt_min(Collection<T0> input, ToIntFunction<T0> arg0, IntToLongFunction arg1, LongToIntFunction arg2) {
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			long t2 = arg1.applyAsLong(t1);
			int t3 = arg2.applyAsInt(t2);
			if (hasMin) {
				min = Math.min(min, t3);
			} else {
				hasMin = true;
				min = t3;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalDouble stream_mapToInt_mapToLong_mapToDouble_min(Collection<T0> input, ToIntFunction<T0> arg0, IntToLongFunction arg1, LongToDoubleFunction arg2) {
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			long t2 = arg1.applyAsLong(t1);
			double t3 = arg2.applyAsDouble(t2);
			if (hasMin) {
				min = Math.min(min, t3);
			} else {
				hasMin = true;
				min = t3;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalLong stream_mapToInt_mapToLong_sorted_min(Collection<T0> input, ToIntFunction<T0> arg0, IntToLongFunction arg1) {
		List<Long> sorted0 = new ArrayList<>();
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			long t2 = arg1.applyAsLong(t1);
			sorted0.add(t2);
		}
		Collections.sort((List) sorted0);
		for (long t2: sorted0) {
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalLong stream_mapToInt_mapToLong_limit_min(Collection<T0> input, ToIntFunction<T0> arg0, IntToLongFunction arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			long t2 = arg1.applyAsLong(t1);
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalLong stream_mapToInt_mapToLong_skip_min(Collection<T0> input, ToIntFunction<T0> arg0, IntToLongFunction arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			long t2 = arg1.applyAsLong(t1);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_mapToInt_mapToDouble_map_min(Collection<T0> input, ToIntFunction<T0> arg0, IntToDoubleFunction arg1, DoubleUnaryOperator arg2) {
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			double t2 = arg1.applyAsDouble(t1);
			t2 = arg2.applyAsDouble(t2);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalDouble stream_mapToInt_mapToDouble_filter_min(Collection<T0> input, ToIntFunction<T0> arg0, IntToDoubleFunction arg1, DoublePredicate arg2) {
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			double t2 = arg1.applyAsDouble(t1);
			if (!arg2.test(t2)) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_mapToInt_mapToDouble_mapToInt_min(Collection<T0> input, ToIntFunction<T0> arg0, IntToDoubleFunction arg1, DoubleToIntFunction arg2) {
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			double t2 = arg1.applyAsDouble(t1);
			int t3 = arg2.applyAsInt(t2);
			if (hasMin) {
				min = Math.min(min, t3);
			} else {
				hasMin = true;
				min = t3;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_mapToInt_mapToDouble_mapToLong_min(Collection<T0> input, ToIntFunction<T0> arg0, IntToDoubleFunction arg1, DoubleToLongFunction arg2) {
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			double t2 = arg1.applyAsDouble(t1);
			long t3 = arg2.applyAsLong(t2);
			if (hasMin) {
				min = Math.min(min, t3);
			} else {
				hasMin = true;
				min = t3;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_mapToInt_mapToDouble_sorted_min(Collection<T0> input, ToIntFunction<T0> arg0, IntToDoubleFunction arg1) {
		List<Double> sorted0 = new ArrayList<>();
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			double t2 = arg1.applyAsDouble(t1);
			sorted0.add(t2);
		}
		Collections.sort((List) sorted0);
		for (double t2: sorted0) {
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalDouble stream_mapToInt_mapToDouble_limit_min(Collection<T0> input, ToIntFunction<T0> arg0, IntToDoubleFunction arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			double t2 = arg1.applyAsDouble(t1);
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalDouble stream_mapToInt_mapToDouble_skip_min(Collection<T0> input, ToIntFunction<T0> arg0, IntToDoubleFunction arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			double t2 = arg1.applyAsDouble(t1);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0, T2> OptionalInt stream_mapToInt_mapToObj_mapToInt_min(Collection<T0> input, ToIntFunction<T0> arg0, IntFunction<T2> arg1, ToIntFunction<T2> arg2) {
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			T2 t2 = arg1.apply(t1);
			int t3 = arg2.applyAsInt(t2);
			if (hasMin) {
				min = Math.min(min, t3);
			} else {
				hasMin = true;
				min = t3;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0, T2> OptionalLong stream_mapToInt_mapToObj_mapToLong_min(Collection<T0> input, ToIntFunction<T0> arg0, IntFunction<T2> arg1, ToLongFunction<T2> arg2) {
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			T2 t2 = arg1.apply(t1);
			long t3 = arg2.applyAsLong(t2);
			if (hasMin) {
				min = Math.min(min, t3);
			} else {
				hasMin = true;
				min = t3;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0, T2> OptionalDouble stream_mapToInt_mapToObj_mapToDouble_min(Collection<T0> input, ToIntFunction<T0> arg0, IntFunction<T2> arg1, ToDoubleFunction<T2> arg2) {
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			T2 t2 = arg1.apply(t1);
			double t3 = arg2.applyAsDouble(t2);
			if (hasMin) {
				min = Math.min(min, t3);
			} else {
				hasMin = true;
				min = t3;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_mapToInt_boxed_mapToInt_min(Collection<T0> input, ToIntFunction<T0> arg0, ToIntFunction<Integer> arg2) {
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			Integer t2 = t1;
			int t3 = arg2.applyAsInt(t2);
			if (hasMin) {
				min = Math.min(min, t3);
			} else {
				hasMin = true;
				min = t3;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_mapToInt_boxed_mapToLong_min(Collection<T0> input, ToIntFunction<T0> arg0, ToLongFunction<Integer> arg2) {
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			Integer t2 = t1;
			long t3 = arg2.applyAsLong(t2);
			if (hasMin) {
				min = Math.min(min, t3);
			} else {
				hasMin = true;
				min = t3;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_mapToInt_boxed_mapToDouble_min(Collection<T0> input, ToIntFunction<T0> arg0, ToDoubleFunction<Integer> arg2) {
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			Integer t2 = t1;
			double t3 = arg2.applyAsDouble(t2);
			if (hasMin) {
				min = Math.min(min, t3);
			} else {
				hasMin = true;
				min = t3;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_mapToInt_sorted_map_min(Collection<T0> input, ToIntFunction<T0> arg0, IntUnaryOperator arg2) {
		List<Integer> sorted0 = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (int t1: sorted0) {
			t1 = arg2.applyAsInt(t1);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalInt stream_mapToInt_sorted_filter_min(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg2) {
		List<Integer> sorted0 = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (int t1: sorted0) {
			if (!arg2.test(t1)) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_mapToInt_sorted_mapToLong_min(Collection<T0> input, ToIntFunction<T0> arg0, IntToLongFunction arg2) {
		List<Integer> sorted0 = new ArrayList<>();
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (int t1: sorted0) {
			long t2 = arg2.applyAsLong(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_mapToInt_sorted_mapToDouble_min(Collection<T0> input, ToIntFunction<T0> arg0, IntToDoubleFunction arg2) {
		List<Integer> sorted0 = new ArrayList<>();
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (int t1: sorted0) {
			double t2 = arg2.applyAsDouble(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_mapToInt_sorted_sorted_min(Collection<T0> input, ToIntFunction<T0> arg0) {
		List<Integer> sorted0 = new ArrayList<>();
		List<Integer> sorted1 = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (int t1: sorted0) {
			sorted1.add(t1);
		}
		Collections.sort((List) sorted1);
		for (int t1: sorted1) {
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalInt stream_mapToInt_sorted_limit_min(Collection<T0> input, ToIntFunction<T0> arg0, long arg2) {
		List<Integer> sorted0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (int t1: sorted0) {
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalInt stream_mapToInt_sorted_skip_min(Collection<T0> input, ToIntFunction<T0> arg0, long arg2) {
		List<Integer> sorted0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (int t1: sorted0) {
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalInt stream_mapToInt_limit_map_min(Collection<T0> input, ToIntFunction<T0> arg0, long arg1, IntUnaryOperator arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			t1 = arg2.applyAsInt(t1);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalInt stream_mapToInt_limit_filter_min(Collection<T0> input, ToIntFunction<T0> arg0, long arg1, IntPredicate arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			if (!arg2.test(t1)) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_mapToInt_limit_mapToLong_min(Collection<T0> input, ToIntFunction<T0> arg0, long arg1, IntToLongFunction arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			long t2 = arg2.applyAsLong(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_mapToInt_limit_mapToDouble_min(Collection<T0> input, ToIntFunction<T0> arg0, long arg1, IntToDoubleFunction arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			double t2 = arg2.applyAsDouble(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_mapToInt_limit_sorted_min(Collection<T0> input, ToIntFunction<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<Integer> sorted0 = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (int t1: sorted0) {
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalInt stream_mapToInt_limit_limit_min(Collection<T0> input, ToIntFunction<T0> arg0, long arg1, long arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			limit1++;
			if(limit1 > arg2) {
				break;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalInt stream_mapToInt_limit_skip_min(Collection<T0> input, ToIntFunction<T0> arg0, long arg1, long arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalInt stream_mapToInt_skip_map_min(Collection<T0> input, ToIntFunction<T0> arg0, long arg1, IntUnaryOperator arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			t1 = arg2.applyAsInt(t1);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalInt stream_mapToInt_skip_filter_min(Collection<T0> input, ToIntFunction<T0> arg0, long arg1, IntPredicate arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if (!arg2.test(t1)) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_mapToInt_skip_mapToLong_min(Collection<T0> input, ToIntFunction<T0> arg0, long arg1, IntToLongFunction arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			long t2 = arg2.applyAsLong(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_mapToInt_skip_mapToDouble_min(Collection<T0> input, ToIntFunction<T0> arg0, long arg1, IntToDoubleFunction arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			double t2 = arg2.applyAsDouble(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_mapToInt_skip_sorted_min(Collection<T0> input, ToIntFunction<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<Integer> sorted0 = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (int t1: sorted0) {
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalInt stream_mapToInt_skip_limit_min(Collection<T0> input, ToIntFunction<T0> arg0, long arg1, long arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalInt stream_mapToInt_skip_skip_min(Collection<T0> input, ToIntFunction<T0> arg0, long arg1, long arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			skip1++;
			if(skip1 <= arg2) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_mapToLong_map_map_min(Collection<T0> input, ToLongFunction<T0> arg0, LongUnaryOperator arg1, LongUnaryOperator arg2) {
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			t1 = arg1.applyAsLong(t1);
			t1 = arg2.applyAsLong(t1);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalLong stream_mapToLong_map_filter_min(Collection<T0> input, ToLongFunction<T0> arg0, LongUnaryOperator arg1, LongPredicate arg2) {
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			t1 = arg1.applyAsLong(t1);
			if (!arg2.test(t1)) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalInt stream_mapToLong_map_mapToInt_min(Collection<T0> input, ToLongFunction<T0> arg0, LongUnaryOperator arg1, LongToIntFunction arg2) {
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			t1 = arg1.applyAsLong(t1);
			int t2 = arg2.applyAsInt(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalDouble stream_mapToLong_map_mapToDouble_min(Collection<T0> input, ToLongFunction<T0> arg0, LongUnaryOperator arg1, LongToDoubleFunction arg2) {
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			t1 = arg1.applyAsLong(t1);
			double t2 = arg2.applyAsDouble(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalLong stream_mapToLong_map_sorted_min(Collection<T0> input, ToLongFunction<T0> arg0, LongUnaryOperator arg1) {
		List<Long> sorted0 = new ArrayList<>();
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			t1 = arg1.applyAsLong(t1);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (long t1: sorted0) {
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalLong stream_mapToLong_map_limit_min(Collection<T0> input, ToLongFunction<T0> arg0, LongUnaryOperator arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			t1 = arg1.applyAsLong(t1);
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalLong stream_mapToLong_map_skip_min(Collection<T0> input, ToLongFunction<T0> arg0, LongUnaryOperator arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			t1 = arg1.applyAsLong(t1);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalLong stream_mapToLong_filter_map_min(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1, LongUnaryOperator arg2) {
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			t1 = arg2.applyAsLong(t1);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalLong stream_mapToLong_filter_filter_min(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1, LongPredicate arg2) {
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			if (!arg2.test(t1)) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalInt stream_mapToLong_filter_mapToInt_min(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1, LongToIntFunction arg2) {
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			int t2 = arg2.applyAsInt(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalDouble stream_mapToLong_filter_mapToDouble_min(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1, LongToDoubleFunction arg2) {
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			double t2 = arg2.applyAsDouble(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalLong stream_mapToLong_filter_sorted_min(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1) {
		List<Long> sorted0 = new ArrayList<>();
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (long t1: sorted0) {
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalLong stream_mapToLong_filter_limit_min(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalLong stream_mapToLong_filter_skip_min(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalInt stream_mapToLong_mapToInt_map_min(Collection<T0> input, ToLongFunction<T0> arg0, LongToIntFunction arg1, IntUnaryOperator arg2) {
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			int t2 = arg1.applyAsInt(t1);
			t2 = arg2.applyAsInt(t2);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalInt stream_mapToLong_mapToInt_filter_min(Collection<T0> input, ToLongFunction<T0> arg0, LongToIntFunction arg1, IntPredicate arg2) {
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			int t2 = arg1.applyAsInt(t1);
			if (!arg2.test(t2)) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_mapToLong_mapToInt_mapToLong_min(Collection<T0> input, ToLongFunction<T0> arg0, LongToIntFunction arg1, IntToLongFunction arg2) {
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			int t2 = arg1.applyAsInt(t1);
			long t3 = arg2.applyAsLong(t2);
			if (hasMin) {
				min = Math.min(min, t3);
			} else {
				hasMin = true;
				min = t3;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_mapToLong_mapToInt_mapToDouble_min(Collection<T0> input, ToLongFunction<T0> arg0, LongToIntFunction arg1, IntToDoubleFunction arg2) {
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			int t2 = arg1.applyAsInt(t1);
			double t3 = arg2.applyAsDouble(t2);
			if (hasMin) {
				min = Math.min(min, t3);
			} else {
				hasMin = true;
				min = t3;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_mapToLong_mapToInt_sorted_min(Collection<T0> input, ToLongFunction<T0> arg0, LongToIntFunction arg1) {
		List<Integer> sorted0 = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			int t2 = arg1.applyAsInt(t1);
			sorted0.add(t2);
		}
		Collections.sort((List) sorted0);
		for (int t2: sorted0) {
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalInt stream_mapToLong_mapToInt_limit_min(Collection<T0> input, ToLongFunction<T0> arg0, LongToIntFunction arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			int t2 = arg1.applyAsInt(t1);
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalInt stream_mapToLong_mapToInt_skip_min(Collection<T0> input, ToLongFunction<T0> arg0, LongToIntFunction arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			int t2 = arg1.applyAsInt(t1);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalDouble stream_mapToLong_mapToDouble_map_min(Collection<T0> input, ToLongFunction<T0> arg0, LongToDoubleFunction arg1, DoubleUnaryOperator arg2) {
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			double t2 = arg1.applyAsDouble(t1);
			t2 = arg2.applyAsDouble(t2);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalDouble stream_mapToLong_mapToDouble_filter_min(Collection<T0> input, ToLongFunction<T0> arg0, LongToDoubleFunction arg1, DoublePredicate arg2) {
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			double t2 = arg1.applyAsDouble(t1);
			if (!arg2.test(t2)) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_mapToLong_mapToDouble_mapToInt_min(Collection<T0> input, ToLongFunction<T0> arg0, LongToDoubleFunction arg1, DoubleToIntFunction arg2) {
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			double t2 = arg1.applyAsDouble(t1);
			int t3 = arg2.applyAsInt(t2);
			if (hasMin) {
				min = Math.min(min, t3);
			} else {
				hasMin = true;
				min = t3;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_mapToLong_mapToDouble_mapToLong_min(Collection<T0> input, ToLongFunction<T0> arg0, LongToDoubleFunction arg1, DoubleToLongFunction arg2) {
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			double t2 = arg1.applyAsDouble(t1);
			long t3 = arg2.applyAsLong(t2);
			if (hasMin) {
				min = Math.min(min, t3);
			} else {
				hasMin = true;
				min = t3;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_mapToLong_mapToDouble_sorted_min(Collection<T0> input, ToLongFunction<T0> arg0, LongToDoubleFunction arg1) {
		List<Double> sorted0 = new ArrayList<>();
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			double t2 = arg1.applyAsDouble(t1);
			sorted0.add(t2);
		}
		Collections.sort((List) sorted0);
		for (double t2: sorted0) {
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalDouble stream_mapToLong_mapToDouble_limit_min(Collection<T0> input, ToLongFunction<T0> arg0, LongToDoubleFunction arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			double t2 = arg1.applyAsDouble(t1);
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalDouble stream_mapToLong_mapToDouble_skip_min(Collection<T0> input, ToLongFunction<T0> arg0, LongToDoubleFunction arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			double t2 = arg1.applyAsDouble(t1);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0, T2> OptionalInt stream_mapToLong_mapToObj_mapToInt_min(Collection<T0> input, ToLongFunction<T0> arg0, LongFunction<T2> arg1, ToIntFunction<T2> arg2) {
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			T2 t2 = arg1.apply(t1);
			int t3 = arg2.applyAsInt(t2);
			if (hasMin) {
				min = Math.min(min, t3);
			} else {
				hasMin = true;
				min = t3;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0, T2> OptionalLong stream_mapToLong_mapToObj_mapToLong_min(Collection<T0> input, ToLongFunction<T0> arg0, LongFunction<T2> arg1, ToLongFunction<T2> arg2) {
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			T2 t2 = arg1.apply(t1);
			long t3 = arg2.applyAsLong(t2);
			if (hasMin) {
				min = Math.min(min, t3);
			} else {
				hasMin = true;
				min = t3;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0, T2> OptionalDouble stream_mapToLong_mapToObj_mapToDouble_min(Collection<T0> input, ToLongFunction<T0> arg0, LongFunction<T2> arg1, ToDoubleFunction<T2> arg2) {
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			T2 t2 = arg1.apply(t1);
			double t3 = arg2.applyAsDouble(t2);
			if (hasMin) {
				min = Math.min(min, t3);
			} else {
				hasMin = true;
				min = t3;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_mapToLong_boxed_mapToInt_min(Collection<T0> input, ToLongFunction<T0> arg0, ToIntFunction<Long> arg2) {
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			Long t2 = t1;
			int t3 = arg2.applyAsInt(t2);
			if (hasMin) {
				min = Math.min(min, t3);
			} else {
				hasMin = true;
				min = t3;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_mapToLong_boxed_mapToLong_min(Collection<T0> input, ToLongFunction<T0> arg0, ToLongFunction<Long> arg2) {
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			Long t2 = t1;
			long t3 = arg2.applyAsLong(t2);
			if (hasMin) {
				min = Math.min(min, t3);
			} else {
				hasMin = true;
				min = t3;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_mapToLong_boxed_mapToDouble_min(Collection<T0> input, ToLongFunction<T0> arg0, ToDoubleFunction<Long> arg2) {
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			Long t2 = t1;
			double t3 = arg2.applyAsDouble(t2);
			if (hasMin) {
				min = Math.min(min, t3);
			} else {
				hasMin = true;
				min = t3;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalLong stream_mapToLong_sorted_map_min(Collection<T0> input, ToLongFunction<T0> arg0, LongUnaryOperator arg2) {
		List<Long> sorted0 = new ArrayList<>();
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (long t1: sorted0) {
			t1 = arg2.applyAsLong(t1);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalLong stream_mapToLong_sorted_filter_min(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg2) {
		List<Long> sorted0 = new ArrayList<>();
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (long t1: sorted0) {
			if (!arg2.test(t1)) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalInt stream_mapToLong_sorted_mapToInt_min(Collection<T0> input, ToLongFunction<T0> arg0, LongToIntFunction arg2) {
		List<Long> sorted0 = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (long t1: sorted0) {
			int t2 = arg2.applyAsInt(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalDouble stream_mapToLong_sorted_mapToDouble_min(Collection<T0> input, ToLongFunction<T0> arg0, LongToDoubleFunction arg2) {
		List<Long> sorted0 = new ArrayList<>();
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (long t1: sorted0) {
			double t2 = arg2.applyAsDouble(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalLong stream_mapToLong_sorted_sorted_min(Collection<T0> input, ToLongFunction<T0> arg0) {
		List<Long> sorted0 = new ArrayList<>();
		List<Long> sorted1 = new ArrayList<>();
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (long t1: sorted0) {
			sorted1.add(t1);
		}
		Collections.sort((List) sorted1);
		for (long t1: sorted1) {
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalLong stream_mapToLong_sorted_limit_min(Collection<T0> input, ToLongFunction<T0> arg0, long arg2) {
		List<Long> sorted0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (long t1: sorted0) {
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalLong stream_mapToLong_sorted_skip_min(Collection<T0> input, ToLongFunction<T0> arg0, long arg2) {
		List<Long> sorted0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (long t1: sorted0) {
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalLong stream_mapToLong_limit_map_min(Collection<T0> input, ToLongFunction<T0> arg0, long arg1, LongUnaryOperator arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			t1 = arg2.applyAsLong(t1);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalLong stream_mapToLong_limit_filter_min(Collection<T0> input, ToLongFunction<T0> arg0, long arg1, LongPredicate arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			if (!arg2.test(t1)) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalInt stream_mapToLong_limit_mapToInt_min(Collection<T0> input, ToLongFunction<T0> arg0, long arg1, LongToIntFunction arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			int t2 = arg2.applyAsInt(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalDouble stream_mapToLong_limit_mapToDouble_min(Collection<T0> input, ToLongFunction<T0> arg0, long arg1, LongToDoubleFunction arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			double t2 = arg2.applyAsDouble(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalLong stream_mapToLong_limit_sorted_min(Collection<T0> input, ToLongFunction<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<Long> sorted0 = new ArrayList<>();
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (long t1: sorted0) {
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalLong stream_mapToLong_limit_limit_min(Collection<T0> input, ToLongFunction<T0> arg0, long arg1, long arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			limit1++;
			if(limit1 > arg2) {
				break;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalLong stream_mapToLong_limit_skip_min(Collection<T0> input, ToLongFunction<T0> arg0, long arg1, long arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalLong stream_mapToLong_skip_map_min(Collection<T0> input, ToLongFunction<T0> arg0, long arg1, LongUnaryOperator arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			t1 = arg2.applyAsLong(t1);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalLong stream_mapToLong_skip_filter_min(Collection<T0> input, ToLongFunction<T0> arg0, long arg1, LongPredicate arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if (!arg2.test(t1)) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalInt stream_mapToLong_skip_mapToInt_min(Collection<T0> input, ToLongFunction<T0> arg0, long arg1, LongToIntFunction arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			int t2 = arg2.applyAsInt(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalDouble stream_mapToLong_skip_mapToDouble_min(Collection<T0> input, ToLongFunction<T0> arg0, long arg1, LongToDoubleFunction arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			double t2 = arg2.applyAsDouble(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalLong stream_mapToLong_skip_sorted_min(Collection<T0> input, ToLongFunction<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<Long> sorted0 = new ArrayList<>();
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (long t1: sorted0) {
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalLong stream_mapToLong_skip_limit_min(Collection<T0> input, ToLongFunction<T0> arg0, long arg1, long arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalLong stream_mapToLong_skip_skip_min(Collection<T0> input, ToLongFunction<T0> arg0, long arg1, long arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			skip1++;
			if(skip1 <= arg2) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_mapToDouble_map_map_min(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleUnaryOperator arg1, DoubleUnaryOperator arg2) {
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			t1 = arg1.applyAsDouble(t1);
			t1 = arg2.applyAsDouble(t1);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalDouble stream_mapToDouble_map_filter_min(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleUnaryOperator arg1, DoublePredicate arg2) {
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			t1 = arg1.applyAsDouble(t1);
			if (!arg2.test(t1)) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_mapToDouble_map_mapToInt_min(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleUnaryOperator arg1, DoubleToIntFunction arg2) {
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			t1 = arg1.applyAsDouble(t1);
			int t2 = arg2.applyAsInt(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_mapToDouble_map_mapToLong_min(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleUnaryOperator arg1, DoubleToLongFunction arg2) {
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			t1 = arg1.applyAsDouble(t1);
			long t2 = arg2.applyAsLong(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_mapToDouble_map_sorted_min(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleUnaryOperator arg1) {
		List<Double> sorted0 = new ArrayList<>();
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			t1 = arg1.applyAsDouble(t1);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (double t1: sorted0) {
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalDouble stream_mapToDouble_map_limit_min(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleUnaryOperator arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			t1 = arg1.applyAsDouble(t1);
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalDouble stream_mapToDouble_map_skip_min(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleUnaryOperator arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			t1 = arg1.applyAsDouble(t1);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalDouble stream_mapToDouble_filter_map_min(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1, DoubleUnaryOperator arg2) {
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			t1 = arg2.applyAsDouble(t1);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalDouble stream_mapToDouble_filter_filter_min(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1, DoublePredicate arg2) {
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			if (!arg2.test(t1)) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_mapToDouble_filter_mapToInt_min(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1, DoubleToIntFunction arg2) {
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			int t2 = arg2.applyAsInt(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_mapToDouble_filter_mapToLong_min(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1, DoubleToLongFunction arg2) {
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			long t2 = arg2.applyAsLong(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_mapToDouble_filter_sorted_min(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1) {
		List<Double> sorted0 = new ArrayList<>();
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (double t1: sorted0) {
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalDouble stream_mapToDouble_filter_limit_min(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalDouble stream_mapToDouble_filter_skip_min(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_mapToDouble_mapToInt_map_min(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToIntFunction arg1, IntUnaryOperator arg2) {
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			int t2 = arg1.applyAsInt(t1);
			t2 = arg2.applyAsInt(t2);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalInt stream_mapToDouble_mapToInt_filter_min(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToIntFunction arg1, IntPredicate arg2) {
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			int t2 = arg1.applyAsInt(t1);
			if (!arg2.test(t2)) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_mapToDouble_mapToInt_mapToLong_min(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToIntFunction arg1, IntToLongFunction arg2) {
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			int t2 = arg1.applyAsInt(t1);
			long t3 = arg2.applyAsLong(t2);
			if (hasMin) {
				min = Math.min(min, t3);
			} else {
				hasMin = true;
				min = t3;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_mapToDouble_mapToInt_mapToDouble_min(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToIntFunction arg1, IntToDoubleFunction arg2) {
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			int t2 = arg1.applyAsInt(t1);
			double t3 = arg2.applyAsDouble(t2);
			if (hasMin) {
				min = Math.min(min, t3);
			} else {
				hasMin = true;
				min = t3;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_mapToDouble_mapToInt_sorted_min(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToIntFunction arg1) {
		List<Integer> sorted0 = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			int t2 = arg1.applyAsInt(t1);
			sorted0.add(t2);
		}
		Collections.sort((List) sorted0);
		for (int t2: sorted0) {
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalInt stream_mapToDouble_mapToInt_limit_min(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToIntFunction arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			int t2 = arg1.applyAsInt(t1);
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalInt stream_mapToDouble_mapToInt_skip_min(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToIntFunction arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			int t2 = arg1.applyAsInt(t1);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_mapToDouble_mapToLong_map_min(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToLongFunction arg1, LongUnaryOperator arg2) {
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			long t2 = arg1.applyAsLong(t1);
			t2 = arg2.applyAsLong(t2);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalLong stream_mapToDouble_mapToLong_filter_min(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToLongFunction arg1, LongPredicate arg2) {
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			long t2 = arg1.applyAsLong(t1);
			if (!arg2.test(t2)) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalInt stream_mapToDouble_mapToLong_mapToInt_min(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToLongFunction arg1, LongToIntFunction arg2) {
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			long t2 = arg1.applyAsLong(t1);
			int t3 = arg2.applyAsInt(t2);
			if (hasMin) {
				min = Math.min(min, t3);
			} else {
				hasMin = true;
				min = t3;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalDouble stream_mapToDouble_mapToLong_mapToDouble_min(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToLongFunction arg1, LongToDoubleFunction arg2) {
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			long t2 = arg1.applyAsLong(t1);
			double t3 = arg2.applyAsDouble(t2);
			if (hasMin) {
				min = Math.min(min, t3);
			} else {
				hasMin = true;
				min = t3;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalLong stream_mapToDouble_mapToLong_sorted_min(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToLongFunction arg1) {
		List<Long> sorted0 = new ArrayList<>();
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			long t2 = arg1.applyAsLong(t1);
			sorted0.add(t2);
		}
		Collections.sort((List) sorted0);
		for (long t2: sorted0) {
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalLong stream_mapToDouble_mapToLong_limit_min(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToLongFunction arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			long t2 = arg1.applyAsLong(t1);
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalLong stream_mapToDouble_mapToLong_skip_min(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToLongFunction arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			long t2 = arg1.applyAsLong(t1);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0, T2> OptionalInt stream_mapToDouble_mapToObj_mapToInt_min(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleFunction<T2> arg1, ToIntFunction<T2> arg2) {
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			T2 t2 = arg1.apply(t1);
			int t3 = arg2.applyAsInt(t2);
			if (hasMin) {
				min = Math.min(min, t3);
			} else {
				hasMin = true;
				min = t3;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0, T2> OptionalLong stream_mapToDouble_mapToObj_mapToLong_min(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleFunction<T2> arg1, ToLongFunction<T2> arg2) {
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			T2 t2 = arg1.apply(t1);
			long t3 = arg2.applyAsLong(t2);
			if (hasMin) {
				min = Math.min(min, t3);
			} else {
				hasMin = true;
				min = t3;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0, T2> OptionalDouble stream_mapToDouble_mapToObj_mapToDouble_min(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleFunction<T2> arg1, ToDoubleFunction<T2> arg2) {
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			T2 t2 = arg1.apply(t1);
			double t3 = arg2.applyAsDouble(t2);
			if (hasMin) {
				min = Math.min(min, t3);
			} else {
				hasMin = true;
				min = t3;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_mapToDouble_boxed_mapToInt_min(Collection<T0> input, ToDoubleFunction<T0> arg0, ToIntFunction<Double> arg2) {
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			Double t2 = t1;
			int t3 = arg2.applyAsInt(t2);
			if (hasMin) {
				min = Math.min(min, t3);
			} else {
				hasMin = true;
				min = t3;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_mapToDouble_boxed_mapToLong_min(Collection<T0> input, ToDoubleFunction<T0> arg0, ToLongFunction<Double> arg2) {
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			Double t2 = t1;
			long t3 = arg2.applyAsLong(t2);
			if (hasMin) {
				min = Math.min(min, t3);
			} else {
				hasMin = true;
				min = t3;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_mapToDouble_boxed_mapToDouble_min(Collection<T0> input, ToDoubleFunction<T0> arg0, ToDoubleFunction<Double> arg2) {
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			Double t2 = t1;
			double t3 = arg2.applyAsDouble(t2);
			if (hasMin) {
				min = Math.min(min, t3);
			} else {
				hasMin = true;
				min = t3;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalDouble stream_mapToDouble_sorted_map_min(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleUnaryOperator arg2) {
		List<Double> sorted0 = new ArrayList<>();
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (double t1: sorted0) {
			t1 = arg2.applyAsDouble(t1);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalDouble stream_mapToDouble_sorted_filter_min(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg2) {
		List<Double> sorted0 = new ArrayList<>();
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (double t1: sorted0) {
			if (!arg2.test(t1)) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_mapToDouble_sorted_mapToInt_min(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToIntFunction arg2) {
		List<Double> sorted0 = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (double t1: sorted0) {
			int t2 = arg2.applyAsInt(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_mapToDouble_sorted_mapToLong_min(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToLongFunction arg2) {
		List<Double> sorted0 = new ArrayList<>();
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (double t1: sorted0) {
			long t2 = arg2.applyAsLong(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_mapToDouble_sorted_sorted_min(Collection<T0> input, ToDoubleFunction<T0> arg0) {
		List<Double> sorted0 = new ArrayList<>();
		List<Double> sorted1 = new ArrayList<>();
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (double t1: sorted0) {
			sorted1.add(t1);
		}
		Collections.sort((List) sorted1);
		for (double t1: sorted1) {
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalDouble stream_mapToDouble_sorted_limit_min(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg2) {
		List<Double> sorted0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (double t1: sorted0) {
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalDouble stream_mapToDouble_sorted_skip_min(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg2) {
		List<Double> sorted0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (double t1: sorted0) {
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalDouble stream_mapToDouble_limit_map_min(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1, DoubleUnaryOperator arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			t1 = arg2.applyAsDouble(t1);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalDouble stream_mapToDouble_limit_filter_min(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1, DoublePredicate arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			if (!arg2.test(t1)) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_mapToDouble_limit_mapToInt_min(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1, DoubleToIntFunction arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			int t2 = arg2.applyAsInt(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_mapToDouble_limit_mapToLong_min(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1, DoubleToLongFunction arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			long t2 = arg2.applyAsLong(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_mapToDouble_limit_sorted_min(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<Double> sorted0 = new ArrayList<>();
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (double t1: sorted0) {
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalDouble stream_mapToDouble_limit_limit_min(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1, long arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			limit1++;
			if(limit1 > arg2) {
				break;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalDouble stream_mapToDouble_limit_skip_min(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1, long arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalDouble stream_mapToDouble_skip_map_min(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1, DoubleUnaryOperator arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			t1 = arg2.applyAsDouble(t1);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalDouble stream_mapToDouble_skip_filter_min(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1, DoublePredicate arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if (!arg2.test(t1)) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_mapToDouble_skip_mapToInt_min(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1, DoubleToIntFunction arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			int t2 = arg2.applyAsInt(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_mapToDouble_skip_mapToLong_min(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1, DoubleToLongFunction arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			long t2 = arg2.applyAsLong(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_mapToDouble_skip_sorted_min(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<Double> sorted0 = new ArrayList<>();
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (double t1: sorted0) {
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalDouble stream_mapToDouble_skip_limit_min(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1, long arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalDouble stream_mapToDouble_skip_skip_min(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1, long arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			skip1++;
			if(skip1 <= arg2) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0, T1> OptionalInt stream_sorted_map_mapToInt_min(Collection<T0> input, Function<T0, T1> arg1, ToIntFunction<T1> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			T1 t1 = arg1.apply(t0);
			int t2 = arg2.applyAsInt(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0, T1> OptionalLong stream_sorted_map_mapToLong_min(Collection<T0> input, Function<T0, T1> arg1, ToLongFunction<T1> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			T1 t1 = arg1.apply(t0);
			long t2 = arg2.applyAsLong(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0, T1> OptionalDouble stream_sorted_map_mapToDouble_min(Collection<T0> input, Function<T0, T1> arg1, ToDoubleFunction<T1> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			T1 t1 = arg1.apply(t0);
			double t2 = arg2.applyAsDouble(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_sorted_filter_mapToInt_min(Collection<T0> input, Predicate<T0> arg1, ToIntFunction<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if (!arg1.test(t0)) {
				continue;
			}
			int t1 = arg2.applyAsInt(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_sorted_filter_mapToLong_min(Collection<T0> input, Predicate<T0> arg1, ToLongFunction<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if (!arg1.test(t0)) {
				continue;
			}
			long t1 = arg2.applyAsLong(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_sorted_filter_mapToDouble_min(Collection<T0> input, Predicate<T0> arg1, ToDoubleFunction<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if (!arg1.test(t0)) {
				continue;
			}
			double t1 = arg2.applyAsDouble(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_sorted_mapToInt_map_min(Collection<T0> input, ToIntFunction<T0> arg1, IntUnaryOperator arg2) {
		List<T0> sorted0 = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			int t1 = arg1.applyAsInt(t0);
			t1 = arg2.applyAsInt(t1);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalInt stream_sorted_mapToInt_filter_min(Collection<T0> input, ToIntFunction<T0> arg1, IntPredicate arg2) {
		List<T0> sorted0 = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			int t1 = arg1.applyAsInt(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_sorted_mapToInt_mapToLong_min(Collection<T0> input, ToIntFunction<T0> arg1, IntToLongFunction arg2) {
		List<T0> sorted0 = new ArrayList<>();
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			int t1 = arg1.applyAsInt(t0);
			long t2 = arg2.applyAsLong(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_sorted_mapToInt_mapToDouble_min(Collection<T0> input, ToIntFunction<T0> arg1, IntToDoubleFunction arg2) {
		List<T0> sorted0 = new ArrayList<>();
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			int t1 = arg1.applyAsInt(t0);
			double t2 = arg2.applyAsDouble(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_sorted_mapToInt_sorted_min(Collection<T0> input, ToIntFunction<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		List<Integer> sorted1 = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			int t1 = arg1.applyAsInt(t0);
			sorted1.add(t1);
		}
		Collections.sort((List) sorted1);
		for (int t1: sorted1) {
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalInt stream_sorted_mapToInt_limit_min(Collection<T0> input, ToIntFunction<T0> arg1, long arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			int t1 = arg1.applyAsInt(t0);
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalInt stream_sorted_mapToInt_skip_min(Collection<T0> input, ToIntFunction<T0> arg1, long arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			int t1 = arg1.applyAsInt(t0);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_sorted_mapToLong_map_min(Collection<T0> input, ToLongFunction<T0> arg1, LongUnaryOperator arg2) {
		List<T0> sorted0 = new ArrayList<>();
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			long t1 = arg1.applyAsLong(t0);
			t1 = arg2.applyAsLong(t1);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalLong stream_sorted_mapToLong_filter_min(Collection<T0> input, ToLongFunction<T0> arg1, LongPredicate arg2) {
		List<T0> sorted0 = new ArrayList<>();
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			long t1 = arg1.applyAsLong(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalInt stream_sorted_mapToLong_mapToInt_min(Collection<T0> input, ToLongFunction<T0> arg1, LongToIntFunction arg2) {
		List<T0> sorted0 = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			long t1 = arg1.applyAsLong(t0);
			int t2 = arg2.applyAsInt(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalDouble stream_sorted_mapToLong_mapToDouble_min(Collection<T0> input, ToLongFunction<T0> arg1, LongToDoubleFunction arg2) {
		List<T0> sorted0 = new ArrayList<>();
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			long t1 = arg1.applyAsLong(t0);
			double t2 = arg2.applyAsDouble(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalLong stream_sorted_mapToLong_sorted_min(Collection<T0> input, ToLongFunction<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		List<Long> sorted1 = new ArrayList<>();
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			long t1 = arg1.applyAsLong(t0);
			sorted1.add(t1);
		}
		Collections.sort((List) sorted1);
		for (long t1: sorted1) {
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalLong stream_sorted_mapToLong_limit_min(Collection<T0> input, ToLongFunction<T0> arg1, long arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			long t1 = arg1.applyAsLong(t0);
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalLong stream_sorted_mapToLong_skip_min(Collection<T0> input, ToLongFunction<T0> arg1, long arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			long t1 = arg1.applyAsLong(t0);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_sorted_mapToDouble_map_min(Collection<T0> input, ToDoubleFunction<T0> arg1, DoubleUnaryOperator arg2) {
		List<T0> sorted0 = new ArrayList<>();
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			double t1 = arg1.applyAsDouble(t0);
			t1 = arg2.applyAsDouble(t1);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalDouble stream_sorted_mapToDouble_filter_min(Collection<T0> input, ToDoubleFunction<T0> arg1, DoublePredicate arg2) {
		List<T0> sorted0 = new ArrayList<>();
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			double t1 = arg1.applyAsDouble(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_sorted_mapToDouble_mapToInt_min(Collection<T0> input, ToDoubleFunction<T0> arg1, DoubleToIntFunction arg2) {
		List<T0> sorted0 = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			double t1 = arg1.applyAsDouble(t0);
			int t2 = arg2.applyAsInt(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_sorted_mapToDouble_mapToLong_min(Collection<T0> input, ToDoubleFunction<T0> arg1, DoubleToLongFunction arg2) {
		List<T0> sorted0 = new ArrayList<>();
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			double t1 = arg1.applyAsDouble(t0);
			long t2 = arg2.applyAsLong(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_sorted_mapToDouble_sorted_min(Collection<T0> input, ToDoubleFunction<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		List<Double> sorted1 = new ArrayList<>();
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			double t1 = arg1.applyAsDouble(t0);
			sorted1.add(t1);
		}
		Collections.sort((List) sorted1);
		for (double t1: sorted1) {
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalDouble stream_sorted_mapToDouble_limit_min(Collection<T0> input, ToDoubleFunction<T0> arg1, long arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			double t1 = arg1.applyAsDouble(t0);
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalDouble stream_sorted_mapToDouble_skip_min(Collection<T0> input, ToDoubleFunction<T0> arg1, long arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			double t1 = arg1.applyAsDouble(t0);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_sorted_sorted_mapToInt_min(Collection<T0> input, ToIntFunction<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
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
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_sorted_sorted_mapToLong_min(Collection<T0> input, ToLongFunction<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
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
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_sorted_sorted_mapToDouble_min(Collection<T0> input, ToDoubleFunction<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
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
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_sorted_sortedComp_mapToInt_min(Collection<T0> input, Comparator<? super T0> arg1, ToIntFunction<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
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
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_sorted_sortedComp_mapToLong_min(Collection<T0> input, Comparator<? super T0> arg1, ToLongFunction<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
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
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_sorted_sortedComp_mapToDouble_min(Collection<T0> input, Comparator<? super T0> arg1, ToDoubleFunction<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
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
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_sorted_limit_mapToInt_min(Collection<T0> input, long arg1, ToIntFunction<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			int t1 = arg2.applyAsInt(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_sorted_limit_mapToLong_min(Collection<T0> input, long arg1, ToLongFunction<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			long t1 = arg2.applyAsLong(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_sorted_limit_mapToDouble_min(Collection<T0> input, long arg1, ToDoubleFunction<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			double t1 = arg2.applyAsDouble(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_sorted_skip_mapToInt_min(Collection<T0> input, long arg1, ToIntFunction<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			int t1 = arg2.applyAsInt(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_sorted_skip_mapToLong_min(Collection<T0> input, long arg1, ToLongFunction<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			long t1 = arg2.applyAsLong(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_sorted_skip_mapToDouble_min(Collection<T0> input, long arg1, ToDoubleFunction<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			double t1 = arg2.applyAsDouble(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0, T1> OptionalInt stream_sortedComp_map_mapToInt_min(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, T1> arg1, ToIntFunction<T1> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			T1 t1 = arg1.apply(t0);
			int t2 = arg2.applyAsInt(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0, T1> OptionalLong stream_sortedComp_map_mapToLong_min(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, T1> arg1, ToLongFunction<T1> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			T1 t1 = arg1.apply(t0);
			long t2 = arg2.applyAsLong(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0, T1> OptionalDouble stream_sortedComp_map_mapToDouble_min(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, T1> arg1, ToDoubleFunction<T1> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			T1 t1 = arg1.apply(t0);
			double t2 = arg2.applyAsDouble(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_sortedComp_filter_mapToInt_min(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, ToIntFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if (!arg1.test(t0)) {
				continue;
			}
			int t1 = arg2.applyAsInt(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_sortedComp_filter_mapToLong_min(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, ToLongFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if (!arg1.test(t0)) {
				continue;
			}
			long t1 = arg2.applyAsLong(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_sortedComp_filter_mapToDouble_min(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, ToDoubleFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if (!arg1.test(t0)) {
				continue;
			}
			double t1 = arg2.applyAsDouble(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_sortedComp_mapToInt_map_min(Collection<T0> input, Comparator<? super T0> arg0, ToIntFunction<T0> arg1, IntUnaryOperator arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			int t1 = arg1.applyAsInt(t0);
			t1 = arg2.applyAsInt(t1);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalInt stream_sortedComp_mapToInt_filter_min(Collection<T0> input, Comparator<? super T0> arg0, ToIntFunction<T0> arg1, IntPredicate arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			int t1 = arg1.applyAsInt(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_sortedComp_mapToInt_mapToLong_min(Collection<T0> input, Comparator<? super T0> arg0, ToIntFunction<T0> arg1, IntToLongFunction arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			int t1 = arg1.applyAsInt(t0);
			long t2 = arg2.applyAsLong(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_sortedComp_mapToInt_mapToDouble_min(Collection<T0> input, Comparator<? super T0> arg0, ToIntFunction<T0> arg1, IntToDoubleFunction arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			int t1 = arg1.applyAsInt(t0);
			double t2 = arg2.applyAsDouble(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_sortedComp_mapToInt_sorted_min(Collection<T0> input, Comparator<? super T0> arg0, ToIntFunction<T0> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<Integer> sorted0 = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			int t1 = arg1.applyAsInt(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (int t1: sorted0) {
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalInt stream_sortedComp_mapToInt_limit_min(Collection<T0> input, Comparator<? super T0> arg0, ToIntFunction<T0> arg1, long arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			int t1 = arg1.applyAsInt(t0);
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalInt stream_sortedComp_mapToInt_skip_min(Collection<T0> input, Comparator<? super T0> arg0, ToIntFunction<T0> arg1, long arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			int t1 = arg1.applyAsInt(t0);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_sortedComp_mapToLong_map_min(Collection<T0> input, Comparator<? super T0> arg0, ToLongFunction<T0> arg1, LongUnaryOperator arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			long t1 = arg1.applyAsLong(t0);
			t1 = arg2.applyAsLong(t1);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalLong stream_sortedComp_mapToLong_filter_min(Collection<T0> input, Comparator<? super T0> arg0, ToLongFunction<T0> arg1, LongPredicate arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			long t1 = arg1.applyAsLong(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalInt stream_sortedComp_mapToLong_mapToInt_min(Collection<T0> input, Comparator<? super T0> arg0, ToLongFunction<T0> arg1, LongToIntFunction arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			long t1 = arg1.applyAsLong(t0);
			int t2 = arg2.applyAsInt(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalDouble stream_sortedComp_mapToLong_mapToDouble_min(Collection<T0> input, Comparator<? super T0> arg0, ToLongFunction<T0> arg1, LongToDoubleFunction arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			long t1 = arg1.applyAsLong(t0);
			double t2 = arg2.applyAsDouble(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalLong stream_sortedComp_mapToLong_sorted_min(Collection<T0> input, Comparator<? super T0> arg0, ToLongFunction<T0> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<Long> sorted0 = new ArrayList<>();
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			long t1 = arg1.applyAsLong(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (long t1: sorted0) {
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalLong stream_sortedComp_mapToLong_limit_min(Collection<T0> input, Comparator<? super T0> arg0, ToLongFunction<T0> arg1, long arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			long t1 = arg1.applyAsLong(t0);
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalLong stream_sortedComp_mapToLong_skip_min(Collection<T0> input, Comparator<? super T0> arg0, ToLongFunction<T0> arg1, long arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			long t1 = arg1.applyAsLong(t0);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_sortedComp_mapToDouble_map_min(Collection<T0> input, Comparator<? super T0> arg0, ToDoubleFunction<T0> arg1, DoubleUnaryOperator arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			double t1 = arg1.applyAsDouble(t0);
			t1 = arg2.applyAsDouble(t1);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalDouble stream_sortedComp_mapToDouble_filter_min(Collection<T0> input, Comparator<? super T0> arg0, ToDoubleFunction<T0> arg1, DoublePredicate arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			double t1 = arg1.applyAsDouble(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_sortedComp_mapToDouble_mapToInt_min(Collection<T0> input, Comparator<? super T0> arg0, ToDoubleFunction<T0> arg1, DoubleToIntFunction arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			double t1 = arg1.applyAsDouble(t0);
			int t2 = arg2.applyAsInt(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_sortedComp_mapToDouble_mapToLong_min(Collection<T0> input, Comparator<? super T0> arg0, ToDoubleFunction<T0> arg1, DoubleToLongFunction arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			double t1 = arg1.applyAsDouble(t0);
			long t2 = arg2.applyAsLong(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_sortedComp_mapToDouble_sorted_min(Collection<T0> input, Comparator<? super T0> arg0, ToDoubleFunction<T0> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<Double> sorted0 = new ArrayList<>();
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			double t1 = arg1.applyAsDouble(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (double t1: sorted0) {
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalDouble stream_sortedComp_mapToDouble_limit_min(Collection<T0> input, Comparator<? super T0> arg0, ToDoubleFunction<T0> arg1, long arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			double t1 = arg1.applyAsDouble(t0);
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalDouble stream_sortedComp_mapToDouble_skip_min(Collection<T0> input, Comparator<? super T0> arg0, ToDoubleFunction<T0> arg1, long arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			double t1 = arg1.applyAsDouble(t0);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_sortedComp_sorted_mapToInt_min(Collection<T0> input, Comparator<? super T0> arg0, ToIntFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
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
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_sortedComp_sorted_mapToLong_min(Collection<T0> input, Comparator<? super T0> arg0, ToLongFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
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
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_sortedComp_sorted_mapToDouble_min(Collection<T0> input, Comparator<? super T0> arg0, ToDoubleFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
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
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_sortedComp_sortedComp_mapToInt_min(Collection<T0> input, Comparator<? super T0> arg0, Comparator<? super T0> arg1, ToIntFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
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
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_sortedComp_sortedComp_mapToLong_min(Collection<T0> input, Comparator<? super T0> arg0, Comparator<? super T0> arg1, ToLongFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
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
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_sortedComp_sortedComp_mapToDouble_min(Collection<T0> input, Comparator<? super T0> arg0, Comparator<? super T0> arg1, ToDoubleFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
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
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_sortedComp_limit_mapToInt_min(Collection<T0> input, Comparator<? super T0> arg0, long arg1, ToIntFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			int t1 = arg2.applyAsInt(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_sortedComp_limit_mapToLong_min(Collection<T0> input, Comparator<? super T0> arg0, long arg1, ToLongFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			long t1 = arg2.applyAsLong(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_sortedComp_limit_mapToDouble_min(Collection<T0> input, Comparator<? super T0> arg0, long arg1, ToDoubleFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			double t1 = arg2.applyAsDouble(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_sortedComp_skip_mapToInt_min(Collection<T0> input, Comparator<? super T0> arg0, long arg1, ToIntFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			int t1 = arg2.applyAsInt(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_sortedComp_skip_mapToLong_min(Collection<T0> input, Comparator<? super T0> arg0, long arg1, ToLongFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			long t1 = arg2.applyAsLong(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_sortedComp_skip_mapToDouble_min(Collection<T0> input, Comparator<? super T0> arg0, long arg1, ToDoubleFunction<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			double t1 = arg2.applyAsDouble(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0, T1> OptionalInt stream_limit_map_mapToInt_min(Collection<T0> input, long arg0, Function<T0, T1> arg1, ToIntFunction<T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			T1 t1 = arg1.apply(t0);
			int t2 = arg2.applyAsInt(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0, T1> OptionalLong stream_limit_map_mapToLong_min(Collection<T0> input, long arg0, Function<T0, T1> arg1, ToLongFunction<T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			T1 t1 = arg1.apply(t0);
			long t2 = arg2.applyAsLong(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0, T1> OptionalDouble stream_limit_map_mapToDouble_min(Collection<T0> input, long arg0, Function<T0, T1> arg1, ToDoubleFunction<T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			T1 t1 = arg1.apply(t0);
			double t2 = arg2.applyAsDouble(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_limit_filter_mapToInt_min(Collection<T0> input, long arg0, Predicate<T0> arg1, ToIntFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			int t1 = arg2.applyAsInt(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_limit_filter_mapToLong_min(Collection<T0> input, long arg0, Predicate<T0> arg1, ToLongFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			long t1 = arg2.applyAsLong(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_limit_filter_mapToDouble_min(Collection<T0> input, long arg0, Predicate<T0> arg1, ToDoubleFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			double t1 = arg2.applyAsDouble(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_limit_mapToInt_map_min(Collection<T0> input, long arg0, ToIntFunction<T0> arg1, IntUnaryOperator arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			int t1 = arg1.applyAsInt(t0);
			t1 = arg2.applyAsInt(t1);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalInt stream_limit_mapToInt_filter_min(Collection<T0> input, long arg0, ToIntFunction<T0> arg1, IntPredicate arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			int t1 = arg1.applyAsInt(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_limit_mapToInt_mapToLong_min(Collection<T0> input, long arg0, ToIntFunction<T0> arg1, IntToLongFunction arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			int t1 = arg1.applyAsInt(t0);
			long t2 = arg2.applyAsLong(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_limit_mapToInt_mapToDouble_min(Collection<T0> input, long arg0, ToIntFunction<T0> arg1, IntToDoubleFunction arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			int t1 = arg1.applyAsInt(t0);
			double t2 = arg2.applyAsDouble(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_limit_mapToInt_sorted_min(Collection<T0> input, long arg0, ToIntFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<Integer> sorted0 = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			int t1 = arg1.applyAsInt(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (int t1: sorted0) {
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalInt stream_limit_mapToInt_limit_min(Collection<T0> input, long arg0, ToIntFunction<T0> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			int t1 = arg1.applyAsInt(t0);
			limit1++;
			if(limit1 > arg2) {
				break;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalInt stream_limit_mapToInt_skip_min(Collection<T0> input, long arg0, ToIntFunction<T0> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			int t1 = arg1.applyAsInt(t0);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_limit_mapToLong_map_min(Collection<T0> input, long arg0, ToLongFunction<T0> arg1, LongUnaryOperator arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			long t1 = arg1.applyAsLong(t0);
			t1 = arg2.applyAsLong(t1);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalLong stream_limit_mapToLong_filter_min(Collection<T0> input, long arg0, ToLongFunction<T0> arg1, LongPredicate arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			long t1 = arg1.applyAsLong(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalInt stream_limit_mapToLong_mapToInt_min(Collection<T0> input, long arg0, ToLongFunction<T0> arg1, LongToIntFunction arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			long t1 = arg1.applyAsLong(t0);
			int t2 = arg2.applyAsInt(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalDouble stream_limit_mapToLong_mapToDouble_min(Collection<T0> input, long arg0, ToLongFunction<T0> arg1, LongToDoubleFunction arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			long t1 = arg1.applyAsLong(t0);
			double t2 = arg2.applyAsDouble(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalLong stream_limit_mapToLong_sorted_min(Collection<T0> input, long arg0, ToLongFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<Long> sorted0 = new ArrayList<>();
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			long t1 = arg1.applyAsLong(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (long t1: sorted0) {
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalLong stream_limit_mapToLong_limit_min(Collection<T0> input, long arg0, ToLongFunction<T0> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			long t1 = arg1.applyAsLong(t0);
			limit1++;
			if(limit1 > arg2) {
				break;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalLong stream_limit_mapToLong_skip_min(Collection<T0> input, long arg0, ToLongFunction<T0> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			long t1 = arg1.applyAsLong(t0);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_limit_mapToDouble_map_min(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1, DoubleUnaryOperator arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			double t1 = arg1.applyAsDouble(t0);
			t1 = arg2.applyAsDouble(t1);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalDouble stream_limit_mapToDouble_filter_min(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1, DoublePredicate arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			double t1 = arg1.applyAsDouble(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_limit_mapToDouble_mapToInt_min(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1, DoubleToIntFunction arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			double t1 = arg1.applyAsDouble(t0);
			int t2 = arg2.applyAsInt(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_limit_mapToDouble_mapToLong_min(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1, DoubleToLongFunction arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			double t1 = arg1.applyAsDouble(t0);
			long t2 = arg2.applyAsLong(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_limit_mapToDouble_sorted_min(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<Double> sorted0 = new ArrayList<>();
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			double t1 = arg1.applyAsDouble(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (double t1: sorted0) {
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalDouble stream_limit_mapToDouble_limit_min(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			double t1 = arg1.applyAsDouble(t0);
			limit1++;
			if(limit1 > arg2) {
				break;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalDouble stream_limit_mapToDouble_skip_min(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			double t1 = arg1.applyAsDouble(t0);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_limit_sorted_mapToInt_min(Collection<T0> input, long arg0, ToIntFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			int t1 = arg2.applyAsInt(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_limit_sorted_mapToLong_min(Collection<T0> input, long arg0, ToLongFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			long t1 = arg2.applyAsLong(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_limit_sorted_mapToDouble_min(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			double t1 = arg2.applyAsDouble(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_limit_sortedComp_mapToInt_min(Collection<T0> input, long arg0, Comparator<? super T0> arg1, ToIntFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			int t1 = arg2.applyAsInt(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_limit_sortedComp_mapToLong_min(Collection<T0> input, long arg0, Comparator<? super T0> arg1, ToLongFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			long t1 = arg2.applyAsLong(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_limit_sortedComp_mapToDouble_min(Collection<T0> input, long arg0, Comparator<? super T0> arg1, ToDoubleFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			double t1 = arg2.applyAsDouble(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_limit_limit_mapToInt_min(Collection<T0> input, long arg0, long arg1, ToIntFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			limit1++;
			if(limit1 > arg1) {
				break;
			}
			int t1 = arg2.applyAsInt(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_limit_limit_mapToLong_min(Collection<T0> input, long arg0, long arg1, ToLongFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			limit1++;
			if(limit1 > arg1) {
				break;
			}
			long t1 = arg2.applyAsLong(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_limit_limit_mapToDouble_min(Collection<T0> input, long arg0, long arg1, ToDoubleFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			limit1++;
			if(limit1 > arg1) {
				break;
			}
			double t1 = arg2.applyAsDouble(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_limit_skip_mapToInt_min(Collection<T0> input, long arg0, long arg1, ToIntFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			int t1 = arg2.applyAsInt(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_limit_skip_mapToLong_min(Collection<T0> input, long arg0, long arg1, ToLongFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			long t1 = arg2.applyAsLong(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_limit_skip_mapToDouble_min(Collection<T0> input, long arg0, long arg1, ToDoubleFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			double t1 = arg2.applyAsDouble(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0, T1> OptionalInt stream_skip_map_mapToInt_min(Collection<T0> input, long arg0, Function<T0, T1> arg1, ToIntFunction<T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			int t2 = arg2.applyAsInt(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0, T1> OptionalLong stream_skip_map_mapToLong_min(Collection<T0> input, long arg0, Function<T0, T1> arg1, ToLongFunction<T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			long t2 = arg2.applyAsLong(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0, T1> OptionalDouble stream_skip_map_mapToDouble_min(Collection<T0> input, long arg0, Function<T0, T1> arg1, ToDoubleFunction<T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			double t2 = arg2.applyAsDouble(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_skip_filter_mapToInt_min(Collection<T0> input, long arg0, Predicate<T0> arg1, ToIntFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			int t1 = arg2.applyAsInt(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_skip_filter_mapToLong_min(Collection<T0> input, long arg0, Predicate<T0> arg1, ToLongFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			long t1 = arg2.applyAsLong(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_skip_filter_mapToDouble_min(Collection<T0> input, long arg0, Predicate<T0> arg1, ToDoubleFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			double t1 = arg2.applyAsDouble(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_skip_mapToInt_map_min(Collection<T0> input, long arg0, ToIntFunction<T0> arg1, IntUnaryOperator arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			t1 = arg2.applyAsInt(t1);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalInt stream_skip_mapToInt_filter_min(Collection<T0> input, long arg0, ToIntFunction<T0> arg1, IntPredicate arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_skip_mapToInt_mapToLong_min(Collection<T0> input, long arg0, ToIntFunction<T0> arg1, IntToLongFunction arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			long t2 = arg2.applyAsLong(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_skip_mapToInt_mapToDouble_min(Collection<T0> input, long arg0, ToIntFunction<T0> arg1, IntToDoubleFunction arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			double t2 = arg2.applyAsDouble(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_skip_mapToInt_sorted_min(Collection<T0> input, long arg0, ToIntFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<Integer> sorted0 = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (int t1: sorted0) {
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalInt stream_skip_mapToInt_limit_min(Collection<T0> input, long arg0, ToIntFunction<T0> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalInt stream_skip_mapToInt_skip_min(Collection<T0> input, long arg0, ToIntFunction<T0> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			skip1++;
			if(skip1 <= arg2) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_skip_mapToLong_map_min(Collection<T0> input, long arg0, ToLongFunction<T0> arg1, LongUnaryOperator arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			t1 = arg2.applyAsLong(t1);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalLong stream_skip_mapToLong_filter_min(Collection<T0> input, long arg0, ToLongFunction<T0> arg1, LongPredicate arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalInt stream_skip_mapToLong_mapToInt_min(Collection<T0> input, long arg0, ToLongFunction<T0> arg1, LongToIntFunction arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			int t2 = arg2.applyAsInt(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalDouble stream_skip_mapToLong_mapToDouble_min(Collection<T0> input, long arg0, ToLongFunction<T0> arg1, LongToDoubleFunction arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			double t2 = arg2.applyAsDouble(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalLong stream_skip_mapToLong_sorted_min(Collection<T0> input, long arg0, ToLongFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<Long> sorted0 = new ArrayList<>();
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (long t1: sorted0) {
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalLong stream_skip_mapToLong_limit_min(Collection<T0> input, long arg0, ToLongFunction<T0> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalLong stream_skip_mapToLong_skip_min(Collection<T0> input, long arg0, ToLongFunction<T0> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			skip1++;
			if(skip1 <= arg2) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_skip_mapToDouble_map_min(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1, DoubleUnaryOperator arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			t1 = arg2.applyAsDouble(t1);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalDouble stream_skip_mapToDouble_filter_min(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1, DoublePredicate arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_skip_mapToDouble_mapToInt_min(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1, DoubleToIntFunction arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			int t2 = arg2.applyAsInt(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_skip_mapToDouble_mapToLong_min(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1, DoubleToLongFunction arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			long t2 = arg2.applyAsLong(t1);
			if (hasMin) {
				min = Math.min(min, t2);
			} else {
				hasMin = true;
				min = t2;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_skip_mapToDouble_sorted_min(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<Double> sorted0 = new ArrayList<>();
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (double t1: sorted0) {
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalDouble stream_skip_mapToDouble_limit_min(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalDouble stream_skip_mapToDouble_skip_min(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			skip1++;
			if(skip1 <= arg2) {
				continue;
			}
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_skip_sorted_mapToInt_min(Collection<T0> input, long arg0, ToIntFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			int t1 = arg2.applyAsInt(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_skip_sorted_mapToLong_min(Collection<T0> input, long arg0, ToLongFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			long t1 = arg2.applyAsLong(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_skip_sorted_mapToDouble_min(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			double t1 = arg2.applyAsDouble(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_skip_sortedComp_mapToInt_min(Collection<T0> input, long arg0, Comparator<? super T0> arg1, ToIntFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			int t1 = arg2.applyAsInt(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_skip_sortedComp_mapToLong_min(Collection<T0> input, long arg0, Comparator<? super T0> arg1, ToLongFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			long t1 = arg2.applyAsLong(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_skip_sortedComp_mapToDouble_min(Collection<T0> input, long arg0, Comparator<? super T0> arg1, ToDoubleFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			double t1 = arg2.applyAsDouble(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_skip_limit_mapToInt_min(Collection<T0> input, long arg0, long arg1, ToIntFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			int t1 = arg2.applyAsInt(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_skip_limit_mapToLong_min(Collection<T0> input, long arg0, long arg1, ToLongFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			long t1 = arg2.applyAsLong(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_skip_limit_mapToDouble_min(Collection<T0> input, long arg0, long arg1, ToDoubleFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			double t1 = arg2.applyAsDouble(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}

	public static <T0> OptionalInt stream_skip_skip_mapToInt_min(Collection<T0> input, long arg0, long arg1, ToIntFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		int min = Integer.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			skip1++;
			if(skip1 <= arg1) {
				continue;
			}
			int t1 = arg2.applyAsInt(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalInt.of(min);
		}
		return OptionalInt.empty();
	}

	public static <T0> OptionalLong stream_skip_skip_mapToLong_min(Collection<T0> input, long arg0, long arg1, ToLongFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		long min = Long.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			skip1++;
			if(skip1 <= arg1) {
				continue;
			}
			long t1 = arg2.applyAsLong(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalLong.of(min);
		}
		return OptionalLong.empty();
	}

	public static <T0> OptionalDouble stream_skip_skip_mapToDouble_min(Collection<T0> input, long arg0, long arg1, ToDoubleFunction<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		double min = Double.MAX_VALUE;
		boolean hasMin = false;
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			skip1++;
			if(skip1 <= arg1) {
				continue;
			}
			double t1 = arg2.applyAsDouble(t0);
			if (hasMin) {
				min = Math.min(min, t1);
			} else {
				hasMin = true;
				min = t1;
			}
		}
		if (hasMin) {
			return OptionalDouble.of(min);
		}
		return OptionalDouble.empty();
	}


}
