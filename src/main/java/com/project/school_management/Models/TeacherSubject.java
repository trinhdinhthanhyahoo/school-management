package com.project.school_management.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "teacher_subjects")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherSubject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "teacher_id")
    private Long teacherId;

    @Column(name = "subject_id")
    private Long subjectId;

    @Column(name = "academic_year")
    private String academicYear;

}