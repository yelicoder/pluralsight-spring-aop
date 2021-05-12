package com.pluralsight.springaop.flightsmanagement.flyer;

import org.aopalliance.aop.Advice;
import org.springframework.aop.support.DefaultIntroductionAdvisor;

public class FlyerAdvisor extends DefaultIntroductionAdvisor {

    public FlyerAdvisor() {
        super(new FlyerImpl());
    }
}