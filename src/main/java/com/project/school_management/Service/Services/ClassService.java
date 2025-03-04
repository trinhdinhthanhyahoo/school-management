package com.project.school_management.Service.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school_management.DTOS.ClassesDTO;
import com.project.school_management.Models.Classes;
import com.project.school_management.Repository.ClassRepository;
import com.project.school_management.Repository.DepartmentRepository;
import com.project.school_management.Service.impl.IClassService;

@Service
public class ClassService implements IClassService {

    @Autowired
    private ClassRepository classesRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Classes createClass(ClassesDTO classesDTO) throws Exception {
        try {
            departmentRepository.findById(classesDTO.getDepartmentId())
                    .orElseThrow(() -> new Exception("Department not found"));

            if (classesRepository.existsByClassCode(classesDTO.getClassCode())) {
                throw new Exception("Class code already exists");
            }

            Classes newClass = Classes.builder()
                    .classCode(classesDTO.getClassCode())
                    .className(classesDTO.getClassName())
                    .departmentId(classesDTO.getDepartmentId())
                    .build();

            return classesRepository.save(newClass);
        } catch (Exception e) {
            throw new Exception("Error creating class: " + e.getMessage());
        }
    }

    @Override
    public Classes updateClass(Long id, ClassesDTO classesDTO) throws Exception {
        try {
            departmentRepository.findById(classesDTO.getDepartmentId())
                    .orElseThrow(() -> new Exception("Department not found"));

            if (classesRepository.existsByClassCode(classesDTO.getClassCode())) {
                throw new Exception("Class code already exists");
            }

            Classes classes = classesRepository.findById(id)
                    .orElseThrow(() -> new Exception("Class not found"));

            classes.setClassCode(classesDTO.getClassCode());
            classes.setClassName(classesDTO.getClassName());
            classes.setDepartmentId(classesDTO.getDepartmentId());

            return classesRepository.save(classes);
        } catch (Exception e) {
            throw new Exception("Error updating class: " + e.getMessage());
        }
    }

    @Override
    public void deleteClass(Long id) throws Exception {
        try {
            Classes classes = classesRepository.findById(id)
                    .orElseThrow(() -> new Exception("Class not found"));
            classesRepository.delete(classes);
        } catch (Exception e) {
            throw new Exception("Error deleting class: " + e.getMessage());
        }
    }

    @Override
    public Classes getClassesById(Long id) throws Exception {
        try {
            return classesRepository.findById(id)
                    .orElseThrow(() -> new Exception("Class not found"));
        } catch (Exception e) {
            throw new Exception("Error retrieving class: " + e.getMessage());
        }
    }

    @Override
    public List<Classes> getAllClasses() {
        return classesRepository.findAll();
    }

    @Override
    public List<Classes> getClassesByDepartmentId(Long departmentId) {
        return classesRepository.findByDepartmentId(departmentId);
    }
}