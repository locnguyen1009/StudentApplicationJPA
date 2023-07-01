package com.example.schoolapplicationjpa.repository;

import com.example.schoolapplicationjpa.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<Teacher, Long> {

}
