package com.data.structures.lists;

import com.data.exceptions.ListIndexOutOfBoundsException;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayListTest {
    @Test
    public void getSize() throws Exception {
        IList<Integer> list = new ArrayList<>();

        assertEquals(0, list.getSize());

        list.addElement(1);

        assertEquals(1, list.getSize());

        list.addElement(2);
        list.addElement(3);

        assertEquals(3, list.getSize());
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

}