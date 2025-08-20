package com.bezkoder.spring.thymeleaf.service;

import com.bezkoder.spring.thymeleaf.entity.Course;
import com.bezkoder.spring.thymeleaf.entity.Enrollment;
import com.bezkoder.spring.thymeleaf.entity.Role;
import com.bezkoder.spring.thymeleaf.entity.User;
import com.bezkoder.spring.thymeleaf.exception.BadRequestException;
import com.bezkoder.spring.thymeleaf.exception.ConflictException;
import com.bezkoder.spring.thymeleaf.repository.CourseRepository;
import com.bezkoder.spring.thymeleaf.repository.EnrollmentRepository;
import com.bezkoder.spring.thymeleaf.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EnrollmentService {
    private final EnrollmentRepository enrRepo;
    private final CourseRepository courseRepo;
    private final UserRepository userRepo;

    public EnrollmentService(EnrollmentRepository e, CourseRepository c, UserRepository u){
        this.enrRepo=e; this.courseRepo=c; this.userRepo=u;
    }


    @Transactional
    public Enrollment enroll(CreateEnrollmentRequest r){
        Course course = courseRepo.findById(r.courseId()).orElseThrow(() -> new NotFoundException("Course not found"));
        User student = userRepo.findById(r.studentId()).orElseThrow(() -> new NotFoundException("Student not found"));
        if (student.getRole()!= Role.STUDENT) throw new BadRequestException("StudentID must belong to a STUDENT");
        if (enrRepo.existsByCourse_CourseIdAndStudent_UserId(course.getCourseId(), student.getUserId()))
            throw new ConflictException("Student already enrolled in this course");
        if (!LocalDate.now().isBefore(course.getStartDate()))
            throw new BadRequestException("Cannot enroll after course start date");
        Enrollment e = new Enrollment(); e.setCourse(course); e.setStudent(student);
        e.setEnrollmentDate(LocalDateTime.now()); e.setProgressPercent(0); e.setStatus("ENROLLED");
        return enrRepo.save(e);
    }


    public Enrollment get(Long id){return enrRepo.findById(id).orElseThrow(() -> new NotFoundException("Enrollment not found"));}
    public List<Enrollment> all(){return enrRepo.findAll();}


    @Transactional
    public Enrollment updateProgress(Long id, UpdateProgressRequest r){
        Enrollment e = get(id);
        e.setProgressPercent(r.progressPercent());
        if (r.status()!=null) e.setStatus(r.status());
        return enrRepo.save(e);
    }


    public void delete(Long id){enrRepo.delete(get(id));}
}
