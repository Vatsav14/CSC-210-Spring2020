/*
 * AUTHOR: Vatsav Sethupathi
 * FILE: ListStack.java
 * ASSIGNMENT: Programming Assignment 6 - StacksQueues
 * COURSE: CSc 210 Spring 2020
 * PURPOSE: This file is used to create a class that represents the Stack
 * data type, which in this case is backed by a Linked List
 */

public class ListStack implements StackInterface {

    private Node front;
    private Node back;
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
     * in a ListStack objects and creates a new copy of the same object
     * 
     * @param other:
     *            The ListStack object which is to be copied
     */
    public ListStack(ListStack other) {
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
     * Purpose: This method adds an element to the top of the stack.
     * 
     * @param value:
     *            The integer value to be added to the Stack
     * 
     * @return void
     */
    @Override
    public void push(int value) {
        Node toAdd = new Node(value, null);
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
     * @return The integer value at the top of the stack, or -1 if the stack is
     *         empty
     */
    @Override
    public int pop() {
        Node curr = front;
        int retval;
        if (size == 0)
            return -1;
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
     * @return The integer value at the top of the stack, or -1 if the stack is
     *         empty
     */
    @Override
    public int peek() {
        if (size == 0)
            return -1;
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
        if (o instanceof ListStack) {
            ListStack other = (ListStack) o;
            if (other.size == this.size) {
                Node thisCurr = this.front;
                Node otherCurr = other.front;
                while (thisCurr != null) {
                    if (thisCurr.data != otherCurr.data)
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
