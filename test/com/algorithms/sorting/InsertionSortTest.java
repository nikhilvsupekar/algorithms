package com.algorithms.sorting;

import com.data.structures.lists.ArrayList;
import com.data.structures.lists.IList;
import org.junit.Test;

import static org.junit.Assert.*;

public class InsertionSortTest {

    @Test
    public void sort() {

        IList<Integer> list = new ArrayList<>();

        list.addElement(6);
        list.addElement(1);
        list.addElement(3);
        list.addElement(9);
        list.addElement(2);

        InsertionSort insertionSort = new InsertionSort();

        insertionSort.sort(list);

        assertEquals(list.getElementByPosition(0), new Integer(1));
        assertEquals(list.getElementByPosition(1), new Integer(2));
        assertEquals(list.getElementByPosition(2), new Integer(3));
        assertEquals(list.getElementByPosition(3), new Integer(6));
        assertEquals(list.getElementByPosition(4), new Integer(9));

        insertionSort.sort(null);
        insertionSort.sort(new ArrayList<String>());


        IList<String> stringList = new ArrayList<>();

        stringList.addElement("ang");
        stringList.addElement("xyz");
        stringList.addElement("poewred");
        stringList.addElement("regdfsd");
        stringList.addElement("and");

        insertionSort.sort(stringList);

        assertEquals(stringList.getElementByPosition(0), "and");
        assertEquals(stringList.getElementByPosition(1), "ang");
        assertEquals(stringList.getElementByPosition(2), "poewred");
        assertEquals(stringList.getElementByPosition(3), "regdfsd");
        assertEquals(stringList.getElementByPosition(4), "xyz");
    }
}