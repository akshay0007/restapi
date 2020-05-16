package com.staxrt.tutorial.config;

import com.staxrt.tutorial.EventHandling.LoginFailureEvent;
import com.staxrt.tutorial.EventHandling.LoginFailureEventPub;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

//Aspect -->comb of advice with point cut
//Pointcut--> expression present in annoation
//        Advices==> method definition written inside AOP classes
//        Waving--> execution of method correct time
//        Joinpoint-->specific exe. point of aspect

/**
 * Created by ubuntu on 14/05/20.
 */
@Aspect
@Component
public class AopConfigure {
    private static final Logger LOG = LoggerFactory.getLogger(AopConfigure.class);
    LoginFailureEventPub loginFailureEventPub;

    @Autowired
    public AopConfigure(LoginFailureEventPub loginFailureEventPub) {
        this.loginFailureEventPub = loginFailureEventPub;
    }


//    @Pointcut("execution(* com.staxrt.tutorial.dummyImpl.LoginAuthDao.isAuthenticate(..))")
//    void doAuthenticate() {
//        LOG.info("do authentication");
//
//    }

//    @Before("com.staxrt.tutorial.config.CommonPointCut.businessLayer()")
//    void beforeAuthenticate(JoinPoint joinPoint) {
//        loginFailureEventPub.publishEvent(new LoginFailureEvent("failt eve"));
//        LOG.info("before authetication+=" + joinPoint.getSignature());
//        LOG.info("before authetication+=" + joinPoint.getArgs());
//    }


//    @AfterReturning(value = "com.staxrt.tutorial.config.CommonPointCut.businessLayer()", returning = "result")
//    void afterAuth(JoinPoint joinPoint, Object result) {
//        LOG.info("after authetication+=" + joinPoint.getSignature());
//        LOG.info("after authetication+=" + joinPoint.getArgs());
//        LOG.info("after authetication+=" + result);
//    }

    @Around(value = "com.staxrt.tutorial.config.CommonPointCut.tracInfo() && args(name,password)")
    void afterProc(ProceedingJoinPoint joinPoint, String name, String password) throws Throwable {
        loginFailureEventPub.publishEvent(new LoginFailureEvent("failt eve"));
        LOG.info("proccess");
        LOG.info(name + "==" + password);
        LocalDate start = LocalDate.now();
        joinPoint.proceed();
        LocalDate end = LocalDate.now();
        LOG.info("done");
    }

//    @Before("com.staxrt.tutorial.config.AopConfigure.doAuthenticate() && args(username,password)")
//    void beforeAuthenticate() {
//        LOG.info("before authetication");
//    }


//    @AfterReturning(value = "com.staxrt.tutorial.config.AopConfigure.doAuthenticate()",returning = "")
//    void afterAuthenticate(){
//
//    }


//    @AfterThrowing(value = "com.staxrt.tutorial.config.AopConfigure.doAuthenticate() && args(username,password)")
//    void afterThrowing(){
//
//    }


}