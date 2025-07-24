package com.example.schoolapplicationjpa.Controller;

import com.example.schoolapplicationjpa.entity.apiPayload.enrollmentPayload.EnrollmentResp;
import com.example.schoolapplicationjpa.entity.model.Enrollment;
import com.example.schoolapplicationjpa.entity.apiPayload.enrollmentPayload.EnrollmentReq;
import com.example.schoolapplicationjpa.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @GetMapping("")
    public List<Enrollment> getALLEnrollments() {
        return enrollmentService.getAllEnrollments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentResp> getEnrollmentById(@PathVariable Long id) {
        return enrollmentService.getEnrollmentById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "course not Found"));
    }

    @PostMapping("/{courseId}")
    public Enrollment createEnrollment(@RequestBody EnrollmentReq enrollment, @PathVariable Long courseId) {
        return enrollmentService.createEnrollment(enrollment, courseId);

    }

    @PutMapping("/{enrollmentId}")
    public ResponseEntity<Enrollment> updateEnrollment(@PathVariable Long enrollmentId, @RequestBody EnrollmentReq enrollment) {
        return enrollmentService.updateEnrollment(enrollmentId, enrollment)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "course not Found"));
    }

}
