package com.example.grpc.student.dao;

import com.example.grpc.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao extends JpaRepository<Student,Long> {

    List<Student> findByName(String name);
}
