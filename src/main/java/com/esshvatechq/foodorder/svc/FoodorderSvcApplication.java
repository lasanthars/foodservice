package com.esshvatechq.foodorder.svc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FoodorderSvcApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(FoodorderSvcApplication.class, args);
	}
}
