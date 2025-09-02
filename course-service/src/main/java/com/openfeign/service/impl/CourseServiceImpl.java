package com.openfeign.service.impl;

import com.openfeign.model.dto.request.CourseRequest;
import com.openfeign.model.entity.Course;
import com.openfeign.repository.CourseRepository;
import com.openfeign.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository studentRepository;

    @Override
    public Course getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Course createStudent(CourseRequest student) {
        return studentRepository.save(student.toEntity());
    }
}
