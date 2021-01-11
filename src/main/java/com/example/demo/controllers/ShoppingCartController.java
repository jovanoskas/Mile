package com.example.demo.controllers;

import com.example.demo.service.ShoppingCartService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/shoppingCart")
public class ShoppingCartController {
    public final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

}