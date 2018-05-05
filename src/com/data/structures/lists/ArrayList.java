package com.data.structures.lists;

import com.data.exceptions.ListIndexOutOfBoundsException;

public class ArrayList<T> implements IList<T> {

    private T[] array;
    private int THRESHOLD_SIZE;


    public ArrayList() {

    }


    @Override
    public int getSize() {
        return array.length;
    }

    @Override
    public void addElement(T t) {

    }

    @Override
    public void addElement(T t, int position) throws ListIndexOutOfBoundsException {

    }

    @Override
    public void removeElement(T t) {

    }

    @Override
    public void removeElementByPosition(int position) throws ListIndexOutOfBoundsException {

    }

    @Override
    public int getElementPosition(T t) {
        return 0;
    }

    @Override
    public T getElementByPosition(int position) throws ListIndexOutOfBoundsException {
        return null;
    }
}
