package com.edu.neu.studyapp.service;

import com.edu.neu.studyapp.entity.Test;

import java.util.List;

public interface TestService {
    public List<Test> findAll();
    public Test findById(Integer id);
}
