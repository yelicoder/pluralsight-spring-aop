package com.pluralsight.springaop.flightsmanagement.aspects;

import com.pluralsight.springaop.flightsmanagement.dao.PassengerDaoImpl;
import com.pluralsight.springaop.flightsmanagement.domain.Passenger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

@Aspect
@Order(3)
public class CachingAspect {

    @Around("execution(* com.pluralsight.springaop.flightsmanagement.dao.PassengerDaoImpl.getPassenger(..))")
    public void cachePassenger(ProceedingJoinPoint thisJointPoint) throws Throwable{
        Object[] methodArgs = thisJointPoint.getArgs();
        Passenger result = (Passenger) thisJointPoint.proceed();

        int id = (Integer)methodArgs[0];

        if (!PassengerDaoImpl.getPassengerMap().containsKey(id)){
            PassengerDaoImpl.getPassengerMap().put(id, result);
        }
    }
}
