package com.example.schoolapplicationjpa.service;


import com.example.schoolapplicationjpa.entity.Course;
import com.example.schoolapplicationjpa.request.CourseReq;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CourseService {
    List<Course> getAllCourse();

    Optional<Course> getCourseById(Long courseId);

    Course addCourse(CourseReq courseReq);

    Optional<Course> updateCourse(Long courseId, Course course);

    void deleteCourse(Long courseId);
}
