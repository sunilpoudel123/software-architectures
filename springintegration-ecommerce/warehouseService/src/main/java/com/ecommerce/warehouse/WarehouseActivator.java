package com.ecommerce.warehouse;

import com.ecommerce.model.Order;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

@Component
public class WarehouseActivator {

    @ServiceActivator(inputChannel = "warehousechannel")
    public void handleOrder(Order order) {
        System.out.println("Warehouse received: " + order.getId());
    }
}