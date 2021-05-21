/*
* $Id: ComparatorChecker.java 06-Apr-2021 2:52:17 am SubhajoyLaskar $
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.hrank;

import java.util.Scanner;

/**
 * The ComparatorChecker.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
class Comparator {

    public boolean compare(final int a, final int b) {
        return a == b;
    }

    public boolean compare(final String a, final String b) {
        return a.equals(b);
    }

    public boolean compare(final int []a, final int []b) {
        if (a.length != b.length) {
            return false;
        } else {
            for (int i = 0; i < a.length; i++) {
                if (a[i] != b[i]) {
                    return false;
                }
            }
        }

        return true;
    }
}

/**
 * The comparator checker.
 *
 * @author Subhajoy Laskar
 * @version 1.0 $ Revision: $
 */
public class ComparatorChecker {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
        final Scanner scan = new Scanner(System.in);
        final Comparator comp = new Comparator();

        int testCases = Integer.parseInt(scan.nextLine());
        while(testCases-- > 0){
            final int condition = Integer.parseInt(scan.nextLine());
            switch(condition){
                case 1:
                    final String s1=scan.nextLine().trim();
                    final String s2=scan.nextLine().trim();

                    System.out.println( (comp.compare(s1,s2)) ? "Same" : "Different" );
                    break;
                case 2:
                    final int num1 = scan.nextInt();
                    final int num2 = scan.nextInt();

                    System.out.println( (comp.compare(num1,num2)) ? "Same" : "Different");
                    if(scan.hasNext()){ // avoid exception if this last test case
                        scan.nextLine(); // eat space until next line
                    }
                    break;
                case 3:
                    // create and fill arrays
                    final int[] array1 = new int[scan.nextInt()];
                    final int[] array2 = new int[scan.nextInt()];
                    for(int i = 0; i < array1.length; i++){
                        array1[i] = scan.nextInt();
                    }
                    for(int i = 0; i < array2.length; i++){
                        array2[i] = scan.nextInt();
                    }

                    System.out.println( comp.compare(array1, array2) ? "Same" : "Different");
                    if(scan.hasNext()){ // avoid exception if this last test case
                        scan.nextLine(); // eat space until next line
                    }
                    break;
                default:
                    System.err.println("Invalid input.");
            }// end switch
        }// end while
        scan.close();
    }
}