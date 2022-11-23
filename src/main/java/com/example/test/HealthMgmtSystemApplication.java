package com.example.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HealthMgmtSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthMgmtSystemApplication.class, args);
	}

}
