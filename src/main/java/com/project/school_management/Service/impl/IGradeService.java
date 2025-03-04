package com.project.school_management.Service.impl;

import java.util.List;

import com.project.school_management.DTOS.GradeDTO;
import com.project.school_management.Models.Grade;

public interface IGradeService {
    Grade createGrade(GradeDTO gradeDTO) throws Exception;

    Grade updateGrade(Long id, GradeDTO gradeDTO) throws Exception;

    void deleteGrade(Long id) throws Exception;

    Grade getGradeById(Long id) throws Exception;

    List<Grade> getAllGrades();

    List<Grade> getGradesByStudentId(Long studentId);

    List<Grade> getGradesByTeacherId(Long teacherId);

    List<Grade> getGradesBySubjectId(Long subjectId);
}