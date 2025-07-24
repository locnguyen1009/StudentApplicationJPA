package com.example.schoolapplicationjpa.service;


import com.example.schoolapplicationjpa.entity.apiPayload.enrollmentPayload.EnrollmentResp;
import com.example.schoolapplicationjpa.entity.model.Enrollment;

import com.example.schoolapplicationjpa.entity.apiPayload.enrollmentPayload.EnrollmentReq;
import java.util.List;
import java.util.Optional;

public interface EnrollmentService {
    List<Enrollment> getAllEnrollments();

    Optional<EnrollmentResp> getEnrollmentById(Long id);

    Enrollment createEnrollment(EnrollmentReq enrollment, Long courseId);


    Optional<Enrollment> updateEnrollment(Long enrollmentId, EnrollmentReq enrollment);
}
