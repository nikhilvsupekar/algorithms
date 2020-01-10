package com.data.structures.trees;

/**
 * Generic data structure for a node in a Binary Tree
 *
 * @param <T>
 */
public class BinaryTreeNode<T extends Comparable<T>> {
    private T value_;
    private BinaryTreeNode<T> left_;
    private BinaryTreeNode<T> right_;

    public BinaryTreeNode(T value_) {
        this.value_ = value_;
    }

    public BinaryTreeNode<T> left() {
        return left_;
    }

    public BinaryTreeNode<T> right() {
        return right_;
    }

    public T value() {
        return value_;
    }

    public void setLeft(BinaryTreeNode<T> left_) {
        this.left_ = left_;
    }

    public void setRight(BinaryTreeNode<T> right_) {
        this.right_ = right_;
    }

    public void setValue(T value_) {
        this.value_ = value_;
    }
}
