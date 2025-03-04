package com.project.school_management.Service.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school_management.DTOS.SubjectDTO;
import com.project.school_management.Models.Subject;
import com.project.school_management.Repository.DepartmentRepository;
import com.project.school_management.Repository.SubjectRepository;
import com.project.school_management.Service.impl.ISubjectService;

@Service
public class SubjectService implements ISubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Subject createSubject(SubjectDTO subjectDTO) throws Exception {
        try {
            departmentRepository.findById(subjectDTO.getDepartmentId())
                    .orElseThrow(() -> new Exception("Department not found"));

            if (subjectRepository.existsBySubjectCode(subjectDTO.getSubjectCode())) {
                throw new Exception("Subject code already exists");
            }

            Subject subject = Subject.builder()
                    .subjectCode(subjectDTO.getSubjectCode())
                    .subjectName(subjectDTO.getSubjectName())
                    .credits(subjectDTO.getCredits())
                    .departmentId(subjectDTO.getDepartmentId())
                    .build();

            return subjectRepository.save(subject);
        } catch (Exception e) {
            throw new Exception("Error creating subject: " + e.getMessage());
        }
    }

    @Override
    public Subject updateSubject(Long id, SubjectDTO subjectDTO) throws Exception {
        try {
            departmentRepository.findById(subjectDTO.getDepartmentId())
                    .orElseThrow(() -> new Exception("Department not found"));

            Subject subject = subjectRepository.findById(id)
                    .orElseThrow(() -> new Exception("Subject not found"));

            // Check if another subject with the same code exists (exclude current subject)
            if (!subject.getSubjectCode().equals(subjectDTO.getSubjectCode()) &&
                    subjectRepository.existsBySubjectCode(subjectDTO.getSubjectCode())) {
                throw new Exception("Subject code already exists");
            }

            subject.setSubjectCode(subjectDTO.getSubjectCode());
            subject.setSubjectName(subjectDTO.getSubjectName());
            subject.setCredits(subjectDTO.getCredits());
            subject.setDepartmentId(subjectDTO.getDepartmentId());

            return subjectRepository.save(subject);
        } catch (Exception e) {
            throw new Exception("Error updating subject: " + e.getMessage());
        }
    }

    @Override
    public void deleteSubject(Long id) throws Exception {
        try {
            Subject subject = subjectRepository.findById(id)
                    .orElseThrow(() -> new Exception("Subject not found"));
            subjectRepository.delete(subject);
        } catch (Exception e) {
            throw new Exception("Error deleting subject: " + e.getMessage());
        }
    }

    @Override
    public Subject getSubjectById(Long id) throws Exception {
        try {
            return subjectRepository.findById(id)
                    .orElseThrow(() -> new Exception("Subject not found"));
        } catch (Exception e) {
            throw new Exception("Error retrieving subject: " + e.getMessage());
        }
    }

    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public List<Subject> getSubjectsByDepartmentId(Long departmentId) {
        return subjectRepository.findByDepartmentId(departmentId);
    }
}