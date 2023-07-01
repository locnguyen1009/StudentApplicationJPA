package com.example.schoolapplicationjpa.service.Impl;

import com.example.schoolapplicationjpa.entity.Teacher;
import com.example.schoolapplicationjpa.repository.TeacherRepo;
import com.example.schoolapplicationjpa.request.TeacherReq;
import com.example.schoolapplicationjpa.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepo teacherRepo;

    @Override
    public List<Teacher> getAllTeacher() {
        return teacherRepo.findAll();
    }

    @Override
    public Optional<Teacher> getTeacherById(Long teacherId) {
        return teacherRepo.findById(teacherId);
    }

    @Override
    public Teacher addTeacher(TeacherReq teacherReq) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(teacherReq.getFirstName());
        teacher.setLastName(teacherReq.getLastName());
        return teacherRepo.save(teacher);
    }

    @Override
    public Optional<Teacher> updateTeacher(Long teacherId, Teacher teacher) {
        if(getTeacherById(teacherId).isEmpty()){
            return Optional.empty();
        }
        teacher.setId(teacherId);
        return Optional.of(teacherRepo.save(teacher));
    }

    @Override
    public void deleteTeacher(Long teacherId) {
        teacherRepo.deleteById(teacherId);
    }
}
