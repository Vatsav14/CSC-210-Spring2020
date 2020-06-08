/*
 * AUTHOR: Vatsav Sethupathi
 * FILE: ArrayStack.java
 * ASSIGNMENT: Programming Assignment 6 - StacksQueues
 * COURSE: CSc 210 Spring 2020
 * PURPOSE: This file is used to create a class that represents the Stack
 * data type, which in this case is backed by an array
 */

public class ArrayStack implements StackInterface {

    private static final int INITIAL_CAPACITY = 10;

    private int size;
    private int capacity;
    private int array[];

    /**
     * Purpose: This is the default, no parameter constructor for the class
     */
    public ArrayStack() {
        this.size = 0;
        this.capacity = INITIAL_CAPACITY;
        this.array = new int[capacity];
    }

    /**
     * Purpose: This is the copy constructor of the class which takes
     * in an ArrayStack objects and creates a new copy of the same object
     * 
     * @param other:
     *            The ArrayStack object which is to be copied
     */
    public ArrayStack(ArrayStack other) {
        this.size = other.size;
        this.capacity = other.capacity;
        array = new int[capacity];

        for (int i = 0; i < size; i++) {
            this.array[i] = other.array[i];
        }
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
     * Purpose: This method adds an element to the top of the stack.
     * 
     * @param value:
     *            The integer value to be added to the Stack
     * 
     * @return void
     */
    @Override
    public void push(int value) {
        if (size >= capacity) {
            growArray();
        }

        array[size] = value;
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
        if (size == 0)
            return -1;

        size--;
        return array[size];
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

        return array[size - 1];
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
        if (o instanceof ArrayStack) {
            ArrayStack other = (ArrayStack) o;
            if (this.size == other.size) {
                for (int i = 0; i < this.size; i++) {
                    if (this.array[i] != other.array[i])
                        return false; // The elements in the stack are different
                }
                return true;
            } else // The sizes of the Stacks are different
                return false;
        } else // The object passed in is not an instance of ArrayStack
            return false;
    }

}
