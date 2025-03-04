package com.project.school_management.Service.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school_management.DTOS.TeacherSubjectDTO;
import com.project.school_management.Models.TeacherSubject;
import com.project.school_management.Repository.SubjectRepository;
import com.project.school_management.Repository.TeacherRepository;
import com.project.school_management.Repository.TeacherSubjectRepository;
import com.project.school_management.Service.impl.ITeacherSubjectService;

@Service
public class TeacherSubjectService implements ITeacherSubjectService {

    @Autowired
    private TeacherSubjectRepository teacherSubjectRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public TeacherSubject createTeacherSubject(TeacherSubjectDTO teacherSubjectDTO) throws Exception {
        try {
            // Validate that teacher and subject exist
            teacherRepository.findById(teacherSubjectDTO.getTeacherId())
                    .orElseThrow(() -> new Exception("Teacher not found"));

            subjectRepository.findById(teacherSubjectDTO.getSubjectId())
                    .orElseThrow(() -> new Exception("Subject not found"));

            // Check if the mapping already exists
            if (teacherSubjectRepository.existsByTeacherIdAndSubjectIdAndAcademicYear(
                    teacherSubjectDTO.getTeacherId(),
                    teacherSubjectDTO.getSubjectId(),
                    teacherSubjectDTO.getAcademicYear())) {
                throw new Exception("Teacher-Subject mapping already exists for this academic year");
            }

            TeacherSubject teacherSubject = TeacherSubject.builder()
                    .teacherId(teacherSubjectDTO.getTeacherId())
                    .subjectId(teacherSubjectDTO.getSubjectId())
                    .academicYear(teacherSubjectDTO.getAcademicYear())
                    .build();

            return teacherSubjectRepository.save(teacherSubject);
        } catch (Exception e) {
            throw new Exception("Error creating teacher-subject mapping: " + e.getMessage());
        }
    }

    @Override
    public TeacherSubject updateTeacherSubject(Long id, TeacherSubjectDTO teacherSubjectDTO) throws Exception {
        try {
            // Validate that teacher and subject exist
            teacherRepository.findById(teacherSubjectDTO.getTeacherId())
                    .orElseThrow(() -> new Exception("Teacher not found"));

            subjectRepository.findById(teacherSubjectDTO.getSubjectId())
                    .orElseThrow(() -> new Exception("Subject not found"));

            TeacherSubject teacherSubject = teacherSubjectRepository.findById(id)
                    .orElseThrow(() -> new Exception("Teacher-Subject mapping not found"));

            // Check if updating would create a duplicate
            if ((teacherSubject.getTeacherId() != teacherSubjectDTO.getTeacherId() ||
                    teacherSubject.getSubjectId() != teacherSubjectDTO.getSubjectId() ||
                    !teacherSubject.getAcademicYear().equals(teacherSubjectDTO.getAcademicYear())) &&
                    teacherSubjectRepository.existsByTeacherIdAndSubjectIdAndAcademicYear(
                            teacherSubjectDTO.getTeacherId(),
                            teacherSubjectDTO.getSubjectId(),
                            teacherSubjectDTO.getAcademicYear())) {
                throw new Exception("Teacher-Subject mapping already exists for this academic year");
            }

            teacherSubject.setTeacherId(teacherSubjectDTO.getTeacherId());
            teacherSubject.setSubjectId(teacherSubjectDTO.getSubjectId());
            teacherSubject.setAcademicYear(teacherSubjectDTO.getAcademicYear());

            return teacherSubjectRepository.save(teacherSubject);
        } catch (Exception e) {
            throw new Exception("Error updating teacher-subject mapping: " + e.getMessage());
        }
    }

    @Override
    public void deleteTeacherSubject(Long id) throws Exception {
        try {
            TeacherSubject teacherSubject = teacherSubjectRepository.findById(id)
                    .orElseThrow(() -> new Exception("Teacher-Subject mapping not found"));
            teacherSubjectRepository.delete(teacherSubject);
        } catch (Exception e) {
            throw new Exception("Error deleting teacher-subject mapping: " + e.getMessage());
        }
    }

    @Override
    public TeacherSubject getTeacherSubjectById(Long id) throws Exception {
        try {
            return teacherSubjectRepository.findById(id)
                    .orElseThrow(() -> new Exception("Teacher-Subject mapping not found"));
        } catch (Exception e) {
            throw new Exception("Error retrieving teacher-subject mapping: " + e.getMessage());
        }
    }

    @Override
    public List<TeacherSubject> getAllTeacherSubjects() {
        return teacherSubjectRepository.findAll();
    }

    @Override
    public List<TeacherSubject> getTeacherSubjectsByTeacherId(Long teacherId) {
        return teacherSubjectRepository.findByTeacherId(teacherId);
    }

    @Override
    public List<TeacherSubject> getTeacherSubjectsBySubjectId(Long subjectId) {
        return teacherSubjectRepository.findBySubjectId(subjectId);
    }
}