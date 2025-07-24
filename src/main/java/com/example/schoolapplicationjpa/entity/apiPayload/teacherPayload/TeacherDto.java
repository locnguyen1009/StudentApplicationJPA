package com.example.schoolapplicationjpa.entity.apiPayload.teacherPayload;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class TeacherDto {
  private Long id;
  private String firstName;
  private String lastName;
  private String dob;
  private List<String> skills = new ArrayList<>();
}
