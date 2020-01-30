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

        if (root_ == null) {
            root_ = insertNode;
        } else {
            BinaryTreeNode<T> current = root_;
            BinaryTreeNode<T> prev = root_;

            while (current != null) {
                prev = current;
                if (t.compareTo(current.value()) < 0) {
                    current = current.left();
                } else if (t.compareTo(current.value()) > 0) {
                    current = current.right();
                } else {
                    return;
                }
            }

            if (t.compareTo(prev.value()) < 0) {
                prev.setLeft(insertNode);
            } else {
                prev.setRight(insertNode);
            }

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
}
