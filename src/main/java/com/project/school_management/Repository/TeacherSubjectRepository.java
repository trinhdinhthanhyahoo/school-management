package com.project.school_management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import com.project.school_management.Models.TeacherSubject;

public interface TeacherSubjectRepository extends JpaRepository<TeacherSubject, Long> {

    List<TeacherSubject> findByTeacherId(Long teacherId);

    List<TeacherSubject> findBySubjectId(Long subjectId);

    List<TeacherSubject> findByAcademicYear(String academicYear);

    boolean existsByTeacherIdAndSubjectIdAndAcademicYear(Long teacherId, Long subjectId, String academicYear);
}