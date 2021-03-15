package com.edu.neu.studyapp.entity;

import javax.persistence.*;
import lombok.Data;


@Data
public class AnswerForm {


  private String formId;
  private String saveTime;
  private Integer testId;
  private String answersheet;
  private Integer score;
  private Integer userId;
  private String answersheetResult;

}
