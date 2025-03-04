package com.project.school_management.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "grades")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "subject_id")
    private Long subjectId;

    @Column(name = "teacher_id")
    private Long teacherId;

    @Column(name = "attendance_score")
    private Float attendanceScore;

    @Column(name = "midterm_score")
    private Float midtermScore;

    @Column(name = "final_score")
    private Float finalScore;

    @Column(name = "average_score")
    private Float averageScore;

    @Column(name = "academic_year")
    private String academicYear;

}