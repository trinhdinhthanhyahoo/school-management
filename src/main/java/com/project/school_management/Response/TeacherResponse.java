package com.project.school_management.Response;

import java.time.LocalDate;

import com.project.school_management.Models.Teacher;

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
public class TeacherResponse {
    private String teacherCode;
    private String fullName;
    private String gender;
    private LocalDate birthDate;
    private String email;
    private String phone;
    private Long departmentId;

    public static TeacherResponse fromTeacher(Teacher teacher) {
        return TeacherResponse.builder()
                .teacherCode(teacher.getTeacherCode())
                .fullName(teacher.getFullName())
                .gender(teacher.getGender())
                .birthDate(teacher.getBirthDate())
                .email(teacher.getEmail())
                .phone(teacher.getPhone())
                .departmentId(teacher.getDepartmentId())
                .build();
    }
}