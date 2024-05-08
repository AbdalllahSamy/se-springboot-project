package com.seproject.seproject.aspect;



import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;




@Aspect
@Component
public class LoggingAspect {
    
	Logger log=LoggerFactory.getLogger(LoggingAspect.class);

 	@Around(value = "execution(* com.seproject.seproject.service..*(..))")
     public Object logTime(ProceedingJoinPoint joinPoint) throws Throwable {
     long startTime = System.currentTimeMillis();
     StringBuilder sb = new StringBuilder("KBI:");
     sb.append("[").append(joinPoint.getKind()).append("]\tfor: ").append(joinPoint.getSignature())
             .append("\twithArgs: ").append("(").append(String.join(", ", Arrays.toString(joinPoint.getArgs()))).append(")");
             sb.append("\ttook");
     Object retuenValue = joinPoint.proceed();
     log.info(sb.append(System.currentTimeMillis() - startTime).append(" ms. ").toString());
     return retuenValue;

 }
        @Pointcut(value =  "execution(* com.seproject.seproject.dao..*(..))")
        public void forRepositoryLog(){}
        @Pointcut(value =  "execution(* com.seproject.seproject.service..*(..))")
        public void forServiceLog(){}
        @Pointcut(value =  "execution(* com.seproject.seproject.service..*(..))")
        public void forControllerLog(){}

        @Pointcut(value = "forRepositoryLog()||forServiceLog()||forControllerLog()")
        public void forAllApp(){}

        @Before(value = "forAllApp()")
        public void beforeMethod(JoinPoint joinPoint){
            String methodName= joinPoint.getSignature().getName();
            log.info("====>  Method Name is >> {}",methodName);
            Object[] args =joinPoint.getArgs();
            for(Object arg : args){
                log.info("=====> argument >> {}", arg);
            }

        }





}
