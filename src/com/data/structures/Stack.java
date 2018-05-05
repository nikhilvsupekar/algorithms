package com.data.structures;

import com.data.exceptions.ListIndexOutOfBoundsException;
import com.data.structures.lists.LinkedList;

import java.util.EmptyStackException;

public class Stack<T> {

    private LinkedList<T> stackList;

    public Stack() {
        stackList = new LinkedList<>();
    }

    public void push(T t) {
        try {
            stackList.addElement(t, 0);
        } catch (ListIndexOutOfBoundsException e) {
            throw new NullPointerException();
        }
    }

    public T pop() {
        try {
            T element = stackList.getElementByPosition(0);
            stackList.removeElementByPosition(0);

            return element;
        } catch (ListIndexOutOfBoundsException e) {
            throw new EmptyStackException();
        }
    }

    public T peek() {
        try {
            return stackList.getElementByPosition(0);
        } catch (ListIndexOutOfBoundsException e) {
            throw new EmptyStackException();
        }
    }

    public boolean isEmpty() {
        return stackList.getSize() == 0;
    }
}
