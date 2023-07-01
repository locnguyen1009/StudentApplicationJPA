package com.example.schoolapplicationjpa.repository;

import com.example.schoolapplicationjpa.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EnrollmentRepo extends JpaRepository<Enrollment, Long> {
}
