/*
 * $Id: StringBalanceChecker.java 06-Apr-2021 2:14:51 am SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.hrank;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;


/**
 * The string balance checker.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class StringBalanceChecker {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final Parser parser = new Parser();

        final Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            System.out.println(parser.isBalanced(scanner.next()));
        }

        scanner.close();
    }

}

class Parser {

    /*
     * public boolean isBalanced(final String str) {
     * if (str == null || str == "") {
     * return true;
     * }
     * final String[] strChars = str.split("");
     * if ("}".equals(strChars[0])
     * || ")".equals(strChars[0])
     * ) {
     * return false;
     * }
     * int countOfOpenCurlyBrace = 0;
     * int countOfClosedCurlyBrace = 0;
     * int countOfOpenBracket = 0;
     * int countOfClosedBracket = 0;
     * for (final String strChar : strChars) {
     * switch (strChar) {
     * case "{":
     * countOfOpenCurlyBrace++;
     * break;
     * case "}":
     * countOfClosedCurlyBrace++;
     * break;
     * case "(":
     * countOfOpenBracket++;
     * break;
     * case ")":
     * countOfClosedBracket++;
     * break;
     * }
     * }
     * return (countOfOpenCurlyBrace == countOfClosedCurlyBrace
     * && countOfOpenBracket == countOfClosedBracket);
     * }
     */

    public boolean isBalanced(final String str) {

        if ((str.length() % 2) == 1) {
            return false;
        } else {
            final Deque<Character> stack = new ArrayDeque<>();
            for (final char strChar : str.toCharArray()) {
                switch (strChar) {
                case '{':
                    stack.push('}');
                    break;
                case '(':
                    stack.push(')');
                    break;
                default:
                    if (stack.isEmpty() || strChar != stack.peek()) {
                        return false;
                    }
                    stack.pop();
                }
            }
            return stack.isEmpty();
        }
    }
}
