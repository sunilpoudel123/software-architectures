package com.ecommerce.esb.router;

import com.ecommerce.model.Order;

public class ShippingRouter {
    public static String routeByAmount(Order order) {
        return order.getAmount() > 175 ? "nextday" : "normal";
    }
}