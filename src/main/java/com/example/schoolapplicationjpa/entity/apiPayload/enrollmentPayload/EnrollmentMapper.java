package com.example.schoolapplicationjpa.entity.apiPayload.enrollmentPayload;

import com.example.schoolapplicationjpa.entity.model.Enrollment;
import com.example.schoolapplicationjpa.utils.SimpleDateTimeFormatter;

public class EnrollmentMapper {
  public static Enrollment toEnrollment(EnrollmentReq request){
    Enrollment enrollment = new Enrollment();
    enrollment.setCourseId(request.getCourseId());
    enrollment.setTeacherId(request.getTeacherId());
    enrollment.setMaxCapacity(request.getMaxCapacity());
    enrollment.setStudentIds(request.getStudentIds());
    enrollment.setEnrollDeadline(SimpleDateTimeFormatter.dateFormatter(request.getEnrollDeadline()));
    enrollment.setBeginDate(SimpleDateTimeFormatter.dateFormatter(request.getStartCourse()));
    enrollment.setEndDate(SimpleDateTimeFormatter.dateFormatter(request.getEndOfCourse()));
    return enrollment;
  }


}
