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
    private BinaryTreeNode<T> parent_;

    public BinaryTreeNode(T value_) {
        this.value_ = value_;
        this.left_ = null;
        this.right_ = null;
        this.parent_ = null;
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

    public void setParent(BinaryTreeNode<T> parent_) {
        this.parent_ = parent_;
    }

    public void setValue(T value_) {
        this.value_ = value_;
    }

    public boolean hasLeft() {
        return left_ != null;
    }

    public boolean hasRight() {
        return right_ != null;
    }
}
