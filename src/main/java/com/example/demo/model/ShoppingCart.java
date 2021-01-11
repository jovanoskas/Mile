package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date;
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "shopping_cart_courses",
            joinColumns = @JoinColumn(columnDefinition = "shopping_carts_id"),
            inverseJoinColumns = @JoinColumn(name = "courses_id")
    )
    private List<Courses> courses = new ArrayList<>();

    @OneToOne
    private User user;

    public ShoppingCart(Long id, Date date, List<Courses> courses, User user) {
        this.id = id;
        this.date = date;
        this.courses = courses;
        this.user = user;
    }

    public ShoppingCart() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Courses> getCourses() {
        return courses;
    }

    public void setCourses(List<Courses> courses) {
        this.courses = courses;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}