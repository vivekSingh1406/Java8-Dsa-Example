package com.bezkoder.spring.thymeleaf.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public record CreateCourseRequest(
        @NotBlank String courseName,
        @NotBlank String description,
        @NotNull LocalDate startDate,
        @NotNull LocalDate endDate,
        @NotNull Long instructorId
){}