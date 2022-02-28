package com.example.demo.controller;

import com.example.demo.aspect.Anno;
import com.example.demo.model.UserModel;
import com.example.demo.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl service;

    @Anno
    @GetMapping("/getAll")
    public List<UserModel> getAll() {
        return service.getAll();
    }

    @GetMapping("/getById/{identity}")
    public UserModel getById(@PathVariable Long identity) {
        return service.getById(identity);
    }

    @PostMapping("/save")
    public UserModel save(@RequestBody UserModel model) {
        return service.save(model);
    }

    @PutMapping("/update")
    public UserModel update(@RequestBody UserModel model) {
        return service.update(model);
    }

    @DeleteMapping("/delete/{identity}")
    public UserModel delete(@PathVariable Long identity) {
        return service.delete(identity);
    }
}