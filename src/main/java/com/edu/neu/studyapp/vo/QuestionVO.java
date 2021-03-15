package com.edu.neu.studyapp.vo;

import lombok.Data;

@Data
public class QuestionVO {
    private Integer questId;
    private String title;
    private Integer score;
    private String type;
    private Integer testId;
}
