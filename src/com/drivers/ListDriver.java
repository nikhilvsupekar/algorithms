package com.drivers;

import com.data.structures.IList;
import com.data.structures.LinkedList;

public class ListDriver {

    public static void main (String[] args) {
        IList<Integer> l = new LinkedList<>();
        l.addElement(new Integer(1));
        l.addElement(new Integer(2));
        l.addElement(new Integer(2));

        System.out.println(l.getSize());
    }

}
