package com.edu.neu.studyapp.vo;

import lombok.Data;

@Data
public class AnswerSheetResultVO {
    private Integer score;
    private String answersheetResult;
    private Integer passNum;
    private Integer failNum;
}
