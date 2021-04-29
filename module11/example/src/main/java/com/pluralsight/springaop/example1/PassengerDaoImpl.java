package com.pluralsight.springaop.example1;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("passengerDao")
public class PassengerDaoImpl implements PassengerDao
{

    private static Map<Integer, Passenger> passengerMap = new HashMap<Integer, Passenger>();

    @Log
    public Passenger getPassenger(int id) {
        if (null != passengerMap.get(id)){
            return passengerMap.get(id);
        }

        if(id<1) throw new RuntimeException("incorrect id");
        Passenger passenger = new Passenger(id);
        passengerMap.put(id, passenger);
        return passenger;
    }
}
