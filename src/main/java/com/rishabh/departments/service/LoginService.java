package com.rishabh.departments.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.rishabh.departments.util.JwtUtil;
import com.rishabh.departments.dto.LoginRequest;
import com.rishabh.departments.entity.User;
import com.rishabh.departments.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService {

    private final UserRepo userRepo;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String login(LoginRequest request) {
        User user = userRepo.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));


        if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            String token = jwtUtil.generateToken(request.getEmail());
            System.out.println("Generated Token: " + token);

            return "User logged in successfully.";
        } else {
            throw new IllegalArgumentException("Invalid email or password.");
        }
    }
}
