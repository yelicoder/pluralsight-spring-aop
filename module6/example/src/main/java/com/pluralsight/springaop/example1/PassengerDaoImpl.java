package com.pluralsight.springaop.example1;

import java.util.HashMap;
import java.util.Map;

public final class PassengerDaoImpl
{

    private static Map<Integer, Passenger> passengerMap = new HashMap<Integer, Passenger>();

    public Passenger getPassenger(int id) {
        if (null != passengerMap.get(id)){
            return passengerMap.get(id);
        }

        Passenger passenger = new Passenger(id);
        passengerMap.put(id, passenger);
        return passenger;
    }
}
