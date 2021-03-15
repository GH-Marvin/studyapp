package com.edu.neu.studyapp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.edu.neu.studyapp.entity.AnswerForm;
import com.edu.neu.studyapp.mapper.AnswerFormMapper;
import com.edu.neu.studyapp.service.AnswerFormService;
import com.edu.neu.studyapp.vo.AnswerFormVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerFormServiceImpl implements AnswerFormService {
    @Autowired
    private AnswerFormMapper answerFormMapper;
    @Override
    public AnswerForm findById(Integer id) {
        QueryWrapper<AnswerForm> queryWrapper = new QueryWrapper<>();
        return answerFormMapper.selectOne(queryWrapper.eq("form_id",id));
    }

    @Override
    public void addAnswerForm(AnswerForm answerForm) {
        answerFormMapper.insert(answerForm);
    }

    @Override
    public List<AnswerForm> findByUserIdTestId(Integer user_id, Integer test_id) {
        QueryWrapper<AnswerForm> queryWrapper = new QueryWrapper<>();
        return answerFormMapper.selectList(queryWrapper.eq("user_id",user_id).eq("test_id",test_id));
    }
}
