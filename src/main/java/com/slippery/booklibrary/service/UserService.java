package com.slippery.booklibrary.service;

import com.slippery.booklibrary.dto.JwtKeyDto;
import com.slippery.booklibrary.models.User;

import java.util.List;

public interface UserService {
    User register(User user);
//    String login(User user);
    JwtKeyDto login(User user);
    User updateUser(User user);
    List<User> findAllUsers();
    User findUserById(Long id);
    void deleteUserById(Long id);
    void deleteAllUsers();
}
