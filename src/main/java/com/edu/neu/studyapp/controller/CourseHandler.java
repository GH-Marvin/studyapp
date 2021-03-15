package com.edu.neu.studyapp.controller;

import com.edu.neu.studyapp.entity.Choice;
import com.edu.neu.studyapp.entity.Course;
import com.edu.neu.studyapp.entity.UserComment;
import com.edu.neu.studyapp.entity.Video;
import com.edu.neu.studyapp.service.CommentService;
import com.edu.neu.studyapp.service.CourseService;
import com.edu.neu.studyapp.service.UserInfoService;
import com.edu.neu.studyapp.service.VideoService;
import com.edu.neu.studyapp.vo.CommentVO;
import com.edu.neu.studyapp.vo.CourseVO;
import com.edu.neu.studyapp.vo.UserCommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseHandler {
    @Autowired
    private CourseService courseService;
    @Autowired
    private VideoService videoService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/{url}")
    public String redirect(@PathVariable("url") String url) {
        return url;
    }

    @GetMapping("/findAll")
    public List<Course> findAll(){
        return  courseService.findAll();
    }


    @GetMapping("/findAllTOMap")
    public HashMap<String,List<Course>> findAllToMap(){
        return courseService.findAllToMap();
    }

    @GetMapping("/findVideoById/{video_id}")
    @ResponseBody
    public Video findVideosById(@PathVariable("video_id") String video_id){
        return videoService.findById(Integer.valueOf(video_id));
    }

    @GetMapping("/findCommentsById/{video_id}")
    @ResponseBody
    public List<CommentVO> findCommentsById(@PathVariable("video_id") String video_id){
        return commentService.findAllComments(Integer.valueOf(video_id));
    }
    @PostMapping("/insertComment")
    @ResponseBody
    public List<CommentVO> insertComment(@RequestBody UserCommentVO userCommentVO){
        UserComment userComment = new UserComment();
        userComment.setContent(userCommentVO.getComment());
        userComment.setGoodNum(0);
        userComment.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date().getTime()));
        userComment.setUiId(userInfoService.findByUserId(Integer.valueOf(userCommentVO.getUser_id())).getUiId());
        userComment.setVideoId(Integer.valueOf(userCommentVO.getVideo_id()));
        commentService.insertComment(userComment);
        return commentService.findAllComments(Integer.valueOf(userCommentVO.getVideo_id()));
    }
}
