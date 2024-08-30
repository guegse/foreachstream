package io.github.guegse.foreachstream;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class ForeachStreamToList {

	public static <T0> List<T0> stream_toList(Collection<T0> input) {
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_toList(Collection<T0> input, Function<T0, T1> arg0) {
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_toList(Collection<T0> input, Predicate<T0> arg0) {
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_toList(Collection<T0> input) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_toList(Collection<T0> input, Comparator<? super T0> arg0) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_toList(Collection<T0> input, long arg0) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_toList(Collection<T0> input, long arg0) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_toList(Collection<T0> input) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_toList(Collection<T0> input, Predicate<T0> arg0) {
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_toList(Collection<T0> input, Predicate<T0> arg0) {
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0) {
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_map_map_toList(Collection<T0> input, Function<T0, T1> arg0, Function<T1, T2> arg1) {
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			T2 t2 = arg1.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_filter_toList(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1) {
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_sorted_toList(Collection<T0> input, Function<T0, T1> arg0) {
		List<T1> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_sortedComp_toList(Collection<T0> input, Function<T0, T1> arg0, Comparator<? super T1> arg1) {
		List<T1> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_limit_toList(Collection<T0> input, Function<T0, T1> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_skip_toList(Collection<T0> input, Function<T0, T1> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_distinct_toList(Collection<T0> input, Function<T0, T1> arg0) {
		Set<T1> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_dropWhile_toList(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1) {
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_takeWhile_toList(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1) {
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if(!arg1.test(t1)) {
				break;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_map_flatMap_toList(Collection<T0> input, Function<T0, T1> arg0, Function<T1, Collection<T2>> arg1) {
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			for (T2 t2 : arg1.apply(t1)) {
				result.add(t2);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_filter_map_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1) {
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_filter_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1) {
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_sorted_toList(Collection<T0> input, Predicate<T0> arg0) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_sortedComp_toList(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_limit_toList(Collection<T0> input, Predicate<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_skip_toList(Collection<T0> input, Predicate<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_distinct_toList(Collection<T0> input, Predicate<T0> arg0) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_dropWhile_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1) {
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_takeWhile_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1) {
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_filter_flatMap_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1) {
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToInt_mapToObj_toList(Collection<T0> input, ToIntFunction<T0> arg0, IntFunction<T2> arg1) {
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			T2 t2 = arg1.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Integer> stream_mapToInt_boxed_toList(Collection<T0> input, ToIntFunction<T0> arg0) {
		List<Integer> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			Integer t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToLong_mapToObj_toList(Collection<T0> input, ToLongFunction<T0> arg0, LongFunction<T2> arg1) {
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			T2 t2 = arg1.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Long> stream_mapToLong_boxed_toList(Collection<T0> input, ToLongFunction<T0> arg0) {
		List<Long> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			Long t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToDouble_mapToObj_toList(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleFunction<T2> arg1) {
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			T2 t2 = arg1.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Double> stream_mapToDouble_boxed_toList(Collection<T0> input, ToDoubleFunction<T0> arg0) {
		List<Double> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			Double t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sorted_map_toList(Collection<T0> input, Function<T0, T1> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			T1 t1 = arg1.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_filter_toList(Collection<T0> input, Predicate<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if (!arg1.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_sorted_toList(Collection<T0> input) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			sorted1.add(t0);
		}
		Collections.sort((List) sorted1);
		for (T0 t0: sorted1) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_sortedComp_toList(Collection<T0> input, Comparator<? super T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_limit_toList(Collection<T0> input, long arg1) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_skip_toList(Collection<T0> input, long arg1) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_distinct_toList(Collection<T0> input) {
		List<T0> sorted0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_dropWhile_toList(Collection<T0> input, Predicate<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_takeWhile_toList(Collection<T0> input, Predicate<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(!arg1.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sorted_flatMap_toList(Collection<T0> input, Function<T0, Collection<T1>> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			for (T1 t1 : arg1.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sortedComp_map_toList(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, T1> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			T1 t1 = arg1.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_filter_toList(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if (!arg1.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_sorted_toList(Collection<T0> input, Comparator<? super T0> arg0) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_sortedComp_toList(Collection<T0> input, Comparator<? super T0> arg0, Comparator<? super T0> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sortedComp1.add(t0);
		}
		sortedComp1.sort(arg1);
		for (T0 t0: sortedComp1) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_limit_toList(Collection<T0> input, Comparator<? super T0> arg0, long arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_skip_toList(Collection<T0> input, Comparator<? super T0> arg0, long arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_distinct_toList(Collection<T0> input, Comparator<? super T0> arg0) {
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_dropWhile_toList(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_takeWhile_toList(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!arg1.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sortedComp_flatMap_toList(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, Collection<T1>> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : arg1.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_limit_map_toList(Collection<T0> input, long arg0, Function<T0, T1> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			T1 t1 = arg1.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_filter_toList(Collection<T0> input, long arg0, Predicate<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_sorted_toList(Collection<T0> input, long arg0) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_sortedComp_toList(Collection<T0> input, long arg0, Comparator<? super T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_limit_toList(Collection<T0> input, long arg0, long arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			limit1++;
			if(limit1 > arg1) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_skip_toList(Collection<T0> input, long arg0, long arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_distinct_toList(Collection<T0> input, long arg0) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_dropWhile_toList(Collection<T0> input, long arg0, Predicate<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_takeWhile_toList(Collection<T0> input, long arg0, Predicate<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			if(!arg1.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_limit_flatMap_toList(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			for (T1 t1 : arg1.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_skip_map_toList(Collection<T0> input, long arg0, Function<T0, T1> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_filter_toList(Collection<T0> input, long arg0, Predicate<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_sorted_toList(Collection<T0> input, long arg0) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_sortedComp_toList(Collection<T0> input, long arg0, Comparator<? super T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_limit_toList(Collection<T0> input, long arg0, long arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_skip_toList(Collection<T0> input, long arg0, long arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			skip1++;
			if(skip1 <= arg1) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_distinct_toList(Collection<T0> input, long arg0) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_dropWhile_toList(Collection<T0> input, long arg0, Predicate<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_takeWhile_toList(Collection<T0> input, long arg0, Predicate<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_skip_flatMap_toList(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_distinct_map_toList(Collection<T0> input, Function<T0, T1> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_filter_toList(Collection<T0> input, Predicate<T0> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_sorted_toList(Collection<T0> input) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_sortedComp_toList(Collection<T0> input, Comparator<? super T0> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_limit_toList(Collection<T0> input, long arg1) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_skip_toList(Collection<T0> input, long arg1) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_distinct_toList(Collection<T0> input) {
		Set<T0> distinct0 = new HashSet<>();
		Set<T0> distinct1 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!distinct1.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_dropWhile_toList(Collection<T0> input, Predicate<T0> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_takeWhile_toList(Collection<T0> input, Predicate<T0> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_distinct_flatMap_toList(Collection<T0> input, Function<T0, Collection<T1>> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_dropWhile_map_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1) {
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			T1 t1 = arg1.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_filter_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1) {
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_sorted_toList(Collection<T0> input, Predicate<T0> arg0) {
		boolean dropWhile0 = true;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_sortedComp_toList(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1) {
		boolean dropWhile0 = true;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_limit_toList(Collection<T0> input, Predicate<T0> arg0, long arg1) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_skip_toList(Collection<T0> input, Predicate<T0> arg0, long arg1) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_distinct_toList(Collection<T0> input, Predicate<T0> arg0) {
		boolean dropWhile0 = true;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_dropWhile_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_takeWhile_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1) {
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!arg1.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_dropWhile_flatMap_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1) {
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : arg1.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_takeWhile_map_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1) {
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			T1 t1 = arg1.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_filter_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1) {
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_sorted_toList(Collection<T0> input, Predicate<T0> arg0) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_sortedComp_toList(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_limit_toList(Collection<T0> input, Predicate<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_skip_toList(Collection<T0> input, Predicate<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_distinct_toList(Collection<T0> input, Predicate<T0> arg0) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_dropWhile_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1) {
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_takeWhile_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1) {
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!arg1.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_takeWhile_flatMap_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1) {
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			for (T1 t1 : arg1.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_flatMap_map_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, T2> arg1) {
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				T2 t2 = arg1.apply(t1);
				result.add(t2);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_filter_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1) {
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				if (!arg1.test(t1)) {
					continue;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_sorted_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0) {
		List<T1> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				sorted0.add(t1);
			}
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_sortedComp_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Comparator<? super T1> arg1) {
		List<T1> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_limit_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				limit0++;
				if(limit0 > arg1) {
					break;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_skip_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				skip0++;
				if(skip0 <= arg1) {
					continue;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_distinct_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0) {
		Set<T1> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!distinct0.add(t1)) {
					continue;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_dropWhile_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1) {
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(dropWhile0 && arg1.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_takeWhile_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1) {
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!arg1.test(t1)) {
					break;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_flatMap_flatMap_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, Collection<T2>> arg1) {
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				for (T2 t2 : arg1.apply(t1)) {
					result.add(t2);
				}
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2, T3> List<T3> stream_map_map_map_toList(Collection<T0> input, Function<T0, T1> arg0, Function<T1, T2> arg1, Function<T2, T3> arg2) {
		List<T3> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			T2 t2 = arg1.apply(t1);
			T3 t3 = arg2.apply(t2);
			result.add(t3);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_map_map_filter_toList(Collection<T0> input, Function<T0, T1> arg0, Function<T1, T2> arg1, Predicate<T2> arg2) {
		List<T2> result = new ArrayList<>();
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			T2 t2 = arg1.apply(t1);
			if (!arg2.test(t2)) {
				continue;
			}
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_map_map_sorted_toList(Collection<T0> input, Function<T0, T1> arg0, Function<T1, T2> arg1) {
		List<T2> sorted0 = new ArrayList<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			T2 t2 = arg1.apply(t1);
			sorted0.add(t2);
		}
		Collections.sort((List) sorted0);
		for (T2 t2: sorted0) {
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_map_map_sortedComp_toList(Collection<T0> input, Function<T0, T1> arg0, Function<T1, T2> arg1, Comparator<? super T2> arg2) {
		List<T2> sortedComp0 = new ArrayList<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			T2 t2 = arg1.apply(t1);
			sortedComp0.add(t2);
		}
		sortedComp0.sort(arg2);
		for (T2 t2: sortedComp0) {
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_map_map_limit_toList(Collection<T0> input, Function<T0, T1> arg0, Function<T1, T2> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			T2 t2 = arg1.apply(t1);
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_map_map_skip_toList(Collection<T0> input, Function<T0, T1> arg0, Function<T1, T2> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			T2 t2 = arg1.apply(t1);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_map_map_distinct_toList(Collection<T0> input, Function<T0, T1> arg0, Function<T1, T2> arg1) {
		Set<T2> distinct0 = new HashSet<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			T2 t2 = arg1.apply(t1);
			if(!distinct0.add(t2)) {
				continue;
			}
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_map_map_dropWhile_toList(Collection<T0> input, Function<T0, T1> arg0, Function<T1, T2> arg1, Predicate<T2> arg2) {
		boolean dropWhile0 = true;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			T2 t2 = arg1.apply(t1);
			if(dropWhile0 && arg2.test(t2)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_map_map_takeWhile_toList(Collection<T0> input, Function<T0, T1> arg0, Function<T1, T2> arg1, Predicate<T2> arg2) {
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			T2 t2 = arg1.apply(t1);
			if(!arg2.test(t2)) {
				break;
			}
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2, T3> List<T3> stream_map_map_flatMap_toList(Collection<T0> input, Function<T0, T1> arg0, Function<T1, T2> arg1, Function<T2, Collection<T3>> arg2) {
		List<T3> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			T2 t2 = arg1.apply(t1);
			for (T3 t3 : arg2.apply(t2)) {
				result.add(t3);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_map_filter_map_toList(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Function<T1, T2> arg2) {
		List<T2> result = new ArrayList<>();
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_filter_filter_toList(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Predicate<T1> arg2) {
		List<T1> result = new ArrayList<>();
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
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_filter_sorted_toList(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1) {
		List<T1> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_filter_sortedComp_toList(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Comparator<? super T1> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg2);
		for (T1 t1: sortedComp0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_filter_limit_toList(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_filter_skip_toList(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_filter_distinct_toList(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1) {
		Set<T1> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			if(!distinct0.add(t1)) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_filter_dropWhile_toList(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Predicate<T1> arg2) {
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_filter_takeWhile_toList(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Predicate<T1> arg2) {
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			if(!arg2.test(t1)) {
				break;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_map_filter_flatMap_toList(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Function<T1, Collection<T2>> arg2) {
		List<T2> result = new ArrayList<>();
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			for (T2 t2 : arg2.apply(t1)) {
				result.add(t2);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T3> List<T3> stream_map_mapToInt_mapToObj_toList(Collection<T0> input, Function<T0, T1> arg0, ToIntFunction<T1> arg1, IntFunction<T3> arg2) {
		List<T3> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			int t2 = arg1.applyAsInt(t1);
			T3 t3 = arg2.apply(t2);
			result.add(t3);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<Integer> stream_map_mapToInt_boxed_toList(Collection<T0> input, Function<T0, T1> arg0, ToIntFunction<T1> arg1) {
		List<Integer> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			int t2 = arg1.applyAsInt(t1);
			Integer t3 = t2;
			result.add(t3);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T3> List<T3> stream_map_mapToLong_mapToObj_toList(Collection<T0> input, Function<T0, T1> arg0, ToLongFunction<T1> arg1, LongFunction<T3> arg2) {
		List<T3> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			long t2 = arg1.applyAsLong(t1);
			T3 t3 = arg2.apply(t2);
			result.add(t3);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<Long> stream_map_mapToLong_boxed_toList(Collection<T0> input, Function<T0, T1> arg0, ToLongFunction<T1> arg1) {
		List<Long> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			long t2 = arg1.applyAsLong(t1);
			Long t3 = t2;
			result.add(t3);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T3> List<T3> stream_map_mapToDouble_mapToObj_toList(Collection<T0> input, Function<T0, T1> arg0, ToDoubleFunction<T1> arg1, DoubleFunction<T3> arg2) {
		List<T3> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			double t2 = arg1.applyAsDouble(t1);
			T3 t3 = arg2.apply(t2);
			result.add(t3);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<Double> stream_map_mapToDouble_boxed_toList(Collection<T0> input, Function<T0, T1> arg0, ToDoubleFunction<T1> arg1) {
		List<Double> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			double t2 = arg1.applyAsDouble(t1);
			Double t3 = t2;
			result.add(t3);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_map_sorted_map_toList(Collection<T0> input, Function<T0, T1> arg0, Function<T1, T2> arg2) {
		List<T1> sorted0 = new ArrayList<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_sorted_filter_toList(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg2) {
		List<T1> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			if (!arg2.test(t1)) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_sorted_sorted_toList(Collection<T0> input, Function<T0, T1> arg0) {
		List<T1> sorted0 = new ArrayList<>();
		List<T1> sorted1 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			sorted1.add(t1);
		}
		Collections.sort((List) sorted1);
		for (T1 t1: sorted1) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_sorted_sortedComp_toList(Collection<T0> input, Function<T0, T1> arg0, Comparator<? super T1> arg2) {
		List<T1> sorted0 = new ArrayList<>();
		List<T1> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg2);
		for (T1 t1: sortedComp0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_sorted_limit_toList(Collection<T0> input, Function<T0, T1> arg0, long arg2) {
		List<T1> sorted0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_sorted_skip_toList(Collection<T0> input, Function<T0, T1> arg0, long arg2) {
		List<T1> sorted0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_sorted_distinct_toList(Collection<T0> input, Function<T0, T1> arg0) {
		List<T1> sorted0 = new ArrayList<>();
		Set<T1> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			if(!distinct0.add(t1)) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_sorted_dropWhile_toList(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg2) {
		List<T1> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_sorted_takeWhile_toList(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg2) {
		List<T1> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			if(!arg2.test(t1)) {
				break;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_map_sorted_flatMap_toList(Collection<T0> input, Function<T0, T1> arg0, Function<T1, Collection<T2>> arg2) {
		List<T1> sorted0 = new ArrayList<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			for (T2 t2 : arg2.apply(t1)) {
				result.add(t2);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_map_sortedComp_map_toList(Collection<T0> input, Function<T0, T1> arg0, Comparator<? super T1> arg1, Function<T1, T2> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_sortedComp_filter_toList(Collection<T0> input, Function<T0, T1> arg0, Comparator<? super T1> arg1, Predicate<T1> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			if (!arg2.test(t1)) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_sortedComp_sorted_toList(Collection<T0> input, Function<T0, T1> arg0, Comparator<? super T1> arg1) {
		List<T1> sortedComp0 = new ArrayList<>();
		List<T1> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_sortedComp_sortedComp_toList(Collection<T0> input, Function<T0, T1> arg0, Comparator<? super T1> arg1, Comparator<? super T1> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		List<T1> sortedComp1 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			sortedComp1.add(t1);
		}
		sortedComp1.sort(arg2);
		for (T1 t1: sortedComp1) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_sortedComp_limit_toList(Collection<T0> input, Function<T0, T1> arg0, Comparator<? super T1> arg1, long arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_sortedComp_skip_toList(Collection<T0> input, Function<T0, T1> arg0, Comparator<? super T1> arg1, long arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_sortedComp_distinct_toList(Collection<T0> input, Function<T0, T1> arg0, Comparator<? super T1> arg1) {
		List<T1> sortedComp0 = new ArrayList<>();
		Set<T1> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			if(!distinct0.add(t1)) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_sortedComp_dropWhile_toList(Collection<T0> input, Function<T0, T1> arg0, Comparator<? super T1> arg1, Predicate<T1> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_sortedComp_takeWhile_toList(Collection<T0> input, Function<T0, T1> arg0, Comparator<? super T1> arg1, Predicate<T1> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			if(!arg2.test(t1)) {
				break;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_map_sortedComp_flatMap_toList(Collection<T0> input, Function<T0, T1> arg0, Comparator<? super T1> arg1, Function<T1, Collection<T2>> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			for (T2 t2 : arg2.apply(t1)) {
				result.add(t2);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_map_limit_map_toList(Collection<T0> input, Function<T0, T1> arg0, long arg1, Function<T1, T2> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_limit_filter_toList(Collection<T0> input, Function<T0, T1> arg0, long arg1, Predicate<T1> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			if (!arg2.test(t1)) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_limit_sorted_toList(Collection<T0> input, Function<T0, T1> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_limit_sortedComp_toList(Collection<T0> input, Function<T0, T1> arg0, long arg1, Comparator<? super T1> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg2);
		for (T1 t1: sortedComp0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_limit_limit_toList(Collection<T0> input, Function<T0, T1> arg0, long arg1, long arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			limit1++;
			if(limit1 > arg2) {
				break;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_limit_skip_toList(Collection<T0> input, Function<T0, T1> arg0, long arg1, long arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_limit_distinct_toList(Collection<T0> input, Function<T0, T1> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T1> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			if(!distinct0.add(t1)) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_limit_dropWhile_toList(Collection<T0> input, Function<T0, T1> arg0, long arg1, Predicate<T1> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_limit_takeWhile_toList(Collection<T0> input, Function<T0, T1> arg0, long arg1, Predicate<T1> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			if(!arg2.test(t1)) {
				break;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_map_limit_flatMap_toList(Collection<T0> input, Function<T0, T1> arg0, long arg1, Function<T1, Collection<T2>> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			for (T2 t2 : arg2.apply(t1)) {
				result.add(t2);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_map_skip_map_toList(Collection<T0> input, Function<T0, T1> arg0, long arg1, Function<T1, T2> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_skip_filter_toList(Collection<T0> input, Function<T0, T1> arg0, long arg1, Predicate<T1> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if (!arg2.test(t1)) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_skip_sorted_toList(Collection<T0> input, Function<T0, T1> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_skip_sortedComp_toList(Collection<T0> input, Function<T0, T1> arg0, long arg1, Comparator<? super T1> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg2);
		for (T1 t1: sortedComp0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_skip_limit_toList(Collection<T0> input, Function<T0, T1> arg0, long arg1, long arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_skip_skip_toList(Collection<T0> input, Function<T0, T1> arg0, long arg1, long arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			skip1++;
			if(skip1 <= arg2) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_skip_distinct_toList(Collection<T0> input, Function<T0, T1> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T1> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if(!distinct0.add(t1)) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_skip_dropWhile_toList(Collection<T0> input, Function<T0, T1> arg0, long arg1, Predicate<T1> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_skip_takeWhile_toList(Collection<T0> input, Function<T0, T1> arg0, long arg1, Predicate<T1> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if(!arg2.test(t1)) {
				break;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_map_skip_flatMap_toList(Collection<T0> input, Function<T0, T1> arg0, long arg1, Function<T1, Collection<T2>> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			for (T2 t2 : arg2.apply(t1)) {
				result.add(t2);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_map_distinct_map_toList(Collection<T0> input, Function<T0, T1> arg0, Function<T1, T2> arg2) {
		Set<T1> distinct0 = new HashSet<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_distinct_filter_toList(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg2) {
		Set<T1> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			if (!arg2.test(t1)) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_distinct_sorted_toList(Collection<T0> input, Function<T0, T1> arg0) {
		Set<T1> distinct0 = new HashSet<>();
		List<T1> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_distinct_sortedComp_toList(Collection<T0> input, Function<T0, T1> arg0, Comparator<? super T1> arg2) {
		Set<T1> distinct0 = new HashSet<>();
		List<T1> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg2);
		for (T1 t1: sortedComp0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_distinct_limit_toList(Collection<T0> input, Function<T0, T1> arg0, long arg2) {
		Set<T1> distinct0 = new HashSet<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_distinct_skip_toList(Collection<T0> input, Function<T0, T1> arg0, long arg2) {
		Set<T1> distinct0 = new HashSet<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_distinct_distinct_toList(Collection<T0> input, Function<T0, T1> arg0) {
		Set<T1> distinct0 = new HashSet<>();
		Set<T1> distinct1 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			if(!distinct1.add(t1)) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_distinct_dropWhile_toList(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg2) {
		Set<T1> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_distinct_takeWhile_toList(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg2) {
		Set<T1> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			if(!arg2.test(t1)) {
				break;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_map_distinct_flatMap_toList(Collection<T0> input, Function<T0, T1> arg0, Function<T1, Collection<T2>> arg2) {
		Set<T1> distinct0 = new HashSet<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			for (T2 t2 : arg2.apply(t1)) {
				result.add(t2);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_map_dropWhile_map_toList(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Function<T1, T2> arg2) {
		boolean dropWhile0 = true;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_dropWhile_filter_toList(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Predicate<T1> arg2) {
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if (!arg2.test(t1)) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_dropWhile_sorted_toList(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1) {
		boolean dropWhile0 = true;
		List<T1> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_dropWhile_sortedComp_toList(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Comparator<? super T1> arg2) {
		boolean dropWhile0 = true;
		List<T1> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_dropWhile_limit_toList(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, long arg2) {
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_dropWhile_skip_toList(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, long arg2) {
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_dropWhile_distinct_toList(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1) {
		boolean dropWhile0 = true;
		Set<T1> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!distinct0.add(t1)) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_dropWhile_dropWhile_toList(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Predicate<T1> arg2) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_dropWhile_takeWhile_toList(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Predicate<T1> arg2) {
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!arg2.test(t1)) {
				break;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_map_dropWhile_flatMap_toList(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Function<T1, Collection<T2>> arg2) {
		boolean dropWhile0 = true;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T2 t2 : arg2.apply(t1)) {
				result.add(t2);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_map_takeWhile_map_toList(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Function<T1, T2> arg2) {
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if(!arg1.test(t1)) {
				break;
			}
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_takeWhile_filter_toList(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Predicate<T1> arg2) {
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if(!arg1.test(t1)) {
				break;
			}
			if (!arg2.test(t1)) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_takeWhile_sorted_toList(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1) {
		List<T1> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if(!arg1.test(t1)) {
				break;
			}
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_takeWhile_sortedComp_toList(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Comparator<? super T1> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if(!arg1.test(t1)) {
				break;
			}
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg2);
		for (T1 t1: sortedComp0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_takeWhile_limit_toList(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if(!arg1.test(t1)) {
				break;
			}
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_takeWhile_skip_toList(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if(!arg1.test(t1)) {
				break;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_takeWhile_distinct_toList(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1) {
		Set<T1> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if(!arg1.test(t1)) {
				break;
			}
			if(!distinct0.add(t1)) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_takeWhile_dropWhile_toList(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Predicate<T1> arg2) {
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if(!arg1.test(t1)) {
				break;
			}
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_map_takeWhile_takeWhile_toList(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Predicate<T1> arg2) {
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if(!arg1.test(t1)) {
				break;
			}
			if(!arg2.test(t1)) {
				break;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_map_takeWhile_flatMap_toList(Collection<T0> input, Function<T0, T1> arg0, Predicate<T1> arg1, Function<T1, Collection<T2>> arg2) {
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			if(!arg1.test(t1)) {
				break;
			}
			for (T2 t2 : arg2.apply(t1)) {
				result.add(t2);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2, T3> List<T3> stream_map_flatMap_map_toList(Collection<T0> input, Function<T0, T1> arg0, Function<T1, Collection<T2>> arg1, Function<T2, T3> arg2) {
		List<T3> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			for (T2 t2 : arg1.apply(t1)) {
				T3 t3 = arg2.apply(t2);
				result.add(t3);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_map_flatMap_filter_toList(Collection<T0> input, Function<T0, T1> arg0, Function<T1, Collection<T2>> arg1, Predicate<T2> arg2) {
		List<T2> result = new ArrayList<>();
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			for (T2 t2 : arg1.apply(t1)) {
				if (!arg2.test(t2)) {
					continue;
				}
				result.add(t2);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_map_flatMap_sorted_toList(Collection<T0> input, Function<T0, T1> arg0, Function<T1, Collection<T2>> arg1) {
		List<T2> sorted0 = new ArrayList<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			for (T2 t2 : arg1.apply(t1)) {
				sorted0.add(t2);
			}
		}
		Collections.sort((List) sorted0);
		for (T2 t2: sorted0) {
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_map_flatMap_sortedComp_toList(Collection<T0> input, Function<T0, T1> arg0, Function<T1, Collection<T2>> arg1, Comparator<? super T2> arg2) {
		List<T2> sortedComp0 = new ArrayList<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			for (T2 t2 : arg1.apply(t1)) {
				sortedComp0.add(t2);
			}
		}
		sortedComp0.sort(arg2);
		for (T2 t2: sortedComp0) {
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_map_flatMap_limit_toList(Collection<T0> input, Function<T0, T1> arg0, Function<T1, Collection<T2>> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			for (T2 t2 : arg1.apply(t1)) {
				limit0++;
				if(limit0 > arg2) {
					break;
				}
				result.add(t2);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_map_flatMap_skip_toList(Collection<T0> input, Function<T0, T1> arg0, Function<T1, Collection<T2>> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			for (T2 t2 : arg1.apply(t1)) {
				skip0++;
				if(skip0 <= arg2) {
					continue;
				}
				result.add(t2);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_map_flatMap_distinct_toList(Collection<T0> input, Function<T0, T1> arg0, Function<T1, Collection<T2>> arg1) {
		Set<T2> distinct0 = new HashSet<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			for (T2 t2 : arg1.apply(t1)) {
				if(!distinct0.add(t2)) {
					continue;
				}
				result.add(t2);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_map_flatMap_dropWhile_toList(Collection<T0> input, Function<T0, T1> arg0, Function<T1, Collection<T2>> arg1, Predicate<T2> arg2) {
		boolean dropWhile0 = true;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			for (T2 t2 : arg1.apply(t1)) {
				if(dropWhile0 && arg2.test(t2)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				result.add(t2);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_map_flatMap_takeWhile_toList(Collection<T0> input, Function<T0, T1> arg0, Function<T1, Collection<T2>> arg1, Predicate<T2> arg2) {
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			for (T2 t2 : arg1.apply(t1)) {
				if(!arg2.test(t2)) {
					break;
				}
				result.add(t2);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2, T3> List<T3> stream_map_flatMap_flatMap_toList(Collection<T0> input, Function<T0, T1> arg0, Function<T1, Collection<T2>> arg1, Function<T2, Collection<T3>> arg2) {
		List<T3> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			T1 t1 = arg0.apply(t0);
			for (T2 t2 : arg1.apply(t1)) {
				for (T3 t3 : arg2.apply(t2)) {
					result.add(t3);
				}
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_filter_map_map_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Function<T1, T2> arg2) {
		List<T2> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_filter_map_filter_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Predicate<T1> arg2) {
		List<T1> result = new ArrayList<>();
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
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_filter_map_sorted_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1) {
		List<T1> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_filter_map_sortedComp_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Comparator<? super T1> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg2);
		for (T1 t1: sortedComp0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_filter_map_limit_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_filter_map_skip_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_filter_map_distinct_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1) {
		Set<T1> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_filter_map_dropWhile_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Predicate<T1> arg2) {
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_filter_map_takeWhile_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Predicate<T1> arg2) {
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			if(!arg2.test(t1)) {
				break;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_filter_map_flatMap_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Function<T1, Collection<T2>> arg2) {
		List<T2> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			for (T2 t2 : arg2.apply(t1)) {
				result.add(t2);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_filter_filter_map_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Function<T0, T1> arg2) {
		List<T1> result = new ArrayList<>();
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
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_filter_filter_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		List<T0> result = new ArrayList<>();
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
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_filter_sorted_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_filter_sortedComp_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Comparator<? super T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_filter_limit_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_filter_skip_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_filter_distinct_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_filter_dropWhile_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_filter_takeWhile_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			if(!arg2.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_filter_filter_flatMap_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Function<T0, Collection<T1>> arg2) {
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_filter_mapToInt_mapToObj_toList(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1, IntFunction<T2> arg2) {
		List<T2> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Integer> stream_filter_mapToInt_boxed_toList(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1) {
		List<Integer> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			Integer t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_filter_mapToLong_mapToObj_toList(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1, LongFunction<T2> arg2) {
		List<T2> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Long> stream_filter_mapToLong_boxed_toList(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1) {
		List<Long> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			Long t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_filter_mapToDouble_mapToObj_toList(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1, DoubleFunction<T2> arg2) {
		List<T2> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Double> stream_filter_mapToDouble_boxed_toList(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1) {
		List<Double> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			Double t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_filter_sorted_map_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_sorted_filter_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if (!arg2.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_sorted_sorted_toList(Collection<T0> input, Predicate<T0> arg0) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			sorted1.add(t0);
		}
		Collections.sort((List) sorted1);
		for (T0 t0: sorted1) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_sorted_sortedComp_toList(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_sorted_limit_toList(Collection<T0> input, Predicate<T0> arg0, long arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_sorted_skip_toList(Collection<T0> input, Predicate<T0> arg0, long arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_sorted_distinct_toList(Collection<T0> input, Predicate<T0> arg0) {
		List<T0> sorted0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_sorted_dropWhile_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_sorted_takeWhile_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(!arg2.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_filter_sorted_flatMap_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_filter_sortedComp_map_toList(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Function<T0, T1> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_sortedComp_filter_toList(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Predicate<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_sortedComp_sorted_toList(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_sortedComp_sortedComp_toList(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Comparator<? super T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_sortedComp_limit_toList(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, long arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_sortedComp_skip_toList(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, long arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_sortedComp_distinct_toList(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_sortedComp_dropWhile_toList(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Predicate<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_sortedComp_takeWhile_toList(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Predicate<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_filter_sortedComp_flatMap_toList(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Function<T0, Collection<T1>> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_filter_limit_map_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, Function<T0, T1> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_limit_filter_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, Predicate<T0> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_limit_sorted_toList(Collection<T0> input, Predicate<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_limit_sortedComp_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, Comparator<? super T0> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_limit_limit_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, long arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			limit1++;
			if(limit1 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_limit_skip_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, long arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_limit_distinct_toList(Collection<T0> input, Predicate<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_limit_dropWhile_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, Predicate<T0> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_limit_takeWhile_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, Predicate<T0> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			if(!arg2.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_filter_limit_flatMap_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, Function<T0, Collection<T1>> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_filter_skip_map_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, Function<T0, T1> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_skip_filter_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, Predicate<T0> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_skip_sorted_toList(Collection<T0> input, Predicate<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_skip_sortedComp_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, Comparator<? super T0> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_skip_limit_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, long arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_skip_skip_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, long arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_skip_distinct_toList(Collection<T0> input, Predicate<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_skip_dropWhile_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, Predicate<T0> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_skip_takeWhile_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, Predicate<T0> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_filter_skip_flatMap_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, Function<T0, Collection<T1>> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_filter_distinct_map_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_distinct_filter_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_distinct_sorted_toList(Collection<T0> input, Predicate<T0> arg0) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_distinct_sortedComp_toList(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_distinct_limit_toList(Collection<T0> input, Predicate<T0> arg0, long arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_distinct_skip_toList(Collection<T0> input, Predicate<T0> arg0, long arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_distinct_distinct_toList(Collection<T0> input, Predicate<T0> arg0) {
		Set<T0> distinct0 = new HashSet<>();
		Set<T0> distinct1 = new HashSet<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!distinct1.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_distinct_dropWhile_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_distinct_takeWhile_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!arg2.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_filter_distinct_flatMap_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_filter_dropWhile_map_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Function<T0, T1> arg2) {
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_dropWhile_filter_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_dropWhile_sorted_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1) {
		boolean dropWhile0 = true;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_dropWhile_sortedComp_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Comparator<? super T0> arg2) {
		boolean dropWhile0 = true;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_dropWhile_limit_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, long arg2) {
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_dropWhile_skip_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, long arg2) {
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_dropWhile_distinct_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1) {
		boolean dropWhile0 = true;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_dropWhile_dropWhile_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_dropWhile_takeWhile_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_filter_dropWhile_flatMap_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Function<T0, Collection<T1>> arg2) {
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_filter_takeWhile_map_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Function<T0, T1> arg2) {
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_takeWhile_filter_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_takeWhile_sorted_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_takeWhile_sortedComp_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Comparator<? super T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_takeWhile_limit_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_takeWhile_skip_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_takeWhile_distinct_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_takeWhile_dropWhile_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_filter_takeWhile_takeWhile_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			if(!arg2.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_filter_takeWhile_flatMap_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Function<T0, Collection<T1>> arg2) {
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_filter_flatMap_map_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Function<T1, T2> arg2) {
		List<T2> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				T2 t2 = arg2.apply(t1);
				result.add(t2);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_filter_flatMap_filter_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Predicate<T1> arg2) {
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				if (!arg2.test(t1)) {
					continue;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_filter_flatMap_sorted_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1) {
		List<T1> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				sorted0.add(t1);
			}
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_filter_flatMap_sortedComp_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Comparator<? super T1> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg2);
		for (T1 t1: sortedComp0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_filter_flatMap_limit_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				limit0++;
				if(limit0 > arg2) {
					break;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_filter_flatMap_skip_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				skip0++;
				if(skip0 <= arg2) {
					continue;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_filter_flatMap_distinct_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1) {
		Set<T1> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				if(!distinct0.add(t1)) {
					continue;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_filter_flatMap_dropWhile_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Predicate<T1> arg2) {
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				if(dropWhile0 && arg2.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_filter_flatMap_takeWhile_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Predicate<T1> arg2) {
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				if(!arg2.test(t1)) {
					break;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_filter_flatMap_flatMap_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Function<T1, Collection<T2>> arg2) {
		List<T2> result = new ArrayList<>();
		for (T0 t0 : input) {
			if (!arg0.test(t0)) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				for (T2 t2 : arg2.apply(t1)) {
					result.add(t2);
				}
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToInt_map_mapToObj_toList(Collection<T0> input, ToIntFunction<T0> arg0, IntUnaryOperator arg1, IntFunction<T2> arg2) {
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			t1 = arg1.applyAsInt(t1);
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Integer> stream_mapToInt_map_boxed_toList(Collection<T0> input, ToIntFunction<T0> arg0, IntUnaryOperator arg1) {
		List<Integer> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			t1 = arg1.applyAsInt(t1);
			Integer t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToInt_filter_mapToObj_toList(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1, IntFunction<T2> arg2) {
		List<T2> result = new ArrayList<>();
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Integer> stream_mapToInt_filter_boxed_toList(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1) {
		List<Integer> result = new ArrayList<>();
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			Integer t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T3> List<T3> stream_mapToInt_mapToLong_mapToObj_toList(Collection<T0> input, ToIntFunction<T0> arg0, IntToLongFunction arg1, LongFunction<T3> arg2) {
		List<T3> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			long t2 = arg1.applyAsLong(t1);
			T3 t3 = arg2.apply(t2);
			result.add(t3);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Long> stream_mapToInt_mapToLong_boxed_toList(Collection<T0> input, ToIntFunction<T0> arg0, IntToLongFunction arg1) {
		List<Long> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			long t2 = arg1.applyAsLong(t1);
			Long t3 = t2;
			result.add(t3);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T3> List<T3> stream_mapToInt_mapToDouble_mapToObj_toList(Collection<T0> input, ToIntFunction<T0> arg0, IntToDoubleFunction arg1, DoubleFunction<T3> arg2) {
		List<T3> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			double t2 = arg1.applyAsDouble(t1);
			T3 t3 = arg2.apply(t2);
			result.add(t3);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Double> stream_mapToInt_mapToDouble_boxed_toList(Collection<T0> input, ToIntFunction<T0> arg0, IntToDoubleFunction arg1) {
		List<Double> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			double t2 = arg1.applyAsDouble(t1);
			Double t3 = t2;
			result.add(t3);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2, T3> List<T3> stream_mapToInt_mapToObj_map_toList(Collection<T0> input, ToIntFunction<T0> arg0, IntFunction<T2> arg1, Function<T2, T3> arg2) {
		List<T3> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			T2 t2 = arg1.apply(t1);
			T3 t3 = arg2.apply(t2);
			result.add(t3);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToInt_mapToObj_filter_toList(Collection<T0> input, ToIntFunction<T0> arg0, IntFunction<T2> arg1, Predicate<T2> arg2) {
		List<T2> result = new ArrayList<>();
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			T2 t2 = arg1.apply(t1);
			if (!arg2.test(t2)) {
				continue;
			}
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToInt_mapToObj_sorted_toList(Collection<T0> input, ToIntFunction<T0> arg0, IntFunction<T2> arg1) {
		List<T2> sorted0 = new ArrayList<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			T2 t2 = arg1.apply(t1);
			sorted0.add(t2);
		}
		Collections.sort((List) sorted0);
		for (T2 t2: sorted0) {
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToInt_mapToObj_sortedComp_toList(Collection<T0> input, ToIntFunction<T0> arg0, IntFunction<T2> arg1, Comparator<? super T2> arg2) {
		List<T2> sortedComp0 = new ArrayList<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			T2 t2 = arg1.apply(t1);
			sortedComp0.add(t2);
		}
		sortedComp0.sort(arg2);
		for (T2 t2: sortedComp0) {
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToInt_mapToObj_limit_toList(Collection<T0> input, ToIntFunction<T0> arg0, IntFunction<T2> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			T2 t2 = arg1.apply(t1);
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToInt_mapToObj_skip_toList(Collection<T0> input, ToIntFunction<T0> arg0, IntFunction<T2> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			T2 t2 = arg1.apply(t1);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToInt_mapToObj_distinct_toList(Collection<T0> input, ToIntFunction<T0> arg0, IntFunction<T2> arg1) {
		Set<T2> distinct0 = new HashSet<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			T2 t2 = arg1.apply(t1);
			if(!distinct0.add(t2)) {
				continue;
			}
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToInt_mapToObj_dropWhile_toList(Collection<T0> input, ToIntFunction<T0> arg0, IntFunction<T2> arg1, Predicate<T2> arg2) {
		boolean dropWhile0 = true;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			T2 t2 = arg1.apply(t1);
			if(dropWhile0 && arg2.test(t2)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToInt_mapToObj_takeWhile_toList(Collection<T0> input, ToIntFunction<T0> arg0, IntFunction<T2> arg1, Predicate<T2> arg2) {
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			T2 t2 = arg1.apply(t1);
			if(!arg2.test(t2)) {
				break;
			}
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2, T3> List<T3> stream_mapToInt_mapToObj_flatMap_toList(Collection<T0> input, ToIntFunction<T0> arg0, IntFunction<T2> arg1, Function<T2, Collection<T3>> arg2) {
		List<T3> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			T2 t2 = arg1.apply(t1);
			for (T3 t3 : arg2.apply(t2)) {
				result.add(t3);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T3> List<T3> stream_mapToInt_boxed_map_toList(Collection<T0> input, ToIntFunction<T0> arg0, Function<Integer, T3> arg2) {
		List<T3> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			Integer t2 = t1;
			T3 t3 = arg2.apply(t2);
			result.add(t3);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Integer> stream_mapToInt_boxed_filter_toList(Collection<T0> input, ToIntFunction<T0> arg0, Predicate<Integer> arg2) {
		List<Integer> result = new ArrayList<>();
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			Integer t2 = t1;
			if (!arg2.test(t2)) {
				continue;
			}
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Integer> stream_mapToInt_boxed_sorted_toList(Collection<T0> input, ToIntFunction<T0> arg0) {
		List<Integer> sorted0 = new ArrayList<>();
		List<Integer> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			Integer t2 = t1;
			sorted0.add(t2);
		}
		Collections.sort((List) sorted0);
		for (Integer t2: sorted0) {
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Integer> stream_mapToInt_boxed_sortedComp_toList(Collection<T0> input, ToIntFunction<T0> arg0, Comparator<? super Integer> arg2) {
		List<Integer> sortedComp0 = new ArrayList<>();
		List<Integer> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			Integer t2 = t1;
			sortedComp0.add(t2);
		}
		sortedComp0.sort(arg2);
		for (Integer t2: sortedComp0) {
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Integer> stream_mapToInt_boxed_limit_toList(Collection<T0> input, ToIntFunction<T0> arg0, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<Integer> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			Integer t2 = t1;
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Integer> stream_mapToInt_boxed_skip_toList(Collection<T0> input, ToIntFunction<T0> arg0, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<Integer> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			Integer t2 = t1;
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Integer> stream_mapToInt_boxed_distinct_toList(Collection<T0> input, ToIntFunction<T0> arg0) {
		Set<Integer> distinct0 = new HashSet<>();
		List<Integer> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			Integer t2 = t1;
			if(!distinct0.add(t2)) {
				continue;
			}
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Integer> stream_mapToInt_boxed_dropWhile_toList(Collection<T0> input, ToIntFunction<T0> arg0, Predicate<Integer> arg2) {
		boolean dropWhile0 = true;
		List<Integer> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			Integer t2 = t1;
			if(dropWhile0 && arg2.test(t2)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Integer> stream_mapToInt_boxed_takeWhile_toList(Collection<T0> input, ToIntFunction<T0> arg0, Predicate<Integer> arg2) {
		List<Integer> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			Integer t2 = t1;
			if(!arg2.test(t2)) {
				break;
			}
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T3> List<T3> stream_mapToInt_boxed_flatMap_toList(Collection<T0> input, ToIntFunction<T0> arg0, Function<Integer, Collection<T3>> arg2) {
		List<T3> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			Integer t2 = t1;
			for (T3 t3 : arg2.apply(t2)) {
				result.add(t3);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToInt_sorted_mapToObj_toList(Collection<T0> input, ToIntFunction<T0> arg0, IntFunction<T2> arg2) {
		List<Integer> sorted0 = new ArrayList<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (int t1: sorted0) {
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Integer> stream_mapToInt_sorted_boxed_toList(Collection<T0> input, ToIntFunction<T0> arg0) {
		List<Integer> sorted0 = new ArrayList<>();
		List<Integer> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (int t1: sorted0) {
			Integer t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToInt_limit_mapToObj_toList(Collection<T0> input, ToIntFunction<T0> arg0, long arg1, IntFunction<T2> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Integer> stream_mapToInt_limit_boxed_toList(Collection<T0> input, ToIntFunction<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<Integer> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			Integer t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToInt_skip_mapToObj_toList(Collection<T0> input, ToIntFunction<T0> arg0, long arg1, IntFunction<T2> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Integer> stream_mapToInt_skip_boxed_toList(Collection<T0> input, ToIntFunction<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<Integer> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			Integer t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToInt_distinct_mapToObj_toList(Collection<T0> input, ToIntFunction<T0> arg0, IntFunction<T2> arg2) {
		Set<Integer> distinct0 = new HashSet<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Integer> stream_mapToInt_distinct_boxed_toList(Collection<T0> input, ToIntFunction<T0> arg0) {
		Set<Integer> distinct0 = new HashSet<>();
		List<Integer> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			Integer t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToInt_dropWhile_mapToObj_toList(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1, IntFunction<T2> arg2) {
		boolean dropWhile0 = true;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Integer> stream_mapToInt_dropWhile_boxed_toList(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1) {
		boolean dropWhile0 = true;
		List<Integer> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			Integer t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToInt_takeWhile_mapToObj_toList(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1, IntFunction<T2> arg2) {
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			if(!arg1.test(t1)) {
				break;
			}
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Integer> stream_mapToInt_takeWhile_boxed_toList(Collection<T0> input, ToIntFunction<T0> arg0, IntPredicate arg1) {
		List<Integer> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			int t1 = arg0.applyAsInt(t0);
			if(!arg1.test(t1)) {
				break;
			}
			Integer t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToLong_map_mapToObj_toList(Collection<T0> input, ToLongFunction<T0> arg0, LongUnaryOperator arg1, LongFunction<T2> arg2) {
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			t1 = arg1.applyAsLong(t1);
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Long> stream_mapToLong_map_boxed_toList(Collection<T0> input, ToLongFunction<T0> arg0, LongUnaryOperator arg1) {
		List<Long> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			t1 = arg1.applyAsLong(t1);
			Long t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToLong_filter_mapToObj_toList(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1, LongFunction<T2> arg2) {
		List<T2> result = new ArrayList<>();
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Long> stream_mapToLong_filter_boxed_toList(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1) {
		List<Long> result = new ArrayList<>();
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			Long t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T3> List<T3> stream_mapToLong_mapToInt_mapToObj_toList(Collection<T0> input, ToLongFunction<T0> arg0, LongToIntFunction arg1, IntFunction<T3> arg2) {
		List<T3> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			int t2 = arg1.applyAsInt(t1);
			T3 t3 = arg2.apply(t2);
			result.add(t3);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Integer> stream_mapToLong_mapToInt_boxed_toList(Collection<T0> input, ToLongFunction<T0> arg0, LongToIntFunction arg1) {
		List<Integer> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			int t2 = arg1.applyAsInt(t1);
			Integer t3 = t2;
			result.add(t3);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T3> List<T3> stream_mapToLong_mapToDouble_mapToObj_toList(Collection<T0> input, ToLongFunction<T0> arg0, LongToDoubleFunction arg1, DoubleFunction<T3> arg2) {
		List<T3> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			double t2 = arg1.applyAsDouble(t1);
			T3 t3 = arg2.apply(t2);
			result.add(t3);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Double> stream_mapToLong_mapToDouble_boxed_toList(Collection<T0> input, ToLongFunction<T0> arg0, LongToDoubleFunction arg1) {
		List<Double> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			double t2 = arg1.applyAsDouble(t1);
			Double t3 = t2;
			result.add(t3);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2, T3> List<T3> stream_mapToLong_mapToObj_map_toList(Collection<T0> input, ToLongFunction<T0> arg0, LongFunction<T2> arg1, Function<T2, T3> arg2) {
		List<T3> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			T2 t2 = arg1.apply(t1);
			T3 t3 = arg2.apply(t2);
			result.add(t3);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToLong_mapToObj_filter_toList(Collection<T0> input, ToLongFunction<T0> arg0, LongFunction<T2> arg1, Predicate<T2> arg2) {
		List<T2> result = new ArrayList<>();
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			T2 t2 = arg1.apply(t1);
			if (!arg2.test(t2)) {
				continue;
			}
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToLong_mapToObj_sorted_toList(Collection<T0> input, ToLongFunction<T0> arg0, LongFunction<T2> arg1) {
		List<T2> sorted0 = new ArrayList<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			T2 t2 = arg1.apply(t1);
			sorted0.add(t2);
		}
		Collections.sort((List) sorted0);
		for (T2 t2: sorted0) {
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToLong_mapToObj_sortedComp_toList(Collection<T0> input, ToLongFunction<T0> arg0, LongFunction<T2> arg1, Comparator<? super T2> arg2) {
		List<T2> sortedComp0 = new ArrayList<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			T2 t2 = arg1.apply(t1);
			sortedComp0.add(t2);
		}
		sortedComp0.sort(arg2);
		for (T2 t2: sortedComp0) {
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToLong_mapToObj_limit_toList(Collection<T0> input, ToLongFunction<T0> arg0, LongFunction<T2> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			T2 t2 = arg1.apply(t1);
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToLong_mapToObj_skip_toList(Collection<T0> input, ToLongFunction<T0> arg0, LongFunction<T2> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			T2 t2 = arg1.apply(t1);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToLong_mapToObj_distinct_toList(Collection<T0> input, ToLongFunction<T0> arg0, LongFunction<T2> arg1) {
		Set<T2> distinct0 = new HashSet<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			T2 t2 = arg1.apply(t1);
			if(!distinct0.add(t2)) {
				continue;
			}
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToLong_mapToObj_dropWhile_toList(Collection<T0> input, ToLongFunction<T0> arg0, LongFunction<T2> arg1, Predicate<T2> arg2) {
		boolean dropWhile0 = true;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			T2 t2 = arg1.apply(t1);
			if(dropWhile0 && arg2.test(t2)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToLong_mapToObj_takeWhile_toList(Collection<T0> input, ToLongFunction<T0> arg0, LongFunction<T2> arg1, Predicate<T2> arg2) {
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			T2 t2 = arg1.apply(t1);
			if(!arg2.test(t2)) {
				break;
			}
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2, T3> List<T3> stream_mapToLong_mapToObj_flatMap_toList(Collection<T0> input, ToLongFunction<T0> arg0, LongFunction<T2> arg1, Function<T2, Collection<T3>> arg2) {
		List<T3> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			T2 t2 = arg1.apply(t1);
			for (T3 t3 : arg2.apply(t2)) {
				result.add(t3);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T3> List<T3> stream_mapToLong_boxed_map_toList(Collection<T0> input, ToLongFunction<T0> arg0, Function<Long, T3> arg2) {
		List<T3> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			Long t2 = t1;
			T3 t3 = arg2.apply(t2);
			result.add(t3);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Long> stream_mapToLong_boxed_filter_toList(Collection<T0> input, ToLongFunction<T0> arg0, Predicate<Long> arg2) {
		List<Long> result = new ArrayList<>();
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			Long t2 = t1;
			if (!arg2.test(t2)) {
				continue;
			}
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Long> stream_mapToLong_boxed_sorted_toList(Collection<T0> input, ToLongFunction<T0> arg0) {
		List<Long> sorted0 = new ArrayList<>();
		List<Long> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			Long t2 = t1;
			sorted0.add(t2);
		}
		Collections.sort((List) sorted0);
		for (Long t2: sorted0) {
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Long> stream_mapToLong_boxed_sortedComp_toList(Collection<T0> input, ToLongFunction<T0> arg0, Comparator<? super Long> arg2) {
		List<Long> sortedComp0 = new ArrayList<>();
		List<Long> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			Long t2 = t1;
			sortedComp0.add(t2);
		}
		sortedComp0.sort(arg2);
		for (Long t2: sortedComp0) {
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Long> stream_mapToLong_boxed_limit_toList(Collection<T0> input, ToLongFunction<T0> arg0, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<Long> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			Long t2 = t1;
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Long> stream_mapToLong_boxed_skip_toList(Collection<T0> input, ToLongFunction<T0> arg0, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<Long> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			Long t2 = t1;
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Long> stream_mapToLong_boxed_distinct_toList(Collection<T0> input, ToLongFunction<T0> arg0) {
		Set<Long> distinct0 = new HashSet<>();
		List<Long> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			Long t2 = t1;
			if(!distinct0.add(t2)) {
				continue;
			}
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Long> stream_mapToLong_boxed_dropWhile_toList(Collection<T0> input, ToLongFunction<T0> arg0, Predicate<Long> arg2) {
		boolean dropWhile0 = true;
		List<Long> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			Long t2 = t1;
			if(dropWhile0 && arg2.test(t2)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Long> stream_mapToLong_boxed_takeWhile_toList(Collection<T0> input, ToLongFunction<T0> arg0, Predicate<Long> arg2) {
		List<Long> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			Long t2 = t1;
			if(!arg2.test(t2)) {
				break;
			}
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T3> List<T3> stream_mapToLong_boxed_flatMap_toList(Collection<T0> input, ToLongFunction<T0> arg0, Function<Long, Collection<T3>> arg2) {
		List<T3> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			Long t2 = t1;
			for (T3 t3 : arg2.apply(t2)) {
				result.add(t3);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToLong_sorted_mapToObj_toList(Collection<T0> input, ToLongFunction<T0> arg0, LongFunction<T2> arg2) {
		List<Long> sorted0 = new ArrayList<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (long t1: sorted0) {
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Long> stream_mapToLong_sorted_boxed_toList(Collection<T0> input, ToLongFunction<T0> arg0) {
		List<Long> sorted0 = new ArrayList<>();
		List<Long> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (long t1: sorted0) {
			Long t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToLong_limit_mapToObj_toList(Collection<T0> input, ToLongFunction<T0> arg0, long arg1, LongFunction<T2> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Long> stream_mapToLong_limit_boxed_toList(Collection<T0> input, ToLongFunction<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<Long> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			Long t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToLong_skip_mapToObj_toList(Collection<T0> input, ToLongFunction<T0> arg0, long arg1, LongFunction<T2> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Long> stream_mapToLong_skip_boxed_toList(Collection<T0> input, ToLongFunction<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<Long> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			Long t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToLong_distinct_mapToObj_toList(Collection<T0> input, ToLongFunction<T0> arg0, LongFunction<T2> arg2) {
		Set<Long> distinct0 = new HashSet<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Long> stream_mapToLong_distinct_boxed_toList(Collection<T0> input, ToLongFunction<T0> arg0) {
		Set<Long> distinct0 = new HashSet<>();
		List<Long> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			Long t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToLong_dropWhile_mapToObj_toList(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1, LongFunction<T2> arg2) {
		boolean dropWhile0 = true;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Long> stream_mapToLong_dropWhile_boxed_toList(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1) {
		boolean dropWhile0 = true;
		List<Long> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			Long t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToLong_takeWhile_mapToObj_toList(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1, LongFunction<T2> arg2) {
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			if(!arg1.test(t1)) {
				break;
			}
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Long> stream_mapToLong_takeWhile_boxed_toList(Collection<T0> input, ToLongFunction<T0> arg0, LongPredicate arg1) {
		List<Long> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			long t1 = arg0.applyAsLong(t0);
			if(!arg1.test(t1)) {
				break;
			}
			Long t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToDouble_map_mapToObj_toList(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleUnaryOperator arg1, DoubleFunction<T2> arg2) {
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			t1 = arg1.applyAsDouble(t1);
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Double> stream_mapToDouble_map_boxed_toList(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleUnaryOperator arg1) {
		List<Double> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			t1 = arg1.applyAsDouble(t1);
			Double t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToDouble_filter_mapToObj_toList(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1, DoubleFunction<T2> arg2) {
		List<T2> result = new ArrayList<>();
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Double> stream_mapToDouble_filter_boxed_toList(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1) {
		List<Double> result = new ArrayList<>();
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			if (!arg1.test(t1)) {
				continue;
			}
			Double t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T3> List<T3> stream_mapToDouble_mapToInt_mapToObj_toList(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToIntFunction arg1, IntFunction<T3> arg2) {
		List<T3> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			int t2 = arg1.applyAsInt(t1);
			T3 t3 = arg2.apply(t2);
			result.add(t3);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Integer> stream_mapToDouble_mapToInt_boxed_toList(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToIntFunction arg1) {
		List<Integer> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			int t2 = arg1.applyAsInt(t1);
			Integer t3 = t2;
			result.add(t3);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T3> List<T3> stream_mapToDouble_mapToLong_mapToObj_toList(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToLongFunction arg1, LongFunction<T3> arg2) {
		List<T3> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			long t2 = arg1.applyAsLong(t1);
			T3 t3 = arg2.apply(t2);
			result.add(t3);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Long> stream_mapToDouble_mapToLong_boxed_toList(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleToLongFunction arg1) {
		List<Long> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			long t2 = arg1.applyAsLong(t1);
			Long t3 = t2;
			result.add(t3);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2, T3> List<T3> stream_mapToDouble_mapToObj_map_toList(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleFunction<T2> arg1, Function<T2, T3> arg2) {
		List<T3> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			T2 t2 = arg1.apply(t1);
			T3 t3 = arg2.apply(t2);
			result.add(t3);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToDouble_mapToObj_filter_toList(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleFunction<T2> arg1, Predicate<T2> arg2) {
		List<T2> result = new ArrayList<>();
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			T2 t2 = arg1.apply(t1);
			if (!arg2.test(t2)) {
				continue;
			}
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToDouble_mapToObj_sorted_toList(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleFunction<T2> arg1) {
		List<T2> sorted0 = new ArrayList<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			T2 t2 = arg1.apply(t1);
			sorted0.add(t2);
		}
		Collections.sort((List) sorted0);
		for (T2 t2: sorted0) {
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToDouble_mapToObj_sortedComp_toList(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleFunction<T2> arg1, Comparator<? super T2> arg2) {
		List<T2> sortedComp0 = new ArrayList<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			T2 t2 = arg1.apply(t1);
			sortedComp0.add(t2);
		}
		sortedComp0.sort(arg2);
		for (T2 t2: sortedComp0) {
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToDouble_mapToObj_limit_toList(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleFunction<T2> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			T2 t2 = arg1.apply(t1);
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToDouble_mapToObj_skip_toList(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleFunction<T2> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			T2 t2 = arg1.apply(t1);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToDouble_mapToObj_distinct_toList(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleFunction<T2> arg1) {
		Set<T2> distinct0 = new HashSet<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			T2 t2 = arg1.apply(t1);
			if(!distinct0.add(t2)) {
				continue;
			}
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToDouble_mapToObj_dropWhile_toList(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleFunction<T2> arg1, Predicate<T2> arg2) {
		boolean dropWhile0 = true;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			T2 t2 = arg1.apply(t1);
			if(dropWhile0 && arg2.test(t2)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToDouble_mapToObj_takeWhile_toList(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleFunction<T2> arg1, Predicate<T2> arg2) {
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			T2 t2 = arg1.apply(t1);
			if(!arg2.test(t2)) {
				break;
			}
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2, T3> List<T3> stream_mapToDouble_mapToObj_flatMap_toList(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleFunction<T2> arg1, Function<T2, Collection<T3>> arg2) {
		List<T3> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			T2 t2 = arg1.apply(t1);
			for (T3 t3 : arg2.apply(t2)) {
				result.add(t3);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T3> List<T3> stream_mapToDouble_boxed_map_toList(Collection<T0> input, ToDoubleFunction<T0> arg0, Function<Double, T3> arg2) {
		List<T3> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			Double t2 = t1;
			T3 t3 = arg2.apply(t2);
			result.add(t3);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Double> stream_mapToDouble_boxed_filter_toList(Collection<T0> input, ToDoubleFunction<T0> arg0, Predicate<Double> arg2) {
		List<Double> result = new ArrayList<>();
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			Double t2 = t1;
			if (!arg2.test(t2)) {
				continue;
			}
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Double> stream_mapToDouble_boxed_sorted_toList(Collection<T0> input, ToDoubleFunction<T0> arg0) {
		List<Double> sorted0 = new ArrayList<>();
		List<Double> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			Double t2 = t1;
			sorted0.add(t2);
		}
		Collections.sort((List) sorted0);
		for (Double t2: sorted0) {
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Double> stream_mapToDouble_boxed_sortedComp_toList(Collection<T0> input, ToDoubleFunction<T0> arg0, Comparator<? super Double> arg2) {
		List<Double> sortedComp0 = new ArrayList<>();
		List<Double> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			Double t2 = t1;
			sortedComp0.add(t2);
		}
		sortedComp0.sort(arg2);
		for (Double t2: sortedComp0) {
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Double> stream_mapToDouble_boxed_limit_toList(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<Double> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			Double t2 = t1;
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Double> stream_mapToDouble_boxed_skip_toList(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<Double> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			Double t2 = t1;
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Double> stream_mapToDouble_boxed_distinct_toList(Collection<T0> input, ToDoubleFunction<T0> arg0) {
		Set<Double> distinct0 = new HashSet<>();
		List<Double> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			Double t2 = t1;
			if(!distinct0.add(t2)) {
				continue;
			}
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Double> stream_mapToDouble_boxed_dropWhile_toList(Collection<T0> input, ToDoubleFunction<T0> arg0, Predicate<Double> arg2) {
		boolean dropWhile0 = true;
		List<Double> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			Double t2 = t1;
			if(dropWhile0 && arg2.test(t2)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Double> stream_mapToDouble_boxed_takeWhile_toList(Collection<T0> input, ToDoubleFunction<T0> arg0, Predicate<Double> arg2) {
		List<Double> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			Double t2 = t1;
			if(!arg2.test(t2)) {
				break;
			}
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T3> List<T3> stream_mapToDouble_boxed_flatMap_toList(Collection<T0> input, ToDoubleFunction<T0> arg0, Function<Double, Collection<T3>> arg2) {
		List<T3> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			Double t2 = t1;
			for (T3 t3 : arg2.apply(t2)) {
				result.add(t3);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToDouble_sorted_mapToObj_toList(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleFunction<T2> arg2) {
		List<Double> sorted0 = new ArrayList<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (double t1: sorted0) {
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Double> stream_mapToDouble_sorted_boxed_toList(Collection<T0> input, ToDoubleFunction<T0> arg0) {
		List<Double> sorted0 = new ArrayList<>();
		List<Double> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (double t1: sorted0) {
			Double t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToDouble_limit_mapToObj_toList(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1, DoubleFunction<T2> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Double> stream_mapToDouble_limit_boxed_toList(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<Double> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			Double t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToDouble_skip_mapToObj_toList(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1, DoubleFunction<T2> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Double> stream_mapToDouble_skip_boxed_toList(Collection<T0> input, ToDoubleFunction<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<Double> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			Double t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToDouble_distinct_mapToObj_toList(Collection<T0> input, ToDoubleFunction<T0> arg0, DoubleFunction<T2> arg2) {
		Set<Double> distinct0 = new HashSet<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Double> stream_mapToDouble_distinct_boxed_toList(Collection<T0> input, ToDoubleFunction<T0> arg0) {
		Set<Double> distinct0 = new HashSet<>();
		List<Double> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			Double t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToDouble_dropWhile_mapToObj_toList(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1, DoubleFunction<T2> arg2) {
		boolean dropWhile0 = true;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Double> stream_mapToDouble_dropWhile_boxed_toList(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1) {
		boolean dropWhile0 = true;
		List<Double> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			if(dropWhile0 && arg1.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			Double t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_mapToDouble_takeWhile_mapToObj_toList(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1, DoubleFunction<T2> arg2) {
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			if(!arg1.test(t1)) {
				break;
			}
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Double> stream_mapToDouble_takeWhile_boxed_toList(Collection<T0> input, ToDoubleFunction<T0> arg0, DoublePredicate arg1) {
		List<Double> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			double t1 = arg0.applyAsDouble(t0);
			if(!arg1.test(t1)) {
				break;
			}
			Double t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_sorted_map_map_toList(Collection<T0> input, Function<T0, T1> arg1, Function<T1, T2> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			T1 t1 = arg1.apply(t0);
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sorted_map_filter_toList(Collection<T0> input, Function<T0, T1> arg1, Predicate<T1> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			T1 t1 = arg1.apply(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sorted_map_sorted_toList(Collection<T0> input, Function<T0, T1> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		List<T1> sorted1 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			T1 t1 = arg1.apply(t0);
			sorted1.add(t1);
		}
		Collections.sort((List) sorted1);
		for (T1 t1: sorted1) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sorted_map_sortedComp_toList(Collection<T0> input, Function<T0, T1> arg1, Comparator<? super T1> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T1> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			T1 t1 = arg1.apply(t0);
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg2);
		for (T1 t1: sortedComp0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sorted_map_limit_toList(Collection<T0> input, Function<T0, T1> arg1, long arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			T1 t1 = arg1.apply(t0);
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sorted_map_skip_toList(Collection<T0> input, Function<T0, T1> arg1, long arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			T1 t1 = arg1.apply(t0);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sorted_map_distinct_toList(Collection<T0> input, Function<T0, T1> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		Set<T1> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			T1 t1 = arg1.apply(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sorted_map_dropWhile_toList(Collection<T0> input, Function<T0, T1> arg1, Predicate<T1> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			T1 t1 = arg1.apply(t0);
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sorted_map_takeWhile_toList(Collection<T0> input, Function<T0, T1> arg1, Predicate<T1> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			T1 t1 = arg1.apply(t0);
			if(!arg2.test(t1)) {
				break;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_sorted_map_flatMap_toList(Collection<T0> input, Function<T0, T1> arg1, Function<T1, Collection<T2>> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			T1 t1 = arg1.apply(t0);
			for (T2 t2 : arg2.apply(t1)) {
				result.add(t2);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sorted_filter_map_toList(Collection<T0> input, Predicate<T0> arg1, Function<T0, T1> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if (!arg1.test(t0)) {
				continue;
			}
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_filter_filter_toList(Collection<T0> input, Predicate<T0> arg1, Predicate<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if (!arg1.test(t0)) {
				continue;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_filter_sorted_toList(Collection<T0> input, Predicate<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if (!arg1.test(t0)) {
				continue;
			}
			sorted1.add(t0);
		}
		Collections.sort((List) sorted1);
		for (T0 t0: sorted1) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_filter_sortedComp_toList(Collection<T0> input, Predicate<T0> arg1, Comparator<? super T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if (!arg1.test(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_filter_limit_toList(Collection<T0> input, Predicate<T0> arg1, long arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if (!arg1.test(t0)) {
				continue;
			}
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_filter_skip_toList(Collection<T0> input, Predicate<T0> arg1, long arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if (!arg1.test(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_filter_distinct_toList(Collection<T0> input, Predicate<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if (!arg1.test(t0)) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_filter_dropWhile_toList(Collection<T0> input, Predicate<T0> arg1, Predicate<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if (!arg1.test(t0)) {
				continue;
			}
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_filter_takeWhile_toList(Collection<T0> input, Predicate<T0> arg1, Predicate<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if (!arg1.test(t0)) {
				continue;
			}
			if(!arg2.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sorted_filter_flatMap_toList(Collection<T0> input, Predicate<T0> arg1, Function<T0, Collection<T1>> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if (!arg1.test(t0)) {
				continue;
			}
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_sorted_mapToInt_mapToObj_toList(Collection<T0> input, ToIntFunction<T0> arg1, IntFunction<T2> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			int t1 = arg1.applyAsInt(t0);
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Integer> stream_sorted_mapToInt_boxed_toList(Collection<T0> input, ToIntFunction<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		List<Integer> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			int t1 = arg1.applyAsInt(t0);
			Integer t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_sorted_mapToLong_mapToObj_toList(Collection<T0> input, ToLongFunction<T0> arg1, LongFunction<T2> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			long t1 = arg1.applyAsLong(t0);
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Long> stream_sorted_mapToLong_boxed_toList(Collection<T0> input, ToLongFunction<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		List<Long> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			long t1 = arg1.applyAsLong(t0);
			Long t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_sorted_mapToDouble_mapToObj_toList(Collection<T0> input, ToDoubleFunction<T0> arg1, DoubleFunction<T2> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			double t1 = arg1.applyAsDouble(t0);
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Double> stream_sorted_mapToDouble_boxed_toList(Collection<T0> input, ToDoubleFunction<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		List<Double> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			double t1 = arg1.applyAsDouble(t0);
			Double t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sorted_sorted_map_toList(Collection<T0> input, Function<T0, T1> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			sorted1.add(t0);
		}
		Collections.sort((List) sorted1);
		for (T0 t0: sorted1) {
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_sorted_filter_toList(Collection<T0> input, Predicate<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			sorted1.add(t0);
		}
		Collections.sort((List) sorted1);
		for (T0 t0: sorted1) {
			if (!arg2.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_sorted_sorted_toList(Collection<T0> input) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		List<T0> sorted2 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			sorted1.add(t0);
		}
		Collections.sort((List) sorted1);
		for (T0 t0: sorted1) {
			sorted2.add(t0);
		}
		Collections.sort((List) sorted2);
		for (T0 t0: sorted2) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_sorted_sortedComp_toList(Collection<T0> input, Comparator<? super T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			sorted1.add(t0);
		}
		Collections.sort((List) sorted1);
		for (T0 t0: sorted1) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_sorted_limit_toList(Collection<T0> input, long arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			sorted1.add(t0);
		}
		Collections.sort((List) sorted1);
		for (T0 t0: sorted1) {
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_sorted_skip_toList(Collection<T0> input, long arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			sorted1.add(t0);
		}
		Collections.sort((List) sorted1);
		for (T0 t0: sorted1) {
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_sorted_distinct_toList(Collection<T0> input) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			sorted1.add(t0);
		}
		Collections.sort((List) sorted1);
		for (T0 t0: sorted1) {
			if(!distinct0.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_sorted_dropWhile_toList(Collection<T0> input, Predicate<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			sorted1.add(t0);
		}
		Collections.sort((List) sorted1);
		for (T0 t0: sorted1) {
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_sorted_takeWhile_toList(Collection<T0> input, Predicate<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			sorted1.add(t0);
		}
		Collections.sort((List) sorted1);
		for (T0 t0: sorted1) {
			if(!arg2.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sorted_sorted_flatMap_toList(Collection<T0> input, Function<T0, Collection<T1>> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			sorted1.add(t0);
		}
		Collections.sort((List) sorted1);
		for (T0 t0: sorted1) {
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sorted_sortedComp_map_toList(Collection<T0> input, Comparator<? super T0> arg1, Function<T0, T1> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_sortedComp_filter_toList(Collection<T0> input, Comparator<? super T0> arg1, Predicate<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			if (!arg2.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_sortedComp_sorted_toList(Collection<T0> input, Comparator<? super T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			sorted1.add(t0);
		}
		Collections.sort((List) sorted1);
		for (T0 t0: sorted1) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_sortedComp_sortedComp_toList(Collection<T0> input, Comparator<? super T0> arg1, Comparator<? super T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			sortedComp1.add(t0);
		}
		sortedComp1.sort(arg2);
		for (T0 t0: sortedComp1) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_sortedComp_limit_toList(Collection<T0> input, Comparator<? super T0> arg1, long arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_sortedComp_skip_toList(Collection<T0> input, Comparator<? super T0> arg1, long arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_sortedComp_distinct_toList(Collection<T0> input, Comparator<? super T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_sortedComp_dropWhile_toList(Collection<T0> input, Comparator<? super T0> arg1, Predicate<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_sortedComp_takeWhile_toList(Collection<T0> input, Comparator<? super T0> arg1, Predicate<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			if(!arg2.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sorted_sortedComp_flatMap_toList(Collection<T0> input, Comparator<? super T0> arg1, Function<T0, Collection<T1>> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sorted_limit_map_toList(Collection<T0> input, long arg1, Function<T0, T1> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_limit_filter_toList(Collection<T0> input, long arg1, Predicate<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_limit_sorted_toList(Collection<T0> input, long arg1) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted1 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			sorted1.add(t0);
		}
		Collections.sort((List) sorted1);
		for (T0 t0: sorted1) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_limit_sortedComp_toList(Collection<T0> input, long arg1, Comparator<? super T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_limit_limit_toList(Collection<T0> input, long arg1, long arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			limit1++;
			if(limit1 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_limit_skip_toList(Collection<T0> input, long arg1, long arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_limit_distinct_toList(Collection<T0> input, long arg1) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_limit_dropWhile_toList(Collection<T0> input, long arg1, Predicate<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_limit_takeWhile_toList(Collection<T0> input, long arg1, Predicate<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			if(!arg2.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sorted_limit_flatMap_toList(Collection<T0> input, long arg1, Function<T0, Collection<T1>> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sorted_skip_map_toList(Collection<T0> input, long arg1, Function<T0, T1> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_skip_filter_toList(Collection<T0> input, long arg1, Predicate<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_skip_sorted_toList(Collection<T0> input, long arg1) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted1 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			sorted1.add(t0);
		}
		Collections.sort((List) sorted1);
		for (T0 t0: sorted1) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_skip_sortedComp_toList(Collection<T0> input, long arg1, Comparator<? super T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_skip_limit_toList(Collection<T0> input, long arg1, long arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_skip_skip_toList(Collection<T0> input, long arg1, long arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			skip1++;
			if(skip1 <= arg2) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_skip_distinct_toList(Collection<T0> input, long arg1) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_skip_dropWhile_toList(Collection<T0> input, long arg1, Predicate<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_skip_takeWhile_toList(Collection<T0> input, long arg1, Predicate<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if(!arg2.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sorted_skip_flatMap_toList(Collection<T0> input, long arg1, Function<T0, Collection<T1>> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sorted_distinct_map_toList(Collection<T0> input, Function<T0, T1> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_distinct_filter_toList(Collection<T0> input, Predicate<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_distinct_sorted_toList(Collection<T0> input) {
		List<T0> sorted0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sorted1 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sorted1.add(t0);
		}
		Collections.sort((List) sorted1);
		for (T0 t0: sorted1) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_distinct_sortedComp_toList(Collection<T0> input, Comparator<? super T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_distinct_limit_toList(Collection<T0> input, long arg2) {
		List<T0> sorted0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_distinct_skip_toList(Collection<T0> input, long arg2) {
		List<T0> sorted0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_distinct_distinct_toList(Collection<T0> input) {
		List<T0> sorted0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		Set<T0> distinct1 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!distinct1.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_distinct_dropWhile_toList(Collection<T0> input, Predicate<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_distinct_takeWhile_toList(Collection<T0> input, Predicate<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!arg2.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sorted_distinct_flatMap_toList(Collection<T0> input, Function<T0, Collection<T1>> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sorted_dropWhile_map_toList(Collection<T0> input, Predicate<T0> arg1, Function<T0, T1> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_dropWhile_filter_toList(Collection<T0> input, Predicate<T0> arg1, Predicate<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_dropWhile_sorted_toList(Collection<T0> input, Predicate<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		List<T0> sorted1 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sorted1.add(t0);
		}
		Collections.sort((List) sorted1);
		for (T0 t0: sorted1) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_dropWhile_sortedComp_toList(Collection<T0> input, Predicate<T0> arg1, Comparator<? super T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_dropWhile_limit_toList(Collection<T0> input, Predicate<T0> arg1, long arg2) {
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_dropWhile_skip_toList(Collection<T0> input, Predicate<T0> arg1, long arg2) {
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_dropWhile_distinct_toList(Collection<T0> input, Predicate<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_dropWhile_dropWhile_toList(Collection<T0> input, Predicate<T0> arg1, Predicate<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_dropWhile_takeWhile_toList(Collection<T0> input, Predicate<T0> arg1, Predicate<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!arg2.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sorted_dropWhile_flatMap_toList(Collection<T0> input, Predicate<T0> arg1, Function<T0, Collection<T1>> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sorted_takeWhile_map_toList(Collection<T0> input, Predicate<T0> arg1, Function<T0, T1> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(!arg1.test(t0)) {
				break;
			}
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_takeWhile_filter_toList(Collection<T0> input, Predicate<T0> arg1, Predicate<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(!arg1.test(t0)) {
				break;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_takeWhile_sorted_toList(Collection<T0> input, Predicate<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(!arg1.test(t0)) {
				break;
			}
			sorted1.add(t0);
		}
		Collections.sort((List) sorted1);
		for (T0 t0: sorted1) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_takeWhile_sortedComp_toList(Collection<T0> input, Predicate<T0> arg1, Comparator<? super T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(!arg1.test(t0)) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_takeWhile_limit_toList(Collection<T0> input, Predicate<T0> arg1, long arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(!arg1.test(t0)) {
				break;
			}
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_takeWhile_skip_toList(Collection<T0> input, Predicate<T0> arg1, long arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(!arg1.test(t0)) {
				break;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_takeWhile_distinct_toList(Collection<T0> input, Predicate<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(!arg1.test(t0)) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_takeWhile_dropWhile_toList(Collection<T0> input, Predicate<T0> arg1, Predicate<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(!arg1.test(t0)) {
				break;
			}
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sorted_takeWhile_takeWhile_toList(Collection<T0> input, Predicate<T0> arg1, Predicate<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(!arg1.test(t0)) {
				break;
			}
			if(!arg2.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sorted_takeWhile_flatMap_toList(Collection<T0> input, Predicate<T0> arg1, Function<T0, Collection<T1>> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(!arg1.test(t0)) {
				break;
			}
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_sorted_flatMap_map_toList(Collection<T0> input, Function<T0, Collection<T1>> arg1, Function<T1, T2> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			for (T1 t1 : arg1.apply(t0)) {
				T2 t2 = arg2.apply(t1);
				result.add(t2);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sorted_flatMap_filter_toList(Collection<T0> input, Function<T0, Collection<T1>> arg1, Predicate<T1> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			for (T1 t1 : arg1.apply(t0)) {
				if (!arg2.test(t1)) {
					continue;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sorted_flatMap_sorted_toList(Collection<T0> input, Function<T0, Collection<T1>> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		List<T1> sorted1 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			for (T1 t1 : arg1.apply(t0)) {
				sorted1.add(t1);
			}
		}
		Collections.sort((List) sorted1);
		for (T1 t1: sorted1) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sorted_flatMap_sortedComp_toList(Collection<T0> input, Function<T0, Collection<T1>> arg1, Comparator<? super T1> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T1> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			for (T1 t1 : arg1.apply(t0)) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg2);
		for (T1 t1: sortedComp0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sorted_flatMap_limit_toList(Collection<T0> input, Function<T0, Collection<T1>> arg1, long arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			for (T1 t1 : arg1.apply(t0)) {
				limit0++;
				if(limit0 > arg2) {
					break;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sorted_flatMap_skip_toList(Collection<T0> input, Function<T0, Collection<T1>> arg1, long arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			for (T1 t1 : arg1.apply(t0)) {
				skip0++;
				if(skip0 <= arg2) {
					continue;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sorted_flatMap_distinct_toList(Collection<T0> input, Function<T0, Collection<T1>> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		Set<T1> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			for (T1 t1 : arg1.apply(t0)) {
				if(!distinct0.add(t1)) {
					continue;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sorted_flatMap_dropWhile_toList(Collection<T0> input, Function<T0, Collection<T1>> arg1, Predicate<T1> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			for (T1 t1 : arg1.apply(t0)) {
				if(dropWhile0 && arg2.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sorted_flatMap_takeWhile_toList(Collection<T0> input, Function<T0, Collection<T1>> arg1, Predicate<T1> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			for (T1 t1 : arg1.apply(t0)) {
				if(!arg2.test(t1)) {
					break;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_sorted_flatMap_flatMap_toList(Collection<T0> input, Function<T0, Collection<T1>> arg1, Function<T1, Collection<T2>> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			for (T1 t1 : arg1.apply(t0)) {
				for (T2 t2 : arg2.apply(t1)) {
					result.add(t2);
				}
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_sortedComp_map_map_toList(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, T1> arg1, Function<T1, T2> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			T1 t1 = arg1.apply(t0);
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sortedComp_map_filter_toList(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, T1> arg1, Predicate<T1> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			T1 t1 = arg1.apply(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sortedComp_map_sorted_toList(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, T1> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T1> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			T1 t1 = arg1.apply(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sortedComp_map_sortedComp_toList(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, T1> arg1, Comparator<? super T1> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T1> sortedComp1 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			T1 t1 = arg1.apply(t0);
			sortedComp1.add(t1);
		}
		sortedComp1.sort(arg2);
		for (T1 t1: sortedComp1) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sortedComp_map_limit_toList(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, T1> arg1, long arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			T1 t1 = arg1.apply(t0);
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sortedComp_map_skip_toList(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, T1> arg1, long arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			T1 t1 = arg1.apply(t0);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sortedComp_map_distinct_toList(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, T1> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T1> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			T1 t1 = arg1.apply(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sortedComp_map_dropWhile_toList(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, T1> arg1, Predicate<T1> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sortedComp_map_takeWhile_toList(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, T1> arg1, Predicate<T1> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			T1 t1 = arg1.apply(t0);
			if(!arg2.test(t1)) {
				break;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_sortedComp_map_flatMap_toList(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, T1> arg1, Function<T1, Collection<T2>> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			T1 t1 = arg1.apply(t0);
			for (T2 t2 : arg2.apply(t1)) {
				result.add(t2);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sortedComp_filter_map_toList(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Function<T0, T1> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if (!arg1.test(t0)) {
				continue;
			}
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_filter_filter_toList(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_filter_sorted_toList(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if (!arg1.test(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_filter_sortedComp_toList(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Comparator<? super T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_filter_limit_toList(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, long arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if (!arg1.test(t0)) {
				continue;
			}
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_filter_skip_toList(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, long arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_filter_distinct_toList(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_filter_dropWhile_toList(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_filter_takeWhile_toList(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sortedComp_filter_flatMap_toList(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Function<T0, Collection<T1>> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if (!arg1.test(t0)) {
				continue;
			}
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_sortedComp_mapToInt_mapToObj_toList(Collection<T0> input, Comparator<? super T0> arg0, ToIntFunction<T0> arg1, IntFunction<T2> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			int t1 = arg1.applyAsInt(t0);
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Integer> stream_sortedComp_mapToInt_boxed_toList(Collection<T0> input, Comparator<? super T0> arg0, ToIntFunction<T0> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<Integer> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			int t1 = arg1.applyAsInt(t0);
			Integer t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_sortedComp_mapToLong_mapToObj_toList(Collection<T0> input, Comparator<? super T0> arg0, ToLongFunction<T0> arg1, LongFunction<T2> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			long t1 = arg1.applyAsLong(t0);
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Long> stream_sortedComp_mapToLong_boxed_toList(Collection<T0> input, Comparator<? super T0> arg0, ToLongFunction<T0> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<Long> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			long t1 = arg1.applyAsLong(t0);
			Long t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_sortedComp_mapToDouble_mapToObj_toList(Collection<T0> input, Comparator<? super T0> arg0, ToDoubleFunction<T0> arg1, DoubleFunction<T2> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			double t1 = arg1.applyAsDouble(t0);
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Double> stream_sortedComp_mapToDouble_boxed_toList(Collection<T0> input, Comparator<? super T0> arg0, ToDoubleFunction<T0> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<Double> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			double t1 = arg1.applyAsDouble(t0);
			Double t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sortedComp_sorted_map_toList(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, T1> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_sorted_filter_toList(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if (!arg2.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_sorted_sorted_toList(Collection<T0> input, Comparator<? super T0> arg0) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			sorted1.add(t0);
		}
		Collections.sort((List) sorted1);
		for (T0 t0: sorted1) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_sorted_sortedComp_toList(Collection<T0> input, Comparator<? super T0> arg0, Comparator<? super T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			sortedComp1.add(t0);
		}
		sortedComp1.sort(arg2);
		for (T0 t0: sortedComp1) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_sorted_limit_toList(Collection<T0> input, Comparator<? super T0> arg0, long arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_sorted_skip_toList(Collection<T0> input, Comparator<? super T0> arg0, long arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_sorted_distinct_toList(Collection<T0> input, Comparator<? super T0> arg0) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_sorted_dropWhile_toList(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_sorted_takeWhile_toList(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(!arg2.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sortedComp_sorted_flatMap_toList(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, Collection<T1>> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sortedComp_sortedComp_map_toList(Collection<T0> input, Comparator<? super T0> arg0, Comparator<? super T0> arg1, Function<T0, T1> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sortedComp1.add(t0);
		}
		sortedComp1.sort(arg1);
		for (T0 t0: sortedComp1) {
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_sortedComp_filter_toList(Collection<T0> input, Comparator<? super T0> arg0, Comparator<? super T0> arg1, Predicate<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_sortedComp_sorted_toList(Collection<T0> input, Comparator<? super T0> arg0, Comparator<? super T0> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_sortedComp_sortedComp_toList(Collection<T0> input, Comparator<? super T0> arg0, Comparator<? super T0> arg1, Comparator<? super T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		List<T0> sortedComp2 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_sortedComp_limit_toList(Collection<T0> input, Comparator<? super T0> arg0, Comparator<? super T0> arg1, long arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sortedComp1.add(t0);
		}
		sortedComp1.sort(arg1);
		for (T0 t0: sortedComp1) {
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_sortedComp_skip_toList(Collection<T0> input, Comparator<? super T0> arg0, Comparator<? super T0> arg1, long arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_sortedComp_distinct_toList(Collection<T0> input, Comparator<? super T0> arg0, Comparator<? super T0> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_sortedComp_dropWhile_toList(Collection<T0> input, Comparator<? super T0> arg0, Comparator<? super T0> arg1, Predicate<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_sortedComp_takeWhile_toList(Collection<T0> input, Comparator<? super T0> arg0, Comparator<? super T0> arg1, Predicate<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sortedComp_sortedComp_flatMap_toList(Collection<T0> input, Comparator<? super T0> arg0, Comparator<? super T0> arg1, Function<T0, Collection<T1>> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			sortedComp1.add(t0);
		}
		sortedComp1.sort(arg1);
		for (T0 t0: sortedComp1) {
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sortedComp_limit_map_toList(Collection<T0> input, Comparator<? super T0> arg0, long arg1, Function<T0, T1> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_limit_filter_toList(Collection<T0> input, Comparator<? super T0> arg0, long arg1, Predicate<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_limit_sorted_toList(Collection<T0> input, Comparator<? super T0> arg0, long arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_limit_sortedComp_toList(Collection<T0> input, Comparator<? super T0> arg0, long arg1, Comparator<? super T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp1 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			sortedComp1.add(t0);
		}
		sortedComp1.sort(arg2);
		for (T0 t0: sortedComp1) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_limit_limit_toList(Collection<T0> input, Comparator<? super T0> arg0, long arg1, long arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			limit1++;
			if(limit1 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_limit_skip_toList(Collection<T0> input, Comparator<? super T0> arg0, long arg1, long arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_limit_distinct_toList(Collection<T0> input, Comparator<? super T0> arg0, long arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_limit_dropWhile_toList(Collection<T0> input, Comparator<? super T0> arg0, long arg1, Predicate<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_limit_takeWhile_toList(Collection<T0> input, Comparator<? super T0> arg0, long arg1, Predicate<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			if(!arg2.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sortedComp_limit_flatMap_toList(Collection<T0> input, Comparator<? super T0> arg0, long arg1, Function<T0, Collection<T1>> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sortedComp_skip_map_toList(Collection<T0> input, Comparator<? super T0> arg0, long arg1, Function<T0, T1> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_skip_filter_toList(Collection<T0> input, Comparator<? super T0> arg0, long arg1, Predicate<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_skip_sorted_toList(Collection<T0> input, Comparator<? super T0> arg0, long arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_skip_sortedComp_toList(Collection<T0> input, Comparator<? super T0> arg0, long arg1, Comparator<? super T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp1 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_skip_limit_toList(Collection<T0> input, Comparator<? super T0> arg0, long arg1, long arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_skip_skip_toList(Collection<T0> input, Comparator<? super T0> arg0, long arg1, long arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_skip_distinct_toList(Collection<T0> input, Comparator<? super T0> arg0, long arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_skip_dropWhile_toList(Collection<T0> input, Comparator<? super T0> arg0, long arg1, Predicate<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_skip_takeWhile_toList(Collection<T0> input, Comparator<? super T0> arg0, long arg1, Predicate<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sortedComp_skip_flatMap_toList(Collection<T0> input, Comparator<? super T0> arg0, long arg1, Function<T0, Collection<T1>> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sortedComp_distinct_map_toList(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, T1> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_distinct_filter_toList(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_distinct_sorted_toList(Collection<T0> input, Comparator<? super T0> arg0) {
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_distinct_sortedComp_toList(Collection<T0> input, Comparator<? super T0> arg0, Comparator<? super T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sortedComp1 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sortedComp1.add(t0);
		}
		sortedComp1.sort(arg2);
		for (T0 t0: sortedComp1) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_distinct_limit_toList(Collection<T0> input, Comparator<? super T0> arg0, long arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_distinct_skip_toList(Collection<T0> input, Comparator<? super T0> arg0, long arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_distinct_distinct_toList(Collection<T0> input, Comparator<? super T0> arg0) {
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		Set<T0> distinct1 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_distinct_dropWhile_toList(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_distinct_takeWhile_toList(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!arg2.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sortedComp_distinct_flatMap_toList(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, Collection<T1>> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sortedComp_dropWhile_map_toList(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Function<T0, T1> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_dropWhile_filter_toList(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_dropWhile_sorted_toList(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_dropWhile_sortedComp_toList(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Comparator<? super T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		List<T0> sortedComp1 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_dropWhile_limit_toList(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, long arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_dropWhile_skip_toList(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, long arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_dropWhile_distinct_toList(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_dropWhile_dropWhile_toList(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_dropWhile_takeWhile_toList(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sortedComp_dropWhile_flatMap_toList(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Function<T0, Collection<T1>> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sortedComp_takeWhile_map_toList(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Function<T0, T1> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!arg1.test(t0)) {
				break;
			}
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_takeWhile_filter_toList(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_takeWhile_sorted_toList(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!arg1.test(t0)) {
				break;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_takeWhile_sortedComp_toList(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Comparator<? super T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_takeWhile_limit_toList(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, long arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!arg1.test(t0)) {
				break;
			}
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_takeWhile_skip_toList(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, long arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_takeWhile_distinct_toList(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_takeWhile_dropWhile_toList(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_sortedComp_takeWhile_takeWhile_toList(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sortedComp_takeWhile_flatMap_toList(Collection<T0> input, Comparator<? super T0> arg0, Predicate<T0> arg1, Function<T0, Collection<T1>> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			if(!arg1.test(t0)) {
				break;
			}
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_sortedComp_flatMap_map_toList(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, Collection<T1>> arg1, Function<T1, T2> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : arg1.apply(t0)) {
				T2 t2 = arg2.apply(t1);
				result.add(t2);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sortedComp_flatMap_filter_toList(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, Collection<T1>> arg1, Predicate<T1> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : arg1.apply(t0)) {
				if (!arg2.test(t1)) {
					continue;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sortedComp_flatMap_sorted_toList(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, Collection<T1>> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T1> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : arg1.apply(t0)) {
				sorted0.add(t1);
			}
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sortedComp_flatMap_sortedComp_toList(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, Collection<T1>> arg1, Comparator<? super T1> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T1> sortedComp1 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sortedComp_flatMap_limit_toList(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, Collection<T1>> arg1, long arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : arg1.apply(t0)) {
				limit0++;
				if(limit0 > arg2) {
					break;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sortedComp_flatMap_skip_toList(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, Collection<T1>> arg1, long arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : arg1.apply(t0)) {
				skip0++;
				if(skip0 <= arg2) {
					continue;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sortedComp_flatMap_distinct_toList(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, Collection<T1>> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T1> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : arg1.apply(t0)) {
				if(!distinct0.add(t1)) {
					continue;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sortedComp_flatMap_dropWhile_toList(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, Collection<T1>> arg1, Predicate<T1> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_sortedComp_flatMap_takeWhile_toList(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, Collection<T1>> arg1, Predicate<T1> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : arg1.apply(t0)) {
				if(!arg2.test(t1)) {
					break;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_sortedComp_flatMap_flatMap_toList(Collection<T0> input, Comparator<? super T0> arg0, Function<T0, Collection<T1>> arg1, Function<T1, Collection<T2>> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg0);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : arg1.apply(t0)) {
				for (T2 t2 : arg2.apply(t1)) {
					result.add(t2);
				}
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_limit_map_map_toList(Collection<T0> input, long arg0, Function<T0, T1> arg1, Function<T1, T2> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			T1 t1 = arg1.apply(t0);
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_limit_map_filter_toList(Collection<T0> input, long arg0, Function<T0, T1> arg1, Predicate<T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			T1 t1 = arg1.apply(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_limit_map_sorted_toList(Collection<T0> input, long arg0, Function<T0, T1> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			T1 t1 = arg1.apply(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_limit_map_sortedComp_toList(Collection<T0> input, long arg0, Function<T0, T1> arg1, Comparator<? super T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			T1 t1 = arg1.apply(t0);
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg2);
		for (T1 t1: sortedComp0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_limit_map_limit_toList(Collection<T0> input, long arg0, Function<T0, T1> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			T1 t1 = arg1.apply(t0);
			limit1++;
			if(limit1 > arg2) {
				break;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_limit_map_skip_toList(Collection<T0> input, long arg0, Function<T0, T1> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			T1 t1 = arg1.apply(t0);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_limit_map_distinct_toList(Collection<T0> input, long arg0, Function<T0, T1> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T1> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			T1 t1 = arg1.apply(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_limit_map_dropWhile_toList(Collection<T0> input, long arg0, Function<T0, T1> arg1, Predicate<T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			T1 t1 = arg1.apply(t0);
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_limit_map_takeWhile_toList(Collection<T0> input, long arg0, Function<T0, T1> arg1, Predicate<T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			T1 t1 = arg1.apply(t0);
			if(!arg2.test(t1)) {
				break;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_limit_map_flatMap_toList(Collection<T0> input, long arg0, Function<T0, T1> arg1, Function<T1, Collection<T2>> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			T1 t1 = arg1.apply(t0);
			for (T2 t2 : arg2.apply(t1)) {
				result.add(t2);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_limit_filter_map_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, Function<T0, T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_filter_filter_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_filter_sorted_toList(Collection<T0> input, long arg0, Predicate<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_filter_sortedComp_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, Comparator<? super T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_filter_limit_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			limit1++;
			if(limit1 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_filter_skip_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_filter_distinct_toList(Collection<T0> input, long arg0, Predicate<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_filter_dropWhile_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_filter_takeWhile_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			if(!arg2.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_limit_filter_flatMap_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, Function<T0, Collection<T1>> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_limit_mapToInt_mapToObj_toList(Collection<T0> input, long arg0, ToIntFunction<T0> arg1, IntFunction<T2> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			int t1 = arg1.applyAsInt(t0);
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Integer> stream_limit_mapToInt_boxed_toList(Collection<T0> input, long arg0, ToIntFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<Integer> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			int t1 = arg1.applyAsInt(t0);
			Integer t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_limit_mapToLong_mapToObj_toList(Collection<T0> input, long arg0, ToLongFunction<T0> arg1, LongFunction<T2> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			long t1 = arg1.applyAsLong(t0);
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Long> stream_limit_mapToLong_boxed_toList(Collection<T0> input, long arg0, ToLongFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<Long> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			long t1 = arg1.applyAsLong(t0);
			Long t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_limit_mapToDouble_mapToObj_toList(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1, DoubleFunction<T2> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			double t1 = arg1.applyAsDouble(t0);
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Double> stream_limit_mapToDouble_boxed_toList(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<Double> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			double t1 = arg1.applyAsDouble(t0);
			Double t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_limit_sorted_map_toList(Collection<T0> input, long arg0, Function<T0, T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_sorted_filter_toList(Collection<T0> input, long arg0, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if (!arg2.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_sorted_sorted_toList(Collection<T0> input, long arg0) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			sorted1.add(t0);
		}
		Collections.sort((List) sorted1);
		for (T0 t0: sorted1) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_sorted_sortedComp_toList(Collection<T0> input, long arg0, Comparator<? super T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_sorted_limit_toList(Collection<T0> input, long arg0, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			limit1++;
			if(limit1 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_sorted_skip_toList(Collection<T0> input, long arg0, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_sorted_distinct_toList(Collection<T0> input, long arg0) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_sorted_dropWhile_toList(Collection<T0> input, long arg0, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_sorted_takeWhile_toList(Collection<T0> input, long arg0, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(!arg2.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_limit_sorted_flatMap_toList(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_limit_sortedComp_map_toList(Collection<T0> input, long arg0, Comparator<? super T0> arg1, Function<T0, T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_sortedComp_filter_toList(Collection<T0> input, long arg0, Comparator<? super T0> arg1, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			if (!arg2.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_sortedComp_sorted_toList(Collection<T0> input, long arg0, Comparator<? super T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_sortedComp_sortedComp_toList(Collection<T0> input, long arg0, Comparator<? super T0> arg1, Comparator<? super T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_sortedComp_limit_toList(Collection<T0> input, long arg0, Comparator<? super T0> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			limit1++;
			if(limit1 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_sortedComp_skip_toList(Collection<T0> input, long arg0, Comparator<? super T0> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_sortedComp_distinct_toList(Collection<T0> input, long arg0, Comparator<? super T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_sortedComp_dropWhile_toList(Collection<T0> input, long arg0, Comparator<? super T0> arg1, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_sortedComp_takeWhile_toList(Collection<T0> input, long arg0, Comparator<? super T0> arg1, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			if(!arg2.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_limit_sortedComp_flatMap_toList(Collection<T0> input, long arg0, Comparator<? super T0> arg1, Function<T0, Collection<T1>> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_limit_limit_map_toList(Collection<T0> input, long arg0, long arg1, Function<T0, T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			limit1++;
			if(limit1 > arg1) {
				break;
			}
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_limit_filter_toList(Collection<T0> input, long arg0, long arg1, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			limit1++;
			if(limit1 > arg1) {
				break;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_limit_sorted_toList(Collection<T0> input, long arg0, long arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			limit1++;
			if(limit1 > arg1) {
				break;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_limit_sortedComp_toList(Collection<T0> input, long arg0, long arg1, Comparator<? super T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			limit1++;
			if(limit1 > arg1) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_limit_limit_toList(Collection<T0> input, long arg0, long arg1, long arg2) {
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
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			limit1++;
			if(limit1 > arg1) {
				break;
			}
			limit2++;
			if(limit2 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_limit_skip_toList(Collection<T0> input, long arg0, long arg1, long arg2) {
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
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			limit1++;
			if(limit1 > arg1) {
				break;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_limit_distinct_toList(Collection<T0> input, long arg0, long arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			limit1++;
			if(limit1 > arg1) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_limit_dropWhile_toList(Collection<T0> input, long arg0, long arg1, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			limit1++;
			if(limit1 > arg1) {
				break;
			}
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_limit_takeWhile_toList(Collection<T0> input, long arg0, long arg1, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			limit1++;
			if(limit1 > arg1) {
				break;
			}
			if(!arg2.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_limit_limit_flatMap_toList(Collection<T0> input, long arg0, long arg1, Function<T0, Collection<T1>> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			limit1++;
			if(limit1 > arg1) {
				break;
			}
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_limit_skip_map_toList(Collection<T0> input, long arg0, long arg1, Function<T0, T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_skip_filter_toList(Collection<T0> input, long arg0, long arg1, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_skip_sorted_toList(Collection<T0> input, long arg0, long arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_skip_sortedComp_toList(Collection<T0> input, long arg0, long arg1, Comparator<? super T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_skip_limit_toList(Collection<T0> input, long arg0, long arg1, long arg2) {
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
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			limit1++;
			if(limit1 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_skip_skip_toList(Collection<T0> input, long arg0, long arg1, long arg2) {
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
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_skip_distinct_toList(Collection<T0> input, long arg0, long arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_skip_dropWhile_toList(Collection<T0> input, long arg0, long arg1, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_skip_takeWhile_toList(Collection<T0> input, long arg0, long arg1, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if(!arg2.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_limit_skip_flatMap_toList(Collection<T0> input, long arg0, long arg1, Function<T0, Collection<T1>> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_limit_distinct_map_toList(Collection<T0> input, long arg0, Function<T0, T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_distinct_filter_toList(Collection<T0> input, long arg0, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_distinct_sorted_toList(Collection<T0> input, long arg0) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_distinct_sortedComp_toList(Collection<T0> input, long arg0, Comparator<? super T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_distinct_limit_toList(Collection<T0> input, long arg0, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			limit1++;
			if(limit1 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_distinct_skip_toList(Collection<T0> input, long arg0, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_distinct_distinct_toList(Collection<T0> input, long arg0) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		Set<T0> distinct1 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!distinct1.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_distinct_dropWhile_toList(Collection<T0> input, long arg0, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_distinct_takeWhile_toList(Collection<T0> input, long arg0, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!arg2.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_limit_distinct_flatMap_toList(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_limit_dropWhile_map_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, Function<T0, T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_dropWhile_filter_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_dropWhile_sorted_toList(Collection<T0> input, long arg0, Predicate<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_dropWhile_sortedComp_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, Comparator<? super T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_dropWhile_limit_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			limit1++;
			if(limit1 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_dropWhile_skip_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_dropWhile_distinct_toList(Collection<T0> input, long arg0, Predicate<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_dropWhile_dropWhile_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_dropWhile_takeWhile_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_limit_dropWhile_flatMap_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, Function<T0, Collection<T1>> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_limit_takeWhile_map_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, Function<T0, T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			if(!arg1.test(t0)) {
				break;
			}
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_takeWhile_filter_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			if(!arg1.test(t0)) {
				break;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_takeWhile_sorted_toList(Collection<T0> input, long arg0, Predicate<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			if(!arg1.test(t0)) {
				break;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_takeWhile_sortedComp_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, Comparator<? super T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			if(!arg1.test(t0)) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_takeWhile_limit_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			if(!arg1.test(t0)) {
				break;
			}
			limit1++;
			if(limit1 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_takeWhile_skip_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			if(!arg1.test(t0)) {
				break;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_takeWhile_distinct_toList(Collection<T0> input, long arg0, Predicate<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			if(!arg1.test(t0)) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_takeWhile_dropWhile_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_limit_takeWhile_takeWhile_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			if(!arg1.test(t0)) {
				break;
			}
			if(!arg2.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_limit_takeWhile_flatMap_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, Function<T0, Collection<T1>> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			if(!arg1.test(t0)) {
				break;
			}
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_limit_flatMap_map_toList(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, Function<T1, T2> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			for (T1 t1 : arg1.apply(t0)) {
				T2 t2 = arg2.apply(t1);
				result.add(t2);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_limit_flatMap_filter_toList(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, Predicate<T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			for (T1 t1 : arg1.apply(t0)) {
				if (!arg2.test(t1)) {
					continue;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_limit_flatMap_sorted_toList(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			for (T1 t1 : arg1.apply(t0)) {
				sorted0.add(t1);
			}
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_limit_flatMap_sortedComp_toList(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, Comparator<? super T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			for (T1 t1 : arg1.apply(t0)) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg2);
		for (T1 t1: sortedComp0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_limit_flatMap_limit_toList(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			for (T1 t1 : arg1.apply(t0)) {
				limit1++;
				if(limit1 > arg2) {
					break;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_limit_flatMap_skip_toList(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			for (T1 t1 : arg1.apply(t0)) {
				skip0++;
				if(skip0 <= arg2) {
					continue;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_limit_flatMap_distinct_toList(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T1> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			for (T1 t1 : arg1.apply(t0)) {
				if(!distinct0.add(t1)) {
					continue;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_limit_flatMap_dropWhile_toList(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, Predicate<T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			for (T1 t1 : arg1.apply(t0)) {
				if(dropWhile0 && arg2.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_limit_flatMap_takeWhile_toList(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, Predicate<T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			for (T1 t1 : arg1.apply(t0)) {
				if(!arg2.test(t1)) {
					break;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_limit_flatMap_flatMap_toList(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, Function<T1, Collection<T2>> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			limit0++;
			if(limit0 > arg0) {
				break;
			}
			for (T1 t1 : arg1.apply(t0)) {
				for (T2 t2 : arg2.apply(t1)) {
					result.add(t2);
				}
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_skip_map_map_toList(Collection<T0> input, long arg0, Function<T0, T1> arg1, Function<T1, T2> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_skip_map_filter_toList(Collection<T0> input, long arg0, Function<T0, T1> arg1, Predicate<T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_skip_map_sorted_toList(Collection<T0> input, long arg0, Function<T0, T1> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_skip_map_sortedComp_toList(Collection<T0> input, long arg0, Function<T0, T1> arg1, Comparator<? super T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg2);
		for (T1 t1: sortedComp0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_skip_map_limit_toList(Collection<T0> input, long arg0, Function<T0, T1> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_skip_map_skip_toList(Collection<T0> input, long arg0, Function<T0, T1> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			skip1++;
			if(skip1 <= arg2) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_skip_map_distinct_toList(Collection<T0> input, long arg0, Function<T0, T1> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T1> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_skip_map_dropWhile_toList(Collection<T0> input, long arg0, Function<T0, T1> arg1, Predicate<T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_skip_map_takeWhile_toList(Collection<T0> input, long arg0, Function<T0, T1> arg1, Predicate<T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			if(!arg2.test(t1)) {
				break;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_skip_map_flatMap_toList(Collection<T0> input, long arg0, Function<T0, T1> arg1, Function<T1, Collection<T2>> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			for (T2 t2 : arg2.apply(t1)) {
				result.add(t2);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_skip_filter_map_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, Function<T0, T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_filter_filter_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_filter_sorted_toList(Collection<T0> input, long arg0, Predicate<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_filter_sortedComp_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, Comparator<? super T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_filter_limit_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_filter_skip_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_filter_distinct_toList(Collection<T0> input, long arg0, Predicate<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_filter_dropWhile_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_filter_takeWhile_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_skip_filter_flatMap_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, Function<T0, Collection<T1>> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_skip_mapToInt_mapToObj_toList(Collection<T0> input, long arg0, ToIntFunction<T0> arg1, IntFunction<T2> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Integer> stream_skip_mapToInt_boxed_toList(Collection<T0> input, long arg0, ToIntFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<Integer> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			Integer t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_skip_mapToLong_mapToObj_toList(Collection<T0> input, long arg0, ToLongFunction<T0> arg1, LongFunction<T2> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Long> stream_skip_mapToLong_boxed_toList(Collection<T0> input, long arg0, ToLongFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<Long> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			Long t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_skip_mapToDouble_mapToObj_toList(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1, DoubleFunction<T2> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Double> stream_skip_mapToDouble_boxed_toList(Collection<T0> input, long arg0, ToDoubleFunction<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<Double> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			Double t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_skip_sorted_map_toList(Collection<T0> input, long arg0, Function<T0, T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_sorted_filter_toList(Collection<T0> input, long arg0, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if (!arg2.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_sorted_sorted_toList(Collection<T0> input, long arg0) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			sorted1.add(t0);
		}
		Collections.sort((List) sorted1);
		for (T0 t0: sorted1) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_sorted_sortedComp_toList(Collection<T0> input, long arg0, Comparator<? super T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_sorted_limit_toList(Collection<T0> input, long arg0, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_sorted_skip_toList(Collection<T0> input, long arg0, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			skip1++;
			if(skip1 <= arg2) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_sorted_distinct_toList(Collection<T0> input, long arg0) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_sorted_dropWhile_toList(Collection<T0> input, long arg0, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_sorted_takeWhile_toList(Collection<T0> input, long arg0, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(!arg2.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_skip_sorted_flatMap_toList(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_skip_sortedComp_map_toList(Collection<T0> input, long arg0, Comparator<? super T0> arg1, Function<T0, T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_sortedComp_filter_toList(Collection<T0> input, long arg0, Comparator<? super T0> arg1, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_sortedComp_sorted_toList(Collection<T0> input, long arg0, Comparator<? super T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_sortedComp_sortedComp_toList(Collection<T0> input, long arg0, Comparator<? super T0> arg1, Comparator<? super T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_sortedComp_limit_toList(Collection<T0> input, long arg0, Comparator<? super T0> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_sortedComp_skip_toList(Collection<T0> input, long arg0, Comparator<? super T0> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_sortedComp_distinct_toList(Collection<T0> input, long arg0, Comparator<? super T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_sortedComp_dropWhile_toList(Collection<T0> input, long arg0, Comparator<? super T0> arg1, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_sortedComp_takeWhile_toList(Collection<T0> input, long arg0, Comparator<? super T0> arg1, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_skip_sortedComp_flatMap_toList(Collection<T0> input, long arg0, Comparator<? super T0> arg1, Function<T0, Collection<T1>> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_skip_limit_map_toList(Collection<T0> input, long arg0, long arg1, Function<T0, T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_limit_filter_toList(Collection<T0> input, long arg0, long arg1, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_limit_sorted_toList(Collection<T0> input, long arg0, long arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_limit_sortedComp_toList(Collection<T0> input, long arg0, long arg1, Comparator<? super T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_limit_limit_toList(Collection<T0> input, long arg0, long arg1, long arg2) {
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
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			limit1++;
			if(limit1 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_limit_skip_toList(Collection<T0> input, long arg0, long arg1, long arg2) {
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
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			skip1++;
			if(skip1 <= arg2) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_limit_distinct_toList(Collection<T0> input, long arg0, long arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_limit_dropWhile_toList(Collection<T0> input, long arg0, long arg1, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_limit_takeWhile_toList(Collection<T0> input, long arg0, long arg1, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			if(!arg2.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_skip_limit_flatMap_toList(Collection<T0> input, long arg0, long arg1, Function<T0, Collection<T1>> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_skip_skip_map_toList(Collection<T0> input, long arg0, long arg1, Function<T0, T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			skip1++;
			if(skip1 <= arg1) {
				continue;
			}
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_skip_filter_toList(Collection<T0> input, long arg0, long arg1, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_skip_sorted_toList(Collection<T0> input, long arg0, long arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_skip_sortedComp_toList(Collection<T0> input, long arg0, long arg1, Comparator<? super T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_skip_limit_toList(Collection<T0> input, long arg0, long arg1, long arg2) {
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
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			skip1++;
			if(skip1 <= arg1) {
				continue;
			}
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_skip_skip_toList(Collection<T0> input, long arg0, long arg1, long arg2) {
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
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_skip_distinct_toList(Collection<T0> input, long arg0, long arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_skip_dropWhile_toList(Collection<T0> input, long arg0, long arg1, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_skip_takeWhile_toList(Collection<T0> input, long arg0, long arg1, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_skip_skip_flatMap_toList(Collection<T0> input, long arg0, long arg1, Function<T0, Collection<T1>> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			skip1++;
			if(skip1 <= arg1) {
				continue;
			}
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_skip_distinct_map_toList(Collection<T0> input, long arg0, Function<T0, T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_distinct_filter_toList(Collection<T0> input, long arg0, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_distinct_sorted_toList(Collection<T0> input, long arg0) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_distinct_sortedComp_toList(Collection<T0> input, long arg0, Comparator<? super T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_distinct_limit_toList(Collection<T0> input, long arg0, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_distinct_skip_toList(Collection<T0> input, long arg0, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			skip1++;
			if(skip1 <= arg2) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_distinct_distinct_toList(Collection<T0> input, long arg0) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		Set<T0> distinct1 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_distinct_dropWhile_toList(Collection<T0> input, long arg0, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_distinct_takeWhile_toList(Collection<T0> input, long arg0, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!arg2.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_skip_distinct_flatMap_toList(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_skip_dropWhile_map_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, Function<T0, T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_dropWhile_filter_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_dropWhile_sorted_toList(Collection<T0> input, long arg0, Predicate<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_dropWhile_sortedComp_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, Comparator<? super T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_dropWhile_limit_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_dropWhile_skip_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_dropWhile_distinct_toList(Collection<T0> input, long arg0, Predicate<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_dropWhile_dropWhile_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_dropWhile_takeWhile_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_skip_dropWhile_flatMap_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, Function<T0, Collection<T1>> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_skip_takeWhile_map_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, Function<T0, T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_takeWhile_filter_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_takeWhile_sorted_toList(Collection<T0> input, long arg0, Predicate<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_takeWhile_sortedComp_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, Comparator<? super T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_takeWhile_limit_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_takeWhile_skip_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_takeWhile_distinct_toList(Collection<T0> input, long arg0, Predicate<T0> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_takeWhile_dropWhile_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_skip_takeWhile_takeWhile_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_skip_takeWhile_flatMap_toList(Collection<T0> input, long arg0, Predicate<T0> arg1, Function<T0, Collection<T1>> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_skip_flatMap_map_toList(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, Function<T1, T2> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				T2 t2 = arg2.apply(t1);
				result.add(t2);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_skip_flatMap_filter_toList(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, Predicate<T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				if (!arg2.test(t1)) {
					continue;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_skip_flatMap_sorted_toList(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				sorted0.add(t1);
			}
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_skip_flatMap_sortedComp_toList(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, Comparator<? super T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_skip_flatMap_limit_toList(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				limit0++;
				if(limit0 > arg2) {
					break;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_skip_flatMap_skip_toList(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, long arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				skip1++;
				if(skip1 <= arg2) {
					continue;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_skip_flatMap_distinct_toList(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T1> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				if(!distinct0.add(t1)) {
					continue;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_skip_flatMap_dropWhile_toList(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, Predicate<T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_skip_flatMap_takeWhile_toList(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, Predicate<T1> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				if(!arg2.test(t1)) {
					break;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_skip_flatMap_flatMap_toList(Collection<T0> input, long arg0, Function<T0, Collection<T1>> arg1, Function<T1, Collection<T2>> arg2) {
		if(arg0 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			skip0++;
			if(skip0 <= arg0) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				for (T2 t2 : arg2.apply(t1)) {
					result.add(t2);
				}
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_distinct_map_map_toList(Collection<T0> input, Function<T0, T1> arg1, Function<T1, T2> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_distinct_map_filter_toList(Collection<T0> input, Function<T0, T1> arg1, Predicate<T1> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_distinct_map_sorted_toList(Collection<T0> input, Function<T0, T1> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		List<T1> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_distinct_map_sortedComp_toList(Collection<T0> input, Function<T0, T1> arg1, Comparator<? super T1> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T1> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg2);
		for (T1 t1: sortedComp0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_distinct_map_limit_toList(Collection<T0> input, Function<T0, T1> arg1, long arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_distinct_map_skip_toList(Collection<T0> input, Function<T0, T1> arg1, long arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_distinct_map_distinct_toList(Collection<T0> input, Function<T0, T1> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		Set<T1> distinct1 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			if(!distinct1.add(t1)) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_distinct_map_dropWhile_toList(Collection<T0> input, Function<T0, T1> arg1, Predicate<T1> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_distinct_map_takeWhile_toList(Collection<T0> input, Function<T0, T1> arg1, Predicate<T1> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			if(!arg2.test(t1)) {
				break;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_distinct_map_flatMap_toList(Collection<T0> input, Function<T0, T1> arg1, Function<T1, Collection<T2>> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			T1 t1 = arg1.apply(t0);
			for (T2 t2 : arg2.apply(t1)) {
				result.add(t2);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_distinct_filter_map_toList(Collection<T0> input, Predicate<T0> arg1, Function<T0, T1> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_filter_filter_toList(Collection<T0> input, Predicate<T0> arg1, Predicate<T0> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
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
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_filter_sorted_toList(Collection<T0> input, Predicate<T0> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_filter_sortedComp_toList(Collection<T0> input, Predicate<T0> arg1, Comparator<? super T0> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_filter_limit_toList(Collection<T0> input, Predicate<T0> arg1, long arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_filter_skip_toList(Collection<T0> input, Predicate<T0> arg1, long arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_filter_distinct_toList(Collection<T0> input, Predicate<T0> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		Set<T0> distinct1 = new HashSet<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			if(!distinct1.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_filter_dropWhile_toList(Collection<T0> input, Predicate<T0> arg1, Predicate<T0> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_filter_takeWhile_toList(Collection<T0> input, Predicate<T0> arg1, Predicate<T0> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			if(!arg2.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_distinct_filter_flatMap_toList(Collection<T0> input, Predicate<T0> arg1, Function<T0, Collection<T1>> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_distinct_mapToInt_mapToObj_toList(Collection<T0> input, ToIntFunction<T0> arg1, IntFunction<T2> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Integer> stream_distinct_mapToInt_boxed_toList(Collection<T0> input, ToIntFunction<T0> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		List<Integer> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			int t1 = arg1.applyAsInt(t0);
			Integer t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_distinct_mapToLong_mapToObj_toList(Collection<T0> input, ToLongFunction<T0> arg1, LongFunction<T2> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Long> stream_distinct_mapToLong_boxed_toList(Collection<T0> input, ToLongFunction<T0> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		List<Long> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			long t1 = arg1.applyAsLong(t0);
			Long t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_distinct_mapToDouble_mapToObj_toList(Collection<T0> input, ToDoubleFunction<T0> arg1, DoubleFunction<T2> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Double> stream_distinct_mapToDouble_boxed_toList(Collection<T0> input, ToDoubleFunction<T0> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		List<Double> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			double t1 = arg1.applyAsDouble(t0);
			Double t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_distinct_sorted_map_toList(Collection<T0> input, Function<T0, T1> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_sorted_filter_toList(Collection<T0> input, Predicate<T0> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if (!arg2.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_sorted_sorted_toList(Collection<T0> input) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			sorted1.add(t0);
		}
		Collections.sort((List) sorted1);
		for (T0 t0: sorted1) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_sorted_sortedComp_toList(Collection<T0> input, Comparator<? super T0> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_sorted_limit_toList(Collection<T0> input, long arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sorted0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_sorted_skip_toList(Collection<T0> input, long arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sorted0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_sorted_distinct_toList(Collection<T0> input) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sorted0 = new ArrayList<>();
		Set<T0> distinct1 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(!distinct1.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_sorted_dropWhile_toList(Collection<T0> input, Predicate<T0> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_sorted_takeWhile_toList(Collection<T0> input, Predicate<T0> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(!arg2.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_distinct_sorted_flatMap_toList(Collection<T0> input, Function<T0, Collection<T1>> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_distinct_sortedComp_map_toList(Collection<T0> input, Comparator<? super T0> arg1, Function<T0, T1> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_sortedComp_filter_toList(Collection<T0> input, Comparator<? super T0> arg1, Predicate<T0> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			if (!arg2.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_sortedComp_sorted_toList(Collection<T0> input, Comparator<? super T0> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_sortedComp_sortedComp_toList(Collection<T0> input, Comparator<? super T0> arg1, Comparator<? super T0> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_sortedComp_limit_toList(Collection<T0> input, Comparator<? super T0> arg1, long arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_sortedComp_skip_toList(Collection<T0> input, Comparator<? super T0> arg1, long arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_sortedComp_distinct_toList(Collection<T0> input, Comparator<? super T0> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T0> distinct1 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			if(!distinct1.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_sortedComp_dropWhile_toList(Collection<T0> input, Comparator<? super T0> arg1, Predicate<T0> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_sortedComp_takeWhile_toList(Collection<T0> input, Comparator<? super T0> arg1, Predicate<T0> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			if(!arg2.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_distinct_sortedComp_flatMap_toList(Collection<T0> input, Comparator<? super T0> arg1, Function<T0, Collection<T1>> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_distinct_limit_map_toList(Collection<T0> input, long arg1, Function<T0, T1> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_limit_filter_toList(Collection<T0> input, long arg1, Predicate<T0> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_limit_sorted_toList(Collection<T0> input, long arg1) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_limit_sortedComp_toList(Collection<T0> input, long arg1, Comparator<? super T0> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_limit_limit_toList(Collection<T0> input, long arg1, long arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			limit1++;
			if(limit1 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_limit_skip_toList(Collection<T0> input, long arg1, long arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_limit_distinct_toList(Collection<T0> input, long arg1) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T0> distinct1 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			if(!distinct1.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_limit_dropWhile_toList(Collection<T0> input, long arg1, Predicate<T0> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_limit_takeWhile_toList(Collection<T0> input, long arg1, Predicate<T0> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			if(!arg2.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_distinct_limit_flatMap_toList(Collection<T0> input, long arg1, Function<T0, Collection<T1>> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_distinct_skip_map_toList(Collection<T0> input, long arg1, Function<T0, T1> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_skip_filter_toList(Collection<T0> input, long arg1, Predicate<T0> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_skip_sorted_toList(Collection<T0> input, long arg1) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_skip_sortedComp_toList(Collection<T0> input, long arg1, Comparator<? super T0> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_skip_limit_toList(Collection<T0> input, long arg1, long arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_skip_skip_toList(Collection<T0> input, long arg1, long arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_skip_distinct_toList(Collection<T0> input, long arg1) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T0> distinct1 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if(!distinct1.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_skip_dropWhile_toList(Collection<T0> input, long arg1, Predicate<T0> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_skip_takeWhile_toList(Collection<T0> input, long arg1, Predicate<T0> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			if(!arg2.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_distinct_skip_flatMap_toList(Collection<T0> input, long arg1, Function<T0, Collection<T1>> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_distinct_distinct_map_toList(Collection<T0> input, Function<T0, T1> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		Set<T0> distinct1 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!distinct1.add(t0)) {
				continue;
			}
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_distinct_filter_toList(Collection<T0> input, Predicate<T0> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		Set<T0> distinct1 = new HashSet<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!distinct1.add(t0)) {
				continue;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_distinct_sorted_toList(Collection<T0> input) {
		Set<T0> distinct0 = new HashSet<>();
		Set<T0> distinct1 = new HashSet<>();
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!distinct1.add(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_distinct_sortedComp_toList(Collection<T0> input, Comparator<? super T0> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		Set<T0> distinct1 = new HashSet<>();
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!distinct1.add(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_distinct_limit_toList(Collection<T0> input, long arg2) {
		Set<T0> distinct0 = new HashSet<>();
		Set<T0> distinct1 = new HashSet<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!distinct1.add(t0)) {
				continue;
			}
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_distinct_skip_toList(Collection<T0> input, long arg2) {
		Set<T0> distinct0 = new HashSet<>();
		Set<T0> distinct1 = new HashSet<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!distinct1.add(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_distinct_distinct_toList(Collection<T0> input) {
		Set<T0> distinct0 = new HashSet<>();
		Set<T0> distinct1 = new HashSet<>();
		Set<T0> distinct2 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!distinct1.add(t0)) {
				continue;
			}
			if(!distinct2.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_distinct_dropWhile_toList(Collection<T0> input, Predicate<T0> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		Set<T0> distinct1 = new HashSet<>();
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!distinct1.add(t0)) {
				continue;
			}
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_distinct_takeWhile_toList(Collection<T0> input, Predicate<T0> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		Set<T0> distinct1 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!distinct1.add(t0)) {
				continue;
			}
			if(!arg2.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_distinct_distinct_flatMap_toList(Collection<T0> input, Function<T0, Collection<T1>> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		Set<T0> distinct1 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!distinct1.add(t0)) {
				continue;
			}
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_distinct_dropWhile_map_toList(Collection<T0> input, Predicate<T0> arg1, Function<T0, T1> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_dropWhile_filter_toList(Collection<T0> input, Predicate<T0> arg1, Predicate<T0> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_dropWhile_sorted_toList(Collection<T0> input, Predicate<T0> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_dropWhile_sortedComp_toList(Collection<T0> input, Predicate<T0> arg1, Comparator<? super T0> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_dropWhile_limit_toList(Collection<T0> input, Predicate<T0> arg1, long arg2) {
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_dropWhile_skip_toList(Collection<T0> input, Predicate<T0> arg1, long arg2) {
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_dropWhile_distinct_toList(Collection<T0> input, Predicate<T0> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		Set<T0> distinct1 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!distinct1.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_dropWhile_dropWhile_toList(Collection<T0> input, Predicate<T0> arg1, Predicate<T0> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_dropWhile_takeWhile_toList(Collection<T0> input, Predicate<T0> arg1, Predicate<T0> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_distinct_dropWhile_flatMap_toList(Collection<T0> input, Predicate<T0> arg1, Function<T0, Collection<T1>> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_distinct_takeWhile_map_toList(Collection<T0> input, Predicate<T0> arg1, Function<T0, T1> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_takeWhile_filter_toList(Collection<T0> input, Predicate<T0> arg1, Predicate<T0> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_takeWhile_sorted_toList(Collection<T0> input, Predicate<T0> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_takeWhile_sortedComp_toList(Collection<T0> input, Predicate<T0> arg1, Comparator<? super T0> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_takeWhile_limit_toList(Collection<T0> input, Predicate<T0> arg1, long arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_takeWhile_skip_toList(Collection<T0> input, Predicate<T0> arg1, long arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_takeWhile_distinct_toList(Collection<T0> input, Predicate<T0> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		Set<T0> distinct1 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			if(!distinct1.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_takeWhile_dropWhile_toList(Collection<T0> input, Predicate<T0> arg1, Predicate<T0> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_distinct_takeWhile_takeWhile_toList(Collection<T0> input, Predicate<T0> arg1, Predicate<T0> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			if(!arg2.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_distinct_takeWhile_flatMap_toList(Collection<T0> input, Predicate<T0> arg1, Function<T0, Collection<T1>> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!arg1.test(t0)) {
				break;
			}
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_distinct_flatMap_map_toList(Collection<T0> input, Function<T0, Collection<T1>> arg1, Function<T1, T2> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				T2 t2 = arg2.apply(t1);
				result.add(t2);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_distinct_flatMap_filter_toList(Collection<T0> input, Function<T0, Collection<T1>> arg1, Predicate<T1> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				if (!arg2.test(t1)) {
					continue;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_distinct_flatMap_sorted_toList(Collection<T0> input, Function<T0, Collection<T1>> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		List<T1> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				sorted0.add(t1);
			}
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_distinct_flatMap_sortedComp_toList(Collection<T0> input, Function<T0, Collection<T1>> arg1, Comparator<? super T1> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T1> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg2);
		for (T1 t1: sortedComp0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_distinct_flatMap_limit_toList(Collection<T0> input, Function<T0, Collection<T1>> arg1, long arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				limit0++;
				if(limit0 > arg2) {
					break;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_distinct_flatMap_skip_toList(Collection<T0> input, Function<T0, Collection<T1>> arg1, long arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				skip0++;
				if(skip0 <= arg2) {
					continue;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_distinct_flatMap_distinct_toList(Collection<T0> input, Function<T0, Collection<T1>> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		Set<T1> distinct1 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				if(!distinct1.add(t1)) {
					continue;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_distinct_flatMap_dropWhile_toList(Collection<T0> input, Function<T0, Collection<T1>> arg1, Predicate<T1> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				if(dropWhile0 && arg2.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_distinct_flatMap_takeWhile_toList(Collection<T0> input, Function<T0, Collection<T1>> arg1, Predicate<T1> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				if(!arg2.test(t1)) {
					break;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_distinct_flatMap_flatMap_toList(Collection<T0> input, Function<T0, Collection<T1>> arg1, Function<T1, Collection<T2>> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : arg1.apply(t0)) {
				for (T2 t2 : arg2.apply(t1)) {
					result.add(t2);
				}
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_dropWhile_map_map_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Function<T1, T2> arg2) {
		boolean dropWhile0 = true;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			T1 t1 = arg1.apply(t0);
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_dropWhile_map_filter_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Predicate<T1> arg2) {
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			T1 t1 = arg1.apply(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_dropWhile_map_sorted_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1) {
		boolean dropWhile0 = true;
		List<T1> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			T1 t1 = arg1.apply(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_dropWhile_map_sortedComp_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Comparator<? super T1> arg2) {
		boolean dropWhile0 = true;
		List<T1> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_dropWhile_map_limit_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, long arg2) {
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			T1 t1 = arg1.apply(t0);
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_dropWhile_map_skip_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, long arg2) {
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_dropWhile_map_distinct_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1) {
		boolean dropWhile0 = true;
		Set<T1> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			T1 t1 = arg1.apply(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_dropWhile_map_dropWhile_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Predicate<T1> arg2) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_dropWhile_map_takeWhile_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Predicate<T1> arg2) {
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			T1 t1 = arg1.apply(t0);
			if(!arg2.test(t1)) {
				break;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_dropWhile_map_flatMap_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Function<T1, Collection<T2>> arg2) {
		boolean dropWhile0 = true;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			T1 t1 = arg1.apply(t0);
			for (T2 t2 : arg2.apply(t1)) {
				result.add(t2);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_dropWhile_filter_map_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Function<T0, T1> arg2) {
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_filter_filter_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_filter_sorted_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1) {
		boolean dropWhile0 = true;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_filter_sortedComp_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Comparator<? super T0> arg2) {
		boolean dropWhile0 = true;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_filter_limit_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, long arg2) {
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_filter_skip_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, long arg2) {
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_filter_distinct_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1) {
		boolean dropWhile0 = true;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_filter_dropWhile_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_filter_takeWhile_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_dropWhile_filter_flatMap_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Function<T0, Collection<T1>> arg2) {
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_dropWhile_mapToInt_mapToObj_toList(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1, IntFunction<T2> arg2) {
		boolean dropWhile0 = true;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			int t1 = arg1.applyAsInt(t0);
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Integer> stream_dropWhile_mapToInt_boxed_toList(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1) {
		boolean dropWhile0 = true;
		List<Integer> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			int t1 = arg1.applyAsInt(t0);
			Integer t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_dropWhile_mapToLong_mapToObj_toList(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1, LongFunction<T2> arg2) {
		boolean dropWhile0 = true;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			long t1 = arg1.applyAsLong(t0);
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Long> stream_dropWhile_mapToLong_boxed_toList(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1) {
		boolean dropWhile0 = true;
		List<Long> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			long t1 = arg1.applyAsLong(t0);
			Long t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_dropWhile_mapToDouble_mapToObj_toList(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1, DoubleFunction<T2> arg2) {
		boolean dropWhile0 = true;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			double t1 = arg1.applyAsDouble(t0);
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Double> stream_dropWhile_mapToDouble_boxed_toList(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1) {
		boolean dropWhile0 = true;
		List<Double> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			double t1 = arg1.applyAsDouble(t0);
			Double t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_dropWhile_sorted_map_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg2) {
		boolean dropWhile0 = true;
		List<T0> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_sorted_filter_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg2) {
		boolean dropWhile0 = true;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if (!arg2.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_sorted_sorted_toList(Collection<T0> input, Predicate<T0> arg0) {
		boolean dropWhile0 = true;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			sorted1.add(t0);
		}
		Collections.sort((List) sorted1);
		for (T0 t0: sorted1) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_sorted_sortedComp_toList(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg2) {
		boolean dropWhile0 = true;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_sorted_limit_toList(Collection<T0> input, Predicate<T0> arg0, long arg2) {
		boolean dropWhile0 = true;
		List<T0> sorted0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_sorted_skip_toList(Collection<T0> input, Predicate<T0> arg0, long arg2) {
		boolean dropWhile0 = true;
		List<T0> sorted0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_sorted_distinct_toList(Collection<T0> input, Predicate<T0> arg0) {
		boolean dropWhile0 = true;
		List<T0> sorted0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_sorted_dropWhile_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg2) {
		boolean dropWhile0 = true;
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile1 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(dropWhile1 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile1 = false;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_sorted_takeWhile_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg2) {
		boolean dropWhile0 = true;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(!arg2.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_dropWhile_sorted_flatMap_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg2) {
		boolean dropWhile0 = true;
		List<T0> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_dropWhile_sortedComp_map_toList(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Function<T0, T1> arg2) {
		boolean dropWhile0 = true;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_sortedComp_filter_toList(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Predicate<T0> arg2) {
		boolean dropWhile0 = true;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_sortedComp_sorted_toList(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1) {
		boolean dropWhile0 = true;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_sortedComp_sortedComp_toList(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Comparator<? super T0> arg2) {
		boolean dropWhile0 = true;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_sortedComp_limit_toList(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, long arg2) {
		boolean dropWhile0 = true;
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_sortedComp_skip_toList(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, long arg2) {
		boolean dropWhile0 = true;
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_sortedComp_distinct_toList(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1) {
		boolean dropWhile0 = true;
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_sortedComp_dropWhile_toList(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Predicate<T0> arg2) {
		boolean dropWhile0 = true;
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile1 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_sortedComp_takeWhile_toList(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Predicate<T0> arg2) {
		boolean dropWhile0 = true;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_dropWhile_sortedComp_flatMap_toList(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Function<T0, Collection<T1>> arg2) {
		boolean dropWhile0 = true;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_dropWhile_limit_map_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, Function<T0, T1> arg2) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_limit_filter_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, Predicate<T0> arg2) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_limit_sorted_toList(Collection<T0> input, Predicate<T0> arg0, long arg1) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_limit_sortedComp_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, Comparator<? super T0> arg2) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_limit_limit_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, long arg2) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			limit1++;
			if(limit1 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_limit_skip_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, long arg2) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_limit_distinct_toList(Collection<T0> input, Predicate<T0> arg0, long arg1) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_limit_dropWhile_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, Predicate<T0> arg2) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile1 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			if(dropWhile1 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile1 = false;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_limit_takeWhile_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, Predicate<T0> arg2) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			if(!arg2.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_dropWhile_limit_flatMap_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, Function<T0, Collection<T1>> arg2) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_dropWhile_skip_map_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, Function<T0, T1> arg2) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_skip_filter_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, Predicate<T0> arg2) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_skip_sorted_toList(Collection<T0> input, Predicate<T0> arg0, long arg1) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_skip_sortedComp_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, Comparator<? super T0> arg2) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_skip_limit_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, long arg2) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_skip_skip_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, long arg2) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_skip_distinct_toList(Collection<T0> input, Predicate<T0> arg0, long arg1) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_skip_dropWhile_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, Predicate<T0> arg2) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile1 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_skip_takeWhile_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, Predicate<T0> arg2) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_dropWhile_skip_flatMap_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, Function<T0, Collection<T1>> arg2) {
		boolean dropWhile0 = true;
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_dropWhile_distinct_map_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg2) {
		boolean dropWhile0 = true;
		Set<T0> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_distinct_filter_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg2) {
		boolean dropWhile0 = true;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_distinct_sorted_toList(Collection<T0> input, Predicate<T0> arg0) {
		boolean dropWhile0 = true;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_distinct_sortedComp_toList(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg2) {
		boolean dropWhile0 = true;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_distinct_limit_toList(Collection<T0> input, Predicate<T0> arg0, long arg2) {
		boolean dropWhile0 = true;
		Set<T0> distinct0 = new HashSet<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_distinct_skip_toList(Collection<T0> input, Predicate<T0> arg0, long arg2) {
		boolean dropWhile0 = true;
		Set<T0> distinct0 = new HashSet<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_distinct_distinct_toList(Collection<T0> input, Predicate<T0> arg0) {
		boolean dropWhile0 = true;
		Set<T0> distinct0 = new HashSet<>();
		Set<T0> distinct1 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_distinct_dropWhile_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg2) {
		boolean dropWhile0 = true;
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile1 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			if(dropWhile1 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile1 = false;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_distinct_takeWhile_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg2) {
		boolean dropWhile0 = true;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!arg2.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_dropWhile_distinct_flatMap_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg2) {
		boolean dropWhile0 = true;
		Set<T0> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_dropWhile_dropWhile_map_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Function<T0, T1> arg2) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_dropWhile_filter_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_dropWhile_sorted_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_dropWhile_sortedComp_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Comparator<? super T0> arg2) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_dropWhile_limit_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, long arg2) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_dropWhile_skip_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, long arg2) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_dropWhile_distinct_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_dropWhile_dropWhile_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		boolean dropWhile2 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_dropWhile_takeWhile_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_dropWhile_dropWhile_flatMap_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Function<T0, Collection<T1>> arg2) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_dropWhile_takeWhile_map_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Function<T0, T1> arg2) {
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!arg1.test(t0)) {
				break;
			}
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_takeWhile_filter_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_takeWhile_sorted_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1) {
		boolean dropWhile0 = true;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_takeWhile_sortedComp_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Comparator<? super T0> arg2) {
		boolean dropWhile0 = true;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_takeWhile_limit_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, long arg2) {
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!arg1.test(t0)) {
				break;
			}
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_takeWhile_skip_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, long arg2) {
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_takeWhile_distinct_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1) {
		boolean dropWhile0 = true;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_takeWhile_dropWhile_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_dropWhile_takeWhile_takeWhile_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_dropWhile_takeWhile_flatMap_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Function<T0, Collection<T1>> arg2) {
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			if(!arg1.test(t0)) {
				break;
			}
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_dropWhile_flatMap_map_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Function<T1, T2> arg2) {
		boolean dropWhile0 = true;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : arg1.apply(t0)) {
				T2 t2 = arg2.apply(t1);
				result.add(t2);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_dropWhile_flatMap_filter_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Predicate<T1> arg2) {
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : arg1.apply(t0)) {
				if (!arg2.test(t1)) {
					continue;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_dropWhile_flatMap_sorted_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1) {
		boolean dropWhile0 = true;
		List<T1> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : arg1.apply(t0)) {
				sorted0.add(t1);
			}
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_dropWhile_flatMap_sortedComp_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Comparator<? super T1> arg2) {
		boolean dropWhile0 = true;
		List<T1> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_dropWhile_flatMap_limit_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, long arg2) {
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : arg1.apply(t0)) {
				limit0++;
				if(limit0 > arg2) {
					break;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_dropWhile_flatMap_skip_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, long arg2) {
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_dropWhile_flatMap_distinct_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1) {
		boolean dropWhile0 = true;
		Set<T1> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : arg1.apply(t0)) {
				if(!distinct0.add(t1)) {
					continue;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_dropWhile_flatMap_dropWhile_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Predicate<T1> arg2) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_dropWhile_flatMap_takeWhile_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Predicate<T1> arg2) {
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : arg1.apply(t0)) {
				if(!arg2.test(t1)) {
					break;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_dropWhile_flatMap_flatMap_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Function<T1, Collection<T2>> arg2) {
		boolean dropWhile0 = true;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(dropWhile0 && arg0.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : arg1.apply(t0)) {
				for (T2 t2 : arg2.apply(t1)) {
					result.add(t2);
				}
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_takeWhile_map_map_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Function<T1, T2> arg2) {
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			T1 t1 = arg1.apply(t0);
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_takeWhile_map_filter_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Predicate<T1> arg2) {
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			T1 t1 = arg1.apply(t0);
			if (!arg2.test(t1)) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_takeWhile_map_sorted_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1) {
		List<T1> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			T1 t1 = arg1.apply(t0);
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_takeWhile_map_sortedComp_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Comparator<? super T1> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			T1 t1 = arg1.apply(t0);
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg2);
		for (T1 t1: sortedComp0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_takeWhile_map_limit_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			T1 t1 = arg1.apply(t0);
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_takeWhile_map_skip_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			T1 t1 = arg1.apply(t0);
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_takeWhile_map_distinct_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1) {
		Set<T1> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			T1 t1 = arg1.apply(t0);
			if(!distinct0.add(t1)) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_takeWhile_map_dropWhile_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Predicate<T1> arg2) {
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			T1 t1 = arg1.apply(t0);
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_takeWhile_map_takeWhile_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Predicate<T1> arg2) {
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			T1 t1 = arg1.apply(t0);
			if(!arg2.test(t1)) {
				break;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_takeWhile_map_flatMap_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg1, Function<T1, Collection<T2>> arg2) {
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			T1 t1 = arg1.apply(t0);
			for (T2 t2 : arg2.apply(t1)) {
				result.add(t2);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_takeWhile_filter_map_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Function<T0, T1> arg2) {
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_filter_filter_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_filter_sorted_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_filter_sortedComp_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Comparator<? super T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_filter_limit_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_filter_skip_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_filter_distinct_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_filter_dropWhile_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_filter_takeWhile_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			if(!arg2.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_takeWhile_filter_flatMap_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Function<T0, Collection<T1>> arg2) {
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			if (!arg1.test(t0)) {
				continue;
			}
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_takeWhile_mapToInt_mapToObj_toList(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1, IntFunction<T2> arg2) {
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			int t1 = arg1.applyAsInt(t0);
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Integer> stream_takeWhile_mapToInt_boxed_toList(Collection<T0> input, Predicate<T0> arg0, ToIntFunction<T0> arg1) {
		List<Integer> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			int t1 = arg1.applyAsInt(t0);
			Integer t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_takeWhile_mapToLong_mapToObj_toList(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1, LongFunction<T2> arg2) {
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			long t1 = arg1.applyAsLong(t0);
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Long> stream_takeWhile_mapToLong_boxed_toList(Collection<T0> input, Predicate<T0> arg0, ToLongFunction<T0> arg1) {
		List<Long> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			long t1 = arg1.applyAsLong(t0);
			Long t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T2> List<T2> stream_takeWhile_mapToDouble_mapToObj_toList(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1, DoubleFunction<T2> arg2) {
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			double t1 = arg1.applyAsDouble(t0);
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<Double> stream_takeWhile_mapToDouble_boxed_toList(Collection<T0> input, Predicate<T0> arg0, ToDoubleFunction<T0> arg1) {
		List<Double> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			double t1 = arg1.applyAsDouble(t0);
			Double t2 = t1;
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_takeWhile_sorted_map_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_sorted_filter_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if (!arg2.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_sorted_sorted_toList(Collection<T0> input, Predicate<T0> arg0) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sorted1 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			sorted1.add(t0);
		}
		Collections.sort((List) sorted1);
		for (T0 t0: sorted1) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_sorted_sortedComp_toList(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_sorted_limit_toList(Collection<T0> input, Predicate<T0> arg0, long arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_sorted_skip_toList(Collection<T0> input, Predicate<T0> arg0, long arg2) {
		List<T0> sorted0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_sorted_distinct_toList(Collection<T0> input, Predicate<T0> arg0) {
		List<T0> sorted0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(!distinct0.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_sorted_dropWhile_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_sorted_takeWhile_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			if(!arg2.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_takeWhile_sorted_flatMap_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg2) {
		List<T0> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_takeWhile_sortedComp_map_toList(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Function<T0, T1> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_sortedComp_filter_toList(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Predicate<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_sortedComp_sorted_toList(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_sortedComp_sortedComp_toList(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Comparator<? super T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> sortedComp1 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_sortedComp_limit_toList(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, long arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_sortedComp_skip_toList(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, long arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_sortedComp_distinct_toList(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1) {
		List<T0> sortedComp0 = new ArrayList<>();
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_sortedComp_dropWhile_toList(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Predicate<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_sortedComp_takeWhile_toList(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Predicate<T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_takeWhile_sortedComp_flatMap_toList(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg1, Function<T0, Collection<T1>> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg1);
		for (T0 t0: sortedComp0) {
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_takeWhile_limit_map_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, Function<T0, T1> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_limit_filter_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, Predicate<T0> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_limit_sorted_toList(Collection<T0> input, Predicate<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_limit_sortedComp_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, Comparator<? super T0> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_limit_limit_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, long arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			limit1++;
			if(limit1 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_limit_skip_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, long arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_limit_distinct_toList(Collection<T0> input, Predicate<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_limit_dropWhile_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, Predicate<T0> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_limit_takeWhile_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, Predicate<T0> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			if(!arg2.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_takeWhile_limit_flatMap_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, Function<T0, Collection<T1>> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			limit0++;
			if(limit0 > arg1) {
				break;
			}
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_takeWhile_skip_map_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, Function<T0, T1> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_skip_filter_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, Predicate<T0> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_skip_sorted_toList(Collection<T0> input, Predicate<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_skip_sortedComp_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, Comparator<? super T0> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_skip_limit_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, long arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_skip_skip_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, long arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_skip_distinct_toList(Collection<T0> input, Predicate<T0> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_skip_dropWhile_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, Predicate<T0> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_skip_takeWhile_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, Predicate<T0> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_takeWhile_skip_flatMap_toList(Collection<T0> input, Predicate<T0> arg0, long arg1, Function<T0, Collection<T1>> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			skip0++;
			if(skip0 <= arg1) {
				continue;
			}
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_takeWhile_distinct_map_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, T1> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_distinct_filter_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_distinct_sorted_toList(Collection<T0> input, Predicate<T0> arg0) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_distinct_sortedComp_toList(Collection<T0> input, Predicate<T0> arg0, Comparator<? super T0> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			sortedComp0.add(t0);
		}
		sortedComp0.sort(arg2);
		for (T0 t0: sortedComp0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_distinct_limit_toList(Collection<T0> input, Predicate<T0> arg0, long arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_distinct_skip_toList(Collection<T0> input, Predicate<T0> arg0, long arg2) {
		Set<T0> distinct0 = new HashSet<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_distinct_distinct_toList(Collection<T0> input, Predicate<T0> arg0) {
		Set<T0> distinct0 = new HashSet<>();
		Set<T0> distinct1 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!distinct1.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_distinct_dropWhile_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			if(dropWhile0 && arg2.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_distinct_takeWhile_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			if(!arg2.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_takeWhile_distinct_flatMap_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg2) {
		Set<T0> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_takeWhile_dropWhile_map_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Function<T0, T1> arg2) {
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_dropWhile_filter_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_dropWhile_sorted_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1) {
		boolean dropWhile0 = true;
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_dropWhile_sortedComp_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Comparator<? super T0> arg2) {
		boolean dropWhile0 = true;
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_dropWhile_limit_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, long arg2) {
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_dropWhile_skip_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, long arg2) {
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_dropWhile_distinct_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1) {
		boolean dropWhile0 = true;
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_dropWhile_dropWhile_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_dropWhile_takeWhile_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_takeWhile_dropWhile_flatMap_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Function<T0, Collection<T1>> arg2) {
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(dropWhile0 && arg1.test(t0)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_takeWhile_takeWhile_map_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Function<T0, T1> arg2) {
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!arg1.test(t0)) {
				break;
			}
			T1 t1 = arg2.apply(t0);
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_takeWhile_filter_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		List<T0> result = new ArrayList<>();
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!arg1.test(t0)) {
				break;
			}
			if (!arg2.test(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_takeWhile_sorted_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1) {
		List<T0> sorted0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!arg1.test(t0)) {
				break;
			}
			sorted0.add(t0);
		}
		Collections.sort((List) sorted0);
		for (T0 t0: sorted0) {
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_takeWhile_sortedComp_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Comparator<? super T0> arg2) {
		List<T0> sortedComp0 = new ArrayList<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_takeWhile_limit_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!arg1.test(t0)) {
				break;
			}
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_takeWhile_skip_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_takeWhile_distinct_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1) {
		Set<T0> distinct0 = new HashSet<>();
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!arg1.test(t0)) {
				break;
			}
			if(!distinct0.add(t0)) {
				continue;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_takeWhile_dropWhile_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		boolean dropWhile0 = true;
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0> List<T0> stream_takeWhile_takeWhile_takeWhile_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Predicate<T0> arg2) {
		List<T0> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!arg1.test(t0)) {
				break;
			}
			if(!arg2.test(t0)) {
				break;
			}
			result.add(t0);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_takeWhile_takeWhile_flatMap_toList(Collection<T0> input, Predicate<T0> arg0, Predicate<T0> arg1, Function<T0, Collection<T1>> arg2) {
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			if(!arg1.test(t0)) {
				break;
			}
			for (T1 t1 : arg2.apply(t0)) {
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_takeWhile_flatMap_map_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Function<T1, T2> arg2) {
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			for (T1 t1 : arg1.apply(t0)) {
				T2 t2 = arg2.apply(t1);
				result.add(t2);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_takeWhile_flatMap_filter_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Predicate<T1> arg2) {
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			for (T1 t1 : arg1.apply(t0)) {
				if (!arg2.test(t1)) {
					continue;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_takeWhile_flatMap_sorted_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1) {
		List<T1> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			for (T1 t1 : arg1.apply(t0)) {
				sorted0.add(t1);
			}
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_takeWhile_flatMap_sortedComp_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Comparator<? super T1> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			for (T1 t1 : arg1.apply(t0)) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg2);
		for (T1 t1: sortedComp0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_takeWhile_flatMap_limit_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			for (T1 t1 : arg1.apply(t0)) {
				limit0++;
				if(limit0 > arg2) {
					break;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_takeWhile_flatMap_skip_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			for (T1 t1 : arg1.apply(t0)) {
				skip0++;
				if(skip0 <= arg2) {
					continue;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_takeWhile_flatMap_distinct_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1) {
		Set<T1> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			for (T1 t1 : arg1.apply(t0)) {
				if(!distinct0.add(t1)) {
					continue;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_takeWhile_flatMap_dropWhile_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Predicate<T1> arg2) {
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			for (T1 t1 : arg1.apply(t0)) {
				if(dropWhile0 && arg2.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_takeWhile_flatMap_takeWhile_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Predicate<T1> arg2) {
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			for (T1 t1 : arg1.apply(t0)) {
				if(!arg2.test(t1)) {
					break;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_takeWhile_flatMap_flatMap_toList(Collection<T0> input, Predicate<T0> arg0, Function<T0, Collection<T1>> arg1, Function<T1, Collection<T2>> arg2) {
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			if(!arg0.test(t0)) {
				break;
			}
			for (T1 t1 : arg1.apply(t0)) {
				for (T2 t2 : arg2.apply(t1)) {
					result.add(t2);
				}
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2, T3> List<T3> stream_flatMap_map_map_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, T2> arg1, Function<T2, T3> arg2) {
		List<T3> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				T2 t2 = arg1.apply(t1);
				T3 t3 = arg2.apply(t2);
				result.add(t3);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_flatMap_map_filter_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, T2> arg1, Predicate<T2> arg2) {
		List<T2> result = new ArrayList<>();
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				T2 t2 = arg1.apply(t1);
				if (!arg2.test(t2)) {
					continue;
				}
				result.add(t2);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_flatMap_map_sorted_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, T2> arg1) {
		List<T2> sorted0 = new ArrayList<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				T2 t2 = arg1.apply(t1);
				sorted0.add(t2);
			}
		}
		Collections.sort((List) sorted0);
		for (T2 t2: sorted0) {
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_flatMap_map_sortedComp_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, T2> arg1, Comparator<? super T2> arg2) {
		List<T2> sortedComp0 = new ArrayList<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				T2 t2 = arg1.apply(t1);
				sortedComp0.add(t2);
			}
		}
		sortedComp0.sort(arg2);
		for (T2 t2: sortedComp0) {
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_flatMap_map_limit_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, T2> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				T2 t2 = arg1.apply(t1);
				limit0++;
				if(limit0 > arg2) {
					break;
				}
				result.add(t2);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_flatMap_map_skip_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, T2> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				T2 t2 = arg1.apply(t1);
				skip0++;
				if(skip0 <= arg2) {
					continue;
				}
				result.add(t2);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_flatMap_map_distinct_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, T2> arg1) {
		Set<T2> distinct0 = new HashSet<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				T2 t2 = arg1.apply(t1);
				if(!distinct0.add(t2)) {
					continue;
				}
				result.add(t2);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_flatMap_map_dropWhile_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, T2> arg1, Predicate<T2> arg2) {
		boolean dropWhile0 = true;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				T2 t2 = arg1.apply(t1);
				if(dropWhile0 && arg2.test(t2)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				result.add(t2);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_flatMap_map_takeWhile_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, T2> arg1, Predicate<T2> arg2) {
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				T2 t2 = arg1.apply(t1);
				if(!arg2.test(t2)) {
					break;
				}
				result.add(t2);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2, T3> List<T3> stream_flatMap_map_flatMap_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, T2> arg1, Function<T2, Collection<T3>> arg2) {
		List<T3> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				T2 t2 = arg1.apply(t1);
				for (T3 t3 : arg2.apply(t2)) {
					result.add(t3);
				}
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_flatMap_filter_map_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Function<T1, T2> arg2) {
		List<T2> result = new ArrayList<>();
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				if (!arg1.test(t1)) {
					continue;
				}
				T2 t2 = arg2.apply(t1);
				result.add(t2);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_filter_filter_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Predicate<T1> arg2) {
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				if (!arg1.test(t1)) {
					continue;
				}
				if (!arg2.test(t1)) {
					continue;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_filter_sorted_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1) {
		List<T1> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				if (!arg1.test(t1)) {
					continue;
				}
				sorted0.add(t1);
			}
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_filter_sortedComp_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Comparator<? super T1> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				if (!arg1.test(t1)) {
					continue;
				}
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg2);
		for (T1 t1: sortedComp0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_filter_limit_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				if (!arg1.test(t1)) {
					continue;
				}
				limit0++;
				if(limit0 > arg2) {
					break;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_filter_skip_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				if (!arg1.test(t1)) {
					continue;
				}
				skip0++;
				if(skip0 <= arg2) {
					continue;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_filter_distinct_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1) {
		Set<T1> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				if (!arg1.test(t1)) {
					continue;
				}
				if(!distinct0.add(t1)) {
					continue;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_filter_dropWhile_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Predicate<T1> arg2) {
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				if (!arg1.test(t1)) {
					continue;
				}
				if(dropWhile0 && arg2.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_filter_takeWhile_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Predicate<T1> arg2) {
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				if (!arg1.test(t1)) {
					continue;
				}
				if(!arg2.test(t1)) {
					break;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_flatMap_filter_flatMap_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Function<T1, Collection<T2>> arg2) {
		List<T2> result = new ArrayList<>();
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				if (!arg1.test(t1)) {
					continue;
				}
				for (T2 t2 : arg2.apply(t1)) {
					result.add(t2);
				}
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T3> List<T3> stream_flatMap_mapToInt_mapToObj_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToIntFunction<T1> arg1, IntFunction<T3> arg2) {
		List<T3> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				int t2 = arg1.applyAsInt(t1);
				T3 t3 = arg2.apply(t2);
				result.add(t3);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<Integer> stream_flatMap_mapToInt_boxed_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToIntFunction<T1> arg1) {
		List<Integer> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				int t2 = arg1.applyAsInt(t1);
				Integer t3 = t2;
				result.add(t3);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T3> List<T3> stream_flatMap_mapToLong_mapToObj_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToLongFunction<T1> arg1, LongFunction<T3> arg2) {
		List<T3> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				long t2 = arg1.applyAsLong(t1);
				T3 t3 = arg2.apply(t2);
				result.add(t3);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<Long> stream_flatMap_mapToLong_boxed_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToLongFunction<T1> arg1) {
		List<Long> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				long t2 = arg1.applyAsLong(t1);
				Long t3 = t2;
				result.add(t3);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T3> List<T3> stream_flatMap_mapToDouble_mapToObj_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToDoubleFunction<T1> arg1, DoubleFunction<T3> arg2) {
		List<T3> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				double t2 = arg1.applyAsDouble(t1);
				T3 t3 = arg2.apply(t2);
				result.add(t3);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<Double> stream_flatMap_mapToDouble_boxed_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, ToDoubleFunction<T1> arg1) {
		List<Double> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				double t2 = arg1.applyAsDouble(t1);
				Double t3 = t2;
				result.add(t3);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_flatMap_sorted_map_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, T2> arg2) {
		List<T1> sorted0 = new ArrayList<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				sorted0.add(t1);
			}
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_sorted_filter_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg2) {
		List<T1> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				sorted0.add(t1);
			}
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			if (!arg2.test(t1)) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_sorted_sorted_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0) {
		List<T1> sorted0 = new ArrayList<>();
		List<T1> sorted1 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				sorted0.add(t1);
			}
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			sorted1.add(t1);
		}
		Collections.sort((List) sorted1);
		for (T1 t1: sorted1) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_sorted_sortedComp_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Comparator<? super T1> arg2) {
		List<T1> sorted0 = new ArrayList<>();
		List<T1> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				sorted0.add(t1);
			}
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			sortedComp0.add(t1);
		}
		sortedComp0.sort(arg2);
		for (T1 t1: sortedComp0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_sorted_limit_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg2) {
		List<T1> sorted0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				sorted0.add(t1);
			}
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_sorted_skip_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg2) {
		List<T1> sorted0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				sorted0.add(t1);
			}
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			skip0++;
			if(skip0 <= arg2) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_sorted_distinct_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0) {
		List<T1> sorted0 = new ArrayList<>();
		Set<T1> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				sorted0.add(t1);
			}
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			if(!distinct0.add(t1)) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_sorted_dropWhile_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg2) {
		List<T1> sorted0 = new ArrayList<>();
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				sorted0.add(t1);
			}
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			if(dropWhile0 && arg2.test(t1)) {
				continue;
			} else {
				dropWhile0 = false;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_sorted_takeWhile_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg2) {
		List<T1> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				sorted0.add(t1);
			}
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			if(!arg2.test(t1)) {
				break;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_flatMap_sorted_flatMap_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, Collection<T2>> arg2) {
		List<T1> sorted0 = new ArrayList<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				sorted0.add(t1);
			}
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			for (T2 t2 : arg2.apply(t1)) {
				result.add(t2);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_flatMap_sortedComp_map_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Comparator<? super T1> arg1, Function<T1, T2> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			T2 t2 = arg2.apply(t1);
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_sortedComp_filter_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Comparator<? super T1> arg1, Predicate<T1> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			if (!arg2.test(t1)) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_sortedComp_sorted_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Comparator<? super T1> arg1) {
		List<T1> sortedComp0 = new ArrayList<>();
		List<T1> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			sorted0.add(t1);
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_sortedComp_sortedComp_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Comparator<? super T1> arg1, Comparator<? super T1> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		List<T1> sortedComp1 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_sortedComp_limit_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Comparator<? super T1> arg1, long arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			limit0++;
			if(limit0 > arg2) {
				break;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_sortedComp_skip_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Comparator<? super T1> arg1, long arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_sortedComp_distinct_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Comparator<? super T1> arg1) {
		List<T1> sortedComp0 = new ArrayList<>();
		Set<T1> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			if(!distinct0.add(t1)) {
				continue;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_sortedComp_dropWhile_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Comparator<? super T1> arg1, Predicate<T1> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_sortedComp_takeWhile_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Comparator<? super T1> arg1, Predicate<T1> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			if(!arg2.test(t1)) {
				break;
			}
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_flatMap_sortedComp_flatMap_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Comparator<? super T1> arg1, Function<T1, Collection<T2>> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg1);
		for (T1 t1: sortedComp0) {
			for (T2 t2 : arg2.apply(t1)) {
				result.add(t2);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_flatMap_limit_map_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, Function<T1, T2> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				limit0++;
				if(limit0 > arg1) {
					break;
				}
				T2 t2 = arg2.apply(t1);
				result.add(t2);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_limit_filter_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, Predicate<T1> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				limit0++;
				if(limit0 > arg1) {
					break;
				}
				if (!arg2.test(t1)) {
					continue;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_limit_sorted_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				limit0++;
				if(limit0 > arg1) {
					break;
				}
				sorted0.add(t1);
			}
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_limit_sortedComp_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, Comparator<? super T1> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				limit0++;
				if(limit0 > arg1) {
					break;
				}
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg2);
		for (T1 t1: sortedComp0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_limit_limit_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, long arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit1 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				limit0++;
				if(limit0 > arg1) {
					break;
				}
				limit1++;
				if(limit1 > arg2) {
					break;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_limit_skip_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, long arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				limit0++;
				if(limit0 > arg1) {
					break;
				}
				skip0++;
				if(skip0 <= arg2) {
					continue;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_limit_distinct_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		Set<T1> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				limit0++;
				if(limit0 > arg1) {
					break;
				}
				if(!distinct0.add(t1)) {
					continue;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_limit_dropWhile_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, Predicate<T1> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				limit0++;
				if(limit0 > arg1) {
					break;
				}
				if(dropWhile0 && arg2.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_limit_takeWhile_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, Predicate<T1> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				limit0++;
				if(limit0 > arg1) {
					break;
				}
				if(!arg2.test(t1)) {
					break;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_flatMap_limit_flatMap_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, Function<T1, Collection<T2>> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				limit0++;
				if(limit0 > arg1) {
					break;
				}
				for (T2 t2 : arg2.apply(t1)) {
					result.add(t2);
				}
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_flatMap_skip_map_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, Function<T1, T2> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				skip0++;
				if(skip0 <= arg1) {
					continue;
				}
				T2 t2 = arg2.apply(t1);
				result.add(t2);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_skip_filter_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, Predicate<T1> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				skip0++;
				if(skip0 <= arg1) {
					continue;
				}
				if (!arg2.test(t1)) {
					continue;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_skip_sorted_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				skip0++;
				if(skip0 <= arg1) {
					continue;
				}
				sorted0.add(t1);
			}
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_skip_sortedComp_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, Comparator<? super T1> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_skip_limit_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, long arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				skip0++;
				if(skip0 <= arg1) {
					continue;
				}
				limit0++;
				if(limit0 > arg2) {
					break;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_skip_skip_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, long arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip1 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				skip0++;
				if(skip0 <= arg1) {
					continue;
				}
				skip1++;
				if(skip1 <= arg2) {
					continue;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_skip_distinct_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		Set<T1> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				skip0++;
				if(skip0 <= arg1) {
					continue;
				}
				if(!distinct0.add(t1)) {
					continue;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_skip_dropWhile_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, Predicate<T1> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_skip_takeWhile_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, Predicate<T1> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				skip0++;
				if(skip0 <= arg1) {
					continue;
				}
				if(!arg2.test(t1)) {
					break;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_flatMap_skip_flatMap_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg1, Function<T1, Collection<T2>> arg2) {
		if(arg1 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				skip0++;
				if(skip0 <= arg1) {
					continue;
				}
				for (T2 t2 : arg2.apply(t1)) {
					result.add(t2);
				}
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_flatMap_distinct_map_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, T2> arg2) {
		Set<T1> distinct0 = new HashSet<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!distinct0.add(t1)) {
					continue;
				}
				T2 t2 = arg2.apply(t1);
				result.add(t2);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_distinct_filter_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg2) {
		Set<T1> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!distinct0.add(t1)) {
					continue;
				}
				if (!arg2.test(t1)) {
					continue;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_distinct_sorted_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0) {
		Set<T1> distinct0 = new HashSet<>();
		List<T1> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!distinct0.add(t1)) {
					continue;
				}
				sorted0.add(t1);
			}
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_distinct_sortedComp_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Comparator<? super T1> arg2) {
		Set<T1> distinct0 = new HashSet<>();
		List<T1> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!distinct0.add(t1)) {
					continue;
				}
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg2);
		for (T1 t1: sortedComp0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_distinct_limit_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg2) {
		Set<T1> distinct0 = new HashSet<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!distinct0.add(t1)) {
					continue;
				}
				limit0++;
				if(limit0 > arg2) {
					break;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_distinct_skip_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, long arg2) {
		Set<T1> distinct0 = new HashSet<>();
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!distinct0.add(t1)) {
					continue;
				}
				skip0++;
				if(skip0 <= arg2) {
					continue;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_distinct_distinct_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0) {
		Set<T1> distinct0 = new HashSet<>();
		Set<T1> distinct1 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!distinct0.add(t1)) {
					continue;
				}
				if(!distinct1.add(t1)) {
					continue;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_distinct_dropWhile_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg2) {
		Set<T1> distinct0 = new HashSet<>();
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!distinct0.add(t1)) {
					continue;
				}
				if(dropWhile0 && arg2.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_distinct_takeWhile_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg2) {
		Set<T1> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!distinct0.add(t1)) {
					continue;
				}
				if(!arg2.test(t1)) {
					break;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_flatMap_distinct_flatMap_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, Collection<T2>> arg2) {
		Set<T1> distinct0 = new HashSet<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!distinct0.add(t1)) {
					continue;
				}
				for (T2 t2 : arg2.apply(t1)) {
					result.add(t2);
				}
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_flatMap_dropWhile_map_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Function<T1, T2> arg2) {
		boolean dropWhile0 = true;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(dropWhile0 && arg1.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				T2 t2 = arg2.apply(t1);
				result.add(t2);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_dropWhile_filter_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Predicate<T1> arg2) {
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(dropWhile0 && arg1.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				if (!arg2.test(t1)) {
					continue;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_dropWhile_sorted_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1) {
		boolean dropWhile0 = true;
		List<T1> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(dropWhile0 && arg1.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				sorted0.add(t1);
			}
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_dropWhile_sortedComp_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Comparator<? super T1> arg2) {
		boolean dropWhile0 = true;
		List<T1> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_dropWhile_limit_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, long arg2) {
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(dropWhile0 && arg1.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				limit0++;
				if(limit0 > arg2) {
					break;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_dropWhile_skip_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, long arg2) {
		boolean dropWhile0 = true;
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_dropWhile_distinct_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1) {
		boolean dropWhile0 = true;
		Set<T1> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(dropWhile0 && arg1.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				if(!distinct0.add(t1)) {
					continue;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_dropWhile_dropWhile_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Predicate<T1> arg2) {
		boolean dropWhile0 = true;
		boolean dropWhile1 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
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
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_dropWhile_takeWhile_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Predicate<T1> arg2) {
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(dropWhile0 && arg1.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				if(!arg2.test(t1)) {
					break;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_flatMap_dropWhile_flatMap_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Function<T1, Collection<T2>> arg2) {
		boolean dropWhile0 = true;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(dropWhile0 && arg1.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				for (T2 t2 : arg2.apply(t1)) {
					result.add(t2);
				}
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_flatMap_takeWhile_map_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Function<T1, T2> arg2) {
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!arg1.test(t1)) {
					break;
				}
				T2 t2 = arg2.apply(t1);
				result.add(t2);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_takeWhile_filter_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Predicate<T1> arg2) {
		List<T1> result = new ArrayList<>();
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!arg1.test(t1)) {
					break;
				}
				if (!arg2.test(t1)) {
					continue;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_takeWhile_sorted_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1) {
		List<T1> sorted0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!arg1.test(t1)) {
					break;
				}
				sorted0.add(t1);
			}
		}
		Collections.sort((List) sorted0);
		for (T1 t1: sorted0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_takeWhile_sortedComp_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Comparator<? super T1> arg2) {
		List<T1> sortedComp0 = new ArrayList<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!arg1.test(t1)) {
					break;
				}
				sortedComp0.add(t1);
			}
		}
		sortedComp0.sort(arg2);
		for (T1 t1: sortedComp0) {
			result.add(t1);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_takeWhile_limit_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!arg1.test(t1)) {
					break;
				}
				limit0++;
				if(limit0 > arg2) {
					break;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_takeWhile_skip_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!arg1.test(t1)) {
					break;
				}
				skip0++;
				if(skip0 <= arg2) {
					continue;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_takeWhile_distinct_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1) {
		Set<T1> distinct0 = new HashSet<>();
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!arg1.test(t1)) {
					break;
				}
				if(!distinct0.add(t1)) {
					continue;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_takeWhile_dropWhile_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Predicate<T1> arg2) {
		boolean dropWhile0 = true;
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!arg1.test(t1)) {
					break;
				}
				if(dropWhile0 && arg2.test(t1)) {
					continue;
				} else {
					dropWhile0 = false;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1> List<T1> stream_flatMap_takeWhile_takeWhile_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Predicate<T1> arg2) {
		List<T1> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!arg1.test(t1)) {
					break;
				}
				if(!arg2.test(t1)) {
					break;
				}
				result.add(t1);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_flatMap_takeWhile_flatMap_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Predicate<T1> arg1, Function<T1, Collection<T2>> arg2) {
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				if(!arg1.test(t1)) {
					break;
				}
				for (T2 t2 : arg2.apply(t1)) {
					result.add(t2);
				}
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2, T3> List<T3> stream_flatMap_flatMap_map_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, Collection<T2>> arg1, Function<T2, T3> arg2) {
		List<T3> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				for (T2 t2 : arg1.apply(t1)) {
					T3 t3 = arg2.apply(t2);
					result.add(t3);
				}
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_flatMap_flatMap_filter_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, Collection<T2>> arg1, Predicate<T2> arg2) {
		List<T2> result = new ArrayList<>();
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				for (T2 t2 : arg1.apply(t1)) {
					if (!arg2.test(t2)) {
						continue;
					}
					result.add(t2);
				}
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_flatMap_flatMap_sorted_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, Collection<T2>> arg1) {
		List<T2> sorted0 = new ArrayList<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				for (T2 t2 : arg1.apply(t1)) {
					sorted0.add(t2);
				}
			}
		}
		Collections.sort((List) sorted0);
		for (T2 t2: sorted0) {
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_flatMap_flatMap_sortedComp_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, Collection<T2>> arg1, Comparator<? super T2> arg2) {
		List<T2> sortedComp0 = new ArrayList<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				for (T2 t2 : arg1.apply(t1)) {
					sortedComp0.add(t2);
				}
			}
		}
		sortedComp0.sort(arg2);
		for (T2 t2: sortedComp0) {
			result.add(t2);
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_flatMap_flatMap_limit_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, Collection<T2>> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long limit0 = 0;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				for (T2 t2 : arg1.apply(t1)) {
					limit0++;
					if(limit0 > arg2) {
						break;
					}
					result.add(t2);
				}
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_flatMap_flatMap_skip_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, Collection<T2>> arg1, long arg2) {
		if(arg2 < 0) {
			throw new IllegalArgumentException();
		}
		long skip0 = 0;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				for (T2 t2 : arg1.apply(t1)) {
					skip0++;
					if(skip0 <= arg2) {
						continue;
					}
					result.add(t2);
				}
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_flatMap_flatMap_distinct_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, Collection<T2>> arg1) {
		Set<T2> distinct0 = new HashSet<>();
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				for (T2 t2 : arg1.apply(t1)) {
					if(!distinct0.add(t2)) {
						continue;
					}
					result.add(t2);
				}
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_flatMap_flatMap_dropWhile_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, Collection<T2>> arg1, Predicate<T2> arg2) {
		boolean dropWhile0 = true;
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				for (T2 t2 : arg1.apply(t1)) {
					if(dropWhile0 && arg2.test(t2)) {
						continue;
					} else {
						dropWhile0 = false;
					}
					result.add(t2);
				}
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2> List<T2> stream_flatMap_flatMap_takeWhile_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, Collection<T2>> arg1, Predicate<T2> arg2) {
		List<T2> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				for (T2 t2 : arg1.apply(t1)) {
					if(!arg2.test(t2)) {
						break;
					}
					result.add(t2);
				}
			}
		}
		return Collections.unmodifiableList(result);
	}

	public static <T0, T1, T2, T3> List<T3> stream_flatMap_flatMap_flatMap_toList(Collection<T0> input, Function<T0, Collection<T1>> arg0, Function<T1, Collection<T2>> arg1, Function<T2, Collection<T3>> arg2) {
		List<T3> result = new ArrayList<>(input.size());
		for (T0 t0 : input) {
			for (T1 t1 : arg0.apply(t0)) {
				for (T2 t2 : arg1.apply(t1)) {
					for (T3 t3 : arg2.apply(t2)) {
						result.add(t3);
					}
				}
			}
		}
		return Collections.unmodifiableList(result);
	}


}