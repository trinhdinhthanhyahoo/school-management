package com.project.school_management.DTOS;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClassesDTO {
    @NotBlank(message = "Class code is required")
    @Size(min = 3, max = 10, message = "Class code must be between 3 and 10 characters")
    @JsonProperty("class_code")
    private String classCode;

    @NotBlank(message = "Class name is required")
    @Size(min = 3, max = 100, message = "Class name must be between 3 and 100 characters")
    @JsonProperty("class_name")
    private String className;

    @NotNull(message = "Department id is required")
    @JsonProperty("department_id")
    private Long departmentId;
}