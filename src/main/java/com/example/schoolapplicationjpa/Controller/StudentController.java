package com.example.schoolapplicationjpa.Controller;

import com.example.schoolapplicationjpa.entity.Student;
import com.example.schoolapplicationjpa.entity.request.StudentReq;
import com.example.schoolapplicationjpa.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequestMapping("/student")
@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student ID is not found"));
    }

    @GetMapping("/lastName")
    public List<Student> getStudentByLastName(@RequestParam String lastName){
        return studentService.getStudentByLastName(lastName);
    }
    @GetMapping("/firstName")
    public List<Student> getStudentByFirstName(@RequestParam String firstName){
        return studentService.getStudentByFirstName(firstName);
    }

    @PostMapping("")
    public Student createStudent(@RequestBody StudentReq studentReq){
        return studentService.createStudent(studentReq);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student){
        return studentService.updateStudent(id, student)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student ID is not found"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable Long id){
        if(studentService.getStudentById(id).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
        }
        studentService.deleteStudentById(id);
        return ResponseEntity.ok().build();
    }
}
