package com.data.structures.lists;

import com.data.exceptions.ListIndexOutOfBoundsException;

public interface IList<T> {

    public int getSize();

    public void addElement(T t);

    public void addElement(T t, int position) throws ListIndexOutOfBoundsException;

    public void removeElement(T t);

    public void removeElementByPosition(int position) throws ListIndexOutOfBoundsException;

    public int getElementPosition(T t);

    public T getElementByPosition(int position) throws ListIndexOutOfBoundsException;

    public boolean isEmpty();

    public boolean contains(T t);

    public void clear();

    public void setElementByPosition(T t, int position) throws ListIndexOutOfBoundsException;

}
