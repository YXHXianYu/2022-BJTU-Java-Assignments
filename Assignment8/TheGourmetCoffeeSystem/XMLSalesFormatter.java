/**
 * @author YXH_XianYu
 * Created On 2022-04-28
 */
public class XMLSalesFormatter implements SalesFormatter {
    private static XMLSalesFormatter singletonInstance;

    public static XMLSalesFormatter getSingletonInstance() {
        if(singletonInstance == null)
            singletonInstance = new XMLSalesFormatter();
        return singletonInstance;
    }

    private XMLSalesFormatter() {
    }

    public String formatSales(Sales sales) {
        StringBuilder str = new StringBuilder();
        str.append("<Sales>\n");
        for(Order i: sales) {
            str.append("  <Order total=\"").append(i.getTotalCost()).append("\">\n");
            for(OrderItem j: i) {
                str.append("    <OrderItem quantity=\"").append(j.getQuantity()).append("\"\n");
                str.append("price=\"").append(j.getProduct().getPrice()).append("\">")
                        .append(j.getProduct().getCode()).append("</OrderItem>\n");
            }
            str.append("  </Order>\n");
        }
        str.append("</Sales>\n");
        return str.toString();
    }
}
