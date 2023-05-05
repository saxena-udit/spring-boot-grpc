package com.example.grpc.model.mapper;

import com.example.grpc.Standard;
import com.example.grpc.model.Student;

import java.util.List;
import java.util.stream.Collectors;

public class StudentMapper {

    public static Student fromProto(com.example.grpc.Student proto) {
        return Student.builder()
                .name(proto.getName())
                .id(proto.getId())
                .age(proto.getAge())
                .standard(proto.getStandard().name())
                .build();
    }

    public static List<Student> fromProto(List<com.example.grpc.Student> students) {
        return students.stream().map(StudentMapper::fromProto).collect(Collectors.toList());
    }

    public static com.example.grpc.Student toProto(Student proto) {
        return com.example.grpc.Student.newBuilder()
                .setName(proto.getName())
                .setId(proto.getId())
                .setAge(proto.getAge())
                .setStandard(Standard.valueOf(proto.getStandard()))
                .build();
    }
}
