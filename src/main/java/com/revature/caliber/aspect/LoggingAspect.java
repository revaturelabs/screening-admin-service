package com.revature.caliber.aspect;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private Logger log;
    
    @Around("everything()")
    public Object log(ProceedingJoinPoint pjp) {
        Object obj = null;
        log = Logger.getLogger(pjp.getTarget().getClass());
        log.trace("Method with signature: "+pjp.getSignature());
        log.trace("With arguments: "+Arrays.toString(pjp.getArgs()));
     
        try {
            obj = pjp.proceed();
        } catch (Throwable e) {
            log.error(e.getMessage());
            for(StackTraceElement s : e.getStackTrace()) {
                log.warn(s);
            }
        }
        log.info(pjp.getSignature()+" returned: "+obj);
        return obj;
    }   
    
    /* Hooks */
    @Pointcut("execution(* com.revature.caliber..*(..))")
    public void everything() { /* Empty method for Aspect Pointcut */ }
}
