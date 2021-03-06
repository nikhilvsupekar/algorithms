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
     * Perform a level-by-level traversal of the tree
     *
     * @return  List of elements visited level-by-level
     */
    public IList<T> levelorderTraversal();

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

    /**
     * Adds elements in the list to the tree in the order specified
     *
     * @param list  List of elements to be added
     */
    public void addListElements(IList<T> list);

    /**
     * Returns the minimum value in the tree
     *
     * @return      Minimum value
     */
    public T min();

    /**
     * Returns the maximum value in the tree
     *
     * @return      Maximum value
     */
    public T max();

    /**
     * Returns the depth of the tree.
     * Depth is defined as the maximum number of edges in a path between the root and leaves
     *
     * @return  Tree depth
     */
    public Integer depth();

    /**
     * Returns the number of nodes in the tree.
     *
     * @return  Node count
     */
    public Integer nodeCount();

    /**
     * Returns the number of leaves in the tree.
     *
      * @return Leaf count
     */
    public Integer leafCount();

}
