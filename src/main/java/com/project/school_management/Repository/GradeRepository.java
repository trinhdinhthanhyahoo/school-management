package com.project.school_management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import com.project.school_management.Models.Grade;

public interface GradeRepository extends JpaRepository<Grade, Long> {

    List<Grade> findByStudentId(Long studentId);

    List<Grade> findBySubjectId(Long subjectId);

    List<Grade> findByTeacherId(Long teacherId);

    List<Grade> findByAcademicYear(String academicYear);

    boolean existsByStudentIdAndSubjectIdAndAcademicYear(Long studentId, Long subjectId, String academicYear);

    boolean existsByStudentIdAndSubjectIdAndTeacherIdAndAcademicYear(Long studentId, Long subjectId, Long teacherId,
            String academicYear);
}