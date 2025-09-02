package com.openfeign.model.entity;

import com.openfeign.model.dto.response.CourseResponse;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    private String code;

    public CourseResponse toResponse(){
        return CourseResponse.builder()
                .courseId(this.id)
                .courseName(this.courseName)
                .code(this.code)
                .build();
    }
}
