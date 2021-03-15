package com.edu.neu.studyapp.service.impl;

import com.edu.neu.studyapp.entity.UserComment;
import com.edu.neu.studyapp.mapper.CommentMapper;
import com.edu.neu.studyapp.service.CommentService;
import com.edu.neu.studyapp.vo.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public List<CommentVO> findAllComments(Integer video_id) {
        List<CommentVO> list = commentMapper.findAllCommentVO();
        List<CommentVO> commentVOList = new ArrayList<>();
        for(CommentVO commentVO: list){
            if(commentVO.getVideoId()==video_id){
                commentVOList.add(commentVO);
            }
        }
        return commentVOList;
    }

    @Override
    public void insertComment(UserComment userComment) {
        commentMapper.insert(userComment);
    }
}
