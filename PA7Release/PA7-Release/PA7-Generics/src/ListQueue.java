/*
 * AUTHOR: Vatsav Sethupathi
 * FILE: ListQueue.java
 * ASSIGNMENT: Programming Assignment 7 - Generics
 * COURSE: CSc 210 Spring 2020
 * PURPOSE: This file is used to create a class that represents the Queue
 * data type that can store any kind of object, which in this case is backed by a Linked List
 */

public class ListQueue<E> implements QueueInterface<E> {

    private Node<E> front;
    private Node<E> back;
    private int size;

    /**
     * Purpose: This is the default, no-parameter constructor for the class
     */
    public ListQueue() {
        this.size = 0;
        this.front = null;
        this.back = null;
    }

    /**
     * Purpose: This is the copy constructor for the class which takes in an
     * object of the ListQueue<E> class and creates a copy of the same
     * 
     * @param other:
     *            An object of the ListQueue<E> class which is to be copied
     */
    public ListQueue(ListQueue<E> other) {
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
     * Purpose: This method adds an element to the back of the queue.
     * 
     * @param value:
     *            The data value to be added to the queue
     * 
     * @return void
     */
    @Override
    public void enqueue(E value) {
        Node<E> toAdd = new Node<E>(value, null);
        if (size == 0) {
            front = toAdd;
            back = toAdd;
        } else {
            back.next = toAdd;
            back = back.next;
        }
        size++;
    }

    /**
     * Purpose: This method removes and returns the front element in the queue.
     * 
     * @param None
     * 
     * @return The first element in the queue, or null if the queue is empty
     */
    @Override
    public E dequeue() {
        if (size == 0)
            return null;
        E retval = front.data;
        front = front.next;
        size--;
        return retval;
    }

    /**
     * Purpose: This method returns the front element in the queue.
     * 
     * @param None
     * 
     * @return The first element in the queue, or null if the queue is empty
     */
    @Override
    public E peek() {
        if (size == 0)
            return null;
        return front.data;
    }

    /**
     * Purpose: This method returns true if the queue is empty
     * 
     * @param None
     * 
     * @return A boolean value signifying whether the list is empty or not
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Purpose: This method returns the size of the queue
     * 
     * @param None
     * 
     * @return The size of the queue
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Purpose: This method removes all the elements of the Queue
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
     * Purpose: This method creates a String representation of the Queue
     * 
     * @param None
     * 
     * @return A String representation of all the elements in the Queue
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
        if (o instanceof ListQueue) {
            ListQueue<E> other = (ListQueue<E>) o;
            if (this.size == other.size) {
                Node<E> thisCurr = this.front;
                Node<E> otherCurr = other.front;
                while (thisCurr != null) {
                    if (!thisCurr.data.equals(otherCurr.data))
                        return false;
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