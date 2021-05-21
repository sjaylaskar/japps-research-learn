/*
* $Id: TestOutput.java 09-May-2021 2:54:19 am SubhajoyLaskar $
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.hearth.may2021.concentrix;


/**
 * The TestOutput.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class TestOutput {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final Languages ap;

        for (final Languages a : Languages.values()) {
            System.out.println(a + " " + a.getCoders() + " coders.");
        }

    }

    /**
     * The languages.
     *
     * @author Subhajoy Laskar
     * @version 1.0 $ Revision: $
     */
    enum Languages {
        
        /** The Py. */
        Py(10 - 10 + 10 * 10), 
 /** The Java. */
 Java (9 + 9 * 9 - 9), 
 /** The Ang. */
 Ang (12 * 12 - 12 - 12);

        /** The coders. */
        private final int coders;

        /**
         * Instantiates a new languages.
         *
         * @param p the p
         */
        Languages(final int p) {
            coders = p;
        }


        /**
         * Gets the coders.
         *
         * @return the coders
         */
        int getCoders() {

            return coders;
        }
    }
}
