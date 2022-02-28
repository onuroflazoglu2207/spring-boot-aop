package com.example.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class Aspects {

    @Before("execution(* com.example.demo.controller.UserController.getById(..)) && args(identity)")
    public void aspect1(Long identity) {
        log.info("1-) getById() method called, id = " + identity);
    }

    @Before("execution(* com.example.demo.controller.UserController.*(*))")
    public void aspect2(JoinPoint point) {
        String str = " Fileds: \n";
        for (Object obj : point.getArgs()) {
            str += obj.getClass().getSimpleName() + " => " + obj.toString() + "\n";
        }
        log.info(str);
    }
}
