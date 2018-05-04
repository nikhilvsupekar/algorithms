package com.data.structures;

import com.data.exceptions.LinkedListIndexOutOfBoundsException;

public class LinkedList<T> implements IList<T> {

    private LinkedListNode<T> head;

    public LinkedList() {
        this.head = null;
    }

    public int getSize() {
        int size = 0;
        LinkedListNode currentNode = head;

        while (currentNode != null) {
            currentNode = currentNode.getNextNode();
            size++;
        }

        return size;
    }

    public void addElement(T t) {
        if (head == null) {
            head = new LinkedListNode<>(t);
        } else {
            LinkedListNode currentNode = head;

            while (currentNode.getNextNode() != null) {
                currentNode = currentNode.getNextNode();
            }

            currentNode.setNextNode(new LinkedListNode<>(t));
        }
    }

    public void addElement(T t, int position) throws LinkedListIndexOutOfBoundsException {
        if (head == null && position == 0) {
            head = new LinkedListNode<>(t);
        } else if ((head == null && position > 0) || position < 0) {
            throw new LinkedListIndexOutOfBoundsException();
        } else if (position == 0) {
            LinkedListNode<T> newNode = new LinkedListNode<>(t);
            LinkedListNode nextNode = head;
            head = newNode;
            head.setNextNode(nextNode);
        } else {
            LinkedListNode prev = getLinkedListNodeByPosition(position - 1);

            if (prev == null) {
                throw new LinkedListIndexOutOfBoundsException();
            } else {
                LinkedListNode newNode = new LinkedListNode<>(t);

                if (prev.getNextNode() == null) {
                    prev.setNextNode(newNode);
                } else {
                    LinkedListNode nextNode = prev.getNextNode();
                    prev.setNextNode(newNode);
                    newNode.setNextNode(nextNode);
                }
            }
        }

    }

    public void removeElement(T t) {

    }

    public void removeElement(int position) {

    }

    public int getElementPosition(T t) {
        return 0;
    }

    private LinkedListNode getLinkedListNodeByPosition(int position) {
        if (head == null) {
            return null;
        }

        int currentPosition = 0;
        LinkedListNode currentNode = head;

        while (currentPosition != position && currentNode != null) {
            currentNode = currentNode.getNextNode();
            currentPosition++;
        }

        return currentNode;
    }
}
