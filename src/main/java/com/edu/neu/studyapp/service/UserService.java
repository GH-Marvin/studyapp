package com.edu.neu.studyapp.service;



import com.edu.neu.studyapp.entity.User;

import java.util.List;


public interface UserService {
    public User findByUserName(String userName);
    public List<User> findAll();
    public void addUser(User user);
}
