package com.data.structures.lists;

import com.data.structures.lists.IList;
import com.data.structures.lists.LinkedList;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {
    @Test
    public void setElementByPosition() throws Exception {
        IList<Integer> list = new LinkedList<>();

        list.addElement(1);
        list.addElement(1);
        list.addElement(1);

        list.setElementByPosition(3, 0);
        assertEquals(3, (int)list.getElementByPosition(0));

        list.setElementByPosition(2, 1);
        assertEquals(2, (int)list.getElementByPosition(1));


        list.setElementByPosition(1, 2);
        assertEquals(1, (int)list.getElementByPosition(2));

    }

    @Test
    public void clear() throws Exception {
        IList<Integer> list = new LinkedList<>();

        list.addElement(1);
        list.addElement(1);
        list.addElement(1);

        list.clear();

        assertTrue(list.isEmpty());
    }

    @Test
    public void contains() throws Exception {
        IList<Integer> list = new LinkedList<>();

        list.addElement(1);
        list.addElement(2);
        list.addElement(3);

        assertTrue(list.contains(1));
        assertTrue(list.contains(2));
        assertTrue(list.contains(3));

        assertFalse(list.contains(0));
        assertFalse(list.contains(-1));
        assertFalse(list.contains(4));
    }

    @Test
    public void isEmpty() throws Exception {
        IList<Integer> list = new LinkedList<>();
        assertTrue(list.isEmpty());

        list.addElement(1);
        assertFalse(list.isEmpty());

        list.removeElement(1);
        assertTrue(list.isEmpty());
    }

    @Test
    public void getElementByPosition() throws Exception {

        IList<Integer> list = new LinkedList<>();

        list.addElement(1);
        assertEquals(1, (int)list.getElementByPosition(0));

        list.addElement(2);
        list.addElement(3);
        assertEquals(3, (int)list.getElementByPosition(2));
    }

    @org.junit.Test
    public void getSize() throws Exception {

        IList<Integer> list = new LinkedList<>();

        assertEquals(list.getSize(), 0);

        list.addElement(1);
        list.addElement(2);
        list.addElement(2);
        list.addElement(-4);

        assertEquals(list.getSize(), 4);
    }

    @org.junit.Test
    public void addElement() throws Exception {

        IList<Integer> list = new LinkedList<>();

        list.addElement(1);
        list.addElement(2);

        assertEquals(1, (int)list.getElementByPosition(0));
        assertEquals(2, (int)list.getElementByPosition(1));
    }

    @org.junit.Test
    public void addElement1() throws Exception {

        IList<Integer> list = new LinkedList<>();
        list.addElement(1);
        list.addElement(2);

        list.addElement(3, 1);
        assertEquals(3, (int)list.getElementByPosition(1));

        list.addElement(4, 0);
        assertEquals(4, (int)list.getElementByPosition(0));

        list.addElement(5, 3);
        assertEquals(5, (int)list.getElementByPosition(3));
    }

    @org.junit.Test
    public void removeElement() throws Exception {
        IList<Integer> list = new LinkedList<>();
        list.addElement(1);
        list.addElement(2);

        list.removeElement(2);
        assertEquals(1, list.getSize());

        list.addElement(3);
        list.addElement(4);

        list.removeElement(3);
        assertEquals(4, (int)list.getElementByPosition(1));
    }

    @org.junit.Test
    public void removeElementByPosition() throws Exception {
        IList<Integer> list = new LinkedList<>();
        list.addElement(1);
        list.addElement(2);
        list.addElement(3);

        list.removeElementByPosition(1);
        assertEquals(3, (int)list.getElementByPosition(1));

        list.removeElementByPosition(1);
        assertEquals(1, (int)list.getElementByPosition(0));
    }

    @org.junit.Test
    public void getElementPosition() throws Exception {
        IList<Integer> list = new LinkedList<>();
        list.addElement(1);
        list.addElement(2);
        list.addElement(3);

        assertEquals(0, list.getElementPosition(1));
        assertEquals(1, list.getElementPosition(2));
        assertEquals(2, list.getElementPosition(3));
    }

    @Test
    public void iterator() {
        IList<Integer> list = new LinkedList<>();

        list.addElement(1);
        list.addElement(2);
        list.addElement(3);
        list.addElement(4);
        list.addElement(5);

        int counter = 1;
        for (Integer i : list) {
            assertEquals(i, (Integer)counter++);
        }
    }

    @Test
    public void addListElements() {
        IList<Integer> l1 = new LinkedList<>();
        IList<Integer> l2 = new LinkedList<>();

        l1.addElement(1);
        l1.addElement(2);
        l1.addElement(3);
        l2.addElement(4);
        l2.addElement(5);
        l2.addElement(6);

        l1.addListElements(l2);

        assertEquals(6, l1.getSize());
        assertEquals((Integer) 4, l1.getElementByPosition(3));
        assertEquals((Integer) 5, l1.getElementByPosition(4));
        assertEquals((Integer) 6, l1.getElementByPosition(5));
    }
}