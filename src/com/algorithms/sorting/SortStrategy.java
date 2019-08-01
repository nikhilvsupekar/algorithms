package com.algorithms.sorting;

import com.data.structures.lists.IList;

/**
 * Interface for Sorting Algorithms
 * All sorting algorithms for arrays and lists must implement this interface
 *
 */
public interface SortStrategy {

    public <T extends Comparable<T>> void sort(IList<T> iList);
}
