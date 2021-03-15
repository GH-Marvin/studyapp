package com.edu.neu.studyapp.service.impl;

import com.edu.neu.studyapp.entity.Course;
import com.edu.neu.studyapp.service.CourseService;
import com.edu.neu.studyapp.vo.CourseVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseServiceImplTest {

    @Autowired
    private CourseService courseService;
    @Test
    void findAll() {
        HashMap<String,List<Course>> map = courseService.findAllToMap();

        int i = 0;
    }
    @Test
    void findByType(){
        courseService.findByType("css");
        int i =0 ;
    }

}