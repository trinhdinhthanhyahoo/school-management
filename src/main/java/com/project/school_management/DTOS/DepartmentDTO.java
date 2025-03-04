package com.project.school_management.DTOS;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
    @NotBlank(message = "Department code is required")
    @Size(min = 2, max = 10, message = "Department code must be between 2 and 10 characters")
    @JsonProperty("department_code")
    private String departmentCode;

    @NotBlank(message = "Department name is required")
    @Size(min = 3, max = 100, message = "Department name must be between 3 and 100 characters")
    @JsonProperty("department_name")
    private String departmentName;
}