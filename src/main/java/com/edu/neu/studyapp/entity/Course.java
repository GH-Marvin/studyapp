package com.edu.neu.studyapp.entity;


import lombok.Data;

@Data
public class Course {

    private Integer courseId;
    private String imgUrl;
    private String title;
    private String type;
    private String content;
    private Integer videoId;

}
