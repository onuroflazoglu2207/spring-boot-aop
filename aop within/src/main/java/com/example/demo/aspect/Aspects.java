package com.example.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class Aspects {

    @Before("within(@org.springframework.web.bind.annotation.RestController *)")
    public void aspect1() {
        log.info("1-) RestController method called!");
    }

    @Before("@within(org.springframework.web.bind.annotation.RestController)")
    public void aspect2() {
        log.info("2-) RestController method called!");
    }

    @Before("within(com.example.demo.controller.UserController)")
    public void aspect3() {
        log.info("3-) UserController method called!");
    }

    @Before("within(com.example.demo.controller.*)")
    public void aspect4() {
        log.info("4-) Controller method called!");
    }

    @Before("within(com.example.demo.*.*)")
    public void aspect5() {
        log.info("5-) Demo methods called!");
    }

    @Before("within(com.example.demo..*)")
    public void aspect6() {
        log.info("6-) Demo methods called!");
    }
}
