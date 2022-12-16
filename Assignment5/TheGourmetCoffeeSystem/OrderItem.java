/**
 * @author YXH_XianYu
 * Created On 2022-04-02
 */

/**
 * Class OrderItem models an item in an order.
 */
public class OrderItem {
    private Product product;
    private int quantity;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getValue() {
        return product.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return quantity + " " + product.getCode() + " " + product.getPrice();
    }
}
