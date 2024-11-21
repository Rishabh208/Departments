package com.rishabh.departments.service;

import com.rishabh.departments.dto.DepartmentRequest;
import com.rishabh.departments.entity.Department;
import com.rishabh.departments.mapper.DepartmentMapper;
import com.rishabh.departments.repo.DepartmentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepo repo;
    private final DepartmentMapper mapper;
    public String createDepartment(DepartmentRequest request) {
        Department customer = mapper.toEntity(request);
        repo.save(customer);
        return "Created";
    }
}
