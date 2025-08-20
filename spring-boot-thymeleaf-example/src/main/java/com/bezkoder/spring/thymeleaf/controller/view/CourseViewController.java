package com.bezkoder.spring.thymeleaf.controller.view;


import com.bezkoder.spring.thymeleaf.entity.Role;
import com.bezkoder.spring.thymeleaf.entity.User;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.bezkoder.spring.thymeleaf.service.CourseService;
import com.bezkoder.spring.thymeleaf.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/courses")
public class CourseViewController {

    private final CourseService courseService;
    private final UserService userService;
    public CourseViewController(CourseService c, UserService u){
        this.courseService=c; this.userService=u;
    }


    @GetMapping
    public String list(Model model, @ModelAttribute("currentUser") User current){
        model.addAttribute("courses", courseService.all());
        model.addAttribute("instructors", userService.instructors());
        boolean canManage = current!=null && (current.getRole()== Role.ADMIN || current.getRole()==Role.INSTRUCTOR);
        model.addAttribute("canManage", canManage);
        return "courses";
    }


    @PostMapping
    public String create(@Valid CreateCourseRequest req, BindingResult br, Model model){
        if (br.hasErrors()) { model.addAttribute("error","Validation failed"); return list(model, null); }
        try { courseService.create(req); model.addAttribute("success","Course created"); }
        catch (RuntimeException ex){ model.addAttribute("error", ex.getMessage()); }
        return list(model, null);
    }


    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id, Model model){
        courseService.delete(id); model.addAttribute("success","Course deleted");
        return list(model, null);
    }
}
