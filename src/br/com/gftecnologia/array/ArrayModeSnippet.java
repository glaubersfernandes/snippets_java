package br.com.gftecnologia.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayModeSnippet {

	/**
	 * Private constructor to prevent instantiation.
	 */
	private ArrayModeSnippet() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Returns the mode(s) of the array. If multiple modes exist, it returns them in
	 * a list.
	 */
	public static List<Integer> modeArray(int[] arr) {
		int maxCount = 0;
		HashMap<Integer, Integer> frequencyMap = new HashMap<>();
		for (int num : arr) {
			frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
			maxCount = Math.max(maxCount, frequencyMap.get(num));
		}
		List<Integer> modes = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
			if (entry.getValue() == maxCount) {
				modes.add(entry.getKey());
			}
		}
		return modes;
	}
}
