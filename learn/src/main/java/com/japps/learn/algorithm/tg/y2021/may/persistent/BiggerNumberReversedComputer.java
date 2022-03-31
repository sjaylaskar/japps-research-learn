/*
* $Id: BiggerNumberReversedComputer.java 17-May-2021 3:23:02 pm SubhajoyLaskar $
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.tg.y2021.may.persistent;

import java.util.Scanner;

/**
 * The BiggerNumberReversedComputer.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class BiggerNumberReversedComputer {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final Scanner scanner = new Scanner(System.in);

        final String a = new StringBuilder(scanner.next()).reverse().toString();

        final String b = new StringBuilder(scanner.next()).reverse().toString();

        scanner.close();

        System.out.println(Math.max(Long.valueOf(a), Long.valueOf(b)));
    }

}
