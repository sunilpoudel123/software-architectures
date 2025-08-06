package com.ecommerce.shipping;

import com.ecommerce.model.Order;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

@Component
public class ShippingActivator {
    @ServiceActivator(inputChannel = "shippingchannelNormal")
    public void receive(Order order) {
        System.out.println("Normal shipping received: " + order.getId());
    }
}
