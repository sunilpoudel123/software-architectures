package com.ecommerce.warehouse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.http.dsl.Http;
import org.springframework.messaging.MessageChannel;

@Configuration
public class WarehouseConfig {

    @Bean
    public MessageChannel warehousechannel() {
        return new DirectChannel();
    }

    @Bean
    public IntegrationFlow warehouseInboundFlow() {
        return IntegrationFlows.from(Http.inboundGateway("/esb/orders"))
                .channel("warehousechannel")
                .get();
    }
}