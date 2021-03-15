package com.edu.neu.studyapp.entity;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class UserComment {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Integer commentId;
  private Integer uiId;
  private String time;
  private String content;
  private Integer goodNum;
  private Integer videoId;

}
