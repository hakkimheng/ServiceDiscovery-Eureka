package com.openfeign.service;

import com.openfeign.model.Student;
import com.openfeign.model.request.StudentRequest;
import com.openfeign.model.response.StudentResponse;

import java.util.List;

public interface StudentService {
    StudentResponse getStudent(Long studentId);

    List<StudentResponse> getAllStudents();

    StudentResponse createStudent(StudentRequest student);
}
