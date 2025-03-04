package com.project.school_management.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "classes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Classes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "class_code")
    private String classCode;

    @Column(name = "class_name")
    private String className;

    @Column(name = "department_id")
    private Long departmentId;

}
