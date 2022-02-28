package com.example.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class Aspects {

    @Before("bean(userController)")
    public void aspect1() {
        log.info("1-) userController method called!");
    }

    @Before("bean(userServiceImpl)")
    public void aspect2() {
        log.info("2-) userServiceImpl method called!");
    }

    @Before("bean(userRepository)")
    public void aspect3() {
        log.info("3-) userRepository method called!");
    }
}
