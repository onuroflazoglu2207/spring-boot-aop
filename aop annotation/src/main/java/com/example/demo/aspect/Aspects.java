package com.example.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class Aspects {

    @Before("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    public void aspect1() {
        log.info("1-) delete() method called!");
    }

    //i set @anno annotation on UserController.getAll()
    @Before("@annotation(com.example.demo.aspect.Anno)")
    public void aspect2() {
        log.info("2-) getAll() method called!");
    }
}
