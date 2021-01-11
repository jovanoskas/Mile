package com.example.demo.service.implementation;

import com.example.demo.model.Courses;
import com.example.demo.model.ShoppingCart;
import com.example.demo.model.User;
import com.example.demo.repository.CoursesRepository;
import com.example.demo.repository.ShoppingCartRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @Autowired
    CoursesRepository coursesRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public ShoppingCart addCourseToShoppingCart(Long userId, Long CourseID) {
        User user = this.userRepository.findById(userId).orElseThrow(RuntimeException::new);
        Courses course = this.coursesRepository.findById(CourseID).orElseThrow(RuntimeException::new);
        ShoppingCart shoppingCart = user.getShoppingCart();
        shoppingCart.getCourses().add(course);
        return this.shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public ShoppingCart removeCourseFromShoppingCart(Long userId, Long productId) {
        User user = this.userRepository.findById(userId).orElseThrow();
        ShoppingCart shoppingCart = user.getShoppingCart();
        shoppingCart.setCourses(
                shoppingCart.getCourses()
                        .stream()
                        .filter(courses -> !courses.getId().equals(productId))
                        .collect(Collectors.toList())
        );

        return this.shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public List<ShoppingCart> findAllShoppingCarts() {
        return this.shoppingCartRepository.findAll();
    }
}