package com.example.demo.service;

import com.example.demo.model.UserModel;

import java.util.List;

public interface UserService {
    public List<UserModel> getAll();

    public UserModel getById(Long identity);

    public UserModel save(UserModel model);

    public UserModel update(UserModel model) throws Exception;

    public UserModel delete(Long identity);
}
