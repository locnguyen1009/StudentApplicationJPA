package com.example.schoolapplicationjpa.service.Impl;

import com.example.schoolapplicationjpa.entity.apiPayload.enrollmentPayload.EnrollmentMapper;
import com.example.schoolapplicationjpa.entity.apiPayload.enrollmentPayload.EnrollmentReq;
import com.example.schoolapplicationjpa.entity.apiPayload.enrollmentPayload.EnrollmentResp;
import com.example.schoolapplicationjpa.entity.model.Course;
import com.example.schoolapplicationjpa.entity.model.Enrollment;
import com.example.schoolapplicationjpa.entity.model.Student;
import com.example.schoolapplicationjpa.entity.model.Teacher;
import com.example.schoolapplicationjpa.repository.EnrollmentRepo;
import com.example.schoolapplicationjpa.service.CourseService;
import com.example.schoolapplicationjpa.service.EnrollmentService;
import com.example.schoolapplicationjpa.service.StudentService;
import com.example.schoolapplicationjpa.service.TeacherService;
import com.example.schoolapplicationjpa.utils.SimpleDateTimeFormatter;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
  public Optional<EnrollmentResp> getEnrollmentById(Long id) {
    Enrollment enrollment = enrollmentRepo.findById(id)
        .orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "EnrollmentId not found"));

    Course currentCourse = enrollment.getCourseId() != null
        ? courseService.getCourseById(enrollment.getCourseId())
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
            "Course not found for id: " + enrollment.getCourseId()))
        : null;
    Teacher currentTeacherDto = enrollment.getTeacherId() != null
        ? teacherService.getTeacherById(enrollment.getTeacherId())
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
            "Teacher not found for id: " + enrollment.getTeacherId()))
        :null;
    List<Student> currentStudents = enrollment.getStudentIds()
        .stream()
        .map(studentId -> studentService.getStudentById(studentId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Teacher not found for id: " + studentId)))
        .toList();

    EnrollmentResp enrollmentResp = EnrollmentResp.builder()
        .id(id)
        .course(currentCourse)
        .teacher(currentTeacherDto)
        .maxCapacity(enrollment.getMaxCapacity())
        .students(currentStudents)
        .enrollDeadline(enrollment.getEnrollDeadline())
        .begin(enrollment.getBeginDate())
        .end(enrollment.getEndDate())
        .build();
    return Optional.of(enrollmentResp);

  }

  @Override
  public Enrollment createEnrollment(EnrollmentReq enrollment, Long courseId) {
    if (courseService.getCourseById(courseId).isEmpty()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "CourseID is not found");
    }

    Enrollment addEnrollment = EnrollmentMapper.toEnrollment(enrollment);
    addEnrollment.setCourseId(courseId);

    return enrollmentRepo.save(addEnrollment);
  }


  @Override
  public Optional<Enrollment> updateEnrollment(Long enrollmentId, EnrollmentReq enrollment) {
    Optional<Enrollment> enrollmentOp = enrollmentRepo.findById(enrollmentId);

    if (enrollmentOp.isEmpty()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "EnrollmentId is not found");
    }

    Enrollment currentEnrollment = enrollmentOp.get();
    if (enrollment.getMaxCapacity() != null) {
      currentEnrollment.setMaxCapacity(enrollment.getMaxCapacity());
    }
    if (enrollment.getStartCourse() != null) {
      currentEnrollment.setBeginDate(
          SimpleDateTimeFormatter.dateFormatter(enrollment.getStartCourse()));
    }
    if (enrollment.getEndOfCourse() != null) {
      currentEnrollment.setEndDate(
          SimpleDateTimeFormatter.dateFormatter(enrollment.getEndOfCourse()));
    }
    if (enrollment.getEnrollDeadline() != null) {
      currentEnrollment.setEnrollDeadline(
          SimpleDateTimeFormatter.dateFormatter(enrollment.getEnrollDeadline()));
    }
    return Optional.of(enrollmentRepo.save(currentEnrollment));
  }


}
