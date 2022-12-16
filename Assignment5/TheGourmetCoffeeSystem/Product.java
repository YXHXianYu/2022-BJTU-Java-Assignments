/**
 * @author YXH_XianYu
 * Created On 2022-04-02
 */

/**
 * The class Product models a generic product in the store.
 */
public class Product {
    private String code;
    private String description;
    private double price;

    public Product(String code, String description, double price) {
        this.code = code;
        this.description = description;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    // Two Product objects are equal if their codes are equal.
    // If parameter object is not an instance of Product, return false;
    @Override
    public boolean equals(Object object) {
        if(object instanceof Product) {
            // Use equals to judge whether it is equal when using String class
            // I almost forgot it. thanks to IDEA.
            return this.code.equals(((Product) object).code);
        } else {
            // If object is not Product, return false;
            return false;
        }
    }

    @Override
    public String toString() {
        return code + '_' + description + '_' + price;
    }
}
