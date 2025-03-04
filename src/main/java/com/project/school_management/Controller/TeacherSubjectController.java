package com.project.school_management.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import com.project.school_management.DTOS.TeacherSubjectDTO;
import com.project.school_management.Models.TeacherSubject;
import com.project.school_management.Response.TeacherSubjectResponse;
import com.project.school_management.Service.Services.TeacherSubjectService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/teacher-subjects")
public class TeacherSubjectController {

    @Autowired
    private TeacherSubjectService teacherSubjectService;

    @GetMapping("/")
    public ResponseEntity<?> getAllTeacherSubjects() {
        List<TeacherSubject> teacherSubjects = teacherSubjectService.getAllTeacherSubjects();
        return ResponseEntity.ok(teacherSubjects.stream()
                .map(TeacherSubjectResponse::fromTeacherSubject)
                .toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTeacherSubjectById(@PathVariable Long id) {
        try {
            TeacherSubject teacherSubject = teacherSubjectService.getTeacherSubjectById(id);
            return ResponseEntity.ok(TeacherSubjectResponse.fromTeacherSubject(teacherSubject));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/teacher/{teacherId}")
    public ResponseEntity<?> getTeacherSubjectsByTeacherId(@PathVariable Long teacherId) {
        try {
            List<TeacherSubject> teacherSubjects = teacherSubjectService.getTeacherSubjectsByTeacherId(teacherId);
            return ResponseEntity.ok(teacherSubjects.stream()
                    .map(TeacherSubjectResponse::fromTeacherSubject)
                    .toList());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> createTeacherSubject(@Valid @RequestBody TeacherSubjectDTO teacherSubjectDTO,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getFieldErrors().stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            return ResponseEntity.badRequest().body(errors);
        }
        try {
            TeacherSubject teacherSubject = teacherSubjectService.createTeacherSubject(teacherSubjectDTO);
            return ResponseEntity.ok(TeacherSubjectResponse.fromTeacherSubject(teacherSubject));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTeacherSubject(@PathVariable Long id,
            @RequestBody TeacherSubjectDTO teacherSubjectDTO) {
        try {
            TeacherSubject teacherSubject = teacherSubjectService.updateTeacherSubject(id, teacherSubjectDTO);
            return ResponseEntity.ok(TeacherSubjectResponse.fromTeacherSubject(teacherSubject));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeacherSubject(@PathVariable Long id) {
        try {
            teacherSubjectService.deleteTeacherSubject(id);
            return ResponseEntity.ok("Teacher-Subject mapping deleted successfully with id: " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}