package com.during15.school.service;

import org.springframework.stereotype.Service;

@Service
public class JwtService {

    private final String secretKey = "school-management-system-secret-key";

    public String generateToken(String username) {
        // JWT token generation will be implemented here.
        return username;
    }

    public String extractUsername(String token) {
        // JWT token validation will be implemented here.
        return token;
    }

    public boolean isTokenValid(String token, String username) {
        return username.equals(extractUsername(token));
    }
}
