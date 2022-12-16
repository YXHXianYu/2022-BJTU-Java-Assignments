public class Product {
    private String name;
    private double price;
    private int number;
    public Product(String name, double price,int number) {
        this.name = name;
        this.price = price;
        this.number= number;
    }
    public String getName() {
        return this.name;
    }
    public int getNumber() {
        return this.number;
    }
    public double getPrice() {
        return this.price;
    }
}