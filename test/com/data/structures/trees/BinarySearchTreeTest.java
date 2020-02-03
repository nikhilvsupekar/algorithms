package com.data.structures.trees;

import com.data.structures.lists.ArrayList;
import com.data.structures.lists.IList;
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

    @Test
    public void inorderTraversal() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(4);
        tree.add(8);
        tree.add(6);
        tree.add(1);

        IList<Integer> traversal = tree.inorderTraversal();
        for (int i = 0; i < 8; i++) {
            assertEquals((Integer) (i + 1), traversal.getElementByPosition(i));
        }

        tree = new BinarySearchTree<>();
        tree.add(3);
        tree.add(7);
        tree.add(9);
        tree.add(12);
        tree.add(100);

        traversal = tree.inorderTraversal();
        assertEquals(traversal.getElementByPosition(0), (Integer) 3);
        assertEquals(traversal.getElementByPosition(1), (Integer) 7);
        assertEquals(traversal.getElementByPosition(2), (Integer) 9);
        assertEquals(traversal.getElementByPosition(3), (Integer) 12);
        assertEquals(traversal.getElementByPosition(4), (Integer) 100);


        tree = new BinarySearchTree<>();
        tree.add(-3);
        tree.add(-7);
        tree.add(-9);
        tree.add(-12);
        tree.add(-100);

        traversal = tree.inorderTraversal();
        assertEquals(traversal.getElementByPosition(4), (Integer) (-3));
        assertEquals(traversal.getElementByPosition(3), (Integer) (-7));
        assertEquals(traversal.getElementByPosition(2), (Integer) (-9));
        assertEquals(traversal.getElementByPosition(1), (Integer) (-12));
        assertEquals(traversal.getElementByPosition(0), (Integer) (-100));
    }

    @Test
    public void preorderTraversal() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(3);
        tree.add(7);
        tree.add(9);
        tree.add(12);
        tree.add(100);

        IList<Integer> traversal = tree.preorderTraversal();
        assertEquals(traversal.getElementByPosition(0), (Integer) 3);
        assertEquals(traversal.getElementByPosition(1), (Integer) 7);
        assertEquals(traversal.getElementByPosition(2), (Integer) 9);
        assertEquals(traversal.getElementByPosition(3), (Integer) 12);
        assertEquals(traversal.getElementByPosition(4), (Integer) 100);

        tree = new BinarySearchTree<>();
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(4);
        tree.add(8);
        tree.add(6);
        tree.add(1);

        traversal = tree.preorderTraversal();
        assertEquals(traversal.getElementByPosition(0), (Integer) 5);
        assertEquals(traversal.getElementByPosition(1), (Integer) 3);
        assertEquals(traversal.getElementByPosition(2), (Integer) 2);
        assertEquals(traversal.getElementByPosition(3), (Integer) 1);
        assertEquals(traversal.getElementByPosition(4), (Integer) 4);
        assertEquals(traversal.getElementByPosition(5), (Integer) 7);
        assertEquals(traversal.getElementByPosition(6), (Integer) 6);
        assertEquals(traversal.getElementByPosition(7), (Integer) 8);
    }

    @Test
    public void postorderTraversal() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
//        tree.add(3);
//        tree.add(7);
//        tree.add(9);
//        tree.add(12);
//        tree.add(100);
//
        IList<Integer> traversal = tree.postorderTraversal();
//        assertEquals(traversal.getElementByPosition(4), (Integer) 3);
//        assertEquals(traversal.getElementByPosition(3), (Integer) 7);
//        assertEquals(traversal.getElementByPosition(2), (Integer) 9);
//        assertEquals(traversal.getElementByPosition(1), (Integer) 12);
//        assertEquals(traversal.getElementByPosition(0), (Integer) 100);

        tree = new BinarySearchTree<>();
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(4);
        tree.add(8);
        tree.add(6);
        tree.add(1);

        traversal = tree.postorderTraversal();
        assertEquals(traversal.getElementByPosition(0), (Integer) 1);
        assertEquals(traversal.getElementByPosition(1), (Integer) 2);
        assertEquals(traversal.getElementByPosition(2), (Integer) 4);
        assertEquals(traversal.getElementByPosition(3), (Integer) 3);
        assertEquals(traversal.getElementByPosition(4), (Integer) 6);
        assertEquals(traversal.getElementByPosition(5), (Integer) 8);
        assertEquals(traversal.getElementByPosition(6), (Integer) 7);
        assertEquals(traversal.getElementByPosition(7), (Integer) 5);
    }

    @Test
    public void addListElements() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        assertTrue(tree.isEmpty());

        tree.add(4);
        assertFalse(tree.isEmpty());

        IList<Integer> list = new ArrayList<>();
        list.addElement(2);
        list.addElement(3);
        list.addElement(5);

        tree.addListElements(list);
        assertFalse(tree.isEmpty());

        BinaryTreeNode<Integer> root = tree.root();
        assertEquals(root.value(), (Integer) 4);
        assertEquals(root.left().value(), (Integer) 2);
        assertEquals(root.right().value(), (Integer) 5);
        assertEquals(root.left().right().value(), (Integer) 3);
    }

    @Test
    public void levelorderTraversal() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(3);
        tree.add(7);
        tree.add(9);
        tree.add(12);
        tree.add(100);

        IList<Integer> traversal = tree.levelorderTraversal();
        assertEquals(traversal.getElementByPosition(0), (Integer) 3);
        assertEquals(traversal.getElementByPosition(1), (Integer) 7);
        assertEquals(traversal.getElementByPosition(2), (Integer) 9);
        assertEquals(traversal.getElementByPosition(3), (Integer) 12);
        assertEquals(traversal.getElementByPosition(4), (Integer) 100);

        tree = new BinarySearchTree<>();
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(4);
        tree.add(8);
        tree.add(6);
        tree.add(1);

        traversal = tree.levelorderTraversal();
        assertEquals(traversal.getElementByPosition(0), (Integer) 5);
        assertEquals(traversal.getElementByPosition(1), (Integer) 3);
        assertEquals(traversal.getElementByPosition(2), (Integer) 7);
        assertEquals(traversal.getElementByPosition(3), (Integer) 2);
        assertEquals(traversal.getElementByPosition(4), (Integer) 4);
        assertEquals(traversal.getElementByPosition(5), (Integer) 6);
        assertEquals(traversal.getElementByPosition(6), (Integer) 8);
        assertEquals(traversal.getElementByPosition(7), (Integer) 1);
    }

    @Test
    public void min() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(3);
        tree.add(7);
        tree.add(9);
        tree.add(12);
        tree.add(100);

        assertEquals(tree.min(), (Integer) 3);

        tree = new BinarySearchTree<>();
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(4);
        tree.add(8);
        tree.add(6);
        tree.add(1);

        assertEquals(tree.min(), (Integer) 1);
    }

    @Test
    public void max() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(3);
        tree.add(7);
        tree.add(9);
        tree.add(12);
        tree.add(100);

        assertEquals(tree.max(), (Integer) 100);

        tree = new BinarySearchTree<>();
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(4);
        tree.add(8);
        tree.add(6);
        tree.add(1);

        assertEquals(tree.max(), (Integer) 8);
    }

    @Test
    public void depth() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(3);
        tree.add(7);
        tree.add(9);
        tree.add(12);
        tree.add(100);

        assertEquals(tree.depth(), (Integer) 4);

        tree = new BinarySearchTree<>();
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(4);
        tree.add(8);
        tree.add(6);
        tree.add(1);

        assertEquals(tree.depth(), (Integer) 3);
    }
}