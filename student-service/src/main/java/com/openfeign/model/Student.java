package com.openfeign.model;

import com.openfeign.client.CourseClient;
import com.openfeign.model.response.CourseResponse;
import com.openfeign.model.response.StudentResponse;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String email;
    private String gender;
    private Long coursesId;

    public StudentResponse toStudentResponse(CourseResponse courseResponse) {
        return StudentResponse.builder()
                .id(this.id)
                .fullName(this.fullName)
                .email(this.email)
                .gender(this.gender)
                .course(courseResponse)
                .build();

    }
}
