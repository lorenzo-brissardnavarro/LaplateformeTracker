package com.example.demo.controller;

import com.example.demo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    
    // Display the registration page
    @GetMapping("/register")
    public String showRegistrationPage(Model model) {
        model.addAttribute("student", new Student());
        return "register";
    }

    // Display the login page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    // Handle the registration form submission
    @PostMapping("/register")
    public String registerStudent(@ModelAttribute Student student) {
        authService.registerStudent(student);
        return "redirect:/login";
    }
}
