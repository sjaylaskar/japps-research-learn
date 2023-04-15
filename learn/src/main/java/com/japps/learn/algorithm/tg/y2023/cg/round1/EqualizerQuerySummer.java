/**
 * Id: MinimumEnergyLevelToSaveExactNumberOfAnimalsComputer.java 14-Apr-2023 1:39:22 pm SubhajoyLaskar
 * Copyright (©) 2023 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.tg.y2023.cg.round1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * The MinimumEnergyLevelToSaveExactNumberOfAnimalsComputer.
 *
 * @author Subhajoy Laskar
 * @revision 1.0.
 */
public final class EqualizerQuerySummer {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(final String[] args) {
		final Scanner scanner = new Scanner(System.in);

		final int n = scanner.nextInt();

		final int m = scanner.nextInt();

		scanner.nextLine();

		final List<Integer> nums = Arrays.asList(scanner.nextLine().split(" ")).stream().map(Integer::valueOf)
				.collect(Collectors.toList());

		final List<Integer> queries = Arrays.asList(scanner.nextLine().split(" ")).stream().map(Integer::valueOf)
				.collect(Collectors.toList());

		queries.forEach(query -> {
			System.out.print(
					nums.stream().filter(num -> !num.equals(query)).mapToInt(num -> Math.abs(num - query)).sum() + " ");
		});

		scanner.close();
	}
}
