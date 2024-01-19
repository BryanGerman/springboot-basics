package com.bryanlema.springboot.webapp.springbootwebapp.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.bryanlema.springboot.webapp.springbootwebapp.models.dto.ParamDTO;
import com.bryanlema.springboot.webapp.springbootwebapp.models.dto.ParamMixDTO;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/params")

public class RequestParamsController {
    @GetMapping("/foo")
    public ParamDTO foo(@RequestParam(required = false, defaultValue = "No hay mensaje") String message) {
        ParamDTO paramdtoo = new ParamDTO();
        paramdtoo.setMessage(message);
        return paramdtoo;
    }

    @GetMapping("/bar")
    public ParamMixDTO bar(@RequestParam String text, @RequestParam Integer code) {
        ParamMixDTO params = new ParamMixDTO();
        params.setMessage(text);
        params.setCode(code);
        return params;
    }

    @GetMapping("/request")
    public ParamMixDTO request(HttpServletRequest request) {
        ParamMixDTO params = new ParamMixDTO();
        Integer code = 0;
        try{
            code = Integer.parseInt(request.getParameter("code"));
        } catch(NumberFormatException e){

        }
        params.setCode(code);
        params.setMessage(request.getParameter("message"));
        return params;
    }
    
    
    
}
