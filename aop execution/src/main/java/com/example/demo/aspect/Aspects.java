package com.example.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class Aspects {

    @Before("execution(public com.example.demo.model.UserModel com.example.demo.controller.UserController.delete(..))")
    public void deleteAspect() {
        log.info("delete() method called!");
    }

    @Before("execution(* com.example.demo.controller.UserController.*(Long))")
    public void longAspect() {
        log.info("*(Long) method called!");
    }

    @Before("execution(public * com.example.demo.controller.UserController.*(*))")
    public void controllerAspect() {
        log.info("controller method called!");
    }
}
