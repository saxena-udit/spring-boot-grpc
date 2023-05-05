package com.example.grpc.student;

import io.grpc.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentGRPCService {
  public static void main(String[] args) throws InterruptedException {
    SpringApplication.run(StudentGRPCService.class, args).getBean(Server.class).awaitTermination();
  }
}
