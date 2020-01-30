package com.data.structures.trees;

import com.data.structures.lists.IList;

/**
 * Interface for Binary Search Trees
 *
 * @param <T> a comparable generic type
 */
public interface IBinarySearchTree<T extends Comparable<T>> {

    /**
     * Add element to the tree
     *
     * @param t   A generic element to be added to the tree
     */
    public void add(T t);

    /**
     * Remove element from the tree
     *
     * @param t   A generic element to be removed from the tree
     */
    public void remove(T t);

    /**
     * Check if an element is present in the tree
     *
     * @param t   A generic element to be searched in the tree
     */
    public boolean contains(T t);

    /**
     * Check if the tree is empty
     *
     * @return   true if the tree is empty, false otherwise
     */
    public boolean isEmpty();

    /**
     * Perform an iterative inorder traversal of the tree
     *
     * @return  List of elements visited inorder
     */
    public IList<T> inorderTraversal();

    /**
     * Perform an iterative preorder traversal of the tree
     *
     * @return  List of elements visited preorder
     */
    public IList<T> preorderTraversal();

    /**
     * Perform an iterative postorder traversal of the tree
     *
     * @return  List of elements visited postorder
     */
    public IList<T> postorderTraversal();

    /**
     * Returns the root of the tree
     *
     * @return  A BinaryTreeNode reference to the root
     */
    public BinaryTreeNode<T> root();

    /**
     * Returns a reference to the node containing the element
     *
     * @param t     Element to search in the BST
     * @return      Reference to the element to be searched
     */
    public BinaryTreeNode<T> searchNode(T t);

}
