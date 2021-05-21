/*
 * $Id: LRUCacheTest.java 25-Mar-2021 1:35:36 am SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.g4g;

/**
 * The LRU cache test.
 *
 * @author Subhajoy Laskar
 * @version 1.0 $Revision: $
 */
public final class LRUCacheTest {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final LRUCache lruCache = LRUCache.instance(5);
        lruCache.display();
        lruCache.refer(new Data("A", 1));
        lruCache.display();
        lruCache.refer(new Data("D", 4));
        lruCache.display();
        lruCache.refer(new Data("B", 2));
        lruCache.display();
        lruCache.refer(new Data("C", 3));
        lruCache.display();
        lruCache.refer(new Data("A", 1));
        lruCache.display();
        lruCache.refer(new Data("B", 2));
        lruCache.display();
        lruCache.refer(new Data("C", 3));
        lruCache.display();
        lruCache.refer(new Data("A", 2));
        lruCache.display();
        lruCache.refer(new Data("A", 1));
        lruCache.display();
        lruCache.refer(new Data("a", 1));
        lruCache.display();

        final LRUCache lruCache2 = LRUCache.instance(1);
        lruCache2.refer(null);
        lruCache2.display();
        lruCache2.refer(new Data("X", 24));
        lruCache2.display();

        lruCache.clear();

        lruCache.display();
        lruCache2.display();
    }
}
