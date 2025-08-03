package com.ecommerce.order;

import com.ecommerce.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private MessageChannel orderChannel;

	@PostMapping
	public ResponseEntity<String> placeOrder(@RequestBody Order order) {
		orderChannel.send(MessageBuilder.withPayload(order).build());
		return ResponseEntity.ok("Order sent to ESB");
	}
}