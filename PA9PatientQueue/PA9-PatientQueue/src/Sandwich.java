public class Sandwich {

    private static int totalSold = 0;
    private String name;
    private int length;
    private boolean isVegetarian;

    public Sandwich(String name, int length, boolean isVegetarian) {
        this.name = name;
        this.length = length;
        this.isVegetarian = isVegetarian;
        totalSold++;
    }

    public Sandwich(Sandwich sandwich) {
        this.name = sandwich.name;
        this.length = sandwich.length;
        this.isVegetarian = sandwich.isVegetarian;
        totalSold++;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int newLength) {
        this.length = newLength;
    }

    public boolean isVegetarian() {
        return this.isVegetarian;
    }

    public int getTotalSandwichesSold() {
        return totalSold;
    }

    public boolean equals(Object o) {
        if (o instanceof Sandwich) {
            Sandwich s = (Sandwich) o;
            return (this.isVegetarian == s.isVegetarian)
                    && (this.length == s.length) && (this.name.equals(s.name));
        } else
            return false;
    }

    public String toString() {
        String retval = "The " + this.name + " sandwich is " + this.length + " inches ling, and is ";
        if(isVegetarian)
            return retval + "vegetarian";
        else
            return retval + "not vegetarian";
    }
}
