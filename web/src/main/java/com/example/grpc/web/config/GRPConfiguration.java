package com.example.grpc.web.config;

import com.example.grpc.StudentServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.protobuf.ProtobufJsonFormatHttpMessageConverter;

@Configuration
public class GRPConfiguration {

    @Value("${grpc.service.student.port}")
    private int studentServicePort;
    @Value("${grpc.service.student.host}")
    private String studentServiceHost;

    @Bean
    public StudentServiceGrpc.StudentServiceBlockingStub studentServiceBlockingStub(){
        // Create a channel
        ManagedChannel channel = ManagedChannelBuilder.forTarget(studentServiceHost+":"+studentServicePort)
                .usePlaintext().build();
        // Create a blocking stub
        return StudentServiceGrpc.newBlockingStub(channel);
    }

}
