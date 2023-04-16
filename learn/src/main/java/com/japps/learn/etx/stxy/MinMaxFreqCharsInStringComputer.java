/**
 * Id: MinMaxCharFreqInStringComputer.java 16-Apr-2023 10:44:12 pm SubhajoyLaskar
 * Copyright (©) 2023 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.etx.stxy;

import java.util.Scanner;

/**
 * The MinMaxCharFreqInStringComputer.
 *
 * @author Subhajoy Laskar
 * @revision 1.0.
 */
public final class MinMaxFreqCharsInStringComputer {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(final String[] args) {

		final Scanner scanner = new Scanner(System.in);

		final String str = scanner.nextLine();

		findMinMaxFreqChars(str);

		scanner.close();

	}

	/**
	 * Find min max freq chars.
	 *
	 * @param str the str
	 */
	private static void findMinMaxFreqChars(final String str) {

		final String strLowerCase = str.toLowerCase();
		final int[] frequencies = new int[26];

		for (int i = 0; i < strLowerCase.length(); i++) {
			if (strLowerCase.charAt(i) != ' ') {
				frequencies[strLowerCase.charAt(i) - 97]++;
			}
		}

		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		int minPos = -1, maxPos = -1;

		for (int i = 0; i < 26; i++) {
			if (frequencies[i] != 0) {
				if (frequencies[i] < min) {
					min = frequencies[i];
					minPos = i;
				}
				if (frequencies[i] > max) {
					max = frequencies[i];
					maxPos = i;
				}
			}
		}

		System.out.println("Min occuring char: " + (char) (minPos + 97));
		System.out.println("Max occuring char: " + (char) (maxPos + 97));

	}

}
