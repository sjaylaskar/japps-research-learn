/*
 * $Id: ReachabilityFinder.java 27-Jun-2021 3:16:08 pm SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.hearth.y2021.jun.juspay;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;


/**
 * The ReachabilityFinder.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class ReachabilityFinder {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final Scanner scanner = new Scanner(System.in);

        determineReachability(scanner);

        scanner.close();

    }

    /**
     * Determines the reachability.
     *
     * @param scanner the scanner
     */
    private static void determineReachability(final Scanner scanner) {

        final int n = scanner.nextInt();

        final Map<Integer, Integer> nodeIdMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            nodeIdMap.put(scanner.nextInt(), i);
        }

        final int numberOfEdges = scanner.nextInt();

        final Graph graph = new Graph(n);

        for (int i = 0; i < numberOfEdges; i++) {
            graph.addEdge(nodeIdMap.get(scanner.nextInt()), nodeIdMap.get(scanner.nextInt()));
        }

        System.out.println(determineReachability(graph, nodeIdMap.get(scanner.nextInt()), nodeIdMap.get(scanner.nextInt())));
    }

    /**
     * Determines the reachability.
     *
     * @param graph the graph
     * @param sourceNode the source node
     * @param destinationNode the destination node
     * @return the reachability
     */
    private static int determineReachability(final Graph graph, final int sourceNode, final int destinationNode) {

        return (graph.isReachable(sourceNode, destinationNode)) ? 1 : 0;
    }

    /**
     * The graph.
     *
     * @author Subhajoy Laskar
     * @version 1.0 $ Revision: $
     */
    private static final class Graph {

        /** The number of vertices. */
        private final int numberOfVertices;

        /** The adjacency list. */
        private final LinkedList<Integer> adjacencyList[];

        /**
         * Instantiates a new graph.
         *
         * @param numberOfVertices the number of vertices
         */
        Graph(final int numberOfVertices) {

            this.numberOfVertices = numberOfVertices;
            adjacencyList = new LinkedList[numberOfVertices];
            for (int i = 0; i < numberOfVertices; ++i) {
                adjacencyList[i] = new LinkedList<>();
            }
        }

        /**
         * Adds the edge.
         *
         * @param node1 the node 1
         * @param node2 the node 2
         */
        void addEdge(final int node1, final int node2) {

            adjacencyList[node1].add(node2);
        }

        /**
         * Indicates if is reachable.
         *
         * @param sourceNode the source node
         * @param destinationNode the destination node
         * @return {@code true}, if is reachable
         */
        boolean isReachable(int sourceNode, final int destinationNode) {

            final boolean visited[] = new boolean[numberOfVertices];

            final LinkedList<Integer> bfsQueue = new LinkedList<Integer>();

            visited[sourceNode] = true;
            bfsQueue.add(sourceNode);

            while (bfsQueue.size() != 0) {
                sourceNode = bfsQueue.poll();

                final Iterator<Integer> iterator = adjacencyList[sourceNode].listIterator();

                while (iterator.hasNext()) {
                    final int node = iterator.next();

                    if (node == destinationNode) {
                        return true;
                    }

                    if (!visited[node]) {
                        visited[node] = true;
                        bfsQueue.add(node);
                    }
                }
            }

            return false;
        }
    }
}
