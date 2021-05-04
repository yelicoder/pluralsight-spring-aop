package com.pluralsight.springaop.flightsmanagement.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect1 {
    private Logger logger =
            Logger.getLogger(LoggingAspect1.class.getName());

    @Before("execution(public String com.pluralsight.springaop.flightsmanagement.domain.Flight.getId())")
    public void loggingAdviceGetId() {
        logger.info("Flight getId method will be called");
    }

    @AfterReturning("execution(public * *.print())")
    public void LoggingAdvicePrint(){
        logger.warning("A print method has been called");
    }

    @Pointcut("within(com.pluralsight.springaop.flightsmanagement.domain.Ticket)")
    public void allTicketMethods() {
    }

    @After("allTicketMethods()")
    public void loggingAdvice(JoinPoint joinPoint){
        logger.info("A ticket method had been called.");
        logger.info(joinPoint.toString());
        logger.info(joinPoint.getTarget().toString());
    }
}
