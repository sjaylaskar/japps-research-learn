/**
 * Id: StringCharFrequencifier.java 16-Apr-2023 11:34:04 pm SubhajoyLaskar
 * Copyright (©) 2023 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.etx.stxy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * The StringCharFrequencifier.
 *
 * @author Subhajoy Laskar
 * @revision 1.0.
 */
public final class StringCharFrequencifier {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(final String[] args) {

		final Scanner scanner = new Scanner(System.in);

		final String str = scanner.nextLine();

		frequencifyChars(str);

		frequencifyCharsByStreams(str);

		scanner.close();

	}

	/**
	 * Frequencify chars by streams.
	 *
	 * @param str the str
	 */
	private static void frequencifyCharsByStreams(final String str) {

		System.out.println(
				str.chars()
				.mapToObj(c -> (Character) (char) c)
				.collect(Collectors.counting()));
	}

	/**
	 * Frequencify chars.
	 *
	 * @param str the str
	 */
	private static void frequencifyChars(final String str) {

		final Map<Character, Integer> charFreqMap = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {
			final char c = str.charAt(i);

			charFreqMap.putIfAbsent(c, 0);

			charFreqMap.put(c, charFreqMap.get(c) + 1);
		}

		System.out.println(charFreqMap);
	}

}
