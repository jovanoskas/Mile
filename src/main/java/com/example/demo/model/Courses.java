package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "courses")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private Long price;

    @JsonIgnore
    @ManyToOne
    private Category category;
    @JsonIgnore
    @ManyToOne
    private Instructor instructor;
    @JsonIgnore
    @ManyToMany(mappedBy = "courses")
    private List<ShoppingCart> shoppingCarts;

    public Courses() {
    }

    public Courses(String name, String description, Long price, Category category, Instructor instructor) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.instructor = instructor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}