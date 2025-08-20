package com.bezkoder.spring.thymeleaf.controller.api;
import com.bezkoder.spring.thymeleaf.dto.CreateUserRequest;
import com.bezkoder.spring.thymeleaf.entity.User;
import com.bezkoder.spring.thymeleaf.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserApiController {
    private final UserService service;
    public UserApiController(UserService s){
        this.service=s;
    }


    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public User create(@Valid @RequestBody CreateUserRequest r){
        return service.create(r);
    }
    @GetMapping public List<User> all(){
        return service.all();
    }
    @GetMapping("/{id}")
    public User one(@PathVariable Long id){
        return service.get(id);
    }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
