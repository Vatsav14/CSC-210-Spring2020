import java.util.ArrayList;
import java.util.Stack;
import java.util.TreeSet;

public class TesterClass {
    public static void main(String args[]) {
        // Node root = new Node();
        // root.patient = new Patient("Yosef", 3);
        // Node now = new Node();
        // now.patient = new Patient("Vatsav", 6);
        // root.leftChild = now;
        // now = new Node();
        // now.patient = new Patient("Erica", 4);
        // root.rightChild = now;
        // now = new Node();
        // now.patient = new Patient("Caroline", 9);
        // root.leftChild.leftChild = now;
        // now = new Node();
        // now.patient = new Patient("Casey", 8);
        // root.leftChild.rightChild = now;
        // now = new Node();
        // now.patient = new Patient("Andres", 5);
        // root.rightChild.leftChild = now;
        // now = new Node();
        // now.patient = new Patient("Hamza", 5);
        // root.rightChild.rightChild = now;
        // now = new Node();
        // now.patient = new Patient("Karly", 11);
        // root.leftChild.leftChild.leftChild = now;
        // now = new Node();
        // now.patient = new Patient("Aditya", 10);
        // root.leftChild.leftChild.rightChild = now;
        //
        // Tree.printS(System.out, root);
        // Node lp = root.leftChild.leftChild;
        // Tree.dequeue(root, lp);
        // System.out.println("\n\n");
        // Tree.printS(System.out, root);
        // Tree.dequeue(root, lp);
        // System.out.println("\n\n");
        // Tree.printS(System.out, root);
        // lp = root.rightChild;
        // Tree.dequeue(root, lp);
        // System.out.println("\n\n");
        // Tree.printS(System.out, root);
        // lp = root.rightChild;
        // Tree.dequeue(root, lp);
        // System.out.println("\n\n");
        // Tree.printS(System.out, root);
        // lp = root.leftChild;
        // Tree.dequeue(root, lp);
        // System.out.println("\n\n");
        // Tree.printS(System.out, root);
        // lp = root.leftChild;
        // Tree.dequeue(root, lp);
        // System.out.println("\n\n");
        // Tree.printS(System.out, root);
        // lp = root;
        // Tree.dequeue(root, lp);
        // System.out.println("\n\n");
        // Tree.printS(System.out, root);
        // lp = root;
        // Tree.dequeue(root, lp);
        // System.out.println("\n\n");
        // Tree.printS(System.out, root);

        TreeSet<String> help = new TreeSet<String>();
        help.add("1");
        help.add("2");
        help.add("3");
        sandwiches(help);

    }

    public static void sandwiches(TreeSet<String> ingredients) {
        helper1(new ArrayList<String>(ingredients), new TreeSet<String>());
    }

    public static void helper1(ArrayList<String> in, TreeSet<String> soFar) {
        for (int i = 0; i <= in.size(); i++) {
            helper(in, soFar, i);
        }
    }

    public static void helper(ArrayList<String> in, TreeSet<String> soFar,
            int size) {

        if (size == 0)
            System.out.println(soFar);
        else {
            for (int i = 0; i < in.size(); i++) {
                String choice = in.get(i);
                if(!soFar.contains(choice)) {
                    soFar.add(choice);
                    helper(in, soFar, size - 1);
                    soFar.remove(choice);
                }
            }
        }
    }

    // public int returnLargest() {
    // if (root == null)
    // throw new NoSuchElementException("The Set is empty");
    // Node temp = root;
    // while (temp.rightChild != null) {
    // temp = temp.rightChild;
    // }
    // return temp.value;
    // }

    public static void printSquares(int num) {
        printHelper((int) Math.sqrt(num), num, new ArrayList<Integer>(), 1);
    }

    public static void printHelper(int max, int sum, ArrayList<Integer> soFar,
            int cur) {
        if (sum == 0) {
            System.out.println(soFar);
        } else {
            for (int i = cur; i <= max; i++) {
                if (sum - (i * i) < 0)
                    return;
                soFar.add(i);
                printHelper(max, sum - (i * i), soFar, i + 1);
                soFar.remove(new Integer(i));
            }
        }
    }

    public static void swapEnds(Stack<String> stack) {
        Stack<String> temp = new Stack<String>();
        String first = stack.pop();
        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }
        stack.push(first);
        first = temp.pop();
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
        stack.push(first);
    }
}
