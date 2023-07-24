package com.example.schoolapplicationjpa.repository;

import com.example.schoolapplicationjpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Long> {

}
