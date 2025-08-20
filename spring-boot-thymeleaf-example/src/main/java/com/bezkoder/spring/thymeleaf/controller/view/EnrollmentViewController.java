package com.bezkoder.spring.thymeleaf.controller.view;


import com.bezkoder.spring.thymeleaf.entity.Role;
import com.bezkoder.spring.thymeleaf.entity.User;
import com.bezkoder.spring.thymeleaf.service.CourseService;
import com.bezkoder.spring.thymeleaf.service.EnrollmentService;
import com.bezkoder.spring.thymeleaf.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/enrollments")
public class EnrollmentViewController {
    private final EnrollmentService enrollmentService;
    private final CourseService courseService;
    private final UserService userService;
    public EnrollmentViewController(EnrollmentService e, CourseService c, UserService u){
        this.enrollmentService=e; this.courseService=c; this.userService=u;
    }


    @GetMapping
    public String list(Model model, @ModelAttribute("currentUser") User current){
        model.addAttribute("enrollments", enrollmentService.all());
        model.addAttribute("courses", courseService.all());
        model.addAttribute("students", userService.students());
        boolean canManage = current!=null && (current.getRole()== Role.ADMIN || current.getRole()==Role.INSTRUCTOR);
        model.addAttribute("canManage", canManage);
        boolean canEnroll = current!=null && current.getRole()==Role.STUDENT;
        model.addAttribute("canEnroll", canEnroll);
        return "enrollments";
    }


    @PostMapping
    public String create(@Valid CreateEnrollmentRequest req, BindingResult br, Model model){
        if (br.hasErrors()) { model.addAttribute("error","Validation failed"); return list(model, null); }
        try { enrollmentService.enroll(req); model.addAttribute("success","Enrolled"); }
        catch (RuntimeException ex){ model.addAttribute("error", ex.getMessage()); }
        return list(model, null);
    }


    @PostMapping("/{id}/progress")
    public String progress(@PathVariable Long id, @Valid UpdateProgressRequest req, BindingResult br, Model model){
        if (br.hasErrors()) { model.addAttribute("error","Validation failed"); return list(model, null); }
        try { enrollmentService.updateProgress(id, req); model.addAttribute("success","Progress updated"); }
        catch (RuntimeException ex){ model.addAttribute("error", ex.getMessage()); }
        return list(model, null);
    }


    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id, Model model){
        enrollmentService.delete(id); model.addAttribute("success","Enrollment deleted");
        return list(model, null);
    }
}