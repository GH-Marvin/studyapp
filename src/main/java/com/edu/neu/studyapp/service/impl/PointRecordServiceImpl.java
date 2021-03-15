package com.edu.neu.studyapp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.edu.neu.studyapp.entity.PointRecord;
import com.edu.neu.studyapp.mapper.PointRecordMapper;
import com.edu.neu.studyapp.service.PointRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointRecordServiceImpl implements PointRecordService {
    @Autowired
    private PointRecordMapper pointRecordMapper;
    @Override
    public void insert(PointRecord pointRecord) {
        pointRecordMapper.insert(pointRecord);
    }

    @Override
    public List<PointRecord> findByUserId(Integer user_id) {
        return pointRecordMapper.selectList(new QueryWrapper<PointRecord>().eq("user_id",user_id));
    }
}
