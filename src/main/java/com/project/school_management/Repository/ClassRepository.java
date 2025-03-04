package com.project.school_management.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.school_management.Models.Classes;

public interface ClassRepository extends JpaRepository<Classes, Long> {

    List<Classes> findByDepartmentId(Long departmentId);

    boolean existsByClassCode(String classCode);

}
