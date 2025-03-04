package com.project.school_management.Service.impl;

import java.util.List;

import com.project.school_management.DTOS.TeacherDTO;
import com.project.school_management.Models.Teacher;

public interface ITeacherService {
    Teacher createTeacher(TeacherDTO teacherDTO) throws Exception;

    Teacher updateTeacher(Long id, TeacherDTO teacherDTO) throws Exception;

    void deleteTeacher(Long id) throws Exception;

    Teacher getTeacherById(Long id) throws Exception;

    List<Teacher> getAllTeachers();

    List<Teacher> getTeachersByDepartmentId(Long departmentId);
}