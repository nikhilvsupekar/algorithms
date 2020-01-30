package com.data.structures.trees;

import com.data.structures.lists.IList;

public class BinarySearchTree<T extends Comparable<T>> implements IBinarySearchTree<T>{
    private BinaryTreeNode<T> root_;

    public BinarySearchTree() {
        root_ = null;
    }

    public BinarySearchTree(BinaryTreeNode<T> root_) {
        this.root_ = root_;
    }

    @Override
    public void add(T t) {
        BinaryTreeNode<T> insertNode = new BinaryTreeNode<>(t);
        BinaryTreeNode<T> prev = searchLogicalParent(t);
        insertNode.setParent(prev);

        if (prev == null) {
            root_ = insertNode;
            return;
        }

        if (t.compareTo(prev.value()) < 0) {
            prev.setLeft(insertNode);
        } else {
            prev.setRight(insertNode);
        }

    }

    @Override
    public void remove(T t) {

    }

    @Override
    public boolean contains(T t) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return root_ == null;
    }

    @Override
    public IList<T> inorderTraversal() {
        return null;
    }

    @Override
    public IList<T> preorderTraversal() {
        return null;
    }

    @Override
    public IList<T> postorderTraversal() {
        return null;
    }

    @Override
    public BinaryTreeNode<T> root() {
        return root_;
    }

    @Override
    public BinaryTreeNode<T> searchNode(T t) {
        if (root_ == null) return null;
        if (root_.value().equals(t)) return root_;

        BinaryTreeNode<T> current = root_;

        while (current != null) {
            if (t.compareTo(current.value()) < 0) {
                current = current.left();
            } else if (t.compareTo(current.value()) > 0) {
                current = current.right();
            } else {
                break;
            }
        }

        return current;
    }

    private BinaryTreeNode<T> searchLogicalParent(T t) {
        if (root_ == null) return null;
        if (root_.value().equals(t)) return null;

        BinaryTreeNode<T> current = root_;
        BinaryTreeNode<T> prev = null;

        while (current != null) {
            if (t.compareTo(current.value()) < 0) {
                prev = current;
                current = current.left();
            } else if (t.compareTo(current.value()) > 0) {
                prev = current;
                current = current.right();
            } else {
                break;
            }
        }

        return prev;
    }
}
