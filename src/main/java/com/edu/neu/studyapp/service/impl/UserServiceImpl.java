package com.edu.neu.studyapp.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.edu.neu.studyapp.entity.User;
import com.edu.neu.studyapp.mapper.UserMapper;
import com.edu.neu.studyapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUserName(String name) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("username", name);
        return userMapper.selectOne(wrapper);
    }

    @Override
    public List<User> findAll() {
        return userMapper.selectList(null);
    }

    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }

}
