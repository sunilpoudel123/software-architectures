package com.ecommerce.shipping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.http.dsl.Http;
import org.springframework.messaging.MessageChannel;

@Configuration
public class InternationalShippingConfig {

    @Bean
    public MessageChannel shippingchannelInternational() {
        return new DirectChannel();
    }

    @Bean
    public IntegrationFlow shippingInboundFlow() {
        return IntegrationFlows.from(Http.inboundGateway("/shipping/international"))
                .channel("shippingchannelInternational")
                .get();
    }
}
