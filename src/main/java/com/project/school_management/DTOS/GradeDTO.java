package com.project.school_management.DTOS;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GradeDTO {
    @NotNull(message = "Student id is required")
    @JsonProperty("student_id")
    private Long studentId;

    @NotNull(message = "Subject id is required")
    @JsonProperty("subject_id")
    private Long subjectId;

    @NotNull(message = "Teacher id is required")
    @JsonProperty("teacher_id")
    private Long teacherId;

    @NotNull(message = "Attendance score is required")
    @Min(value = 0, message = "Attendance score must be at least 0")
    @Max(value = 10, message = "Attendance score must be at most 10")
    @JsonProperty("attendance_score")
    private Float attendanceScore;

    @NotNull(message = "Midterm score is required")
    @Min(value = 0, message = "Midterm score must be at least 0")
    @Max(value = 10, message = "Midterm score must be at most 10")
    @JsonProperty("midterm_score")
    private Float midtermScore;

    @NotNull(message = "Final score is required")
    @Min(value = 0, message = "Final score must be at least 0")
    @Max(value = 10, message = "Final score must be at most 10")
    @JsonProperty("final_score")
    private Float finalScore;

    @JsonProperty("average_score")
    private Float averageScore;

    @NotBlank(message = "Academic year is required")
    @JsonProperty("academic_year")
    private String academicYear;
}