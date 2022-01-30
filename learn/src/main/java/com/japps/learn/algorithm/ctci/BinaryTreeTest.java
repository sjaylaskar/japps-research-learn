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
     * @param args
     */
    public static void main(final String[] args) {


        testBreadthFirstTraversal();
        testDepthFirstTraversal();
        testDepthFirstTraversalRecurse();
        testIsPresentRecurse();
        testIsPresentBFS();
    }

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
