package com.bezkoder.spring.thymeleaf.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public record UpdateProgressRequest(
        @Min(0) @Max(100) int progressPercent, String status
) {}
