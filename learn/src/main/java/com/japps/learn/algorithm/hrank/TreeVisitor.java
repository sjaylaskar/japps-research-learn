/*
 * $Id: JavaTreeVisitor.java 07-Mar-2021 4:10:38 am SubhajoyLaskar $
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.hrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;


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

        final int n = scanner.nextInt();

        final int[] values = new int[n];

        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
        }

        final int[] colors = new int[n];

        for (int i = 0; i < n; i++) {
            colors[i] = scanner.nextInt();
        }

        final TreeMap<Integer, Set<Integer>> edges = new TreeMap<>();

        for (int i = 0; i < n - 1; i++) {
            final int parentNodeNumber = scanner.nextInt();
            if (!edges.containsKey(parentNodeNumber)) {
                edges.put(parentNodeNumber, new HashSet<>());
            }
            edges.get(parentNodeNumber).add(scanner.nextInt());
        }

        final TreeNode treeRootNode = buildTree(values, colors, edges);

        scanner.close();

        return treeRootNode;
    }

    /**
     * Builds the tree.
     *
     * @param values the values
     * @param colors the colors
     * @param edges the edges
     * @return the tree node
     */
    private static TreeNode buildTree(final int[] values, final int[] colors, final TreeMap<Integer, Set<Integer>> edges) {

        final TreeNode treeRootNode = new TreeNode(values[0], (colors[0] == 0) ? Color.RED : Color.GREEN, 0);

        final Map<Integer, TreeNode> treeNodes = new HashMap<>();

        edges.forEach((parentNodeNumber, childNodeNumbers) -> {
            if (parentNodeNumber == 1) {
                treeNodes.put(1, treeRootNode);
            }
            childNodeNumbers.forEach(childNodeNumber -> {
                if (edges.containsKey(childNodeNumber)) {
                    final TreeNode treeNode = (treeNodes.containsKey(childNodeNumber))
                                                             ? treeNodes.get(childNodeNumber)
                                                             : new TreeNode(values[childNodeNumber - 1],
                                                                            (colors[childNodeNumber - 1] == 0)
                                                                             ? Color.RED
                                                                             : Color.GREEN,
                                                                             treeNodes.get(parentNodeNumber).getDepth() + 1);
                    treeNodes.get(parentNodeNumber).addChild(treeNode);
                    treeNodes.putIfAbsent(childNodeNumber, treeNode);
                } else {
                    treeNodes.get(parentNodeNumber).addChild(new TreeLeaf(values[childNodeNumber - 1], (colors[childNodeNumber - 1] == 0) ? Color.RED
                        : Color.GREEN, treeNodes.get(parentNodeNumber).getDepth() + 1));
                }
            });
        });
        return treeRootNode;
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

        return (result == 0) ? 1 : (int)(result % PRODUCT_MODULO);
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
