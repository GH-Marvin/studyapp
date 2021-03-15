package com.edu.neu.studyapp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.edu.neu.studyapp.entity.Course;
import com.edu.neu.studyapp.vo.CourseVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CourseMapper extends BaseMapper<Course> {
    @Select("SELECT course.type\n" +
            "FROM course\n" +
            "GROUP BY course.type")
    public List<String> findAllType();

}
