import java.io.PrintStream;

public class Tree {

    public static Patient dequeue(Node root, Node lastParent) {
        Patient toRemove = root.patient;
        // Remove the last node and make it the new root of the tree
        if (lastParent.rightChild != null) {
            Node newRoot = lastParent.rightChild;
            lastParent.rightChild = null;
            root.patient = newRoot.patient;
        } else {
            Node newRoot = lastParent.leftChild;
            lastParent.leftChild = null;
            root.patient = newRoot.patient;
        }
        bubbleDown(root);
        return toRemove;
    }

    private static void bubbleDown(Node root) {
        if (root.rightChild != null) {
            Patient left = root.leftChild.patient,
                    right = root.rightChild.patient;
            if (right.priority < left.priority) {
                compareSwap(root, root.rightChild);
                bubbleDown(root.rightChild);
            }

            else if (right.priority > left.priority) {
                compareSwap(root, root.leftChild);
                bubbleDown(root.leftChild);
            }

            else {
                if (left.name.compareTo(right.name) <= 0) {
                    compareSwap(root, root.leftChild);
                    bubbleDown(root.leftChild);
                }

                else {
                    compareSwap(root, root.rightChild);
                    bubbleDown(root.rightChild);
                }
            }
        } // Since the right child is empty, the left child can't be null
        else if (root.leftChild != null)
            compareSwap(root, root.leftChild);
    }

    // This method compares the parent and one of its children and swaps if
    // necessary
    public static void compareSwap(Node first, Node second) {
        if (first.patient.priority > second.patient.priority) {
            Patient temp = first.patient;
            first.patient = second.patient;
            second.patient = temp;
        } else if (first.patient.priority == second.patient.priority) {
            if (first.patient.name.compareTo(second.patient.name) <= 0) {
                Patient temp = first.patient;
                first.patient = second.patient;
                second.patient = temp;
            }
        }
    }

    public static void print(Node root, StringBuilder s) {
        if (root != null) {
            s.append(root.patient);
            s.append("\n");
            print(root.leftChild, s);
            print(root.rightChild, s);
        }
    }

    public static void printS(PrintStream os, Node root) {
        StringBuilder s = new StringBuilder();
        print(root, s);
        os.print(s.toString());
    }
}
