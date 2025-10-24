package br.com.gftecnologia.array;

import java.util.Arrays;

public class FindMaxSnippet {

	/**
	 * Returns the maximum integer from the array using reduction.
	 * 
	 * @param arr the array of integers (not null)
	 * @return the maximum element from the array
	 */
	public static int findMax(int[] arr) {
		return Arrays.stream(arr).reduce(Integer.MIN_VALUE, Integer::max);
	}
}
