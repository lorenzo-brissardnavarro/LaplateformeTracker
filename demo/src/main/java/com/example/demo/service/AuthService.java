package com.example.demo.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class AuthService {
    
    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;

    // Constructor
    public AuthService(StudentRepository studentRepository, PasswordEncoder passwordEncoder) {
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Method to register a new student
    public Student registerStudent(Student student) {
        // Hash the password before saving
        String hashPassword = passwordEncoder.encode(student.getPassword());
        student.setPassword(hashPassword);
        return studentRepository.save(student);
    }
}
