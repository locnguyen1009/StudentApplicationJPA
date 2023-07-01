package com.example.schoolapplicationjpa.service;

import com.example.schoolapplicationjpa.entity.Teacher;
import com.example.schoolapplicationjpa.request.TeacherReq;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
    List<Teacher> getAllTeacher();

    Optional<Teacher> getTeacherById(Long teacherId);

    Teacher addTeacher(TeacherReq teacherReq);

    Optional<Teacher> updateTeacher(Long teacherId, Teacher teacher);

    void deleteTeacher(Long teacherId);
}
