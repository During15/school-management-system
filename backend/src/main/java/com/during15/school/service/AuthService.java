package com.during15.school.service;

import com.during15.school.model.User;
import com.during15.school.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public User register(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        user.setPasswordHash(
                passwordEncoder.encode(user.getPasswordHash())
        );

        return userRepository.save(user);
    }

    public String login(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new RuntimeException("Invalid username or password"));

        if (!passwordEncoder.matches(
                password,
                user.getPasswordHash())) {
            throw new RuntimeException("Invalid username or password");
        }

        return jwtService.generateToken(user.getUsername());
    }
}
   
