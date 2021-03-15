package com.edu.neu.studyapp.service;

import com.edu.neu.studyapp.entity.UserComment;
import com.edu.neu.studyapp.vo.CommentVO;

import java.util.List;

public interface CommentService {
    public List<CommentVO> findAllComments(Integer video_id);
    public void insertComment(UserComment userComment);
}
