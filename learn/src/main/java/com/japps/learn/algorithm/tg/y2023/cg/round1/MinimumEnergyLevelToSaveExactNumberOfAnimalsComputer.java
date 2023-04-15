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
public final class MinimumEnergyLevelToSaveExactNumberOfAnimalsComputer {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(final String[] args) {
		final Scanner scanner = new Scanner(System.in);

		final int n = scanner.nextInt();

		final int x = scanner.nextInt();

		scanner.nextLine();

		final List<Long> energyLevels =
				Arrays.asList(scanner.nextLine().split(" "))
				.stream()
				.map(Long::valueOf)
				.sorted().collect(Collectors.toList());

		System.out.println(
				((n == x) || (energyLevels.get(n - x) > energyLevels.get(n - x - 1)))
				? String.valueOf(energyLevels.get(n - x)) : String.valueOf(-1));

		scanner.close();
	}

}
