package com.rishabh.departments.repo;

import com.rishabh.departments.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DepartmentRepo extends JpaRepository<Department, Long> {
}
