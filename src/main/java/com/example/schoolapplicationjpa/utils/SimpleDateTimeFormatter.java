package com.example.schoolapplicationjpa.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SimpleDateTimeFormatter {

  public static String dateFormatter(LocalDate date) {
    return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
  }

}
