package com.example.ticket_football;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class TicketFootballApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketFootballApplication.class, args);
	}

}
