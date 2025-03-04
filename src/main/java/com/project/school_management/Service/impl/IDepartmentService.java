package com.project.school_management.Service.impl;

import java.util.List;

import com.project.school_management.DTOS.DepartmentDTO;
import com.project.school_management.Models.Department;

public interface IDepartmentService {
    Department createDepartment(DepartmentDTO departmentDTO) throws Exception;

    Department updateDepartment(Long id, DepartmentDTO departmentDTO) throws Exception;

    void deleteDepartment(Long id) throws Exception;

    Department getDepartmentById(Long id) throws Exception;

    List<Department> getAllDepartments();
}