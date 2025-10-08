package br.com.gftecnologia.algorithm;

public class LuhnModnSnippet {

	private static final String CODE_POINTS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	/**
	 * Generates a check character using the Luhn mod N algorithm.
	 * 
	 * @param character the input string consisting of valid alphanumeric characters
	 * @return the generated check character
	 * @throws IllegalArgumentException if the input contains invalid characters
	 */
	public static int codePointFromCharacter(char character) {
		if (CODE_POINTS.indexOf(character) == -1) {
			throw new IllegalArgumentException("Invalid character: " + character);
		}

		return CODE_POINTS.indexOf(character);
	}

	/**
	 * Converts a code point to its corresponding character.
	 * 
	 * @param codePoint the code point to be converted
	 * @return the character representation of the code point
	 * @throws IllegalArgumentException if the code point is out of range.
	 */
	public static char characterFromCodePoint(int codePoint) {
		if (codePoint < 0 || codePoint >= CODE_POINTS.length()) {
			throw new IllegalArgumentException("Invalid code point: " + codePoint);
		}
		return CODE_POINTS.charAt(codePoint);
	}

	public static int numberOfValidInputCharacters() {
		return CODE_POINTS.length();
	}

	/**
	 * Helper method to calculate the sum for both check character generation and
	 * validation.
	 * 
	 * @param input       the input string
	 * @param factorStart the initial factor to start with (1 or 2)
	 * @return the calculated sum, reminder, and the numberOfValidInputCharacters
	 */
	private static int[] calculateSum(String input, int factorStart) {
		if (input == null || input.isEmpty()) {
			throw new IllegalArgumentException("Input cannot be empty");
		}

		int factor = factorStart;
		int sum = 0;
		int n = numberOfValidInputCharacters();

		for (int i = input.length() - 1; i >= 0; i--) {
			int codePoint = codePointFromCharacter(input.charAt(i));
			int addend = factor * codePoint;
			factor = (factor == 2) ? 1 : 2;
			addend = (addend / n) + (addend % n);
			sum += addend;
		}

		return new int[] { sum, sum % n, n };
	}

	/**
	 * Generates a check character for the given input string using the Luhn mod N
	 * algorithm.
	 * 
	 * @param input the input string (non-empty)
	 * @return the generated check character
	 * @throws IllegalArgumentException if the input is null or empty
	 */
	public static char generateCheckCharacter(String input) {
		int[] result = calculateSum(input, 2);
		return characterFromCodePoint((result[2] - result[1]) % result[2]);
	}

	/**
	 * Validates a check character by applying the Luhn mod N algorithm.
	 * 
	 * @param input the input string (including the check character)
	 * @return true if the input passes validation, false otherwise
	 * @throws IllegalArgumentException if the input is null or empty
	 */
	public static boolean validateCheckCharacter(String input) {
		int[] result = calculateSum(input, 1);
		return (result[1] == 0);
	}
}
