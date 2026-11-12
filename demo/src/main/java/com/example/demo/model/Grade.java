package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity 
public class Grade {
    @Id 
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private float value;

    // Empty constructor
    public Grade() {
    }

    // Constructor with parameters
    public Grade(String subject, float value) {
        this.subject = subject;
        this.value = value;
    }


    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }



}
