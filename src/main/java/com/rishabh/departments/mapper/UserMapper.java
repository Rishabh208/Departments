package com.rishabh.departments.mapper;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.rishabh.departments.dto.UserRequest;
import com.rishabh.departments.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public User toEntity(UserRequest request) {
        String hashedPassword = passwordEncoder.encode(request.password());
        return User.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(hashedPassword)
                .build();
    }
}
