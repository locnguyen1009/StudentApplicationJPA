package com.example.schoolapplicationjpa.service.Impl;

import com.example.schoolapplicationjpa.entity.apiPayload.teacherPayload.TeacherDto;
import com.example.schoolapplicationjpa.entity.apiPayload.teacherPayload.TeacherReq;
import com.example.schoolapplicationjpa.entity.model.Teacher;
import com.example.schoolapplicationjpa.repository.TeacherRepo;
import com.example.schoolapplicationjpa.service.TeacherService;
import com.example.schoolapplicationjpa.utils.SimpleDateTimeFormatter;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepo teacherRepo;

    @Override
    public List<TeacherDto> getAllTeacherDto() {
        return teacherRepo.findAll().stream()
//            .map(teacher -> {
//                TeacherDto teacherDto = new TeacherDto();
//                teacherDto.setId(teacher.getId());
//                teacherDto.setFirstName(teacher.getFirstName());
//                teacherDto.setLastName(teacher.getLastName());
//                teacherDto.setDob(teacher.getDob());
//                teacherDto.setSkills(teacher.getSkills());
//                return teacherDto;
//            })
            .map(Teacher::getTeacherDto)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<Teacher> getTeacherById(Long teacherId) {
        return teacherRepo.findById(teacherId);
    }

    @Override
    public TeacherDto addTeacher(TeacherReq teacherReq) {
//        TeacherDto teacher = TeacherMapper.toTeacherReq(teacherReq);
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacherReq, teacher);
        teacher.setDob(SimpleDateTimeFormatter.dateFormatter(teacherReq.getDob()));
        Teacher addTeacher = teacherRepo.save(teacher);
        TeacherDto createdTeacherDto = new TeacherDto();
        BeanUtils.copyProperties(addTeacher, createdTeacherDto);
        return createdTeacherDto;
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
