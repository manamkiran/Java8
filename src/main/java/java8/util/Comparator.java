package java8.util;

import java.util.function.Function;

@FunctionalInterface
public interface Comparator<T> extends java.util.Comparator<T> {

	int compare(T t1, T t2);

	public static <U,V extends Comparable<V>> Comparator<U> comparator(Function<U,V> function) {
		return (t1, t2) -> function.apply(t1).compareTo(function.apply(t2));
	}

	public default <V extends Comparable<V>>Comparator<T> thenComparingWith(Function<T, V> function) {
		return thenComparingWith(comparator(function));
	}
	
	public default Comparator<T> thenComparingWith(Comparator<T> cmp) {
		return (t1,t2) -> compare(t1, t2)!=0 ? compare(t1, t2) : cmp.compare(t1, t2);
	}
	

}
