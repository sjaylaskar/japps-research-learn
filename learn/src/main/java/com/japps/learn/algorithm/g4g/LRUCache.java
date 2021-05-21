/*
 * $Id: LRUCache.java 25-Mar-2021 1:02:21 am SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.g4g;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Objects;



/**
 * The LRU cache.
 *
 * @author Subhajoy Laskar
 * @version 1.0 $ Revision: $
 */
public final class LRUCache {

    /** The cache. */
    private static LRUCache CACHE;

    /** The data store. */
    private final LinkedHashSet<Data> dataStore;

    /** The cache size. */
    private final int CACHE_SIZE;

    /** The LRU cache display name. */
    private static final String LRU_CACHE_DISPLAY_NAME = "LRUCache:";

    /** The space. */
    private static final String SPACE = " ";

    /**
     * Instantiates a new LRU cache.
     *
     * @param size the size
     */
    private LRUCache(final int size) {

        CACHE_SIZE = size;
        dataStore = new LinkedHashSet<Data>(CACHE_SIZE);
    }

    /**
     * Instance.
     *
     * @param size the size of the cache
     * @return the LRU cache
     */
    public static LRUCache instance(final int size) {

        if (CACHE == null) {
            CACHE = new LRUCache(size);
        }

        return CACHE;
    }

    /**
     * Refer to cache for data.
     *
     * @param data the data
     * @return the data
     */
    public Data refer(final Data data) {

        if (data == null) {
            return null;
        }

        final Data cachedData = fetch(data);

        return (cachedData == null)
            ? push(data)
            : cachedData;
    }

    /**
     * Fetches the data.
     *
     * @param data the data
     * @return the data
     */
    private Data fetch(final Data data) {

        if (!contains(data)) {
            return null;
        }
        dataStore.remove(data);
        dataStore.add(data);

        return data;
    }

    /**
     * Checks if the data is contained in the data store.
     *
     * @param data the data
     * @return {@code true}, if successful
     */
    private boolean contains(final Data data) {

        return dataStore.contains(data);
    }

    /**
     * Pushes the data.
     *
     * @param data the data
     * @return the data
     */
    private Data push(final Data data) {

        if (CACHE_SIZE == size()) {
            dataStore.remove(dataStore.iterator().next());
        }
        dataStore.add(data);

        return data;
    }

    /**
     * The size of the datastore.
     *
     * @return the size
     */
    private int size() {

        return dataStore.size();
    }

    /**
     * Clear the cache.
     */
    public void clear() {
        dataStore.clear();
    }

    /**
     * Display.
     */
    public void display() {

        System.out.print(LRU_CACHE_DISPLAY_NAME);
        if (dataStore == null || dataStore.isEmpty()) {
            System.out.println(" is empty.");
        } else {
            displayData();
        }
    }

    /**
     * Display data.
     */
    private void displayData() {

        System.out.println();
        new LinkedList<>(dataStore)
            .descendingIterator()
            .forEachRemaining(data -> displayData(data));
        System.out.println();
    }

    /**
     * Prints the data.
     *
     * @param data the data
     */
    private void displayData(final Data data) {

        System.out.print(data + SPACE);
    }
}

/**
 * The data.
 *
 * @author Subhajoy Laskar
 * @version $ Revision: $
 */
final class Data {

    /** The name. */
    private final String name;

    /** The value. */
    private final int value;

    /**
     * Instantiates a new data.
     *
     * @param name the name
     * @param value the value
     */
    public Data(final String name, final int value) {

        this.name = name;
        this.value = value;
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, value);
    }

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
        final Data other = (Data) obj;
        return Objects.equals(name, other.name) && value == other.value;
    }

    @Override
    public String toString() {

        return new StringBuilder()
            .append("(")
            .append(name)
            .append(", ")
            .append(value)
            .append(")")
            .toString();
    }

}
