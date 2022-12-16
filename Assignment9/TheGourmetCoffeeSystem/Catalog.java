import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author YXH_XianYu
 * Created On 2022-05-15
 */
public class Catalog implements Iterable<Product> {
    // attribute
    private ArrayList<Product> products;

    // methods
    public Catalog() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Iterator<Product> iterator() {
        return products.iterator();
    }

    // find the product with specified code
    public Product getProduct(String code) {
        for(Product p: products)
            if(p.getCode().equals(code))
                return p;
        return null;
    }

    public int getNumberOfProducts() {
        return products.size();
    }
}
