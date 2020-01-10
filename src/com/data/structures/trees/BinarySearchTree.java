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
}
