package com.project.school_management.DTOS;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDTO {
    @NotBlank(message = "Teacher code is required")
    @Size(min = 3, max = 15, message = "Teacher code must be between 3 and 15 characters")
    @JsonProperty("teacher_code")
    private String teacherCode;

    @NotBlank(message = "Full name is required")
    @Size(min = 3, max = 100, message = "Full name must be between 3 and 100 characters")
    @JsonProperty("full_name")
    private String fullName;

    @NotBlank(message = "Gender is required")
    @JsonProperty("gender")
    private String gender;

    @NotNull(message = "Birth date is required")
    @JsonProperty("birth_date")
    private LocalDate birthDate;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @JsonProperty("email")
    private String email;

    @NotBlank(message = "Phone is required")
    @JsonProperty("phone")
    private String phone;

    @NotNull(message = "Department id is required")
    @JsonProperty("department_id")
    private Long departmentId;
}