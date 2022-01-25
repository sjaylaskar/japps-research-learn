/*
 * $Id: Pair.java 26-Mar-2021 10:57:37 pm SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.util;

import java.util.Objects;


/**
 * The pair.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 * @param <U> the generic type
 * @param <V> the value type
 */
public class Pair<U, V> {

    /** The first. */
    private final U first;

    /** The second. */
    private final V second;

    /**
     * Instantiates a new pair.
     *
     * @param first the first
     * @param second the second
     */
    public Pair(final U first, final V second) {

        this.first = first;
        this.second = second;
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {

        return Objects.hash(first, second);
    }

    /**
     * Equals.
     *
     * @param obj the obj
     * @return {@code true}, if successful
     */
    @Override
    public boolean equals(final Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pair other = (Pair) obj;
        return Objects.equals(first, other.first) && Objects.equals(second, other.second);
    }

    /**
     * The first.
     *
     * @return the first
     */
    public U first() {

        return first;
    }

    /**
     * The second.
     *
     * @return the second
     */
    public V second() {

        return second;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {

        return "(" + first + ", " + second + ")";
    }

}
