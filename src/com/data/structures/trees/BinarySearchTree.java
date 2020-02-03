package com.data.structures.trees;

import com.algorithms.trees.BinarySearchTreeAlgorithms;
import com.data.structures.lists.IList;

public class BinarySearchTree<T extends Comparable<T>> implements IBinarySearchTree<T>{
    private BinaryTreeNode<T> root_;

    public BinarySearchTree() {
        root_ = null;
    }

    public BinarySearchTree(BinaryTreeNode<T> root_) {
        this.root_ = root_;
    }

    public BinarySearchTree(IList<T> list) {
        addListElements(list);
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
        if (root_ == null) return;

        // node to be deleted is the root node
        if (root_.value().equals(t)) {

            if (!root_.hasChildren()) {
                root_ = null;
            } else if (!root_.hasLeft() && root_.hasRight()) {
                root_ = root_.right();
            } else if (root_.hasLeft() && !root_.hasRight()) {
                root_ = root_.left();
            } else {
                // go rightmost in the left tree
                BinaryTreeNode<T> rightmost = root_.left();
                while (rightmost.right() != null) {
                    rightmost = rightmost.right();
                }
                rightmost.setRight(root_.right());

                root_ = root_.left();
            }

        } else {
            BinaryTreeNode<T> prev = searchLogicalParent(t);

            // element not present in the tree
            if (prev == null) {
                return;
            }

            // indicates whether node is a left child or right child of prev
            boolean positionFlag = prev.left().value().equals(t);
            BinaryTreeNode<T> node = positionFlag ? prev.left() : prev.right();

            // node to be removed is a leaf node
            if (!node.hasChildren()) {
                if (positionFlag) prev.setLeft(null);
                else prev.setRight(null);

            }
            // left child is null but right is not null
            else if (!node.hasLeft() && node.hasRight()) {
                if (positionFlag) prev.setLeft(node.right());
                else prev.setRight(node.right());

            }
            // left child is not null but right is null
            else if (node.hasLeft() && !node.hasRight()){
                if (positionFlag) prev.setLeft(node.left());
                else prev.setRight(node.left());

            }
            // left and right child both not null
            else {

                // go rightmost in the left tree
                BinaryTreeNode<T> rightmost = node.left();
                while (rightmost.right() != null) {
                    rightmost = rightmost.right();
                }
                rightmost.setRight(node.right());

                if (positionFlag) prev.setLeft(node.left());
                else prev.setRight(node.left());
            }
        }
    }

    @Override
    public boolean contains(T t) {
        return searchNode(t) != null;
    }

    @Override
    public boolean isEmpty() {
        return root_ == null;
    }

    @Override
    public IList<T> inorderTraversal() {
        return BinarySearchTreeAlgorithms.inorderTraversal(root_);
    }

    @Override
    public IList<T> preorderTraversal() {
        return BinarySearchTreeAlgorithms.preorderTraversal(root_);
    }

    @Override
    public IList<T> postorderTraversal() {
        return BinarySearchTreeAlgorithms.postorderTraversal(root_);
    }

    @Override
    public IList<T> levelorderTraversal() {
        return BinarySearchTreeAlgorithms.levelOrderTraversal(root_);
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

    @Override
    public void addListElements(IList<T> list) {
        if (list == null) return;

        for (T t : list) {
            add(t);
        }
    }

    @Override
    public T min() {
        return BinarySearchTreeAlgorithms.findMin(root_);
    }

    @Override
    public T max() {
        return BinarySearchTreeAlgorithms.findMax(root_);
    }

    @Override
    public Integer depth() {
        return null;
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
