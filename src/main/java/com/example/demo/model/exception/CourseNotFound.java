package com.example.demo.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CourseNotFound extends RuntimeException {
    public CourseNotFound(Long id) {
        super(String.format("Course not found %s",id));
    }
}