package com.example.demo.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

@Service
public class AuthService implements UserDetailsService {
    
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

    // Method to load user by email
    @Override
    public UserDetails loadUserByUsername(String email) {
        Student student = studentRepository.findByEmail(email);
        if (student == null) {
            throw new UsernameNotFoundException("Utilisateur non trouvé avec l'email : " + email);
        }
        return User.withUsername(student.getEmail())
                .password(student.getPassword())
                .roles(student.getRole())
                .build();
    }

}
