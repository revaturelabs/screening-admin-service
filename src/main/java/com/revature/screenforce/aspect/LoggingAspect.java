package com.revature.screenforce.aspect;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
 * Provides an aspect to modularize the logging concern for the service.
 * @author Isaac Pawling | 1805-WVU | Richard Orr
 */
@Component
@Aspect
public class LoggingAspect {
    /*
     * Applies advice to join points matched by everything()
     * Logs the method called and the parameters passed.
     * If any errors are thrown, the stacktrace is logged.
     * The returned object is also logged.
     * 
     * @param pjp the ProceedingJoinPoint used to expose target method invocation via the .proceed() method
     * @return obj the object returned by the function
     * @author Isaac Pawling | 1805-WVU | Richard Orr
     */
    @Around("everything()")
    public Object log(ProceedingJoinPoint pjp) throws Throwable {
        Object obj = null;
        Logger log = LogManager.getLogger(pjp.getTarget().getClass());
        log.info("Method with signature: "+pjp.getSignature());
        log.info("With arguments: "+Arrays.toString(pjp.getArgs()));
     
        try {
            obj = pjp.proceed();
        } catch (Exception e) {
            log.error(e.getMessage());
            for(StackTraceElement s : e.getStackTrace()) {
                log.warn(s);
            }
        }
        log.info(pjp.getSignature()+" returned: "+obj);
        return obj;
    }   
    
    /*
     * Specifies the predicate to match join points.
     * All spring bean methods in the application are matched. 
     * @author Isaac Pawling | 1805-WVU | Richard Orr
     */
    @Pointcut("execution(* com.revature.screenforce..*(..))")
    public void everything() { /* Empty method for Aspect Pointcut */ }
}
