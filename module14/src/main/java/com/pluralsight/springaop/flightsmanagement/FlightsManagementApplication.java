package com.pluralsight.springaop.flightsmanagement;

import com.pluralsight.springaop.flightsmanagement.domain.Flight;
import com.pluralsight.springaop.flightsmanagement.domain.Passenger;
import com.pluralsight.springaop.flightsmanagement.domain.Ticket;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FlightsManagementApplication {

	public static void main(String[] args) {

		SpringApplication.run(FlightsManagementApplication.class, args);
	}

}
