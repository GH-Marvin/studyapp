package com.edu.neu.studyapp.service;

import com.edu.neu.studyapp.entity.PointRecord;

import java.util.List;

public interface PointRecordService {
    public void insert(PointRecord pointRecord);
    public List<PointRecord> findByUserId(Integer user_id);
}
