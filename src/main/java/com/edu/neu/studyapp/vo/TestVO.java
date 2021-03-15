package com.edu.neu.studyapp.vo;

import com.edu.neu.studyapp.entity.Question;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TestVO {
    private Integer testId;
    private String title;
    private String description;
    private Integer score;
    private String hard;
    private String limitTime;
    private Integer limitDegree;
    private Date deadline;
    private Integer questNum;
    private List<Question> questionList;

}
