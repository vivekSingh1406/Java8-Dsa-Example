package com.bezkoder.spring.thymeleaf.dto;

import com.bezkoder.spring.thymeleaf.entity.Role;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public record CreateUserRequest(
        @NotBlank String fullName,
        @NotBlank @Email String email,
        @NotBlank @Pattern(regexp = "^\\d{10}$") String mobile,
        @NotBlank String password,
        @NotNull Role role
){}