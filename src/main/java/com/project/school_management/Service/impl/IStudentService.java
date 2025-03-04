package com.project.school_management.Service.impl;

import java.util.List;

import com.project.school_management.DTOS.StudentDTO;
import com.project.school_management.Models.Student;

public interface IStudentService {
    Student createStudent(StudentDTO studentDTO) throws Exception;

    Student updateStudent(Long id, StudentDTO studentDTO) throws Exception;

    void deleteStudent(Long id) throws Exception;

    Student getStudentById(Long id) throws Exception;

    List<Student> getAllStudents();

    List<Student> getStudentsByClassId(Long classId);
}