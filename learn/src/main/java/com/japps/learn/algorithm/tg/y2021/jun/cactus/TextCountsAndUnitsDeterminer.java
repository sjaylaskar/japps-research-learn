/*
 * $Id: TextCountsAndUnitsDeterminer.java 06-Jun-2021 2:12:18 am SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.tg.y2021.jun.cactus;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/**
 * The text counts and units determiner.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class TextCountsAndUnitsDeterminer {

    /** The none. */
    private static final String NONE = "NONE";

    /** The space. */
    private static final String SPACE = " ";

    /** The unit of measure. */
    private static final String UNIT_OF_MEASURE = "Unit of Measure";

    /** The counts measure. */
    private static final String COUNTS_MEASURE = "Counts";

    /** The regex decimal. */
    // private static final String REGEX_DECIMAL = "[+-]?[0-9]+(\\\\.[0-9]+)?([Ee][+-]?[0-9]+)?";
    private static final String REGEX_DECIMAL = "[0-9.]";

    /** The regex alphabet. */
    private static final String REGEX_ALPHABET = "[a-zA-Z]";

    /** The regex non alpha. */
    private static final String REGEX_NON_ALPHA_SPACE_DIGIT_SLASH = "[^a-zA-Z0-9/\\s]";

    /** The counts. */
    private static final Set<String> COUNTS = new HashSet<>();

    static {
        COUNTS.add("groups");
        COUNTS.add("students");
        COUNTS.add("people");
        COUNTS.add("persons");
        COUNTS.add("images");
        COUNTS.add("boys");
        COUNTS.add("girls");
        COUNTS.add("birds");
        COUNTS.add("animals");
        COUNTS.add("dogs");
        COUNTS.add("tables");
        COUNTS.add("chairs");
        COUNTS.add("bats");
        COUNTS.add("cats");
        COUNTS.add("rats");
        COUNTS.add("shoes");
        COUNTS.add("sandals");
        COUNTS.add("games");
        COUNTS.add("runs");
        COUNTS.add("passes");
        COUNTS.add("cubes");
        COUNTS.add("squares");
        COUNTS.add("triangles");
        COUNTS.add("things");
        COUNTS.add("times");
        COUNTS.add("beds");
        COUNTS.add("cars");
        COUNTS.add("bikes");
        COUNTS.add("cycles");
        COUNTS.add("things");

    }

    /** The units. */
    private static final Set<String> UNITS = new HashSet<>();

    static {
        UNITS.add("metre");
        UNITS.add("m");
        UNITS.add("centimeter");
        UNITS.add("cm");
        UNITS.add("millimeter");
        UNITS.add("kilogram");
        UNITS.add("kg");
        UNITS.add("gram");
        UNITS.add("g");
        UNITS.add("pound");
        UNITS.add("lb");
        UNITS.add("fl. oz.");
        UNITS.add("mmol/L");
        UNITS.add("pixels");
        UNITS.add("foot");
        UNITS.add("ft");
        UNITS.add("inch");
        UNITS.add("in");
        UNITS.add("cubic foot");
        UNITS.add("square meter");
        UNITS.add("sq. m");
        UNITS.add("cubic centimeter");
        UNITS.add("cubic cm");
        UNITS.add("cubic meter");
        UNITS.add("cubic m");
        UNITS.add("newton");
        UNITS.add("n");
        UNITS.add("m/s");
        UNITS.add("meter per second");
        UNITS.add("meters per second");
        UNITS.add("kilometer per hour");
        UNITS.add("kilometers per hour");
        UNITS.add("km/hr");
        UNITS.add("km/h");
        UNITS.add("kmph");
        UNITS.add("mph");
        UNITS.add("second");
        UNITS.add("sec");
        UNITS.add("hour");
        UNITS.add("h");
        UNITS.add("minute");
        UNITS.add("min");
        UNITS.add("litre");
        UNITS.add("l");
        UNITS.add("millilitre");
        UNITS.add("ml");
        UNITS.add("centrigrade");
        UNITS.add("celcius");
        UNITS.add("fahrenheit");
        UNITS.add("f");
        UNITS.add("c");
        UNITS.add("pascal");
        UNITS.add("ampere");
        UNITS.add("a");
        UNITS.add("volt");
        UNITS.add("v");
        UNITS.add("kilovolt");
        UNITS.add("kv");
        UNITS.add("nm");
        UNITS.add("mw/cm2");
        UNITS.add("mv");
        UNITS.add("ev");
        UNITS.add("jones");

    }

    /**
     * The main method.
     *
     * @param args the arguments
     * @throws Exception the exception
     */
    public static void main(final String args[]) throws Exception {

        final Scanner scanner = new Scanner(System.in);
        final String text = scanner.nextLine();
        scanner.close();
        determineCountsAndUnitsOfMeasure(text);

    }

    /**
     * Determines the counts and units of measure.
     *
     * @param text the text
     */
    private static void determineCountsAndUnitsOfMeasure(final String text) {

        boolean isPresent = false;
        if (text != null && text.length() > 0) {
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) >= 48 && text.charAt(i) <= 57) {
                    final String scientificText = text.substring(i, (text.length() - i > 50) ? (i + 50) : text.length());
                    final String[] entities = process(scientificText);
                    if (entities[1].length() > 0) {
                        System.out.println(entities[0] + "," + "[" + i + "," + (i + entities[0].length()) + "]," + entities[1]);
                        isPresent = true;
                        i += entities[0].length();
                    }
                }
            }
        }
        if (!isPresent) {
            System.out.println(NONE);
        }

    }

    /**
     * Process.
     *
     * @param scientificText the scientific text
     * @return the string[]
     */
    private static String[] process(final String scientificText) {

        final String[] subTexts = scientificText.split(" ");

        final String subTextFirst = subTexts[0].replaceAll(REGEX_DECIMAL, "");

        String entity = subTexts[0];

        String entityType = "";

        boolean isEntityTypeSet = false;

        final StringBuilder textToSearch = new StringBuilder();
        final StringBuilder originalTextToSearch = new StringBuilder();
        for (int i = 0; i < ((subTexts.length > 4) ? 4 : subTexts.length); i++) {
            final String measureString = (i != 0) ? subTexts[i] : subTextFirst;
            if (measureString.length() > 0) {
                textToSearch.append(SPACE).append(measureString.toLowerCase());
                originalTextToSearch.append(SPACE).append(measureString);
                final String textToSearchLowerCase = textToSearch.toString().replaceAll(REGEX_NON_ALPHA_SPACE_DIGIT_SLASH, "");
                if (!isEntityTypeSet && UNITS.contains(textToSearchLowerCase.trim())) {
                    entity += (i == 0) ? "" : SPACE + originalTextToSearch.toString().replaceAll(REGEX_NON_ALPHA_SPACE_DIGIT_SLASH, "").trim();
                    entityType = UNIT_OF_MEASURE;
                    isEntityTypeSet = true;
                    break;
                } else if (!isEntityTypeSet && COUNTS.contains(textToSearchLowerCase.trim())) {
                    entity += (i == 0) ? "" : SPACE + originalTextToSearch.toString().trim().replaceAll(REGEX_NON_ALPHA_SPACE_DIGIT_SLASH, "");
                    entityType = COUNTS_MEASURE;
                    isEntityTypeSet = true;
                    break;
                }
            }
        }

        return new String[] {entity.trim(), entityType};

    }
}
