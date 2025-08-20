package com.bezkoder.spring.thymeleaf.controller.view;


import com.bezkoder.spring.thymeleaf.entity.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bezkoder.spring.thymeleaf.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.bezkoder.spring.thymeleaf.repository.*;

@Controller
public class AuthController {
    private final UserRepository userRepo;
    private final UserService userService;

    public AuthController(UserRepository r, UserService s){
        this.userRepo=r; this.userService=s;
    }


    @GetMapping("/login")
    public String loginPage(){return "login";}


    @PostMapping("/login")
    public String doLogin(@RequestParam String email, @RequestParam String password, Model model){
        var userOpt = userRepo.findByEmail(email);
        if (userOpt.isPresent() && userService.passwordMatches(userOpt.get(), password)){
            model.addAttribute("currentUser", userOpt.get());
            return "redirect:/courses";
        }
        model.addAttribute("error","Invalid credentials");
        return "login";
    }

    @ModelAttribute("currentUser")
    public User currentUser(){ return null; }
}
