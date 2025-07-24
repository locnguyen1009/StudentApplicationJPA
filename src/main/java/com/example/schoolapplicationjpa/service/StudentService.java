package com.example.schoolapplicationjpa.service;

import com.example.schoolapplicationjpa.entity.model.Student;
import com.example.schoolapplicationjpa.entity.apiPayload.studentPayload.StudentReq;
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
