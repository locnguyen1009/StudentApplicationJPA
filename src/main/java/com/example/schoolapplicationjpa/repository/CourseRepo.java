package com.example.schoolapplicationjpa.repository;

import com.example.schoolapplicationjpa.entity.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource

public interface CourseRepo extends JpaRepository<Course, Long> {

}
