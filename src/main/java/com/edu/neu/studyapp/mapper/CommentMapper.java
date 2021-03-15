package com.edu.neu.studyapp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.edu.neu.studyapp.entity.UserComment;
import com.edu.neu.studyapp.vo.CommentVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CommentMapper extends BaseMapper<UserComment> {
    @Select("SELECT comment_id,user_icon,nickname,time,content,good_num,video_id\n" +
            "FROM user_comment NATURAL JOIN userinfo\n" +
            "WHERE userinfo.ui_id = user_comment.ui_id")
    public List<CommentVO> findAllCommentVO();
}
