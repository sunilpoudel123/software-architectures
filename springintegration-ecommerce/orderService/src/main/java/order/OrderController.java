package order;

import com.ecommerce.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private RestTemplate restTemplate;

//	@Autowired
//	AccountFeignClient accountClient;

	@PostMapping
	public ResponseEntity<String> sendOrder(@RequestBody Order order) {
		restTemplate.postForObject("http://localhost:8081/esb/orders", order, String.class);
		return ResponseEntity.ok("Order sent to ESB");
	}

//	@FeignClient(name = "AccountService")
//	interface AccountFeignClient {
//		@RequestMapping("/account/{customerid}")
//		public Account getName(@PathVariable("customerid") String customerId);
//	}

}
