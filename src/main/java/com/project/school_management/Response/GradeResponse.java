package com.project.school_management.Response;

import com.project.school_management.Models.Grade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GradeResponse {
    private Long studentId;
    private Long subjectId;
    private Long teacherId;
    private Float attendanceScore;
    private Float midtermScore;
    private Float finalScore;
    private Float averageScore;
    private String academicYear;

    public static GradeResponse fromGrade(Grade grade) {
        return GradeResponse.builder()
                .studentId(grade.getStudentId())
                .subjectId(grade.getSubjectId())
                .teacherId(grade.getTeacherId())
                .attendanceScore(grade.getAttendanceScore())
                .midtermScore(grade.getMidtermScore())
                .finalScore(grade.getFinalScore())
                .averageScore(grade.getAverageScore())
                .academicYear(grade.getAcademicYear())
                .build();
    }
}