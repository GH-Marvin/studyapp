package com.edu.neu.studyapp.vo;


import lombok.Data;

@Data
public class UserCommentVO {
    private String user_id;
    private String video_id;
    private String comment;
}
