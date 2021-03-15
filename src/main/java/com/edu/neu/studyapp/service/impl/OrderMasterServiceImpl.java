package com.edu.neu.studyapp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.edu.neu.studyapp.entity.OrderMaster;
import com.edu.neu.studyapp.mapper.OrderMasterMapper;
import com.edu.neu.studyapp.service.OrderMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderMasterServiceImpl implements OrderMasterService {
    @Autowired
    private OrderMasterMapper orderMasterMapper;
    @Override
    public void insertOrderMaster(OrderMaster orderMaster) {
        orderMasterMapper.insert(orderMaster);
    }

    @Override
    public List<OrderMaster> findOrdersByUserId(Integer user_id) {
        return orderMasterMapper.selectList(new QueryWrapper<OrderMaster>().eq("user_id",user_id));
    }

    @Override
    public OrderMaster findOrdersById(String order_id) {
        return orderMasterMapper.selectOne(new QueryWrapper<OrderMaster>().eq("order_id",order_id));
    }
}
