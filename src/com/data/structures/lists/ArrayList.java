package com.data.structures.lists;

import com.data.exceptions.ListIndexOutOfBoundsException;
import sun.awt.image.ImageWatched;

public class ArrayList<T> implements IList<T> {

    private Object[] array;
    private int THRESHOLD_SIZE = 5;
    private int arrayPointer;

    public ArrayList() {
        array = new Object[THRESHOLD_SIZE];
        THRESHOLD_SIZE = 5;
        arrayPointer = -1;
    }


    private void resizeArray(boolean expand) {

        if (expand) {
            THRESHOLD_SIZE *= 2;
        } else {
            THRESHOLD_SIZE /= 2;
        }

        Object[] tempArray = new Object[THRESHOLD_SIZE];

        for (int i = 0; i <= arrayPointer; i++) {
            tempArray[i] = array[i];
        }

        array = tempArray;
    }

    @Override
    public int getSize() {
        return arrayPointer + 1;
    }

    @Override
    public void addElement(T t) {
        if (arrayPointer == THRESHOLD_SIZE - 1) {
            resizeArray(true);
        }

        arrayPointer++;
        array[arrayPointer] = t;
    }

    @Override
    public void addElement(T t, int position) throws ListIndexOutOfBoundsException {
        if (position > arrayPointer + 1) {
            throw new ListIndexOutOfBoundsException();
        } else {
            if (arrayPointer == THRESHOLD_SIZE - 1) {
                resizeArray(true);
            }

            for (int i = arrayPointer; i >= position; i--) {
                array[i + 1] = array[i];
            }

            array[position] = t;
            arrayPointer++;
        }
    }

    @Override
    public void removeElement(T t) {
        int elementPosition = -1;

        for (int i = 0; i <= arrayPointer; i++) {
            if (array[i].equals(t)) {
                elementPosition = i;
            }
        }

        if (elementPosition != -1) {
            for (int i = elementPosition; i < arrayPointer; i++) {
                array[i] = array[i + 1];
            }

            arrayPointer--;

            if (arrayPointer < THRESHOLD_SIZE / 2) {
                resizeArray(false);
            }
        }
    }

    @Override
    public void removeElementByPosition(int position) throws ListIndexOutOfBoundsException {
        for (int i = position; i < arrayPointer; i++) {
            array[i] = array[i + 1];
        }

        arrayPointer--;

        if (arrayPointer < THRESHOLD_SIZE / 2) {
            resizeArray(false);
        }
    }

    @Override
    public int getElementPosition(T t) {
        for (int i = 0; i <= arrayPointer; i++) {
            if (((T)array[i]).equals(t)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public T getElementByPosition(int position) throws ListIndexOutOfBoundsException {
        if (position > arrayPointer) {
            throw new ListIndexOutOfBoundsException();
        } else {
            return (T) array[position];
        }
    }

    @Override
    public boolean isEmpty() {
        return arrayPointer == -1;
    }

    @Override
    public boolean contains(T t) {
        return getElementPosition(t) != -1;
    }

    @Override
    public void clear() {
        array = new Object[THRESHOLD_SIZE];
        THRESHOLD_SIZE = 5;
        arrayPointer = -1;
    }

    @Override
    public void setElementByPosition(T t, int position) throws ListIndexOutOfBoundsException {
        if (position > arrayPointer) {
            throw new ListIndexOutOfBoundsException();
        } else {
            array[position] = t;
        }
    }
}


