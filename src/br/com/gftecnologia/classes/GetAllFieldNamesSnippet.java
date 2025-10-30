package br.com.gftecnologia.classes;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GetAllFieldNamesSnippet {

	/**
	 * Print all declared field names of the class or the interface the class
	 * extends.
	 * 
	 * @param clazz Tested class
	 * @return list of names of all fields
	 */
	public static List<String> getAllFieldNames(final Class<?> clazz) {
		var fields = new ArrayList<String>();
		var currentClazz = clazz;
		while (currentClazz != null) {
			fields.addAll(Arrays.stream(currentClazz.getDeclaredFields()).filter(field -> !field.isSynthetic())
					.map(Field::getName).collect(Collectors.toList()));

			currentClazz = currentClazz.getSuperclass();
		}

		return fields;
	}
}
