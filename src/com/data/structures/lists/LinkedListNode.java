package com.data.structures.lists;

public class LinkedListNode<T> {

    public LinkedListNode(T data, LinkedListNode nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }

    public LinkedListNode(T data) {
        this(data, null);
    }

    public LinkedListNode() {
        this(null, null);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LinkedListNode<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(LinkedListNode nextNode) {
        this.nextNode = nextNode;
    }

    private T data;
    private LinkedListNode nextNode;
}
