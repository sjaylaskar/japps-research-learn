/**
 * Id: ValleyCounter.java 23-Jul-2023 1:14:31 am SubhajoyLaskar
 * Copyright (©) 2023 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.hrank;

/**
 * The ValleyCounter.
 *
 * @author Subhajoy Laskar
 * @revision 1.0.
 */
public final class ValleyCounter {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(final String[] args) {
		System.out.println(countingValleys(8, "UDDDUDUU"));
		System.out.println(countingValleys(8, "DDUUUUDD"));
		System.out.println(countingValleys(12, "DDUUDDUDUUUD"));
	}

	/**
	 * Counting valleys.
	 *
	 * @param steps the steps
	 * @param path the path
	 * @return the int
	 */
	public static int countingValleys(final int steps, final String path) {

		boolean isBelowSeaLevel = false;
		int seaLevellerCount = 0;
		int valleyCount = 0;
		for (int i = 0; i < steps; i++) {
			final char step = path.charAt(i);
			seaLevellerCount += (step == 'U') ? 1 : -1;
			if (seaLevellerCount < 0) {
				isBelowSeaLevel = true;
			}
			if (isBelowSeaLevel && (seaLevellerCount == 0)) {
				valleyCount += 1;
				isBelowSeaLevel = false;
			}
		}
		return valleyCount;
	}
}