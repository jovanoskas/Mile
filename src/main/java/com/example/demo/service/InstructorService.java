package com.example.demo.service;

import com.example.demo.model.Instructor;

import java.io.IOException;
import java.util.List;

public interface InstructorService {
    List<Instructor> findAll();
    List<Instructor> findTopInstructor();
    Instructor findInstructorById(Long id);
    Instructor saveInstructor(Instructor instructor) throws IOException;
    Instructor updateInstructor(Instructor instructor) throws IOException;
    void deleteInstructor(Long id);
}