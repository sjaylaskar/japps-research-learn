/*
 * $Id: StreamTest.java 25-Jan-2022 1:18:34 pm SubhajoyLaskar $
 * Copyright (©) 2022 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.java.common;

import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;


/**
 * The StreamTest.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class StreamTest {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
        Arrays.asList(new Person[] {
            new Person("a", Arrays.asList(new Identifiers[] {new Identifiers(1, "p1id1"), new Identifiers(2, "p1id2"), new Identifiers(3, "p1id3"), new Identifiers(4, "p1id4"), new Identifiers(5, "p1id5")})),
            new Person("b", Arrays.asList(new Identifiers[] {new Identifiers(1, "p2id1"), new Identifiers(2, "p2id2"), new Identifiers(3, "p2id3"), new Identifiers(4, "p2id4"), new Identifiers(5, "p2id5")})),
            new Person("c", Arrays.asList(new Identifiers[] {new Identifiers(1, "p3id1"), new Identifiers(3, null), new Identifiers(4, "p3id4"), new Identifiers(5, "p3id5")})),
            new Person("d", Arrays.asList(new Identifiers[] {new Identifiers(1, "p4id1"), new Identifiers(2, "p4id2"), new Identifiers(3, "p4id3"), new Identifiers(4, "p4id4"), new Identifiers(5, "p4id5")})),
            new Person("e", Arrays.asList(new Identifiers[] {new Identifiers(1, "p5id1"), null, new Identifiers(3, "p5id3"), new Identifiers(4, "p5id4"), new Identifiers(5, "p5id5")})),
            new Person("f", Arrays.asList(new Identifiers[] {new Identifiers(1, "p6id1"), new Identifiers(2, "p6id2"), new Identifiers(3, "p6id3"), new Identifiers(4, "p6id4"), new Identifiers(5, "p6id5")})),
            new Person("g", Arrays.asList(new Identifiers[] {new Identifiers(1, "p7id1"), new Identifiers(2, "p7id2"), null, new Identifiers(4, "p7id4"), new Identifiers(5, "p7id5")})),
            new Person("h", Arrays.asList(new Identifiers[] {new Identifiers(8, "p8id1"), new Identifiers(8, null)})),
            new Person("i", Arrays.asList(new Identifiers[] {new Identifiers(9, "9id1")})),
            new Person("j", Arrays.asList(new Identifiers[] {new Identifiers(1, "p10id1"), new Identifiers(-1, "p10id2"), new Identifiers(3, "p10id3"), new Identifiers(4, "p10id4"), null})),
            null,
            new Person(null, Arrays.asList(new Identifiers[] {new Identifiers(1, "12id1")})),
        })
        .stream()
        .filter(person -> person != null && StringUtils.isNotBlank(person.name) && CollectionUtils.isNotEmpty(person.identifiers))
        .map(Person::getIdentifiers)
        .flatMap(Collection::stream)
        .filter(identifier -> identifier != null && identifier.id >= 1 && StringUtils.isNotBlank(identifier.name))
        .forEach(System.out::println);
    }

    /**
     * The person.
     *
     * @author Subhajoy Laskar
     * @version 1.0
     */
    private static final class Person {

        /** The name. */
        private final String name;

        /** The identifiers. */
        private final Collection<Identifiers> identifiers;

        /**
         * Instantiates a new person.
         *
         * @param name the name
         * @param identifiers the identifiers
         */
        Person(final String name, final Collection<Identifiers> identifiers) {

            this.name = name;
            this.identifiers = identifiers;
        }

        /**
         * To string.
         *
         * @return the string
         */
        @Override
        public String toString() {

            return "Person [name=" + name + ", identifiers=" + identifiers + "]";
        }


        String getName() {

            return name;
        }


        Collection<Identifiers> getIdentifiers() {

            return identifiers;
        }



    }

    /**
     * The identifiers.
     *
     * @author Subhajoy Laskar
     * @version 1.0
     */
    private static final class Identifiers {

        /** The id. */
        private final int id;

        /** The name. */
        private final String name;

        /**
         * Instantiates a new identifiers.
         *
         * @param id the id
         * @param name the name
         */
        Identifiers(final int id, final String name) {

            this.id = id;
            this.name = name;
        }

        /**
         * To string.
         *
         * @return the string
         */
        @Override
        public String toString() {

            return "Identifiers [id=" + id + ", name=" + name + "]";
        }

    }
}
