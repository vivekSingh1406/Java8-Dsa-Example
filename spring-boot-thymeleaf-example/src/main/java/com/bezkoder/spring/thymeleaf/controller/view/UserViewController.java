package com.bezkoder.spring.thymeleaf.controller.view;

import com.bezkoder.spring.thymeleaf.entity.Role;
import com.bezkoder.spring.thymeleaf.entity.User;
import com.bezkoder.spring.thymeleaf.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserViewController {
    private final UserService service; public UserViewController(UserService s){this.service=s;}


    @GetMapping
    public String list(Model model, @ModelAttribute("currentUser") User current){
        model.addAttribute("users", service.all());
        model.addAttribute("roles", Role.values());
        model.addAttribute("canEdit", current!=null && current.getRole()==Role.ADMIN);
        return "users";
    }


    @PostMapping
    public String create(@Valid CreateUserRequest req, BindingResult br, Model model){
        if (br.hasErrors()) { model.addAttribute("error","Validation failed"); return "users"; }
        try { service.create(req); model.addAttribute("success","User created"); }
        catch (RuntimeException ex){ model.addAttribute("error", ex.getMessage()); }
        model.addAttribute("users", service.all()); model.addAttribute("roles", Role.values());
        return "users";
    }


    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id, Model model){
        service.delete(id); model.addAttribute("success","User deleted");
        model.addAttribute("users", service.all()); model.addAttribute("roles", Role.values());
        return "users";
    }
}