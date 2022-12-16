/**
 * @author YXH_XianYu
 * Created On 2022-04-28
 */
public class HTMLSalesFormatter implements SalesFormatter {
    private static HTMLSalesFormatter singletonInstance;

    public static HTMLSalesFormatter getSingletonInstance() {
        if(singletonInstance == null)
            singletonInstance = new HTMLSalesFormatter();
        return singletonInstance;
    }

    private HTMLSalesFormatter() {
    }

    @Override
    public String formatSales(Sales sales) {
        StringBuilder str = new StringBuilder();

        str.append("<html>\n");
        str.append("  <body>\n");
        str.append("    <center><h2>Orders</h2></center>\n");
        for(Order i: sales) {
            str.append("    <hr>\n");
            str.append("    <h4>Total = ").append(i.getTotalCost()).append("</h4>\n");
            for(OrderItem j: i) {
                str.append("      <p>\n");
                str.append("        <b>code:</b> ").append(j.getProduct().getCode()).append("<br>\n");
                str.append("        <b>quantity:</b> ").append(j.getQuantity()).append("<br>\n");
                str.append("        <b>price:</b> ").append(j.getProduct().getPrice()).append("\n");
                str.append("      </p>\n");
            }
        }
        str.append("  </body>\n");
        str.append("</html>\n");
        return str.toString();
    }
}
