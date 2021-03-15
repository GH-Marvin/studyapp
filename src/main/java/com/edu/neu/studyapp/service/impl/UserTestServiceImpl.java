package com.edu.neu.studyapp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.edu.neu.studyapp.entity.UserTest;
import com.edu.neu.studyapp.mapper.UserTestMapper;
import com.edu.neu.studyapp.service.UserTestService;
import com.edu.neu.studyapp.vo.UserTestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTestServiceImpl implements UserTestService {
    @Autowired
    private UserTestMapper userTestMapper;
    @Override
    public UserTest findById(Integer user_id) {
        QueryWrapper<UserTest> queryWrapper = new QueryWrapper<>();
        return userTestMapper.selectOne(queryWrapper.eq("user_id",user_id));
    }

    @Override
    public void update(UserTest userTest) {
        UpdateWrapper<UserTest> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("user_id",userTest.getUserId()).set("pass_num",userTest.getPassNum()).set("fail_num",userTest.getFailNum()).set("notry_num",userTest.getNotryNum()).set("history",userTest.getHistory());
        userTestMapper.update(null,updateWrapper);
    }

    @Override
    public void insertUserTest(UserTest userTest) {
        userTestMapper.insert(userTest);
    }
}
