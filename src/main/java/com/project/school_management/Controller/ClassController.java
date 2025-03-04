package com.project.school_management.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.school_management.DTOS.ClassesDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/classes") // http://localhost:8080/classes
public class ClassController {

    @GetMapping // http://localhost:8080/classes
    public ResponseEntity<?> getAllClasses(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit) {
        return ResponseEntity.ok("Get all classes with page: " + page + " and limit: " + limit);
    }

    @GetMapping("/{id}") // http://localhost:8080/classes/1
    public ResponseEntity<?> getClassById(@PathVariable Long id) {
        return ResponseEntity.ok(String.format("Get class by id: %d", id));
    }

    @PostMapping // http://localhost:8080/classes
    public ResponseEntity<?> createClass(@Valid @RequestBody ClassesDTO classesDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getFieldErrors().stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            return ResponseEntity.badRequest().body(errors);
        }
        return ResponseEntity.ok(String.format("Create class: %s", classesDTO));

    }

    @PutMapping("/{id}") // http://localhost:8080/classes/1
    public ResponseEntity<?> updateClass(@PathVariable Long id) {
        return ResponseEntity.ok(String.format("Update class: %d", id));
    }

    @DeleteMapping("/{id}") // http://localhost:8080/classes/1
    public ResponseEntity<?> deleteClass(@PathVariable Long id) {
        return ResponseEntity.ok("Delete class: " + id);
    }

}
