package com.saiteja.product_service_microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class 	ProductServiceMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceMicroserviceApplication.class, args);
	}

}
