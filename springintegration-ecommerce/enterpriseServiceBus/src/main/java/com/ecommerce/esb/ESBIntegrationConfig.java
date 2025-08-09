package com.ecommerce.esb;

import com.ecommerce.model.Order;
import com.ecommerce.esb.router.OrderTypeRouter;
import com.ecommerce.esb.router.ShippingRouter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.http.dsl.Http;
import org.springframework.messaging.MessageChannel;

@Configuration
public class ESBIntegrationConfig {

    @Bean
    public MessageChannel esbInputChannel() {
        return new DirectChannel();
    }

    @Bean
    public IntegrationFlow esbInboundFlow() {
        return IntegrationFlows.from(Http.inboundGateway("/esb/orders")
                        .requestMapping(r -> r.methods(HttpMethod.POST))
                        .requestPayloadType(Order.class))
                .channel("esbInputChannel")
                .handle(m -> System.out.println("Received in ESB: " + m.getPayload()))
                .get();
    }

    @Bean
    public IntegrationFlow esbRouterFlow() {
        return IntegrationFlows.from("esbInputChannel")
                .route(Order.class, OrderTypeRouter::routeByType, r -> r

                        .subFlowMapping("international", sf -> sf
                                .handle(Http.outboundGateway("http://localhost:8085/shipping/international")
                                        .httpMethod(HttpMethod.POST)))


                        .subFlowMapping("domestic", sf -> sf
                                .route(Order.class, ShippingRouter::routeByAmount, ra -> ra
                                        .subFlowMapping("nextday", s -> s
                                                .handle(Http.outboundGateway("http://localhost:8084/shipping/nextday")
                                                        .httpMethod(HttpMethod.POST)))

                                        .subFlowMapping("normal", s -> s
                                                .handle(Http.outboundGateway("http://localhost:8083/shipping/normal")
                                                        .httpMethod(HttpMethod.POST))))))
                .get();
    }
}