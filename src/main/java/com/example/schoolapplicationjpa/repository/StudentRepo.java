package com.example.schoolapplicationjpa.repository;

import com.example.schoolapplicationjpa.entity.model.Student;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface StudentRepo extends JpaRepository<Student, Long>{
  List<Student> findStudentByLastName(String lastName);
  List<Student> findStudentByFirstName(String firstName);
}
