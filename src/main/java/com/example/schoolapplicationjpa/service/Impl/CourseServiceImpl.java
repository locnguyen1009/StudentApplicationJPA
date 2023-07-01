package com.example.schoolapplicationjpa.service.Impl;

import com.example.schoolapplicationjpa.entity.Course;
import com.example.schoolapplicationjpa.repository.CourseRepo;
import com.example.schoolapplicationjpa.request.CourseReq;
import com.example.schoolapplicationjpa.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;

    @Override
    public List<Course> getAllCourse() {
        return courseRepo.findAll();
    }

    @Override
    public Optional<Course> getCourseById(Long courseId) {
        return courseRepo.findById(courseId);
    }

    @Override
    public Course addCourse(CourseReq courseReq) {
        Course course = new Course();
        course.setName(courseReq.getName());
        course.setDescription(courseReq.getDescription());
        course.setCredit(courseReq.getCredit());
        return courseRepo.save(course);
    }

    @Override
    public Optional<Course> updateCourse(Long courseId, Course course) {
        if(courseRepo.findById(courseId).isEmpty()){
            return Optional.empty();
        }
        course.setId(courseId);
        return Optional.of(courseRepo.save(course));
    }

    @Override
    public void deleteCourse(Long courseId) {
        courseRepo.deleteById(courseId);
    }


}
