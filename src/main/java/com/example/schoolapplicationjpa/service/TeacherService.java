package com.example.schoolapplicationjpa.service;

import com.example.schoolapplicationjpa.entity.apiPayload.teacherPayload.TeacherDto;
import com.example.schoolapplicationjpa.entity.apiPayload.teacherPayload.TeacherReq;
import com.example.schoolapplicationjpa.entity.model.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
    List<TeacherDto> getAllTeacherDto();

    Optional<Teacher> getTeacherById(Long teacherId);

    TeacherDto addTeacher(TeacherReq teacherReq);

    Optional<Teacher> updateTeacher(Long teacherId, Teacher teacher);

    void deleteTeacher(Long teacherId);
}
