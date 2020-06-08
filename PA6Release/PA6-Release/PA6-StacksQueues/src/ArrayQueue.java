/*
 * AUTHOR: Vatsav Sethupathi
 * FILE: ArrayQueue.java
 * ASSIGNMENT: Programming Assignment 6 - StacksQueues
 * COURSE: CSc 210 Spring 2020
 * PURPOSE: This file is used to create a class that represents the Queue
 * data type, which in this case is backed by an Array
 */

public class ArrayQueue implements QueueInterface {

    private static final int INITIAL_CAPACITY = 10;

    private int size;
    private int capacity;
    private int array[];

    /**
     * Purpose: This is the default, no-parameter constructor for the class
     */
    public ArrayQueue() {
        this.size = 0;
        this.capacity = INITIAL_CAPACITY;
        this.array = new int[capacity];
    }

    /**
     * Purpose: This is the copy constructor for the class which takes in an
     * object of the ArrayQueue class and creates a copy of the same
     * 
     * @param other:
     *            An object of the ArrayQueue class which is to be copied
     */
    public ArrayQueue(ArrayQueue other) {
        this.size = other.size;
        this.capacity = other.capacity;
        array = new int[capacity];
        for (int i = 0; i < size; i++)
            this.array[i] = other.array[i];
    }

    /**
     * Purpose: This is a helper method which is used to increase the size of
     * the main array once the size starts to go beyond the current capacity of
     * the array
     * 
     * @param None
     * 
     * @return void
     */
    public void growArray() {
        this.capacity *= 2;
        int newArr[] = new int[this.capacity];
        for (int i = 0; i < size; i++) {
            newArr[i] = array[i];
        }
        array = newArr;
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
        if (size >= capacity)
            growArray();
        array[size] = value;
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
        int retval = array[0];
        for (int i = 0; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
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
        return array[0];
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
        for (int i = 0; i < this.size; i++)
            retval += array[i] + ", ";
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
        if (o instanceof ArrayQueue) {
            ArrayQueue other = (ArrayQueue) o;
            if (this.size == other.size) {
                for (int i = 0; i < this.size; i++) {
                    if (this.array[i] != other.array[i])
                        return false;
                }
                return true;
            } else
                return false;
        } else
            return false;
    }

}
