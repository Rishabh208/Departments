package com.rishabh.departments.controller;

import com.rishabh.departments.dto.DepartmentRequest;
import com.rishabh.departments.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<String> createDepartment(@RequestBody @Valid DepartmentRequest request) {
        return ResponseEntity.ok(departmentService.createDepartment(request));
    }


}