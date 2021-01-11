package com.example.demo.service;

import com.example.demo.model.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    ShoppingCart addCourseToShoppingCart(Long userId, Long productId);
    ShoppingCart removeCourseFromShoppingCart(Long userId, Long CourseId);
    List<ShoppingCart> findAllShoppingCarts();
}
