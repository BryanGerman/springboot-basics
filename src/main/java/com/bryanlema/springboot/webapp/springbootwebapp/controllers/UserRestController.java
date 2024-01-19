package com.bryanlema.springboot.webapp.springbootwebapp.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bryanlema.springboot.webapp.springbootwebapp.models.User;
import com.bryanlema.springboot.webapp.springbootwebapp.models.dto.UserDTO;



@RestController
@RequestMapping("/api")
public class UserRestController {

    User user = new User("Bryan", "Lema");

    @GetMapping("/details")
    public UserDTO details() {
        UserDTO userdto = new UserDTO();
        userdto.setTitle("Bienvenido al curso");
        userdto.setUser(user);
        return userdto;
    }

    @GetMapping("/list")
    public List<User> list(){
        User user = new User("Bryan", "Lema");
        User user2 = new User("Pepe", "Doe");
        User user3 = new User("Jhon", "Doe");

        List<User> users = Arrays.asList(user, user2, user3);
        return users;
        
    }
    
}
