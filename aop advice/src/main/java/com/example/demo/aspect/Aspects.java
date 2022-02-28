package com.example.demo.aspect;

import com.example.demo.model.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Aspect
@Component
public class Aspects {

    private long saveTime = 0;

    @Before("execution(* com.example.demo.service.UserServiceImpl.save(..))")
    public void beforeAspect() {
        saveTime = System.currentTimeMillis();
        log.info("save() method started!");
    }

    @After("execution(* com.example.demo.service.UserServiceImpl.save(..))")
    public void afterAspect() {
        log.info("save() method finished!, time = " + (System.currentTimeMillis() - saveTime) + "ms");
    }

    @AfterReturning(value = "execution(* com.example.demo.service.UserServiceImpl.getAll())", returning = "list")
    public void getAllAspect(List<UserModel> list) {
        log.info("getAll() method called, array size = " + list.size());
    }

    //i set throw in UserServiceImpl.update method!
    //i set try-catch in UserController.update method!
    @AfterThrowing(value = "execution(* com.example.demo.service.UserServiceImpl.update(..))", throwing = "e")
    public void updateAspect(Exception e) {
        log.info("have an error in update() method, message = " + e.getMessage());
    }

    @Around("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    public void deleteAspect() {
        log.info("delete() method called!");
    }

    @Pointcut("execution(* com.example.demo.controller.UserController.getById(..)) && args(identity)")
    public void getByIdPointcut(Long identity) {}

    @Around("getByIdPointcut(identity)")
    public void getByIdAspect(Long identity) {
        log.info("getById() method called, id = " + identity);
    }

    //Delete ve GetById aspectlerini kapsamaz cunku orda @Around kullanildigi icin.
    //@Around diger aspectleri devre disi birakir.
    @Before("within( com.example.demo.service.UserServiceImpl)")
    public void aspect() {
        log.info("ServiceImpl class is active!");
    }
}
