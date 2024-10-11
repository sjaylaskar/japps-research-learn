/**
 * Id: RangedCombinationFinder2.java 08-Jul-2023 1:29:45 am SubhajoyLaskar
 * Copyright (©) 2023 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.tg.y2023.cg.round2;

/**
 * The array count.
 */
public class ArrayCount {

	/**
	 * Number of arrays.
	 *
	 * @param s the s
	 * @param k the k
	 * @return the int
	 */
	public static int numberOfArrays(final String s, final int k) {
		final int n = s.length(), mod = 1000000007;
		final int[] dp = new int[n + 1];
		dp[n] = 1;

		for (int i = n - 1; i >= 0; i--) {
			if (s.charAt(i) == '0') {
				continue;
			}
			long cur = 0;
			for (int t = 1; (i + t) <= n; t++) {
				cur = ((cur * 10) + s.charAt((i + t) - 1)) - '0';
				if (cur > k) {
					break;
				}
				dp[i] = (dp[i] + dp[i + t]) % mod;
			}
		}
		return dp[0];
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(final String[] args) {
		System.out.println(numberOfArrays("123", 3));
		System.out.println(numberOfArrays("123", 1000));
		System.out.println(numberOfArrays("10203", 100));
	}
}
