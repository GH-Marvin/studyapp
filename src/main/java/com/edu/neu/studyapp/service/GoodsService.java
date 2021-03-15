package com.edu.neu.studyapp.service;

import com.edu.neu.studyapp.entity.Goods;

import java.util.List;

public interface GoodsService {
    public List<Goods> findAll();
    public List<Goods> findListByType(Integer type);
    public Goods findById(Integer id);
    public void update(Integer id, Integer num);
}
