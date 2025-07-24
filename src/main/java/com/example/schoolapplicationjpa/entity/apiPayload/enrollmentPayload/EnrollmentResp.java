package com.example.schoolapplicationjpa.entity.apiPayload.enrollmentPayload;

import com.example.schoolapplicationjpa.entity.model.Course;
import com.example.schoolapplicationjpa.entity.model.Student;
import com.example.schoolapplicationjpa.entity.model.Teacher;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentResp {

    private Long id;

    private Course course;
    private Teacher teacher;
    private Integer maxCapacity;
    private List<Student> students;

    private String enrollDeadline;

    private String begin;

    private String end;
}
