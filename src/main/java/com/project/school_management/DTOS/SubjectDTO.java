package com.project.school_management.DTOS;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDTO {
    @NotBlank(message = "Subject code is required")
    @Size(min = 2, max = 10, message = "Subject code must be between 2 and 10 characters")
    @JsonProperty("subject_code")
    private String subjectCode;

    @NotBlank(message = "Subject name is required")
    @Size(min = 3, max = 100, message = "Subject name must be between 3 and 100 characters")
    @JsonProperty("subject_name")
    private String subjectName;

    @NotNull(message = "Credits is required")
    @Min(value = 1, message = "Credits must be at least 1")
    @JsonProperty("credits")
    private Integer credits;

    @NotNull(message = "Department id is required")
    @JsonProperty("department_id")
    private Long departmentId;
}