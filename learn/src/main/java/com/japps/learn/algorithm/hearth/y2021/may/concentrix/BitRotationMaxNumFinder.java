/*
 * $Id: BitRotationMaxNumFinder.java 09-May-2021 3:22:03 am SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.hearth.y2021.may.concentrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.ByteBuffer;


/**
 * The bit rotation max num finder.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class BitRotationMaxNumFinder {

    /**
     * The main method.
     *
     * @param args the arguments
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void main(final String[] args) throws IOException {

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final PrintWriter wr = new PrintWriter(System.out);
        final int T = Integer.parseInt(br.readLine().trim());
        for (int t_i = 0; t_i < T; t_i++) {
            final long X = Long.parseLong(br.readLine().trim());
            final int N = Integer.parseInt(br.readLine().trim());
            final String[] arr_A = br.readLine().split(" ");
            final int[] A = new int[N];
            for (int i_A = 0; i_A < arr_A.length; i_A++) {
                A[i_A] = Integer.parseInt(arr_A[i_A]);
            }
            final long out_ = solve(X, N, A);
            System.out.println(out_);
        }
        wr.close();
        br.close();

    }

    /**
     * Solve.
     *
     * @param X the x
     * @param N the n
     * @param A the a
     * @return the long
     */
    private static long solve(final long X, final int N, final int[] A) {

        if (X == 0 || X == Integer.MAX_VALUE) {
            return X;
        }

        final int rotatedNum = (int) X;
        final Byte[] bits = numTo31Bits(rotatedNum);
        long max = X;

        for (final int bitsToMove : A) {
            rotateRight(bits, bits.length, bitsToMove);
            max = Math.max(max, bitsToNum(bits));
        }

        return max;

    }

    /**
     * Bits to num.
     *
     * @param bits the bits
     * @return the int
     */
    private static int bitsToNum(final Byte[] bits) {

        int num = 0;

        for (int i = 0; i < bits.length; i++) {
            num += (bits[i] == 1) ? bits[i] * Math.pow(2, bits.length - 1 - i) : 0;
        }

        return num;
    }

    /**
     * Num to 31 bits.
     *
     * @param n the n
     * @return the byte[]
     */
    private static Byte[] numTo31Bits(int n) {

        final Byte[] bits = new Byte[31];

        int index = 30;

        while (n > 0) {
            bits[index--] = (byte) (n % 2);
            n /= 2;
        }

        return bits;
    }

    /**
     * Right rotate.
     *
     * @param <T> the generic type
     * @param arr the arr
     * @param n the n
     * @param bitsToMove the d
     */
    private static <T> void rotateRight(final T arr[], final int n, int bitsToMove) {

        while (bitsToMove > n) {
            bitsToMove -= n;
        }

        bitsToMove = n - bitsToMove;
        bitsToMove = bitsToMove % n;

        final int gcd = gcd(bitsToMove, n);

        for (int i = 0, j, k; i < gcd; i++) {
            final T temp = arr[i];
            j = i;
            while (true) {
                k = j + bitsToMove;
                if (k >= n) {
                    k -= n;
                }
                if (k == i) {
                    break;
                }
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
    }

    /**
     * Gcd.
     *
     * @param a the a
     * @param b the b
     * @return the gcd
     */
    private static int gcd(final int a, final int b) {

        return (b == 0) ? a : gcd(b,  a % b);
    }

}
