package com.example.demo.service.implementation;

import com.example.demo.model.Category;
import com.example.demo.model.Courses;
import com.example.demo.model.Instructor;
import com.example.demo.model.exception.CourseNotFound;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.CoursesRepository;
import com.example.demo.repository.InstructorRepository;
import com.example.demo.repository.ShoppingCartRepository;
import com.example.demo.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CoursesServiceImpl implements CoursesService {
    @Autowired
    CoursesRepository coursesRepository;

    @Autowired
    InstructorRepository instructorRepository;

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @Override
    public List<Courses> findAllCourses() {
        return this.coursesRepository.findAll();
    }

    @Override
    public List<Courses> findTopCourses() {
        return null;
    }

    @Override
    public Courses findCourseByID(Long id) {
        return this.coursesRepository.findById(id).orElseThrow(() -> new CourseNotFound(id));
    }

    @Override
    public List<Courses> findAllByInstructor(Long instructorId) {
        List<Courses> coursesList = null;
        List<Instructor> instructorList = this.instructorRepository.findAll();
        for(Instructor i : instructorList){
            if(i.getId().equals(instructorId)){
                coursesList=i.getCourses();
                break;
            }
        }
        return coursesList;
    }

    @Override
    public List<Courses> findAllByCategory(Long categoryId) {
        return null;
    }
    @Override
    public Courses saveCourse(Courses course){//, Long instructorId, Long categoryId) throws IOException {
        Courses newCourse =  new Courses();
        newCourse.setId(course.getId());
        newCourse.setDescription(course.getDescription());
        newCourse.setName(course.getName());
        newCourse.setPrice(course.getPrice());
        return this.coursesRepository.save(newCourse);
    }



    @Override
    public Courses updateCourse(Long id, Courses courses) throws IOException {
        Courses newCourse = this.coursesRepository.findById(id).orElseThrow();
        newCourse.setId(id);
        newCourse.setDescription(courses.getDescription());
        newCourse.setName(courses.getName());
        newCourse.setPrice(courses.getPrice());
        return this.coursesRepository.save(newCourse);

    }

    @Override
    public void deleteCourse(Long id) {
        this.coursesRepository.deleteById(id);
    }

    @Override
    public Courses save(Courses course, Long kategorijata, Long instruktorot) {

        Instructor instructor = this.instructorRepository.findById(instruktorot).orElseThrow();
        Category category = this.categoryRepository.findById(kategorijata).orElseThrow();
        String name = course.getName();
        String description = course.getDescription();
        Long price = course.getPrice();
        Courses newCourse = new Courses(name,description,price,category,instructor);

        return this.coursesRepository.save(newCourse);
    }

    @Override
    public Courses save2(Long id,String name, String description, String image, Long price, Long category, Long instructor) {
        Category category1 = this.categoryRepository.findById(category).orElseThrow();
        Instructor instructor1 = this.instructorRepository.findById(instructor).orElseThrow();
        Courses newCourse = new Courses(name,description,price,category1,instructor1);
        return null;
    }
}