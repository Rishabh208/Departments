package com.rishabh.departments.mapper;

import com.rishabh.departments.dto.DepartmentRequest;
import com.rishabh.departments.entity.Department;
import org.springframework.stereotype.Service;

@Service
public class DepartmentMapper {
    public Department toEntity(DepartmentRequest request) {
        return Department.builder()
                .departmentName(request.departmentName())
                .build();
    }
}
