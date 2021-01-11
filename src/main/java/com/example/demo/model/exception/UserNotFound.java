package com.example.demo.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFound extends RuntimeException {
    public UserNotFound(Long id) {
        super(String.format("User with userID %s is not found",id));
    }
}
