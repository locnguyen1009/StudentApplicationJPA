package com.example.schoolapplicationjpa.service.Impl;

import com.example.schoolapplicationjpa.entity.Enrollment;
import com.example.schoolapplicationjpa.entity.Teacher;
import com.example.schoolapplicationjpa.repository.EnrollmentRepo;
import com.example.schoolapplicationjpa.response.EnrollmentResp;
import com.example.schoolapplicationjpa.service.CourseService;
import com.example.schoolapplicationjpa.service.EnrollmentService;
import com.example.schoolapplicationjpa.service.StudentService;
import com.example.schoolapplicationjpa.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepo enrollmentRepo;

    private final CourseService courseService;

    private final TeacherService teacherService;

    private final StudentService studentService;

    @Override
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepo.findAll();
    }

    @Override
    public Optional<Enrollment> getEnrollmentById(Long id) {
        return enrollmentRepo.findById(id);
    }

    @Override
    public Optional<Enrollment> createEnrollment(Enrollment enrollment, Long courseId) {
        if (courseService.getCourseById(courseId).isEmpty()) {
            return Optional.empty();
        }
        enrollment.setCourseId(courseId);
        return Optional.of(enrollmentRepo.save(enrollment));
    }

    @Override
    public Optional<Enrollment> updateEnrollment(Long enrollmentId, Enrollment enrollment) {
        Optional<Enrollment> enrollmentOp = enrollmentRepo.findById(enrollmentId);

        if(enrollmentOp.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "EnrollmentId is not found");
        }

        Enrollment currentEnrollment = enrollmentOp.get();
        if(enrollment.getMaxCapacity() != null) {
            currentEnrollment.setMaxCapacity(enrollment.getMaxCapacity());
        }
        if(enrollment.getBegin()!=null){
            currentEnrollment.setBegin(enrollment.getBegin());
        }
        if(enrollment.getEnd()!=null){
            currentEnrollment.setEnd(enrollment.getEnd());
        }
        if(enrollment.getEnrollDeadline()!=null){
            currentEnrollment.setEnrollDeadline(enrollment.getEnrollDeadline());
        }
        return Optional.of(enrollmentRepo.save(currentEnrollment));
    }







}
