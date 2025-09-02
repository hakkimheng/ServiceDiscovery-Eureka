package com.openfeign.controller;

import com.openfeign.client.CourseClient;
import com.openfeign.model.Student;
import com.openfeign.model.request.StudentRequest;
import com.openfeign.model.response.CourseResponse;
import com.openfeign.model.response.StudentResponse;
import com.openfeign.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final CourseClient courseClient;

    @GetMapping("/{student-id}")
    public StudentResponse getStudent(@PathVariable("student-id") Long studentId) {
        return studentService.getStudent(studentId);
    }

    @GetMapping
    public List<StudentResponse> getStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public StudentResponse createStudent(@RequestBody StudentRequest student) {
        return studentService.createStudent(student);
    }

    @GetMapping("course/{id}")
    public CourseResponse getCourse(@PathVariable Long id) {
        return courseClient.getCourse(id);
    }
}
