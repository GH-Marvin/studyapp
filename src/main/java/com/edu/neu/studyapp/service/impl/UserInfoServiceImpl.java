package com.edu.neu.studyapp.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.edu.neu.studyapp.entity.UserTest;
import com.edu.neu.studyapp.entity.Userinfo;
import com.edu.neu.studyapp.mapper.UserInfoMapper;
import com.edu.neu.studyapp.service.UserInfoService;
import com.edu.neu.studyapp.vo.UserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public Userinfo findByUserId(Integer id) {
        QueryWrapper<Userinfo> queryWrapper = new QueryWrapper();
        return userInfoMapper.selectOne(queryWrapper.eq("user_id",id));
    }

    @Override
    public void addUserInfo(Userinfo userinfo) {
        userInfoMapper.insert(userinfo);
    }

    @Override
    public Userinfo findByNickName(String nickName) {
        QueryWrapper<Userinfo> queryWrapper = new QueryWrapper();
        return userInfoMapper.selectOne(queryWrapper.eq("nickname",nickName));
    }

    @Override
    public Userinfo update(UserInfoVO userInfoVO) {
        UpdateWrapper<Userinfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("user_id",Integer.valueOf(userInfoVO.getUser_id())).set(userInfoVO.getCol(),userInfoVO.getInput());
        userInfoMapper.update(null,updateWrapper);
        return findByUserId(Integer.valueOf(userInfoVO.getUser_id()));
    }
}
