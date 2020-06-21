
public class goo extends foo {
    public void one() {
        System.out.println("Goo One");
        super.one();
    }

    public void two() {
        super.two(22);
        System.out.println("Goo Two");
    }

    public void three() {
        super.one();
        super.two(22);
        System.out.println("Goo Three");
    }
}
