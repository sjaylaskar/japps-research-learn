/*
* $Id: Test1.java 04-Jan-2022 10:14:37 am SubhajoyLaskar $
* Copyright (©) 2022 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.tg.y2022.jan.nice;


/**
 * The Test1.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public class Test1 {

    static int i = 5;
    static int n;
    int j = 7;
    int k;
    public Test1(final int m) {
        System.out.println(i + ", " + j + ", " + k + ", " + n + ", " + m);
    }
    {
        j = 70;
        n = 20;
    }
    static {
        i = 50;
    }
    public static void main(final String[] args) {

        final Test1 obj = new Test1(n);
        final Test1 obj2 = new Test1(n);
        final Test1 obj3 = new Test1(n);
    }
}
