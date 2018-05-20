package com.data.structures.trees;

import com.data.structures.lists.IList;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {
    @Test
    public void preOrderTraversal() throws Exception {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.addElement(10);
        tree.addElement(7);
        tree.addElement(3);
        tree.addElement(1);
        tree.addElement(5);
        tree.addElement(9);
        tree.addElement(20);
        tree.addElement(18);
        tree.addElement(19);
        tree.addElement(25);
        tree.addElement(24);

        IList<Integer> pre = tree.preOrderTraversal();

        assertEquals((int)pre.getElementByPosition(0), 10);
        assertEquals((int)pre.getElementByPosition(1), 7);
        assertEquals((int)pre.getElementByPosition(2), 3);
        assertEquals((int)pre.getElementByPosition(3), 1);
        assertEquals((int)pre.getElementByPosition(4), 5);
        assertEquals((int)pre.getElementByPosition(5), 9);
        assertEquals((int)pre.getElementByPosition(6), 20);
        assertEquals((int)pre.getElementByPosition(10), 24);

    }

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