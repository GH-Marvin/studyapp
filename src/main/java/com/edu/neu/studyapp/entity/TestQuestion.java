package com.edu.neu.studyapp.entity;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class TestQuestion {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Integer testId;
  private Integer questId;

}
