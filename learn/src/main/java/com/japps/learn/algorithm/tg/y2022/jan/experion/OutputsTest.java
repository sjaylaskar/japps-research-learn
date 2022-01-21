/*
* $Id: OutputsTest.java 21-Jan-2022 3:57:18 pm SubhajoyLaskar $
* Copyright (©) 2022 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.tg.y2022.jan.experion;


/**
 * The OutputsTest.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class OutputsTest {

    public static void main(final String[] args) {

        final B b = new D();
        final A a = b;
        System.out.println(a instanceof A);
        System.out.println(a instanceof B);
        System.out.println(a instanceof C);
        System.out.println(a instanceof D);

    }
}
class A {}
class B extends A {}
class C extends B {}
class D extends C {}
