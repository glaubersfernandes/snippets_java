package br.com.gftecnologia.algorithm;

public class LinearSearchIn2dArraySnippet {

	/**
	 * Search an item with linearSearch algorithm.
	 * 
	 * @param arr    array to search
	 * @param target an item to search
	 * @return if location of target is found, otherwise return {-1, -1}
	 */
	public static int[] linearSearch2dArray(int[][] arr, int target) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == target) {
					return new int[] { i, j };
				}
			}
		}
		return new int[] { -1, -1 };
	}
}
