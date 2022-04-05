/*
* $Id: Test.java 06-Apr-2022 2:58:06 am SubhajoyLaskar $
* Copyright (©) 2022 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.tg.y2022.apr.epam;


/**
 * The Test.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class Test {

    /**
     * @param args
     */
    public static void main(final String[] args) {
        final Object o = new Object() {
            @Override
            public boolean equals(final Object obj) {
                return true;
            }
        };
        System.out.println(o.equals("test"));
    }

}
