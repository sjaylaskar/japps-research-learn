/*
 * $Id: ShortestPathWeightedCyclicGraphFinder.java 27-Jun-2021 4:02:40 pm SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.hearth.jun2021.juspay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


/**
 * The shortest path weighted cyclic graph finder.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class ShortestPathWeightedCyclicGraphFinder {

    /**
     * The max value.
     *
     * @author Subhajoy Laskar
     * @version 1.0 $ Revision: $
     */
    /*
     * private static final int MAX_VALUE = Integer.MAX_VALUE;
     *//**
        * The main method.
        *
        * @param args the arguments
        */
    /*
     * public static void main(final String[] args) {
     * final Scanner scanner = new Scanner(System.in);
     * minCostPath(scanner);
     * scanner.close();
     * }
     *//**
        * Min cost path.
        *
        * @param scanner the scanner
        */

    /*
     * private static void minCostPath(final Scanner scanner) {
     * final int n = scanner.nextInt();
     * final Map<Integer, Integer> nodeIdMap = new HashMap<>();
     * for (int i = 0; i < n; i++) {
     * nodeIdMap.put(scanner.nextInt(), i);
     * }
     * final int numberOfEdges = scanner.nextInt();
     * final int graph[][] = new int[n][n];
     * for (int i = 0; i < n; i++) {
     * Arrays.fill(graph[i], MAX_VALUE);
     * }
     * for (int i = 0; i < numberOfEdges; i++) {
     * graph[nodeIdMap.get(scanner.nextInt())][nodeIdMap.get(scanner.nextInt())] = scanner.nextInt();
     * }
     * System.out.println(minCostPath(nodeIdMap.get(scanner.nextInt()), nodeIdMap.get(scanner.nextInt()), new boolean[n], graph));
     * }
     *//**
        * Min cost path.
        *
        * @param source the source
        * @param destination the destination
        * @param visited the visited
        * @param graph the graph
        * @return the int
        *//*
           * private static int minCostPath(final int source, final int destination,
           * final boolean visited[],
           * final int graph[][]) {
           * if (source == destination) {
           * return 0;
           * }
           * visited[source] = true;
           * int minCost = MAX_VALUE;
           * for (int i = 0; i < visited.length; i++) {
           * if (graph[source][i] != MAX_VALUE && !visited[i]) {
           * final int cost = minCostPath(i,
           * destination, visited, graph);
           * if (cost < MAX_VALUE) {
           * minCost = Math.min(minCost, graph[source][i] + cost);
           * }
           * }
           * }
           * visited[source] = false;
           * return minCost;
           * }
           */
    // =========================================Dijkstras=====================================//
    private static final class Pair {

        /** The first. */
        int first;

        /** The second. */
        int second;

        /**
         * Instantiates a new pair.
         *
         * @param first the first
         * @param second the second
         */
        Pair(final int first, final int second) {

            this.first = first;
            this.second = second;
        }
    }

    /** The max value. */
    private static final int MAX_VALUE = Integer.MAX_VALUE;

    /**
     * The node.
     *
     * @author Subhajoy Laskar
     * @version 1.0 $ Revision: $
     */
    private static final class Node {

        /** The vertex number. */
        int vertexNumber;

        /** The children. */
        List<Pair> children;

        /**
         * Instantiates a new node.
         *
         * @param vertexNumber the vertex number
         */
        Node(final int vertexNumber) {

            this.vertexNumber = vertexNumber;
            children = new ArrayList<>();
        }

        /**
         * Adds the child.
         *
         * @param vertexNumber the v number
         * @param length the length
         */
        void addChild(final int vertexNumber, final int length) {

            final Pair p = new Pair(vertexNumber, length);
            children.add(p);
        }
    }

    /**
     * Compute dijkstras distance.
     *
     * @param nodes the nodes
     * @param source the source
     * @param path the path
     * @return the distance matrix
     */
    private static int[] computeDijkstrasDistance(final List<Node> nodes,
            final int source, final int[] path) {

        final int[] distance = new int[nodes.size()];

        final boolean[] visited = new boolean[nodes.size()];

        for (int i = 0; i < nodes.size(); i++) {
            path[i] = -1;
            distance[i] = MAX_VALUE;
        }

        distance[source] = 0;
        path[source] = -1;

        int currentNode = source;

        final Set<Integer> nodeSet = new HashSet<>();
        while (true) {

            visited[currentNode] = true;
            for (final Pair element : nodes.get(currentNode).children) {
                final int vertex = element.first;

                if (visited[vertex]) {
                    continue;
                }

                nodeSet.add(vertex);
                final int pathDistance = distance[currentNode] + element.second;

                if (pathDistance < distance[vertex]) {
                    distance[vertex] = pathDistance;
                    path[vertex] = currentNode;
                }
            }
            nodeSet.remove(currentNode);

            if (nodeSet.isEmpty()) {
                break;
            }

            int minDistance = MAX_VALUE;
            int index = 0;

            for (final int node : nodeSet) {
                if (distance[node] < minDistance) {
                    minDistance = distance[node];
                    index = node;
                }
            }
            currentNode = index;
        }
        return distance;
    }

    /**
     * Min cost path.
     *
     * @param scanner the scanner
     */
    private static void minCostPath(final Scanner scanner) {

        final int n = scanner.nextInt();

        final Map<Integer, Integer> nodeIdMap = new HashMap<>();

        final List<Node> nodes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            nodeIdMap.put(scanner.nextInt(), i);
            nodes.add(new Node(i));
        }

        final int numberOfEdges = scanner.nextInt();

        for (int i = 0; i < numberOfEdges; i++) {
            nodes.get(nodeIdMap.get(scanner.nextInt())).addChild(nodeIdMap.get(scanner.nextInt()), scanner.nextInt());
        }

        final int[] path = new int[n];

        final int[] distance = computeDijkstrasDistance(nodes, nodeIdMap.get(scanner.nextInt()), path);

        System.out.println(distance[nodeIdMap.get(scanner.nextInt())]);
    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final Scanner scanner = new Scanner(System.in);

        minCostPath(scanner);

        scanner.close();
    }
}
