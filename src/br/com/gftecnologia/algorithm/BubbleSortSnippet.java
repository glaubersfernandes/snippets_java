package br.com.gftecnologia.algorithm;

import java.util.Arrays;

public class BubbleSortSnippet {

	/**
	 * Sort an array with an optimized bubbleSort algorithm.
	 * 
	 * @param arr array to sort
	 */
	public static void bubbleSort(int[] arr) {

		// Validação de entrada para robutez.
		// Arrays nulos ou com 0 ou 1 elemento não precisam de ordenação.
		if (arr == null || arr.length < 2) {
			return;
		}

		int lastIndex = arr.length;
		boolean swapped; // Flag para otimização de "curto-circuito"

		for (int j = 0; j < lastIndex - 1; j++) {
			// Otimização de "Curto-Circuito"
			// Se nenhuma troca ocorrer em uma passagem, o array está ordenado.
			swapped = false;
			for (int i = 0; i < lastIndex - 1 - j; i++) {
				if (arr[i] > arr[i + 1]) {
					// Melhoria: Usando método auxiliar para a troca
					swap(arr, i, i + 1);
					swapped = true;
				}
			}

			// Se não houve trocas nesta passagem, podemos sair mais cedo.
			if (!swapped) {
				break;
			}
		}
	}

	/**
	 * Método auxiliar privado para trocar dois elementos em um array.
	 * 
	 * @param arr    O array
	 * @param index1 O índice do primeiro elemento
	 * @param index2 O índice do segundo elemento
	 */
	private static void swap(int[] arr, int index1, int index2) {
		int tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;
	}

	private static void runTest(String testName, int[] arr, int[] expected) {
		System.out.println("\nExecutando teste: " + testName);
		System.out.println("Array original: " + (arr != null ? Arrays.toString(arr) : "null"));

		// Clona o array para não modificar o original se for usado em outro lugar
		int[] arrToSort = arr != null ? arr.clone() : null;

		bubbleSort(arrToSort);

		String status = Arrays.equals(arrToSort, expected) ? "PASSOU" : "FALHOU";
		System.out.println("Array ordenado: " + (arrToSort != null ? Arrays.toString(arrToSort) : "null"));
		if (status.equals("FALHOU")) {
			System.out.println("Esperado:    " + (expected != null ? Arrays.toString(expected) : "null"));
		}
		System.out.println("Resultado: [" + status + "]");
	}

	public static void main(String[] args) {
		System.out.println("--- Iniciando suíte de testes para o Bubble Sort Otimizado ---");

		// Teste 1: Array comum desordenado
		int[] arr1 = { 64, 34, 25, 12, 22, 11, 90 };
		runTest("Array comum", arr1, new int[] { 11, 12, 22, 25, 34, 64, 90 });

		// Teste 2: Array já ordenado (testa a otimização de "curto-circuito)
		int[] arr2 = { 5, 10, 15, 20, 25 };
		runTest("Array já ordenado", arr2, new int[] { 5, 10, 15, 20, 25 });

		// Teste 3: Array em ordem decrescente (pior caso)
		int[] arr3 = { 9, 8, 7, 6, 5 };
		runTest("Array em ordem decrescente", arr3, new int[] { 5, 6, 7, 8, 9 });

		// Teste 4: Array com elementos duplicados
		int[] arr4 = { 5, 1, 4, 2, 8, 5, 4 };
		runTest("Array com elementos duplicados", arr4, new int[] { 1, 2, 4, 4, 5, 5, 8 });

		// Teste 5: Array vazio (edge case)
		int[] arr5 = {};
		runTest("Array vazio", arr5, new int[] {});

		// Teste 6: Array com um elemento (edge case)
		int[] arr6 = { 42 };
		runTest("Array com um elemento", arr6, new int[] { 42 });

		// Teste 7: Array nulo (edge case)
		int[] arr7 = null;
		runTest("Array nulo", arr7, null);

		// Teste 8: Array com elementos negativos
		int[] arr8 = { -10, 0, -20, 50, 15 };
		runTest("Array com elementos negativos", arr8, new int[] { -20, -10, 0, 15, 50 });
	}
}
