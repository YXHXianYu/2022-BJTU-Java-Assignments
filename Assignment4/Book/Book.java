import java.util.Arrays;

/**
 * @author YXH_XianYu
 * @create 2022-03-29
 */
public class Book {
    private String name;
    private Author[] authors;
    private double price;
    private int qty = 0;

    // constructor
    public Book(String name, Author[] authors, double price) {
        this.name = name;
        this.authors = authors;
        this.price = price;
    }
    public Book(String name, Author[] authors, double price, int qty) {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qty = qty;
    }

    // getter
    public String getName() {
        return name;
    }
    public Author[] getAuthors() {
        return authors;
    }
    public double getPrice() {
        return price;
    }
    public int getQty() {
        return qty;
    }

    // setter (only price & qty)
    public void setPrice(double price) {
        this.price = price;
    }
    public void setQty(int qty) {
        this.qty = qty;
    }

    // toString methods
    public String toString() {
        // authors information
        String authorString = "{";
        for(int i = 0; i < authors.length; i++) {
            authorString += authors[i];
            if(i != authors.length - 1)
                authorString += ',';
        }
        authorString += "}";
        // others
        return "Book[" +
                "name=" + name +
                ",authors=" + authorString +
                ",price=" + price +
                ",qty=" + qty +
                ']';
    }
    public String getAuthorNames() {
        String str = "";
        for(int i = 0; i < authors.length; i++) {
            str += authors[i].getName();
            if(i != authors.length - 1)
                str += ',';
        }
        return str;
    }
}
