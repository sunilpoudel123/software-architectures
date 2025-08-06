package com.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class InternationalShippingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InternationalShippingServiceApplication.class, args);
	}
}
