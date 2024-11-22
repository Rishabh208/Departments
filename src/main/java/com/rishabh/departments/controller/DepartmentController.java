package com.rishabh.departments.controller;

import com.rishabh.departments.dto.DepartmentRequest;
import com.rishabh.departments.entity.Department;
import com.rishabh.departments.entity.Employee;
import com.rishabh.departments.service.DepartmentService;
import com.rishabh.departments.service.EmployeeService;
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
    private final EmployeeService employeeService;



    @PostMapping
    public ResponseEntity<String> createDepartment(@RequestBody @Valid DepartmentRequest request) {
        return ResponseEntity.ok(departmentService.createDepartment(request));
    }

//    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    ResponseEntity<List<Department>> getAllDepartments() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @GetMapping("/{departmentId}")
    ResponseEntity<Department> getDepartmentById(@PathVariable("departmentId") Long departmentId) {
        return ResponseEntity.ok(departmentService.getDepartmentById(departmentId));
    }

    @GetMapping("/some/{employeeDepartmentId}")
    ResponseEntity<List<Employee>> getEmployeeByDepartmentId(@PathVariable("employeeDepartmentId") Long departmentId) {
        return ResponseEntity.ok(employeeService.getEmployeesByDepartmentId(departmentId));
    }

    @PutMapping("/{departmentId}")
    public ResponseEntity<Department> updateDepartment(@PathVariable("departmentId") Long departmentId, @RequestBody @Valid Department request) {
        return ResponseEntity.ok(departmentService.updateDepartment(departmentId, request));
    }

    @DeleteMapping("/{departmentId}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("departmentId") Long departmentId) {
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
