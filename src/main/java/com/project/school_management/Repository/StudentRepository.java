package com.project.school_management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import com.project.school_management.Models.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByClassId(Long classId);

    boolean existsByStudentCode(String studentCode);

    boolean existsByEmail(String email);
}