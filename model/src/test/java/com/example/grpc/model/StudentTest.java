package com.example.grpc.model;

import com.google.common.annotations.VisibleForTesting;
import org.junit.jupiter.api.Test;

public class StudentTest {

    // Write test cases for the Student class here.
    // You can use the Student class from the student/src/main/java/com/example/grpc/model/Student.java
    // file.
    // junit test cases to verify constructor and getters.
    @Test
    public void verifyConstructorAndGetters() {
        // Write test cases to verify the constructor and getters.
        // Create a student object using the constructor.
        Student student = new Student(1,"test", 10, "test");
        // assert the student object is not null.
        assert student != null;
        // assert name of student with message "Name is not matching"
        assert student.getName().equals("test") : "Name is not matching";
        // assert age of student with message "Age is not matching"
        assert student.getAge() == 10 : "Age is not matching";
        // assert standard of student with message "Standard is not matching"
        assert student.getStandard().equals("test") : "Standard is not matching";
        // assert id of student with message "Id is not matching"
        assert student.getId() == 1 : "Id is not matching";
    }

    // Write test cases to verify the equals and hashcode methods.
    // Write test cases to verify the toString method.
    // Write test cases to verify the compareTo method.
    // Write test cases to verify the builder pattern.
    // Write test cases to verify the builder pattern with the default values.
    // Write test cases to verify the builder pattern with the custom values.
    // Write test cases to verify the builder pattern with the null values.
    // Write test cases to verify the builder pattern with the empty values.
    // Write test cases to verify the builder pattern with the negative values.
    // Write test cases to verify the builder pattern with the zero values.
    // Write test cases to verify the builder pattern with the positive values.
    // Write test cases to verify the builder pattern with the max values.
    // Write test cases to verify the builder pattern with the min values.
    // Write test cases to verify the builder pattern with the invalid values.
    // Write test cases to verify the builder pattern with the valid values.

}
