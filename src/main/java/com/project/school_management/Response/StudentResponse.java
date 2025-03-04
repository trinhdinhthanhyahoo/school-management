package com.project.school_management.Response;

import java.time.LocalDate;

import com.project.school_management.Models.Student;

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
public class StudentResponse {
    private String studentCode;
    private String fullName;
    private String gender;
    private LocalDate birthDate;
    private String email;
    private String phone;
    private Long classId;
    private String status;

    public static StudentResponse fromStudent(Student student) {
        return StudentResponse.builder()
                .studentCode(student.getStudentCode())
                .fullName(student.getFullName())
                .gender(student.getGender())
                .birthDate(student.getBirthDate())
                .email(student.getEmail())
                .phone(student.getPhone())
                .classId(student.getClassId())
                .status(student.getStatus())
                .build();
    }
}