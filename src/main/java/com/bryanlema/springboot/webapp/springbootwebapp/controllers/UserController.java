package com.bryanlema.springboot.webapp.springbootwebapp.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.bryanlema.springboot.webapp.springbootwebapp.models.User;

@Controller
public class UserController {

    User user = new User("Bryan", "Lema");

    @GetMapping("/details")
    public String details(Model model) {
        model.addAttribute("title", "Bienvenido al curso!");
        model.addAttribute("user", user);
        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap modelMap) {
        modelMap.addAttribute("title", "Listado de usuarios");

        return "list";
    }

    @ModelAttribute("users")
    public List<User> userModel(){
        return Arrays.asList(
            new User("Para", "Gonzales"),
            new User("Lalo", "Perez", "lalo@correo.com")
            );
    }
    
    
}
