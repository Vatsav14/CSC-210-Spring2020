/*
 * AUTHOR: Vatsav Sethupathi
 * FILE: ListQueue.java
 * ASSIGNMENT: Programming Assignment 6 - StacksQueues
 * COURSE: CSc 210 Spring 2020
 * PURPOSE: This file is used to create a class that represents the Queue
 * data type, which in this case is backed by a Linked List
 */

public class ListQueue implements QueueInterface {

    private Node front;
    private Node back;
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
     * object of the ListQueue class and creates a copy of the same
     * 
     * @param other:
     *            An object of the ListQueue class which is to be copied
     */
    public ListQueue(ListQueue other) {
        this.size = other.size;
        if (other.size == 0) {
            return;
        }
        this.front = new Node(other.front.data, null);
        Node otherCurr = other.front.next;
        Node thisCurr = this.front;
        while (otherCurr != null) {
            thisCurr.next = new Node(otherCurr.data, null);
            otherCurr = otherCurr.next;
            thisCurr = thisCurr.next;
        }
        back = thisCurr;
    }

    /**
     * Purpose: This method adds an element to the back of the queue.
     * 
     * @param value:
     *            The integer value to be added to the queue
     * 
     * @return void
     */
    @Override
    public void enqueue(int value) {
        // TODO Auto-generated method stub
        Node toAdd = new Node(value, null);
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
     * @return The first element in the queue, or -1 if the queue is empty
     */
    @Override
    public int dequeue() {
        if (size == 0)
            return -1;
        int retval = front.data;
        front = front.next;
        size--;
        return retval;
    }

    /**
     * Purpose: This method returns the front element in the queue.
     * 
     * @param None
     * 
     * @return The first element in the queue, or -1 if the queue is empty
     */
    @Override
    public int peek() {
        if (size == 0)
            return -1;
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
        Node curr = front;
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
            ListQueue other = (ListQueue) o;
            if (this.size == other.size) {
                Node thisCurr = this.front;
                Node otherCurr = other.front;
                while (thisCurr != null) {
                    if (thisCurr.data != otherCurr.data)
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
     * Node in a Linked List
     */
    private static class Node {
        int data;
        Node next;

        /**
         * Purpose: This is the constructor for the Node class
         * 
         * @param data:
         *            The value that is to be stored in the Node
         * @param next:
         *            A reference to the next node in the list
         */
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

}
