package com.example.project1.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="student")
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @NotBlank(message="Name is required")
    private  String name;
    @NotBlank(message = "email is required")
    @Email(message = "Invalid email address")
    private  String email;
    @NotBlank(message = "phone number is required")
    @Size(min = 10,max = 10,message = "Valid Phone number is required")
    private  String phone;
    @ManyToMany
    @JsonIgnoreProperties("students")
    //@JsonIgnore
    private List<Course> courses;
}
