package com.project.school_management.Service.impl;

import java.util.List;

import com.project.school_management.DTOS.SubjectDTO;
import com.project.school_management.Models.Subject;

public interface ISubjectService {
    Subject createSubject(SubjectDTO subjectDTO) throws Exception;

    Subject updateSubject(Long id, SubjectDTO subjectDTO) throws Exception;

    void deleteSubject(Long id) throws Exception;

    Subject getSubjectById(Long id) throws Exception;

    List<Subject> getAllSubjects();

    List<Subject> getSubjectsByDepartmentId(Long departmentId);
}