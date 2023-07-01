package com.example.schoolapplicationjpa.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseReq {
    private String name;
    private String description;
    private int credit;
}
