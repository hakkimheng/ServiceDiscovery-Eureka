package com.openfeign.model.request;

import com.openfeign.model.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentRequest {
    private String fullName;
    private String email;
    private String gender;
    private Long coursesId;

    public Student toEntity() {
        return Student.builder()
                .fullName(this.fullName)
                .email(this.email)
                .gender(this.gender)
                .build();
    }
}
