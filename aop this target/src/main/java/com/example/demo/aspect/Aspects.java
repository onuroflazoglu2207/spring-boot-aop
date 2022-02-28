package com.example.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class Aspects {
    @Before("target(com.example.demo.controller.UserController)")
    public void aspect1() {
        log.info("1-) UserController method called!");
    }

    @Before("this(com.example.demo.controller.UserController)")
    public void aspect2() {
        log.info("2-) UserController method called!");
    }
}
