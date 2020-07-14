package java8.util;

import java.util.function.Function;

public interface Comparator<T> extends java.util.Comparator<T> {

	int compare(T t1, T t2);

	public static <U> Comparator<U> comparator(Function<U, Comparable> function) {
		return (t1, t2) -> function.apply(t1).compareTo(function.apply(t2));
	}

	public default Comparator<T> thenComparingWith(Function<T, Comparable> function) {
		return (t1,t2) -> compare(t1, t2)!=0 ? compare(t1, t2) : comparator(function).compare(t1, t2);
	}
	

}
