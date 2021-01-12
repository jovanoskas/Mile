package com.example.demo.controllers;

import com.example.demo.model.Courses;
import com.example.demo.service.CoursesService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/courses")
public class CoursesController {

    private final CoursesService coursesService;

    public CoursesController(CoursesService coursesService) {
        this.coursesService = coursesService;
    }
    @GetMapping
    public List<Courses> findAll(){
        return this.coursesService.findAllCourses();
    }

    @GetMapping("/{id}")
    public Courses findCourseById(@PathVariable Long id){
        return this.coursesService.findCourseByID(id);
    }

    @PostMapping("/{kategoriii}/{instruktoriii}")
    public Courses save(@RequestBody Courses course
            ,@PathVariable(value = "kategoriii") Long kategoriii
            ,@PathVariable(value = "instruktoriii") Long instruktoriii
    ){


        return this.coursesService.save(course,kategoriii,instruktoriii);
    }

    @PutMapping("/{id}")
    public Courses update(@PathVariable Long id, @RequestBody Courses courses) throws IOException {
        return this.coursesService.updateCourse(id, courses);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        this.coursesService.deleteCourse(id);
    }


}