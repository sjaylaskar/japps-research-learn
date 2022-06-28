/*
 * $Id: ExclusiveRoomNumberFinder.java 27-Jun-2022 10:24:54 pm SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.tg.y2022.cg.round2;

import java.util.Scanner;


/**
 * The exclusive room number finder.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class ExclusiveRoomNumberFinder {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final Scanner scanner = new Scanner(System.in);

        final int n = scanner.nextInt();

        findRoom(n);

        scanner.close();
    }

    /**
     * @param n
     */
    private static void findRoom(final int n) {

        int currentMaxNum = n;
        for (int i = 1; i <= currentMaxNum; i++) {
            final String numStr = Integer.toString(i);
            if (numStr.contains("2") || numStr.contains("14")) {
                currentMaxNum++;
            }
        }
        System.out.println(currentMaxNum);
    }
}
