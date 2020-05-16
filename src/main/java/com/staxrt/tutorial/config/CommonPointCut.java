package com.staxrt.tutorial.config;

import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by ubuntu on 16/05/20.
 */
public class CommonPointCut {
    private static final Logger LOG = LoggerFactory.getLogger(CommonPointCut.class);


//    @Pointcut("execution(* com.staxrt.tutorial.controller.EmployeeController.*(..))")
//    void businessLayer() {
//        LOG.info("v info");
//    }


    @Pointcut("@annotation(com.staxrt.tutorial.config.TrackInfo)")
    void tracInfo() {
    }
}
