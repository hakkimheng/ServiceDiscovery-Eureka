package com.openfeign.service;

import com.openfeign.model.dto.request.CourseRequest;
import com.openfeign.model.entity.Course;

public interface CourseService {
    Course getStudentById(Long id);

    Course createStudent(CourseRequest student);
}
