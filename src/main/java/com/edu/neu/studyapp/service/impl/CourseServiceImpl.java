package com.edu.neu.studyapp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.edu.neu.studyapp.entity.Course;
import com.edu.neu.studyapp.mapper.CourseMapper;
import com.edu.neu.studyapp.service.CourseService;
import com.edu.neu.studyapp.vo.CourseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;


    @Override
    public List<Course> findAll() {
        return courseMapper.selectList(null);
    }

    @Override
    public List<Course> findByType(String type) {
        QueryWrapper<Course> queryWrapper = new QueryWrapper();
        return courseMapper.selectList(queryWrapper.eq("type",type));
    }

    @Override
    public HashMap<String,List<Course>> findAllToMap() {

        List<String> types = courseMapper.findAllType();
        HashMap<String,List<Course>> map = new HashMap<>();
        for(String s : types){
            QueryWrapper<Course> queryWrapper = new QueryWrapper();
            List<Course> courses = courseMapper.selectList(queryWrapper.eq("type",s));
            map.put(s,courses);
        }
        return map;
    }

}
