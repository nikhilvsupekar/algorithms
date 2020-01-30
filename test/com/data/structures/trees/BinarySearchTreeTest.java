package com.data.structures.trees;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    @Test
    public void add() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        assertTrue(tree.isEmpty());

        tree.add(4);
        assertFalse(tree.isEmpty());

        tree.add(2);
        tree.add(3);
        tree.add(5);
        assertFalse(tree.isEmpty());

        BinaryTreeNode<Integer> root = tree.root();
        assertEquals(root.value(), (Integer) 4);
        assertEquals(root.left().value(), (Integer) 2);
        assertEquals(root.right().value(), (Integer) 5);
        assertEquals(root.left().right().value(), (Integer) 3);
    }

    @Test
    public void root() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        assertNull(tree.root());

        tree.add(4);
        assertNotNull(tree.root());
        assertEquals(tree.root().value(), (Integer) 4);
    }

    @Test
    public void searchNode() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(7);
        tree.add(4);
        tree.add(9);
        tree.add(2);
        tree.add(6);
        tree.add(3);

        BinaryTreeNode<Integer> node = tree.searchNode(7);
        assertEquals(node, tree.root());
        assertEquals(node.left().value(), (Integer) 4);
        assertEquals(node.right().value(), (Integer) 9);

        node = tree.searchNode(2);
        assertEquals(node.right().value(), (Integer) 3);
    }

    @Test
    public void remove() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(7);
        tree.remove(7);
        assertTrue(tree.isEmpty());

        tree.add(7);
        tree.add(4);
        tree.remove(7);
        assertEquals(tree.root().value(), (Integer) 4);
        tree.remove(4);

        tree.add(7);
        tree.add(9);
        tree.remove(7);
        assertEquals(tree.root().value(), (Integer) 9);
        tree.remove(9);

        tree.add(7);
        tree.add(4);
        tree.add(9);
        tree.remove(4);
        assertNull(tree.root().left());
        tree.add(4);

        tree.remove(9);
        assertNull(tree.root().right());
        tree.add(9);

        tree.add(2);
        tree.add(6);
        tree.add(3);
        tree.remove(4);
        assertNotEquals(tree.root().left(), 4);

    }

    @Test
    public void contains() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(7);
        tree.add(4);
        tree.add(9);
        tree.add(8);
        tree.add(2);

        assertTrue(tree.contains(7));
        assertTrue(tree.contains(4));
        assertTrue(tree.contains(2));
        assertFalse(tree.contains(10));
        assertFalse(tree.contains(20));
    }
}