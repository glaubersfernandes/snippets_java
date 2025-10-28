package br.com.gftecnologia.classes;

import java.lang.reflect.InvocationTargetException;

public class CreatingObjectSnippet {

	/**
	 * Create object using reflection.
	 * 
	 * @param cls
	 * @return
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static Object createObject(String cls)
			throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> objectClass = Class.forName(cls);
		var objectConstrutor = objectClass.getConstructor();
		return objectConstrutor.newInstance();
	}
	
	public static void main(String[] args) {
	    try {
	      // Exemplo: Criando um objeto ArrayList
	      Object list = createObject("java.util.ArrayList"); 
	      System.out.println("Objeto criado com sucesso: " + list.getClass().getName());
	      System.out.println("É uma lista? " + (list instanceof java.util.List));
	    } catch (Exception e) {
	      System.err.println("Erro ao criar objeto:");
	      e.printStackTrace();
	    }
	  }
}
