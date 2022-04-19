/*
* $Id: TestOutputStringMatch.java 09-May-2021 3:08:58 am SubhajoyLaskar $
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.hearth.y2021.may.concentrix;


/**
 * The TestOutputStringMatch.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class TestOutputStringMatch {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final String regex = ".@.";
        compare("Hacker@Earth.com", regex);
        compare("a@N", regex);
        compare("Java@Program", regex);

    }

    /**
     * Compare.
     *
     * @param str the str
     * @param regex the regex
     */
    private static void compare(final String str, final String regex) {
        if (str.matches(regex)) {
            System.out.println(str + " matches");
        } else {
            System.out.println(str + " does not match");
        }
    }

}
