package com.bezkoder.spring.thymeleaf.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "enrollments", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"course_id", "student_id"})
})
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enrollmentId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id")
    private User student; // must have role STUDENT

    @NotNull
    private LocalDateTime enrollmentDate = LocalDateTime.now();

    @Min(0)
    @Max(100)
    private Integer progressPercent = 0;

    @Column(length = 30)
    private String status = "ENROLLED"; // ENROLLED / IN_PROGRESS / COMPLETED

    // Getters & Setters
    public Long getEnrollmentId() { return enrollmentId; }
    public void setEnrollmentId(Long enrollmentId) { this.enrollmentId = enrollmentId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Integer getProgressPercent() { return progressPercent; }
    public void setProgressPercent(Integer progressPercent) { this.progressPercent = progressPercent; }

    public LocalDateTime getEnrollmentDate() { return enrollmentDate; }
    public void setEnrollmentDate(LocalDateTime enrollmentDate) { this.enrollmentDate = enrollmentDate; }

    public User getStudent() { return student; }
    public void setStudent(User student) { this.student = student; }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }
}
