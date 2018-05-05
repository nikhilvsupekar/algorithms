package com.drivers;

import com.data.exceptions.ListIndexOutOfBoundsException;
import com.data.structures.lists.IList;
import com.data.structures.lists.LinkedList;

public class ListDriver {

    public static void main (String[] args) throws ListIndexOutOfBoundsException {
        IList<Integer> l = new LinkedList<>();
        l.addElement(new Integer(3));
        l.addElement(new Integer(1));
        l.addElement(new Integer(1));
        l.addElement(new Integer(2), 0);

        System.out.println(l.getSize());
    }

}
