package com.example.grpc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private String standard;

    @Builder
    public Student(int id, String name, int age, String standard) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.standard = standard;
    }
}
