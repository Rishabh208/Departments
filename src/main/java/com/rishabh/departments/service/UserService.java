package com.rishabh.departments.service;

import com.rishabh.departments.dto.UserRequest;
import com.rishabh.departments.entity.User;
import com.rishabh.departments.mapper.UserMapper;
import com.rishabh.departments.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo repo;
    private final UserMapper mapper;
    public String createUser(UserRequest request) {
        User user = mapper.toEntity(request);
        repo.save(user);
        return "Created";
    }
}
