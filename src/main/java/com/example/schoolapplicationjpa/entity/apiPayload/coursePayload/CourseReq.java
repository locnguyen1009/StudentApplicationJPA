package com.example.schoolapplicationjpa.entity.apiPayload.coursePayload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseReq {
    private String name;
    private String description;
    private int credit;

}
