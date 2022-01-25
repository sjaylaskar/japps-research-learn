/*
 * Id: StringUtil.java 01-Jan-2014 01:11:56 am SubhajoyLaskar
 * Copyright (©) 2014 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.util;

import java.util.Arrays;
import java.util.Optional;

import org.apache.commons.lang3.math.NumberUtils;


/**
 * The string util.
 *
 * @author Subhajoy Laskar
 * @version 1.0
 */
public final class StringUtil {

    /**
     * Instantiates a new string util.
     */
    private StringUtil() {

    }

    /**
     * Sort.
     *
     * @param str the string
     * @return the sorted string
     */
    public static String sort(final String str) {

        final char[] strChars = str.toCharArray();
        Arrays.sort(strChars);
        return new String(strChars);
    }


    /**
     * To optional integer.
     *
     * @param c the c
     * @return the optional
     */
    public static Optional<Integer> toOptionalInteger(final char c) {

        final String str = String.valueOf(c);
        return (NumberUtils.isCreatable(str))
                ? Optional.of(Integer.parseInt(str)) : Optional.empty();
    }

    /**
     * To strict int.
     * Assumes that the character c is String-parsable to int.
     *
     * @param c the c
     * @return the int value (not ASCII)
     * @throws NumberFormatException if the character c is not String-parsable to int.
     */
    public static int toStrictInt(final char c) throws NumberFormatException {
        return Integer.parseInt(String.valueOf(c));
    }

}
