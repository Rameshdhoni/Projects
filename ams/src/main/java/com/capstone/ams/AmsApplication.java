package com.capstone.ams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootApplication

public class AmsApplication {

	public static void main(String[] args) {
		log.info("Main method execution started successfully");
		SpringApplication.run(AmsApplication.class, args);
	}

}
