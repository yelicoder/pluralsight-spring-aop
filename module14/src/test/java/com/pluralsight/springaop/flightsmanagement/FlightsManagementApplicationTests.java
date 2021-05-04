package com.pluralsight.springaop.flightsmanagement;

import com.pluralsight.springaop.flightsmanagement.domain.Passenger;
import com.pluralsight.springaop.flightsmanagement.domain.Flight;
import com.pluralsight.springaop.flightsmanagement.domain.Ticket;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class FlightsManagementApplicationTests {

	@Autowired
	Flight flight;

	@Autowired
	Ticket ticket;

	@Autowired
	private ApplicationContext context;

	@Test
	public void testPrintFlight() {

		Passenger jim = context.getBean(Passenger.class);
		jim.setName("Jim");
		jim.setCountry("US");

		Passenger jack = context.getBean(Passenger.class);
		jack.setName("Jack");
		jack.setCountry("UK");

		Passenger jill = context.getBean(Passenger.class);
		jill.setName("Jill");
		jill.setCountry("AU");

		List<Passenger> passengers = Arrays.asList(jim, jack, jill);
		flight.setPassengers(passengers);
		flight.setId("AA1234");
		flight.setCompany("ABC Flights");

		flight.print();

		System.out.println(flight.getId());
		flight.setId("AA5678");

		System.out.println(flight.getCompany());

		for (Passenger passenger : flight.getPassengers()) {
			System.out.println(passenger.getName());
			passenger.print();
		}

		ticket.setPassenger(jim);
		ticket.setNumber("1234567890");
		ticket.setNumber("0987654321");
	}
}
