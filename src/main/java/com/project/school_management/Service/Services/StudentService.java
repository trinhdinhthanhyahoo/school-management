package com.project.school_management.Service.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school_management.DTOS.StudentDTO;
import com.project.school_management.Models.Student;
import com.project.school_management.Repository.ClassRepository;
import com.project.school_management.Repository.StudentRepository;
import com.project.school_management.Service.impl.IStudentService;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassRepository classRepository;

    @Override
    public Student createStudent(StudentDTO studentDTO) throws Exception {
        try {
            classRepository.findById(studentDTO.getClassId())
                    .orElseThrow(() -> new Exception("Class not found"));

            if (studentRepository.existsByStudentCode(studentDTO.getStudentCode())) {
                throw new Exception("Student code already exists");
            }

            if (studentRepository.existsByEmail(studentDTO.getEmail())) {
                throw new Exception("Email already exists");
            }

            Student student = Student.builder()
                    .studentCode(studentDTO.getStudentCode())
                    .fullName(studentDTO.getFullName())
                    .gender(studentDTO.getGender())
                    .birthDate(studentDTO.getBirthDate())
                    .email(studentDTO.getEmail())
                    .phone(studentDTO.getPhone())
                    .classId(studentDTO.getClassId())
                    .status(studentDTO.getStatus())
                    .build();

            return studentRepository.save(student);
        } catch (Exception e) {
            throw new Exception("Error creating student: " + e.getMessage());
        }
    }

    @Override
    public Student updateStudent(Long id, StudentDTO studentDTO) throws Exception {
        try {
            classRepository.findById(studentDTO.getClassId())
                    .orElseThrow(() -> new Exception("Class not found"));

            Student student = studentRepository.findById(id)
                    .orElseThrow(() -> new Exception("Student not found"));

            // Check if another student with the same code exists (exclude current student)
            if (!student.getStudentCode().equals(studentDTO.getStudentCode()) &&
                    studentRepository.existsByStudentCode(studentDTO.getStudentCode())) {
                throw new Exception("Student code already exists");
            }

            // Check if another student with the same email exists (exclude current student)
            if (!student.getEmail().equals(studentDTO.getEmail()) &&
                    studentRepository.existsByEmail(studentDTO.getEmail())) {
                throw new Exception("Email already exists");
            }

            student.setStudentCode(studentDTO.getStudentCode());
            student.setFullName(studentDTO.getFullName());
            student.setGender(studentDTO.getGender());
            student.setBirthDate(studentDTO.getBirthDate());
            student.setEmail(studentDTO.getEmail());
            student.setPhone(studentDTO.getPhone());
            student.setClassId(studentDTO.getClassId());
            student.setStatus(studentDTO.getStatus());

            return studentRepository.save(student);
        } catch (Exception e) {
            throw new Exception("Error updating student: " + e.getMessage());
        }
    }

    @Override
    public void deleteStudent(Long id) throws Exception {
        try {
            Student student = studentRepository.findById(id)
                    .orElseThrow(() -> new Exception("Student not found"));
            studentRepository.delete(student);
        } catch (Exception e) {
            throw new Exception("Error deleting student: " + e.getMessage());
        }
    }

    @Override
    public Student getStudentById(Long id) throws Exception {
        try {
            return studentRepository.findById(id)
                    .orElseThrow(() -> new Exception("Student not found"));
        } catch (Exception e) {
            throw new Exception("Error retrieving student: " + e.getMessage());
        }
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getStudentsByClassId(Long classId) {
        return studentRepository.findByClassId(classId);
    }
}