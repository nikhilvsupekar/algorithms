package com.algorithms.sorting;

import com.data.structures.lists.IList;

public class InsertionSort implements SortStrategy {

    @Override
    public <T extends Comparable<T>> void sort(IList<T> iList) {
        if (iList == null || iList.isEmpty() || iList.getSize() == 1) return;

        int length = iList.getSize();

        for (int i = 1; i < length; i++) {
            T key = iList.getElementByPosition(i);

            int j = i - 1;

            while (j >= 0 && key.compareTo(iList.getElementByPosition(j)) < 0) {
                iList.setElementByPosition(iList.getElementByPosition(j), j + 1);
                j--;
            }

            iList.setElementByPosition(key, j + 1);
        }
    }
}
