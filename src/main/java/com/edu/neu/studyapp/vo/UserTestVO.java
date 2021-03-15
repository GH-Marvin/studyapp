package com.edu.neu.studyapp.vo;

import com.edu.neu.studyapp.entity.Test;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserTestVO {
    private Integer utId;
    private Integer userId;
    private Integer passNum;
    private Integer failNum;
    private Integer notryNum;
    private Test test;
}
