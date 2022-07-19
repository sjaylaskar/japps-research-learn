/*
* Id: RepeatedArraySortedIndexifier.java 17-Jul-2022 3:14:10 am SubhajoyLaskar
* Copyright (©) 2022 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.hearth.y2022.jul.infinx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class RepeatedArraySortedIndexifier {
    public static void main(final String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final PrintWriter wr = new PrintWriter(System.out);
         final String[] str = br.readLine().split(" ");
         final int N = Integer.parseInt(str[0]);
         final long X = Long.parseLong(str[1]);
         final String[] arr_arr = br.readLine().split(" ");
         final int[] arr = new int[N];
         for(int i_arr = 0; i_arr < arr_arr.length; i_arr++)
         {
            arr[i_arr] = Integer.parseInt(arr_arr[i_arr]);
         }
         final int Q = Integer.parseInt(br.readLine().trim());
         final String[] arr_pos = br.readLine().split(" ");
         final long[] pos = new long[Q];
         for(int i_pos = 0; i_pos < arr_pos.length; i_pos++)
         {
            pos[i_pos] = Long.parseLong(arr_pos[i_pos]);
         }

         final int[] out_ = can(N, X, arr, Q, pos);
         System.out.print(out_[0]);
         for(int i_out_ = 1; i_out_ < out_.length; i_out_++)
         {
            System.out.print(" " + out_[i_out_]);
         }

         wr.close();
         br.close();
    }

    private static int[] can(final int n, final long x, final int[] arr, final int q, final long[] pos) {

        final int[] result = new int[q];

        final List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toSet()).stream().sorted().collect(Collectors.toList());

        final Map<Integer, Long> frequencyMap = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        final List<Long> frequencyList = new ArrayList<>();
        frequencyList.add(frequencyMap.get(arrList.get(0)) * x);
        for (int i = 1; i < arrList.size(); i++) {
            frequencyList.add(frequencyList.get(i - 1) + frequencyMap.get(arrList.get(i)) * x);
        }

        int resultIndex = -1;
        for (final long index : pos) {
            int arrIndex = Collections.binarySearch(frequencyList, index);
            if (arrIndex < 0) {
                arrIndex = (arrIndex * -1) - 1;
            }
            result[++resultIndex] = arrList.get(arrIndex);
        }

        return result;
    }
}