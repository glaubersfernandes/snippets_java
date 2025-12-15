package br.com.gftecnologia.classes;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GetAllMethodsSnippet {

	/**
	 * Print all declared methods of the class.
	 * 
	 * @param cls Tested class
	 * @return list of methods name
	 */
	public static List<String> getAllMethods(final Class<?> cls) {
		return Arrays.stream(cls.getDeclaredMethods()).map(Method::getName).collect(Collectors.toList());
	}
}
