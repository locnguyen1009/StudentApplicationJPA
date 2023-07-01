package com.example.schoolapplicationjpa.service.Impl;

import com.example.schoolapplicationjpa.entity.Student;
import com.example.schoolapplicationjpa.repository.StudentRepo;
import com.example.schoolapplicationjpa.request.StudentReq;
import com.example.schoolapplicationjpa.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
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
        Student student = new Student();
        student.setFirstName(studentReq.getFirstName());
        student.setLastName(studentReq.getLastName());
        student.setGrade(studentReq.getGrade());
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
        List<Student> stuLastName = new ArrayList<>();
        for(Student student : studentRepo.findAll()){
            if(student.getLastName().equalsIgnoreCase(lastName)){
                stuLastName.add(student);
            }
        }
       return stuLastName;
    }


}
