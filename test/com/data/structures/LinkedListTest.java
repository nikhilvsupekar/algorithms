package com.data.structures;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {
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

}