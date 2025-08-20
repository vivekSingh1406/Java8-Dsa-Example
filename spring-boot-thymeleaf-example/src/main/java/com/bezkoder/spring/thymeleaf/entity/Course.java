package com.bezkoder.spring.thymeleaf.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @NotBlank
    private String courseName;

    @NotBlank
    @Size(min = 1)
    @Column(length = 2000)
    private String description;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "instructor_id")
    private User instructor; // must have role INSTRUCTOR

    // Getters & Setters
    public Long getCourseId() { return courseId; }
    public void setCourseId(Long courseId) { this.courseId = courseId; }

    public User getInstructor() { return instructor; }
    public void setInstructor(User instructor) { this.instructor = instructor; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
}
