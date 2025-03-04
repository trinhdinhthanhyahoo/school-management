package com.project.school_management.Response;

import com.project.school_management.Models.TeacherSubject;

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
public class TeacherSubjectResponse {
    private Long teacherId;
    private Long subjectId;
    private String academicYear;

    public static TeacherSubjectResponse fromTeacherSubject(TeacherSubject teacherSubject) {
        return TeacherSubjectResponse.builder()
                .teacherId(teacherSubject.getTeacherId())
                .subjectId(teacherSubject.getSubjectId())
                .academicYear(teacherSubject.getAcademicYear())
                .build();
    }
}