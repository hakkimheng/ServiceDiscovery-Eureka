package com.openfeign.client;

import com.openfeign.model.response.CourseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "course-service")
public interface CourseClient {
    @GetMapping("/api/v1/course/{id}")
    CourseResponse getCourse(@PathVariable Long id);
}
