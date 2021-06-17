package com.pluralsight.springaop.example1;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PassengersManager {

    public static void main(String[] args) {

        // AspectJProxyFactory vs ProxyFactory:
        // AspectJProxyFactory can add Aspect while ProxyFactory can not
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory(new PassengerDaoImpl());
        proxyFactory.addAspect(new LoggingAspect());

        //setExposeFactory to true in order to get currentProxy from AopContext
        //proxyFactory.setExposeProxy(true);

        PassengerDao proxy = proxyFactory.getProxy();
        System.out.println(proxy.getPassenger(1));
    }
}
