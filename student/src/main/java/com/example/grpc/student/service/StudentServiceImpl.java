package com.example.grpc.student.service;

import com.example.grpc.*;
import com.example.grpc.model.Student;
import com.example.grpc.model.mapper.StudentMapper;
import com.example.grpc.student.dao.StudentDao;
import io.grpc.stub.StreamObserver;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StudentServiceImpl extends StudentServiceGrpc.StudentServiceImplBase {

  @Autowired private StudentDao studentDao;

  @Override
  public void getAllStudentDetails(
      AllStudentRequest request, StreamObserver<StudentResponse> responseObserver) {

    log.info("All request received at student grpc service");
    try {
      List<Student> students = this.studentDao.findAll();
      // Sort the student list based on the name.
      students.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
      // Create the response object and send it to the client.

      responseObserver.onNext(
          StudentResponse.newBuilder()
              .addAllStudents(
                  students.stream().map(StudentMapper::toProto).collect(Collectors.toList()))
              .build());

    } catch (Exception e) {
      log.error("Error while searching student", e);
      responseObserver.onError(e);
    } finally {
      responseObserver.onCompleted();
    }
    log.info("All request completed at student grpc service");
  }

  @Override
  public void getStudentDetails(
      GetStudentRequest request, StreamObserver<StudentResponse> responseObserver) {

    log.info("Search request received at student grpc service - {}", request.getName());
    try {
      List<Student> student = this.studentDao.findByName(request.getName());

      responseObserver.onNext(
          StudentResponse.newBuilder()
              .addAllStudents(
                  student.stream().map(StudentMapper::toProto).collect(Collectors.toList()))
              .build());
    } catch (Exception e) {
      log.error("Error while searching student", e);
      responseObserver.onError(e);
    } finally {
      responseObserver.onCompleted();
    }
    log.info("Search request completed at student grpc service");
  }

  @Override
  public void createStudentDetails(
      CreateStudentRequest request, StreamObserver<com.example.grpc.Student> responseObserver) {

    log.info("Create request received at student grpc service");
    try {
      Student student = this.studentDao.save(StudentMapper.fromProto(request.getStudent()));
      responseObserver.onNext(StudentMapper.toProto(student));
    } catch (Exception e) {
      log.error("Error while creating Student", e);
      responseObserver.onError(e);
    } finally {
      responseObserver.onCompleted();
    }

    log.info("Create request completed at student grpc service");
  }
}
