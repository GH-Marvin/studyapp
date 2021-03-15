package com.edu.neu.studyapp.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class User {


  private Integer userId;
  private String username;
  private String password;

}
