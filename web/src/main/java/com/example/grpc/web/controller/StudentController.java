package com.example.grpc.web.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.example.grpc.*;
import com.example.grpc.model.Student;
import com.example.grpc.model.mapper.StudentMapper;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "student", produces = APPLICATION_JSON_VALUE)
@Slf4j
public class StudentController {
  @Autowired private StudentServiceGrpc.StudentServiceBlockingStub studentServiceBlockingStub;

  @GetMapping
  public List<Student> getAllStudents() {
    // create all student request object
    AllStudentRequest request = AllStudentRequest.newBuilder().build();
    // call the grpc service and get the response
    log.info("Sending find request to student grpc service");
    StudentResponse response = studentServiceBlockingStub.getAllStudentDetails(request);
    // return the response
    return StudentMapper.fromProto(response.getStudentsList());
  }

  @GetMapping("{name}")
  public List<Student> findStudent(@PathVariable final String name) {
    // build the get student request object from name
    GetStudentRequest request = GetStudentRequest.newBuilder().setName(name).build();
    // call the grpc service and get the response
    StudentResponse response = studentServiceBlockingStub.getStudentDetails(request);

    log.info("Sending find request to student grpc service");
    return StudentMapper.fromProto(response.getStudentsList());
  }

  @PostMapping
  public Student createStudent(@RequestBody Student student) {
    // build the create student request object from student
    CreateStudentRequest request =
        CreateStudentRequest.newBuilder().setStudent(StudentMapper.toProto(student)).build();
    // call the grpc service and get the response
    com.example.grpc.Student response = studentServiceBlockingStub.createStudentDetails(request);
    log.info("Sending create request to student grpc service");
    return StudentMapper.fromProto(response);
  }
}
