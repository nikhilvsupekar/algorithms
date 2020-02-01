package com.algorithms.trees;

import com.data.structures.lists.ArrayList;
import com.data.structures.lists.IList;
import com.data.structures.trees.BinaryTreeNode;

public class BinarySearchTreeAlgorithms {

    /**
     * Perform an iterative inorder traversal of the tree
     *
     * @return  List of elements visited inorder
     */
    public static <T extends Comparable<T>> IList<T> inorderTraversal(BinaryTreeNode<T> root) {
        return inorderTraversal_recursive(root);
    }

    /**
     * Perform an iterative preorder traversal of the tree
     *
     * @return  List of elements visited preorder
     */
    public static <T extends Comparable<T>> IList<T> preorderTraversal(BinaryTreeNode<T> root) {
        return null;
    }

    /**
     * Perform an iterative postorder traversal of the tree
     *
     * @return  List of elements visited postorder
     */
    public static <T extends Comparable<T>> IList<T> postorderTraversal(BinaryTreeNode<T> root) {
        return null;
    }

    public static <T extends Comparable<T>>
    BinaryTreeNode<T> searchNodeByValue(
            BinaryTreeNode<T> root,
            T value_
    ) {
        if (root == null) return null;

        BinaryTreeNode<T> current = root;

        while (current != null) {
            if (value_.equals(current.value())) {
                return current;
            }

            if (current.value().compareTo(value_) > 0) {
                current = current.left();
            } else {
                current = current.right();
            }
        }

        return null;
    }

    public static <T extends Comparable<T>>
    BinaryTreeNode<T> inorderSuccessor(
            BinaryTreeNode<T> root,
            BinaryTreeNode<T> node
    ) {
        if (root == null || node == null) return null;



        return null;
    }

    /**
     * Perform a recursive inorder traversal of the tree
     *
     * @return  List of elements visited inorder
     */
    public static <T extends Comparable<T>>
    IList<T> inorderTraversal_recursive(BinaryTreeNode<T> node) {
        return genericTraversal_recursive(node, "inorder");
    }

    private static <T extends Comparable<T>>
    IList<T> genericTraversal_recursive(BinaryTreeNode<T> node, String traversalType) {
        IList<T> fullTraversal = new ArrayList<>();
        if (node == null) return null;

        IList<T> leftTraversal = inorderTraversal_recursive(node.left());
        IList<T> rightTraversal = inorderTraversal_recursive(node.right());

        switch (traversalType) {
            case "inorder":
                fullTraversal.addListElements(leftTraversal);
                fullTraversal.addElement(node.value());
                fullTraversal.addListElements(rightTraversal);

                break;

            case "preorder":
                fullTraversal.addElement(node.value());
                fullTraversal.addListElements(leftTraversal);
                fullTraversal.addListElements(rightTraversal);

                break;

            case "postorder":
                fullTraversal.addListElements(leftTraversal);
                fullTraversal.addListElements(rightTraversal);
                fullTraversal.addElement(node.value());

                break;
        }

        return fullTraversal;
    }
}
