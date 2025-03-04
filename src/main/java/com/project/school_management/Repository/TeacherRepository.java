package com.project.school_management.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.school_management.Models.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    List<Teacher> findByDepartmentId(Long departmentId);

    boolean existsByTeacherCode(String teacherCode);

    boolean existsByEmail(String email);
}