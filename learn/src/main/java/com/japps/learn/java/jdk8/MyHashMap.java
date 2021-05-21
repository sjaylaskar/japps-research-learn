/*
* $$ Id: MyHashMap.java 07-May-2021 12:51:26 am SubhajoyLaskar $$
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.java.jdk8;

import java.util.Arrays;
import java.util.Objects;
import java.util.TreeSet;

/**
 * The my hash map.
 *
 * @author Subhajoy Laskar
 * @version 1.0 $ Revision: $
 */
public class MyHashMap {


    /** The table rows. */
    private final TableRow[] tableRows;

    /** The mod key. */
    private final int modKey;

    /**
     * Instantiates a new my hash map.
     */
    public MyHashMap() {
        modKey = 929;
        tableRows = new TableRow[modKey];

        Arrays.fill(tableRows, new TableRow());
    }

    /**
     * Hash.
     *
     * @param key the key
     * @return the int
     */
    private int hash(final int key) {
        return Math.abs(key) % modKey;
    }

    /**
     *  value will always be non-negative.
     *
     * @param key the key
     * @param value the value
     */
    public void put(final int key, final int value) {
        tableRows[hash(key)].put(key, value);
    }

    /**
     *  Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
     *
     * @param key the key
     * @return the int
     */
    public int get(final int key) {
        return tableRows[hash(key)].get(key);
    }

    /**
     *  Removes the mapping of the specified value key if this map contains a mapping for the key.
     *
     * @param key the key
     */
    public void remove(final int key) {
        tableRows[hash(key)].remove(key);
    }

    /**
     * The table row.
     *
     * @author Subhajoy Laskar
     * @version 1.0 $ Revision: $
     */
    class TableRow {

        /** The binary search tree. */
        TreeSet<Container> binarySearchTree;

        /**
         * Instantiates a new table row.
         */
        TableRow() {
            binarySearchTree = new TreeSet<>((c1, c2) -> Integer.compare(c1.key, c2.key));
        }

        /**
         * Put.
         *
         * @param key the key
         * @param value the value
         */
        void put(final int key, final int value) {
            final Container existingContainer = find(key);

            if (existingContainer != null) {
                existingContainer.value = value;
            } else {
                binarySearchTree.add(new Container(key, value));
            }
        }

        /**
         * Gets the.
         *
         * @param key the key
         * @return the int
         */
        int get(final int key) {
            final Container container = find(key);
            return (container != null) ? container.value : -1;
        }

        /**
         * Find.
         *
         * @param key the key
         * @return the container
         */
        private Container find(final int key) {
            return binarySearchTree.stream().filter(container -> container.key == key)
                    .findAny().orElse(null);
        }

        /**
         * Removes the.
         *
         * @param key the key
         */
        void remove(final int key) {
            binarySearchTree.remove(new Container(key, -1));
        }

    }

    /**
     * The container.
     *
     * @author Subhajoy Laskar
     * @version 1.0 $ Revision: $
     */
    class Container {

        /** The key. */
        final int key;

        /** The value. */
        int value;

        /**
         * Instantiates a new container.
         *
         * @param key the key
         * @param value the value
         */
        Container(final int key, final int value) {
            this.key = key;
            this.value = value;
        }

        /**
         * Hash code.
         *
         * @return the int
         */
        @Override
        public int hashCode() {

            return Objects.hash(key);
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
            final Container other = (Container) obj;
            return key == other.key;
        }
    }
}