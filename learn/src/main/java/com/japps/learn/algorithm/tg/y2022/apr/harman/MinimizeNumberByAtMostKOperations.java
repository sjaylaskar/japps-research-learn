/*
* $Id: MinimizeNumberByAtMostKOperations.java 27-Apr-2022 12:41:37 am SubhajoyLaskar $
* Copyright (©) 2022 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.tg.y2022.apr.harman;

import java.util.Scanner;

/**
 * The MinimizeNumberByAtMostKOperations.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class MinimizeNumberByAtMostKOperations {

    /**
     * The main method.
     *
     * @param args the arguments
     * @throws Exception the exception
     */
    public static void main(final String args[] ) throws Exception {

        final Scanner scanner = new Scanner(System.in);

        final int n = scanner.nextInt();
        scanner.nextLine();
        final String l = scanner.nextLine();
        final int k = scanner.nextInt();

        System.out.println(minNumber(l.length(), l.toCharArray(), k));

        scanner.close();

   }

   /**
    * Min number.
    *
    * @param n the n
    * @param lChars the l chars
    * @param k the k
    * @return the string
    */
   private static String minNumber(final int n, final char[] lChars,  int k) {
       if (n == 0 || k == 0) {
           return new String(lChars);
       }

       if (n == 1 && k > 0) {
           return "0";
       }

       if (lChars[0] != '1') {
           lChars[0] = '1';
           --k;
       }

       for (int i = 1; k > 0 && i < n; i++) {
            if (lChars[i] != '0') {
                lChars[i] = '0';
                --k;
           }
       }

       return new String(lChars);
   }
}
