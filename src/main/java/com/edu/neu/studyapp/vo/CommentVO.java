package com.edu.neu.studyapp.vo;

import lombok.Data;

@Data
public class CommentVO {
    private Integer commentId;
    private String userIcon;
    private String nickname;
    private String time;
    private String content;
    private Integer goodNum;
    private Integer videoId;
}
