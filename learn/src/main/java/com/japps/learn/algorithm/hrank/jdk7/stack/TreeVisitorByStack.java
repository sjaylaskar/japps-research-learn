/*
* $Id: TreeVisitorByStack.java 02-Apr-2021 12:56:49 pm SubhajoyLaskar $
* Copyright (©) 2021 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.hrank.jdk7.stack;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * The TreeVisitorByStack.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public class TreeVisitorByStack {

    /**
     * Solve.
     *
     * @return the tree
     */
    private static Tree solve() {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final Tree[] nodes = new Tree[n];
        final boolean[] isNode = new boolean[n];
        final int[] depth = new int[n];
        final int[] value = new int[n];
        final Color[] color = new Color[n];
        final int[] parent = new int[n];
        final boolean[] isVisited = new boolean[n];
        final ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) { adj.add(new ArrayList<Integer>()); }
        for (int i = 0; i < n; i++) { value[i] = scanner.nextInt(); }
        for (int i = 0; i < n; i++) { color[i] = (scanner.nextInt() == 0) ? Color.RED : Color.GREEN; }
        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt(); int v = scanner.nextInt();
            u--; v--;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        scanner.close();

        // Perform a DFS
        final Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        isVisited[0] = true;
        isNode[0] = true;
        depth[0] = 0;
        while (!stack.empty()) {
            final int current = stack.pop();
            for (final Integer element : adj.get(current)) {
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

        for (int i = 0; i < n; i++) {
            if (isNode[i]) {
                nodes[i] = new TreeNode(value[i], color[i], depth[i]);
            } else {
                nodes[i] = new TreeLeaf(value[i], color[i], depth[i]);
            }
        }

        for (int i = 1; i < n; i++) {
            final TreeNode current = (TreeNode) nodes[parent[i]];
            current.addChild(nodes[i]);
        }

        return nodes[0];
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

class SumInLeavesVisitor extends TreeVis {
    private int result = 0;

    @Override
    public int getResult() {
        return result;
    }

    @Override
    public void visitNode(final TreeNode node) {
        //implement this
    }

    @Override
    public void visitLeaf(final TreeLeaf leaf) {
        result += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private final int M = 1000000007;
    private long result = 1;
    @Override
    public int getResult() {
        return (int) result;
    }

    @Override
    public void visitNode(final TreeNode node) {
        if (node.getColor() == Color.RED) {
            result = (result * node.getValue()) % M;
        }
    }

    @Override
    public void visitLeaf(final TreeLeaf leaf) {
        if (leaf.getColor() == Color.RED) {
            result = (result * leaf.getValue()) % M;
        }
    }
}

class FancyVisitor extends TreeVis {
    private int countGreen = 0;
    private int countNonLeaf = 0;
    @Override
    public int getResult() {
        return Math.abs(countNonLeaf - countGreen);
    }

    @Override
    public void visitNode(final TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            countNonLeaf += node.getValue();
        }
    }

    @Override
    public void visitLeaf(final TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) {
            countGreen += leaf.getValue();
        }
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