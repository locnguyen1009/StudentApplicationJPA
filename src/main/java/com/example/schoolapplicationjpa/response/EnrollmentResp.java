package com.example.schoolapplicationjpa.response;

import com.example.schoolapplicationjpa.entity.Course;
import com.example.schoolapplicationjpa.entity.Student;
import com.example.schoolapplicationjpa.entity.Teacher;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
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
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date enrollDeadline;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date begin;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date end;
}
