package com.pluralsight.springaop.flightsmanagement.domain;

import com.pluralsight.springaop.flightsmanagement.flyer.Flyer;
import com.pluralsight.springaop.flightsmanagement.flyer.FlyerAdvisor;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertTrue;

public class FlyerTest {
    @Test
    public void flyerTest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");

        Flight flight = (Flight) context.getBean("flight");

        FlyerAdvisor flyerAdvisor = new FlyerAdvisor();
        ProxyFactory proxyFactory = new ProxyFactory();

        proxyFactory.setTarget(flight);
        proxyFactory.addAdvisor(flyerAdvisor);
        proxyFactory.setOptimize(true);

        Flight proxyFlight = (Flight)proxyFactory.getProxy();
        assertTrue(proxyFlight instanceof Flight);
        System.out.println(proxyFlight.getId());
        System.out.println(proxyFlight.getCompany());

        assertTrue(proxyFlight instanceof Flyer);
        ((Flyer)proxyFlight).takeOff();
        ((Flyer)proxyFlight).fly();
        ((Flyer)proxyFlight).land();

        System.out.println(proxyFlight.getClass().getName());


        context.close();
    }
}
