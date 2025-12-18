package br.com.gftecnologia.classes;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GetAllPublicFieldNamesSnippet {

	/**
	 * Print all declared public field names of the class or the interface the class extends.
	 * @param clazz Tested class
	 * @return list of name of public fields
	 */
	public static List<String> getAllPublicFieldNames(final Class<?> clazz) {
		return Arrays.stream(clazz.getFields()).map(Field::getName).collect(Collectors.toList());
	}
}
