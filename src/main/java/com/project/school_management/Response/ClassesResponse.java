package com.project.school_management.Response;

import com.project.school_management.Models.Classes;

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
public class ClassesResponse {
    private String classCode;
    private String className;
    private Long departmentId;

    public static ClassesResponse fromClasses(Classes classes) {
        return ClassesResponse.builder()
                .classCode(classes.getClassCode())
                .className(classes.getClassName())
                .departmentId(classes.getDepartmentId())
                .build();
    }
}