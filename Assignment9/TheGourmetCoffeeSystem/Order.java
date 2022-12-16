import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author YXH_XianYu
 * Created On 2022-05-15
 */
public class Order implements Iterable<OrderItem> {
    // vars
    private ArrayList<OrderItem> items;

    // methods
    public Order() {
        items = new ArrayList<>();
    }

    public void addItem(OrderItem orderItem) {
        items.add(orderItem);
    }

    public void removeItem(OrderItem orderItem) {
        items.remove(orderItem);
    }

    public Iterator<OrderItem> iterator() {
        return items.iterator();
    }

    public OrderItem getItem(Product product) {
        for(OrderItem i: items)
            if(i.getProduct().equals(product))
                return i;
        return null;
    }

    public int getNumberOfItems() {
        return items.size();
    }

    public double getTotalCost() {
        double sum = 0.0;
        for(OrderItem i: items)
            sum += i.getValue();
        return sum;
    }
}
