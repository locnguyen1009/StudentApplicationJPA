package com.example.schoolapplicationjpa.entity.apiPayload.enrollmentPayload;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EnrollmentReq {

  private Long courseId;
  private Long teacherId;
  private Integer maxCapacity;
  private Set<Long> studentIds = new HashSet<>();

  //    @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate enrollDeadline;

  //    @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate startCourse;

  //    @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate endOfCourse;


}
