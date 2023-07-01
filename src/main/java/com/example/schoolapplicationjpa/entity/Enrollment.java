package com.example.schoolapplicationjpa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_enrollment")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long courseId;
    private Long teacherId;
    private Integer maxCapacity;
    private Set<Long> studentIds = new HashSet<>();

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date enrollDeadline;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date begin;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date end;

}
