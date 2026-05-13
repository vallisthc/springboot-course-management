package com.example.project1.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="course")
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String courseName;
    private String duration;
    private double fees;
    @ManyToMany(mappedBy = "courses")
    //@JsonIgnoreProperties("courses")
    @JsonIgnore
    private List<Student> students;
}
