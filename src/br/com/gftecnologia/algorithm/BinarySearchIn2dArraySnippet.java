package br.com.gftecnologia.algorithm;

import java.util.Arrays;

public class BinarySearchIn2dArraySnippet {

	/**
	 * Search an item with binarySearch algorithm.
	 * 
	 * @param matrix should be sorted
	 * @param target an item to search
	 * @return if location of item is found, otherwise return {-1, -1}
	 */
	public static int[] binarySearchIn2darr(int[][] matrix, int target) {

		// Isso previne a exceção 'ArrayIndexOutOfBoundsException'.
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return new int[] { -1, -1 };
		}

		int rows = matrix.length;
		int cols = matrix[0].length;

		// Se houver apenas uma linha, realizamos uma busca 1D nela e encerramos.
		if (rows == 1) {
			return binarySearch(matrix, target, 0, 0, cols - 1);
		}

		int rstart = 0;
		int rend = rows - 1;
		int cmid = cols / 2;

		while (rstart < (rend - 1)) {
			int rmid = rstart + (rend - rstart) / 2;
			if (matrix[rmid][cmid] > target) {
				rend = rmid;
			} else if (matrix[rmid][cmid] < target) {
				rstart = rmid;
			} else {
				return new int[] { rmid, cmid };
			}
		}

		if (matrix[rstart][cmid] == target) {
			return new int[] { rstart, cmid };
		}

		if (matrix[rend][cmid] == target) {
			return new int[] { rend, cmid };
		}

		if (target >= matrix[rstart][0] && target <= matrix[rstart][cmid]) {
			return binarySearch(matrix, target, rstart, 0, cmid);
		}

		if (cmid + 1 < cols && target >= matrix[rstart][cmid + 1] && target <= matrix[rstart][cols - 1]) {
			return binarySearch(matrix, target, rstart, cmid + 1, cols - 1);
		}

		if (target >= matrix[rend][0] && target <= matrix[rend][cmid]) {
			return binarySearch(matrix, target, rend, 0, cmid);
		}

		if (cmid + 1 < cols && target >= matrix[rend][cmid + 1] && target <= matrix[rend][cols - 1]) {
			return binarySearch(matrix, target, rend, cmid + 1, cols - 1);
		}

		return new int[] { -1, -1 };
	}

	/**
	 * Helper method to perform a standard 1D binary search on a specific row.
	 */
	static int[] binarySearch(int[][] matrix, int target, int row, int cstart, int cend) {
		while (cstart <= cend) {
			int cmid = cstart + (cend - cstart) / 2;
			if (matrix[row][cmid] > target) {
				cend = cmid - 1;
			} else if (matrix[row][cmid] < target) {
				cstart = cmid + 1;
			} else {
				return new int[] { row, cmid };
			}
		}
		return new int[] { -1, -1 };
	}

	// --- MÉTODO MAIN PARA TESTES ---
	public static void main(String[] args) {
		int[][] matrix = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 28, 29, 37, 49 }, { 33, 34, 38, 50 } };

		System.out.println("Matriz de Teste:");
		imprimirMatrix(matrix);
		System.out.println("------------------------------------------");

		// --- Casos de Teste ---
		System.out.println("Iniciando testes...");
		testarBusca(matrix, 37); // Elemento do meio
		testarBusca(matrix, 36); // Elemento que não existe
		testarBusca(matrix, 10); // Primeiro elemento
		testarBusca(matrix, 50); // Último elemento
		testarBusca(matrix, 5); // Elemento menor que todos
		testarBusca(matrix, 100); // Elemento maior que todos

		System.out.println("\n--- Teste com matriz de linha única ---");
		int[][] linhaUnicaMatrix = { { 5, 8, 12, 16, 22, 29 } };

		System.out.println("Matriz de Teste de Linha Única:");
		imprimirMatrix(linhaUnicaMatrix);
		System.out.println("------------------------------------------");
		testarBusca(linhaUnicaMatrix, 16);
		testarBusca(linhaUnicaMatrix, 17);
	}

	/**
	 * Método auxiliar para executar um teste e imprimir o resultado formatado.
	 */
	private static void testarBusca(int[][] matrix, int target) {
		int[] resultado = binarySearchIn2darr(matrix, target);
		if (resultado[0] != -1) {
			System.out.printf("Resultado para %d: Elemento encontrado na posição: %s\n", target,
					Arrays.toString(resultado));
		} else {
			System.out.printf("Resultado para %d: Elemento não encontrado.\n", target);
		}
	}

	/**
	 * Método auxiliar para imprimir a matriz de forma legível
	 */
	private static void imprimirMatrix(int[][] matrix) {
		for (int[] row : matrix) {
			System.out.println(Arrays.toString(row));
		}
	}
}
