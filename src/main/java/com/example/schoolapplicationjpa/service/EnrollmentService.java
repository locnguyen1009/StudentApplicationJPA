package com.example.schoolapplicationjpa.service;


import com.example.schoolapplicationjpa.entity.Enrollment;
import com.example.schoolapplicationjpa.response.EnrollmentResp;

import java.util.List;
import java.util.Optional;

public interface EnrollmentService {
    List<Enrollment> getAllEnrollments();

    Optional<Enrollment> getEnrollmentById(Long id);

    Optional<Enrollment> createEnrollment(Enrollment enrollment, Long courseId);


    Optional<Enrollment> updateEnrollment(Long enrollmentId, Enrollment enrollment);
}
