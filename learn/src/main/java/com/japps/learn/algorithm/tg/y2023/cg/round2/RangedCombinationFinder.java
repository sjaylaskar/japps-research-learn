/**
 * Id: RangedCombinationFinder.java 28-Jun-2023 11:44:51 am SubhajoyLaskar
 * Copyright (©) 2023 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */

package com.japps.learn.algorithm.tg.y2023.cg.round2;

import java.util.Scanner;

/**
 * The ranged combination finder.
 */
public final class RangedCombinationFinder {

	/** The modulo. */
	private static final int MODULO = 1000000007;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(final String[] args) {
		final Scanner scanner = new Scanner(System.in);

		final int n = scanner.nextInt();

		final int k = scanner.nextInt();

		scanner.nextLine();

		final String s = scanner.nextLine();

		System.out.println(countReconstructedArrays(s, n, k));

		scanner.close();
	}

	/**
	 * Count reconstructed arrays.
	 *
	 * @param s the s
	 * @param n the n
	 * @param k the k
	 * @return the int
	 */
	public static int countReconstructedArrays(final String s, final int n, final int k) {
		final int[] table = new int[n + 1];
		table[n] = 1;

		for (int i = n - 1; i >= 0; i--) {
			if (s.charAt(i) == '0') {
				continue;
			}
			long number = 0;
			for (int j = 1; (i + j) <= n; j++) {
				number = ((number * 10) + s.charAt((i + j) - 1)) - '0';
				if (number > k) {
					break;
				}
				table[i] = (table[i] + table[i + j]) % MODULO;
			}
		}
		return table[0];
	}
}
