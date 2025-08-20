package com.bezkoder.spring.thymeleaf.service;

import com.bezkoder.spring.thymeleaf.entity.Role;
import com.bezkoder.spring.thymeleaf.entity.User;
import com.bezkoder.spring.thymeleaf.exception.BadRequestException;
import com.bezkoder.spring.thymeleaf.exception.ConflictException;
import com.bezkoder.spring.thymeleaf.exception.NotFoundException;
import com.bezkoder.spring.thymeleaf.repository.UserRepository;
import com.bezkoder.spring.thymeleaf.util.PasswordValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repo;
    private final BCryptPasswordEncoder b = new BCryptPasswordEncoder();

    public UserService(UserRepository repo){this.repo=repo;}


    public User create(CreateUserRequest r){
        if (!PasswordValidator.isStrong(r.password()))
            throw new BadRequestException("Weak password: must have upper, lower, digit, special and length>8");
        if (repo.existsByEmail(r.email())) throw new ConflictException("Email already taken");
        if (repo.existsByMobile(r.mobile())) throw new ConflictException("Mobile already taken");
        User u = new User();
        u.setFullName(r.fullName()); u.setEmail(r.email()); u.setMobile(r.mobile());
        u.setPasswordHash(b.encode(r.password())); u.setRole(r.role());
        return repo.save(u);
    }

    public User get(Long id){return repo.findById(id).orElseThrow(() -> new NotFoundException("User not found"));}
    public List<User> all(){return repo.findAll();}
    public void delete(Long id){repo.delete(get(id));}
    public List<User> instructors(){return repo.findByRole(Role.INSTRUCTOR);}
    public List<User> students(){return repo.findByRole(Role.STUDENT);}
    public boolean passwordMatches(User user, String raw){return new BCryptPasswordEncoder().matches(raw, user.getPasswordHash());}
}