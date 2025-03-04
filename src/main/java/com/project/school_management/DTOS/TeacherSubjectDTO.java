package com.project.school_management.DTOS;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherSubjectDTO {
    @NotNull(message = "Teacher id is required")
    @JsonProperty("teacher_id")
    private Long teacherId;

    @NotNull(message = "Subject id is required")
    @JsonProperty("subject_id")
    private Long subjectId;

    @NotBlank(message = "Academic year is required")
    @JsonProperty("academic_year")
    private String academicYear;
}