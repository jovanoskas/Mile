package com.example.demo.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class UserAlreadyExists extends RuntimeException {
    public UserAlreadyExists(String email) {
        super(String.format("the user already exist %s",email));
    }
}
