package com.example.schoolapplicationjpa.entity.apiPayload.studentPayload;

import com.example.schoolapplicationjpa.entity.model.Student;
import com.example.schoolapplicationjpa.utils.SimpleDateTimeFormatter;

public class StudentMapper {
  public static Student toStudentReq(StudentReq req){
    Student student = new Student();
    student.setFirstName(req.getFirstName());
    student.setLastName(req.getLastName());
    student.setGrade(req.getGrade());
    student.setDob(SimpleDateTimeFormatter.dateFormatter(req.getDob()));
    return student;
  }

  public static StudentResp toStudentResp(Student student){
    StudentResp resp = new StudentResp();
    resp.setId(student.getId());
    resp.setFirstName(student.getFirstName());
    resp.setLastName(student.getLastName());
    resp.setDob(student.getDob());
    return resp;
  }

}
