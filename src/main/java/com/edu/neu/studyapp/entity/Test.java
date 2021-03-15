package com.edu.neu.studyapp.entity;

import javax.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
public class Test {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Integer testId;
  private String title;
  private String description;
  private Integer score;
  private String hard;
  private String limitTime;
  private Integer limitDegree;
  private String deadline;
  private Integer questNum;

}
