/*
* $Id: StringCharFrequencyDeterminer.java 21-Jul-2022 1:48:34 am SubhajoyLaskar $
* Copyright (©) 2022 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.common;

import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * The string char frequency determiner.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class StringCharFrequencyDeterminer {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        determineCharFrequency(scanner.nextLine()).forEach((key, value) -> System.out.println(((key == 32) ? "SPACE" : key) + " : " + value));
        scanner.close();
    }

    private static Map<Character, Long> determineCharFrequency(final String str) {
        return str.chars().boxed().collect(Collectors.groupingBy(c -> (char) (int) c, Collectors.counting()));
    }

}
