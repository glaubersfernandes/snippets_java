package br.com.gftecnologia.encoding;

import java.util.Base64;

public class Base64DecodeSnippet {

	/**
	 * Decodes a Base64 encoded string to the actual representation.
	 * 
	 * @param input base64 encoded input
	 * @return decoded string
	 */
	public static String decodeBase64(String input) {
		return new String(Base64.getDecoder().decode(input.getBytes()));
	}
}
