package com.project.school_management.Service.impl;

import java.util.List;

import com.project.school_management.DTOS.TeacherSubjectDTO;
import com.project.school_management.Models.TeacherSubject;

public interface ITeacherSubjectService {
    TeacherSubject createTeacherSubject(TeacherSubjectDTO teacherSubjectDTO) throws Exception;

    TeacherSubject updateTeacherSubject(Long id, TeacherSubjectDTO teacherSubjectDTO) throws Exception;

    void deleteTeacherSubject(Long id) throws Exception;

    TeacherSubject getTeacherSubjectById(Long id) throws Exception;

    List<TeacherSubject> getAllTeacherSubjects();

    List<TeacherSubject> getTeacherSubjectsByTeacherId(Long teacherId);

    List<TeacherSubject> getTeacherSubjectsBySubjectId(Long subjectId);
}