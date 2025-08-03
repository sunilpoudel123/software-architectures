package shipping.nextday;

import com.ecommerce.model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderReceiverController {

    @PostMapping("/orders")
    public ResponseEntity<String> receiveOrder(@RequestBody Order order) {
        System.out.println("NextDay Shipping received: " + order.getId());
        return ResponseEntity.ok("NextDay Received");
    }
}
