package com.example.demo.controllers;

import com.example.demo.model.Instructor;
import com.example.demo.service.InstructorService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/instructor")
public class InstructorController {


    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    public List<Instructor> findAllInstructors(){
        return this.instructorService.findAll();
    }
    @GetMapping("/{id}")
    public Instructor findByID(@PathVariable Long id){
        return this.instructorService.findInstructorById(id);
    }
    @PostMapping
    public Instructor createInstructor(@RequestBody Instructor instructor) throws IOException {
        return this.instructorService.saveInstructor(instructor);
    }


}