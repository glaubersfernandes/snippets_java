package br.com.gftecnologia.array;

import java.util.Arrays;

public class ArrayModeInPlaceSnippet {

	/**
	 * Returns the mode of the array.
	 * 
	 * @param arr array to find mode in it
	 * @return mode of array
	 */
	public static int modeArrayInPlace(int[] arr) {
		if (arr.length == 0) {
			return 0;
		}

		Arrays.sort(arr);

		int mode = arr[0];
		int maxcount = 1;
		int count = 1;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == arr[i - 1]) {
				count++;
			} else {
				if (count > maxcount) {
					maxcount = count;
					mode = arr[i - 1];
				}
				count = 1;
			}
		}
		if (count > maxcount) {
			mode = arr[arr.length - 1];
		}
		return mode;
	}
}
