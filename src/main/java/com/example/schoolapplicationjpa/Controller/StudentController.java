package com.example.schoolapplicationjpa.Controller;

import com.example.schoolapplicationjpa.entity.apiPayload.studentPayload.StudentReq;
import com.example.schoolapplicationjpa.entity.model.Student;
import com.example.schoolapplicationjpa.service.StudentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RequestMapping("/student")
@RestController
@RequiredArgsConstructor
public class StudentController {

  private final StudentService studentService;

  @GetMapping("")
  public List<Student> getAllStudents() {
    return studentService.getAllStudents();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
    return studentService.getStudentById(id)
        .map(ResponseEntity::ok)
        .orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student ID is not found"));
  }

  @GetMapping("/lastName")
  public List<Student> getStudentByLastName(@RequestParam String lastName) {
    return studentService.getStudentByLastName(lastName);
  }

  @GetMapping("/firstName")
  public List<Student> getStudentByFirstName(@RequestParam String firstName) {
    return studentService.getStudentByFirstName(firstName);
  }

  @PostMapping("")
  public ResponseEntity<Student> createStudent(@RequestBody StudentReq studentReq) {
    Student student = studentService.createStudent(studentReq);
    if (student == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "something went wrong");
    }
    return ResponseEntity.status(HttpStatus.CREATED).body(student);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Student> updateStudent(@PathVariable Long id,
      @RequestBody Student student) {
    return studentService.updateStudent(id, student)
        .map(ResponseEntity::ok)
        .orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student ID is not found"));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteStudentById(@PathVariable Long id) {
    if (studentService.getStudentById(id).isEmpty()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
    }
    studentService.deleteStudentById(id);
    return ResponseEntity.ok().build();
  }
}
