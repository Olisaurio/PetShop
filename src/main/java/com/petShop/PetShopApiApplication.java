package com.petShop;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.petShop.persistance.crud")
public class PetShopApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(PetShopApiApplication.class, args);
	}
}
