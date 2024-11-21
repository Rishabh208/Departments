package com.rishabh.departments.controller;

import com.rishabh.departments.dto.DepartmentRequest;
import com.rishabh.departments.entity.Department;
import com.rishabh.departments.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {

    private final DepartmentService departmentService;



    @PostMapping
    public ResponseEntity<String> createDepartment(@RequestBody @Valid DepartmentRequest request) {
        return ResponseEntity.ok(departmentService.createDepartment(request));
    }

    @GetMapping
    ResponseEntity<List<Department>> getAllDepartments() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @GetMapping("{departmentId}")
    ResponseEntity<Department> getDepartmentById(@PathVariable("departmentId") Integer departmentId) {
        return ResponseEntity.ok(departmentService.getDepartmentById(departmentId));
    }

    @PutMapping("/{departmentId}")
    public ResponseEntity<Department> updateDepartment(@PathVariable("departmentId") Integer departmentId, @RequestBody @Valid Department request) {
        return ResponseEntity.ok(departmentService.updateDepartment(departmentId, request));
    }

    @DeleteMapping("/{departmentId}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("departmentId") Integer departmentId) {
        return ResponseEntity.ok(departmentService.deleteDepartment(departmentId));
    }


    @GetMapping("/error")
    public ResponseEntity<String> triggerServerError() {
        try{
            throw new RuntimeException("Simulated Server Error");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An internal server error occurred");
        }
    }


}
