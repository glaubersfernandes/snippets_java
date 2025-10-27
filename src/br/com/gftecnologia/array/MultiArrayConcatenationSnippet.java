package br.com.gftecnologia.array;

import java.util.Arrays;

public class MultiArrayConcatenationSnippet {

	/**
	 * Generic N array concatenation Credits: Joachim Sauer
	 * https://stackoverflow.com/questions/80476/how-can-i-concatenate-two-arrays-in-java
	 * 
	 * @param <T>   the element type
	 * @param first is the first array (not null)
	 * @param rest  the rest of the arrays (optional)
	 * @return concatenated array
	 */
	public static <T> T[] multiArrayConcat(T[] first, T[]... rest) {
		var totalLength = first.length;

		for (var array : rest) {
			totalLength += array.length;
		}

		var result = Arrays.copyOf(first, totalLength);
		var offset = first.length;

		for (var array : rest) {
			System.arraycopy(array, 0, result, offset, array.length);
			offset += array.length;
		}

		return result;
	}
}
