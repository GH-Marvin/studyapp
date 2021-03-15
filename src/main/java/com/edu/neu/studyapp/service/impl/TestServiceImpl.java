package com.edu.neu.studyapp.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.edu.neu.studyapp.entity.Test;
import com.edu.neu.studyapp.mapper.TestMapper;
import com.edu.neu.studyapp.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper testMapper;


    @Override
    public List<Test> findAll() {
        return testMapper.selectList(null);
    }

    @Override
    public Test findById(Integer id) {
        return testMapper.selectOne(new QueryWrapper<Test>().eq("test_id",id));
    }

}
