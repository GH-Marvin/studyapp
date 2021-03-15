package com.edu.neu.studyapp.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Question {

  private Integer questId;
  private String title;
  private Integer score;
  private String type;

}
