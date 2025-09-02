package com.openfeign.model.dto.request;

import com.openfeign.model.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseRequest {
    private String courseName;
    private String code;

    public Course toEntity() {
        return Course.builder()
                .courseName(this.courseName)
                .code(this.code)
                .build();
    }
}
