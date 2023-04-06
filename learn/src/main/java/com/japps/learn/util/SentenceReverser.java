/**
 * Id: SentenceReverser.java 05-Apr-2023 9:12:36 pm SubhajoyLaskar
 * Copyright (©) 2023 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.util;

/**
 * The SentenceReverser.
 *
 * @author Subhajoy Laskar
 * @revision 1.0.
 */
public final class SentenceReverser {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(final String[] args) {


		System.out.println(reverse("Hello world"));
	}

	/**
	 * Reverse.
	 *
	 * @param sentence the sentence
	 * @return the string
	 */
	private static String reverse(final String sentence) {
		final String[] words = sentence.split(" ");

		final StringBuilder reverseSentence = new StringBuilder();

		for (final String word : words) {
			reverseSentence.append(new StringBuilder(word).reverse().append(" "));
		}

		return reverseSentence.toString();
	}

}
