package br.com.gftecnologia.array;

public class ReverseArraySnippet {

	/**
	 * The function then reverses the elements of the array between the starting and ending 
	 * indices using a while loop and a temporary variable 'temp'. Finally, the function returns
	 * the reversed array.
	 * 
	 * @param <T>
	 * @param array a array
	 * @param start start index array
	 * @param end end index array
	 * @return reverses elements in the array
	 * @throws IllegalArgumentException if the [start] index is greater than the [end] index or if the array is null
	 */
	public static <T> T[] reverseArray(T[] array, int start, int end) {
		if (start > end || array == null) {
			throw new IllegalArgumentException("Invalid argument!");
		}

		int minimumSizeArrayForReversal = 2;

		if (start == end || array.length < minimumSizeArrayForReversal) {
			return array;
		}

		while (start < end) {
			T temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			start++;
			end--;
		}

		return array;
	}
}
