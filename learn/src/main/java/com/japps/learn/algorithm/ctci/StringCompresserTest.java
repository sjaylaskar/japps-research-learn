/*
* $Id: StringCompresserTest.java 27-Jan-2022 3:53:11 pm SubhajoyLaskar $
* Copyright (©) 2022 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.ctci;

import static com.japps.learn.util.LogUtil.printLn;

/**
 * The StringCompresserTest.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class StringCompresserTest {

    /**
     * @param args
     */
    public static void main(final String[] args) {

        printLn(StringCompresser.compressString(null));

        printLn(StringCompresser.compressString(""));

        printLn(StringCompresser.compressString("a"));

        printLn(StringCompresser.compressString("ab"));

        printLn(StringCompresser.compressString("abab"));

        printLn(StringCompresser.compressString("aaa"));

        printLn(StringCompresser.compressString("abc"));

        printLn(StringCompresser.compressString("abaac"));

        printLn(StringCompresser.compressString("aabcccccaaa"));

    }

}
