package br.com.gftecnologia.encoding;

import java.util.Base64;

public class Base64EncodeSnippet {

	/**
	 * Encodes the input string to a Base64 encoded string.
	 * 
	 * @param input string to be encoded
	 * @return base64 encoded string
	 */
	public static String encodeBase64(String input) {
		return Base64.getEncoder().encodeToString(input.getBytes());
	}
}
