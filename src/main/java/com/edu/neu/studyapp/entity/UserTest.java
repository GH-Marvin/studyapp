package com.edu.neu.studyapp.entity;

import javax.persistence.*;
import lombok.Data;

@Data
public class UserTest {

  private Integer utId;
  private Integer userId;
  private Integer passNum;
  private Integer failNum;
  private Integer notryNum;
  private Integer history;

}
