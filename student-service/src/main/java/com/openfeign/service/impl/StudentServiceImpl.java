package com.openfeign.service.impl;

import com.openfeign.client.CourseClient;
import com.openfeign.model.Student;
import com.openfeign.model.request.StudentRequest;
import com.openfeign.model.response.StudentResponse;
import com.openfeign.repositorry.StudentRepository;
import com.openfeign.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final CourseClient courseClient;

    @Override
    public StudentResponse getStudent(Long studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        assert student != null;
        return student.toStudentResponse(courseClient.getCourse(studentId));
    }

    @Override
    public List<StudentResponse> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentResponse> studentResponses = new ArrayList<>();
        for (Student student : students) {
            StudentResponse response = StudentResponse.builder()
                    .id(student.getId())
                    .email(student.getEmail())
                    .gender(student.getGender())
                    .fullName(student.getFullName())
                    .course(courseClient.getCourse(student.getCoursesId()))
                    .build();
            studentResponses.add(response);
        }
        return studentResponses;
    }

    @Override
    public StudentResponse createStudent(StudentRequest student) {
        return studentRepository.save(student.toEntity()).toStudentResponse(courseClient.getCourse(student.getCoursesId()));

    }
}
