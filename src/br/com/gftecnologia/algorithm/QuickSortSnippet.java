package br.com.gftecnologia.algorithm;

public class QuickSortSnippet {

	/**
	 * Sort an array with quicksort algorithm.
	 * 
	 * @param arr   array to sort.
	 * @param left  left index where to begin sort (e.g. 0)
	 * @param right right index where to end sort (e.g. array lenght - 1)
	 */
	public static void quickSort(int[] arr, int left, int right) {
		var pivotIndex = left + (right - left) / 2;
		var pivotValue = arr[pivotIndex];
		var i = left;
		var j = right;

		while (i <= j) {
			while (arr[i] < pivotValue) {
				i++;
			}
			while (arr[j] > pivotValue) {
				j--;
			}
			if (i <= j) {
				var tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}

			if (left < i) {
				quickSort(arr, left, j);
			}

			if (right > i) {
				quickSort(arr, i, right);
			}
		}
	}
}
