package com.example.schoolapplicationjpa.entity.apiPayload.teacherPayload;

import com.example.schoolapplicationjpa.entity.model.Course;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherReq {
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private List<Course> skill = new ArrayList<>();
}
