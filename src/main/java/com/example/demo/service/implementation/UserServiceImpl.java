package com.example.demo.service.implementation;

import com.example.demo.model.User;
import com.example.demo.model.exception.UserNotFound;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return this.userRepository.findById(id).orElseThrow(() -> new UserNotFound(id));
    }

    @Override
    public User registerUser(User user) {

        return this.userRepository.save(user);

    }

}