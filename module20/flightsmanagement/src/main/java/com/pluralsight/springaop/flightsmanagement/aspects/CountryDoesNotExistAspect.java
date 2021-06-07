package com.pluralsight.springaop.flightsmanagement.aspects;

import com.pluralsight.springaop.flightsmanagement.exceptions.CountryDoesNotExistException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.logging.Logger;

@Aspect
public class CountryDoesNotExistAspect {

    private Logger logger = Logger.getLogger(CountryDoesNotExistAspect.class.getName());

    @Around("execution (* com.pluralsight.springaop.flightsmanagement.dao.PassengerDaoImpl.insert(..))")
    public Object log (ProceedingJoinPoint thisJointPoint) throws  Throwable{
        String methodName = thisJointPoint.getSignature().getName();
        Object[] methodArgs = thisJointPoint.getArgs();
        logger.info("Call method " + methodName + " with arg " + methodArgs[0]);
        Object result = new Object();
        try {
            result = thisJointPoint.proceed();
        } catch (Exception ex) {
            logger.severe("Call method" + methodName + "with arg" + methodArgs[0] + " throws exception");
        }
        logger.info("Method " + methodName + " returns " + result);
        return result;
    }
}
