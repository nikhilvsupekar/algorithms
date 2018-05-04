package com.drivers;

import com.data.exceptions.LinkedListIndexOutOfBoundsException;
import com.data.structures.IList;
import com.data.structures.LinkedList;

public class ListDriver {

    public static void main (String[] args) throws LinkedListIndexOutOfBoundsException {
        IList<Integer> l = new LinkedList<>();
        l.addElement(new Integer(1));
        l.addElement(new Integer(1));
        l.addElement(new Integer(1));
        l.addElement(new Integer(2), 0);

        System.out.println(l.getSize());
    }

}
