/*
 * $Id: JavaTreeVisitor.java 07-Mar-2021 4:10:38 am SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.hrank.jdk7;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;


/**
 * The java tree visitor.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class TreeVisitor {

    /**
     * Solve.
     *
     * @return the tree
     */
    public static Tree solve() {

        final Scanner scanner = new Scanner(System.in);

        final int numberOfNodes = scanner.nextInt();

        final int[] values = new int[numberOfNodes];

        final Color[] colors = new Color[numberOfNodes];

        final ArrayList<ArrayList<Integer>> edgesList = new ArrayList<>();

        scanAndFillData(scanner, numberOfNodes, values, colors, edgesList);

        return depthFirstSearch(edgesList, values, colors);
    }

    /**
     * Scan and fill data.
     *
     * @param scanner the scanner
     * @param numberOfNodes the number of nodes
     * @param values the values
     * @param colors the colors
     * @param edgesList the edges list
     */
    private static void scanAndFillData(final Scanner scanner, final int numberOfNodes, final int[] values, final Color[] colors,
            final ArrayList<ArrayList<Integer>> edgesList) {

        for (int i = 0; i < numberOfNodes; i++) {
            values[i] = scanner.nextInt();
            edgesList.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < numberOfNodes; i++) {
            colors[i] = (scanner.nextInt() == 0) ? Color.RED : Color.GREEN;
        }

        for (int i = 0; i < numberOfNodes - 1; i++) {
            final int treeNode1 = scanner.nextInt() - 1;
            final int treeNode2 = scanner.nextInt() - 1;
            edgesList.get(treeNode1).add(treeNode2);
            edgesList.get(treeNode2).add(treeNode1);
        }

        scanner.close();
    }

    /**
     * Depth first search.
     *
     * @param edgesList the edges list
     * @param values the values
     * @param colors the colors
     * @return the tree
     */
    private static Tree depthFirstSearch(final ArrayList<ArrayList<Integer>> edgesList, final int[] values, final Color[] colors) {

        final boolean[] isVisited = new boolean[values.length];
        final boolean[] isNode = new boolean[values.length];
        final int[] depth = new int[values.length];
        final int[] parent = new int[values.length];
        final Tree[] nodes = new Tree[values.length];
        final Deque<Integer> stack = new ArrayDeque<Integer>();

        initialize(stack, isVisited, isNode, depth);

        fillNodeDetails(stack, edgesList, isVisited, isNode, depth, parent);

        buildTree(nodes, values, colors, isNode, depth, parent);

        return nodes[0];
    }

    /**
     * Builds the tree.
     *
     * @param nodes the nodes
     * @param values the values
     * @param colors the colors
     * @param isNode the is node
     * @param depth the depth
     * @param parent the parent
     */
    private static void buildTree(final Tree[] nodes, final int[] values, final Color[] colors, final boolean[] isNode,
            final int[] depth, final int[] parent) {

        for (int i = 0; i < values.length; i++) {
             nodes[i] = (isNode[i]) ? new TreeNode(values[i], colors[i], depth[i]) : new TreeLeaf(values[i], colors[i], depth[i]);
        }

        for (int i = 1; i < values.length; i++) {
            final TreeNode current = (TreeNode) nodes[parent[i]];
            current.addChild(nodes[i]);
        }
    }

    /**
     * Fill node details.
     *
     * @param stack the stack
     * @param edgesList the edges list
     * @param isVisited the is visited
     * @param isNode the is node
     * @param depth the depth
     * @param parent the parent
     */
    private static void fillNodeDetails(final Deque<Integer> stack, final ArrayList<ArrayList<Integer>> edgesList,
            final boolean[] isVisited, final boolean[] isNode, final int[] depth, final int[] parent) {

        while (!stack.isEmpty()) {
            final int current = stack.pop();
            for (final Integer element : edgesList.get(current)) {
                final int child = element;
                if (!isVisited[child]) {
                    depth[child] = depth[current] + 1;
                    parent[child] = current;
                    isNode[current] = true;
                    isVisited[child] = true;
                    stack.push(child);
                }
            }
        }
    }

    /**
     * Initialize.
     *
     * @param stack the stack
     * @param isVisited the is visited
     * @param isNode the is node
     * @param depth the depth
     */
    private static void initialize(final Deque<Integer> stack, final boolean[] isVisited, final boolean[] isNode,
            final int[] depth) {

        stack.push(0);
        isVisited[0] = true;
        isNode[0] = true;
        depth[0] = 0;
    }


    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

        final Tree root = solve();
        final SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        final ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        final FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        final int res1 = vis1.getResult();
        final int res2 = vis2.getResult();
        final int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}

/**
 * The color.
 *
 * @author Subhajoy Laskar
 * @version $ Revision: $
 */
enum Color {
    RED, GREEN
}

/**
 * The tree.
 *
 * @author Subhajoy Laskar
 * @version $ Revision: $
 */
