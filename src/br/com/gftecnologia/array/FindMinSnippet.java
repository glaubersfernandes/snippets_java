package br.com.gftecnologia.array;

import java.util.Arrays;

public class FindMinSnippet {

	/**
	 * Returns the minimum integer from the array using reduction.
	 * 
	 * @param arr the array of integers (not null)
	 * @return the minimum element from the array
	 */
	public static int findMin(int[] arr) {
		return Arrays.stream(arr).reduce(Integer.MAX_VALUE, Integer::min);
	}
}
