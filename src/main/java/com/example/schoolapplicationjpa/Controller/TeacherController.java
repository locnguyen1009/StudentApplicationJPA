package com.example.schoolapplicationjpa.Controller;

import com.example.schoolapplicationjpa.entity.Teacher;
import com.example.schoolapplicationjpa.entity.request.TeacherReq;
import com.example.schoolapplicationjpa.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("")
    public List<Teacher> getAllTeacher() {
        return teacherService.getAllTeacher();
    }

    @GetMapping("/{teacherId}")
    public ResponseEntity<Teacher> getTeacherById (@PathVariable long teacherId){
        Optional<Teacher> teacher = teacherService.getTeacherById(teacherId);
        return teacher
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Teacher not Found"));
    }

    @PostMapping("")
    public Teacher addTeacher (@RequestBody TeacherReq teacherReq){
        return teacherService.addTeacher(teacherReq);
    }

    @PutMapping("/{teacherId}")
    public ResponseEntity<Teacher> updateTeacher (@PathVariable long teacherId, @RequestBody Teacher teacher) {
        Optional<Teacher> updatedTeacher = teacherService.updateTeacher(teacherId, teacher);
        return updatedTeacher
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Teacher not found"));
    }

    @DeleteMapping("/{teacherId}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable long teacherId) {
        if (teacherService.getTeacherById(teacherId).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Teacher not found");
        }
        teacherService.deleteTeacher(teacherId);
        return ResponseEntity.ok().build();
    }
}
