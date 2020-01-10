package com.data.structures.trees;

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
}
