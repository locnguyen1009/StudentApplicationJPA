package com.example.schoolapplicationjpa.Controller;

import com.example.schoolapplicationjpa.entity.Enrollment;
import com.example.schoolapplicationjpa.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @GetMapping("")
    public List<Enrollment> getALLEnrollments() {
        return enrollmentService.getAllEnrollments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enrollment> getEnrollmentById(@PathVariable Long id) {
        return enrollmentService.getEnrollmentById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "course not Found"));
    }

    @PostMapping("/{courseId}")
    public ResponseEntity<Enrollment> createEnrollment(@RequestBody Enrollment enrollment, @PathVariable Long courseId) {
        return enrollmentService.createEnrollment(enrollment, courseId)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "CourseId is not found"));
    }

    @PutMapping("/{enrollmentId}")
    public ResponseEntity<Enrollment> updateEnrollment(@PathVariable Long enrollmentId, @RequestBody Enrollment enrollment) {
        return enrollmentService.updateEnrollment(enrollmentId, enrollment)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "course not Found"));
    }

}
