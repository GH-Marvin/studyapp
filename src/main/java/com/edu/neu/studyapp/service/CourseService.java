package com.edu.neu.studyapp.service;

import com.edu.neu.studyapp.entity.Course;
import com.edu.neu.studyapp.vo.CourseVO;

import java.util.HashMap;
import java.util.List;

public interface CourseService {
    public List<Course> findAll();
    public List<Course> findByType(String type);
    public HashMap<String,List<Course>> findAllToMap();
}
