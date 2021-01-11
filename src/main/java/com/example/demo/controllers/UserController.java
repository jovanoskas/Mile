package com.example.demo.controllers;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/person")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        return this.userService.findById(id);
    }
    @PostMapping
    public User registerPerson(@RequestBody User user){
        return this.userService.registerUser(user);
    }


}