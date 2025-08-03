package com.ecommerce.order;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.http.dsl.Http;
import org.springframework.messaging.MessageChannel;

@Configuration
public class WebConfig {

    @Bean
    public MessageChannel orderChannel() {
        return new DirectChannel();
    }

    @Bean
    public IntegrationFlow orderFlow() {
        return IntegrationFlows.from("orderChannel")
                .handle(Http.outboundGateway("http://localhost:8081/esb/orders")
                        .httpMethod(HttpMethod.POST))
                .get();
    }
}
