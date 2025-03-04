package com.project.school_management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.school_management.Models.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    boolean existsByDepartmentCode(String departmentCode);

}
