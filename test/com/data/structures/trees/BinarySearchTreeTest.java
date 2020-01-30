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
}