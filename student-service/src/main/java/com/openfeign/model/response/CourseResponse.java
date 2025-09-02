package com.openfeign.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseResponse {
    private Long courseId;
    private String courseName;
    private String code;
}
