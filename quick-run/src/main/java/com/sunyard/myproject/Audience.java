package com.sunyard.myproject;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * Created by Administrator on 2018/4/19.
 */
@Aspect
public class Audience {
    private Logger logger= LoggerFactory.getLogger(Audience.class);
    @Before("execution(* com.sunyard.myproject.service.*.TopicServiceImpl.findAll(..))")
    public void before(){
        logger.info("Before.....");
//        System.out.println("Before.....");
    }

    @Pointcut("execution(* com.sunyard.myproject.service.impl.TopicServiceImpl.findAll(..))")
    public void performance(){

    }

    @Around("performance()")
    public Object watchPerformace(ProceedingJoinPoint jp){
        try {
            logger.info("Around before!!!");
//            System.out.println("Taking seats");
            Object obj=jp.proceed();
            logger.info("Around after!!!");
            return obj;
        } catch (Throwable e) {
            logger.info("Catch exception!!!");
        }
        return null;
    }
}
