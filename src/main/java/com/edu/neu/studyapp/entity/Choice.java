package com.edu.neu.studyapp.entity;

import javax.persistence.*;
import lombok.Data;

@Data

public class Choice {

  private Integer optId;
  private String name;
  private Integer questId;
  private Integer isAnswer;
  private String optType;

}
