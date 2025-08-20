package com.bezkoder.spring.thymeleaf.repository;

import com.bezkoder.spring.thymeleaf.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByInstructor_UserId(Long instructorId);
}