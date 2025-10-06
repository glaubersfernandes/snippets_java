package br.com.gftecnologia.algorithm;

public class CycleSortSnippet {

	/**
	 * Sort an array with cycleSort algorithm.
	 * 
	 * @param arr
	 * @return
	 */
	public static int[] cycleSort(int[] arr) {
		int n = arr.length;
		int i = 0;

		while (i < n) {
			int correctpos = arr[i] - 1;
			if (arr[i] != arr[correctpos]) {
				int temp = arr[i];
				arr[i] = arr[correctpos];
				arr[correctpos] = temp;
			} else {
				i++;
			}
		}
		return arr;
	}
}
