package com.data.structures.lists;

import com.data.exceptions.ListIndexOutOfBoundsException;

/**
 * Doubly Linked List structure implementing the IList interface
 *
 * @param <T>   a generic type
 *
 * @author      Nikhil Supekar
 */
public class DoublyLinkedList<T extends Comparable<T>> implements IList<T> {

    private DoublyLinkedListNode<T> head;

    public DoublyLinkedList() {
        this.head = null;
    }

    @Override
    public int getSize() {
        int size = 0;
        DoublyLinkedListNode currentNode = head;

        while (currentNode != null) {
            currentNode = currentNode.getNextNode();
            size++;
        }

        return size;
    }

    @Override
    public void addElement(T t) {
        if (head == null) {
            head = new DoublyLinkedListNode<>(t);
        } else {
            DoublyLinkedListNode<T> currentNode = head;

            while (currentNode.getNextNode() != null) {
                currentNode = currentNode.getNextNode();
            }

            currentNode.setNextNode(new DoublyLinkedListNode<>(t, currentNode, null));
        }
    }

    @Override
    public void addElement(T t, int position) throws ListIndexOutOfBoundsException {
        if (head == null && position == 0) {
            head = new DoublyLinkedListNode<>(t);
        } else if ((head == null && position > 0) || position < 0) {
            throw new ListIndexOutOfBoundsException();
        } else if (position == 0) {
            head = new DoublyLinkedListNode<>(t, null, head);
        } else {
            DoublyLinkedListNode<T> prev = getDoublyLinkedListNodeByPosition(position - 1);

            if (prev == null) {
                throw new ListIndexOutOfBoundsException();
            } else {
                if (prev.getNextNode() == null) {
                    prev.setNextNode(new DoublyLinkedListNode<>(t, prev, null));
                } else {
                    prev.setNextNode(new DoublyLinkedListNode<>(t, prev, prev.getNextNode()));
                }
            }
        }
    }

    private DoublyLinkedListNode<T> getDoublyLinkedListNodeByPosition(int position) {
        if (head == null) {
            return null;
        }

        int currentPosition = 0;
        DoublyLinkedListNode<T> currentNode = head;

        while (currentPosition != position && currentNode != null) {
            currentNode = currentNode.getNextNode();
            currentPosition++;
        }

        return currentNode;
    }

    @Override
    public void removeElement(T t) {
        if (head == null) {
            return;
        }

        if (head.getNextNode() == null && head.getData().equals(t)) {
            head = null;
        } else {
            DoublyLinkedListNode<T> currentNode = head;
            while (currentNode.getNextNode() != null && !currentNode.getNextNode().getData().equals(t)) {
                currentNode = currentNode.getNextNode();
            }

            if (currentNode.getNextNode() == null) {
                return;
            }

            if (currentNode.getNextNode().getData().equals(t)) {
                DoublyLinkedListNode<T> nextNode = currentNode.getNextNode().getNextNode();
                if (nextNode != null) {
                    nextNode.setPreviousNode(currentNode);
                }
                currentNode.setNextNode(nextNode);
            }

        }
    }

    @Override
    public void removeElementByPosition(int position) throws ListIndexOutOfBoundsException {
        if ((head == null && position >= 0) || position < 0) {
            throw new ListIndexOutOfBoundsException();
        } else if (position == 0) {
            head = head.getNextNode();
        } else {
            DoublyLinkedListNode<T> prevNode = getDoublyLinkedListNodeByPosition(position - 1);
            if (prevNode == null) {
                throw new ListIndexOutOfBoundsException();
            } else {
                if (prevNode.getNextNode().getNextNode() == null) {
                    prevNode.setNextNode(null);
                } else {
                    prevNode.setNextNode(prevNode.getNextNode().getNextNode());
                    prevNode.getNextNode().setPreviousNode(prevNode);
                }
            }
        }
    }

    @Override
    public int getElementPosition(T t) {
        DoublyLinkedListNode<T> currentNode = head;
        int currentPosition = 0;

        while (currentNode != null) {
            if (currentNode.getData().equals(t)) {
                return currentPosition;
            }

            currentNode = currentNode.getNextNode();
            currentPosition++;
        }

        return -1;
    }

    @Override
    public T getElementByPosition(int position) throws ListIndexOutOfBoundsException {
        if ((head == null && position >= 0) || position < 0) {
            throw new ListIndexOutOfBoundsException();
        } else {
            DoublyLinkedListNode<T> currentNode = head;
            int currentPosition = 0;

            while (currentNode != null && currentPosition != position) {
                currentNode = currentNode.getNextNode();
                currentPosition++;
            }

            if (currentNode == null) {
                throw new ListIndexOutOfBoundsException();
            } else {
                return currentNode.getData();
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean contains(T t) {
        return getElementPosition(t) != -1;
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public void setElementByPosition(T t, int position) throws ListIndexOutOfBoundsException {
        if ((head == null && position >= 0) || position < 0) {
            throw new ListIndexOutOfBoundsException();
        } else {
            DoublyLinkedListNode<T> currentNode = head;
            int currentPosition = 0;

            while (currentNode != null && currentPosition != position) {
                currentNode = currentNode.getNextNode();
                currentPosition++;
            }

            if (currentNode == null) {
                throw new ListIndexOutOfBoundsException();
            } else {
                currentNode.setData(t);
            }
        }
    }
}
