package com.example.schoolapplicationjpa.Controller;

import com.example.schoolapplicationjpa.entity.Course;
import com.example.schoolapplicationjpa.entity.request.CourseReq;
import com.example.schoolapplicationjpa.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @GetMapping("")
    public List<Course> getAllCourse() {
        return courseService.getAllCourse();
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<Course> getCourseById (@PathVariable Long courseId){
        Optional<Course> course = courseService.getCourseById(courseId);
        return course
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not Found"));
    }

    @PostMapping("")
    public Course addCourse (@RequestBody CourseReq courseReq){
        return courseService.addCourse(courseReq);
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<Course> updateCourse (@PathVariable Long courseId, @RequestBody Course course) {
        Optional<Course> updatedCourse= courseService.updateCourse(courseId, course);
        return updatedCourse
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found"));
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long courseId) {
        if(courseService.getCourseById(courseId).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found");
        }
        courseService.deleteCourse(courseId);
        return ResponseEntity.ok().build();

    }
}