abstract class Tree {

    /** The value. */
    private final int value;

    /** The color. */
    private final Color color;

    /** The depth. */
    private final int depth;

    /**
     * Instantiates a new tree.
     *
     * @param value the value
     * @param color the color
     * @param depth the depth
     */
    public Tree(final int value, final Color color, final int depth) {

        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public int getValue() {

        return value;
    }

    /**
     * Gets the color.
     *
     * @return the color
     */
    public Color getColor() {

        return color;
    }

    /**
     * Gets the depth.
     *
     * @return the depth
     */
    public int getDepth() {

        return depth;
    }

    /**
     * Accept.
     *
     * @param visitor the visitor
     */
    public abstract void accept(TreeVis visitor);
}

/**
 * The tree node.
 *
 * @author Subhajoy Laskar
 * @version $ Revision: $
 */
class TreeNode extends Tree {

    /** The children. */
    private final ArrayList<Tree> children = new ArrayList<>();

    /**
     * Instantiates a new tree node.
     *
     * @param value the value
     * @param color the color
     * @param depth the depth
     */
    public TreeNode(final int value, final Color color, final int depth) {

        super(value, color, depth);
    }

    /**
     * Accept.
     *
     * @param visitor the visitor
     */
    @Override
    public void accept(final TreeVis visitor) {

        visitor.visitNode(this);

        for (final Tree child : children) {
            child.accept(visitor);
        }
    }

    /**
     * Adds the child.
     *
     * @param child the child
     */
    public void addChild(final Tree child) {

        children.add(child);
    }
}

/**
 * The tree leaf.
 *
 * @author Subhajoy Laskar
 * @version $ Revision: $
 */
class TreeLeaf extends Tree {

    /**
     * Instantiates a new tree leaf.
     *
     * @param value the value
     * @param color the color
     * @param depth the depth
     */
    public TreeLeaf(final int value, final Color color, final int depth) {

        super(value, color, depth);
    }

    /**
     * Accept.
     *
     * @param visitor the visitor
     */
    @Override
    public void accept(final TreeVis visitor) {

        visitor.visitLeaf(this);
    }
}

/**
 * The tree vis.
 *
 * @author Subhajoy Laskar
 * @version $ Revision: $
 */
abstract class TreeVis {

    /**
     * Gets the result.
     *
     * @return the result
     */
    public abstract int getResult();

    /**
     * Visit node.
     *
     * @param node the node
     */
    public abstract void visitNode(TreeNode node);

    /**
     * Visit leaf.
     *
     * @param leaf the leaf
     */
    public abstract void visitLeaf(TreeLeaf leaf);

}

/**
 * The sum in leaves visitor.
 *
 * @author Subhajoy Laskar
 * @version $ Revision: $
 */
class SumInLeavesVisitor extends TreeVis {

    /** The result. */
    private int result;

    /**
     * Gets the result.
     *
     * @return the result
     */
    @Override
    public int getResult() {

        return result;
    }

    /**
     * Visit node.
     *
     * @param node the node
     */
    @Override
    public void visitNode(final TreeNode node) {

        // implement this
    }

    /**
     * Visit leaf.
     *
     * @param leaf the leaf
     */
    @Override
    public void visitLeaf(final TreeLeaf leaf) {

        result += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {

    /** The result. */
    private long result = 1;

    /** The product modulo. */
    private static final int PRODUCT_MODULO = 1000000007;

    /**
     * Gets the result.
     *
     * @return the result
     */
    @Override
    public int getResult() {

        return (result == 0) ? 1 : (int) result;
    }

    /**
     * Visit node.
     *
     * @param node the node
     */
    @Override
    public void visitNode(final TreeNode node) {

        if (Color.RED.equals(node.getColor())) {
            result = (result * node.getValue()) % PRODUCT_MODULO;
        }
    }

    /**
     * Visit leaf.
     *
     * @param leaf the leaf
     */
    @Override
    public void visitLeaf(final TreeLeaf leaf) {

        if (Color.RED.equals(leaf.getColor())) {
            result = (result * leaf.getValue()) % PRODUCT_MODULO;
        }
    }
}

/**
 * The fancy visitor.
 *
 * @author Subhajoy Laskar
 * @version $ Revision: $
 */
class FancyVisitor extends TreeVis {

    /** The result. */
    private int result;

    /**
     * Gets the result.
     *
     * @return the result
     */
    @Override
    public int getResult() {

        return Math.abs(result);
    }

    /**
     * Visit node.
     *
     * @param node the node
     */
    @Override
    public void visitNode(final TreeNode node) {

        if (node.getDepth() % 2 == 0) {
            result += node.getValue();
        }
    }

    /**
     * Visit leaf.
     *
     * @param leaf the leaf
     */
    @Override
    public void visitLeaf(final TreeLeaf leaf) {

        if (Color.GREEN.equals(leaf.getColor())) {
            result -= leaf.getValue();
        }
    }
}
