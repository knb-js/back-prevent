package com.back.prev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BackPreventionApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackPreventionApplication.class, args);
	}

}
