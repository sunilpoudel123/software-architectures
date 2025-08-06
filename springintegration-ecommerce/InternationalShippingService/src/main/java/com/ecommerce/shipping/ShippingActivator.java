package com.ecommerce.shipping;

import com.ecommerce.model.Order;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

@Component
public class ShippingActivator {

    @ServiceActivator(inputChannel = "shippingchannelInternational")
    public void handleOrder(Order order) {
        System.out.println("International Shipping received: " + order.getId());
    }
}