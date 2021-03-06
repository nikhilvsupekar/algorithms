package com.data.structures.lists;

import com.data.exceptions.ListIndexOutOfBoundsException;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Linked List Structure implementing the IList interface
 *
 * @param <T>   Generic Element type
 *
 * @author Nikhil Supekar
 */
public class LinkedList<T> implements IList<T> {

    /**
     * Reference to the first node of the linked list structure
     */
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

    public void addElement(T t, int position) throws ListIndexOutOfBoundsException {
        if (head == null && position == 0) {
            head = new LinkedListNode<>(t);
        } else if ((head == null && position > 0) || position < 0) {
            throw new ListIndexOutOfBoundsException();
        } else if (position == 0) {
            LinkedListNode<T> newNode = new LinkedListNode<>(t);
            LinkedListNode nextNode = head;
            head = newNode;
            head.setNextNode(nextNode);
        } else {
            LinkedListNode prev = getLinkedListNodeByPosition(position - 1);

            if (prev == null) {
                throw new ListIndexOutOfBoundsException();
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
        if (head == null) {
            return;
        }

        if (head.getNextNode() == null && head.getData().equals(t)) {
            head = null;
        } else {
            LinkedListNode currentNode = head;
            while (currentNode.getNextNode() != null && !currentNode.getNextNode().getData().equals(t)) {
                currentNode = currentNode.getNextNode();
            }

            if (currentNode.getNextNode() == null) {
                return;
            }

            if (currentNode.getNextNode().getData().equals(t)) {
                LinkedListNode nextNode = currentNode.getNextNode().getNextNode();
                currentNode.setNextNode(nextNode);
            }

        }

    }

    public void removeElementByPosition(int position) throws ListIndexOutOfBoundsException {
        if ((head == null && position >= 0) || position < 0) {
            throw new ListIndexOutOfBoundsException();
        } else if (position == 0) {
            head = head.getNextNode();
        } else {
            LinkedListNode prevNode = getLinkedListNodeByPosition(position - 1);
            if (prevNode == null) {
                throw new ListIndexOutOfBoundsException();
            } else {
                if (prevNode.getNextNode().getNextNode() == null) {
                    prevNode.setNextNode(null);
                } else {
                    prevNode.setNextNode(prevNode.getNextNode().getNextNode());
                }
            }
        }
    }

    public int getElementPosition(T t) {
        LinkedListNode currentNode = head;
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

    public T getElementByPosition(int position) throws ListIndexOutOfBoundsException {
        if ((head == null && position >= 0) || position < 0) {
            throw new ListIndexOutOfBoundsException();
        } else {
            LinkedListNode<T> currentNode = head;
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
            LinkedListNode<T> currentNode = head;
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

    @Override
    public void addListElements(IList<T> iList) {
        if (iList == null) return;

        for (T elem : iList) {
            addElement(elem);
        }
    }

    public LinkedListNode<T> getHead() {
        return head;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<>();
    }

    private class LinkedListIterator<T> implements Iterator<T> {
        private LinkedListNode<T> current = null;

        public LinkedListIterator() {
            current = (LinkedListNode<T>) head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (current == null) {
                throw new NoSuchElementException();
            }

            T data = current.getData();
            current = current.getNextNode();
            return data;
        }
    }

}
