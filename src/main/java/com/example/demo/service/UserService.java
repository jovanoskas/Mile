package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {
    User findById(Long id);
    User registerUser(User user);
}