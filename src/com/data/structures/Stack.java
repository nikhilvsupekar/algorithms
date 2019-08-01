package com.data.structures;

import com.data.exceptions.ListIndexOutOfBoundsException;
import com.data.structures.lists.LinkedList;

import java.util.EmptyStackException;

/**
 * A FILO data structure.
 * Uses a Linked List as the underlying data structure.
 * Most Stack operations are implemented by making Linked List API calls.
 *
 * @param <T>   a generic type
 *
 * @author  Nikhil Supekar
 */
public class Stack<T extends Comparable<T>> {

    /**
     * Underlying Linked List data structure.
     * Elements are always inserted at the top of the Stack and popped off only from the top of the Stack.
     * The head of the Linked List is assumed to be the Stack top.
     */
    private LinkedList<T> stackList;

    public Stack() {
        stackList = new LinkedList<>();
    }

    /**
     * Push an element to the top of the Stack.
     *
     * @param t     Element of the generic type to be pushed on the Stack.
     */
    public void push(T t) {
        try {
            stackList.addElement(t, 0);
        } catch (ListIndexOutOfBoundsException e) {
            throw new NullPointerException();
        }
    }

    /**
     * Pop an element off the Stack.
     * The function returns the value of the element at Stack top as well as removes the element off the Stack.
     * The Stack top (head of the Linked List) now points to the previous element at Stack top.
     *
     * @return  The element at Stack top.
     */
    public T pop() {
        try {
            T element = stackList.getElementByPosition(0);
            stackList.removeElementByPosition(0);

            return element;
        } catch (ListIndexOutOfBoundsException e) {
            throw new EmptyStackException();
        }
    }

    /**
     * Peek at the element at Stack top.
     * The function returns the value of the element at Stack top but doesn't remove from the Stack.
     * The Stack top still points to the current element at Stack top.
     *
     * @return  The element at Stack top.
     */
    public T peek() {
        try {
            return stackList.getElementByPosition(0);
        } catch (ListIndexOutOfBoundsException e) {
            throw new EmptyStackException();
        }
    }

    /**
     * Check if the Stack is empty.
     *
     * @return  A boolean indicating whether the Stack is empty.
     */
    public boolean isEmpty() {
        return stackList.getSize() == 0;
    }
}
