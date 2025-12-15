package com.api.finlytics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.finlytics.model.User;
import com.api.finlytics.service.AuthService;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public String login(@RequestBody User request) {

        boolean success = authService.login(request.getUsername(), request.getPassword());
        
        if(success) return "Login Successfull";
        else return "Login failed";
    }
    
    @PostMapping("/sign-up")
    public String signUp(@RequestBody User request) {

         String message= authService.register(request.getUsername(), request.getPassword(), request.getEmail());
        
        return message;
    }
}
