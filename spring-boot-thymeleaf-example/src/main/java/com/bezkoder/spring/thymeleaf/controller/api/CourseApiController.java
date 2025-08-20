package com.bezkoder.spring.thymeleaf.controller.api;

import com.bezkoder.spring.thymeleaf.entity.Course;
import com.bezkoder.spring.thymeleaf.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseApiController {


    private final CourseService service;

    public CourseApiController(CourseService s){
        this.service=s;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Course create(@Valid @RequestBody CreateCourseRequest r){
        return service.create(r);
    }
    @GetMapping
    public List<Course> all(){
        return service.all();
    }
    @GetMapping("/{id}")
    public Course one(@PathVariable Long id){
        return service.get(id);
    }
    @PutMapping("/{id}")
    public Course update(@PathVariable Long id, @Valid @RequestBody CreateCourseRequest r){
        return service.update(id, r);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
