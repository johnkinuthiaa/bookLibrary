package com.slippery.booklibrary.controller;

import com.slippery.booklibrary.models.User;
import com.slippery.booklibrary.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/find/all")
    public ResponseEntity<List<User>> findAllUsers(){
        return ResponseEntity.ok(service.findAllUsers());
    }
    @GetMapping("/find/id")
    public ResponseEntity<User> findUserById(@RequestParam Long id){
        return ResponseEntity.ok(service.findUserById(id));
    }
    @DeleteMapping("/delete/id")
    public void deleteUserById(@RequestParam Long id){
        service.deleteUserById(id);
    }
    @DeleteMapping("/delete/all")
    public void deleteAllUsers(){
        service.deleteAllUsers();
    }

}
