package br.com.gftecnologia.algorithm;

public class MergeSortSnippet {

	/**
	 * Sort an array with mergeSort algorithm.
	 * 
	 * @param arr  array to sort
	 * @param low  index where to begin sort (e.g. 0)
	 * @param high index where to end sort (e.g. array length - 1)
	 */
	public static void mergeSort(int[] arr, int low, int high) {
		if (low >= high) {
			return;
		}

		var mid = (low + high) / 2;
		mergeSort(arr, low, mid);
		mergeSort(arr, mid + 1, high);
		merge(arr, low, high, mid);
	}

	private static void merge(int[] arr, int low, int high, int mid) {

		int[] temp = new int[(high - low + 1)];
		var i = low;
		var j = mid + 1;
		var k = 0;

		while (i <= mid && j <= high) {
			if (arr[i] < arr[j]) {
				temp[k++] = arr[i];
				i++;
			} else {
				temp[k++] = arr[j];
				j++;
			}
		}

		while (i <= mid) {
			temp[k++] = arr[i];
			i++;
		}

		while (j <= high) {
			temp[k++] = arr[j];
			j++;
		}

		for (int m = 0, n = low; m < temp.length; m++, n++) {
			arr[n] = temp[m];
		}
	}
}
