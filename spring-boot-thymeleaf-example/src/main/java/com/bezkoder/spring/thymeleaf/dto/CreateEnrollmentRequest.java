package com.bezkoder.spring.thymeleaf.dto;

import javax.validation.constraints.NotNull;

public record CreateEnrollmentRequest(
        @NotNull Long courseId,
        @NotNull Long studentId
){}