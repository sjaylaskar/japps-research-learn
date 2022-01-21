/*
 * $Id: AmountMismatchCounter.java 21-Jan-2022 2:57:29 am SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.hearth.y2022.jan.clervertap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * The AmountMismatchCounter.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class AmountMismatchCounter {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final Scanner scanner = new Scanner(System.in);
        final int n = Integer.parseInt(scanner.nextLine());
        final String[] accountNames = new String[n];
        final int[] dues = new int[n];
        for (int i = 0; i < n; i++) {
            accountNames[i] = scanner.nextLine();
        }
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            dues[i] = Integer.parseInt(scanner.nextLine());
        }
        final int m = Integer.parseInt(scanner.nextLine());
        final String[] accountsPayingByCheques = new String[m];
        final int[] chequeAmounts = new int[m];
        for (int i = 0; i < m; i++) {
            accountsPayingByCheques[i] = scanner.nextLine();
        }
        scanner.nextLine();
        for (int i = 0; i < m; i++) {
            chequeAmounts[i] = Integer.parseInt(scanner.nextLine());
        }
        final int result = countMismatchedPayments(n, accountNames, dues, m, accountsPayingByCheques, chequeAmounts);
        System.out.println(result);

        scanner.close();
    }

    /**
     * Counts the mismatched payments.
     *
     * @param n the n
     * @param accountNames the account names
     * @param dues the dues
     * @param m the m
     * @param accountsPayingByCheques the accounts paying by cheques
     * @param chequeAmounts the cheque amounts
     * @return the mismatched payments
     */
    private static int countMismatchedPayments(final int n, final String[] accountNames, final int[] dues, final int m,
            final String[] accountsPayingByCheques,
            final int[] chequeAmounts) {

        final Map<String, Integer> accountDuesMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            accountDuesMap.put(accountNames[i], dues[i]);
        }
        final Map<String, Integer> accountPaymentsMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            accountPaymentsMap.put(accountsPayingByCheques[i], chequeAmounts[i]);
        }

        return countMismatchedPayments(accountDuesMap, accountPaymentsMap);

    }

    /**
     * Counts the mismatched payments.
     *
     * @param accountDuesMap the account dues map
     * @param accountPaymentsMap the account payments map
     * @return the mismatched payments.
     */
    private static int countMismatchedPayments(final Map<String, Integer> accountDuesMap,
            final Map<String, Integer> accountPaymentsMap) {

        return (int) accountPaymentsMap
            .entrySet()
            .stream()
            .filter(entry -> accountDuesMap.containsKey(entry.getKey())
                && !accountPaymentsMap.get(entry.getKey()).equals(accountDuesMap.get(entry.getKey())))
            .count();
    }
}
