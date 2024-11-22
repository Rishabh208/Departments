package com.rishabh.departments.service;

import com.rishabh.departments.entity.Department;
import com.rishabh.departments.entity.Employee;
import com.rishabh.departments.repo.DepartmentRepo;
import com.rishabh.departments.repo.EmployeeRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepo employeeRepository;
    private final DepartmentRepo departmentRepository;

    @Transactional
    public Employee createEmployee(Employee employee) {
        // Fetch the associated department
        Department department = departmentRepository.findById(employee.getDepartment().getDepartment_id())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        // Increment the capacity of the department
        department.setCapacity(department.getCapacity() + 1);
        departmentRepository.save(department);

        // Save the employee
        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployeesByDepartmentId(long departmentId) {
        Department department = Department.builder()
                .department_id(departmentId)
                .build();
        return employeeRepository.findByDepartment(department);
    }
}
