package com.edu.neu.studyapp.vo;

import lombok.Data;

@Data
public class CourseVO {
    private Integer courseId;
    private String imgUrl;
    private String title;
    private String type;
    private String content;
    private String url;
}
