/*
 * AUTHOR: Vatsav Sethupathi
 * FILE: ListStack.java
 * ASSIGNMENT: Programming Assignment 7 - Generics
 * COURSE: CSc 210 Spring 2020
 * PURPOSE: This file is used to create a class that represents the Stack
 * data type that can store any type of object, which in this case is backed by a Linked List
 */

public class ListStack<E> implements StackInterface<E> {

    private Node<E> front;
    private Node<E> back;
    private int size;

    /**
     * Purpose: This is the default, no parameter constructor for the class
     */
    public ListStack() {
        this.size = 0;
        this.front = null;
        this.back = null;
    }

    /**
     * Purpose: This is the copy constructor of the class which takes
     * in a ListStack<E> objects and creates a new copy of the same object
     * 
     * @param other:
     *            The ListStack<E> object which is to be copied
     */
    public ListStack(ListStack<E> other) {
        this.size = other.size;
        if (other.size == 0) {
            return;
        }
        this.front = new Node<E>(other.front.data, null);
        Node<E> otherCurr = other.front.next;
        Node<E> thisCurr = this.front;
        while (otherCurr != null) {
            thisCurr.next = new Node<E>(otherCurr.data, null);
            otherCurr = otherCurr.next;
            thisCurr = thisCurr.next;
        }
        back = thisCurr;
    }

    /**
     * Purpose: This method adds an element to the top of the stack.
     * 
     * @param value:
     *            The data value to be added to the Stack
     * 
     * @return void
     */
    @Override
    public void push(E value) {
        Node<E> toAdd = new Node<E>(value, null);
        if (size == 0) {
            this.front = toAdd;
            this.back = toAdd;
        } else {
            this.back.next = toAdd;
            this.back = toAdd;
        }
        size++;
    }

    /**
     * Purpose: This method removes and returns the top element in the stack.
     * 
     * @param None
     * 
     * @return The data value at the top of the stack, or null if the stack is
     *         empty
     */
    @Override
    public E pop() {
        Node<E> curr = front;
        E retval;
        if (size == 0)
            return null;
        if (size == 1) {
            retval = front.data;
            front = null;
            back = null;
        } else if (size == 2) {
            retval = back.data;
            front.next = null;
            back = front;
        } else {
            retval = back.data;
            while (curr.next.next != null) {
                curr = curr.next;
            }
            curr.next = null;
            back = curr;
        }
        size--;

        return retval;
    }

    /**
     * Purpose: This method returns the top element in the stack.
     * 
     * @param None
     * 
     * @return The data value at the top of the stack, or null if the stack is
     *         empty
     */
    @Override
    public E peek() {
        if (size == 0)
            return null;
        return back.data;
    }

    /**
     * Purpose: This method returns true if the stack has no elements.
     * 
     * @param None
     * 
     * @return A boolean value signifying whether the stack is empty or not
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Purpose: This method returns the size of the stack
     * 
     * @param None
     * 
     * @return The size of the Stack
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Purpose: This method removes all the elements of the Stack
     * 
     * @param None
     * 
     * @return void
     */
    @Override
    public void clear() {
        size = 0;
        front = null;
        back = null;
    }

    /**
     * Purpose: This method creates a String representation of the stack
     * 
     * @param None
     * 
     * @return A String representation of all the elements in the stack
     */
    public String toString() {
        String retval = "{ ";
        Node<E> curr = front;
        while (curr != null) {
            retval += curr.data + ", ";
            curr = curr.next;
        }
        retval += "}";
        return retval;
    }

    /**
     * Purpose: This method checks if the object passed in as a parameter has
     * the same fields as the current object
     * 
     * @param o:
     *            The object which is to be compared to the current instance of
     *            the class
     * 
     * @return A boolean that represents whether the objects are the same or not
     */
    public boolean equals(Object o) {
        if (o instanceof ListStack) {
            ListStack<E> other = (ListStack<E>) o;
            if (other.size == this.size) {
                Node<E> thisCurr = this.front;
                Node<E> otherCurr = other.front;
                while (thisCurr != null) {
                    if (!thisCurr.data.equals(otherCurr.data))
                        return false; // The elements in the stack are different
                    thisCurr = thisCurr.next;
                    otherCurr = otherCurr.next;
                }
                return true;
            } else
                return false;
        } else
            return false;
    }

    /*
     * Purpose: This is a nested class used to provide the functionality of a
     * Node in a Linked List that stores any type of object as data
     */
    private static class Node<E> {
        E data;
        Node<E> next;

        /**
         * Purpose: This is the constructor for the Node class
         * 
         * @param data:
         *            The data value that is to be stored in the Node
         * @param next:
         *            A reference to the next node in the list
         */
        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

}