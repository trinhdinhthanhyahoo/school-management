package com.project.school_management.Service.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school_management.DTOS.DepartmentDTO;
import com.project.school_management.Models.Department;
import com.project.school_management.Repository.DepartmentRepository;
import com.project.school_management.Service.impl.IDepartmentService;

@Service
public class DepartmentService implements IDepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department createDepartment(DepartmentDTO departmentDTO) throws Exception {
        try {
            if (departmentRepository.existsByDepartmentCode(departmentDTO.getDepartmentCode())) {
                throw new Exception("Department code already exists");
            }

            Department department = Department.builder()
                    .departmentCode(departmentDTO.getDepartmentCode())
                    .departmentName(departmentDTO.getDepartmentName())
                    .build();

            return departmentRepository.save(department);
        } catch (Exception e) {
            throw new Exception("Error creating department: " + e.getMessage());
        }
    }

    @Override
    public Department updateDepartment(Long id, DepartmentDTO departmentDTO) throws Exception {
        try {
            Department department = departmentRepository.findById(id)
                    .orElseThrow(() -> new Exception("Department not found"));

            // Check if another department with the same code exists (exclude current
            // department)
            if (!department.getDepartmentCode().equals(departmentDTO.getDepartmentCode()) &&
                    departmentRepository.existsByDepartmentCode(departmentDTO.getDepartmentCode())) {
                throw new Exception("Department code already exists");
            }

            department.setDepartmentCode(departmentDTO.getDepartmentCode());
            department.setDepartmentName(departmentDTO.getDepartmentName());

            return departmentRepository.save(department);
        } catch (Exception e) {
            throw new Exception("Error updating department: " + e.getMessage());
        }
    }

    @Override
    public void deleteDepartment(Long id) throws Exception {
        try {
            Department department = departmentRepository.findById(id)
                    .orElseThrow(() -> new Exception("Department not found"));
            departmentRepository.delete(department);
        } catch (Exception e) {
            throw new Exception("Error deleting department: " + e.getMessage());
        }
    }

    @Override
    public Department getDepartmentById(Long id) throws Exception {
        try {
            return departmentRepository.findById(id)
                    .orElseThrow(() -> new Exception("Department not found"));
        } catch (Exception e) {
            throw new Exception("Error retrieving department: " + e.getMessage());
        }
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
}
