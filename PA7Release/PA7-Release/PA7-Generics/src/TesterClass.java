
public class TesterClass {
    public static void main(String args[]) {
        // ListStack<Integer> s = new ListStack<>();
        // ListStack<Integer> t = new ListStack<>();
        // System.out.println(s.isEmpty());
        // System.out.println(s.equals(t));
        // t.push(45);
        // t.push(55);
        // System.out.println(s);
        // System.out.println(s.isEmpty());
        // s.push(45);
        // s.push(55);
        // s.push(66);
        // System.out.println(s.equals(t));
        // s.push(77);
        // System.out.println(s.size());
        // System.out.println(s);
        // System.out.println(s.pop());
        // System.out.println(s);
        // System.out.println(s.pop());
        // System.out.println(s);
        // System.out.println(t);
        // System.out.println(s.equals(t));
        // s.clear();
        // System.out.println(s);
        // System.out.println(s.isEmpty());
        // System.out.println(s.peek());
        // System.out.println(s.pop());

        ListQueue<Integer> p = new ListQueue<>();
        System.out.println(p);
        p.enqueue(7);
        p.enqueue(8);
        p.enqueue(9);
        System.out.println(p);
        ListQueue<Integer> q = new ListQueue<>(p);
        System.out.println(q);
        System.out.println(q.equals(p));
        System.out.println(q.dequeue());
        System.out.println(q);
        System.out.println(q.peek());
        System.out.println(q);
        System.out.println(q.dequeue());
        System.out.println(q);
        System.out.println(q.dequeue());
        System.out.println(q);
        q.enqueue(30);
        System.out.println(q);
        System.out.println(q.equals(p));
    }
}
