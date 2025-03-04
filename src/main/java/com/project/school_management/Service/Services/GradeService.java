package com.project.school_management.Service.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school_management.DTOS.GradeDTO;
import com.project.school_management.Models.Grade;
import com.project.school_management.Repository.GradeRepository;
import com.project.school_management.Repository.StudentRepository;
import com.project.school_management.Repository.SubjectRepository;
import com.project.school_management.Repository.TeacherRepository;
import com.project.school_management.Service.impl.IGradeService;

@Service
public class GradeService implements IGradeService {

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public Grade createGrade(GradeDTO gradeDTO) throws Exception {
        try {
            // Validate that student, teacher and subject exist
            studentRepository.findById(gradeDTO.getStudentId())
                    .orElseThrow(() -> new Exception("Student not found"));

            teacherRepository.findById(gradeDTO.getTeacherId())
                    .orElseThrow(() -> new Exception("Teacher not found"));

            subjectRepository.findById(gradeDTO.getSubjectId())
                    .orElseThrow(() -> new Exception("Subject not found"));

            // Check if a grade for the same student, subject, teacher and academic year
            // already exists
            if (gradeRepository.existsByStudentIdAndSubjectIdAndTeacherIdAndAcademicYear(
                    gradeDTO.getStudentId(),
                    gradeDTO.getSubjectId(),
                    gradeDTO.getTeacherId(),
                    gradeDTO.getAcademicYear())) {
                throw new Exception("Grade already exists for this student, subject, teacher and academic year");
            }

            // Calculate average score if all required scores are provided
            Float averageScore = null;
            if (gradeDTO.getAttendanceScore() != null &&
                    gradeDTO.getMidtermScore() != null &&
                    gradeDTO.getFinalScore() != null) {
                // Example calculation: 10% attendance, 30% midterm, 60% final
                averageScore = 0.1f * gradeDTO.getAttendanceScore() +
                        0.3f * gradeDTO.getMidtermScore() +
                        0.6f * gradeDTO.getFinalScore();
            }

            Grade grade = Grade.builder()
                    .studentId(gradeDTO.getStudentId())
                    .subjectId(gradeDTO.getSubjectId())
                    .teacherId(gradeDTO.getTeacherId())
                    .attendanceScore(gradeDTO.getAttendanceScore())
                    .midtermScore(gradeDTO.getMidtermScore())
                    .finalScore(gradeDTO.getFinalScore())
                    .averageScore(averageScore)
                    .academicYear(gradeDTO.getAcademicYear())
                    .build();

            return gradeRepository.save(grade);
        } catch (Exception e) {
            throw new Exception("Error creating grade: " + e.getMessage());
        }
    }

    @Override
    public Grade updateGrade(Long id, GradeDTO gradeDTO) throws Exception {
        try {
            // Validate that student, teacher and subject exist
            studentRepository.findById(gradeDTO.getStudentId())
                    .orElseThrow(() -> new Exception("Student not found"));

            teacherRepository.findById(gradeDTO.getTeacherId())
                    .orElseThrow(() -> new Exception("Teacher not found"));

            subjectRepository.findById(gradeDTO.getSubjectId())
                    .orElseThrow(() -> new Exception("Subject not found"));

            Grade grade = gradeRepository.findById(id)
                    .orElseThrow(() -> new Exception("Grade not found"));

            // Calculate average score if all required scores are provided
            Float averageScore = null;
            if (gradeDTO.getAttendanceScore() != null &&
                    gradeDTO.getMidtermScore() != null &&
                    gradeDTO.getFinalScore() != null) {
                // Example calculation: 10% attendance, 30% midterm, 60% final
                averageScore = 0.1f * gradeDTO.getAttendanceScore() +
                        0.3f * gradeDTO.getMidtermScore() +
                        0.6f * gradeDTO.getFinalScore();
            }

            grade.setStudentId(gradeDTO.getStudentId());
            grade.setSubjectId(gradeDTO.getSubjectId());
            grade.setTeacherId(gradeDTO.getTeacherId());
            grade.setAttendanceScore(gradeDTO.getAttendanceScore());
            grade.setMidtermScore(gradeDTO.getMidtermScore());
            grade.setFinalScore(gradeDTO.getFinalScore());
            grade.setAverageScore(averageScore);
            grade.setAcademicYear(gradeDTO.getAcademicYear());

            return gradeRepository.save(grade);
        } catch (Exception e) {
            throw new Exception("Error updating grade: " + e.getMessage());
        }
    }

    @Override
    public void deleteGrade(Long id) throws Exception {
        try {
            Grade grade = gradeRepository.findById(id)
                    .orElseThrow(() -> new Exception("Grade not found"));
            gradeRepository.delete(grade);
        } catch (Exception e) {
            throw new Exception("Error deleting grade: " + e.getMessage());
        }
    }

    @Override
    public Grade getGradeById(Long id) throws Exception {
        try {
            return gradeRepository.findById(id)
                    .orElseThrow(() -> new Exception("Grade not found"));
        } catch (Exception e) {
            throw new Exception("Error retrieving grade: " + e.getMessage());
        }
    }

    @Override
    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    @Override
    public List<Grade> getGradesByStudentId(Long studentId) {
        return gradeRepository.findByStudentId(studentId);
    }

    @Override
    public List<Grade> getGradesByTeacherId(Long teacherId) {
        return gradeRepository.findByTeacherId(teacherId);
    }

    @Override
    public List<Grade> getGradesBySubjectId(Long subjectId) {
        return gradeRepository.findBySubjectId(subjectId);
    }
}