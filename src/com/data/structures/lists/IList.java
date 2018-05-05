package com.data.structures.lists;

import com.data.exceptions.LinkedListIndexOutOfBoundsException;

public interface IList<T> {

    public int getSize();

    public void addElement(T t);

    public void addElement(T t, int position) throws LinkedListIndexOutOfBoundsException;

    public void removeElement(T t);

    public void removeElementByPosition(int position) throws LinkedListIndexOutOfBoundsException;

    public int getElementPosition(T t);

    public T getElementByPosition(int position) throws LinkedListIndexOutOfBoundsException;

}
