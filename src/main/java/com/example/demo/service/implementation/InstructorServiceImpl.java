package com.example.demo.service.implementation;

import com.example.demo.model.Instructor;
import com.example.demo.repository.InstructorRepository;
import com.example.demo.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {
    @Autowired
    InstructorRepository instructorRepository;

    @Override
    public List<Instructor> findAll() {
        return this.instructorRepository.findAll();
    }

    @Override
    public List<Instructor> findTopInstructor() {
        return null;
    }

    @Override
    public Instructor findInstructorById(Long id) {
        return this.instructorRepository.findById(id).orElseThrow();
    }

    @Override
    public Instructor saveInstructor(Instructor instructor) throws IOException {
        Instructor newInstructor =  new Instructor();
        newInstructor.setAddress(instructor.getAddress());
        newInstructor.setCourses(instructor.getCourses());
        newInstructor.setDescription(instructor.getDescription());
        newInstructor.setEmail(instructor.getEmail());
        newInstructor.setId(instructor.getId());
        newInstructor.setName(instructor.getName());
        newInstructor.setPassword(instructor.getPassword());
        newInstructor.setSurname(instructor.getSurname());


        return this.instructorRepository.save(newInstructor);
    }

    @Override
    public Instructor updateInstructor(Instructor instructor) throws IOException {
        return null;
    }

    @Override
    public void deleteInstructor(Long id) {

    }
}