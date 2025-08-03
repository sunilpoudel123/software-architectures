package order;

import com.ecommerce.model.Order;
import order.router.OrderTypeRouter;
import order.router.ShippingRouter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
public class IntegrationConfig {

    @Bean
    public IntegrationFlow orderFlow() {
        return IntegrationFlows.from(Http.inboundGateway("/esb/orders").requestMapping(r -> r.methods(HttpMethod.POST)))
                .channel("order.input")
                .route(Order.class, OrderTypeRouter::routeByType, mapping -> mapping
                        .subFlowMapping("international", sf -> sf.handle(Http.outboundGateway("http://localhost:8085/orders")))
                        .subFlowMapping("domestic", sf -> sf
                                .route(Order.class, ShippingRouter::routeByAmount, amountMap -> amountMap
                                        .subFlowMapping("nextday", s -> s.handle(Http.outboundGateway("http://localhost:8083/orders")))
                                        .subFlowMapping("normal", s -> s.handle(Http.outboundGateway("http://localhost:8084/orders"))))))
                .get();
    }
}