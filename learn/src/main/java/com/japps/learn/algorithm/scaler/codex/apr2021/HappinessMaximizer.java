/*
* $Id: HappinessMaximizer.java 11-Apr-2021 12:40:16 pm SubhajoyLaskar $
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.scaler.codex.apr2021;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * The HappinessMaximizer.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class HappinessMaximizer {

    /** The happiness map. */
    private static final Map<Character, Integer> HAPPINESS_MAP = new HashMap<>(4);

    static {
        HAPPINESS_MAP.put('c', 4);
        HAPPINESS_MAP.put('w', 3);
        HAPPINESS_MAP.put('m', 2);
        HAPPINESS_MAP.put('o', 1);
    }

    /** The colon. */
    private static final String COLON = ":";

    /**
     * Solve.
     *
     * @param A the a
     * @param B the b
     * @return the int
     */
    public int solve(final int A, final List<String> B) {
        if (B.stream().allMatch(group -> group.length() > A)) {
            return 0;
        }

        final List<String> happinessList = B.stream().filter(group -> group.length() <= A)
        .map(group -> happiness(group))
        .collect(Collectors.toList());

        int max = 0;
        for (int i = 0; i < happinessList.size() - 1; i++) {
            for (int j = 1; j < happinessList.size(); j++) {
                final String gHI[] = happinessList.get(i).split(COLON);
                final String gHJ[] = happinessList.get(j).split(COLON);

                if (gHI[0].length() + gHJ[0].length() <= A) {
                    max = Math.max(Integer.valueOf(gHI[1]) + Integer.valueOf(gHJ[1]), max);
                }
            }
        }

        return max;
    }

    /**
     * Happiness.
     *
     * @param group the group
     * @return the happiness
     */
    private String happiness(final String group) {
       return group + COLON + group.length() * group.chars().map(c -> HAPPINESS_MAP.get((char) c)).sum();
    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final Scanner scanner = new Scanner(System.in);

        final int A = scanner.nextInt();

        final String[] BArr = scanner.next().toString().split(COLON);

        scanner.close();

        System.out.println(new HappinessMaximizer().solve(A, Arrays.asList(BArr)));
    }
}

