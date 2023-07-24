package com.example.schoolapplicationjpa.repository;

import com.example.schoolapplicationjpa.entity.Student;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long>{
  List<Student> findStudentByLastName(String lastName);
  List<Student> findStudentByFirstName(String firstName);
}
