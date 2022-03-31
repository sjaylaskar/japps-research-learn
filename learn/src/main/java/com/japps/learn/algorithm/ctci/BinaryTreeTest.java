/*
* $Id: BinaryTreeTest.java 31-Jan-2022 1:46:16 am SubhajoyLaskar $
* Copyright (©) 2022 Subhajoy Laskar
* https://www.linkedin.com/in/subhajoylaskar
*/
package com.japps.learn.algorithm.ctci;

import static com.japps.learn.util.LogUtil.printLn;

import com.japps.learn.ds.BinaryTree;
import com.japps.learn.ds.BinaryTree.Node;
import com.japps.learn.ds.BinaryTreeOperations;

/**
 * The BinaryTreeTest.
 *
 * @author Subhajoy Laskar
 * @version $Revision: $
 */
public final class BinaryTreeTest {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {


        testBreadthFirstTraversal();
        testDepthFirstTraversal();
        testDepthFirstTraversalRecurse();
        testIsPresentRecurse();
        testIsPresentBFS();
        testTreeSum();
        testTreeMaxValue();
        testTreeMaxRootToLeafPathSum();
    }

    private static void testTreeMaxRootToLeafPathSum() {

        final BinaryTree<Integer> tree = new BinaryTree<>();
        tree.root(new Node<>(2));
        tree.root().left(new Node<>(1));
        tree.root().right(new Node<>(3));
        tree.root().left().left(0);
        tree.root().left().right(6);
        tree.root().left().left().right(4);
        tree.root().left().right().left(5);
        tree.root().right().right(20);
        tree.root().right().right().left(7);

        printLn(tree);

        printLn(BinaryTreeOperations.maxRootToLeafPathSum(tree));

        final BinaryTree<Integer> tree2 = new BinaryTree<>();
        tree2.root(new Node<>(-1));
        tree2.root().left(new Node<>(-6));
        tree2.root().right(new Node<>(-5));
        tree2.root().left().left(-3);
        tree2.root().left().right(0).left(-1);
        tree2.root().right().right(-13).right(-2);

        printLn(tree2);

        printLn(BinaryTreeOperations.maxRootToLeafPathSum(tree2));

    }

    /**
     * Test tree max value.
     */
    private static void testTreeMaxValue() {

        final BinaryTree<Integer> tree = new BinaryTree<>();
        tree.root(new Node<>(1));
        tree.root().left(new Node<>(20));
        tree.root().right(new Node<>(45));
        tree.root().left().left(new Node<>(-20));
        tree.root().left().right(new Node<>(45));
        tree.root().right().left(new Node<>(20));
        tree.root().right().right(new Node<>(45));
        tree.root().right().left().left(new Node<>(20));
        tree.root().right().right().right(new Node<>(45));
        tree.root().right().right().left(new Node<>(205));
        tree.root().right().right().right().right(new Node<>(105));
        tree.root().right().right().left().right(new Node<>(-105));

        printLn(tree);

        printLn(BinaryTreeOperations.treeMaxValueBFS(tree));
        printLn(BinaryTreeOperations.treeMaxValueDFS(tree));

    }

    /**
     * Test tree sum.
     */
    private static void testTreeSum() {

        final BinaryTree<Integer> tree = new BinaryTree<>();
        tree.root(new Node<>(1));
        tree.root().left(new Node<>(20));
        tree.root().right(new Node<>(45));
        tree.root().left().left(new Node<>(-20));
        tree.root().left().right(new Node<>(45));
        tree.root().right().left(new Node<>(20));
        tree.root().right().right(new Node<>(45));
        tree.root().right().left().left(new Node<>(20));
        tree.root().right().right().right(new Node<>(45));

        printLn(tree);

        printLn(BinaryTreeOperations.treeSumRecurse(tree));
        printLn(BinaryTreeOperations.treeSumBFS(tree));

    }

    /**
     * Test is present BFS.
     */
    private static void testIsPresentBFS() {

        final BinaryTree<Character> binaryTree = new BinaryTree<Character>();

        binaryTree.root(new Node<>('a'));
        binaryTree.root().left(new Node<>('b'));
        binaryTree.root().right(new Node<>('c'));
        binaryTree.root().left().left(new Node<>('d'));
        binaryTree.root().left().right(new Node<>('e'));
        binaryTree.root().right().right(new Node<>('f'));

        printLn(BinaryTreeOperations.isPresentBFS(binaryTree, 'b'));
        printLn(BinaryTreeOperations.isPresentBFS(binaryTree, null));
        printLn(BinaryTreeOperations.isPresentBFS(null, 'b'));
        printLn(BinaryTreeOperations.isPresentBFS(binaryTree, 'z'));
        printLn(BinaryTreeOperations.isPresentBFS(binaryTree, 'f'));

    }

    /**
     * Test is present recurse.
     */
    private static void testIsPresentRecurse() {

        final BinaryTree<Character> binaryTree = new BinaryTree<Character>();

        binaryTree.root(new Node<>('a'));
        binaryTree.root().left(new Node<>('b'));
        binaryTree.root().right(new Node<>('c'));
        binaryTree.root().left().left(new Node<>('d'));
        binaryTree.root().left().right(new Node<>('e'));
        binaryTree.root().right().right(new Node<>('f'));

        printLn(BinaryTreeOperations.isPresentRecurse(binaryTree, 'b'));
        printLn(BinaryTreeOperations.isPresentRecurse(binaryTree, null));
        printLn(BinaryTreeOperations.isPresentRecurse(null, 'b'));
        printLn(BinaryTreeOperations.isPresentRecurse(binaryTree, 'z'));
        printLn(BinaryTreeOperations.isPresentRecurse(binaryTree, 'f'));

    }

    /**
     * Test depth first traversal recurse.
     */
    private static void testDepthFirstTraversalRecurse() {

        final BinaryTree<Character> binaryTree = new BinaryTree<Character>();

        binaryTree.root(new Node<>('a'));
        binaryTree.root().left(new Node<>('b'));
        binaryTree.root().right(new Node<>('c'));
        binaryTree.root().left().left(new Node<>('d'));
        binaryTree.root().left().right(new Node<>('e'));
        binaryTree.root().right().right(new Node<>('f'));

        printLn(BinaryTreeOperations.depthFirstValuesRecurse(binaryTree));

    }

    /**
     * Test depth first traversal.
     */
    private static void testDepthFirstTraversal() {

        final BinaryTree<Character> binaryTree = new BinaryTree<Character>();

        binaryTree.root(new Node<>('a'));
        binaryTree.root().left(new Node<>('b'));
        binaryTree.root().right(new Node<>('c'));
        binaryTree.root().left().left(new Node<>('d'));
        binaryTree.root().left().right(new Node<>('e'));
        binaryTree.root().right().right(new Node<>('f'));

        printLn(BinaryTreeOperations.depthFirstValues(binaryTree));

    }

    /**
     * Test breadth first traversal.
     */
    private static void testBreadthFirstTraversal() {

        final BinaryTree<Character> binaryTree = new BinaryTree<Character>();

        binaryTree.root(new Node<>('a'));
        binaryTree.root().left(new Node<>('b'));
        binaryTree.root().right(new Node<>('c'));
        binaryTree.root().left().left(new Node<>('d'));
        binaryTree.root().left().right(new Node<>('e'));
        binaryTree.root().right().right(new Node<>('f'));

        printLn(BinaryTreeOperations.breadthFirstValues(binaryTree));
    }

}
