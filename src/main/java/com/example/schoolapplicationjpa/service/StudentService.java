package com.example.schoolapplicationjpa.service;

import com.example.schoolapplicationjpa.entity.Student;
import com.example.schoolapplicationjpa.entity.request.StudentReq;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllStudents();
    Optional<Student> getStudentById(Long id);
    Student createStudent(StudentReq studentReq);
    Optional<Student> updateStudent(Long id, Student student);
    void deleteStudentById(Long id);

    List<Student> getStudentByLastName(String lastName);

  List<Student> getStudentByFirstName(String firstName);
}
