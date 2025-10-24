package br.com.gftecnologia.array;

import java.util.Arrays;

public class ArraySumSnippet {

	/**
	 * Returns sum of the integers in the array.
	 * 
	 * @param arr the array of integers (not null)
	 * @return the sum of the elements from the array
	 */
	public static int arraySum(int[] arr) {
		return Arrays.stream(arr).sum();
	}
}
