package order.router;

import com.ecommerce.model.Order;

public class OrderTypeRouter {
    public static String routeByType(Order order) {
        return order.getOrderType().equalsIgnoreCase("international") ? "international" : "domestic";
    }
}
