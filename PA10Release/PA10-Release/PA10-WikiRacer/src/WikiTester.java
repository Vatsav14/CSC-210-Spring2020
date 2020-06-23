import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WikiTester {
	public static void main(String args[]) {
//		MaxPQ m = new MaxPQ();
//		ArrayList<String> x = new ArrayList<>();
//		x.add("Hello");
//		x.add("This");
//		x.add("is");
//		x.add("Vatsav");
//		ArrayList<String> y = new ArrayList<>();
//		y.add("I");
//		y.add("like");
//		y.add("food");
//		m.enqueue(x, 50);
//		m.enqueue(y, 6);
//		System.out.println(m);
//		System.out.println(m.dequeue());
//		System.out.println(m.dequeue());
		Set<String> s1 = new HashSet<>();
		Set<String> s2 = new HashSet<>();
		s1.add("Hello"); s2.add("Hello");
		s1.add("this");  s2.add("this");
		s1.add("is"); s2.add("is");
		s1.add("Vatsav"); s2.add("Racer");
		Set<String> intersection = new HashSet<>(s1);
		intersection.retainAll(s2);
		System.out.println(intersection.size());
	}
}