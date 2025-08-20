package com.bezkoder.spring.thymeleaf.repository;

import com.bezkoder.spring.thymeleaf.entity.Role;
import com.bezkoder.spring.thymeleaf.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByMobile(String mobile);
    List<User> findByRole(Role role);
}
