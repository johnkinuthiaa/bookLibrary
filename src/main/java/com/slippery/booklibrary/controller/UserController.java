package com.slippery.booklibrary.controller;

import com.slippery.booklibrary.models.User;
import com.slippery.booklibrary.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }


    @PostMapping("/register")
    public User register(@RequestBody User user){
        return service.register(user);
    }
    @PostMapping("/login")
    public String login(@RequestBody User user){
        return service.login(user);
    }
}
