package com.slippery.booklibrary.service;

import com.slippery.booklibrary.models.User;

public interface UserService {
    User register(User user);
    String login(User user);
}
