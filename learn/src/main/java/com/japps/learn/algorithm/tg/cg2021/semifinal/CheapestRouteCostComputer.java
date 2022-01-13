/*
* $$ Id: CheapestRouteCostComputer.java 06-Jul-2021 4:31:06 am SubhajoyLaskar $$
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.tg.cg2021.semifinal;

/*
* $$ Id: CheapestRouteCostComputer.java 06-Jul-2021 3:14:40 am SubhajoyLaskar $$
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
import java.util.Scanner;

/**
 * The cheapest route cost computer.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class CheapestRouteCostComputer {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final int r = scanner.nextInt();

        final int[][] graph = new int[n][n];

        boolean isNotPossibleSourcePrimaryCheck = true;
        boolean isNotPossibleTargetPrimaryCheck = true;
        for (int i = 0; i < r; i++) {
            final int vertex1 = scanner.nextInt();
            final int vertex2 = scanner.nextInt();
            if (vertex1 == 1 || vertex2 == 1) {
                isNotPossibleSourcePrimaryCheck = false;
            }
            if (vertex1 == n || vertex2 == n) {
                isNotPossibleTargetPrimaryCheck = false;
            }
            final int pathCost = scanner.nextInt();
            graph[vertex1 - 1][vertex2 - 1] = pathCost;
            graph[vertex2 - 1][vertex1 - 1] = pathCost;
        }

        final int dijkstrasDistance = isNotPossiblePrimaryCheck(isNotPossibleSourcePrimaryCheck, isNotPossibleTargetPrimaryCheck) ? -1 : dijkstra(graph, 0, n);
        System.out.println((-1 != dijkstrasDistance) ? dijkstrasDistance : "NOT POSSIBLE");

        scanner.close();
    }

    /**
     * Indicates if is not possible primary check.
     *
     * @param isNotPossibleSourcePrimaryCheck the is not possible source primary check
     * @param isNotPossibleTargetPrimaryCheck the is not possible target primary check
     * @return {@code true}, if is not possible primary check
     */
    private static boolean isNotPossiblePrimaryCheck(final boolean isNotPossibleSourcePrimaryCheck,
            final boolean isNotPossibleTargetPrimaryCheck) {

        return isNotPossibleSourcePrimaryCheck || isNotPossibleTargetPrimaryCheck;
    }

    /**
     * Find minimum distance vertex.
     *
     * @param distance the distance
     * @param shortestPathTree the shortest path tree
     * @param numberOfVertices the number of vertices
     * @return the minimum distance vertex
     */
    private static int findMinimumDistanceVertex(final int distance[],
            final boolean shortestPathTree[], final int numberOfVertices) {

        int minimumDistance = Integer.MAX_VALUE;
        int minimumDistanceVertexIndex = -1;

        for (int vertexIndex = 0; vertexIndex < numberOfVertices; vertexIndex++) {
            if (shortestPathTree[vertexIndex] == false && distance[vertexIndex] <= minimumDistance) {
                minimumDistance = distance[vertexIndex];
                minimumDistanceVertexIndex = vertexIndex;
            }
        }

        return minimumDistanceVertexIndex;
    }

    /**
     * Dijkstra.
     *
     * @param graph the graph
     * @param source the src
     * @param numberOfVertices the number of vertices
     * @return the dijkstra distance
     */
    private static int dijkstra(final int graph[][], final int source, final int numberOfVertices) {

        final int[] distance = new int[numberOfVertices];

        final boolean[] shortestPathTree = new boolean[numberOfVertices];

        final int[] parent = new int[numberOfVertices];

        for (int i = 0; i < numberOfVertices; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        distance[source] = 0;

        parent[source] = -1;

        for (int count = 0; count < numberOfVertices - 1; count++) {
            final int minimumDistanceVertex = findMinimumDistanceVertex(distance, shortestPathTree, numberOfVertices);

            shortestPathTree[minimumDistanceVertex] = true;

            for (int vertexIndex = 0; vertexIndex < numberOfVertices; vertexIndex++) {
                if (!shortestPathTree[vertexIndex]
                    && graph[minimumDistanceVertex][vertexIndex] != 0
                    && distance[minimumDistanceVertex] != Integer.MAX_VALUE) {
                    final int dijkstrasDistance = Math.max(distance[minimumDistanceVertex], graph[minimumDistanceVertex][vertexIndex]);
                    if (dijkstrasDistance < distance[vertexIndex]) {
                        parent[vertexIndex] = minimumDistanceVertex;
                        distance[vertexIndex] = dijkstrasDistance;
                    }
                }
            }
        }

        return determineDistance(numberOfVertices - 1, parent, distance, graph);
    }

    /**
     * Determines the distance.
     *
     * @param targetVertex the target vertex
     * @param parent the parent
     * @param distance the distance
     * @param graph the graph
     * @return the distance
     */
    private static int determineDistance(final int targetVertex, final int[] parent, final int[] distance, final int[][] graph) {

        if (Integer.MAX_VALUE == distance[targetVertex]) {
            return -1;
        }

        int node = targetVertex;
        int pathDistance = Integer.MIN_VALUE;

        while (true) {
            if (parent[node] == -1) {
                break;
            }
            pathDistance = Math.max(pathDistance, graph[parent[node]][node]);
            node = parent[node];
        }

        return pathDistance;
    }

}
