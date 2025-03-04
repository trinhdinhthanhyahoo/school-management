package com.project.school_management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import com.project.school_management.Models.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

    List<Subject> findByDepartmentId(Long departmentId);

    boolean existsBySubjectCode(String subjectCode);
}