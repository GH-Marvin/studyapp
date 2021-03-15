package com.edu.neu.studyapp.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
public class Userinfo {

  private Integer uiId;
  private Integer userId;
  private String nickname;
  private String realname;
  private String sex;
  private Integer age;
  private Date birthday;
  private String identity;
  private String address;
  private String userIcon;
  private String phone;
  private Integer point;

}
