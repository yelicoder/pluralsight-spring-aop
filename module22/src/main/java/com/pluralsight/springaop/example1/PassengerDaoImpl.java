package com.pluralsight.springaop.example1;

import org.springframework.aop.framework.AopContext;

import java.util.HashMap;
import java.util.Map;

public class PassengerDaoImpl implements PassengerDao {

    private static Map<Integer, Passenger> passengerMap = new HashMap<Integer, Passenger>();

    public Passenger getPassenger(int id) {
        if (null != passengerMap.get(id)){
            return passengerMap.get(id);
        }

        Passenger passenger = new Passenger(id);
        passengerMap.put(id, passenger);
        selfInvocation("test");

        return passenger;
    }

    public void selfInvocation(String s)
    {
        System.out.println("Self invocation " + s);
    }
}
