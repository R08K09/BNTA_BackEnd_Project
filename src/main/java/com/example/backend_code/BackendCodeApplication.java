package com.example.backend_code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BackendCodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendCodeApplication.class, args);
	}

}
