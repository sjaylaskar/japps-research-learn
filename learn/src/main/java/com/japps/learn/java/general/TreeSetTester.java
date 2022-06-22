/*
 * $Id: TreeSetTester.java 22-Jun-2022 4:18:57 pm SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.java.general;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.TreeSet;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * The TreeSetTester.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class TreeSetTester {

    /**
     * @param args
     */
    public static void main(final String[] args) {

        final TreeSet<ComparablePerson> comparablePersons = new TreeSet<ComparablePerson>(
            Comparator.comparing(ComparablePerson::getName));

        comparablePersons.addAll(Arrays.asList(
            new ComparablePerson(1, "B", 3),
            new ComparablePerson(3, "A", 2),
            new ComparablePerson(2, "C", 1),
            new ComparablePerson(1, "X", 5),
            new ComparablePerson(6, "B", 7),
            new ComparablePerson(7, "Z", 3)));

        System.out.println(comparablePersons);
        System.out.println(comparablePersons.size());
    }

}

class ComparablePerson implements Comparable<ComparablePerson> {

    private final int id;

    private final String name;

    private final int extn;

    @Override
    public String toString() {

        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

    /**
     * @param id
     * @param name
     * @param extn
     */
    ComparablePerson(final int id, final String name, final int extn) {

        this.id = id;
        this.name = name;
        this.extn = extn;
    }

    /**
     * @return the id
     */
    int getId() {

        return id;
    }

    /**
     * @return the name
     */
    String getName() {

        return name;
    }

    /**
     * @return the extn
     */
    int getExtn() {

        return extn;
    }

    // @Override
    @Override
    public int compareTo(final ComparablePerson other) {

        return Integer.compare(id, other.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(extn);
    }

    @Override
    public boolean equals(final Object obj) {

        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        final ComparablePerson other = (ComparablePerson) obj;
        return extn == other.extn;
    }
}

class ComparablePersonNameComparator implements Comparator<ComparablePerson> {

    @Override
    public int compare(final ComparablePerson o1, final ComparablePerson o2) {

        return o1.getName().compareTo(o2.getName());
    }

}
