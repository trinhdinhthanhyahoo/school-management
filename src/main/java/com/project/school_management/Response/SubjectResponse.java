package com.project.school_management.Response;

import com.project.school_management.Models.Subject;

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
public class SubjectResponse {
    private String subjectCode;
    private String subjectName;
    private Integer credits;
    private Long departmentId;

    public static SubjectResponse fromSubject(Subject subject) {
        return SubjectResponse.builder()
                .subjectCode(subject.getSubjectCode())
                .subjectName(subject.getSubjectName())
                .credits(subject.getCredits())
                .departmentId(subject.getDepartmentId())
                .build();
    }
}