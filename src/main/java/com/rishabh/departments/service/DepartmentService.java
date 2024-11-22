package com.rishabh.departments.service;

import com.rishabh.departments.dto.DepartmentRequest;
import com.rishabh.departments.entity.Department;
import com.rishabh.departments.mapper.DepartmentMapper;
import com.rishabh.departments.repo.DepartmentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<Department> getAllDepartments() {
        List<Department> departments = repo.findAll();
        if (departments.isEmpty()) {
            return new ArrayList<>();
        }
        return departments;
    }

    public Department getDepartmentById(long id) {
        Optional<Department> department=repo.findById(id);
        return department.orElse(null);
    }

    public Department updateDepartment(long id, Department updatedDepartment) {
        if(repo.existsById(id)){
            updatedDepartment.setDepartment_id(id);
            repo.save(updatedDepartment);
        }
        return updatedDepartment;

    }

    public String deleteDepartment(long id){
        if(repo.existsById(id)){
            repo.deleteById(id);
            return "Deleted";
        }
        return "Not Found";
    }
}
