package com.project.school_management.Response;

import com.project.school_management.Models.Department;

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

public class DepartmentResponse {
    private String departmentCode;
    private String departmentName;

    public static DepartmentResponse fromDepartment(Department department) {
        return DepartmentResponse.builder()
                .departmentCode(department.getDepartmentCode())
                .departmentName(department.getDepartmentName())
                .build();
    }
}
