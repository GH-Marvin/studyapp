package com.edu.neu.studyapp.service;

import com.edu.neu.studyapp.entity.UserTest;
import com.edu.neu.studyapp.vo.UserTestVO;

public interface UserTestService {
    public UserTest findById(Integer user_id);
    public void update(UserTest userTest);
    public void insertUserTest(UserTest userTest);
}
