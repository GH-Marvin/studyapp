package com.edu.neu.studyapp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.edu.neu.studyapp.entity.Video;
import com.edu.neu.studyapp.mapper.VideoMapper;
import com.edu.neu.studyapp.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoMapper videoMapper;
    @Override
    public Video findById(Integer id) {
        QueryWrapper<Video> queryWrapper = new QueryWrapper<>();
        return videoMapper.selectOne(queryWrapper.eq("video_id",id));
    }
}
