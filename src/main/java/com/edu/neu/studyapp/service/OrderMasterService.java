package com.edu.neu.studyapp.service;

import com.edu.neu.studyapp.entity.OrderMaster;

import java.util.List;

public interface OrderMasterService {
    public void insertOrderMaster(OrderMaster orderMaster);
    public List<OrderMaster> findOrdersByUserId(Integer user_id);
    public OrderMaster findOrdersById(String order_id);
}
