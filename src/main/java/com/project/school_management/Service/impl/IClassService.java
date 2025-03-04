package com.project.school_management.Service.impl;

import java.util.List;

import com.project.school_management.DTOS.ClassesDTO;
import com.project.school_management.Models.Classes;

public interface IClassService {
    Classes createClass(ClassesDTO classesDTO) throws Exception;

    Classes updateClass(Long id, ClassesDTO classesDTO) throws Exception;

    void deleteClass(Long id) throws Exception;

    Classes getClassesById(Long id) throws Exception;

    List<Classes> getAllClasses();

    List<Classes> getClassesByDepartmentId(Long departmentId);
}