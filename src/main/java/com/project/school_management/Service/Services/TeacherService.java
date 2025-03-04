package com.project.school_management.Service.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school_management.DTOS.TeacherDTO;
import com.project.school_management.Models.Teacher;
import com.project.school_management.Repository.DepartmentRepository;
import com.project.school_management.Repository.TeacherRepository;
import com.project.school_management.Service.impl.ITeacherService;

@Service
public class TeacherService implements ITeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Teacher createTeacher(TeacherDTO teacherDTO) throws Exception {
        try {
            departmentRepository.findById(teacherDTO.getDepartmentId())
                    .orElseThrow(() -> new Exception("Department not found"));

            if (teacherRepository.existsByTeacherCode(teacherDTO.getTeacherCode())) {
                throw new Exception("Teacher code already exists");
            }

            if (teacherRepository.existsByEmail(teacherDTO.getEmail())) {
                throw new Exception("Email already exists");
            }

            Teacher teacher = Teacher.builder()
                    .teacherCode(teacherDTO.getTeacherCode())
                    .fullName(teacherDTO.getFullName())
                    .gender(teacherDTO.getGender())
                    .birthDate(teacherDTO.getBirthDate())
                    .email(teacherDTO.getEmail())
                    .phone(teacherDTO.getPhone())
                    .departmentId(teacherDTO.getDepartmentId())
                    .build();

            return teacherRepository.save(teacher);
        } catch (Exception e) {
            throw new Exception("Error creating teacher: " + e.getMessage());
        }
    }

    @Override
    public Teacher updateTeacher(Long id, TeacherDTO teacherDTO) throws Exception {
        try {
            departmentRepository.findById(teacherDTO.getDepartmentId())
                    .orElseThrow(() -> new Exception("Department not found"));

            Teacher teacher = teacherRepository.findById(id)
                    .orElseThrow(() -> new Exception("Teacher not found"));

            // Check if another teacher with the same code exists (exclude current teacher)
            if (!teacher.getTeacherCode().equals(teacherDTO.getTeacherCode()) &&
                    teacherRepository.existsByTeacherCode(teacherDTO.getTeacherCode())) {
                throw new Exception("Teacher code already exists");
            }

            // Check if another teacher with the same email exists (exclude current teacher)
            if (!teacher.getEmail().equals(teacherDTO.getEmail()) &&
                    teacherRepository.existsByEmail(teacherDTO.getEmail())) {
                throw new Exception("Email already exists");
            }

            teacher.setTeacherCode(teacherDTO.getTeacherCode());
            teacher.setFullName(teacherDTO.getFullName());
            teacher.setGender(teacherDTO.getGender());
            teacher.setBirthDate(teacherDTO.getBirthDate());
            teacher.setEmail(teacherDTO.getEmail());
            teacher.setPhone(teacherDTO.getPhone());
            teacher.setDepartmentId(teacherDTO.getDepartmentId());

            return teacherRepository.save(teacher);
        } catch (Exception e) {
            throw new Exception("Error updating teacher: " + e.getMessage());
        }
    }

    @Override
    public void deleteTeacher(Long id) throws Exception {
        try {
            Teacher teacher = teacherRepository.findById(id)
                    .orElseThrow(() -> new Exception("Teacher not found"));
            teacherRepository.delete(teacher);
        } catch (Exception e) {
            throw new Exception("Error deleting teacher: " + e.getMessage());
        }
    }

    @Override
    public Teacher getTeacherById(Long id) throws Exception {
        try {
            return teacherRepository.findById(id)
                    .orElseThrow(() -> new Exception("Teacher not found"));
        } catch (Exception e) {
            throw new Exception("Error retrieving teacher: " + e.getMessage());
        }
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public List<Teacher> getTeachersByDepartmentId(Long departmentId) {
        return teacherRepository.findByDepartmentId(departmentId);
    }
}