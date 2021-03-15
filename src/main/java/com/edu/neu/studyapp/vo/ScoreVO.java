package com.edu.neu.studyapp.vo;

import com.edu.neu.studyapp.entity.Question;
import lombok.Data;

import java.util.List;

@Data
public class ScoreVO {
    private Integer test_id;
    private String test_name;
    private Integer user_id;
    private List<Question> checkedList;
    private List<Question> failList;
    private Integer score;
    private String time;
    private Integer total_score;

}
