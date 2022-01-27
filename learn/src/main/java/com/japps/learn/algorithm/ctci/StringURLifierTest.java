/*
* $Id: StringURLifierTest.java 27-Jan-2022 1:33:22 pm SubhajoyLaskar $
* Copyright (©) 2022 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.ctci;

import static com.japps.learn.util.LogUtil.printLn;

/**
 * The StringURLifierTest.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class StringURLifierTest {

    /**
     * @param args
     */
    public static void main(final String[] args) {
        printLn(StringURLifier.urlify("My name is John Smith            "));

    }

}
