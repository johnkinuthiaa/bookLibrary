package com.slippery.booklibrary.repository;

import com.slippery.booklibrary.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
    User findUserByEmail(String email);
}
