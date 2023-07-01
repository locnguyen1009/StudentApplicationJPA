package com.example.schoolapplicationjpa.repository;

import com.example.schoolapplicationjpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {
}
