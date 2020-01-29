package com.data.structures.lists;

import com.data.exceptions.ListIndexOutOfBoundsException;

/**
 * Interface for List types
 *
 * @param <T> a generic type
 *
 * @author Nikhil Supekar
 */
public interface IList<T extends Comparable<T>> extends Iterable<T>{

    /**
     * Get number of elements in the List
     *
     * @return number of elements in the list
     */
    public int getSize();


    /**
     * Add an element to the end of the list
     *
     * @param t A generic element to be added to the list
     */
    public void addElement(T t);


    /**
     * Add an element in the specified position.
     * The position must be a valid position; must lie between 0 and size of list
     *
     * @param t         A generic element to be added to the list
     * @param position  The position at which the element has be to inserted
     * @throws ListIndexOutOfBoundsException    If the specified position lies outside the bounds of the list
     */
    public void addElement(T t, int position) throws ListIndexOutOfBoundsException;


    /**
     * Add all elements of the parameter list to the current list.
     *
     * @param iList     List elements to be added to the current list
     */
//    public void addList(IList<T> iList);

    /**
     * Remove the specified element from the list.
     * Removes only the first instance of the element in the list.
     *
     * @param t     The element to remove from the list
     */
    public void removeElement(T t);


    /**
     * Remove the element from the specified position of the list.
     *
     * @param position  List position to remove the element from.
     * @throws ListIndexOutOfBoundsException    If the specified position lies outside the bounds of the list
     */
    public void removeElementByPosition(int position) throws ListIndexOutOfBoundsException;


    /**
     * Get the position of the element in the list.
     * Returns -1 if the element is not found.
     *
     * @param t     Element to search in the list
     * @return      Position of the element in the list.
     *              Returns -1 if the element is not found.
     */
    public int getElementPosition(T t);


    /**
     * Get the element at the specified position
     *
     * @param position  Position to fetch the element from
     * @return          Value of the data at node identified by position
     * @throws ListIndexOutOfBoundsException    If the specified position lies outside the bounds of the list
     */
    public T getElementByPosition(int position) throws ListIndexOutOfBoundsException;


    /**
     * Check if the list is empty
     *
     * @return  a boolean indicating if the list if empty
     */
    public boolean isEmpty();


    /**
     * Check if an element belongs to the list
     *
     * @param t     Element to check for existence in the list
     * @return      a boolean indicating whether the element is present in the list
     */
    public boolean contains(T t);


    /**
     * Delete all elements from the list
     */
    public void clear();


    /**
     * Set an element at the specified position to the specified value
     *
     * @param t         Value to set the element
     * @param position  The position at which the element has to be replaced
     * @throws ListIndexOutOfBoundsException    If the specified position lies outside the bounds of the list
     */
    public void setElementByPosition(T t, int position) throws ListIndexOutOfBoundsException;


    /**
     * Add elements of the parameter list to the current list
     * @param iList     List whose elements need to be added to the list
     */
    public void addListElements(IList<T> iList);

}
