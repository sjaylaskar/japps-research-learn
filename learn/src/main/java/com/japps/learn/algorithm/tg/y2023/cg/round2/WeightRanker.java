/**
 * Id: WeightRanker.java 28-Jun-2023 10:19:07 am SubhajoyLaskar
 * Copyright (©) 2023 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */

package com.japps.learn.algorithm.tg.y2023.cg.round2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The weight ranker.
 */
public final class WeightRanker {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(final String[] args) {
		final Scanner scanner = new Scanner(System.in);

		final int n = scanner.nextInt();

		final int p = scanner.nextInt();

		scanner.nextLine();

		final List<Long> rankedWeights = Arrays.asList(scanner.nextLine().split(" ")).stream().map(Long::valueOf)
				.collect(Collectors.toList());

		final List<Long> unRankedWeights = Arrays.asList(scanner.nextLine().split(" ")).stream().map(Long::valueOf)
				.collect(Collectors.toList());

		final Set<Long> unRankedWeightsSet = new LinkedHashSet<>(unRankedWeights);

		final Map<Long, Integer> ranks = rank(rankedWeights);

		final Map<Long, Integer> unRankedRanks = new HashMap<>();

		for (final Long unRankedWeight : unRankedWeightsSet) {
			findUnrankedRank(rankedWeights, ranks, unRankedWeight, unRankedRanks);
		}

		unRankedWeights.forEach(unRankedWeight -> System.out.println(findRank(unRankedRanks, unRankedWeight)));

		scanner.close();
	}

	/**
	 * Find unranked rank.
	 *
	 * @param rankedWeights the ranked weights
	 * @param ranks the ranks
	 * @param unRankedWeight the un ranked weight
	 * @param unRankedRanks the un ranked ranks
	 * @return the int
	 */
	private static void findUnrankedRank(final List<Long> rankedWeights, final Map<Long, Integer> ranks,
			final long unRankedWeight, final Map<Long, Integer> unRankedRanks) {
		final int possibleIndex = findPossibleIndex(rankedWeights, unRankedWeight);
		if (possibleIndex == 0) {
			unRankedRanks.putIfAbsent(unRankedWeight, 1);
		} else if (possibleIndex > 0) {
			if (rankedWeights.get(possibleIndex - 1) == unRankedWeight) {
				unRankedRanks.putIfAbsent(unRankedWeight, (findRank(ranks, unRankedWeight)));
			} else {
				unRankedRanks.putIfAbsent(unRankedWeight, (findRank(ranks, rankedWeights.get(possibleIndex - 1)) + 1));
			}
		}
		rankedWeights.add(possibleIndex, unRankedWeight);
	}

	/**
	 * Find rank.
	 *
	 * @param ranks the ranks
	 * @param weight the weight
	 * @return the int
	 */
	private static int findRank(final Map<Long, Integer> ranks, final long weight) {
		if (ranks.containsKey(weight)) {
			return ranks.get(weight);
		}

		return -1;
	}

	/**
	 * Rank.
	 *
	 * @param rankedWeights the ranked weights
	 * @return the map
	 */
	private static Map<Long, Integer> rank(final List<Long> rankedWeights) {
		final Map<Long, Integer> rankedWeightRanks = new HashMap<>();

		rankedWeightRanks.put(rankedWeights.get(0), 1);
		for (int i = 1; i < rankedWeights.size(); i++) {
			if (rankedWeights.get(i) < rankedWeights.get(i - 1)) {
				rankedWeightRanks.put(rankedWeights.get(i), rankedWeightRanks.get(rankedWeights.get(i - 1)) + 1);
			}
		}

		return rankedWeightRanks;
	}

	/**
	 * Find possible index.
	 *
	 * @param arr the arr
	 * @param key the key
	 * @return the long
	 */
	private static int findPossibleIndex(final List<Long> arr, final long key) {

		final int size = arr.size();
		final int possibleIndex = floorBinarySearch(arr, key, 0, size - 1);

		return (possibleIndex >= 0)
				? possibleIndex + 1
						: (key < arr.get(size - 1))
						? size
								: (key > arr.get(0))
								? 0
										: possibleIndex;
	}

	/**
	 * Floor binary search.
	 *
	 * @param arr the arr
	 * @param key the key
	 * @param low the low
	 * @param high the high
	 * @return the int
	 */
	private static int floorBinarySearch(final List<Long> arr, final long key, final int low, final int high) {

		if (low > high) {
			return -1;
		}

		if (key <= arr.get(high)) {
			return high;
		}

		final int mid = (low + high) / 2;

		if (key == arr.get(mid)) {
			return mid;
		}

		if ((mid > 0) && (arr.get(mid - 1) >= key) && (key > arr.get(mid))) {
			return mid - 1;
		}

		if (key > arr.get(mid)) {
			return floorBinarySearch(arr, key, low, mid - 1);
		}

		return floorBinarySearch(arr, key, mid + 1, high);

	}

}
