/*
 * $Id: PunchedCardsPrinter.java 02-Apr-2022 3:48:56 pm SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.goog.codejam.y2022.qualround;

import java.util.Scanner;


/**
 * The punched cards printer.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class PunchedCardsPrinter {

    /** The new line. */
    private static final String NEW_LINE = "\n";

    /** The pattern pipe dot pipe. */
    private static final String PATTERN_PIPE_DOT_PIPE = "|.|";

    /** The pattern plus minus plus. */
    private static final String PATTERN_PLUS_MINUS_PLUS = "+-+";

    /** The pattern first row start. */
    private static final String PATTERN_FIRST_ROW_START = "..|";

    /** The pattern zeroth row start. */
    private static final String PATTERN_ZEROTH_ROW_START = "..+";

    /** The pattern minus plus. */
    private static final String PATTERN_MINUS_PLUS = "-+";

    /** The pattern dot pipe. */
    private static final String PATTERN_DOT_PIPE = ".|";

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final Scanner scanner = new Scanner(System.in);

        final int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            final int r = scanner.nextInt();
            final int c = scanner.nextInt();

            final StringBuilder minusPlusPatternBuilder = new StringBuilder();
            final StringBuilder dotPipePatternBuilder = new StringBuilder();
            for (int col = 1; col < c; col++) {
                minusPlusPatternBuilder.append(PATTERN_MINUS_PLUS);
                dotPipePatternBuilder.append(PATTERN_DOT_PIPE);
            }
            final StringBuilder subsequentMinusPlusPatternBuilder = new StringBuilder(PATTERN_PLUS_MINUS_PLUS).append(
                minusPlusPatternBuilder).append(NEW_LINE);
            final StringBuilder subsequentDotPipePatternBuilder = new StringBuilder(PATTERN_PIPE_DOT_PIPE).append(
                dotPipePatternBuilder).append(NEW_LINE);

            final StringBuilder punchedCardPrintBuilder = new StringBuilder("Case #" + i + ":").append(NEW_LINE)
                .append(PATTERN_ZEROTH_ROW_START).append(minusPlusPatternBuilder).append(NEW_LINE)
                .append(PATTERN_FIRST_ROW_START).append(dotPipePatternBuilder).append(NEW_LINE);

            final int rows = r * 2 - 1;
            for (int row = 1; row <= rows; row++) {
                punchedCardPrintBuilder.append(
                    (row % 2 != 0)
                        ? (row < rows) ? subsequentMinusPlusPatternBuilder : subsequentMinusPlusPatternBuilder
                        : subsequentDotPipePatternBuilder);
            }

            System.out.print((i == t) ? punchedCardPrintBuilder.toString().trim()
                : punchedCardPrintBuilder);
        }

        scanner.close();

    }

}
