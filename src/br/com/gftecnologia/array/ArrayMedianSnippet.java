package br.com.gftecnologia.array;

import java.util.Arrays;

public class ArrayMedianSnippet {

	/**
	 * Returns the median of the array.
	 * 
	 * @param arr the array of integers (not null)
	 * @return a double representing the median of the array
	 */
	public static double arrayMedian(int[] arr) {
		Arrays.sort(arr);
		var mid = arr.length / 2;
		return arr.length % 2 != 0 ? (double) arr[mid] : (double) (arr[mid] + arr[mid - 1]) / 2;
	}
}
