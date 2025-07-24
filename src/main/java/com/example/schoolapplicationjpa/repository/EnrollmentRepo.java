package com.example.schoolapplicationjpa.repository;

import com.example.schoolapplicationjpa.entity.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepo extends JpaRepository<Enrollment, Long> {
}
