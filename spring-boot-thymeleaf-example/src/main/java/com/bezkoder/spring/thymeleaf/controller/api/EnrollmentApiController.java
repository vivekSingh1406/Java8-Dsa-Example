package com.bezkoder.spring.thymeleaf.controller.api;

import com.bezkoder.spring.thymeleaf.entity.Enrollment;
import com.bezkoder.spring.thymeleaf.service.EnrollmentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentApiController {
    private final EnrollmentService service;

    public EnrollmentApiController(EnrollmentService s){
        this.service=s;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Enrollment create(@Valid @RequestBody CreateEnrollmentRequest r){
        return service.enroll(r);
    }
    @GetMapping
    public List<Enrollment> all(){
        return service.all();
    }

    @GetMapping("/{id}")
    public Enrollment one(@PathVariable Long id){
        return service.get(id);
    }

    @PatchMapping("/{id}/progress")
    public Enrollment progress(@PathVariable Long id, @Valid @RequestBody UpdateProgressRequest r){
        return service.updateProgress(id, r);
    }

    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}