package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    
    // Display the registration page
    @GetMapping("/register")
    public String showRegistrationPage() {
        return "register";
    }

    // Display the login page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }
}
