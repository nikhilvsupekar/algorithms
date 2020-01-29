package com.data.structures.lists;

import com.data.exceptions.ListIndexOutOfBoundsException;
import org.junit.Test;

import java.lang.reflect.Array;

import static org.junit.Assert.*;

public class ArrayListTest {
    @Test
    public void setElementByPosition() throws Exception {
        IList<Integer> list = new ArrayList<>();

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
        IList<Integer> list = new ArrayList<>();

        list.addElement(1);
        list.addElement(1);
        list.addElement(1);

        list.clear();

        assertTrue(list.isEmpty());
    }

    @Test
    public void contains() throws Exception {
        IList<Integer> list = new ArrayList<>();

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
        IList<Integer> list = new ArrayList<>();
        assertTrue(list.isEmpty());

        list.addElement(1);
        assertFalse(list.isEmpty());

        list.removeElement(1);
        assertTrue(list.isEmpty());
    }

    @Test
    public void getSize() throws Exception {
        IList<Integer> list = new ArrayList<>();

        assertEquals(0, list.getSize());

        list.addElement(1);

        assertEquals(1, list.getSize());

        list.addElement(2);
        list.addElement(3);

        assertEquals(3, list.getSize());

        list.addElement(3);
        list.addElement(3);
        list.addElement(3);
        list.addElement(3);
        list.addElement(3);
        list.addElement(3);
        list.addElement(3);

        assertEquals(10, list.getSize());
    }

    @Test
    public void addElement() throws ListIndexOutOfBoundsException {
        IList<Integer> list = new ArrayList<>();

        list.addElement(1);
        assertEquals(1, (int)list.getElementByPosition(0));

        list.addElement(2);
        assertEquals(2, (int)list.getElementByPosition(1));

        list.addElement(3);
        assertEquals(3, (int)list.getElementByPosition(2));

        list.addElement(3);
        assertEquals(3, (int)list.getElementByPosition(3));

        list.addElement(3);
        assertEquals(3, (int)list.getElementByPosition(4));

        list.addElement(3);
        assertEquals(3, (int)list.getElementByPosition(5));

        list.addElement(3);
        assertEquals(3, (int)list.getElementByPosition(6));

        list.addElement(3);
        assertEquals(3, (int)list.getElementByPosition(7));

        list.addElement(3);
        assertEquals(3, (int)list.getElementByPosition(8));
    }

    @Test
    public void addElement1() throws ListIndexOutOfBoundsException {
        IList<Integer> list = new ArrayList<>();

        list.addElement(1);
        list.addElement(2);

        list.addElement(3, 1);
        assertEquals(3, (int)list.getElementByPosition(1));

        list.addElement(4, 3);
        assertEquals(4, (int)list.getElementByPosition(3));

        list.addElement(10, 0);
        assertEquals(10, (int)list.getElementByPosition(0));

        list.addElement(11, 5);
        assertEquals(11, (int)list.getElementByPosition(5));

    }

    @Test
    public void removeElement() throws Exception {
        IList<Integer> list = new ArrayList<>();
        list.addElement(1);
        list.addElement(2);

        list.removeElement(2);
        assertEquals(1, list.getSize());

        list.addElement(3);
        list.addElement(4);
        list.addElement(4);
        list.addElement(4);

        list.removeElement(3);
        assertEquals(4, (int)list.getElementByPosition(1));
    }

    @Test
    public void removeElementByPosition() throws Exception {
        IList<Integer> list = new ArrayList<>();
        list.addElement(1);
        list.addElement(2);
        list.addElement(3);

        list.removeElementByPosition(1);
        assertEquals(3, (int)list.getElementByPosition(1));

        list.removeElementByPosition(1);
        assertEquals(1, (int)list.getElementByPosition(0));
    }

    @Test
    public void getElementPosition() throws Exception {
        IList<Integer> list = new ArrayList<>();
        list.addElement(1);
        list.addElement(2);
        list.addElement(3);

        assertEquals(0, list.getElementPosition(1));
        assertEquals(1, list.getElementPosition(2));
        assertEquals(2, list.getElementPosition(3));
    }

    @Test
    public void getElementByPosition() throws Exception {
        IList<Integer> list = new ArrayList<>();

        list.addElement(1);
        assertEquals(1, (int)list.getElementByPosition(0));

        list.addElement(2);
        list.addElement(3);
        assertEquals(3, (int)list.getElementByPosition(2));
    }

    @Test
    public void iterator() {
        IList<Integer> list = new ArrayList<>();

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
}