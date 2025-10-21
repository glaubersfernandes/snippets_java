package br.com.gftecnologia.array;

import java.util.Arrays;

public class AllEqualSnippet {

	/**
	 * Returns true if all elements in array are equal.
	 * 
	 * @param <T> the element type
	 * @param arr the array to check (not null)
	 * @return true if all elements in the array are equal
	 */
	public static <T> boolean allEqual(T[] arr) {
		return Arrays.stream(arr).distinct().count() == 1;
	}
}
