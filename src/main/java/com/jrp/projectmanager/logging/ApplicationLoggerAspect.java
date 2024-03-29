package com.jrp.projectmanager.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class ApplicationLoggerAspect {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Pointcut("within(com.jrp.projectmanager.controllers..*)" + "|| within(com.jrp.projectmanager.dao..*)")
    public void definePackagePointcuts(){
        // empty method just to name the location specified in the pointcut


    }
    @Around("definePackagePointcuts()")
    public Object logAround(ProceedingJoinPoint jp){
        log.debug(" \n \n \n ");
        log.debug("******* Before method execution ********* \n {}.{} () with arguments[s] = {}",
                jp.getSignature().getDeclaringTypeName(),
                jp.getSignature().getName(), Arrays.toString(jp.getArgs()));
        log.debug("-------------------------------------------------- \n \n \n");
        Object o = null;
        try {
             o = jp.proceed();
        } catch (Throwable err) {
            err.printStackTrace();
        }
        log.debug(" \n \n \n ");
        log.debug("******* Before method execution ********* \n {}.{} () with arguments[s] = {}",
                jp.getSignature().getDeclaringTypeName(),
                jp.getSignature().getName(), Arrays.toString(jp.getArgs()));
        log.debug("-------------------------------------------------- \n \n \n");
        return o;
    }
}
