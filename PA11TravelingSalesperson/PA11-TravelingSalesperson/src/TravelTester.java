public class TravelTester {
    public static void main(String args[]) {
        DGraph test = new DGraph(3);
        test.addEdge(1, 2, 1.0);
        test.addEdge(1, 3, 3.0);
        test.addEdge(2, 3, 5.0);
        test.addEdge(3, 1, 4.0);
        test.addEdge(2, 1, 2.0);
        test.addEdge(3, 2, 6.0);
        System.out.println(test.toDotString());
    }
}
