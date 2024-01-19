package com.bryanlema.springboot.webapp.springbootwebapp.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.bryanlema.springboot.webapp.springbootwebapp.models.User;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/var")

public class PathVariableController {
    @Value("${config.username}")
    private String username;

    //@Value("${config.message}")
    //private String message;

    @Value("${config.listOfValues}")
    private String[] listOfValues;

    @Value("${config.code}")
    private Integer code;

    @Value("#{ '${config.listOfValues}'.split(',')}")
    private List<String> valuesList;

    @Value("#{'${config.listOfValues}'.toUpperCase()}")
    private List<String> valuesString;

    @Value("#{${config.valuesMap}}")
    private Map<String, Object> valuesMap;

    @Value("#{${config.valuesMap}.product}")
    private String productName;

    @Value("#{${config.valuesMap}.price}")
    private String price;

    @Autowired
    private Environment environment;

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        
        return user;
    }

    @GetMapping("/values")
    public Map<String, Object> values(@Value("${config.message}") String message) {
        Map<String, Object> mapjson = new HashMap<>();
        mapjson.put("username", username);
        mapjson.put("code", code);
        mapjson.put("message", message);
        mapjson.put("message2", environment.getProperty("config.message"));
        mapjson.put("code2", environment.getProperty("config.code", Long.class));
        mapjson.put("listOfValues", listOfValues);
        mapjson.put("valuesList", valuesList);
        mapjson.put("valuesString", valuesString);
        mapjson.put("valuesMap", valuesMap);
        mapjson.put("productName", productName);
        mapjson.put("price", price);

        return mapjson;
    }
    
    
}
