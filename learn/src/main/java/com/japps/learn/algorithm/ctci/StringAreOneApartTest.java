/*
* $Id: StringAreOneApartTest.java 27-Jan-2022 2:37:51 pm SubhajoyLaskar $
* Copyright (©) 2022 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.ctci;

import static com.japps.learn.util.LogUtil.printLn;

/**
 * The StringAreOneApartTest.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class StringAreOneApartTest {

    /**
     * @param args
     */
    public static void main(final String[] args) {
        printLn("StringsAreOneApartChecker.areOneApartOverall(): ");
        printLn(StringsAreOneApartChecker.areDifferentByOneCharacter(null, null));
        printLn(StringsAreOneApartChecker.areDifferentByOneCharacter("", ""));
        printLn(StringsAreOneApartChecker.areDifferentByOneCharacter(null, ""));
        printLn(StringsAreOneApartChecker.areDifferentByOneCharacter("", null));
        printLn(StringsAreOneApartChecker.areDifferentByOneCharacter("pale", "pale"));
        printLn(StringsAreOneApartChecker.areDifferentByOneCharacter("pale", "ale"));
        printLn(StringsAreOneApartChecker.areDifferentByOneCharacter("pales", "pale"));
        printLn(StringsAreOneApartChecker.areDifferentByOneCharacter("pale", "bale"));
        printLn(StringsAreOneApartChecker.areDifferentByOneCharacter("pale", "bake"));
        printLn(StringsAreOneApartChecker.areDifferentByOneCharacter("elap", "ale"));

        printLn("StringsAreOneApartChecker.areOnePartSequentially(): ");
        printLn(StringsAreOneApartChecker.areOnePartSequentially(null, null));
        printLn(StringsAreOneApartChecker.areOnePartSequentially("", ""));
        printLn(StringsAreOneApartChecker.areOnePartSequentially(null, ""));
        printLn(StringsAreOneApartChecker.areOnePartSequentially("", null));
        printLn(StringsAreOneApartChecker.areOnePartSequentially("pale", "pale"));
        printLn(StringsAreOneApartChecker.areOnePartSequentially("pale", "ale"));
        printLn(StringsAreOneApartChecker.areOnePartSequentially("pales", "pale"));
        printLn(StringsAreOneApartChecker.areOnePartSequentially("pale", "bale"));
        printLn(StringsAreOneApartChecker.areOnePartSequentially("pale", "bake"));
        printLn(StringsAreOneApartChecker.areOnePartSequentially("elap", "ale"));

    }

}
