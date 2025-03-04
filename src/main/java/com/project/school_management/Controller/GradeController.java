package com.project.school_management.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import com.project.school_management.DTOS.GradeDTO;
import com.project.school_management.Models.Grade;
import com.project.school_management.Response.GradeResponse;
import com.project.school_management.Service.Services.GradeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/grades")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @GetMapping("/")
    public ResponseEntity<?> getAllGrades() {
        List<Grade> grades = gradeService.getAllGrades();
        return ResponseEntity.ok(grades.stream()
                .map(GradeResponse::fromGrade)
                .toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGradeById(@PathVariable Long id) {
        try {
            Grade grade = gradeService.getGradeById(id);
            return ResponseEntity.ok(GradeResponse.fromGrade(grade));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<?> getGradesByStudentId(@PathVariable Long studentId) {
        try {
            List<Grade> grades = gradeService.getGradesByStudentId(studentId);
            return ResponseEntity.ok(grades.stream()
                    .map(GradeResponse::fromGrade)
                    .toList());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> createGrade(@Valid @RequestBody GradeDTO gradeDTO,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getFieldErrors().stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            return ResponseEntity.badRequest().body(errors);
        }
        try {
            Grade grade = gradeService.createGrade(gradeDTO);
            return ResponseEntity.ok(GradeResponse.fromGrade(grade));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateGrade(@PathVariable Long id, @RequestBody GradeDTO gradeDTO) {
        try {
            Grade grade = gradeService.updateGrade(id, gradeDTO);
            return ResponseEntity.ok(GradeResponse.fromGrade(grade));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGrade(@PathVariable Long id) {
        try {
            gradeService.deleteGrade(id);
            return ResponseEntity.ok("Grade deleted successfully with id: " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}