package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/sign", method = RequestMethod.POST)
public class SignController {

    @PostConstruct
    public void init(){
        List<String> allowedNames = new ArrayList<>();
        allowedNames.add("userr");
    }


    @GetMapping
    public String getLoginPage(@RequestParam(required = false) String info,
                               Model model) {
        model.addAttribute("info", info);
        return "sign";
    }


}