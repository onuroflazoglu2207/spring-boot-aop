package com.example.demo.service;

import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;


    @Override
    public List<UserModel> getAll() {
        return repository.findAll();
    }

    @Override
    public UserModel getById(Long identity) {
        Optional<UserModel> optional = repository.findById(identity);
        return optional.isEmpty() ? null : optional.get();
    }

    @Override
    public UserModel save(UserModel model) {
        try {
            if (model.getIdentity() != null)
                return null;
            return repository.save(model);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public UserModel update(UserModel model) {
        try {
            if (getById(model.getIdentity()) == null) return null;
            return repository.save(model);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public UserModel delete(Long identity) {
        UserModel model = getById(identity);
        if (model != null) repository.deleteById(identity);
        return model;
    }
}
