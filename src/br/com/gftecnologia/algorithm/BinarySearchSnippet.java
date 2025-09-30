package br.com.gftecnologia.algorithm;

import java.util.Arrays;

public class BinarySearchSnippet {

	// --- VERSÃO RECURSIVA (COM MELHORIAS DE API) ---

	/**
	 * Método público e fácil de usar que inicia a busca binária recursiva
	 * 
	 * @param arr  O array ORDENADO onde a busca será feita.
	 * @param item O item a ser procurado.
	 * @return O índice do item se encontrado, caso contrário -1.
	 */
	public static int binarySearchRecursive(int[] arr, int item) {
		// Validação de entrada para evitar NullPointerException.
		if (arr == null) {
			return -1;
		}

		// Chama o método auxiliar com os parâmetros corretos
		return binarySearchRecursiveHelper(arr, 0, arr.length - 1, item);
	}

	/**
	 * Search an item with binarySearch algorithm. Método auxiliar (helper) privado
	 * com a lógica recursiva original.
	 * 
	 * @param arr  sorted array to search
	 * @param item an item to search
	 * @return if item is found, return the index position of the array item,
	 *         otherwise return -1
	 */
	public static int binarySearchRecursiveHelper(int[] arr, int left, int right, int item) {
		if (right >= left) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == item) {
				return mid;
			}

			if (arr[mid] > item) {
				return binarySearchRecursiveHelper(arr, left, mid - 1, item);
			}

			return binarySearchRecursiveHelper(arr, mid + 1, right, item);
		}

		return -1;
	}

	// --- VERSÃO ITERATIVA (RECOMENDADA PARA PRODUÇÃO) ---

	/**
	 * Versão iterativa da busca binária. Mais robusta contra StackOverflowError.
	 * 
	 * @param arr  O array ORDENADO onde a busca será feita.
	 * @param item O item a ser procurado.
	 * @return O índice do item se encontrado, caso contrário -1.
	 */
	public static int binarySearchIterative(int[] arr, int item) {
		if (arr == null) {
			return -1;
		}

		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (arr[mid] == item) {
				return mid; // Encontrado
			}

			if (arr[mid] < item) {
				left = mid + 1; // Busca na metade direita
			} else {
				right = mid - 1; // Busca na metade esquerda
			}
		}

		return -1; // Não encontrado
	}

	public static void main(String[] args) {
		System.out.println("--- Testando a Versão Recursiva --- ");
		runTests(TestType.RECURSIVE);

		System.out.println("\n--- Testando a Versão Iterativa ---");
		runTests(TestType.ITERATIVE);
	}

	// Enum para facilitar a escolha do método de teste
	enum TestType {
		RECURSIVE, ITERATIVE
	}

	private static void runTests(TestType type) {
		int[] arrPar = { 2, 5, 8, 12, 16, 23, 38, 56, 72, 91 };
		int[] arrImpar = { 3, 7, 11, 15, 22, 43, 67 };
		int[] arrVazio = {};
		int[] arrUmElemento = { 10 };

		// Teste 1: Item no meio (array par)
		runTest(type, arrPar, 16, 4);

		// Teste 2: Item no meio (array ímpar)
		runTest(type, arrImpar, 15, 3);

		// Teste 3: Item na primeira posição
		runTest(type, arrPar, 2, 0);

		// Teste 4: Item na última posição
		runTest(type, arrPar, 91, 9);

		// Teste 5: Item não existe (entre dois elementos)
		runTest(type, arrPar, 20, -1);

		// Teste 6: Item não existe (menor que todos)
		runTest(type, arrPar, 1, -1);

		// Teste 7: Item não existe (maior que todos)
		runTest(type, arrPar, 100, -1);

		// Teste 8: Array vazio
		runTest(type, arrVazio, 5, -1);

		// Teste 9: Array com um elemento (encontrado)
		runTest(type, arrUmElemento, 10, 0);

		// Teste 10: Array com um elemento (não encontrado)
		runTest(type, arrUmElemento, 7, -1);

		// Teste 11: Array nulo
		runTest(type, null, 5, -1);
	}

	// Método auxiliar para executar um único teste e reportar o resultado
	private static void runTest(TestType type, int[] arr, int item, int esperado) {
		int resultado;
		if (type == TestType.RECURSIVE) {
			resultado = binarySearchRecursive(arr, item);
		} else {
			resultado = binarySearchIterative(arr, item);
		}

		String status = resultado == esperado ? "PASSOU" : "FALHOU";
		System.out.printf("Buscando %d em %s. Esperado: %d, Recebido: %d -> [%s]\n", item,
				arr != null ? Arrays.toString(arr) : "null", esperado, resultado, status);
	}
}
