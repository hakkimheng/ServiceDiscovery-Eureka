package com.openfeign.controller;

import com.openfeign.model.dto.request.CourseRequest;
import com.openfeign.model.dto.response.CourseResponse;
import com.openfeign.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
class StudentController {
    private final CourseService studentService;

    @GetMapping("/{id}")
    public CourseResponse getStudent(@PathVariable Long id) {
        return studentService.getStudentById(id).toResponse();
    }

    @PostMapping
    public CourseResponse saveStudent(@RequestBody CourseRequest student) {
        return studentService.createStudent(student).toResponse();
    }
}
