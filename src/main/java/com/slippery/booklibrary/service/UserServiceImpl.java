package com.slippery.booklibrary.service;

import com.slippery.booklibrary.dto.JwtKeyDto;
import com.slippery.booklibrary.models.User;
import com.slippery.booklibrary.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

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
//    public String login(User user) {
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//                user.getUsername(),
//                user.getPassword()));
//        if (authentication.isAuthenticated()) {
//            service.refreshJwtToken(user.getUsername());
//            return service.generateJwtToken(user.getUsername());
//        }
//        return "fail";
//    }
    public JwtKeyDto login(User user) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                user.getUsername(),
                user.getPassword()));
        if (authentication.isAuthenticated()) {
            service.refreshJwtToken(user.getUsername());
            return service.refreshJwtToken(user.getUsername());
        }
        return null;
    }

    @Override
    public User updateUser(User user) {
        if(repository.findByUsername(user.getUsername()) !=null ||repository.findUserByEmail(user.getEmail()) !=null){
            repository.save(user);
        }
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        return repository.findAll();
    }

    @Override
    public User findUserById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public void deleteUserById(Long id) {
        if(repository.findById(id).isPresent()){
            repository.delete(repository.findById(id).orElseThrow());
        }
    }

    @Override
    public void deleteAllUsers() {
        repository.deleteAll();
    }
}
