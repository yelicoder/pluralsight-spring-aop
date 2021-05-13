package com.pluralsight.springaop.flightsmanagement.domain;

import com.pluralsight.springaop.flightsmanagement.flyer.Flyer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.Assert.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = com.pluralsight.springaop.flightsmanagement.config.Config.class)
public class FlyerTest {

    @Autowired
    private Flight flight;

    @Test
    public void flyerTest() {
        assertTrue(flight instanceof Flight);
        System.out.println(flight.getId());
        System.out.println(flight.getCompany());

        assertTrue( flight instanceof Flyer);
        ((Flyer)flight).takeOff();
        ((Flyer)flight).land();
        ((Flyer)flight).fly();

        System.out.println(flight.getClass().getName());
    }
}
