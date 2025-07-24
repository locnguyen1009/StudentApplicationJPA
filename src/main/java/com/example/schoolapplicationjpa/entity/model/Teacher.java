package com.example.schoolapplicationjpa.entity.model;

import com.example.schoolapplicationjpa.entity.apiPayload.teacherPayload.TeacherDto;
import jakarta.persistence.*;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String dob;
    private List<String> skills = new ArrayList<>();

    public TeacherDto getTeacherDto(){
        TeacherDto teacherdto = new TeacherDto();
        teacherdto.setId(id);
        teacherdto.setFirstName(firstName);
        teacherdto.setLastName(lastName);
        teacherdto.setDob(dob);
        teacherdto.setSkills(skills);
        return teacherdto;
    }
}
