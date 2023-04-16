/**
 * Id: StringDuplicateCharFinder.java 16-Apr-2023 11:41:13 pm SubhajoyLaskar
 * Copyright (©) 2023 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.etx.stxy;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * The StringDuplicateCharFinder.
 *
 * @author Subhajoy Laskar
 * @revision 1.0.
 */
public final class StringDuplicateCharFinder {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(final String[] args) {
		final Scanner scanner = new Scanner(System.in);

		final String str = scanner.nextLine();

		findDuplicateChars(str);

		scanner.close();

	}

	/**
	 * Find duplicate chars.
	 *
	 * @param str the str
	 */
	private static void findDuplicateChars(final String str) {

		final Set<Character> charSet = new HashSet<>();
		final Set<Character> duplicateChars = new HashSet<>();
		for (int i = 0; i < str.length(); i++) {
			final char c = str.charAt(i);

			if (!charSet.add(c)) {
				duplicateChars.add(c);
			}
		}

		System.out.println(duplicateChars);
	}

}
