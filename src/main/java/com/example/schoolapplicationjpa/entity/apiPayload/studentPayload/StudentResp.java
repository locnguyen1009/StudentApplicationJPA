package com.example.schoolapplicationjpa.entity.apiPayload.studentPayload;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentResp {

  private Long id;
  private String firstName;
  private String lastName;
  private String dob;
  private double grade;

}
