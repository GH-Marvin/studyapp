package com.edu.neu.studyapp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.edu.neu.studyapp.entity.Goods;
import com.edu.neu.studyapp.entity.Userinfo;
import com.edu.neu.studyapp.mapper.GoodsMapper;
import com.edu.neu.studyapp.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public List<Goods> findAll() {
        return goodsMapper.selectList(null);
    }

    @Override
    public List<Goods> findListByType(Integer type) {
        return goodsMapper.selectList(new QueryWrapper<Goods>().eq("goods_type",type));
    }

    @Override
    public Goods findById(Integer id) {
        return goodsMapper.selectOne(new QueryWrapper<Goods>().eq("goods_id",id));
    }

    @Override
    public void update(Integer id, Integer num) {
        UpdateWrapper<Goods> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("goods_id",id).set("goods_stock",num);
        goodsMapper.update(null,updateWrapper);
    }
}
