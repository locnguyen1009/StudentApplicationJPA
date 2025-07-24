package com.example.schoolapplicationjpa.entity.apiPayload.teacherPayload;

import com.example.schoolapplicationjpa.entity.model.Teacher;
import com.example.schoolapplicationjpa.utils.SimpleDateTimeFormatter;

public class TeacherMapper {
  public static Teacher toTeacherReq(TeacherReq teacherReq){
    Teacher teacher = new Teacher();
    teacher.setFirstName(teacherReq.getFirstName());
    teacher.setLastName(teacherReq.getLastName());
    teacher.setDob(SimpleDateTimeFormatter.dateFormatter(teacherReq.getDob()));
    teacher.setSkills(teacher.getSkills());
    return teacher;
  }

}
