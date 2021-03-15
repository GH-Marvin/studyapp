package com.edu.neu.studyapp.service;

import com.edu.neu.studyapp.entity.Userinfo;
import com.edu.neu.studyapp.vo.UserInfoVO;

public interface UserInfoService {
    public Userinfo findByUserId(Integer id);
    public void addUserInfo(Userinfo userinfo);
    public Userinfo findByNickName(String nickName);
    public Userinfo update(UserInfoVO userInfoVO);
}
