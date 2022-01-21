/*
* $Id: OutputsTest.java 19-Jan-2022 1:25:20 pm SubhajoyLaskar $
* Copyright (©) 2022 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.java.common;

/**
 * The OutputsTest.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class OutputsTest {

    /**
     * @param args
     */
    public static void main(final String[] args) {
        testStrings();
        System.out.println("return testTryCatchFinally1(): " + testTryCatchFinally1());
        System.out.println("return testTryCatchFinally2(): " + testTryCatchFinally2());
    }

    // OUTPUT:
    private static int testTryCatchFinally1() {
        try {
          System.out.println(1);
          return 1;
        } catch (final Exception e) {
           System.out.println(2);
           return 2;
        } finally {
           System.out.println(3);
           return 3;
        }
        // Compilation error: Unreachable code.
        //System.out.println(4);
        // return 4;
    }

    // OUTPUT:
    private static int testTryCatchFinally2() {
        try {
          throw new RuntimeException("1");
        } catch (final Exception e) {
           System.out.println(2);
           return 2;
        } finally {
           System.out.println(3);
           return 3;
        }
    }

    // OUTPUT:
    private static void testStrings() {
      final String s1 = "abc";
      final String s2 = new String("abc");
      final String s3 = s1;

      System.out.println( s1 == s2 );
      System.out.println( s1.equals(s2) );
      System.out.println( s1 == s3 );
      System.out.println( s1.equals(s3) );
      System.out.println( s2 == s3 );
      System.out.println( s3.equals(s2) );
    }

}
