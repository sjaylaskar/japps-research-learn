/*
 * $Id: ThreeDCardPrinter.java 03-Apr-2022 12:47:12 am SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.goog.codejam.y2022.qualround;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


/**
 * The three D card printer.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class ThreeDCardPrinter {

    /** The empty. */
    private static final String EMPTY = "";

    /** The impossible. */
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    /** The new line. */
    private static final String NEW_LINE = "\n";

    /** The colon. */
    private static final String COLON = ":";

    /** The case. */
    private static final String CASE = "Case #";

    /** The number of colors. */
    private static final int NUMBER_OF_COLORS = 4;

    /** The max color. */
    private static final int MAX_COLOR = 1000000;

    /** The space. */
    private static final String SPACE = " ";

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final Scanner scanner = new Scanner(System.in);

        final int t = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= t; i++) {
            final boolean isTrim = (i == t);
            final Map<Color, List<Integer>> colorUnitsMap = new HashMap<>();
            final String[] printer1InkUnitsString = scanner.nextLine().split(SPACE);
            final String[] printer2InkUnitsString = scanner.nextLine().split(SPACE);
            final String[] printer3InkUnitsString = scanner.nextLine().split(SPACE);

            for (final Color color : Color.values()) {
                colorUnitsMap.putIfAbsent(color, new ArrayList<>());
                colorUnitsMap.get(color).add(Integer.valueOf(printer1InkUnitsString[color.getColorIndex()]));
                colorUnitsMap.get(color).add(Integer.valueOf(printer2InkUnitsString[color.getColorIndex()]));
                colorUnitsMap.get(color).add(Integer.valueOf(printer3InkUnitsString[color.getColorIndex()]));
            }

            final List<ColorCartridge> minColorCartridges = new ArrayList<>();

            colorUnitsMap
                .entrySet()
                .forEach(colorUnitsEntry -> {
                    minColorCartridges.add(new ColorCartridge(colorUnitsEntry.getKey(), colorUnitsEntry.getValue().stream()
                        .mapToInt(Integer::valueOf).min().getAsInt()));
                });

            if (minColorCartridges.stream().mapToInt(ColorCartridge::getInkUnits).sum() >= MAX_COLOR) {
                Collections.sort(minColorCartridges, (cc1, cc2) -> -Integer.compare(cc1.getInkUnits(), cc2.getInkUnits()));

                int remColor = MAX_COLOR;
                final Map<Color, Integer> colorInkUnitsUsedMap = new HashMap<>();
                colorInkUnitsUsedMap.put(Color.C, 0);
                colorInkUnitsUsedMap.put(Color.M, 0);
                colorInkUnitsUsedMap.put(Color.Y, 0);
                colorInkUnitsUsedMap.put(Color.K, 0);
                for (int index = 0; index < NUMBER_OF_COLORS; index++) {
                    if (remColor <= minColorCartridges.get(index).inkUnits) {
                        colorInkUnitsUsedMap.put(minColorCartridges.get(index).getColor(), remColor);
                        remColor = 0;
                        break;
                    } else {
                        remColor -= minColorCartridges.get(index).inkUnits;
                        colorInkUnitsUsedMap.put(minColorCartridges.get(index).getColor(), minColorCartridges.get(index).inkUnits);
                    }
                }
                if (remColor > 0) {
                    System.out.print(buildImpossibleOutput(i, isTrim));
                } else {
                    System.out.print(
                        buildPossiblePrintOutput(i, colorInkUnitsUsedMap, isTrim));
                }
            } else {
                System.out.print(buildImpossibleOutput(i, isTrim));
            }
        }
        scanner.close();
    }

    /**
     * Builds the impossible output.
     *
     * @param i the i
     * @param isTrim the is trim
     * @return the string
     */
    private static StringBuilder buildImpossibleOutput(final int i, final boolean isTrim) {

        return buildCasePrefix(i)
            .append(IMPOSSIBLE).append(!isTrim ? NEW_LINE : EMPTY);
    }

    /**
     * Builds the possible print output.
     *
     * @param i the i
     * @param colorInkUnitsUsedMap the color ink units used map
     * @param isTrim the is trim
     * @return the string
     */
    private static StringBuilder buildPossiblePrintOutput(final int i, final Map<Color, Integer> colorInkUnitsUsedMap,
            final boolean isTrim) {

        return buildCasePrefix(i)
            .append(colorInkUnitsUsedMap.get(Color.C))
            .append(SPACE)
            .append(colorInkUnitsUsedMap.get(Color.M))
            .append(SPACE)
            .append(colorInkUnitsUsedMap.get(Color.Y))
            .append(SPACE)
            .append(colorInkUnitsUsedMap.get(Color.K))
            .append(!isTrim ? NEW_LINE : EMPTY);
    }

    /**
     * Builds the case prefix.
     *
     * @param i the i
     * @return the string builder
     */
    private static StringBuilder buildCasePrefix(final int i) {

        return new StringBuilder(CASE)
            .append(i)
            .append(COLON)
            .append(SPACE);
    }

    /**
     * The color.
     *
     * @author Subhajoy Laskar
     * @version 1.0
     */
    private enum Color {

        /** The c. */
        C(0),

        /** The m. */
        M(1),

        /** The y. */
        Y(2),

        /** The k. */
        K(3);

        /** The color index. */
        private final int colorIndex;

        /**
         * Instantiates a new color.
         *
         * @param colorIndex the color index
         */
        Color(final int colorIndex) {

            this.colorIndex = colorIndex;
        }

        /**
         * Gets the color index.
         *
         * @return the color index
         */
        int getColorIndex() {

            return colorIndex;
        }

    }

    /**
     * The color cartridge.
     *
     * @author Subhajoy Laskar
     * @version 1.0
     */
    private static final class ColorCartridge {

        /** The color. */
        private final Color color;

        /** The ink units. */
        private final int inkUnits;

        /**
         * Instantiates a new color cartridge.
         *
         * @param color the color
         * @param inkUnits the ink units
         */
        ColorCartridge(final Color color, final int inkUnits) {

            this.color = color;
            this.inkUnits = inkUnits;
        }

        /**
         * Gets the color.
         *
         * @return the color
         */
        Color getColor() {

            return color;
        }

        /**
         * Gets the ink units.
         *
         * @return the inkUnits
         */
        int getInkUnits() {

            return inkUnits;
        }

    }
}
