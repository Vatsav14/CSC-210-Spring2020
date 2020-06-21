import java.util.NoSuchElementException;

public class PatientQueue {

    private static final int INITIAL_CAPACITY = 10;
    private Patient array[];
    private int size;
    private int capacity;

    /**
     * This is the default, no parameter constructor of the PatientQueue class
     */
    public PatientQueue() {
        array = new Patient[INITIAL_CAPACITY];
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
        Patient newArr[] = new Patient[this.capacity];

        // Copy over all the elements to the new array
        for (int i = 0; i <= size; i++) {
            newArr[i] = array[i];
        }

        array = newArr;
    }

    /**
     * This method is used to add a new Patient to the Queue, given their name
     * and priority
     * 
     * @param name
     *            Takes in the name of the Patient to be added to the Queue
     * @param priority
     *            Takes in the priority of the Patient to be added to the Queue
     */
    public void enqueue(String name, int priority) {
        Patient toAdd = new Patient(name, priority);
        enqueue(toAdd);
    }

    /**
     * This method is used to add the given Patient object to the queue as per
     * their priority
     * (or name is their priority is the same)
     * 
     * @param patient
     *            The Patient object to be added to the Queue
     */
    public void enqueue(Patient patient) {
        if (size + 1 >= capacity) {
            growArray();
        }

        size++;
        array[size] = patient;
        bubbleUp(size);
    }

    /**
     * This method simply bubbles up a Patient object in the Queue to restore
     * its property
     * using their priority, or name if the priority is the same
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
        if (array[parent].priority > array[i].priority) {
            Patient temp = array[parent];
            array[parent] = array[i];
            array[i] = temp;
            bubbleUp(parent);
        }
        else if (array[parent].priority == array[i].priority) {
            if (array[i].name.compareTo(array[parent].name) < 0) {
                Patient temp = array[parent];
                array[parent] = array[i];
                array[i] = temp;
                bubbleUp(parent);
            }
        }
    }

    /**
     * This function removes the patient with the most important priority and
     * returns their name.
     * If the Queue is empty, a NoSuchElementException is thrown.
     * 
     * @return The name of the Patient with the most important priority
     */
    public String dequeue() {
        if(size == 0)
            throw new NoSuchElementException(
                    "You can't dequeue items from the list since it is currently empty!");

        Patient toRemove = array[1];
        array[1] = array[size];
        array[size] = null;
        size--;

        bubbleDown(1);

        return toRemove.name;
    }

    /**
     * This method simply bubbles down a Patient object in the Queue to restore
     * its property
     * using their priority, or name if the priority is the same
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

            Patient first = array[i * 2], second = array[(i * 2) + 1];

            if (second != null) {

                if (first.priority < second.priority) {
                    // First has a higher urgency
                    compareSwap(i, i * 2);
                    bubbleDown(i * 2);
                }

                else if (second.priority < first.priority) {
                    // Second has a higher urgency
                    compareSwap(i, i * 2 + 1);
                    bubbleDown(i * 2 + 1);
                }

                // We know both the children have the same priority in the queue
                else {

                    if (first.name.compareTo(second.name) <= 0) {
                        // The first name should come earlier
                        compareSwap(i, i * 2);
                        bubbleDown(i * 2);
                    }

                    else {
                        // The second name should come earlier
                        compareSwap(i, i * 2 + 1);
                        bubbleDown(i * 2 + 1);
                    }
                }
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
     *            The index of the parent Patient
     * @param child
     *            The index of one of the child Patients to be checked
     */
    public void compareSwap(int i, int child) {

        if (array[i].priority > array[child].priority) {
            Patient temp = array[child];
            array[child] = array[i];
            array[i] = temp;
        }

        else if (array[i].priority == array[child].priority) {
            if (array[child].name.compareTo(array[i].name) < 0) {
                Patient temp = array[child];
                array[child] = array[i];
                array[i] = temp;
            }
        }
    }

    /**
     * This method simply returns the name of the Patient with the most
     * important priority.
     * If the Queue is empty, a NoSuchElementException is thrown.
     * 
     * @return The name of the Patient with the most important priority
     */
    public String peek() {
        if (size == 0)
            throw new NoSuchElementException(
                    "You can't peek into the queue since it is currently empty!");

        return array[1].name;
    }

    /**
     * This method simply returns the priority of the Patient with the most
     * important priority.
     * If the Queue is empty, a NoSuchElementException is thrown.
     * 
     * @return The priority of the Patient with the most important priority
     */
    public int peekPriority() {
        if (size == 0)
            throw new NoSuchElementException(
                    "You can't peek into the queue since it is currently empty!");

        return array[1].priority;
    }

    /**
     * This method changes the priority of one of the Patients in the queue.
     * Only changes the
     * priority of the first occurrence of the name. Nothing happens if the name
     * doesn't exist
     * or if the new priority is the same
     * 
     * @param name
     *            The name of the Patient whose priority is to be changed
     * @param newPriority
     *            The new value of priority to be allotted to the patient
     */
    public void changePriority(String name, int newPriority) {
        for (int i = 1; i < size + 1; i++) {
            if (array[i].name.equals(name)) {

                int oldP = array[i].priority;
                array[i].priority = newPriority;

                // Urgency has increased. Bubble up the queue
                if (newPriority < oldP)
                    bubbleUp(i);

                // Urgency has reduced. Bubble down the queue
                else if (newPriority > oldP)
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
     * @return The String representation of the queue with all of its patients
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
}
