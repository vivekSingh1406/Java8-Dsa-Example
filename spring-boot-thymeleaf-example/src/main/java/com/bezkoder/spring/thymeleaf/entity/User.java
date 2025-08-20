package com.bezkoder.spring.thymeleaf.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"email", "mobile"})
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank
    private String fullName;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Pattern(regexp = "^\\d{10}$", message = "Mobile must be 10 digits")
    private String mobile;

    @NotBlank
    private String passwordHash; // store BCrypt hash

    @Enumerated(EnumType.STRING)
    @NotNull
    private Role role;

    @NotNull
    private LocalDateTime dateRegistered = LocalDateTime.now();

    // Getters & Setters
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public LocalDateTime getDateRegistered() { return dateRegistered; }
    public void setDateRegistered(LocalDateTime dateRegistered) { this.dateRegistered = dateRegistered; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }

    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }

    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
}
