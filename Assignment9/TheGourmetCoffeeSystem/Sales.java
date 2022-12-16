import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author YXH_XianYu
 * Created On 2022-05-15
 */
public class Sales implements Iterable<Order> {
    // vars
    private ArrayList<Order> orders;

    // methods
    public Sales() {
        orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public Iterator<Order> iterator() {
        return orders.iterator();
    }

    public int getNumberOfOrders() {
        return orders.size();
    }
}
