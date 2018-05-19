package com.data.structures.trees;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {
    @Test
    public void removeElement() throws Exception {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.addElement(7);
        tree.addElement(2);
        tree.addElement(8);
        tree.addElement(1);
        tree.addElement(5);
        tree.addElement(10);

        tree.removeElement(5);
    }

    @Test
    public void addElement() throws Exception {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.addElement(7);
        tree.addElement(2);
        tree.addElement(8);
        tree.addElement(1);
        tree.addElement(5);
        tree.addElement(10);
    }

}