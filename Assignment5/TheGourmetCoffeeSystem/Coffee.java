/**
 * @author YXH_XianYu
 * Created On 2022-04-02
 */

/**
 * The class Coffee models a coffee product. It extends class Product.
 */
public class Coffee extends Product {
    private String origin;
    private String roast;
    private String flavor;
    private String aroma;
    private String acidity;
    private String body;

    public Coffee(String code, String description, double price,
                  String origin,String roast, String flavor,
                  String aroma, String acidity, String body) {
        super(code, description, price);
        this.origin = origin;
        this.roast = roast;
        this.flavor = flavor;
        this.aroma = aroma;
        this.acidity = acidity;
        this.body = body;
    }

    public String getOrigin() {
        return origin;
    }

    public String getRoast() {
        return roast;
    }

    public String getFlavor() {
        return flavor;
    }

    public String getAroma() {
        return aroma;
    }

    public String getAcidity() {
        return acidity;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return super.getCode() + '_' + super.getDescription() + '_' + super.getPrice() + '_'
                + origin + '_' + roast + '_' + flavor + '_'
                + aroma + '_' + acidity + '_' + body;
    }
}
