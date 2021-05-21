/*
 * $Id: CountingOnesAfterOperations.java 18-May-2021 12:28:27 am SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.hearth.may2021.cambian;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



/**
 * The counting ones after operations.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class BinaryTransformationOneCounter {

    /**
     * The main method.
     *
     * @param args the arguments
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void main(final String[] args) throws IOException {

        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final PrintWriter printWriter = new PrintWriter(System.out);
        final int n = Integer.parseInt(bufferedReader.readLine().trim());
        final String[] vStrArr = bufferedReader.readLine().split(" ");
        final int[] vArr = new int[n];
        for (int index = 0; index < vStrArr.length; index++) {
            vArr[index] = Integer.parseInt(vStrArr[index]);
        }
        final int x = Integer.parseInt(bufferedReader.readLine().trim());

        final int result = countOnes(n, vArr, x);
        System.out.println(result);

        printWriter.close();
        bufferedReader.close();
    }

    /**
     * Count ones.
     *
     * @param n the n
     * @param vArr the v arr
     * @param x the x
     * @return the int
     */
    private static int countOnes(final int n, int[] vArr, final int x) {

        final int[] arrCopy = new int[n];
        boolean isDeadEnd = false;
        final List<String> arrangements = new ArrayList<>();
        final Set<String> arrangementSet = new HashSet<>();
        final String binaryStringFirst = binaryString(vArr);
        arrangementSet.add(binaryStringFirst);
        arrangements.add(binaryStringFirst);
        for (int op = 1; op <= x; op++) {
            for (int i = 1; i < n - 1; i++) {
                arrCopy[i] = (vArr[i - 1] == vArr[i + 1]) ? 1 : 0;
            }
            vArr = Arrays.copyOf(arrCopy, n);
            final String binaryString = binaryString(vArr);

            if (!arrangementSet.add(binaryString)) {
                break;
            }

            if (binaryString.equals(arrangements.get(op - 1))) {
                isDeadEnd = true;
                break;
            }
            arrangements.add(binaryString);
        }

        return (isDeadEnd)
            ? countOnes(arrangements.get(arrangements.size() - 1))
            : countOnes(arrangements.get(x % arrangements.size()));
    }

    /**
     * Count ones.
     *
     * @param str the str
     * @return the int
     */
    private static int countOnes(final String str) {

        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                result++;
            }
        }
        return result;
    }

    /**
     * Binary string.
     *
     * @param vArr the v arr
     * @return the string
     */
    private static String binaryString(final int[] vArr) {

        String binaryString = "";
        for (final int num : vArr) {
            binaryString += num;
        }

        return binaryString;
    }
}
