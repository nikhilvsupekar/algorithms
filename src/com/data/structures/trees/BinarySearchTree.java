package com.data.structures.trees;

public class BinarySearchTree<T> {
    private BinaryTreeNode<T> root;

    public BinarySearchTree() {
        root = null;
    }

    public void addElement(T t) {
        if (root == null) {
            root = new BinaryTreeNode<>(t, null, null);
        } else {
            BinaryTreeNode<T> currentNode = root;

            while (currentNode != null) {
                
            }
        }
    }
}
