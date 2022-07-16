package com.example.carMangement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "repository")  
@ComponentScan(basePackages= {"controllers","services","mapper"}) 
@EntityScan(value = "model")   
@SpringBootApplication
public class CarMangementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarMangementApplication.class, args);
	}

}
