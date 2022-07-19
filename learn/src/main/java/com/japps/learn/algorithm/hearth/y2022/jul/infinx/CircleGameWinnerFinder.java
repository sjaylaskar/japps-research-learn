/*
* Id: CircleGameWinnerFinder.java 17-Jul-2022 4:30:03 am SubhajoyLaskar
* Copyright (©) 2022 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.hearth.y2022.jul.infinx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class CircleGameWinnerFinder {
    public static void main(final String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final PrintWriter wr = new PrintWriter(System.out);
         final int N = Integer.parseInt(br.readLine().trim());
         final String[] arr_A = br.readLine().split(" ");
         final int[] A = new int[N];
         for(int i_A = 0; i_A < arr_A.length; i_A++)
         {
            A[i_A] = Integer.parseInt(arr_A[i_A]);
         }
         final String[] arr_B = br.readLine().split(" ");
         final int[] B = new int[N];
         for(int i_B = 0; i_B < arr_B.length; i_B++)
         {
            B[i_B] = Integer.parseInt(arr_B[i_B]);
         }

         final int out_ = solve(N, A, B);
         System.out.println(out_);

         wr.close();
         br.close();
    }

    private static int solve(final int n, final int[] arrA, final int[] arrB) {
        int currNoOfPlayers = n;
        int currPlayer = 0;
        int eliminatedIndex = (arrB[currPlayer] == 1) ? currPlayer + arrA[currPlayer] % currNoOfPlayers : currNoOfPlayers - arrA[currPlayer] % currNoOfPlayers;
        currPlayer = (arrB[currPlayer] == 1)
                        ? (eliminatedIndex + 1) > currNoOfPlayers - 1
                          ? eliminatedIndex - currNoOfPlayers
                          : eliminatedIndex + 1
                        : (eliminatedIndex - 1) < 0
                          ? currNoOfPlayers + eliminatedIndex
                          : eliminatedIndex - 1;
        int prevElimIndex = eliminatedIndex;
        currNoOfPlayers--;
        while (currNoOfPlayers > 1) {
            eliminatedIndex = (arrB[currPlayer] == 1) ? currPlayer + arrA[currPlayer] % currNoOfPlayers : currPlayer - arrA[currPlayer] % currNoOfPlayers;
            if (eliminatedIndex > currNoOfPlayers - 1) {
                eliminatedIndex -= currNoOfPlayers;
            } else if (eliminatedIndex < 0) {
                eliminatedIndex += currNoOfPlayers;
            }

            if (eliminatedIndex > prevElimIndex) {
                eliminatedIndex--;
            }

            currPlayer = (arrB[currPlayer] == 1)
                    ? (eliminatedIndex + 1) > currNoOfPlayers - 1
                      ? eliminatedIndex - currNoOfPlayers
                      : eliminatedIndex + 1
                    : (eliminatedIndex - 1) < 0
                      ? currNoOfPlayers + eliminatedIndex
                      : eliminatedIndex - 1;

            prevElimIndex = eliminatedIndex;
            currNoOfPlayers--;
        }

        return currPlayer;
    }
}