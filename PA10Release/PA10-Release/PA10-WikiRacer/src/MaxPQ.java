import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class MaxPQ {
	
	private static final int INITIAL_CAPACITY = 10;
	private int size;
	private int capacity;
	private Node array[];
	
	public MaxPQ() {
		array = new Node[INITIAL_CAPACITY];
        size = 0;
        capacity = INITIAL_CAPACITY;
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
        Node newArr[] = new Node[this.capacity];

        // Copy over all the elements to the new array
        for (int i = 0; i <= size; i++) {
            newArr[i] = array[i];
        }

        array = newArr;
    }

    /**
     * This method is used to add a new Node to the Queue, given their name
     * and priority
     * 
     * @param name
     *            Takes in the list of the Node to be added to the Queue
     * @param priority
     *            Takes in the priority of the Node to be added to the Queue
     */
    public void enqueue(List<String> name, int priority) {
        Node toAdd = new Node(name, priority);
        enqueue(toAdd);
    }

    /**
     * This method is used to add the given Node object to the queue as per
     * their priority
     * (or name is their priority is the same)
     * 
     * @param node
     *            The Node object to be added to the Queue
     */
    public void enqueue(Node node) {
        if (size + 1 >= capacity) {
            growArray();
        }

        size++;
        array[size] = node;
        bubbleUp(size);
    }

    /**
     * This method simply bubbles up a Node object in the Queue to restore
     * its property using their priority
     * 
     * @param i
     *            The index of the object which violates the property of the
     *            Queue
     */
    private void bubbleUp(int i) {
        int parent = i / 2;


        // Base case
        if (i <= 1) // If the element is now at the front of the Queue
            return;

        // Recursive case
        if (array[parent].priority < array[i].priority) {
            Node temp = array[parent];
            array[parent] = array[i];
            array[i] = temp;
            bubbleUp(parent);
        }
    }

    /**
     * This function removes the Node with the most important priority and
     * returns their list.
     * If the Queue is empty, a NoSuchElementException is thrown.
     * 
     * @return The list of the Node with the most important priority
     */
    public List<String> dequeue() {
        if(size == 0)
            throw new NoSuchElementException(
                    "You can't dequeue items from the list since it is currently empty!");

        Node toRemove = array[1];
        array[1] = array[size];
        array[size] = null;
        size--;

        bubbleDown(1);

        return toRemove.ladder;
    }

    /**
     * This method simply bubbles down a Node object in the Queue to restore
     * its property using their priority
     * 
     * @param i
     *            The index of the object which violates the property of the
     *            Queue
     */
    public void bubbleDown(int i) {
        if (size == 0)
            return;

        else {
            if (i * 2 > size) // Base case for recursion
                return;

            Node first = array[i * 2], second = array[(i * 2) + 1];

            if (second != null) {

                if (first.priority > second.priority) {
                    // First has a higher urgency
                    compareSwap(i, i * 2);
                    bubbleDown(i * 2);
                }

                else if (second.priority > first.priority) {
                    // Second has a higher urgency
                    compareSwap(i, i * 2 + 1);
                    bubbleDown(i * 2 + 1);
                }

                // We know both the children have the same priority in the queue
//                else {
//
//                    if (first.name.compareTo(second.name) >= 0) {
//                        // The first name should come earlier
//                        compareSwap(i, i * 2);
//                        bubbleDown(i * 2);
//                    }
//
//                    else {
//                        // The second name should come earlier
//                        compareSwap(i, i * 2 + 1);
//                        bubbleDown(i * 2 + 1);
//                    }
//                }
            }

            // The second child is null
            else {
                compareSwap(i, i*2);
                bubbleDown(i*2);
            }
        }
    }

    /**
     * This function is just a helper function for the dequeue function which
     * checks two items in the
     * queue and swaps them if necessary in order to preserve the property of
     * the queue
     * 
     * @param i
     *            The index of the parent Node
     * @param child
     *            The index of one of the child Node to be checked
     */
    public void compareSwap(int i, int child) {

        if (array[i].priority < array[child].priority) {
            Node temp = array[child];
            array[child] = array[i];
            array[i] = temp;
        }
    }

    /**
     * This method simply returns the name of the Node with the most
     * important priority.
     * If the Queue is empty, a NoSuchElementException is thrown.
     * 
     * @return The name of the Node with the most important priority
     */
    public List<String> peek() {
        if (size == 0)
            throw new NoSuchElementException(
                    "You can't peek into the queue since it is currently empty!");

        return array[1].ladder;
    }

    /**
     * This method simply returns the priority of the Node with the most
     * important priority.
     * If the Queue is empty, a NoSuchElementException is thrown.
     * 
     * @return The priority of the Node with the most important priority
     */
    public int peekPriority() {
        if (size == 0)
            throw new NoSuchElementException(
                    "You can't peek into the queue since it is currently empty!");

        return array[1].priority;
    }

    /**
     * This method changes the priority of one of the Nodes in the queue.
     * Only changes the
     * priority of the first occurrence of the name. Nothing happens if the name
     * doesn't exist
     * or if the new priority is the same
     * 
     * @param name
     *            The name of the Node whose priority is to be changed
     * @param newPriority
     *            The new value of priority to be allotted to the Node
     */
    public void changePriority(String name, int newPriority) {
        for (int i = 1; i < size + 1; i++) {
            if (array[i].ladder.equals(name)) {

                int oldP = array[i].priority;
                array[i].priority = newPriority;

                // Urgency has increased. Bubble up the queue
                if (newPriority > oldP)
                    bubbleUp(i);

                // Urgency has reduced. Bubble down the queue
                else if (newPriority < oldP)
                    bubbleDown(i);

                return; // This is so that only the first occurence is changed
            }
        }
    }

    /**
     * Returns true if there are no elements in the Queue and false otherwise
     * 
     * @return true or false depending on whether the list has elements or not
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Simply returns the number of elements in the queue
     * 
     * @return The size of the queue
     */
    public int size() {
        return size;
    }

    /**
     * This method removes all of the elements in the queue
     */
    public void clear() {
        this.size = 0;
    }

    /**
     * This method creates a String representation of all the elements in the
     * Queue and returns it
     * 
     * @return The String representation of the queue with all of its Nodes
     */
    public String toString() {
        String retval = "{";

        for (int i = 1; i < size + 1; i++) {
            retval += array[i].toString() + ", ";
        }

        return retval.length() > 1
                ? retval.substring(0, retval.length() - 2) + "}"
                : retval + "}";
    }
    
    /*
     * This is the Node class which is used in the implementation of the Binary Max Queue
     */
    private class Node{
    	List<String> ladder;
    	int priority;
    	
    	/**
    	 * This is the parameterized constructor of the Node
    	 * 
    	 * @param ladder The list ladder of the Node in the Queue
    	 * @param priority The priority of the item in the Queue
    	 */
    	public Node(List<String> ladder, int priority) {
    		this.ladder = ladder;
    		this.priority = priority;
    	}
    	
    	
    	/**
    	 * This is function which converts the Node into a String representation
    	 * 
    	 * @return The String representation of the Node
    	 */
    	public String toString() {
    		return this.ladder + " (" + this.priority + ")";
    	}
    }
}
