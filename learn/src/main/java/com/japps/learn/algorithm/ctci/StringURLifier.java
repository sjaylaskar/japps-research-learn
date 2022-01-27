/*
 * $Id: StringURLifier.java 27-Jan-2022 1:31:57 pm SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.ctci;

/**
 * The StringURLifier.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class StringURLifier {

    /**
     * Urlify.
     *
     * @param s the s
     * @return the string
     */
    public static String urlify(final String s) {

        final int trueLength = calcTrueLength(s);

        int spaceCount = 0;
        for (int i = 0; i < trueLength; i++) {
            if (s.charAt(i) == ' ') {
                spaceCount++;
            }
        }
        int index = trueLength + spaceCount * 2;
        final char[] sChars = s.toCharArray();
        if (trueLength < sChars.length) {
            sChars[trueLength] = '\0';
        }
        for (int i = trueLength - 1; i >= 0; i--) {
            if (sChars[i] == ' ') {
                sChars[index - 1] = '0';
                sChars[index - 2] = '2';
                sChars[index - 3] = '%';
                index -= 3;
            } else {
                sChars[index - 1] = sChars[i];
                index--;
            }
        }
        return new String(sChars);
    }

    /**
     * Calc true length.
     *
     * @param s the s
     * @return the int
     */
    private static int calcTrueLength(final String s) {

        int len = s.length();
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                break;
            }
            len--;
        }
        return len;
    }

}
