/**
 * @author YXH_XianYu
 * Created On 2022-04-28
 */
public class PlainTextSalesFormatter implements SalesFormatter {
    private static PlainTextSalesFormatter singletonInstance;

    public static PlainTextSalesFormatter getSingletonInstance() {
        if(singletonInstance == null)
            singletonInstance = new PlainTextSalesFormatter();
        return singletonInstance;
    }

    private PlainTextSalesFormatter() {
    }

    @Override
    public String formatSales(Sales sales) {
        StringBuilder str = new StringBuilder();

        for(Order order: sales) {
            str.append("------------------------\n");
            str.append("Order ").append(order.getNumberOfItems()).append("\n");
            str.append("\n");

            for(OrderItem item: order)
                str.append(item.getQuantity()).append(" ")
                        .append(item.getProduct().getCode()).append(" ")
                        .append(item.getProduct().getPrice()).append("\n");
            str.append("\n");
            str.append("Total = ").append(order.getTotalCost()).append("\n");
        }
        return str.toString();
    }
}
