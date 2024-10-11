/**
 * Id: CountArrays.java 09-Jul-2023 1:55:44 am SubhajoyLaskar
 * Copyright (©) 2023 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.tg.y2023.cg.round2;

import java.util.HashSet;
import java.util.Set;

/**
 * The CountArrays.
 *
 * @author Subhajoy Laskar
 * @revision 1.0.
 */
public final class CountArrays {


	/** The dp. */
	private static int[] dp;

	/** The used digits. */
	private static Set<String> usedDigits;

	/**
	 * Count arrays.
	 *
	 * @param number the number
	 * @param k the k
	 * @return the int
	 */
	public static int countArrays(final String number, final int k) {
		// Initialize the table.
		dp = new int[number.length() + 1];
		dp[0] = 1;
		usedDigits = new HashSet<>();

		// Iterate over the digits in the number.
		for (int i = 1; i <= number.length(); i++) {
			// If the current digit is greater than k, there are no more arrays that can be formed.
			if (Integer.parseInt(number.charAt(i - 1) + "") > k) {
				break;
			}

			// Iterate over the previous digits.
			for (int j = 0; j < i; j++) {
				// If the current digit is not already present in the array and it is different from the previous digit, or if it is the same digit but i - j > 1, add the number of arrays that can be formed with the first j digits to the count of arrays that can be formed with the first i digits.
				if ((Integer.parseInt(number.charAt(i - 1) + "") <= k) && !usedDigits.contains(number.charAt(i - 1) + "") && ((j == 0) || (number.charAt(i - 1) != number.charAt(j - 1)) || ((i - j) > 1))) {
					dp[i] += dp[j];
				}
			}
			usedDigits.add(number.charAt(i - 1) + "");
		}

		// Return the count of arrays.
		return dp[number.length()];
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(final String[] args) {
		System.out.println(countArrays("123", 3));
		System.out.println(countArrays("123", 1000));
		System.out.println(countArrays("10203", 100));
	}
}
