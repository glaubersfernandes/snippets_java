package br.com.gftecnologia.algorithm;

public class SieveOfEratosthenesSnippet {

	/**
	 * Search an item with binarySearch algorithm.
	 * 
	 * @param n range of number.
	 * @return isPrime boolean array where prime number 0 to n are mark true.
	 */
	public static boolean[] sieveOfEratosthenes(int n) {
		boolean[] isPrime = new boolean[n + 1];
		for (int i = 0; i < isPrime.length; i++) {
			isPrime[i] = true;
		}

		for (int i = 2; i * i <= n; i++) {
			if (isPrime[i] == true) {
				for (int j = i * i; j <= n; j += i) {
					isPrime[j] = false;
				}
			}
		}

		return isPrime;
	}
}
