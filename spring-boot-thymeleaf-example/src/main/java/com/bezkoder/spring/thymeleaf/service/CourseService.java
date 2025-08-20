package com.bezkoder.spring.thymeleaf.service;


import com.bezkoder.spring.thymeleaf.entity.Course;
import com.bezkoder.spring.thymeleaf.entity.Role;
import com.bezkoder.spring.thymeleaf.entity.User;
import com.bezkoder.spring.thymeleaf.exception.BadRequestException;
import com.bezkoder.spring.thymeleaf.exception.NotFoundException;
import com.bezkoder.spring.thymeleaf.repository.CourseRepository;
import com.bezkoder.spring.thymeleaf.repository.UserRepository;
import com.bezkoder.spring.thymeleaf.util.WordCountValidator;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepo;
    private final UserRepository userRepo;
    public CourseService(CourseRepository c, UserRepository u){
        this.courseRepo=c; this.userRepo=u;
    }


    @Transactional
    public Course create(CreateCourseRequest r){
        if (!WordCountValidator.isBetweenWords(r.description(), 11, 19))
            throw new BadRequestException("Description must be >10 and <20 words");
        if (!r.startDate().isAfter(LocalDate.now()))
            throw new BadRequestException("StartDate must be a future date");
        if (!r.endDate().isAfter(r.startDate()))
            throw new BadRequestException("EndDate must be after StartDate");
        User instructor = userRepo.findById(r.instructorId())
                .orElseThrow(() -> new NotFoundException("Instructor not found"));
        if (instructor.getRole() != Role.INSTRUCTOR)
            throw new BadRequestException("InstructorID must belong to an INSTRUCTOR");
        Course c = new Course();
        c.setCourseName(r.courseName()); c.setDescription(r.description());
        c.setStartDate(r.startDate()); c.setEndDate(r.endDate()); c.setInstructor(instructor);
        return courseRepo.save(c);
    }


    public Course get(Long id){
        return courseRepo.findById(id).orElseThrow(() -> new NotFoundException("Course not found"));}
    public List<Course> all(){return courseRepo.findAll();}
    public Course update(Long id, CreateCourseRequest r){
        Course c = get(id);
        c.setCourseName(r.courseName()); c.setDescription(r.description());
        c.setStartDate(r.startDate()); c.setEndDate(r.endDate());
        User instructor = userRepo.findById(r.instructorId()).orElseThrow(() -> new NotFoundException("Instructor not found"));
        if (instructor.getRole()!=Role.INSTRUCTOR) throw new BadRequestException("Instructor must be INSTRUCTOR");
        c.setInstructor(instructor);
        return courseRepo.save(c);
    }
    public void delete(Long id){courseRepo.delete(get(id));}
}
