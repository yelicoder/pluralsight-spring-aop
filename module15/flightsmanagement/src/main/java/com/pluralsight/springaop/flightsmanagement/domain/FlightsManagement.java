package com.pluralsight.springaop.flightsmanagement.domain;

import com.pluralsight.springaop.flightsmanagement.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;

public class FlightsManagement
{
    private static Flight flight;
    private static Ticket ticket;

    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        flight = context.getBean(Flight.class);
        ticket = context.getBean(Ticket.class);

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

        System.out.println( flight.getId());
        flight.setId("AA5678");

        System.out.println(flight.getCompany());

        for (Passenger passenger: flight.getPassengers()) {
            System.out.println(passenger.getName());
            passenger.print();
        }

        Ticket ticket = (Ticket) context.getBean("ticket");
        ticket.setNumber("0987654321");
    }
}
