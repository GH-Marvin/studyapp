package com.edu.neu.studyapp.service.impl;

import com.edu.neu.studyapp.service.UserInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserInfoServiceImplTest {
    @Autowired
    private UserInfoService userInfoService;
    @Test
    void findByUserId() {
        userInfoService.findByUserId(1);
        int i = 0;
    }
}