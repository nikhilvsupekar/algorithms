package com.data.structures;

import com.data.exceptions.EmptyQueueException;
import com.data.structures.lists.DoublyLinkedListNode;

/**
 * A simple queue impl using Doubly Linked List as the underlying structure.
 *
 *
 * @param <T>   a generic type
 *
 * @author      Nikhil Supekar
 */
public class Queue<T> {
    /**
     * End of the queue where the elements are consumed from.
     */
    private DoublyLinkedListNode<T> front;

    /**
     * End of the queue where the elements are entered from.
     */
    private DoublyLinkedListNode<T> rear;

    public Queue() {
        front = null;
        rear = null;
    }

    /**
     * Check if the Queue is empty.
     *
     * @return  a boolean indicating if the queue is empty
     */
    public boolean isEmpty() {
        return front == null && rear == null;
    }


    /**
     * Add an element to the queue.
     *
     * @param t     a generic type
     */
    public void enqueue(T t) {
        if (isEmpty()) {
            rear = new DoublyLinkedListNode<>(t);
            front = rear;
        } else {
            if (front == rear) {
                DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<>(t, null, rear);
                rear = newNode;
                front.setPreviousNode(newNode);
            } else {
                DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<>(t, null, rear);
                DoublyLinkedListNode<T> nextNode = rear.getNextNode();

                rear = newNode;
                if (nextNode != null) {
                    nextNode.setPreviousNode(newNode.getNextNode());
                }

                newNode.getNextNode().setPreviousNode(newNode);
            }

        }

    }


    /**
     * Remove an element off the queue.
     *
     * @return      the element at the front end of the queue.
     * @throws EmptyQueueException      if the queue is empty
     */
    public T dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        } else {
            T data = front.getData();

            if (front == rear) {
                front = rear = null;
            } else {
                front = front.getPreviousNode();
                if (front.getPreviousNode() != null) {
                    front.getPreviousNode().setNextNode(null);
                }
            }

            return data;
        }

    }


    /**
     * Peek at the value at the front end of the queue.
     * Element is not removed off the front end.
     *
     * @return      value at the front end
     * @throws EmptyQueueException  if the queue is empty
     */
    public T peek() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        } else {
            return front.getData();
        }

    }

}
