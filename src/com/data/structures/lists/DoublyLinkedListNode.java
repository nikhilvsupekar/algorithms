package com.data.structures.lists;

/**
 * Node structure for a Doubly Linked List.
 *
 * @param <T>   a generic type
 *
 * @author  Nikhil Supekar
 */
public class DoublyLinkedListNode<T> {

    /**
     * Generic type holding the data.
     */
    private T data;

    /**
     * Reference to the previous node in the DLL.
     */
    private DoublyLinkedListNode<T> prev;

    /**
     * Reference to the next node in the DLL.
     */
    private DoublyLinkedListNode<T> next;

    public DoublyLinkedListNode(T data, DoublyLinkedListNode<T> prev, DoublyLinkedListNode<T> next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public DoublyLinkedListNode(T data) {
        this(data, null, null);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DoublyLinkedListNode<T> getPreviousNode() {
        return prev;
    }

    public void setPreviousNode(DoublyLinkedListNode prev) {
        this.prev = prev;
    }

    public DoublyLinkedListNode<T> getNextNode() {
        return next;
    }

    public void setNextNode(DoublyLinkedListNode next) {
        this.next = next;
    }
}
