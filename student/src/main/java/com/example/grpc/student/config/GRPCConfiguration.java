package com.example.grpc.student.config;

import com.example.grpc.StudentServiceGrpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
@Slf4j
@EntityScan("com.example.grpc.model")
public class GRPCConfiguration {

    @Value("${grpc.service.student.port}")
    private int studentServicePort;

    @Autowired
    private StudentServiceGrpc.StudentServiceImplBase studentService;

    @Bean(destroyMethod = "shutdown")
    public Server grpcServer() throws IOException {
        // Create the grpc server
        Server server = ServerBuilder.forPort(studentServicePort).addService(studentService).build();
        // Start the server
        server.start();
        log.info("Student service started at " + server.getPort());
        return server;
    }


}
