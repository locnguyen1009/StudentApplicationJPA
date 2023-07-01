package com.example.schoolapplicationjpa.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentReq {
    private String firstName;
    private String lastName;
    private double grade;
}
