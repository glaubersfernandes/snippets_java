package br.com.gftecnologia.algorithm;

public class LinearSearchSnippet {

	/**
	 * Search an item with linearSearch algorithm.
	 * 
	 * @param arr  array to search
	 * @param item an item to search
	 * @return if item is found, return the index position of the array item
	 *         otherwise return -1.
	 */
	public static int linearSearch(int[] arr, int item) {
		for (int i = 0; i < arr.length; i++) {
			if (item == arr[i]) {
				return i;
			}
		}
		return -1;
	}
}
