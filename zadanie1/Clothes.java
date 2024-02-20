package zadanie1;



public class Clothes implements Comparable<Clothes> {
    private String name;
    private int size;
    private double price;
    private static Criterion sortingCriterion;

    public Clothes(String name, int size, double price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int compareTo(Clothes o) {
        switch (sortingCriterion) {
            case PRICE:
                return Double.compare(this.price, o.price);
            case SIZE:
            default:
                return Integer.compare(this.size, o.size);
        }
    }

    public static void setSortingCriterion(Criterion criterion) {
        sortingCriterion = criterion;
    }
}
