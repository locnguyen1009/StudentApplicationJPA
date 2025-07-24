package com.example.schoolapplicationjpa.service.Impl;

import com.example.schoolapplicationjpa.entity.apiPayload.studentPayload.StudentMapper;
import com.example.schoolapplicationjpa.entity.apiPayload.studentPayload.StudentResp;
import com.example.schoolapplicationjpa.entity.model.Student;
import com.example.schoolapplicationjpa.repository.StudentRepo;
import com.example.schoolapplicationjpa.entity.apiPayload.studentPayload.StudentReq;
import com.example.schoolapplicationjpa.service.StudentService;
import com.example.schoolapplicationjpa.utils.SimpleDateTimeFormatter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRepo.findById(id);
    }

    public Student createStudent(StudentReq studentReq) {
//        Student student = StudentMapper.toStudentReq(studentReq);
        Student student = new Student();
        BeanUtils.copyProperties(studentReq, student);
        student.setDob(SimpleDateTimeFormatter.dateFormatter(studentReq.getDob()));
        return studentRepo.save(student);
    }

    @Override
    public Optional<Student> updateStudent(Long id, Student student) {
        if(getStudentById(id).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student Id is not found");
        }

        student.setId(id);
        return Optional.of(studentRepo.save(student));
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepo.deleteById(id);
    }

    @Override
    public List<Student> getStudentByLastName(String lastName) {
            return studentRepo.findStudentByLastName(lastName).stream().toList();

//        List<Student> students = studentRepo.findAll();
//        return students.stream()
//            .filter(stu -> stu.getLastName().equalsIgnoreCase(lastName))
//            .toList();

//        List<Student> stuLastName = new ArrayList<>();
//        for(Student student : studentRepo.findAll()){
//            if(student.getLastName().equalsIgnoreCase(lastName)){
//                stuLastName.add(student);
//            }
//        }
//        return stuLastName;
    }

    @Override
    public List<Student> getStudentByFirstName(String firstName) {
        return studentRepo.findStudentByFirstName(firstName).stream().toList();
    }


}
