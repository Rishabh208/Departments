package com.rishabh.departments.repo;

import com.rishabh.departments.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.rishabh.departments.entity.Department;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartment(Department department);
}
