package com.slippery.booklibrary.service;

import com.slippery.booklibrary.models.User;
import com.slippery.booklibrary.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository repository;
    private final JwtService service;
    private final PasswordEncoder passwordEncoder =new BCryptPasswordEncoder(12);
    private final AuthenticationManager authenticationManager;

    public UserServiceImpl(UserRepository repository, JwtService service, AuthenticationManager authenticationManager) {
        this.repository = repository;
        this.service = service;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    @Override
    public String login(User user) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                user.getUsername(),
                user.getPassword()));
        if (authentication.isAuthenticated()) {
            return service.generateJwtToken(user.getUsername());
        }
        return "fail";
    }
}
