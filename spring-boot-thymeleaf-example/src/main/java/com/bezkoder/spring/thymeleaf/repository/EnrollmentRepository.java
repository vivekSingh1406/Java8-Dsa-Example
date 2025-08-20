package com.bezkoder.spring.thymeleaf.repository;

import com.bezkoder.spring.thymeleaf.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    boolean existsByCourse_CourseIdAndStudent_UserId(Long courseId, Long studentId);
    List<Enrollment> findByCourse_CourseId(Long courseId);
    List<Enrollment> findByStudent_UserId(Long studentId);
}