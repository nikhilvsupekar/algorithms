package com.data.structures;

public class LinkedList<T> implements IList<T> {

    LinkedListNode<T> head;

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
}
