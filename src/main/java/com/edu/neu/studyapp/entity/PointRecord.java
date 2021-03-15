package com.edu.neu.studyapp.entity;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class PointRecord {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Integer prId;
  private Integer userId;
  private String createTime;
  private String eventName;
  private Integer gainPoint;

}
