package br.com.gftecnologia.array;

import java.util.Arrays;

public class ArrayMeanSnippet {

	/**
	 * Returns the mean of the integers in the array.
	 * 
	 * @param arr the array of integers (not null)
	 * @return a double representing the mean of the array
	 */
	public static double arrayMean(int[] arr) {
		return (double) Arrays.stream(arr).sum() / arr.length;
	}
}
