package com.bryanlema.springboot.webapp.springbootwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {
    @GetMapping({"", "/", "/home"})
    public String home() {
        return "forward:/details";
    }
    
}
